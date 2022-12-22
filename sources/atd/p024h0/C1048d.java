package atd.p024h0;

import atd.p026i0.C1063h;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.internal.C1395b;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: atd.h0.d */
public final class C1048d {

    /* renamed from: a */
    private final C1045a f300a;

    /* renamed from: b */
    private final C1046b f301b;

    /* renamed from: c */
    private final C1047c f302c;

    static {
        C1172a.m764a(-700187496762030L);
    }

    private C1048d(C1045a aVar, C1046b bVar, C1047c cVar) {
        this.f300a = aVar;
        this.f301b = bVar;
        this.f302c = cVar;
    }

    /* renamed from: a */
    public static C1048d m425a(String str) {
        String[] split = str.split(C1172a.m764a(-700166021925550L));
        if (split.length == 3) {
            return new C1048d(new C1045a(split[0]), new C1046b(split[1]), new C1047c(split[2]));
        }
        throw C1225c.CRYPTO_FAILURE.mo13982a();
    }

    /* renamed from: a */
    public C1046b mo13777a() {
        return this.f301b;
    }

    /* renamed from: a */
    public void mo13779a(List<X509Certificate> list) {
        for (X509Certificate a : list) {
            try {
                mo13778a(a);
                return;
            } catch (SDKRuntimeException unused) {
            }
        }
        throw C1225c.CRYPTO_FAILURE.mo13982a();
    }

    /* renamed from: a */
    public void mo13778a(X509Certificate x509Certificate) {
        C1063h.m462a(x509Certificate, this.f300a.mo13775e());
        byte[] a = m426a(this.f300a.mo13791c(), this.f301b.mo13791c());
        try {
            if (!this.f300a.mo13776f().mo13746a(this.f302c.mo13790b(), a, this.f300a.mo13775e().get(0).getPublicKey())) {
                throw C1225c.CRYPTO_FAILURE.mo13982a();
            }
        } catch (GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    private static byte[] m426a(String str, String str2) {
        return (str + C1172a.m764a(-700178906827438L) + str2).getBytes(C1395b.f995a);
    }
}
