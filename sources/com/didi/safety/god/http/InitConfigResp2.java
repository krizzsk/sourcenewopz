package com.didi.safety.god.http;

import com.didichuxing.dfbasesdk.utils.StrToNumUtils;
import java.util.Arrays;

public class InitConfigResp2 extends BaseInnerResult {
    public String appealUrl;
    private Card[] cards;
    private String clearPicProportion;
    private int code;
    private float dectConf;
    private int delayedFocusTime = -1;
    private double detectBadFrameRatio = 1.0d;
    public boolean failCaseSwitch;
    private String modelMd5;
    private boolean modelUp;
    private String modelUrl;
    private Long modelVersion;
    public boolean standardTimeoutSwitch;
    public boolean successCaseSwitch;

    public double getScreenCheckRate() {
        return this.detectBadFrameRatio;
    }

    public String getAppealUrl() {
        return this.appealUrl;
    }

    public void setAppealUrl(String str) {
        this.appealUrl = str;
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

    public Card[] getCards() {
        return this.cards;
    }

    public void setCards(Card[] cardArr) {
        this.cards = cardArr;
    }

    public float getClearPicProportion() {
        return StrToNumUtils.toFloat(this.clearPicProportion);
    }

    public String toString() {
        return "InitConfigResponseData{code=" + this.code + ", modelUp=" + this.modelUp + ", dectConf=" + this.dectConf + ", delayedFocusTime=" + this.delayedFocusTime + ", modelVersion=" + this.modelVersion + ", modelUrl='" + this.modelUrl + '\'' + ", modelMd5='" + this.modelMd5 + '\'' + ", cards=" + Arrays.toString(this.cards) + '}';
    }
}
