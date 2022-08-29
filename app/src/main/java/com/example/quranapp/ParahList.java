package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ParahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parahlayout);
        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);
        DBHelper dbHelper=new DBHelper(getApplicationContext());
        ArrayList<QuranModel> arabic = dbHelper.GetAllByParah(i);
        MyAdapter adapter = new MyAdapter(ParahList.this, arabic);
        ListView listView = findViewById(R.id.parahList);
        listView.setAdapter(adapter);
    }
}