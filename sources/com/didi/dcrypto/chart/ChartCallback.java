package com.didi.dcrypto.chart;

public interface ChartCallback {
    void onInitChart();

    void onReceiveData(String str, String str2);

    void onResetChart();
}
