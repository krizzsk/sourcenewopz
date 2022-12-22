package com.yanzhenjie.permission.bridge;

import com.yanzhenjie.permission.source.Source;

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
    private final Source f56160a;

    /* renamed from: b */
    private int f56161b;

    /* renamed from: c */
    private Callback f56162c;

    /* renamed from: d */
    private String[] f56163d;

    public interface Callback {
        void onCallback();
    }

    public BridgeRequest(Source source) {
        this.f56160a = source;
    }

    public Source getSource() {
        return this.f56160a;
    }

    public int getType() {
        return this.f56161b;
    }

    public void setType(int i) {
        this.f56161b = i;
    }

    public Callback getCallback() {
        return this.f56162c;
    }

    public void setCallback(Callback callback) {
        this.f56162c = callback;
    }

    public String[] getPermissions() {
        return this.f56163d;
    }

    public void setPermissions(String[] strArr) {
        this.f56163d = strArr;
    }
}
