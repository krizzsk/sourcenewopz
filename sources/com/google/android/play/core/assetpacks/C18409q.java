package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C18470br;
import com.google.android.play.core.internal.C18494co;

/* renamed from: com.google.android.play.core.assetpacks.q */
public final class C18409q implements C18494co<AssetPackManager> {

    /* renamed from: a */
    private final C18494co<C18401j> f53102a;

    /* renamed from: b */
    private final C18494co<Context> f53103b;

    public C18409q(C18494co<C18401j> coVar, C18494co<Context> coVar2) {
        this.f53102a = coVar;
        this.f53103b = coVar2;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo148801a() {
        C18401j a = this.f53102a.mo148801a();
        Context b = ((C18411s) this.f53103b).mo148801a();
        C18401j jVar = a;
        C18470br.m37852a(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.m37733a(b);
        C18470br.m37859b(jVar);
        return jVar;
    }
}
