package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.didi.sdk.apm.SystemUtils;

public class PieEntry extends Entry {

    /* renamed from: a */
    private String f52400a;

    public PieEntry(float f) {
        super(0.0f, f);
    }

    public PieEntry(float f, Object obj) {
        super(0.0f, f, obj);
    }

    public PieEntry(float f, Drawable drawable) {
        super(0.0f, f, drawable);
    }

    public PieEntry(float f, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
    }

    public PieEntry(float f, String str) {
        super(0.0f, f);
        this.f52400a = str;
    }

    public PieEntry(float f, String str, Object obj) {
        super(0.0f, f, obj);
        this.f52400a = str;
    }

    public PieEntry(float f, String str, Drawable drawable) {
        super(0.0f, f, drawable);
        this.f52400a = str;
    }

    public PieEntry(float f, String str, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
        this.f52400a = str;
    }

    public float getValue() {
        return getY();
    }

    public String getLabel() {
        return this.f52400a;
    }

    public void setLabel(String str) {
        this.f52400a = str;
    }

    @Deprecated
    public void setX(float f) {
        super.setX(f);
        SystemUtils.log(4, "DEPRECATED", "Pie entries do not have x values", (Throwable) null, "com.github.mikephil.charting.data.PieEntry", 72);
    }

    @Deprecated
    public float getX() {
        SystemUtils.log(4, "DEPRECATED", "Pie entries do not have x values", (Throwable) null, "com.github.mikephil.charting.data.PieEntry", 78);
        return super.getX();
    }

    public PieEntry copy() {
        return new PieEntry(getY(), this.f52400a, getData());
    }
}
