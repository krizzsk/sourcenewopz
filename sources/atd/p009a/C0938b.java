package atd.p009a;

import atd.p046s0.C1172a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: atd.a.b */
abstract class C0938b {

    /* renamed from: a */
    private static final SSLSocketFactory f156a;

    static {
        try {
            f156a = new C0955k();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException(C1172a.m764a(-2276785998510L), e);
        }
    }

    C0938b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo13553a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return mo13554a(httpURLConnection);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        httpsURLConnection.setSSLSocketFactory(f156a);
        return httpsURLConnection;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract HttpURLConnection mo13554a(HttpURLConnection httpURLConnection);
}
