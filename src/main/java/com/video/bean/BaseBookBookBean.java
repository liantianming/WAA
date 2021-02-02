package com.video.bean;

import java.io.Serializable;

public class BaseBookBookBean implements Serializable {
    private String bkId;

    private String bkParentId;

    private String bkLevel;

    private String bkOrder;

    private String bkName;

    private String bkItemNum;

    private String bkDirectItemNum;

    private String bkAuthor;

    private String bkBook;

    private String bkComment;

    private String bkOrgnization;

    private String bkPublisher;

    private String bkVersion;

    private String bkFlag;

    private static final long serialVersionUID = 1L;

    public String getBkId() {
        return bkId;
    }

    public void setBkId(String bkId) {
        this.bkId = bkId == null ? null : bkId.trim();
    }

    public String getBkParentId() {
        return bkParentId;
    }

    public void setBkParentId(String bkParentId) {
        this.bkParentId = bkParentId == null ? null : bkParentId.trim();
    }

    public String getBkLevel() {
        return bkLevel;
    }

    public void setBkLevel(String bkLevel) {
        this.bkLevel = bkLevel == null ? null : bkLevel.trim();
    }

    public String getBkOrder() {
        return bkOrder;
    }

    public void setBkOrder(String bkOrder) {
        this.bkOrder = bkOrder == null ? null : bkOrder.trim();
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName == null ? null : bkName.trim();
    }

    public String getBkItemNum() {
        return bkItemNum;
    }

    public void setBkItemNum(String bkItemNum) {
        this.bkItemNum = bkItemNum == null ? null : bkItemNum.trim();
    }

    public String getBkDirectItemNum() {
        return bkDirectItemNum;
    }

    public void setBkDirectItemNum(String bkDirectItemNum) {
        this.bkDirectItemNum = bkDirectItemNum == null ? null : bkDirectItemNum.trim();
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor == null ? null : bkAuthor.trim();
    }

    public String getBkBook() {
        return bkBook;
    }

    public void setBkBook(String bkBook) {
        this.bkBook = bkBook == null ? null : bkBook.trim();
    }

    public String getBkComment() {
        return bkComment;
    }

    public void setBkComment(String bkComment) {
        this.bkComment = bkComment == null ? null : bkComment.trim();
    }

    public String getBkOrgnization() {
        return bkOrgnization;
    }

    public void setBkOrgnization(String bkOrgnization) {
        this.bkOrgnization = bkOrgnization == null ? null : bkOrgnization.trim();
    }

    public String getBkPublisher() {
        return bkPublisher;
    }

    public void setBkPublisher(String bkPublisher) {
        this.bkPublisher = bkPublisher == null ? null : bkPublisher.trim();
    }

    public String getBkVersion() {
        return bkVersion;
    }

    public void setBkVersion(String bkVersion) {
        this.bkVersion = bkVersion == null ? null : bkVersion.trim();
    }

    public String getBkFlag() {
        return bkFlag;
    }

    public void setBkFlag(String bkFlag) {
        this.bkFlag = bkFlag == null ? null : bkFlag.trim();
    }
}
