package didihttp;

import didihttp.internal.C20747Util;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f56435a;

    /* renamed from: b */
    private final CipherSuite f56436b;

    /* renamed from: c */
    private final List<Certificate> f56437c;

    /* renamed from: d */
    private final List<Certificate> f56438d;

    /* renamed from: e */
    private byte[] f56439e;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f56435a = tlsVersion;
        this.f56436b = cipherSuite;
        this.f56437c = list;
        this.f56438d = list2;
    }

    public static Handshake get(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C20747Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C20747Util.immutableList((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                Handshake handshake = new Handshake(forJavaName2, forJavaName, list, list2);
                handshake.f56439e = sSLSession.getId();
                return handshake;
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, C20747Util.immutableList(list), C20747Util.immutableList(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public TlsVersion tlsVersion() {
        return this.f56435a;
    }

    public CipherSuite cipherSuite() {
        return this.f56436b;
    }

    public List<Certificate> peerCertificates() {
        return this.f56437c;
    }

    public Principal peerPrincipal() {
        if (!this.f56437c.isEmpty()) {
            return ((X509Certificate) this.f56437c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> localCertificates() {
        return this.f56438d;
    }

    public Principal localPrincipal() {
        if (!this.f56438d.isEmpty()) {
            return ((X509Certificate) this.f56438d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public byte[] getSessionId() {
        return this.f56439e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!C20747Util.equal(this.f56436b, handshake.f56436b) || !this.f56436b.equals(handshake.f56436b) || !this.f56437c.equals(handshake.f56437c) || !this.f56438d.equals(handshake.f56438d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        TlsVersion tlsVersion = this.f56435a;
        return ((((((527 + (tlsVersion != null ? tlsVersion.hashCode() : 0)) * 31) + this.f56436b.hashCode()) * 31) + this.f56437c.hashCode()) * 31) + this.f56438d.hashCode();
    }
}
