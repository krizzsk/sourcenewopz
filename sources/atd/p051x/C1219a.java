package atd.p051x;

import atd.p026i0.C1063h;
import atd.p044r0.C1159f;
import atd.p052y.C1223a;
import atd.p052y.C1225c;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atd.x.a */
public final class C1219a {
    /* renamed from: a */
    public static List<X509Certificate> m897a(String str, ConfigParameters configParameters) {
        if (str == null || str.isEmpty()) {
            return m895a(configParameters);
        }
        return m896a(str);
    }

    /* renamed from: b */
    private static List<X509Certificate> m898b(String str) {
        ArrayList arrayList = new ArrayList();
        for (String a : C1220b.m901b(str)) {
            try {
                arrayList.add(C1063h.m461a(a));
            } catch (CertificateException e) {
                throw C1225c.UNKNOWN_DIRECTORY_SERVER.mo13983a(e);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<X509Certificate> m895a(ConfigParameters configParameters) {
        C1159f.m731a((Object) configParameters, C1223a.CONFIG_PARAMETERS);
        return m898b(AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID));
    }

    /* renamed from: a */
    private static List<X509Certificate> m896a(String str) {
        C1159f.m732a(str, C1223a.DIRECTORY_SERVER_ID);
        return m898b(str);
    }
}
