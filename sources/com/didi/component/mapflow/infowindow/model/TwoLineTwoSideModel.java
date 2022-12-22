package com.didi.component.mapflow.infowindow.model;

public class TwoLineTwoSideModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private SubMessage f14244a;

    /* renamed from: b */
    private SubMessage f14245b;

    /* renamed from: c */
    private SubMessage f14246c;

    /* renamed from: d */
    private SubMessage f14247d;

    /* renamed from: e */
    private boolean f14248e;

    public boolean isShowArrow() {
        return this.f14248e;
    }

    public void setShowArrow(boolean z) {
        this.f14248e = z;
    }

    public SubMessage getLeftTop() {
        return this.f14244a;
    }

    public void setLeftTop(SubMessage subMessage) {
        this.f14244a = subMessage;
    }

    public SubMessage getLeftBottom() {
        return this.f14245b;
    }

    public void setLeftBottom(SubMessage subMessage) {
        this.f14245b = subMessage;
    }

    public SubMessage getRightTop() {
        return this.f14246c;
    }

    public void setRightTop(SubMessage subMessage) {
        this.f14246c = subMessage;
    }

    public SubMessage getRightBottom() {
        return this.f14247d;
    }

    public void setRightBottom(SubMessage subMessage) {
        this.f14247d = subMessage;
    }
}
