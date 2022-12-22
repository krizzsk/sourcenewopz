package com.didi.map.sdk.maprouter;

public class TtsText {
    public String eventId;
    public String path;
    public String text;
    public int type;

    public TtsText(int i, String str, String str2, String str3) {
        this.type = i;
        this.text = str;
        this.eventId = str3;
        this.path = str2;
    }
}
