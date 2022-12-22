package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {

    /* renamed from: a */
    private Mode f52374a = Mode.LINEAR;

    /* renamed from: b */
    private List<Integer> f52375b = null;

    /* renamed from: c */
    private int f52376c = -1;

    /* renamed from: d */
    private float f52377d = 8.0f;

    /* renamed from: e */
    private float f52378e = 4.0f;

    /* renamed from: f */
    private float f52379f = 0.2f;

    /* renamed from: g */
    private DashPathEffect f52380g = null;

    /* renamed from: h */
    private IFillFormatter f52381h = new DefaultFillFormatter();

    /* renamed from: i */
    private boolean f52382i = true;

    /* renamed from: j */
    private boolean f52383j = true;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        if (this.f52375b == null) {
            this.f52375b = new ArrayList();
        }
        this.f52375b.clear();
        this.f52375b.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((Entry) this.mValues.get(i)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        copy(lineDataSet);
        return lineDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(LineDataSet lineDataSet) {
        super.copy(lineDataSet);
        lineDataSet.f52375b = this.f52375b;
        lineDataSet.f52376c = this.f52376c;
        lineDataSet.f52378e = this.f52378e;
        lineDataSet.f52377d = this.f52377d;
        lineDataSet.f52379f = this.f52379f;
        lineDataSet.f52380g = this.f52380g;
        lineDataSet.f52383j = this.f52383j;
        lineDataSet.f52382i = this.f52383j;
        lineDataSet.f52381h = this.f52381h;
        lineDataSet.f52374a = this.f52374a;
    }

    public Mode getMode() {
        return this.f52374a;
    }

    public void setMode(Mode mode) {
        this.f52374a = mode;
    }

    public void setCubicIntensity(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.05f) {
            f = 0.05f;
        }
        this.f52379f = f;
    }

    public float getCubicIntensity() {
        return this.f52379f;
    }

    public void setCircleRadius(float f) {
        if (f >= 1.0f) {
            this.f52377d = Utils.convertDpToPixel(f);
        } else {
            SystemUtils.log(6, "LineDataSet", "Circle radius cannot be < 1", (Throwable) null, "com.github.mikephil.charting.data.LineDataSet", 162);
        }
    }

    public float getCircleRadius() {
        return this.f52377d;
    }

    public void setCircleHoleRadius(float f) {
        if (f >= 0.5f) {
            this.f52378e = Utils.convertDpToPixel(f);
        } else {
            SystemUtils.log(6, "LineDataSet", "Circle radius cannot be < 0.5", (Throwable) null, "com.github.mikephil.charting.data.LineDataSet", 182);
        }
    }

    public float getCircleHoleRadius() {
        return this.f52378e;
    }

    @Deprecated
    public void setCircleSize(float f) {
        setCircleRadius(f);
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.f52380g = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.f52380g = null;
    }

    public boolean isDashedLineEnabled() {
        return this.f52380g != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.f52380g;
    }

    public void setDrawCircles(boolean z) {
        this.f52382i = z;
    }

    public boolean isDrawCirclesEnabled() {
        return this.f52382i;
    }

    @Deprecated
    public boolean isDrawCubicEnabled() {
        return this.f52374a == Mode.CUBIC_BEZIER;
    }

    @Deprecated
    public boolean isDrawSteppedEnabled() {
        return this.f52374a == Mode.STEPPED;
    }

    public List<Integer> getCircleColors() {
        return this.f52375b;
    }

    public int getCircleColor(int i) {
        return this.f52375b.get(i).intValue();
    }

    public int getCircleColorCount() {
        return this.f52375b.size();
    }

    public void setCircleColors(List<Integer> list) {
        this.f52375b = list;
    }

    public void setCircleColors(int... iArr) {
        this.f52375b = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        List<Integer> list = this.f52375b;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int color : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.f52375b = list;
    }

    public void setCircleColor(int i) {
        resetCircleColors();
        this.f52375b.add(Integer.valueOf(i));
    }

    public void resetCircleColors() {
        if (this.f52375b == null) {
            this.f52375b = new ArrayList();
        }
        this.f52375b.clear();
    }

    public void setCircleHoleColor(int i) {
        this.f52376c = i;
    }

    public int getCircleHoleColor() {
        return this.f52376c;
    }

    public void setDrawCircleHole(boolean z) {
        this.f52383j = z;
    }

    public boolean isDrawCircleHoleEnabled() {
        return this.f52383j;
    }

    public void setFillFormatter(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            this.f52381h = new DefaultFillFormatter();
        } else {
            this.f52381h = iFillFormatter;
        }
    }

    public IFillFormatter getFillFormatter() {
        return this.f52381h;
    }
}
