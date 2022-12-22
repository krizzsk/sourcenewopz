package com.didi.global.globaluikit.callback;

public class LEGOBtnTextAndCallback {

    /* renamed from: a */
    private String f22363a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f22364b;

    public LEGOBtnTextAndCallback(String str, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener) {
        this.f22363a = str;
        this.f22364b = lEGOOnAntiShakeClickListener;
    }

    public LEGOBtnTextAndCallback() {
    }

    public String getText() {
        return this.f22363a;
    }

    public LEGOOnAntiShakeClickListener getListener() {
        return this.f22364b;
    }
}
