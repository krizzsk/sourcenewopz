package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dd */
final class C18375dd {

    /* renamed from: a */
    private byte[] f52996a = new byte[4096];

    /* renamed from: b */
    private int f52997b;

    /* renamed from: c */
    private long f52998c;

    /* renamed from: d */
    private long f52999d;

    /* renamed from: e */
    private int f53000e;

    /* renamed from: f */
    private int f53001f;

    /* renamed from: g */
    private int f53002g;

    /* renamed from: h */
    private boolean f53003h;

    /* renamed from: i */
    private String f53004i;

    public C18375dd() {
        mo149009c();
    }

    /* renamed from: a */
    private final int m37646a(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f52997b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f52996a, this.f52997b, min);
        int i5 = this.f52997b + min;
        this.f52997b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo149006a(byte[] bArr, int i, int i2) {
        int a = m37646a(30, bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        if (this.f52998c == -1) {
            long b = C18373db.m37641b(this.f52996a, 0);
            this.f52998c = b;
            if (b == 67324752) {
                this.f53003h = false;
                this.f52999d = C18373db.m37641b(this.f52996a, 18);
                this.f53002g = C18373db.m37643c(this.f52996a, 8);
                this.f53000e = C18373db.m37643c(this.f52996a, 26);
                int c = this.f53000e + 30 + C18373db.m37643c(this.f52996a, 28);
                this.f53001f = c;
                int length = this.f52996a.length;
                if (length < c) {
                    do {
                        length += length;
                    } while (length < c);
                    this.f52996a = Arrays.copyOf(this.f52996a, length);
                }
            } else {
                this.f53003h = true;
            }
        }
        int a2 = m37646a(this.f53001f, bArr, i + a, i2 - a);
        if (a2 == -1) {
            return -1;
        }
        int i3 = a + a2;
        if (!this.f53003h && this.f53004i == null) {
            this.f53004i = new String(this.f52996a, 30, this.f53000e);
        }
        return i3;
    }

    /* renamed from: a */
    public final C18395dx mo149007a() {
        int i = this.f52997b;
        int i2 = this.f53001f;
        if (i < i2) {
            return C18395dx.m37686a(this.f53004i, this.f52999d, this.f53002g, true, Arrays.copyOf(this.f52996a, i), this.f53003h);
        }
        C18395dx a = C18395dx.m37686a(this.f53004i, this.f52999d, this.f53002g, false, Arrays.copyOf(this.f52996a, i2), this.f53003h);
        mo149009c();
        return a;
    }

    /* renamed from: b */
    public final int mo149008b() {
        return this.f53001f;
    }

    /* renamed from: c */
    public final void mo149009c() {
        this.f52997b = 0;
        this.f53000e = -1;
        this.f52998c = -1;
        this.f53003h = false;
        this.f53001f = 30;
        this.f52999d = -1;
        this.f53002g = -1;
        this.f53004i = null;
    }
}
