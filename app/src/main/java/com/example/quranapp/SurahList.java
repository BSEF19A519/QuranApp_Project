package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SurahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surahlayout);

        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);
        Log.d("test", "you click in surahList : " + i);
        DBHelper dbHelper=new DBHelper(SurahList.this);
        ArrayList<QuranModel> arabic = dbHelper.GetAllBySurah(i);
        MyAdapter adapter = new MyAdapter(SurahList.this, arabic);
        ListView listView = findViewById(R.id.surahdisplay);
        listView.setAdapter(adapter);



    }
}