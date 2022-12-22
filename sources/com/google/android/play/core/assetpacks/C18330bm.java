package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.google.android.play.core.assetpacks.bm */
final class C18330bm extends FilterInputStream {

    /* renamed from: a */
    private final C18375dd f52826a = new C18375dd();

    /* renamed from: b */
    private byte[] f52827b = new byte[4096];

    /* renamed from: c */
    private long f52828c;

    /* renamed from: d */
    private boolean f52829d = false;

    /* renamed from: e */
    private boolean f52830e = false;

    C18330bm(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    private final int m37551a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private final boolean m37552a(int i) throws IOException {
        int a = m37551a(this.f52827b, 0, i);
        if (a != i) {
            int i2 = i - a;
            if (m37551a(this.f52827b, a, i2) != i2) {
                this.f52826a.mo149006a(this.f52827b, 0, a);
                return false;
            }
        }
        this.f52826a.mo149006a(this.f52827b, 0, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C18395dx mo148954a() throws IOException {
        byte[] bArr;
        if (this.f52828c > 0) {
            do {
                bArr = this.f52827b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f52829d || this.f52830e) {
            return new C18395dx((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!m37552a(30)) {
            this.f52829d = true;
            return this.f52826a.mo149007a();
        }
        C18395dx a = this.f52826a.mo149007a();
        if (a.mo149045g()) {
            this.f52830e = true;
            return a;
        } else if (a.mo149041d() != InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            int b = this.f52826a.mo149008b() - 30;
            long j = (long) b;
            int length = this.f52827b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f52827b = Arrays.copyOf(this.f52827b, length);
            }
            if (!m37552a(b)) {
                this.f52829d = true;
                return this.f52826a.mo149007a();
            }
            C18395dx a2 = this.f52826a.mo149007a();
            this.f52828c = a2.mo149041d();
            return a2;
        } else {
            throw new C18339bv("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo148955b() {
        return this.f52829d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo148956c() {
        return this.f52830e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo148957d() {
        return this.f52828c;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f52828c;
        if (j <= 0 || this.f52829d) {
            return -1;
        }
        int a = m37551a(bArr, i, (int) Math.min(j, (long) i2));
        this.f52828c -= (long) a;
        if (a != 0) {
            return a;
        }
        this.f52829d = true;
        return 0;
    }
}
