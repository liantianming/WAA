package com.video.bean;

import java.io.Serializable;

public class BaseBookWordBean implements Serializable {
    private String vcId;

    private String vcVocabulary;

    private String vcPhoneticUk;

    private String vcPhoneticUs;

    private Float vcFrequency;

    private Integer vcDifficulty;

    private Float vcAcknowledgeRate;

    private Integer wordId;

    private static final long serialVersionUID = 1L;

    public String getVcId() {
        return vcId;
    }

    public void setVcId(String vcId) {
        this.vcId = vcId == null ? null : vcId.trim();
    }

    public String getVcVocabulary() {
        return vcVocabulary;
    }

    public void setVcVocabulary(String vcVocabulary) {
        this.vcVocabulary = vcVocabulary == null ? null : vcVocabulary.trim();
    }

    public String getVcPhoneticUk() {
        return vcPhoneticUk;
    }

    public void setVcPhoneticUk(String vcPhoneticUk) {
        this.vcPhoneticUk = vcPhoneticUk == null ? null : vcPhoneticUk.trim();
    }

    public String getVcPhoneticUs() {
        return vcPhoneticUs;
    }

    public void setVcPhoneticUs(String vcPhoneticUs) {
        this.vcPhoneticUs = vcPhoneticUs == null ? null : vcPhoneticUs.trim();
    }

    public Float getVcFrequency() {
        return vcFrequency;
    }

    public void setVcFrequency(Float vcFrequency) {
        this.vcFrequency = vcFrequency;
    }

    public Integer getVcDifficulty() {
        return vcDifficulty;
    }

    public void setVcDifficulty(Integer vcDifficulty) {
        this.vcDifficulty = vcDifficulty;
    }

    public Float getVcAcknowledgeRate() {
        return vcAcknowledgeRate;
    }

    public void setVcAcknowledgeRate(Float vcAcknowledgeRate) {
        this.vcAcknowledgeRate = vcAcknowledgeRate;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }
}