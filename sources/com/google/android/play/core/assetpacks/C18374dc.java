package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* renamed from: com.google.android.play.core.assetpacks.dc */
public final class C18374dc extends InputStream {

    /* renamed from: a */
    private final Enumeration<File> f52994a;

    /* renamed from: b */
    private InputStream f52995b;

    public C18374dc(Enumeration<File> enumeration) throws IOException {
        this.f52994a = enumeration;
        mo149002a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149002a() throws IOException {
        InputStream inputStream = this.f52995b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f52995b = this.f52994a.hasMoreElements() ? new FileInputStream(this.f52994a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f52995b;
        if (inputStream != null) {
            inputStream.close();
            this.f52995b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f52995b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo149002a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f52995b == null) {
            return -1;
        }
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f52995b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo149002a();
            } while (this.f52995b != null);
            return -1;
        }
    }
}
