package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.au */
final /* synthetic */ class C18311au implements Runnable {

    /* renamed from: a */
    private final C18313aw f52766a;

    /* renamed from: b */
    private final Bundle f52767b;

    /* renamed from: c */
    private final AssetPackState f52768c;

    C18311au(C18313aw awVar, Bundle bundle, AssetPackState assetPackState) {
        this.f52766a = awVar;
        this.f52767b = bundle;
        this.f52768c = assetPackState;
    }

    public final void run() {
        this.f52766a.mo148902a(this.f52767b, this.f52768c);
    }
}
