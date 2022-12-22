package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.ai */
final class C18299ai extends C18433ah {

    /* renamed from: a */
    final /* synthetic */ int f52735a;

    /* renamed from: b */
    final /* synthetic */ String f52736b;

    /* renamed from: c */
    final /* synthetic */ String f52737c;

    /* renamed from: d */
    final /* synthetic */ int f52738d;

    /* renamed from: e */
    final /* synthetic */ C18619i f52739e;

    /* renamed from: f */
    final /* synthetic */ C18308ar f52740f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C18299ai(C18308ar arVar, C18619i iVar, int i, String str, String str2, int i2, C18619i iVar2) {
        super(iVar);
        this.f52740f = arVar;
        this.f52735a = i;
        this.f52736b = str;
        this.f52737c = str2;
        this.f52738d = i2;
        this.f52739e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148807a() {
        try {
            ((C18511t) this.f52740f.f52759e.mo149094b()).mo149181d(this.f52740f.f52757c, C18308ar.m37478c(this.f52735a, this.f52736b, this.f52737c, this.f52738d), C18308ar.m37482e(), new C18302al(this.f52740f, this.f52739e));
        } catch (RemoteException e) {
            C18308ar.f52755a.mo149083b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f52736b, this.f52737c, Integer.valueOf(this.f52738d), Integer.valueOf(this.f52735a));
            this.f52739e.mo149341b((Exception) new RuntimeException(e));
        }
    }
}
