package com.example.quranapp;


import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<QuranModel> {
    public MyAdapter(Context context, ArrayList<QuranModel> arrayList) {
        super(context, 0, arrayList);
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        QuranModel model = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surahcustomizedview, parent, false);
        TextView textViewArabic = convertView.findViewById(R.id.arabic);
        TextView textViewUrdu = convertView.findViewById(R.id.urdu);
        TextView textViewEnglish = convertView.findViewById(R.id.english);


     textViewArabic.setText(model.getArabicText());
     textViewUrdu.setText(model.getUrduText());
     textViewEnglish.setText(model.getEnglishText());

        return convertView;
}}


