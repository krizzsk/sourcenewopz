package com.didi.dcrypto.model;

import java.util.Date;

public class GraphDataPoint {
    public Date date;

    /* renamed from: x */
    public float f16483x;

    /* renamed from: y */
    public float f16484y;

    public GraphDataPoint(float f, float f2, Date date2) {
        this.f16483x = f;
        this.f16484y = f2;
        this.date = date2;
    }
}
