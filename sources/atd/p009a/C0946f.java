package atd.p009a;

import atd.p046s0.C1172a;

/* renamed from: atd.a.f */
public enum C0946f {
    GET(C1172a.m764a(-3256038541998L), false),
    POST(C1172a.m764a(-3294693247662L), true);
    
    private boolean mDoOutput;
    private String mValue;

    private C0946f(String str, boolean z) {
        this.mValue = str;
        this.mDoOutput = z;
    }

    /* renamed from: a */
    public static boolean m127a(C0946f fVar) {
        return !fVar.equals(GET);
    }

    /* renamed from: b */
    public static boolean m128b(C0946f fVar) {
        return fVar.equals(POST);
    }

    /* renamed from: a */
    public String mo13567a() {
        return this.mValue;
    }

    /* renamed from: b */
    public boolean mo13568b() {
        return this.mDoOutput;
    }
}
