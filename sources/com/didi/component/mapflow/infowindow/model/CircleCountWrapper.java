package com.didi.component.mapflow.infowindow.model;

import com.didi.component.mapflow.infowindow.callback.CountDownCallback;

public class CircleCountWrapper {

    /* renamed from: a */
    private String f14208a;

    /* renamed from: b */
    private CircleCountDownModel f14209b;

    /* renamed from: c */
    private int f14210c;

    /* renamed from: d */
    private int f14211d;

    /* renamed from: e */
    private CountDownCallback f14212e;

    public CircleCountWrapper(String str, CircleCountDownModel circleCountDownModel, int i, int i2, CountDownCallback countDownCallback) {
        this.f14208a = str;
        this.f14209b = circleCountDownModel;
        this.f14210c = i;
        this.f14211d = i2;
        this.f14212e = countDownCallback;
    }

    public String getTag() {
        return this.f14208a;
    }

    public CircleCountDownModel getModel() {
        return this.f14209b;
    }

    public int getCount() {
        return this.f14210c;
    }

    public int getInitCount() {
        return this.f14211d;
    }

    public CountDownCallback getCallback() {
        return this.f14212e;
    }

    public String toString() {
        return "CircleCountWrapper{tag='" + this.f14208a + '\'' + ", model=" + this.f14209b + ", count=" + this.f14210c + ", initCount=" + this.f14211d + ", callback=" + this.f14212e + '}';
    }
}
