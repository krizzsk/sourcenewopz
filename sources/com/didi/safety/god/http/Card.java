package com.didi.safety.god.http;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Card implements Serializable {
    @SerializedName("algoModelSwitch")
    public boolean algoModelSwitch;
    private Integer algoType;
    private String cardImgCode;
    private String cardImgDesc;
    private String cardImgName;
    @SerializedName("confirmUploadPageSwitch")
    public boolean confirmUploadPageSwitch;
    @SerializedName("confirmUploadPageTitle")
    public String confirmUploadPageTitle;
    private String outlineUrl;
    private int picAutoDect;
    private String previewUrl;
    @SerializedName("shootRequire")
    private String requests;
    private String retryTimes;
    @SerializedName("localPicSwitch")
    public boolean supportLocalPic;
    private int timeOutSec;
    private int videoLength;

    public String getCardImgCode() {
        return this.cardImgCode;
    }

    public void setCardImgCode(String str) {
        this.cardImgCode = str;
    }

    public String getCardImgName() {
        return this.cardImgName;
    }

    public void setCardImgName(String str) {
        this.cardImgName = str;
    }

    public String getRetryTimes() {
        return this.retryTimes;
    }

    public void setRetryTimes(String str) {
        this.retryTimes = str;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public void setVideoLength(int i) {
        this.videoLength = i;
    }

    public String getOutlineUrl() {
        return this.outlineUrl;
    }

    public void setOutlineUrl(String str) {
        this.outlineUrl = str;
    }

    public int getTimeOutSec() {
        return this.timeOutSec;
    }

    public void setTimeOutSec(int i) {
        this.timeOutSec = i;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public void setPreviewUrl(String str) {
        this.previewUrl = str;
    }

    public Integer getAlgoType() {
        return this.algoType;
    }

    public void setAlgoType(Integer num) {
        this.algoType = num;
    }

    public String getCardImgDesc() {
        return this.cardImgDesc;
    }

    public void setCardImgDesc(String str) {
        this.cardImgDesc = str;
    }

    public int getPicAutoDect() {
        return this.picAutoDect;
    }

    public void setPicAutoDect(int i) {
        this.picAutoDect = i;
    }

    public String getRequests() {
        return this.requests;
    }

    public void setRequests(String str) {
        this.requests = str;
    }

    public String toString() {
        return "Card{picAutoDect=" + this.picAutoDect + ", cardImgDesc='" + this.cardImgDesc + '\'' + ", previewUrl='" + this.previewUrl + '\'' + ", algoType=" + this.algoType + '}';
    }

    public String getCardName() {
        return getCardImgCode();
    }

    public void setCardName(String str) {
        setCardImgCode(str);
    }

    public String getCardReqContent(Context context) {
        return getRequests();
    }
}
