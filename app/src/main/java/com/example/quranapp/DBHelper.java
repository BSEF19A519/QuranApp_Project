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
     int k;
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public DBHelper(@Nullable Context context,int rindex) {
        super(context, DATABASE_NAME, null, 1);
        k=rindex;
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



    public List<String> getUrduTranslation(int i,String check) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("i", String.valueOf(i));
        Cursor cursorCourses = null;
        if(check.equals("s"))
        {
            Log.d("in function", String.valueOf(k));
            if(k==0||k==2)
            {
                cursorCourses = db.rawQuery("SELECT "+FATEHMUHAMMADJALANDHRI+" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+i, null);
            }
            else if(k==1||k==3)
            {
                cursorCourses = db.rawQuery("SELECT "+MEHMOODULHASSAN+" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+i, null);
            }

        }
        else
        {
            if(i==1)
            {
                if(k==0||k==2)
                {
                    cursorCourses = db.rawQuery("SELECT "+FATEHMUHAMMADJALANDHRI+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+" BETWEEN 0 AND 1", null);
                }
                else if(k==1||k==3)
                {
                    cursorCourses = db.rawQuery("SELECT "+MEHMOODULHASSAN+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+" BETWEEN 0 AND 1", null);
                }

            }
            else
            {
                if(k==0||k==2)
                {
                    cursorCourses = db.rawQuery("SELECT "+FATEHMUHAMMADJALANDHRI+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+"="+i, null);
                }
                else if(k==1||k==3)
                {
                    cursorCourses = db.rawQuery("SELECT "+MEHMOODULHASSAN+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+"="+i, null);
                }

            }

        }

        List<String> list = new LinkedList<>();

        Log.d("nocolumns", String.valueOf(cursorCourses.getCount()));
        int j=1;
        if (cursorCourses.moveToFirst()) {
            do {
                Log.d("urdu", cursorCourses.getString(0));
                list.add(cursorCourses.getString(0));
                j++;
            }
            while (cursorCourses.moveToNext());
            Log.d("count of added items", String.valueOf(j));

        }
        cursorCourses.close();
        return list;
    }


    public List<String> getEnglishTranslation(int i,String check) {
        SQLiteDatabase db = this.getReadableDatabase();
//        Log.d("i", String.valueOf(i));
        Cursor cursorCourses=null;
        if(check.equals("s"))
        {
            if(k==0||k==1)
            {
                cursorCourses = db.rawQuery("SELECT "+DRMOHSINKHAN+" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+i, null);
            }
            else if(k==2||k==3)
            {
                cursorCourses = db.rawQuery("SELECT "+MUFTITAQIUSMANI+" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+i, null);
            }


        }
        else
        {
            if(i==1)
            {
                if(k==0||k==1)
                {
                    cursorCourses = db.rawQuery("SELECT "+DRMOHSINKHAN+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+" BETWEEN 0 AND 1", null);
                }
                else if(k==2||k==3)
                {
                    cursorCourses = db.rawQuery("SELECT "+MUFTITAQIUSMANI+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+" BETWEEN 0 AND 1", null);
                }

            }
            else
            {
                if(k==0||k==1)
                {
                    cursorCourses = db.rawQuery("SELECT "+DRMOHSINKHAN+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+"="+i, null);
                }
                else if(k==2||k==3)
                {
                    cursorCourses = db.rawQuery("SELECT "+MUFTITAQIUSMANI+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+"="+i, null); }

            }

        }


        List<String> list = new LinkedList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                Log.d("english", cursorCourses.getString(0));
                list.add(cursorCourses.getString(0));
            }
            while (cursorCourses.moveToNext());
//            while (cursorCourses.moveToNext()&&st<=end);

        }
        cursorCourses.close();
        return list;
    }
    public List<String> getArabic(int i,String check) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses;
        if(check.equals("s"))
        {
            cursorCourses = db.rawQuery("SELECT "+ARABIC_TEXT+" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+i, null);
        }
        else
        {
            if(i==1)
            {
                cursorCourses = db.rawQuery("SELECT "+ARABIC_TEXT+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+" BETWEEN 0 AND 1", null);
            }
            else
            {
                cursorCourses = db.rawQuery("SELECT "+ARABIC_TEXT+" FROM " + TAYAH_TABLE+" WHERE "+PARAID+"="+i, null);
            }

        }

        List<String> list = new LinkedList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                Log.d("arabic", cursorCourses.getString(0));
                list.add(cursorCourses.getString(0));
            }
            while (cursorCourses.moveToNext());
//            while (cursorCourses.moveToNext()&&st<=end);

        }
        cursorCourses.close();
        return list;
    }

    public ArrayList<QuranModel> Search(int surah)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses;
        cursorCourses = db.rawQuery("SELECT "+ARABIC_TEXT+" , "+FATEHMUHAMMADJALANDHRI+" ,"+DRMOHSINKHAN +" FROM " + TAYAH_TABLE+" WHERE "+SURAHID+"="+surah, null);
       ArrayList<QuranModel>quranModels=new ArrayList<QuranModel>();
        if (cursorCourses.moveToFirst()) {
            do {

                quranModels.add(new QuranModel(cursorCourses.getString(0),cursorCourses.getString(1),cursorCourses.getString(2)));
            }
            while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return quranModels;
    }
    public ArrayList<QuranModel> GetAllBySurah(int i)
    {
        QDH qdh=new QDH();
        List<String> ayats,urduTranslation,englishTranslation;
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();
        int count=qdh.getSurahVerses(i);
        if(i==0)
        {
            ayats=getArabic(i+1,"s");
            urduTranslation=getUrduTranslation(i+1,"s");
            englishTranslation=getEnglishTranslation(i+1,"s");
        }
        else
        {
            quranArrayList.add(new QuranModel("بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ","شروع اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے [۱]","In the Name of Allah, the Most Beneficent, the Most Merciful. "));
            ayats=getArabic(i+1,"s");
            urduTranslation=getUrduTranslation(i+1,"s");
            englishTranslation=getEnglishTranslation(i+1,"s");
        }
//        Log.d("ayats size", String.valueOf(ayats.size()));
//Log.d("count", String.valueOf(count));
        for (int index=0;index<count;index++)
            {
//                Log.d("in display", ayats.get(index));
                quranArrayList.add(new QuranModel(ayats.get(index),urduTranslation.get(index),englishTranslation.get(index) ));

            }
        return quranArrayList;
    }


    public ArrayList<QuranModel> GetAllByParah(int i)
    {
        QDH qdh=new QDH();
        List<String> ayats,urduTranslation,englishTranslation;
        ArrayList<QuranModel> quranArrayList = new ArrayList<>();

     int start,end;

        if(i==0)
        {
            start=qdh.getParahStart(i);
            end=qdh.getParahStart(i+1);
            ayats=getArabic(i+1,"p");
            urduTranslation=getUrduTranslation(i+1,"p");
            englishTranslation=getEnglishTranslation(i+1,"p");
        }
        else
        {
            if(i==29)
            {
               end= 6236;
            }
            else
            {
                end=qdh.getParahStart(i+1);
            }
            start=qdh.getParahStart(i);
            quranArrayList.add(new QuranModel("بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ","شروع اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے [۱]","In the Name of Allah, the Most Beneficent, the Most Merciful. "));
            ayats=getArabic(i+1,"p");
            urduTranslation=getUrduTranslation(i+1,"p");
            englishTranslation=getEnglishTranslation(i+1,"p");
        }
//        Log.d("ayats size", String.valueOf(ayats.size()));
//Log.d("count", String.valueOf(count));
        int j=0;
        Log.d("Start and end", start+" "+" "+end);
        for (int index=start;index<end;index++)
            {
                Log.d("in display", ayats.get(j));
                quranArrayList.add(new QuranModel(ayats.get(j),urduTranslation.get(j),englishTranslation.get(j) ));
                j++;

            }
        return quranArrayList;
}
 }
