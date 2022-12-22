package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C18420a;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18470br;
import com.google.android.play.core.internal.C18481cb;
import com.google.android.play.core.internal.C18489cj;
import com.google.android.play.core.internal.C18490ck;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.do */
final class C18386do {

    /* renamed from: a */
    private static final C18432ag f53036a = new C18432ag("PatchSliceTaskHandler");

    /* renamed from: b */
    private final C18319bb f53037b;

    /* renamed from: c */
    private final C18490ck<C18415w> f53038c;

    /* renamed from: d */
    private final C18420a f53039d;

    C18386do(C18319bb bbVar, C18490ck<C18415w> ckVar, C18420a aVar) {
        this.f53037b = bbVar;
        this.f53038c = ckVar;
        this.f53039d = aVar;
    }

    /* renamed from: a */
    public final void mo149014a(C18385dn dnVar) {
        InputStream inputStream;
        Throwable th;
        C18385dn dnVar2 = dnVar;
        File a = this.f53037b.mo148909a(dnVar2.f52953k, dnVar2.f53028a, dnVar2.f53029b);
        C18319bb bbVar = this.f53037b;
        String str = dnVar2.f52953k;
        int i = dnVar2.f53028a;
        long j = dnVar2.f53029b;
        File file = new File(bbVar.mo148916b(str, i, j), dnVar2.f53033f);
        try {
            inputStream = dnVar2.f53035h;
            if (dnVar2.f53032e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            C18322be beVar = new C18322be(a, file);
            if (this.f53039d.mo149065a()) {
                File a2 = this.f53037b.mo148910a(dnVar2.f52953k, dnVar2.f53030c, dnVar2.f53031d, dnVar2.f53033f);
                if (!a2.exists()) {
                    a2.mkdirs();
                }
                C18389dr drVar = new C18389dr(this.f53037b, dnVar2.f52953k, dnVar2.f53030c, dnVar2.f53031d, dnVar2.f53033f);
                C18470br.m37853a((C18481cb) beVar, inputStream, (OutputStream) new C18342by(a2, drVar), dnVar2.f53034g);
                drVar.mo149032b(0);
            } else {
                File file2 = new File(this.f53037b.mo148932f(dnVar2.f52953k, dnVar2.f53030c, dnVar2.f53031d, dnVar2.f53033f), "slice.zip.tmp");
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                C18470br.m37853a((C18481cb) beVar, inputStream, (OutputStream) new FileOutputStream(file2), dnVar2.f53034g);
                if (!file2.renameTo(this.f53037b.mo148929e(dnVar2.f52953k, dnVar2.f53030c, dnVar2.f53031d, dnVar2.f53033f))) {
                    throw new C18339bv(String.format("Error moving patch for slice %s of pack %s.", new Object[]{dnVar2.f53033f, dnVar2.f52953k}), dnVar2.f52952j);
                }
            }
            inputStream.close();
            if (this.f53039d.mo149065a()) {
                f53036a.mo149084c("Patching and extraction finished for slice %s of pack %s.", dnVar2.f53033f, dnVar2.f52953k);
            } else {
                f53036a.mo149084c("Patching finished for slice %s of pack %s.", dnVar2.f53033f, dnVar2.f52953k);
            }
            this.f53038c.mo149139a().mo148894a(dnVar2.f52952j, dnVar2.f52953k, dnVar2.f53033f, 0);
            try {
                dnVar2.f53035h.close();
                return;
            } catch (IOException unused) {
                f53036a.mo149085d("Could not close file for slice %s of pack %s.", dnVar2.f53033f, dnVar2.f52953k);
                return;
            }
        } catch (IOException e) {
            f53036a.mo149083b("IOException during patching %s.", e.getMessage());
            throw new C18339bv(String.format("Error patching slice %s of pack %s.", new Object[]{dnVar2.f53033f, dnVar2.f52953k}), e, dnVar2.f52952j);
        } catch (Throwable th2) {
            C18489cj.m37906a(th, th2);
        }
        throw th;
    }
}
