package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C19775const;
import java.util.List;
import p232do.C20822goto;
import p234final.C20833if;

/* renamed from: com.iproov.sdk.core.goto */
/* compiled from: IProovCameraZoomSelector */
public class C19888goto implements C20822goto {

    /* renamed from: a */
    private final C20833if f54259a;

    /* renamed from: b */
    private Double f54260b;

    C19888goto(C20833if ifVar) {
        this.f54259a = ifVar;
    }

    /* renamed from: a */
    private double m39103a(C19775const constR, Float f, Double d) {
        this.f54260b = d;
        String.format("Zoom Selector (%s) zoom factor as %.1f given focal length of %.1f", new Object[]{constR, d, f});
        return d.doubleValue();
    }

    /* renamed from: a */
    private Double m39104a(C19775const constR, Float f) {
        if (this.f54259a.m47641for() == null) {
            return Double.valueOf(1.0d);
        }
        String.format("Zoom Selector has zoom factor provided by device profile as %.1f", new Object[]{this.f54259a.m47641for()});
        return this.f54259a.m47641for();
    }

    /* renamed from: do */
    public synchronized Double mo162093do() {
        return this.f54260b;
    }

    /* renamed from: do */
    public synchronized double mo162091do(C19775const constR, Float f) {
        if (this.f54260b == null) {
            Double a = m39104a(constR, f);
            this.f54260b = a;
            m39103a(constR, f, a);
        }
        return this.f54260b.doubleValue();
    }

    /* renamed from: do */
    public synchronized int mo162092do(C19775const constR, Float f, List<Integer> list) {
        int doubleValue = (int) (m39104a(constR, f).doubleValue() * 100.0d);
        int i = 0;
        while (i < list.size()) {
            Integer num = list.get(i);
            if (num == null || num.intValue() < doubleValue) {
                i++;
            } else {
                m39103a(constR, f, Double.valueOf(Double.valueOf((double) num.intValue()).doubleValue() / 100.0d));
                return i;
            }
        }
        m39103a(constR, f, (Double) null);
        return -1;
    }
}
