package com.video.util;

public class Content {
    private String sId;

    private String sWordId;

    private String sSentence;

    private String sSentenceCn;

    private String sSentenceFrom;

    public Content() {
    }

    public Content(String sId, String sWordId, String sSentence, String sSentenceCn, String sSentenceFrom) {
        this.sId = sId;
        this.sWordId = sWordId;
        this.sSentence = sSentence;
        this.sSentenceCn = sSentenceCn;
        this.sSentenceFrom = sSentenceFrom;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsWordId() {
        return sWordId;
    }

    public void setsWordId(String sWordId) {
        this.sWordId = sWordId;
    }

    public String getsSentence() {
        return sSentence;
    }

    public void setsSentence(String sSentence) {
        this.sSentence = sSentence;
    }

    public String getsSentenceCn() {
        return sSentenceCn;
    }

    public void setsSentenceCn(String sSentenceCn) {
        this.sSentenceCn = sSentenceCn;
    }

    public String getsSentenceFrom() {
        return sSentenceFrom;
    }

    public void setsSentenceFrom(String sSentenceFrom) {
        this.sSentenceFrom = sSentenceFrom;
    }
}