package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {

    /* renamed from: a */
    private int f52384a = Color.rgb(140, 234, 255);

    /* renamed from: b */
    private int f52385b = 85;

    /* renamed from: c */
    private float f52386c = 2.5f;

    /* renamed from: d */
    private boolean f52387d = false;
    protected Drawable mFillDrawable;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
    }

    public int getFillColor() {
        return this.f52384a;
    }

    public void setFillColor(int i) {
        this.f52384a = i;
        this.mFillDrawable = null;
    }

    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public void setFillDrawable(Drawable drawable) {
        this.mFillDrawable = drawable;
    }

    public int getFillAlpha() {
        return this.f52385b;
    }

    public void setFillAlpha(int i) {
        this.f52385b = i;
    }

    public void setLineWidth(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.f52386c = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.f52386c;
    }

    public void setDrawFilled(boolean z) {
        this.f52387d = z;
    }

    public boolean isDrawFilledEnabled() {
        return this.f52387d;
    }

    /* access modifiers changed from: protected */
    public void copy(LineRadarDataSet lineRadarDataSet) {
        super.copy(lineRadarDataSet);
        lineRadarDataSet.f52387d = this.f52387d;
        lineRadarDataSet.f52385b = this.f52385b;
        lineRadarDataSet.f52384a = this.f52384a;
        lineRadarDataSet.mFillDrawable = this.mFillDrawable;
        lineRadarDataSet.f52386c = this.f52386c;
    }
}
