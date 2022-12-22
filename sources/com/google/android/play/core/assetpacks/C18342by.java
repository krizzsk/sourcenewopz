package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.by */
final class C18342by extends OutputStream {

    /* renamed from: a */
    private final C18375dd f52898a = new C18375dd();

    /* renamed from: b */
    private final File f52899b;

    /* renamed from: c */
    private final C18389dr f52900c;

    /* renamed from: d */
    private long f52901d;

    /* renamed from: e */
    private long f52902e;

    /* renamed from: f */
    private FileOutputStream f52903f;

    /* renamed from: g */
    private C18395dx f52904g;

    C18342by(File file, C18389dr drVar) {
        this.f52899b = file;
        this.f52900c = drVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f52901d == 0 && this.f52902e == 0) {
                int a = this.f52898a.mo149006a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    C18395dx a2 = this.f52898a.mo149007a();
                    this.f52904g = a2;
                    if (a2.mo149045g()) {
                        this.f52901d = 0;
                        this.f52900c.mo149033b(this.f52904g.mo149046h(), this.f52904g.mo149046h().length);
                        this.f52902e = (long) this.f52904g.mo149046h().length;
                    } else if (!this.f52904g.mo149039b() || this.f52904g.mo149038a()) {
                        byte[] h = this.f52904g.mo149046h();
                        this.f52900c.mo149033b(h, h.length);
                        this.f52901d = this.f52904g.mo149041d();
                    } else {
                        this.f52900c.mo149028a(this.f52904g.mo149046h());
                        File file = new File(this.f52899b, this.f52904g.mo149040c());
                        file.getParentFile().mkdirs();
                        this.f52901d = this.f52904g.mo149041d();
                        this.f52903f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f52904g.mo149038a()) {
                if (this.f52904g.mo149045g()) {
                    this.f52900c.mo149025a(this.f52902e, bArr, i, i2);
                    this.f52902e += (long) i2;
                    i3 = i2;
                } else if (this.f52904g.mo149039b()) {
                    i3 = (int) Math.min((long) i2, this.f52901d);
                    this.f52903f.write(bArr, i, i3);
                    long j = this.f52901d - ((long) i3);
                    this.f52901d = j;
                    if (j == 0) {
                        this.f52903f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f52901d);
                    int length = this.f52904g.mo149046h().length;
                    this.f52900c.mo149025a((((long) length) + this.f52904g.mo149041d()) - this.f52901d, bArr, i, i3);
                    this.f52901d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
