package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18432ag;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.df */
final class C18377df {

    /* renamed from: a */
    private static final C18432ag f53008a = new C18432ag("MergeSliceTaskHandler");

    /* renamed from: b */
    private final C18319bb f53009b;

    C18377df(C18319bb bbVar) {
        this.f53009b = bbVar;
    }

    /* renamed from: a */
    private static void m37651a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m37651a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new C18339bv(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new C18339bv(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new C18339bv(sb3.toString());
        }
    }

    /* renamed from: a */
    public final void mo149010a(C18376de deVar) {
        File b = this.f53009b.mo148917b(deVar.f52953k, deVar.f53005a, deVar.f53006b, deVar.f53007c);
        if (b.exists()) {
            File c = this.f53009b.mo148919c(deVar.f52953k, deVar.f53005a, deVar.f53006b);
            if (!c.exists()) {
                c.mkdirs();
            }
            m37651a(b, c);
            try {
                this.f53009b.mo148912a(deVar.f52953k, deVar.f53005a, deVar.f53006b, this.f53009b.mo148923d(deVar.f52953k, deVar.f53005a, deVar.f53006b) + 1);
            } catch (IOException e) {
                f53008a.mo149083b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new C18339bv("Writing merge checkpoint failed.", e, deVar.f52952j);
            }
        } else {
            throw new C18339bv(String.format("Cannot find verified files for slice %s.", new Object[]{deVar.f53007c}), deVar.f52952j);
        }
    }
}
