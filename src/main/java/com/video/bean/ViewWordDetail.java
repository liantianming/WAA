package com.video.bean;

import java.io.Serializable;

public class ViewWordDetail implements Serializable{
    private String vcId;
    private String vcVocabulary;
    private String vcPhoneticUk;
    private String vcPhoneticUs;
    private String v;
    private String expre;

    public String getVcId() {
        return vcId;
    }

    public void setVcId(String vcId) {
        this.vcId = vcId;
    }

    public String getVcVocabulary() {
        return vcVocabulary;
    }

    public void setVcVocabulary(String vcVocabulary) {
        this.vcVocabulary = vcVocabulary;
    }

    public String getVcPhoneticUk() {
        return vcPhoneticUk;
    }

    public void setVcPhoneticUk(String vcPhoneticUk) {
        this.vcPhoneticUk = vcPhoneticUk;
    }

    public String getVcPhoneticUs() {
        return vcPhoneticUs;
    }

    public void setVcPhoneticUs(String vcPhoneticUs) {
        this.vcPhoneticUs = vcPhoneticUs;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getExpre() {
        return expre;
    }

    public void setExpre(String expre) {
        this.expre = expre;
    }
}
