package com.didiglobal.p205sa.biz.component.sapanel.model;

import android.view.View;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.model.AnimationModel */
public class AnimationModel {

    /* renamed from: a */
    private View f51098a;

    /* renamed from: b */
    private int f51099b;

    /* renamed from: c */
    private float f51100c;

    /* renamed from: d */
    private boolean f51101d;

    /* renamed from: e */
    private int f51102e;

    public AnimationModel() {
    }

    public AnimationModel(View view, int i, float f, boolean z, int i2) {
        this.f51098a = view;
        this.f51099b = i;
        this.f51100c = f;
        this.f51101d = z;
        this.f51102e = i2;
    }

    public void setTarget(View view) {
        this.f51098a = view;
    }

    public void setProcess(int i) {
        this.f51099b = i;
    }

    public void setFraction(float f) {
        this.f51100c = f;
    }

    public void setExpand(boolean z) {
        this.f51101d = z;
    }

    public void setType(int i) {
        this.f51102e = i;
    }

    public View getTarget() {
        return this.f51098a;
    }

    public int getProcess() {
        return this.f51099b;
    }

    public float getFraction() {
        return this.f51100c;
    }

    public boolean isExpand() {
        return this.f51101d;
    }

    public int getType() {
        return this.f51102e;
    }
}
