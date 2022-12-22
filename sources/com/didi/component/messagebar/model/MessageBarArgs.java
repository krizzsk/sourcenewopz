package com.didi.component.messagebar.model;

import java.io.Serializable;

public class MessageBarArgs implements Serializable {
    public String eda;
    public String eta;
    public String pay_status_subtitle;

    public String getPay_status_subtitle() {
        return this.pay_status_subtitle;
    }

    public void setPay_status_subtitle(String str) {
        this.pay_status_subtitle = str;
    }

    public String getEta() {
        return this.eta;
    }

    public void setEta(String str) {
        this.eta = str;
    }

    public String getEda() {
        return this.eda;
    }

    public void setEda(String str) {
        this.eda = str;
    }
}
