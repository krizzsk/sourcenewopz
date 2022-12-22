package com.didiglobal.privacysdk;

import com.taxis99.R;

public class GlobalPrivacyThemeOptions {

    /* renamed from: a */
    private int f50589a = -1;

    /* renamed from: b */
    private int f50590b = -16777216;

    /* renamed from: c */
    private int f50591c = R.drawable.global_privacy_img_back_normal;

    /* renamed from: d */
    private int f50592d = R.drawable.common_title_bar_btn_back_selector;

    /* renamed from: e */
    private boolean f50593e = false;

    /* renamed from: f */
    private boolean f50594f = true;

    /* renamed from: g */
    private boolean f50595g = false;

    /* renamed from: h */
    private int f50596h = -32959;

    public int getTitleBarBgColor() {
        return this.f50589a;
    }

    public GlobalPrivacyThemeOptions setTitleBarBgColor(int i) {
        this.f50589a = i;
        return this;
    }

    public int getTitleBarTitleColor() {
        return this.f50590b;
    }

    public GlobalPrivacyThemeOptions setTitleBarTitleColor(int i) {
        this.f50590b = i;
        return this;
    }

    public int getTitleBarLeftImgRes() {
        return this.f50591c;
    }

    public GlobalPrivacyThemeOptions setTitleBarLeftImgRes(int i) {
        this.f50591c = i;
        return this;
    }

    public int getTitleBarSmallLeftImgRes() {
        return this.f50592d;
    }

    public GlobalPrivacyThemeOptions setTitleBarSmallLeftImgRes(int i) {
        this.f50592d = i;
        return this;
    }

    public boolean isUseTitleBarSmallLeftImg() {
        return this.f50593e;
    }

    public GlobalPrivacyThemeOptions setUseTitleBarSmallLeftImg(boolean z) {
        this.f50593e = z;
        return this;
    }

    public boolean isTitleInCenter() {
        return this.f50594f;
    }

    public GlobalPrivacyThemeOptions setTitleInCenter(boolean z) {
        this.f50594f = z;
        return this;
    }

    public boolean isStatusBarBgLightning() {
        return this.f50595g;
    }

    public GlobalPrivacyThemeOptions setStatusBarBgLightning(boolean z) {
        this.f50595g = z;
        return this;
    }

    public int getSwitchColor() {
        return this.f50596h;
    }

    public GlobalPrivacyThemeOptions setSwitchColor(int i) {
        this.f50596h = i;
        return this;
    }
}
