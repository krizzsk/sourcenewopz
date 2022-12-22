package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18489cj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.g */
final class C18537g implements C18539i {

    /* renamed from: a */
    final /* synthetic */ Set f53239a;

    /* renamed from: b */
    final /* synthetic */ C18547q f53240b;

    /* renamed from: c */
    final /* synthetic */ ZipFile f53241c;

    C18537g(Set set, C18547q qVar, ZipFile zipFile) {
        this.f53239a = set;
        this.f53240b = qVar;
        this.f53241c = zipFile;
    }

    /* renamed from: a */
    public final void mo149230a(C18540j jVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f53239a.add(file);
        if (!z) {
            SystemUtils.log(4, "SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f53240b.mo149239b(), jVar.f53242a, this.f53240b.mo149238a().getAbsolutePath(), jVar.f53243b.getName(), file.getAbsolutePath()}), (Throwable) null, "com.google.android.play.core.splitcompat.g", -1);
            ZipFile zipFile = this.f53241c;
            ZipEntry zipEntry = jVar.f53243b;
            int i = C18541k.f53244a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        C18489cj.m37906a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
