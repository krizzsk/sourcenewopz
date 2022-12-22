package com.didi.component.mapflow.infowindow.model;

public class OneLineTwoMessageModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private SubMessage f14233a;

    /* renamed from: b */
    private SubMessage f14234b;

    /* renamed from: c */
    private boolean f14235c;

    public boolean isShowArrow() {
        return this.f14235c;
    }

    public void setShowArrow(boolean z) {
        this.f14235c = z;
    }

    public SubMessage getLeftMessage() {
        return this.f14233a;
    }

    public void setLeftMessage(SubMessage subMessage) {
        this.f14233a = subMessage;
    }

    public SubMessage getRightMessage() {
        return this.f14234b;
    }

    public void setRightMessage(SubMessage subMessage) {
        this.f14234b = subMessage;
    }
}
