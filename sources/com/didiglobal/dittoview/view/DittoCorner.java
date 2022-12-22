package com.didiglobal.dittoview.view;

public class DittoCorner {

    /* renamed from: a */
    private float f49910a;

    /* renamed from: b */
    private float f49911b;

    /* renamed from: c */
    private float f49912c;

    /* renamed from: d */
    private float f49913d;

    /* renamed from: e */
    private float f49914e;
    public boolean isEmpty = true;

    public void setCorners(float f) {
        this.isEmpty = false;
        this.f49910a = f;
        this.f49911b = f;
        this.f49912c = f;
        this.f49913d = f;
        this.f49914e = f;
    }

    public void setLeftTopCorner(float f) {
        this.isEmpty = false;
        this.f49910a = f;
    }

    public void setLeftBottomCorner(float f) {
        this.isEmpty = false;
        this.f49911b = f;
    }

    public void setRightTopCorner(float f) {
        this.isEmpty = false;
        this.f49912c = f;
    }

    public void setRightBottomCorner(float f) {
        this.isEmpty = false;
        this.f49913d = f;
    }

    public float getLeftTopCorner() {
        return this.f49910a;
    }

    public float getLeftBottomCorner() {
        return this.f49911b;
    }

    public float getRightTopCorner() {
        return this.f49912c;
    }

    public float getRightBottomCorner() {
        return this.f49913d;
    }

    public float getCornerRadius() {
        return this.f49914e;
    }
}
