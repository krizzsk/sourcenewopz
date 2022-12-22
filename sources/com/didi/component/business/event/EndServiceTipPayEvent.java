package com.didi.component.business.event;

public class EndServiceTipPayEvent {
    public String source = "";
    public String tipFee = "";

    public EndServiceTipPayEvent(String str, String str2) {
        this.source = str;
        this.tipFee = str2;
    }
}
