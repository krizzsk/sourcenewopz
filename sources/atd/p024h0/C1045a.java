package atd.p024h0;

import atd.p018e0.C1019c;
import atd.p018e0.C1020d;
import atd.p026i0.C1061f;
import atd.p026i0.C1063h;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.h0.a */
public final class C1045a extends C1061f {

    /* renamed from: c */
    private final C1019c f298c;

    /* renamed from: d */
    private final List<X509Certificate> f299d;

    C1045a(String str) {
        super(str);
        try {
            JSONObject d = mo13792d();
            this.f298c = C1020d.m345a(d.getString(C1172a.m764a(-700131662187182L)));
            this.f299d = new ArrayList();
            JSONArray jSONArray = d.getJSONArray(C1172a.m764a(-700148842056366L));
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f299d.add(C1063h.m461a(jSONArray.getString(i)));
            }
        } catch (CertificateException | JSONException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: e */
    public List<X509Certificate> mo13775e() {
        return new ArrayList(this.f299d);
    }

    /* renamed from: f */
    public C1019c mo13776f() {
        return this.f298c;
    }
}
