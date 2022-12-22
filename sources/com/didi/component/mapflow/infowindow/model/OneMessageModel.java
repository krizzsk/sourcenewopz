package com.didi.component.mapflow.infowindow.model;

import android.text.SpannableString;

public class OneMessageModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private String f14236a;

    /* renamed from: b */
    private SpannableString f14237b;

    /* renamed from: c */
    private boolean f14238c;

    /* renamed from: d */
    private int f14239d;

    public boolean isShowArrow() {
        return this.f14238c;
    }

    public void setShowArrow(boolean z) {
        this.f14238c = z;
    }

    public String getContent() {
        return this.f14236a;
    }

    public void setContent(String str) {
        this.f14236a = str;
    }

    public SpannableString getCustomContent() {
        return this.f14237b;
    }

    public void setCustomContent(SpannableString spannableString) {
        this.f14237b = spannableString;
    }

    public int getBgImageId() {
        return this.f14239d;
    }

    public void setBgImageId(int i) {
        this.f14239d = i;
    }
}
