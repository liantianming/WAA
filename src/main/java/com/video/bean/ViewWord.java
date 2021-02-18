package com.video.bean;

import java.io.Serializable;

public class ViewWord implements Serializable {

    private String classify;
    private String unitName;
    private String bkId;
    private String word;
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String booKName) {
        this.bookName = booKName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBkId() {
        return bkId;
    }

    public void setBkId(String bkId) {
        this.bkId = bkId;
    }
}
