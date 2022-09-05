package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSurah, btnParah;
        btnSurah=findViewById(R.id.bySurah);
        btnParah=findViewById(R.id.byParah);
        btnSurah.setBackgroundColor(R.color.background);
        btnParah.setBackgroundColor(R.color.background);
        SearchView searchView;
        ListView list,droplist;
        searchView = (SearchView) findViewById(R.id.searchView);
//        droplist = (ListView) findViewById(R.id.lv1);

        QDH qdh=new QDH();
        List<String> surahnames = qdh.GetEnglishSurahNames();
//        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,surahnames);
//        droplist.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                int q =Integer.parseInt(query);
//                if(surahnames.contains(query))
                if(q<=114&&q>=1)
                {
//                    adapter.getFilter().filter(query);

//                     int q=surahnames.indexOf(query);
                     Log.d("q1", String.valueOf(q));
                     DBHelper dbHelper=new DBHelper(MainActivity.this);
//                     ArrayList<QuranModel> SearchList = dbHelper.Search(q+1);
                    myRecyclerViewAdapter2 adapterview;
                    RecyclerView.LayoutManager layoutManager;

                    ArrayList<QuranModel> SearchList = dbHelper.Search(q);
                    RecyclerView recycler = findViewById(R.id.lv2);
                    layoutManager = new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.VERTICAL,
                            false);
                    recycler.setLayoutManager(layoutManager);

                    adapterview = new myRecyclerViewAdapter2(SearchList) ;
                    recycler.setAdapter(adapterview);




                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });


        btnSurah.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra("index","Surah");
                startActivity(intent);
                    }
                });

        btnParah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.putExtra("index","Parah");
                startActivity(intent);

        }});









    }
}