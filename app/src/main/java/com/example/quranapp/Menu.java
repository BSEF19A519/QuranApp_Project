package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        QDH qdh=new QDH();
        Intent intent=getIntent();
        String index=intent.getStringExtra("index");

        if(index.equals("Surah"))
        {
            ListView listView = findViewById(R.id.menulist);
            List<String> list = qdh.GetAllSurahNames();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(Menu.this, SurahList.class);
                    Log.d("test", "you click in menu : " + i);
                    intent.putExtra("position", i);
                    startActivity(intent);
                }});}
//        else if(index.equals("Parah"))
//                {
//                    ListView listView = findViewById(R.id.menulist);
//                    List<String> list = qdh.GetAllParahNames();
//                    ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
//                    listView.setAdapter(arrayAdapter);
//                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent = new Intent(getApplicationContext(), ParahList.class);
//                            Log.d("test", "you click : " + i);
//                            intent.putExtra("position", i);
//                            startActivity(intent);
//                        }
//                });}
    }
}