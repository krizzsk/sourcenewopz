package com.didi.entrega.router;

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
    private int f21028a = 0;

    /* renamed from: b */
    private String f21029b;

    /* renamed from: c */
    private String f21030c;

    /* renamed from: d */
    private Class<?> f21031d;

    /* renamed from: e */
    private Bundle f21032e;
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
        this.f21030c = request.getPath();
        this.f21031d = request.getTarget();
        this.f21032e = request.getExtras();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62643a(int i) {
        this.f21028a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62645a(String str) {
        this.f21029b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62644a(Request request) {
        this.f21030c = request.getPath();
        this.f21031d = request.getTarget();
        this.f21032e = request.getExtras();
    }

    public int getCode() {
        return this.f21028a;
    }

    public boolean isSuccessful() {
        return this.f21028a == 0;
    }

    public String getMessage() {
        return this.f21029b;
    }

    public void setResponseExtras(Bundle bundle) {
        this.responseExtras = bundle;
    }

    public Bundle getResponseExtras() {
        return this.responseExtras;
    }

    public Bundle getRequestExtras() {
        return this.f21032e;
    }

    public Class<?> getRequestTarget() {
        return this.f21031d;
    }

    public String getRequestPath() {
        return this.f21030c;
    }

    public String toString() {
        return "Response[code:" + codeToString(this.f21028a) + "(" + this.f21028a + ")" + ", message:" + this.f21029b + ", [requestPath:" + this.f21030c + ", requestTarget:" + this.f21031d + ", requestExtras:" + this.f21032e + "], responseExtras:" + this.responseExtras + Const.jaRight;
    }
}
