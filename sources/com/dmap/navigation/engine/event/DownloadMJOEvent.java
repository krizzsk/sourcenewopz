package com.dmap.navigation.engine.event;

public class DownloadMJOEvent extends NaviEvent {

    /* renamed from: a */
    private final long f51871a;

    /* renamed from: b */
    private final String f51872b;

    /* renamed from: c */
    private final String f51873c;

    /* renamed from: d */
    private final String f51874d;

    public DownloadMJOEvent(long j, String str, String str2, String str3) {
        this.f51871a = j;
        this.f51872b = str;
        this.f51873c = str2;
        this.f51874d = str3;
    }

    public String toString() {
        return "DownloadMjoEvent{mjoId=" + this.f51871a + ", url='" + this.f51872b + '\'' + ", configUrl='" + this.f51873c + '\'' + ", commonUrl='" + this.f51874d + '\'' + '}';
    }

    public long getMjoId() {
        return this.f51871a;
    }

    public String getUrl() {
        return this.f51872b;
    }

    public String getConfigUrl() {
        return this.f51873c;
    }

    public String getCommonUrl() {
        return this.f51874d;
    }
}
