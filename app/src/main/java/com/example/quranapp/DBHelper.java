package com.example.quranapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public ArrayList<QuranModel> GetAllBySurah(int i)
    {
        QDH qdh=new QDH();
        int start=qdh.getSurahStart(i);
        int end=qdh.getSurahStart(i+1);
//        int start=qdh.SSP[i];
//        int end=qdh.SSP[i+1];
        QuranArabicText quranArabicText=new QuranArabicText();
        List<String> ayats=quranArabicText.GetSurahAyats(start-1,end-1);
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();
        int j=0;
        Log.d("db", "GetAllBySurah: "+j);
        do{
            quranArrayList.add(new QuranModel(ayats.get(j),"","" ));
            Log.d("db in", "GetAllBySurah: "+j);
            j++;
        }while(j<end-1);

        return quranArrayList;
    }
    public ArrayList<QuranModel> GetAllByParah(int i)
    {
        QDH qdh=new QDH();
        int start=qdh.getParahStart(i);
        int end=qdh.getParahStart(i+1);
//        int start=qdh.PSP[i];
//        int end=qdh.PSP[i+1];
        QuranArabicText quranArabicText=new QuranArabicText();
        List<String> ayats=quranArabicText.GetSurahAyats(start,end-1);
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();
        do{
            quranArrayList.add(new QuranModel(ayats.get(i),"","" ));
            i++;
        }while(i<end-1);

        return quranArrayList;
    }
}
