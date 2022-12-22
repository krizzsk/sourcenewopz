package didihttp;

import didihttp.internal.C20747Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;

    /* renamed from: e */
    private static final CipherSuite[] f56356e = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: a */
    final boolean f56357a;

    /* renamed from: b */
    final boolean f56358b;

    /* renamed from: c */
    final String[] f56359c;

    /* renamed from: d */
    final String[] f56360d;

    static {
        ConnectionSpec build = new Builder(true).cipherSuites(f56356e).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        MODERN_TLS = build;
        COMPATIBLE_TLS = new Builder(build).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    }

    ConnectionSpec(Builder builder) {
        this.f56357a = builder.tls;
        this.f56359c = builder.cipherSuites;
        this.f56360d = builder.tlsVersions;
        this.f56358b = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.f56357a;
    }

    public List<CipherSuite> cipherSuites() {
        if (this.f56359c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f56359c.length);
        for (String forJavaName : this.f56359c) {
            arrayList.add(CipherSuite.forJavaName(forJavaName));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<TlsVersion> tlsVersions() {
        if (this.f56360d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f56360d.length);
        for (String forJavaName : this.f56360d) {
            arrayList.add(TlsVersion.forJavaName(forJavaName));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean supportsTlsExtensions() {
        return this.f56358b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169433a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m40573b(sSLSocket, z);
        String[] strArr = b.f56360d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f56359c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m40573b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3 = this.f56359c;
        if (strArr3 != null) {
            strArr = (String[]) C20747Util.intersect(String.class, strArr3, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr4 = this.f56360d;
        if (strArr4 != null) {
            strArr2 = (String[]) C20747Util.intersect(String.class, strArr4, sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && C20747Util.indexOf(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            strArr = C20747Util.concat(strArr, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(strArr2).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f56357a) {
            return false;
        }
        String[] strArr = this.f56360d;
        if (strArr != null && !m40572a(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f56359c;
        if (strArr2 == null || m40572a(strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m40572a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String indexOf : strArr) {
                if (C20747Util.indexOf(strArr2, indexOf) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f56357a;
        if (z != connectionSpec.f56357a) {
            return false;
        }
        return !z || (Arrays.equals(this.f56359c, connectionSpec.f56359c) && Arrays.equals(this.f56360d, connectionSpec.f56360d) && this.f56358b == connectionSpec.f56358b);
    }

    public int hashCode() {
        if (this.f56357a) {
            return ((((527 + Arrays.hashCode(this.f56359c)) * 31) + Arrays.hashCode(this.f56360d)) * 31) + (this.f56358b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f56357a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f56359c != null ? cipherSuites().toString() : str;
        if (this.f56360d != null) {
            str = tlsVersions().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f56358b + ")";
    }

    public static final class Builder {
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.f56357a;
            this.cipherSuites = connectionSpec.f56359c;
            this.tlsVersions = connectionSpec.f56360d;
            this.supportsTlsExtensions = connectionSpec.f56358b;
        }

        public Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].f56347a;
                }
                return cipherSuites(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.cipherSuites = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return tlsVersions(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.tlsVersions = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}
