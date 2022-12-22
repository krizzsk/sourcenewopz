package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

public class Highlight {

    /* renamed from: a */
    private float f52418a;

    /* renamed from: b */
    private float f52419b;

    /* renamed from: c */
    private float f52420c;

    /* renamed from: d */
    private float f52421d;

    /* renamed from: e */
    private int f52422e;

    /* renamed from: f */
    private int f52423f;

    /* renamed from: g */
    private int f52424g;

    /* renamed from: h */
    private YAxis.AxisDependency f52425h;

    /* renamed from: i */
    private float f52426i;

    /* renamed from: j */
    private float f52427j;

    public Highlight(float f, float f2, int i) {
        this.f52418a = Float.NaN;
        this.f52419b = Float.NaN;
        this.f52422e = -1;
        this.f52424g = -1;
        this.f52418a = f;
        this.f52419b = f2;
        this.f52423f = i;
    }

    public Highlight(float f, int i, int i2) {
        this(f, Float.NaN, i);
        this.f52424g = i2;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.f52418a = Float.NaN;
        this.f52419b = Float.NaN;
        this.f52422e = -1;
        this.f52424g = -1;
        this.f52418a = f;
        this.f52419b = f2;
        this.f52420c = f3;
        this.f52421d = f4;
        this.f52423f = i;
        this.f52425h = axisDependency;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.f52424g = i2;
    }

    public float getX() {
        return this.f52418a;
    }

    public float getY() {
        return this.f52419b;
    }

    public float getXPx() {
        return this.f52420c;
    }

    public float getYPx() {
        return this.f52421d;
    }

    public int getDataIndex() {
        return this.f52422e;
    }

    public void setDataIndex(int i) {
        this.f52422e = i;
    }

    public int getDataSetIndex() {
        return this.f52423f;
    }

    public int getStackIndex() {
        return this.f52424g;
    }

    public boolean isStacked() {
        return this.f52424g >= 0;
    }

    public YAxis.AxisDependency getAxis() {
        return this.f52425h;
    }

    public void setDraw(float f, float f2) {
        this.f52426i = f;
        this.f52427j = f2;
    }

    public float getDrawX() {
        return this.f52426i;
    }

    public float getDrawY() {
        return this.f52427j;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.f52423f == highlight.f52423f && this.f52418a == highlight.f52418a && this.f52424g == highlight.f52424g && this.f52422e == highlight.f52422e;
    }

    public String toString() {
        return "Highlight, x: " + this.f52418a + ", y: " + this.f52419b + ", dataSetIndex: " + this.f52423f + ", stackIndex (only stacked barentry): " + this.f52424g;
    }
}
