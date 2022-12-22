package com.didi.one.netdetect.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DetectionItem implements Serializable {

    /* renamed from: id */
    public int f29447id;
    public int md5Check;
    public Map<String, String> requestHeaders = new HashMap();
    public int responseHeaders;
    public int timeInfo;
    public String type;
    public String url;

    public String toString() {
        return "DetectionItem{id=" + this.f29447id + ", type='" + this.type + '\'' + ", url='" + this.url + '\'' + ", timeInfo=" + this.timeInfo + ", responseHeaders=" + this.responseHeaders + ", requestHeaders=" + this.requestHeaders + ", md5Check=" + this.md5Check + '}';
    }
}
