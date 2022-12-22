package okhttp3;

import com.didi.travel.p171v2.store.IStoreCallback;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C2434Util;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f5154a;

    /* renamed from: b */
    private final CipherSuite f5155b;

    /* renamed from: c */
    private final List<Certificate> f5156c;

    /* renamed from: d */
    private final List<Certificate> f5157d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f5154a = tlsVersion;
        this.f5155b = cipherSuite;
        this.f5156c = list;
        this.f5157d = list2;
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!IStoreCallback.DEFAULT_API_DETAIL_KEY.equals(protocol)) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C2434Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C2434Util.immutableList((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(forJavaName2, forJavaName, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, C2434Util.immutableList(list), C2434Util.immutableList(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public TlsVersion tlsVersion() {
        return this.f5154a;
    }

    public CipherSuite cipherSuite() {
        return this.f5155b;
    }

    public List<Certificate> peerCertificates() {
        return this.f5156c;
    }

    @Nullable
    public Principal peerPrincipal() {
        if (!this.f5156c.isEmpty()) {
            return ((X509Certificate) this.f5156c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> localCertificates() {
        return this.f5157d;
    }

    @Nullable
    public Principal localPrincipal() {
        if (!this.f5157d.isEmpty()) {
            return ((X509Certificate) this.f5157d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!this.f5154a.equals(handshake.f5154a) || !this.f5155b.equals(handshake.f5155b) || !this.f5156c.equals(handshake.f5156c) || !this.f5157d.equals(handshake.f5157d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f5154a.hashCode()) * 31) + this.f5155b.hashCode()) * 31) + this.f5156c.hashCode()) * 31) + this.f5157d.hashCode();
    }
}
