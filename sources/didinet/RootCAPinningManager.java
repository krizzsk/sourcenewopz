package didinet;

import android.os.Build;
import didihttp.internal.tls.TLSSocketFactory;
import didinet.ApolloAPI;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Collection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class RootCAPinningManager {

    /* renamed from: e */
    private static final String f57139e = "root_ca_pinning";

    /* renamed from: f */
    private static final String f57140f = "disable_share_same_system_ssl";

    /* renamed from: h */
    private static RootCAPinningManager f57141h = null;

    /* renamed from: i */
    private static final long f57142i = 15552000;

    /* renamed from: j */
    private static final int f57143j = 1000;

    /* renamed from: k */
    private static final int f57144k = 0;

    /* renamed from: a */
    private SSLSocketFactory f57145a;

    /* renamed from: b */
    private X509TrustManager f57146b;

    /* renamed from: c */
    private volatile SSLSocketFactory f57147c;

    /* renamed from: d */
    private volatile X509TrustManager f57148d;

    /* renamed from: g */
    private ApolloAPI f57149g = NetEngine.getInstance().getApolloAPI();

    private RootCAPinningManager() {
        X509TrustManager b = m40962b();
        this.f57146b = b;
        this.f57145a = m40959a(b);
        if (this.f57149g.getToggle(f57139e).allow()) {
            C208041 r0 = new Runnable() {
                public void run() {
                    RootCAPinningManager.this.m40960a();
                }
            };
            if (((Integer) this.f57149g.getToggle(f57139e).getExperiment().getParam("async", 0)).intValue() == 0) {
                new Thread(r0).start();
            } else {
                r0.run();
            }
        }
        int i = ((1615977213 - (System.currentTimeMillis() / 1000)) > f57142i ? 1 : ((1615977213 - (System.currentTimeMillis() / 1000)) == f57142i ? 0 : -1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40960a() {
        try {
            Collection<? extends Certificate> a = CertificateSource.m40925a();
            if (a != null) {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream) null, (char[]) null);
                int i = 0;
                for (Certificate certificateEntry : a) {
                    instance.setCertificateEntry(String.valueOf(i), certificateEntry);
                    i++;
                }
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                TrustManager[] trustManagers = instance2.getTrustManagers();
                if (trustManagers != null && trustManagers.length > 0) {
                    this.f57148d = (X509TrustManager) trustManagers[0];
                }
                SSLContext instance3 = SSLContext.getInstance("TLS");
                instance3.init((KeyManager[]) null, new TrustManager[]{this.f57148d}, (SecureRandom) null);
                this.f57147c = m40958a(instance3);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private X509TrustManager m40962b() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m40959a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m40958a(instance);
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m40958a(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new TLSSocketFactory(sSLContext);
        }
        return sSLContext.getSocketFactory();
    }

    public static RootCAPinningManager getInstance() {
        if (f57141h == null) {
            synchronized (RootCAPinningManager.class) {
                if (f57141h == null) {
                    f57141h = new RootCAPinningManager();
                }
            }
        }
        return f57141h;
    }

    public SSLSocketFactory getSslSocketFactory() {
        if (this.f57147c == null || this.f57148d == null || !this.f57149g.getToggle(f57139e).allow()) {
            return getSystemDefaultSslSocketFactory();
        }
        return this.f57147c;
    }

    public X509TrustManager getX509TrustManager() {
        if (this.f57147c == null || this.f57148d == null || !this.f57149g.getToggle(f57139e).allow()) {
            return getSystemDefaultTrustManager();
        }
        return this.f57148d;
    }

    public SSLSocketFactory getSystemDefaultSslSocketFactory() {
        if (m40963c()) {
            return this.f57145a;
        }
        return m40959a(m40962b());
    }

    public X509TrustManager getSystemDefaultTrustManager() {
        if (m40963c()) {
            return this.f57146b;
        }
        return m40962b();
    }

    /* renamed from: c */
    private boolean m40963c() {
        int i;
        ApolloAPI.Toggle toggle = this.f57149g.getToggle(f57140f);
        ApolloAPI.Experiment experiment = toggle.getExperiment();
        if (experiment == null) {
            i = -1;
        } else {
            i = ((Integer) experiment.getParam("open_share", 0)).intValue();
        }
        if (!toggle.allow() || i != 1) {
            return false;
        }
        return true;
    }
}
