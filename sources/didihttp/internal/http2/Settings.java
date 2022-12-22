package didihttp.internal.http2;

import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    static final int f56827a = 65535;

    /* renamed from: b */
    static final int f56828b = 1;

    /* renamed from: c */
    static final int f56829c = 2;

    /* renamed from: d */
    static final int f56830d = 4;

    /* renamed from: e */
    static final int f56831e = 5;

    /* renamed from: f */
    static final int f56832f = 6;

    /* renamed from: g */
    static final int f56833g = 7;

    /* renamed from: h */
    static final int f56834h = 10;

    /* renamed from: i */
    private int f56835i;

    /* renamed from: j */
    private final int[] f56836j = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170177a() {
        this.f56835i = 0;
        Arrays.fill(this.f56836j, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings mo170176a(int i, int i2) {
        int[] iArr = this.f56836j;
        if (i < iArr.length && i >= 0) {
            this.f56835i = (1 << i) | this.f56835i;
            iArr[i] = i2;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo170179a(int i) {
        return ((1 << i) & this.f56835i) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo170182b(int i) {
        return this.f56836j[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo170181b() {
        return Integer.bitCount(this.f56835i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo170183c() {
        if ((this.f56835i & 2) != 0) {
            return this.f56836j[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo170180a(boolean z) {
        return ((this.f56835i & 4) != 0 ? this.f56836j[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo170184c(int i) {
        return (this.f56835i & 16) != 0 ? this.f56836j[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo170186d(int i) {
        return (this.f56835i & 32) != 0 ? this.f56836j[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo170187e(int i) {
        return (this.f56835i & 64) != 0 ? this.f56836j[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo170185d() {
        if ((this.f56835i & 128) != 0) {
            return this.f56836j[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170178a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo170179a(i)) {
                mo170176a(i, settings.mo170182b(i));
            }
        }
    }
}
