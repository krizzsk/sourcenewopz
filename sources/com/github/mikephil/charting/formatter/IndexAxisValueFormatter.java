package com.github.mikephil.charting.formatter;

import java.util.Collection;

public class IndexAxisValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private String[] f52408a = new String[0];

    /* renamed from: b */
    private int f52409b = 0;

    public IndexAxisValueFormatter() {
    }

    public IndexAxisValueFormatter(String[] strArr) {
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }

    public String getFormattedValue(float f) {
        int round = Math.round(f);
        return (round < 0 || round >= this.f52409b || round != ((int) f)) ? "" : this.f52408a[round];
    }

    public String[] getValues() {
        return this.f52408a;
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f52408a = strArr;
        this.f52409b = strArr.length;
    }
}
