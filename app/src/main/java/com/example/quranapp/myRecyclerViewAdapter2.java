package com.example.quranapp;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter2 extends RecyclerView.Adapter<myRecyclerViewAdapter2.MyVH> {

    List<QuranModel>quranList;
    public myRecyclerViewAdapter2(List<QuranModel> friendsList) {
        this.quranList = friendsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter2.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surahcustomizedview, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter2.MyVH holder, int position) {
        holder.data=quranList.get(position);
        holder.textViewArabic.setText(holder.data.getArabicText());
        holder.textViewUrdu.setText(String.valueOf(holder.data.getUrduText()));
        holder.textViewEnglish.setText(holder.data.getEnglishText());

    }

    @Override
    public int getItemCount() {
        return quranList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        TextView textViewArabic;
        TextView  textViewEnglish;
        TextView textViewUrdu;
        QuranModel data;


        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewArabic = itemView.findViewById(R.id.arabic);
            textViewUrdu = itemView.findViewById(R.id.urdu);
             textViewEnglish = itemView.findViewById(R.id.english);
            Typeface urdufont=Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/jameelnoorinastaleeq.ttf");
            textViewUrdu.setTypeface(urdufont);
            Typeface arabicfont=Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/noorehuda.ttf");
            textViewArabic.setTypeface(arabicfont);
        }


    }
}









