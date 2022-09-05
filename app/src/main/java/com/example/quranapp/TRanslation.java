package com.example.quranapp;

public class TRanslation {
    private String english;
    private String urdu;

    public TRanslation(String english, String urdu) {
        this.english = english;
        this.urdu = urdu;
    }

    public String getEnglish() {
        return english;
    }

    public String getUrdu() {
        return urdu;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }
}
