package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class LimitLine extends ComponentBase {

    /* renamed from: a */
    private float f52312a = 0.0f;

    /* renamed from: b */
    private float f52313b = 2.0f;

    /* renamed from: c */
    private int f52314c = Color.rgb(237, 91, 91);

    /* renamed from: d */
    private Paint.Style f52315d = Paint.Style.FILL_AND_STROKE;

    /* renamed from: e */
    private String f52316e = "";

    /* renamed from: f */
    private DashPathEffect f52317f = null;

    /* renamed from: g */
    private LimitLabelPosition f52318g = LimitLabelPosition.RIGHT_TOP;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f) {
        this.f52312a = f;
    }

    public LimitLine(float f, String str) {
        this.f52312a = f;
        this.f52316e = str;
    }

    public float getLimit() {
        return this.f52312a;
    }

    public void setLineWidth(float f) {
        if (f < 0.2f) {
            f = 0.2f;
        }
        if (f > 12.0f) {
            f = 12.0f;
        }
        this.f52313b = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.f52313b;
    }

    public void setLineColor(int i) {
        this.f52314c = i;
    }

    public int getLineColor() {
        return this.f52314c;
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.f52317f = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.f52317f = null;
    }

    public boolean isDashedLineEnabled() {
        return this.f52317f != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.f52317f;
    }

    public void setTextStyle(Paint.Style style) {
        this.f52315d = style;
    }

    public Paint.Style getTextStyle() {
        return this.f52315d;
    }

    public void setLabelPosition(LimitLabelPosition limitLabelPosition) {
        this.f52318g = limitLabelPosition;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.f52318g;
    }

    public void setLabel(String str) {
        this.f52316e = str;
    }

    public String getLabel() {
        return this.f52316e;
    }
}
