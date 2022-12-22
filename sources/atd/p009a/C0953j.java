package atd.p009a;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: atd.a.j */
public final class C0953j {

    /* renamed from: a */
    private final Map<String, List<String>> f181a;

    /* renamed from: b */
    private final byte[] f182b;

    /* renamed from: atd.a.j$a */
    public static final class C0954a {

        /* renamed from: a */
        int f183a;

        /* renamed from: b */
        String f184b;

        /* renamed from: c */
        Map<String, List<String>> f185c;

        /* renamed from: d */
        byte[] f186d;

        /* renamed from: a */
        public C0954a mo13584a(int i) {
            this.f183a = i;
            return this;
        }

        /* renamed from: a */
        public C0954a mo13585a(String str) {
            this.f184b = str;
            return this;
        }

        /* renamed from: a */
        public C0954a mo13586a(Map<String, List<String>> map) {
            this.f185c = map;
            return this;
        }

        /* renamed from: a */
        public C0954a mo13587a(byte[] bArr) {
            this.f186d = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        /* renamed from: a */
        public C0953j mo13588a() {
            return new C0953j(this);
        }
    }

    C0953j(C0954a aVar) {
        int i = aVar.f183a;
        String str = aVar.f184b;
        this.f181a = aVar.f185c;
        this.f182b = aVar.f186d;
    }

    /* renamed from: a */
    public byte[] mo13582a() {
        byte[] bArr = this.f182b;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    /* renamed from: b */
    public Map<String, List<String>> mo13583b() {
        return this.f181a;
    }
}
