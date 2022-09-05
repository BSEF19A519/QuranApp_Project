package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurahList extends AppCompatActivity implements OnItemClickListener {
    List<TRanslation> tlist = new ArrayList<>();
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surahlayout);

        QDH qdh=new QDH();
        TRanslation t1=new TRanslation("English : "+qdh.getenglishTranslation(0),"Urdu : "+qdh.geturduTranslation(0));
        TRanslation t2=new TRanslation("English : "+qdh.getenglishTranslation(0),"Urdu : "+qdh.geturduTranslation(1));
        TRanslation t3=new TRanslation("English : "+qdh.getenglishTranslation(1),"Urdu : "+qdh.geturduTranslation(0));
        TRanslation t4=new TRanslation("English : "+qdh.getenglishTranslation(1),"Urdu : "+qdh.geturduTranslation(1));
        tlist.addAll(Arrays.asList(new TRanslation[]{t1,t2,t3,t4}));
        recyclerView = findViewById(R.id.translayout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new MyRecyclerViewAdapter(tlist,R.layout.translationcustomizedview,this);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);




        DBHelper db=new DBHelper(SurahList.this,0);
        myRecyclerViewAdapter2 adapterview;
        RecyclerView.LayoutManager layoutManager;
        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);
        ArrayList<QuranModel> arabic = db.GetAllBySurah(i);
        RecyclerView recycler = findViewById(R.id.surahdisplay);

        layoutManager = new LinearLayoutManager(SurahList.this,
                LinearLayoutManager.VERTICAL,
                false);
        recycler.setLayoutManager(layoutManager);

        adapterview = new myRecyclerViewAdapter2(arabic) ;
        recycler.setAdapter(adapterview);





    }

    @Override
    public void onClick(View view, int position) {
        Log.d("onclick", "onClick: "+position);
        Toast.makeText(SurahList.this,"You clicked"+position,Toast.LENGTH_LONG);
        final TRanslation trans=tlist.get(position);
        DBHelper db=new DBHelper(SurahList.this,position);
        myRecyclerViewAdapter2 adapterview;
        RecyclerView.LayoutManager layoutManager;
        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);
        ArrayList<QuranModel> arabic = db.GetAllBySurah(i);

        RecyclerView recycler = findViewById(R.id.surahdisplay);

        layoutManager = new LinearLayoutManager(SurahList.this,
                LinearLayoutManager.VERTICAL,
                false);
        recycler.setLayoutManager(layoutManager);

        adapterview = new myRecyclerViewAdapter2(arabic) ;
        recycler.setAdapter(adapterview);






    }
}