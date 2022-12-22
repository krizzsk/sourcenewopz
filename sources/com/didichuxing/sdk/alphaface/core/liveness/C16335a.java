package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.a */
/* compiled from: AbsDetect */
abstract class C16335a<Out> {

    /* renamed from: a */
    protected final AlphaFaceNativeProxy f48715a;

    /* renamed from: b */
    protected final C16337c f48716b;

    /* renamed from: c */
    protected final LivenessConfig f48717c;

    /* renamed from: d */
    protected final LivenessManager f48718d;

    /* renamed from: e */
    protected C16335a f48719e;

    /* renamed from: a */
    public abstract Out mo120633a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo120636b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    /* renamed from: b */
    public abstract boolean mo120637b();

    /* renamed from: c */
    public abstract void mo120638c();

    public C16335a(LivenessManager livenessManager) {
        this.f48718d = livenessManager;
        this.f48715a = livenessManager.mo120616a();
        this.f48717c = livenessManager.mo120617b();
        this.f48716b = livenessManager.mo120618c();
    }

    /* renamed from: a */
    public void mo120634a(C16335a aVar) {
        this.f48719e = aVar;
    }

    /* renamed from: a */
    public final void mo120635a(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        if (mo120637b()) {
            C16335a aVar = this.f48719e;
            if (aVar != null) {
                aVar.mo120636b(bArr, i, i2, i3, f, f2, f3);
                return;
            }
        }
        mo120636b(bArr, i, i2, i3, f, f2, f3);
    }

    /* renamed from: d */
    public void mo120639d() {
        for (C16335a aVar = this; aVar != null; aVar = aVar.f48719e) {
            aVar.mo120638c();
        }
    }
}
