package atd.p026i0;

import atd.p046s0.C1172a;
import java.security.Provider;
import java.util.Locale;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi;

/* renamed from: atd.i0.a */
public final class C1054a extends Provider {

    /* renamed from: a */
    public static final C1054a f306a = new C1054a();

    /* renamed from: b */
    private static final String f307b = String.format(Locale.US, C1172a.m764a(-700355000486574L), new Object[]{Double.valueOf(1.0d)});

    static {
        C1172a.m764a(-700337820617390L);
    }

    private C1054a() {
        super(C1172a.m764a(-700200381663918L), 1.0d, f307b);
        put(C1172a.m764a(-700217561533102L), PSSSignatureSpi.SHA256withRSA.class.getName());
    }
}
