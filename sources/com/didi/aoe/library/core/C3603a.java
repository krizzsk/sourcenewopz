package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.core.AoeClient;

/* renamed from: com.didi.aoe.library.core.a */
/* compiled from: AbsProcessorWrapper */
abstract class C3603a implements AoeProcessor, AoeProcessor.InterpreterComponent<Object, Object>, AoeProcessor.ParcelComponent {

    /* renamed from: a */
    final Context f8181a;

    public Object byte2Obj(byte[] bArr) {
        return null;
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return null;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return null;
    }

    public byte[] obj2Byte(Object obj) {
        return new byte[0];
    }

    public void setId(String str) {
    }

    C3603a(Context context, AoeClient.Options options) {
        this.f8181a = context;
    }

    public boolean isReady() {
        return getInterpreterComponent().isReady();
    }
}
