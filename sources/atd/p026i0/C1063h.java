package atd.p026i0;

import android.os.Build;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.internal.C1395b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.EnumSet;
import java.util.List;

/* renamed from: atd.i0.h */
public final class C1063h {

    /* renamed from: a */
    private static final CertificateFactory f310a;

    static {
        C1172a.m764a(-706161796270766L);
        try {
            f310a = CertificateFactory.getInstance(C1172a.m764a(-706406609406638L));
        } catch (CertificateException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    public static X509Certificate m461a(String str) throws CertificateException {
        return m460a((InputStream) new ByteArrayInputStream(String.format(C1172a.m764a(-705624925358766L), new Object[]{str}).getBytes(C1395b.f995a)));
    }

    /* renamed from: a */
    public static void m462a(X509Certificate x509Certificate, List<X509Certificate> list) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            instance.setCertificateEntry(C1172a.m764a(-705869738494638L), x509Certificate);
            PKIXParameters pKIXParameters = new PKIXParameters(instance);
            CertPathValidator instance2 = CertPathValidator.getInstance(C1172a.m764a(-705891213331118L));
            if (Build.VERSION.SDK_INT >= 24) {
                PKIXRevocationChecker pKIXRevocationChecker = (PKIXRevocationChecker) instance2.getRevocationChecker();
                if (pKIXRevocationChecker.getOcspResponder() == null) {
                    if (Security.getProperty(C1172a.m764a(-705912688167598L)) == null) {
                        pKIXParameters.setRevocationEnabled(false);
                    }
                }
                pKIXRevocationChecker.setOptions(EnumSet.of(PKIXRevocationChecker.Option.SOFT_FAIL));
                pKIXParameters.addCertPathChecker(pKIXRevocationChecker);
            } else {
                pKIXParameters.setRevocationEnabled(false);
            }
            if (instance2.validate(f310a.generateCertPath(list), pKIXParameters) == null) {
                throw C1225c.CRYPTO_FAILURE.mo13982a();
            }
        } catch (IOException | GeneralSecurityException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: a */
    private static X509Certificate m460a(InputStream inputStream) throws CertificateException {
        Certificate generateCertificate = f310a.generateCertificate(inputStream);
        if (generateCertificate instanceof X509Certificate) {
            return (X509Certificate) generateCertificate;
        }
        throw new CertificateException(C1172a.m764a(-705989997578926L));
    }
}
