package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {

    /* renamed from: a */
    private int f52338a = 1;

    /* renamed from: b */
    private int f52339b = Color.rgb(215, 215, 215);

    /* renamed from: c */
    private float f52340c = 0.0f;

    /* renamed from: d */
    private int f52341d = -16777216;

    /* renamed from: e */
    private int f52342e = 120;

    /* renamed from: f */
    private int f52343f = 0;

    /* renamed from: g */
    private String[] f52344g = {"Stack"};

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.mHighLightColor = Color.rgb(0, 0, 0);
        m37265b(list);
        m37264a(list);
    }

    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((BarEntry) this.mValues.get(i)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        copy(barDataSet);
        return barDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(BarDataSet barDataSet) {
        super.copy(barDataSet);
        barDataSet.f52338a = this.f52338a;
        barDataSet.f52339b = this.f52339b;
        barDataSet.f52340c = this.f52340c;
        barDataSet.f52344g = this.f52344g;
        barDataSet.f52342e = this.f52342e;
    }

    /* renamed from: a */
    private void m37264a(List<BarEntry> list) {
        this.f52343f = 0;
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = list.get(i).getYVals();
            if (yVals == null) {
                this.f52343f++;
            } else {
                this.f52343f += yVals.length;
            }
        }
    }

    /* renamed from: b */
    private void m37265b(List<BarEntry> list) {
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = list.get(i).getYVals();
            if (yVals != null && yVals.length > this.f52338a) {
                this.f52338a = yVals.length;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(BarEntry barEntry) {
        if (barEntry != null && !Float.isNaN(barEntry.getY())) {
            if (barEntry.getYVals() == null) {
                if (barEntry.getY() < this.mYMin) {
                    this.mYMin = barEntry.getY();
                }
                if (barEntry.getY() > this.mYMax) {
                    this.mYMax = barEntry.getY();
                }
            } else {
                if ((-barEntry.getNegativeSum()) < this.mYMin) {
                    this.mYMin = -barEntry.getNegativeSum();
                }
                if (barEntry.getPositiveSum() > this.mYMax) {
                    this.mYMax = barEntry.getPositiveSum();
                }
            }
            calcMinMaxX(barEntry);
        }
    }

    public int getStackSize() {
        return this.f52338a;
    }

    public boolean isStacked() {
        return this.f52338a > 1;
    }

    public int getEntryCountStacks() {
        return this.f52343f;
    }

    public void setBarShadowColor(int i) {
        this.f52339b = i;
    }

    public int getBarShadowColor() {
        return this.f52339b;
    }

    public void setBarBorderWidth(float f) {
        this.f52340c = f;
    }

    public float getBarBorderWidth() {
        return this.f52340c;
    }

    public void setBarBorderColor(int i) {
        this.f52341d = i;
    }

    public int getBarBorderColor() {
        return this.f52341d;
    }

    public void setHighLightAlpha(int i) {
        this.f52342e = i;
    }

    public int getHighLightAlpha() {
        return this.f52342e;
    }

    public void setStackLabels(String[] strArr) {
        this.f52344g = strArr;
    }

    public String[] getStackLabels() {
        return this.f52344g;
    }
}
