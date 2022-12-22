package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18432ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dv */
final class C18393dv {

    /* renamed from: a */
    private static final C18432ag f53062a = new C18432ag("VerifySliceTaskHandler");

    /* renamed from: b */
    private final C18319bb f53063b;

    C18393dv(C18319bb bbVar) {
        this.f53063b = bbVar;
    }

    /* renamed from: a */
    private final void m37683a(C18392du duVar, File file) {
        try {
            File f = this.f53063b.mo148932f(duVar.f52953k, duVar.f53058a, duVar.f53059b, duVar.f53060c);
            if (f.exists()) {
                try {
                    if (C18373db.m37638a(C18391dt.m37681a(file, f)).equals(duVar.f53061d)) {
                        f53062a.mo149084c("Verification of slice %s of pack %s successful.", duVar.f53060c, duVar.f52953k);
                        return;
                    }
                    throw new C18339bv(String.format("Verification failed for slice %s.", new Object[]{duVar.f53060c}), duVar.f52952j);
                } catch (NoSuchAlgorithmException e) {
                    throw new C18339bv("SHA256 algorithm not supported.", e, duVar.f52952j);
                } catch (IOException e2) {
                    throw new C18339bv(String.format("Could not digest file during verification for slice %s.", new Object[]{duVar.f53060c}), e2, duVar.f52952j);
                }
            } else {
                throw new C18339bv(String.format("Cannot find metadata files for slice %s.", new Object[]{duVar.f53060c}), duVar.f52952j);
            }
        } catch (IOException e3) {
            throw new C18339bv(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{duVar.f53060c}), e3, duVar.f52952j);
        }
    }

    /* renamed from: a */
    public final void mo149037a(C18392du duVar) {
        File a = this.f53063b.mo148910a(duVar.f52953k, duVar.f53058a, duVar.f53059b, duVar.f53060c);
        if (a.exists()) {
            m37683a(duVar, a);
            File b = this.f53063b.mo148917b(duVar.f52953k, duVar.f53058a, duVar.f53059b, duVar.f53060c);
            if (!b.exists()) {
                b.mkdirs();
            }
            if (!a.renameTo(b)) {
                throw new C18339bv(String.format("Failed to move slice %s after verification.", new Object[]{duVar.f53060c}), duVar.f52952j);
            }
            return;
        }
        throw new C18339bv(String.format("Cannot find unverified files for slice %s.", new Object[]{duVar.f53060c}), duVar.f52952j);
    }
}
