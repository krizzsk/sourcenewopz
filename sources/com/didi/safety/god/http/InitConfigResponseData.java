package com.didi.safety.god.http;

import com.didichuxing.dfbasesdk.utils.StrToNumUtils;
import java.io.Serializable;
import java.util.Arrays;

public class InitConfigResponseData implements Serializable {
    private Card[] cards;
    private String clearPicProportion;
    private int code;
    private float dectConf;
    private int delayedFocusTime = -1;
    private double detectBadFrameRatio = 1.0d;
    private int detectDownTime = -1;
    public String[] exitCaseOptions;
    public boolean exitCaseSwitch;
    public boolean failCaseSwitch;
    private String modelMd5;
    private boolean modelUp;
    private String modelUrl;
    private Long modelVersion;
    public boolean standardTimeoutSwitch;
    public boolean successCaseSwitch;
    private int timeOutSec;
    private int videoLength;

    public double getScreenCheckRate() {
        return this.detectBadFrameRatio;
    }

    public String getModelMd5() {
        return this.modelMd5;
    }

    public void setModelMd5(String str) {
        this.modelMd5 = str;
    }

    public Long getModelVersion() {
        return this.modelVersion;
    }

    public void setModelVersion(Long l) {
        this.modelVersion = l;
    }

    public String getModelUrl() {
        return this.modelUrl;
    }

    public void setModelUrl(String str) {
        this.modelUrl = str;
    }

    public int getDelayedFocusTime() {
        return this.delayedFocusTime;
    }

    public void setDelayedFocusTime(int i) {
        this.delayedFocusTime = i;
    }

    public float getDectConf() {
        return this.dectConf;
    }

    public void setDectConf(float f) {
        this.dectConf = f;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public boolean isModelUp() {
        return this.modelUp;
    }

    public void setModelUp(boolean z) {
        this.modelUp = z;
    }

    public int getTimeOutSec() {
        return this.timeOutSec;
    }

    public void setTimeOutSec(int i) {
        this.timeOutSec = i;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public void setVideoLength(int i) {
        this.videoLength = i;
    }

    public Card[] getCards() {
        return this.cards;
    }

    public void setCards(Card[] cardArr) {
        this.cards = cardArr;
    }

    public int getDetectDownTime() {
        return this.detectDownTime;
    }

    public void setDetectDownTime(int i) {
        this.detectDownTime = i;
    }

    public float getClearPicProportion() {
        return StrToNumUtils.toFloat(this.clearPicProportion);
    }

    public String toString() {
        return "InitConfigResponseData{code=" + this.code + ", modelUp=" + this.modelUp + ", timeOutSec=" + this.timeOutSec + ", videoLength=" + this.videoLength + ", dectConf=" + this.dectConf + ", delayedFocusTime=" + this.delayedFocusTime + ". detectDownTime=" + this.detectDownTime + ", modelVersion=" + this.modelVersion + ", modelUrl='" + this.modelUrl + '\'' + ", modelMd5='" + this.modelMd5 + '\'' + ", cards=" + Arrays.toString(this.cards) + '}';
    }
}
