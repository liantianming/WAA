package com.video.bean;

import java.io.Serializable;
import java.util.Date;

public class BaseVideoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String vId;

    private String vUserId;

    private String vOrigPath;

    private String vPath;

    private String vOrigName;

    private String vName;

    private Long vFileSize;

    private String vSuffix;

    private String vIsDelete;

    private Date vCreateDate;

    private String vUpdateUserId;

    private Date vUpdateDate;

    private String vUuid;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvUserId() {
        return vUserId;
    }

    public void setvUserId(String vUserId) {
        this.vUserId = vUserId == null ? null : vUserId.trim();
    }

    public String getvOrigPath() {
        return vOrigPath;
    }

    public void setvOrigPath(String vOrigPath) {
        this.vOrigPath = vOrigPath == null ? null : vOrigPath.trim();
    }

    public String getvPath() {
        return vPath;
    }

    public void setvPath(String vPath) {
        this.vPath = vPath == null ? null : vPath.trim();
    }

    public String getvOrigName() {
        return vOrigName;
    }

    public void setvOrigName(String vOrigName) {
        this.vOrigName = vOrigName == null ? null : vOrigName.trim();
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public Long getvFileSize() {
        return vFileSize;
    }

    public void setvFileSize(Long vFileSize) {
        this.vFileSize = vFileSize;
    }

    public String getvSuffix() {
        return vSuffix;
    }

    public void setvSuffix(String vSuffix) {
        this.vSuffix = vSuffix == null ? null : vSuffix.trim();
    }

    public String getvIsDelete() {
        return vIsDelete;
    }

    public void setvIsDelete(String vIsDelete) {
        this.vIsDelete = vIsDelete == null ? null : vIsDelete.trim();
    }

    public Date getvCreateDate() {
        return vCreateDate;
    }

    public void setvCreateDate(Date vCreateDate) {
        this.vCreateDate = vCreateDate;
    }

    public String getvUpdateUserId() {
        return vUpdateUserId;
    }

    public void setvUpdateUserId(String vUpdateUserId) {
        this.vUpdateUserId = vUpdateUserId == null ? null : vUpdateUserId.trim();
    }

    public Date getvUpdateDate() {
        return vUpdateDate;
    }

    public void setvUpdateDate(Date vUpdateDate) {
        this.vUpdateDate = vUpdateDate;
    }

    public String getvUuid() {
        return vUuid;
    }

    public void setvUuid(String vUuid) {
        this.vUuid = vUuid == null ? null : vUuid.trim();
    }
}
