package com.video.bean;

import java.io.Serializable;

public class BaseBookSentenceBean implements Serializable {
    private String sId;

    private String sWordId;

    private String sSentence;
    private String sSentenceHtml;

    private String sSentenceCn;

    private String sSentenceFrom;

    public BaseBookSentenceBean() {
    }

    public BaseBookSentenceBean(String sId, String sWordId, String sSentence,String sSentenceHtml, String sSentenceCn, String sSentenceFrom) {
        this.sId = sId;
        this.sWordId = sWordId;
        this.sSentence = sSentence;
        this.sSentenceHtml = sSentenceHtml;
        this.sSentenceCn = sSentenceCn;
        this.sSentenceFrom = sSentenceFrom;
    }

    private static final long serialVersionUID = 1L;

    public String getsSentenceHtml() {
        return sSentenceHtml;
    }

    public void setsSentenceHtml(String sSentenceHtml) {
        this.sSentenceHtml = sSentenceHtml;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getsWordId() {
        return sWordId;
    }

    public void setsWordId(String sWordId) {
        this.sWordId = sWordId == null ? null : sWordId.trim();
    }

    public String getsSentence() {
        return sSentence;
    }

    public void setsSentence(String sSentence) {
        this.sSentence = sSentence == null ? null : sSentence.trim();
    }

    public String getsSentenceCn() {
        return sSentenceCn;
    }

    public void setsSentenceCn(String sSentenceCn) {
        this.sSentenceCn = sSentenceCn == null ? null : sSentenceCn.trim();
    }

    public String getsSentenceFrom() {
        return sSentenceFrom;
    }

    public void setsSentenceFrom(String sSentenceFrom) {
        this.sSentenceFrom = sSentenceFrom == null ? null : sSentenceFrom.trim();
    }
}