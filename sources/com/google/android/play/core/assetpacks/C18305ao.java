package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.ao */
final class C18305ao extends C18301ak<Void> {

    /* renamed from: c */
    final int f52747c;

    /* renamed from: d */
    final String f52748d;

    /* renamed from: e */
    final int f52749e;

    /* renamed from: f */
    final /* synthetic */ C18308ar f52750f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18305ao(C18308ar arVar, C18619i<Void> iVar, int i, String str, int i2) {
        super(arVar, iVar);
        this.f52750f = arVar;
        this.f52747c = i;
        this.f52748d = str;
        this.f52749e = i2;
    }

    /* renamed from: a */
    public final void mo148878a(Bundle bundle) {
        this.f52750f.f52759e.mo149092a();
        int i = bundle.getInt("error_code");
        C18308ar.f52755a.mo149083b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.f52749e;
        if (i2 > 0) {
            this.f52750f.m37468a(this.f52747c, this.f52748d, i2 - 1);
        }
    }
}
