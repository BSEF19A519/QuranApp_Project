package com.example.quranapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Qurandb";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public static final String AYATID = "AyaID";
    public static final String SURAHID = "SuraID";
    public static final String AYANO = "AyaNo";
    public static final String ARABIC_TEXT = "ArabicText";
    public static final String AYATNO = "AyaNo";
    public static final String FATEHMUHAMMADJALANDHRI = "FatehMuhammadJalandhri";
    public static final String MEHMOODULHASSAN = "MehmoodulHassan";
    public static final String DRMOHSINKHAN = "DrMohsinKhan";
    public static final String MUFTITAQIUSMANI = "MuftiTaqiUsmani";
    public static final String RUKUID = "RakuID";
    public static final String PRUKUID = "PRakuID";
    public static final String PARAID = "ParaID";
    public static final String TAYAH_TABLE = "tayah";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//       String query="CREATE TABLE "+TAYAH_TABLE+" ( "+ AYATID+" INTEGER, "
//               +SURAHID+" INTEGER, "+AYANO+" INTEGER, "+ ARABIC_TEXT+" TEXT, "
//               +FATEHMUHAMMADJALANDHRI +" TEXT, "+MEHMOODULHASSAN+" TEXT, "+
//               DRMOHSINKHAN +" TEXT, "+ MUFTITAQIUSMANI+"TEXT, "+RUKUID+" INTEGER, "+
//               PRUKUID+ " INTEGER, "+ PARAID+" INTEGER ) ";
//        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<String> getUrduTranslation(int st,int end) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT "+FATEHMUHAMMADJALANDHRI+" FROM " + TAYAH_TABLE+" WHERE "+AYATID+" BETWEEN "+st+" AND "+end, null);
        List<String> list = new LinkedList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                list.add(cursorCourses.getString(0));
            } while (cursorCourses.moveToNext()&&st<=end);
        }
        cursorCourses.close();
        return list;
    }


    public List<String> getEnglishTranslation(int st,int end) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT "+DRMOHSINKHAN+" FROM " + TAYAH_TABLE+" WHERE "+AYATID+" BETWEEN "+st+" AND "+end, null);
        List<String> list = new LinkedList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                list.add(cursorCourses.getString(0));
            } while (cursorCourses.moveToNext()&&st<=end);
        }
        cursorCourses.close();
        return list;
    }
    public List<String> getArabic(int st,int end) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT "+ARABIC_TEXT+" FROM " + TAYAH_TABLE+" WHERE "+AYATID+" BETWEEN "+st+" AND "+end, null);
        List<String> list = new LinkedList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                list.add(cursorCourses.getString(0));
            } while (cursorCourses.moveToNext()&&st<=end);
        }
        cursorCourses.close();
        return list;
    }
    public ArrayList<QuranModel> GetAllBySurah(int i)
    {
        QDH qdh=new QDH();
        int end;
        int start=qdh.getSurahStart(i);
        if(i==113)
        {
            end=6347;
        }
        else
        {
            end=qdh.getSurahStart(i+1);
        }
        QuranArabicText quranArabicText=new QuranArabicText();
//        List<String> ayats=getArabic(start-1,end-1);
        List<String> ayats=quranArabicText.GetSurahAyats(start-1,end);
        List<String> urduTranslation=getUrduTranslation(start-1,end-1);
        List<String> englishTranslation=getEnglishTranslation(start-1,end-1);
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();
        int j=0;
        for (int index=start;index<end;index++)
            {
                if(index==start)
                {
                    quranArrayList.add(new QuranModel("بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ","شروع اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے [۱]","In the Name of Allah, the Most Beneficent, the Most Merciful. "));
                }
                else
                {
                    quranArrayList.add(new QuranModel(ayats.get(j),urduTranslation.get(j),englishTranslation.get(j) ));
                }
                j++;
            }
        return quranArrayList;
    }


    public ArrayList<QuranModel> GetAllByParah(int i)
    {
        QDH qdh=new QDH();
        int end;
        int start=qdh.getParahStart(i);
        if(i==29)
        {
            end=6347;
        }
        else
        {
            end=qdh.getParahStart(i+1);
        }
        QuranArabicText quranArabicText=new QuranArabicText();
//        List<String> ayats=getArabic(start-1,end-1);
        List<String> ayats=quranArabicText.GetSurahAyats(start-1,end);
        List<String> urduTranslation=getUrduTranslation(start-1,end-1);
        List<String> englishTranslation=getEnglishTranslation(start-1,end-1);
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();
        int j=0;
        for (int index=start;index<end;index++)
        {
            if(index==start)
            {
                quranArrayList.add(new QuranModel("بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ","شروع اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے [۱]","In the Name of Allah, the Most Beneficent, the Most Merciful. "));
            }
            else
            {
                quranArrayList.add(new QuranModel(ayats.get(j),urduTranslation.get(j),englishTranslation.get(j) ));
            }
            j++;
        }
        return quranArrayList;
    }
}
