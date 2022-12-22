package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IExperiment;
import com.dmap.navigation.jni.swig.ApolloExperiment;

/* renamed from: com.dmap.navigation.engine.a.s */
/* compiled from: NavApolloExperiment */
public final class C17408s extends ApolloExperiment {

    /* renamed from: a */
    private IExperiment f51845a = null;

    public C17408s(IExperiment iExperiment) {
        this.f51845a = iExperiment;
    }

    public final int getParam(byte[] bArr, int i) {
        return ((Integer) m37048a(bArr, Integer.valueOf(i))).intValue();
    }

    public final float getParam(byte[] bArr, float f) {
        return ((Float) m37048a(bArr, Float.valueOf(f))).floatValue();
    }

    public final String getParam(byte[] bArr, String str) {
        return (String) m37048a(bArr, str);
    }

    /* renamed from: a */
    private <T> T m37048a(byte[] bArr, T t) {
        if (bArr == null || this.f51845a == null) {
            return null;
        }
        return this.f51845a.getParam(new String(bArr), t);
    }
}
