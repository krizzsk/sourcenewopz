package atd.p032l0;

import android.content.Context;
import atd.p044r0.C1160g;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.internal.C1417j;

/* renamed from: atd.l0.f */
abstract class C1081f {
    C1081f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo13816a() {
        return mo13817a(mo13812c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo13818b() {
        return mo13817a(mo13813d());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo13811b(Context context);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract String mo13812c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract String mo13813d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract Warning.Severity mo13814e();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1417j mo13815a(Context context) {
        if (mo13811b(context)) {
            return new C1417j(mo13816a(), mo13818b(), mo13814e());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo13817a(String str) {
        return C1160g.m734a(str);
    }
}
