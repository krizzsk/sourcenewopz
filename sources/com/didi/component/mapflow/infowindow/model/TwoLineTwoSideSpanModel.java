package com.didi.component.mapflow.infowindow.model;

public class TwoLineTwoSideSpanModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private CharSequence f14249a;

    /* renamed from: b */
    private CharSequence f14250b;

    /* renamed from: c */
    private CharSequence f14251c;

    /* renamed from: d */
    private CharSequence f14252d;

    /* renamed from: e */
    private boolean f14253e;

    public boolean isShowArrow() {
        return this.f14253e;
    }

    public void setShowArrow(boolean z) {
        this.f14253e = z;
    }

    public CharSequence getLeftTop() {
        return this.f14249a;
    }

    public void setLeftTop(CharSequence charSequence) {
        this.f14249a = charSequence;
    }

    public CharSequence getLeftBottom() {
        return this.f14250b;
    }

    public void setLeftBottom(CharSequence charSequence) {
        this.f14250b = charSequence;
    }

    public CharSequence getRightTop() {
        return this.f14251c;
    }

    public void setRightTop(CharSequence charSequence) {
        this.f14251c = charSequence;
    }

    public CharSequence getRightBottom() {
        return this.f14252d;
    }

    public void setRightBottom(CharSequence charSequence) {
        this.f14252d = charSequence;
    }
}
