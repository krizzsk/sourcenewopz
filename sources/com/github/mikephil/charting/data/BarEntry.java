package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

public class BarEntry extends Entry {

    /* renamed from: a */
    private float[] f52345a;

    /* renamed from: b */
    private Range[] f52346b;

    /* renamed from: c */
    private float f52347c;

    /* renamed from: d */
    private float f52348d;

    public BarEntry(float f, float f2) {
        super(f, f2);
    }

    public BarEntry(float f, float f2, Object obj) {
        super(f, f2, obj);
    }

    public BarEntry(float f, float f2, Drawable drawable) {
        super(f, f2, drawable);
    }

    public BarEntry(float f, float f2, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
    }

    public BarEntry(float f, float[] fArr) {
        super(f, m37266a(fArr));
        this.f52345a = fArr;
        m37267a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Object obj) {
        super(f, m37266a(fArr), obj);
        this.f52345a = fArr;
        m37267a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable) {
        super(f, m37266a(fArr), drawable);
        this.f52345a = fArr;
        m37267a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable, Object obj) {
        super(f, m37266a(fArr), drawable, obj);
        this.f52345a = fArr;
        m37267a();
        calcRanges();
    }

    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.f52345a);
        return barEntry;
    }

    public float[] getYVals() {
        return this.f52345a;
    }

    public void setVals(float[] fArr) {
        setY(m37266a(fArr));
        this.f52345a = fArr;
        m37267a();
        calcRanges();
    }

    public float getY() {
        return super.getY();
    }

    public Range[] getRanges() {
        return this.f52346b;
    }

    public boolean isStacked() {
        return this.f52345a != null;
    }

    @Deprecated
    public float getBelowSum(int i) {
        return getSumBelow(i);
    }

    public float getSumBelow(int i) {
        float[] fArr = this.f52345a;
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        while (length > i && length >= 0) {
            f += this.f52345a[length];
            length--;
        }
        return f;
    }

    public float getPositiveSum() {
        return this.f52348d;
    }

    public float getNegativeSum() {
        return this.f52347c;
    }

    /* renamed from: a */
    private void m37267a() {
        float[] fArr = this.f52345a;
        if (fArr == null) {
            this.f52347c = 0.0f;
            this.f52348d = 0.0f;
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : fArr) {
            if (f3 <= 0.0f) {
                f += Math.abs(f3);
            } else {
                f2 += f3;
            }
        }
        this.f52347c = f;
        this.f52348d = f2;
    }

    /* renamed from: a */
    private static float m37266a(float[] fArr) {
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    /* access modifiers changed from: protected */
    public void calcRanges() {
        float[] yVals = getYVals();
        if (yVals != null && yVals.length != 0) {
            this.f52346b = new Range[yVals.length];
            float f = -getNegativeSum();
            int i = 0;
            float f2 = 0.0f;
            while (true) {
                Range[] rangeArr = this.f52346b;
                if (i < rangeArr.length) {
                    float f3 = yVals[i];
                    if (f3 < 0.0f) {
                        float f4 = f - f3;
                        rangeArr[i] = new Range(f, f4);
                        f = f4;
                    } else {
                        float f5 = f3 + f2;
                        rangeArr[i] = new Range(f2, f5);
                        f2 = f5;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
