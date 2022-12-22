package atd.p011b;

import android.text.TextUtils;
import atd.p009a.C0937a;
import atd.p009a.C0943e;
import atd.p009a.C0951i;
import atd.p009a.C0953j;
import atd.p010a0.C0956a;
import atd.p015d.C0980c;
import atd.p015d.C0988i;
import atd.p015d.C0989j;
import atd.p017e.C1014c;
import atd.p017e.C1015d;
import atd.p019f.C1021a;
import atd.p019f.C1022b;
import atd.p020f0.C1023a;
import atd.p020f0.C1030h;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.C1395b;
import com.adyen.threeds2.internal.C1397d;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.b.a */
class C0957a extends C0937a {

    /* renamed from: f */
    private static final int f190f = ((int) TimeUnit.SECONDS.toMillis(10));

    /* renamed from: g */
    private static final int f191g = ((int) TimeUnit.SECONDS.toMillis(10));

    /* renamed from: h */
    private static final Charset f192h = C1395b.f995a;

    /* renamed from: d */
    private final String f193d;

    /* renamed from: e */
    private final C1023a f194e;

    /* renamed from: atd.b.a$a */
    class C0958a implements Callable<C0989j> {

        /* renamed from: a */
        final /* synthetic */ C0988i f195a;

        C0958a(C0988i iVar) {
            this.f195a = iVar;
        }

        /* renamed from: a */
        public C0989j call() throws C0956a {
            return C0957a.this.m161a(C0957a.this.m165b(this.f195a), this.f195a);
        }
    }

    C0957a(String str, C1023a aVar) {
        this.f193d = str;
        this.f194e = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo13552b() {
        return f191g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Callable<C0989j> mo13599c(C0988i iVar) {
        return new C0958a(iVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C0989j m165b(C0988i iVar) throws C0956a {
        try {
            try {
                return m158a(mo13551a(m157a(iVar)));
            } catch (SocketTimeoutException e) {
                throw new C0956a(C1172a.m764a(-3994772916910L), e, C1014c.TRANSACTION_TIMED_OUT);
            } catch (IOException e2) {
                throw new C0956a(C1172a.m764a(-4106442066606L), e2, C1014c.SYSTEM_CONNECTION_FAILURE);
            }
        } catch (GeneralSecurityException | JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo13550a() {
        return f190f;
    }

    /* renamed from: a */
    private C0951i m157a(C0988i iVar) throws JSONException, GeneralSecurityException {
        C0951i.C0952a a = new C0951i.C0952a().mo13577a(this.f193d);
        if (iVar.mo13634i()) {
            a.mo13578a(C1021a.m346a()).mo13579a(m163a(m162a((C1022b) iVar)));
        } else {
            a.mo13578a(C1021a.m348b()).mo13579a(m162a((C1022b) iVar));
        }
        return a.mo13580a();
    }

    /* renamed from: a */
    private byte[] m163a(byte[] bArr) throws GeneralSecurityException {
        return this.f194e.mo13747a(bArr).mo13756e().getBytes(f192h);
    }

    /* renamed from: a */
    private byte[] m162a(C1022b bVar) throws JSONException {
        return bVar.mo13606a().toString().getBytes(f192h);
    }

    /* renamed from: a */
    private C0989j m158a(C0953j jVar) throws C0956a {
        byte[] a = jVar.mo13582a();
        Charset charset = null;
        if (a == null || a.length <= 0) {
            return null;
        }
        C0943e.C0945b a2 = C0943e.m118a(jVar.mo13583b());
        C0943e.C0944a b = a2 != null ? a2.mo13564b() : null;
        if (a2 != null) {
            charset = a2.mo13563a();
        }
        boolean z = b == C0943e.C0944a.APPLICATION_JOSE;
        if (z) {
            try {
                a = m164a(a, charset);
            } catch (GeneralSecurityException e) {
                throw new C0956a(C1172a.m764a(-4239586052782L), e, C1014c.DATA_DECRYPTION_FAILURE);
            }
        }
        if (z || b == C0943e.C0944a.APPLICATION_JSON) {
            try {
                C0989j a3 = C0989j.m257a(m166b(a, charset));
                if (z || !a3.mo13636f()) {
                    return a3;
                }
                throw new C0956a(C1172a.m764a(-4643312978606L), C1014c.MESSAGE_RECEIVED_INVALID);
            } catch (JSONException e2) {
                throw new C0956a(C1172a.m764a(-4389909908142L), e2, C1014c.MESSAGE_RECEIVED_INVALID);
            }
        } else {
            throw new C0956a(C1172a.m764a(-4450039450286L), C1014c.MESSAGE_RECEIVED_INVALID);
        }
    }

    /* renamed from: b */
    private JSONObject m166b(byte[] bArr, Charset charset) throws JSONException {
        if (charset == null) {
            charset = f192h;
        }
        return new JSONObject(new String(bArr, charset));
    }

    /* renamed from: a */
    private byte[] m164a(byte[] bArr, Charset charset) throws GeneralSecurityException {
        if (charset == null) {
            charset = f192h;
        }
        return this.f194e.mo13748a(C1030h.m357a(new String(bArr, charset)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0989j m161a(C0989j jVar, C0988i iVar) throws C0956a {
        if (jVar != null || C1015d.ERROR.equals(iVar.mo13664c())) {
            if (jVar != null && !C1015d.ERROR.equals(jVar.mo13671b())) {
                if (!iVar.mo13665d().equals(jVar.mo13672c())) {
                    String join = TextUtils.join(C1172a.m764a(-4999795264174L), C1397d.m1100a());
                    throw new C0956a(String.format(C1172a.m764a(-5008385198766L), new Object[]{jVar.mo13672c(), join}), C1014c.MESSAGE_VERSION_NOT_SUPPORTED);
                } else if (!iVar.mo13669h().equalsIgnoreCase(jVar.mo13674e())) {
                    throw new C0956a(C1172a.m764a(-5223133563566L), C1014c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if (!iVar.mo13663b().equalsIgnoreCase(jVar.mo13670a())) {
                    throw new C0956a(C1172a.m764a(-5382047353518L), C1014c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if (!iVar.mo13667f().equalsIgnoreCase(jVar.mo13673d())) {
                    throw new C0956a(C1172a.m764a(-5528076241582L), C1014c.TRANSACTION_ID_NOT_RECOGNIZED);
                } else if ((jVar instanceof C0980c) && iVar.mo13666e() != ((C0980c) jVar).mo13637g()) {
                    throw new C0956a(C1172a.m764a(-5674105129646L), C1014c.DATA_DECRYPTION_FAILURE);
                }
            }
            return jVar;
        }
        throw new C0956a(C1172a.m764a(-4875241212590L), C1014c.MESSAGE_RECEIVED_INVALID);
    }
}
