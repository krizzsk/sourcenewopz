package com.didi.sdk.util.tips;

import android.app.Activity;
import android.view.View;

public class TipsBuilder {

    /* renamed from: a */
    TipsView f37743a;

    public TipsBuilder(Activity activity) {
        this.f37743a = new TipsView(activity);
    }

    public TipsBuilder setTarget(View view) {
        this.f37743a.setTarget(view);
        return this;
    }

    public TipsBuilder setTarget(View view, int i, int i2, int i3) {
        this.f37743a.setTarget(view, i, i2, i3);
        return this;
    }

    public TipsView build() {
        return this.f37743a;
    }

    public TipsBuilder setTitle(String str) {
        this.f37743a.setTitle(str);
        return this;
    }

    public TipsBuilder setDescription(String str) {
        this.f37743a.setDescription(str);
        return this;
    }

    public TipsBuilder displayOneTime(int i) {
        this.f37743a.setDisplayOneTime(true);
        this.f37743a.setDisplayOneTimeID(i);
        return this;
    }

    public TipsBuilder setDelay(int i) {
        this.f37743a.setDelay(i);
        return this;
    }

    public TipsBuilder setTitleColor(int i) {
        this.f37743a.setTitle_color(i);
        return this;
    }

    public TipsBuilder setDescriptionColor(int i) {
        this.f37743a.setDescription_color(i);
        return this;
    }

    public TipsBuilder setBackgroundColor(int i) {
        this.f37743a.setBackground_color(i);
        return this;
    }

    public TipsBuilder setCircleColor(int i) {
        this.f37743a.setCircleColor(i);
        return this;
    }

    public TipsBuilder setButtonText(String str) {
        this.f37743a.setButtonText(str);
        return this;
    }

    public TipsBuilder setShowView(View view) {
        this.f37743a.setShowView(view);
        return this;
    }
}
