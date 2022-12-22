package com.github.mikephil.charting.formatter;

import com.didi.raven.config.RavenKey;
import java.text.DecimalFormat;

public class LargeValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private String[] f52410a;

    /* renamed from: b */
    private int f52411b;

    /* renamed from: c */
    private DecimalFormat f52412c;

    /* renamed from: d */
    private String f52413d;

    public int getDecimalDigits() {
        return 0;
    }

    public LargeValueFormatter() {
        this.f52410a = new String[]{"", "k", "m", "b", RavenKey.TYPE};
        this.f52411b = 5;
        this.f52413d = "";
        this.f52412c = new DecimalFormat("###E00");
    }

    public LargeValueFormatter(String str) {
        this();
        this.f52413d = str;
    }

    public String getFormattedValue(float f) {
        return m37270a((double) f) + this.f52413d;
    }

    public void setAppendix(String str) {
        this.f52413d = str;
    }

    public void setSuffix(String[] strArr) {
        this.f52410a = strArr;
    }

    public void setMaxLength(int i) {
        this.f52411b = i;
    }

    /* renamed from: a */
    private String m37270a(double d) {
        String format = this.f52412c.format(d);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f52410a[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.f52411b && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }
}
