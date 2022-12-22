package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.internal.C18513v;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.af */
final class C18296af extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f52721a;

    /* renamed from: b */
    final /* synthetic */ String f52722b;

    /* renamed from: c */
    final /* synthetic */ String f52723c;

    /* renamed from: d */
    final /* synthetic */ int f52724d;

    /* renamed from: e */
    final /* synthetic */ C18619i f52725e;

    /* renamed from: f */
    final /* synthetic */ C18308ar f52726f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18296af(C18308ar arVar, C18619i iVar, int i, String str, String str2, int i2, C18619i iVar2) {
        super(iVar);
        this.f52726f = arVar;
        this.f52721a = i;
        this.f52722b = str;
        this.f52723c = str2;
        this.f52724d = i2;
        this.f52725e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52726f.f52759e.mo149094b()).mo149173a(this.f52726f.f52757c, C18308ar.m37478c(this.f52721a, this.f52722b, this.f52723c, this.f52724d), C18308ar.m37482e(), (C18513v) new C18301ak(this.f52726f, this.f52725e, (char[]) null));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149082a((Throwable) e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
