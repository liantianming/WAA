package com.video.bean;

import java.io.Serializable;

public class BaseBookSchoolBeanBean implements Serializable {

    private Integer bsId;

    private String schoolZh;

    private String bkParentId;

    private Integer schoolClassify;

    private static final long serialVersionUID = 1L;

    public Integer getBsId() {
        return bsId;
    }

    public void setBsId(Integer bsId) {
        this.bsId = bsId;
    }

    public String getSchoolZh() {
        return schoolZh;
    }

    public void setSchoolZh(String schoolZh) {
        this.schoolZh = schoolZh == null ? null : schoolZh.trim();
    }

    public String getBkParentId() {
        return bkParentId;
    }

    public void setBkParentId(String bkParentId) {
        this.bkParentId = bkParentId == null ? null : bkParentId.trim();
    }

    public Integer getSchoolClassify() {
        return schoolClassify;
    }

    public void setSchoolClassify(Integer schoolClassify) {
        this.schoolClassify = schoolClassify;
    }
}
