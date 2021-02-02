package com.video.bean;

import java.io.Serializable;

public class BaseUnitBookBeanBean implements Serializable {

    private String bvId;

    private String bvBookId;

    private String bvVocId;

    private String bvFlag;

    private String bvTag;

    private Integer bvOrder;

    private static final long serialVersionUID = 1L;

    public String getBvId() {
        return bvId;
    }

    public void setBvId(String bvId) {
        this.bvId = bvId == null ? null : bvId.trim();
    }

    public String getBvBookId() {
        return bvBookId;
    }

    public void setBvBookId(String bvBookId) {
        this.bvBookId = bvBookId == null ? null : bvBookId.trim();
    }

    public String getBvVocId() {
        return bvVocId;
    }

    public void setBvVocId(String bvVocId) {
        this.bvVocId = bvVocId == null ? null : bvVocId.trim();
    }

    public String getBvFlag() {
        return bvFlag;
    }

    public void setBvFlag(String bvFlag) {
        this.bvFlag = bvFlag == null ? null : bvFlag.trim();
    }

    public String getBvTag() {
        return bvTag;
    }

    public void setBvTag(String bvTag) {
        this.bvTag = bvTag == null ? null : bvTag.trim();
    }

    public Integer getBvOrder() {
        return bvOrder;
    }

    public void setBvOrder(Integer bvOrder) {
        this.bvOrder = bvOrder;
    }
}
