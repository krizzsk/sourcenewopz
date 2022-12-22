package com.iproov.sdk.cameray;

import java.util.List;
import p232do.C20818case;

/* renamed from: com.iproov.sdk.cameray.final */
/* compiled from: CameraSpecs */
public class C19779final {

    /* renamed from: a */
    private final C19775const f54038a;

    /* renamed from: b */
    private final List<C20818case> f54039b;

    C19779final(C19775const constR, List<C20818case> list) {
        this.f54038a = constR;
        this.f54039b = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C20818case mo161916a() {
        if (mo161918if()) {
            return null;
        }
        return this.f54039b.get(0);
    }

    /* renamed from: if */
    public boolean mo161918if() {
        return this.f54039b.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (C20818case next : this.f54039b) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(next.toString());
        }
        return "CameraSpecs{cameraSDK=" + this.f54038a + ", cameras=[" + sb + "]}";
    }

    /* renamed from: do */
    public C20818case mo161917do(C19768break... breakArr) {
        for (C19768break breakR : breakArr) {
            for (C20818case next : this.f54039b) {
                if (next.mo170634do() == breakR) {
                    return next;
                }
            }
        }
        return null;
    }
}
