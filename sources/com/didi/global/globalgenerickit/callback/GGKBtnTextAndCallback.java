package com.didi.global.globalgenerickit.callback;

import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKBtnTextAndCallback {

    /* renamed from: a */
    private String f22045a;

    /* renamed from: b */
    private GGKOnAntiShakeClickListener f22046b;

    public GGKBtnTextAndCallback(String str, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        this.f22045a = str;
        this.f22046b = gGKOnAntiShakeClickListener;
    }

    public String getText() {
        return this.f22045a;
    }

    public GGKOnAntiShakeClickListener getListener() {
        return this.f22046b;
    }
}
