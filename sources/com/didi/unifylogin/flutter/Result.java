package com.didi.unifylogin.flutter;

import com.didi.unifylogin.store.LoginStore;
import com.google.gson.Gson;
import com.taxis99.R;

public class Result {

    /* renamed from: a */
    private int f44780a = -1;

    /* renamed from: b */
    private String f44781b = "";

    public static String error(int i, String str) {
        Result result = new Result();
        result.f44780a = i;
        result.f44781b = str;
        return result.toString();
    }

    public static String error(String str) {
        Result result = new Result();
        result.f44781b = str;
        return result.toString();
    }

    public static String error() {
        Result result = new Result();
        result.f44781b = LoginStore.getContext().getString(R.string.login_unify_net_error);
        return result.toString();
    }

    public static String from(Object obj) {
        return new Gson().toJson(obj);
    }

    /* renamed from: ok */
    public static String m31807ok() {
        Result result = new Result();
        result.f44780a = 0;
        return result.toString();
    }

    public String toString() {
        return "{\"errno\":" + this.f44780a + ",\"error\":\"" + this.f44781b + "\"}";
    }
}
