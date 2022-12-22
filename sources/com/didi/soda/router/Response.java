package com.didi.soda.router;

import android.os.Bundle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class Response {
    public static final int CODE_DOWNGRADE = -6;
    public static final int CODE_ERROR_PATH = -2;
    public static final int CODE_INTERCEPTED = -5;
    public static final int CODE_NOT_FOUND_HUB = -3;
    public static final int CODE_NOT_FOUND_HUB_HANDLER = -4;
    public static final int CODE_NOT_START = -7;
    public static final int CODE_NO_INIT = -1;
    public static final int CODE_SUCCESS = 0;

    /* renamed from: a */
    private int f43661a = 0;

    /* renamed from: b */
    private String f43662b;

    /* renamed from: c */
    private String f43663c;

    /* renamed from: d */
    private Class<?> f43664d;

    /* renamed from: e */
    private Bundle f43665e;
    protected Bundle responseExtras;

    public static String codeToString(int i) {
        switch (i) {
            case -7:
                return "CODE_NOT_START";
            case -6:
                return "CODE_DOWNGRADE";
            case -5:
                return "CODE_INTERCEPTED";
            case -4:
                return "CODE_NOT_FOUND_HUB_HANDLER";
            case -3:
                return "CODE_NOT_FOUND_HUB";
            case -2:
                return "CODE_ERROR_PATH";
            case -1:
                return "CODE_NO_INIT";
            case 0:
                return "CODE_SUCCESS";
            default:
                return "Unknown";
        }
    }

    Response(Request request) {
        this.f43663c = request.getPath();
        this.f43664d = request.getTarget();
        this.f43665e = request.getExtras();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108754a(int i) {
        this.f43661a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108756a(String str) {
        this.f43662b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108755a(Request request) {
        this.f43663c = request.getPath();
        this.f43664d = request.getTarget();
        this.f43665e = request.getExtras();
    }

    public int getCode() {
        return this.f43661a;
    }

    public boolean isSuccessful() {
        return this.f43661a == 0;
    }

    public String getMessage() {
        return this.f43662b;
    }

    public void setResponseExtras(Bundle bundle) {
        this.responseExtras = bundle;
    }

    public Bundle getResponseExtras() {
        return this.responseExtras;
    }

    public Bundle getRequestExtras() {
        return this.f43665e;
    }

    public Class<?> getRequestTarget() {
        return this.f43664d;
    }

    public String getRequestPath() {
        return this.f43663c;
    }

    public String toString() {
        return "Response[code:" + codeToString(this.f43661a) + "(" + this.f43661a + ")" + ", message:" + this.f43662b + ", [requestPath:" + this.f43663c + ", requestTarget:" + this.f43664d + ", requestExtras:" + this.f43665e + "], responseExtras:" + this.responseExtras + Const.jaRight;
    }
}
