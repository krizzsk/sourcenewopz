package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {

    /* renamed from: a */
    private float f52388a = 0.0f;

    /* renamed from: b */
    private boolean f52389b;

    /* renamed from: c */
    private float f52390c = 18.0f;

    /* renamed from: d */
    private ValuePosition f52391d = ValuePosition.INSIDE_SLICE;

    /* renamed from: e */
    private ValuePosition f52392e = ValuePosition.INSIDE_SLICE;

    /* renamed from: f */
    private boolean f52393f = false;

    /* renamed from: g */
    private int f52394g = -16777216;

    /* renamed from: h */
    private float f52395h = 1.0f;

    /* renamed from: i */
    private float f52396i = 75.0f;

    /* renamed from: j */
    private float f52397j = 0.3f;

    /* renamed from: k */
    private float f52398k = 0.4f;

    /* renamed from: l */
    private boolean f52399l = true;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
    }

    public DataSet<PieEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((PieEntry) this.mValues.get(i)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        copy(pieDataSet);
        return pieDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(PieDataSet pieDataSet) {
        super.copy(pieDataSet);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(PieEntry pieEntry) {
        if (pieEntry != null) {
            calcMinMaxY(pieEntry);
        }
    }

    public void setSliceSpace(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f52388a = Utils.convertDpToPixel(f);
    }

    public float getSliceSpace() {
        return this.f52388a;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean z) {
        this.f52389b = z;
    }

    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.f52389b;
    }

    public void setSelectionShift(float f) {
        this.f52390c = Utils.convertDpToPixel(f);
    }

    public float getSelectionShift() {
        return this.f52390c;
    }

    public ValuePosition getXValuePosition() {
        return this.f52391d;
    }

    public void setXValuePosition(ValuePosition valuePosition) {
        this.f52391d = valuePosition;
    }

    public ValuePosition getYValuePosition() {
        return this.f52392e;
    }

    public void setYValuePosition(ValuePosition valuePosition) {
        this.f52392e = valuePosition;
    }

    public boolean isUsingSliceColorAsValueLineColor() {
        return this.f52393f;
    }

    public void setUsingSliceColorAsValueLineColor(boolean z) {
        this.f52393f = z;
    }

    public int getValueLineColor() {
        return this.f52394g;
    }

    public void setValueLineColor(int i) {
        this.f52394g = i;
    }

    public float getValueLineWidth() {
        return this.f52395h;
    }

    public void setValueLineWidth(float f) {
        this.f52395h = f;
    }

    public float getValueLinePart1OffsetPercentage() {
        return this.f52396i;
    }

    public void setValueLinePart1OffsetPercentage(float f) {
        this.f52396i = f;
    }

    public float getValueLinePart1Length() {
        return this.f52397j;
    }

    public void setValueLinePart1Length(float f) {
        this.f52397j = f;
    }

    public float getValueLinePart2Length() {
        return this.f52398k;
    }

    public void setValueLinePart2Length(float f) {
        this.f52398k = f;
    }

    public boolean isValueLineVariableLength() {
        return this.f52399l;
    }

    public void setValueLineVariableLength(boolean z) {
        this.f52399l = z;
    }
}
