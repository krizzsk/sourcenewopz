package com.didi.sdk.format;

import java.util.Locale;

/* renamed from: com.didi.sdk.format.a */
/* compiled from: AbsDiDiFormatImpl */
abstract class C12209a implements IDiDiFormat {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Locale mo91765a();

    C12209a() {
    }

    public String formatCurrency(float f) {
        return String.format(mo91765a(), "%.2f", new Object[]{Float.valueOf(f)});
    }

    public String formatNumber(int i) {
        return String.format(mo91765a(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
    }

    public String formatNumber(float f) {
        return String.format(mo91765a(), "%.2f", new Object[]{Float.valueOf(f)});
    }

    public String formatNumber(double d) {
        return String.format(mo91765a(), "%.2f", new Object[]{Double.valueOf(d)});
    }

    public String formatNumber(long j) {
        return String.format(mo91765a(), TimeModel.NUMBER_FORMAT, new Object[]{Long.valueOf(j)});
    }

    public String formatNumber(float f, int i) {
        Locale a = mo91765a();
        return String.format(a, "%." + i + "f", new Object[]{Float.valueOf(f)});
    }

    public String formatNumber(double d, int i) {
        Locale a = mo91765a();
        return String.format(a, "%." + i + "f", new Object[]{Double.valueOf(d)});
    }

    public String formatNumber(String str) {
        return String.format(mo91765a(), str, new Object[0]);
    }
}
