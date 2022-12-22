package com.didi.dimina.container.secondparty.permission.bridge;

import com.didi.dimina.container.secondparty.permission.source.Source;

public final class BridgeRequest {
    public static final int TYPE_ALERT_WINDOW = 5;
    public static final int TYPE_APP_DETAILS = 1;
    public static final int TYPE_INSTALL = 3;
    public static final int TYPE_NOTIFY = 6;
    public static final int TYPE_NOTIFY_LISTENER = 7;
    public static final int TYPE_OVERLAY = 4;
    public static final int TYPE_PERMISSION = 2;
    public static final int TYPE_WRITE_SETTING = 8;

    /* renamed from: a */
    private final Source f17337a;

    /* renamed from: b */
    private int f17338b;

    /* renamed from: c */
    private Callback f17339c;

    /* renamed from: d */
    private String[] f17340d;

    public interface Callback {
        void onCallback();
    }

    public BridgeRequest(Source source) {
        this.f17337a = source;
    }

    public Source getSource() {
        return this.f17337a;
    }

    public int getType() {
        return this.f17338b;
    }

    public void setType(int i) {
        this.f17338b = i;
    }

    public Callback getCallback() {
        return this.f17339c;
    }

    public void setCallback(Callback callback) {
        this.f17339c = callback;
    }

    public String[] getPermissions() {
        return this.f17340d;
    }

    public void setPermissions(String[] strArr) {
        this.f17340d = strArr;
    }
}
