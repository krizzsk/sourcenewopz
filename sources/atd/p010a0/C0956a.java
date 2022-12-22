package atd.p010a0;

import atd.p017e.C1014c;
import atd.p046s0.C1172a;

/* renamed from: atd.a0.a */
public final class C0956a extends Exception {

    /* renamed from: a */
    private final C1014c f189a;

    public C0956a(String str, C1014c cVar) {
        super(str);
        this.f189a = cVar;
    }

    /* renamed from: a */
    public String mo13597a() {
        String str;
        String message = getMessage();
        Throwable cause = getCause();
        if (cause != null) {
            str = C1172a.m764a(-697516027103918L) + cause.getMessage();
        } else {
            str = C1172a.m764a(-697524617038510L);
        }
        return message + str;
    }

    /* renamed from: b */
    public C1014c mo13598b() {
        return this.f189a;
    }

    public C0956a(String str, Throwable th, C1014c cVar) {
        super(str, th);
        this.f189a = cVar;
    }
}
