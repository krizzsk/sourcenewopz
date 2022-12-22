package com.dmap.navigation.engine.event;

import java.util.Arrays;

public class DownloadVecEvent extends NaviEvent {

    /* renamed from: a */
    private final String f51875a;

    /* renamed from: b */
    private final String f51876b;

    /* renamed from: c */
    private final byte[] f51877c;

    public DownloadVecEvent(String str, String str2, byte[] bArr) {
        this.f51875a = str;
        this.f51876b = str2;
        this.f51877c = bArr;
    }

    public String toString() {
        return "DownloadVecEvent{url='" + this.f51875a + '\'' + ", key='" + this.f51876b + '\'' + ", data=" + Arrays.toString(this.f51877c) + '}';
    }

    public String getUrl() {
        return this.f51875a;
    }

    public String getKey() {
        return this.f51876b;
    }

    public byte[] getData() {
        return this.f51877c;
    }
}
