package com.adyen.threeds2.internal;

import android.content.Context;
import atd.p030k0.C1072a;
import atd.p044r0.C1160g;
import atd.p046s0.C1172a;
import java.util.UUID;

/* renamed from: com.adyen.threeds2.internal.e */
public final class C1398e {

    /* renamed from: a */
    private final C1072a f996a;

    /* renamed from: b */
    private String f997b;

    static {
        C1172a.m764a(-1181569338030L);
    }

    private C1398e(Context context, C1072a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f996a = aVar;
        m1108b(applicationContext);
    }

    /* renamed from: a */
    public static C1398e m1104a(Context context, C1072a aVar) {
        return new C1398e(context, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo14851b() {
        return m1106a(C1172a.m764a(-447129930414L));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo14852c(Context context) {
        this.f997b = m1105a(context);
    }

    /* renamed from: b */
    private void m1108b(Context context) {
        String a = this.f996a.mo13807a(context, C1172a.m764a(-906691431086L));
        if (a == null) {
            a = m1105a(context);
        }
        this.f997b = a;
    }

    /* renamed from: a */
    public String mo14850a() {
        return m1106a(this.f997b);
    }

    /* renamed from: a */
    private String m1105a(Context context) {
        String b = m1107b(UUID.randomUUID().toString());
        this.f996a.mo13808a(context, C1172a.m764a(-1044130384558L), b);
        return b;
    }

    /* renamed from: a */
    private String m1106a(String str) {
        return C1160g.m734a(str);
    }

    /* renamed from: b */
    private String m1107b(String str) {
        return C1160g.m737b(str);
    }
}
