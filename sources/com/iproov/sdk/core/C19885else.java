package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C19775const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p232do.C20817break;
import p232do.C20826try;

/* renamed from: com.iproov.sdk.core.else */
/* compiled from: IProovCameraPreviewSizeSelector */
public class C19885else implements C20826try {
    /* renamed from: b */
    private static int m39095b(C20817break breakR) {
        return breakR.mo170632if() * breakR.mo170629do();
    }

    /* renamed from: do */
    public C20817break mo162071do(C19775const constR, List<C20817break> list) {
        return m39093a(m39094a(list, 640, 480, 0.7d)).get(0);
    }

    /* renamed from: a */
    private static List<C20817break> m39093a(List<C20817break> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, $$Lambda$else$VUKPLJQ5bqnPBqLltDQhsfJtGYM.INSTANCE);
        return arrayList;
    }

    /* renamed from: a */
    private static double m39091a(C20817break breakR) {
        return ((double) breakR.mo170629do()) / ((double) breakR.mo170632if());
    }

    /* renamed from: a */
    private static List<C20817break> m39094a(List<C20817break> list, int i, int i2, double d) {
        ArrayList arrayList = new ArrayList();
        for (C20817break next : list) {
            if (next.mo170632if() >= i && next.mo170629do() >= i2 && m39091a(next) >= d) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
