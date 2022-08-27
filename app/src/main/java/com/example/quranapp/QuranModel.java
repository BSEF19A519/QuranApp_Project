package com.example.quranapp;

public class QuranModel {
   private String arabicText;
   private String urduText;
   private String englishText;

    public QuranModel(String arabicText, String urduText, String englishText) {
        this.arabicText = arabicText;
        this.urduText = urduText;
        this.englishText = englishText;
    }

    public String getArabicText() {
        return arabicText;
    }

    public String getUrduText() {
        return urduText;
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public void setUrduText(String urduText) {
        this.urduText = urduText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }
}
