package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dx */
final class C18395dx {

    /* renamed from: a */
    private final String f53065a;

    /* renamed from: b */
    private final long f53066b;

    /* renamed from: c */
    private final int f53067c;

    /* renamed from: d */
    private final boolean f53068d;

    /* renamed from: e */
    private final boolean f53069e;

    /* renamed from: f */
    private final byte[] f53070f;

    C18395dx() {
    }

    C18395dx(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this();
        this.f53065a = str;
        this.f53066b = j;
        this.f53067c = i;
        this.f53068d = z;
        this.f53069e = z2;
        this.f53070f = bArr;
    }

    /* renamed from: a */
    static C18395dx m37686a(String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C18395dx(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo149038a() {
        if (mo149040c() == null) {
            return false;
        }
        return mo149040c().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo149039b() {
        return mo149042e() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo149040c() {
        return this.f53065a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo149041d() {
        return this.f53066b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo149042e() {
        return this.f53067c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C18395dx) {
            C18395dx dxVar = (C18395dx) obj;
            String str = this.f53065a;
            if (str != null ? str.equals(dxVar.mo149040c()) : dxVar.mo149040c() == null) {
                if (this.f53066b == dxVar.mo149041d() && this.f53067c == dxVar.mo149042e() && this.f53068d == dxVar.mo149044f() && this.f53069e == dxVar.mo149045g()) {
                    if (Arrays.equals(this.f53070f, dxVar instanceof C18395dx ? dxVar.f53070f : dxVar.mo149046h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo149044f() {
        return this.f53068d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo149045g() {
        return this.f53069e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte[] mo149046h() {
        return this.f53070f;
    }

    public int hashCode() {
        String str = this.f53065a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f53066b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f53067c) * 1000003) ^ (true != this.f53068d ? 1237 : 1231)) * 1000003;
        if (true == this.f53069e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f53070f);
    }

    public String toString() {
        String str = this.f53065a;
        long j = this.f53066b;
        int i = this.f53067c;
        boolean z = this.f53068d;
        boolean z2 = this.f53069e;
        String arrays = Arrays.toString(this.f53070f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
