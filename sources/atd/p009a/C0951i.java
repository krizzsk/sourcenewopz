package atd.p009a;

import atd.p046s0.C1172a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: atd.a.i */
public final class C0951i {

    /* renamed from: a */
    private final String f173a;

    /* renamed from: b */
    private final C0946f f174b;

    /* renamed from: c */
    private final Map<String, List<String>> f175c;

    /* renamed from: d */
    private final byte[] f176d;

    C0951i(C0952a aVar) {
        this.f173a = aVar.f177a;
        this.f174b = aVar.f178b;
        this.f175c = aVar.f179c;
        this.f176d = aVar.f180d;
    }

    /* renamed from: a */
    public byte[] mo13572a() {
        byte[] bArr = this.f176d;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    /* renamed from: b */
    public Map<String, List<String>> mo13573b() {
        return this.f175c;
    }

    /* renamed from: c */
    public C0946f mo13574c() {
        return this.f174b;
    }

    /* renamed from: d */
    public String mo13575d() {
        return this.f173a;
    }

    /* renamed from: atd.a.i$a */
    public static final class C0952a {

        /* renamed from: a */
        String f177a;

        /* renamed from: b */
        C0946f f178b = C0946f.GET;

        /* renamed from: c */
        Map<String, List<String>> f179c = new HashMap();

        /* renamed from: d */
        byte[] f180d;

        /* renamed from: a */
        public C0952a mo13577a(String str) {
            if (str == null) {
                throw new NullPointerException(C1172a.m764a(-3316168084142L));
            } else if (!str.isEmpty()) {
                this.f177a = str;
                return this;
            } else {
                throw new NullPointerException(C1172a.m764a(-3372002658990L));
            }
        }

        /* renamed from: b */
        public C0952a mo13581b() {
            return mo13576a(C0946f.GET, (byte[]) null);
        }

        /* renamed from: a */
        public C0952a mo13578a(Map<String, List<String>> map) {
            this.f179c = map;
            return this;
        }

        /* renamed from: a */
        public C0952a mo13579a(byte[] bArr) {
            return mo13576a(C0946f.POST, bArr);
        }

        /* renamed from: a */
        public C0952a mo13576a(C0946f fVar, byte[] bArr) {
            if (fVar == null) {
                throw new NullPointerException(C1172a.m764a(-3500851677870L));
            } else if (bArr != null && !C0946f.m127a(fVar)) {
                throw new IllegalArgumentException(C1172a.m764a(-3569571154606L) + fVar + C1172a.m764a(-3603930892974L));
            } else if (bArr != null || !C0946f.m128b(fVar)) {
                this.f178b = fVar;
                this.f180d = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            } else {
                throw new IllegalArgumentException(C1172a.m764a(-3737074879150L) + fVar + C1172a.m764a(-3771434617518L));
            }
        }

        /* renamed from: a */
        public C0951i mo13580a() {
            if (this.f177a != null) {
                return new C0951i(this);
            }
            throw new IllegalStateException(C1172a.m764a(-3887398734510L));
        }
    }
}
