package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18478bz;
import com.google.android.play.core.internal.C18514w;
import com.google.android.play.core.internal.C18517z;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.b */
final class C18317b extends C18514w {

    /* renamed from: a */
    private final C18432ag f52790a = new C18432ag("AssetPackExtractionService");

    /* renamed from: b */
    private final Context f52791b;

    /* renamed from: c */
    private final AssetPackExtractionService f52792c;

    /* renamed from: d */
    private final C18319bb f52793d;

    C18317b(Context context, AssetPackExtractionService assetPackExtractionService, C18319bb bbVar) {
        this.f52791b = context;
        this.f52792c = assetPackExtractionService;
        this.f52793d = bbVar;
    }

    /* renamed from: a */
    public final void mo148905a(Bundle bundle, C18517z zVar) throws RemoteException {
        String[] packagesForUid;
        this.f52790a.mo149081a("updateServiceState AIDL call", new Object[0]);
        if (!C18478bz.m37892a(this.f52791b) || (packagesForUid = this.f52791b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) == null || !Arrays.asList(packagesForUid).contains("com.android.vending")) {
            zVar.mo149183a(new Bundle());
            this.f52792c.mo148846a();
            return;
        }
        zVar.mo149184a(this.f52792c.mo148845a(bundle), new Bundle());
    }

    /* renamed from: a */
    public final void mo148906a(C18517z zVar) throws RemoteException {
        this.f52793d.mo148933f();
        zVar.mo149185b(new Bundle());
    }
}
