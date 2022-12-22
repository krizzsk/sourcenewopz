package com.didi.sdk.format;

public interface IDiDiFormat {
    String formatCurrency(float f);

    String formatNumber(double d);

    String formatNumber(double d, int i);

    String formatNumber(float f);

    String formatNumber(float f, int i);

    String formatNumber(int i);

    String formatNumber(long j);

    String formatNumber(String str);
}
