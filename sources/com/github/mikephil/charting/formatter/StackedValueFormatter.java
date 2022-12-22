package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private boolean f52415a;

    /* renamed from: b */
    private String f52416b;

    /* renamed from: c */
    private DecimalFormat f52417c;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.f52415a = z;
        this.f52416b = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f52417c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        if (this.f52415a || (yVals = barEntry.getYVals()) == null) {
            return this.f52417c.format((double) f) + this.f52416b;
        } else if (yVals[yVals.length - 1] != f) {
            return "";
        } else {
            return this.f52417c.format((double) barEntry.getY()) + this.f52416b;
        }
    }
}
