package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18490ck;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dj */
final class C18381dj {

    /* renamed from: a */
    private final C18319bb f53014a;

    /* renamed from: b */
    private final C18490ck<C18415w> f53015b;

    /* renamed from: c */
    private final C18360cp f53016c;

    /* renamed from: d */
    private final C18490ck<Executor> f53017d;

    /* renamed from: e */
    private final C18343bz f53018e;

    C18381dj(C18319bb bbVar, C18490ck<C18415w> ckVar, C18360cp cpVar, C18490ck<Executor> ckVar2, C18343bz bzVar) {
        this.f53014a = bbVar;
        this.f53015b = ckVar;
        this.f53016c = cpVar;
        this.f53017d = ckVar2;
        this.f53018e = bzVar;
    }

    /* renamed from: a */
    public final void mo149012a(C18379dh dhVar) {
        File c = this.f53014a.mo148919c(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b);
        File e = this.f53014a.mo148928e(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b);
        if (!c.exists() || !e.exists()) {
            throw new C18339bv(String.format("Cannot find pack files to move for pack %s.", new Object[]{dhVar.f52953k}), dhVar.f52952j);
        }
        File a = this.f53014a.mo148909a(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b);
        a.mkdirs();
        if (c.renameTo(a)) {
            new File(this.f53014a.mo148909a(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b), "merge.tmp").delete();
            File b = this.f53014a.mo148916b(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b);
            b.mkdirs();
            if (e.renameTo(b)) {
                C18319bb bbVar = this.f53014a;
                bbVar.getClass();
                this.f53017d.mo149139a().execute(C18380di.m37654a(bbVar));
                this.f53016c.mo148978a(dhVar.f52953k, dhVar.f53011a, dhVar.f53012b);
                this.f53018e.mo148971a(dhVar.f52953k);
                this.f53015b.mo149139a().mo148893a(dhVar.f52952j, dhVar.f52953k);
                return;
            }
            throw new C18339bv("Cannot move metadata files to final location.", dhVar.f52952j);
        }
        throw new C18339bv("Cannot move merged pack files to final location.", dhVar.f52952j);
    }
}
