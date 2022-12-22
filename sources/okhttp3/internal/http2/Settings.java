package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    static final int f5483a = 65535;

    /* renamed from: b */
    static final int f5484b = 1;

    /* renamed from: c */
    static final int f5485c = 2;

    /* renamed from: d */
    static final int f5486d = 4;

    /* renamed from: e */
    static final int f5487e = 5;

    /* renamed from: f */
    static final int f5488f = 6;

    /* renamed from: g */
    static final int f5489g = 7;

    /* renamed from: h */
    static final int f5490h = 10;

    /* renamed from: i */
    private int f5491i;

    /* renamed from: j */
    private final int[] f5492j = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25316a() {
        this.f5491i = 0;
        Arrays.fill(this.f5492j, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings mo25315a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f5492j;
            if (i < iArr.length) {
                this.f5491i = (1 << i) | this.f5491i;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25318a(int i) {
        return ((1 << i) & this.f5491i) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo25321b(int i) {
        return this.f5492j[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo25320b() {
        return Integer.bitCount(this.f5491i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo25322c() {
        if ((this.f5491i & 2) != 0) {
            return this.f5492j[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25319a(boolean z) {
        return ((this.f5491i & 4) != 0 ? this.f5492j[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo25323c(int i) {
        return (this.f5491i & 16) != 0 ? this.f5492j[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo25325d(int i) {
        return (this.f5491i & 32) != 0 ? this.f5492j[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo25326e(int i) {
        return (this.f5491i & 64) != 0 ? this.f5492j[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo25324d() {
        if ((this.f5491i & 128) != 0) {
            return this.f5492j[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25317a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo25318a(i)) {
                mo25315a(i, settings.mo25321b(i));
            }
        }
    }
}
