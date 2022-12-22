package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C2434Util;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(true).cipherSuites(f5125f).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(f5125f).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec RESTRICTED_TLS = new Builder(true).cipherSuites(f5124e).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();

    /* renamed from: e */
    private static final CipherSuite[] f5124e = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};

    /* renamed from: f */
    private static final CipherSuite[] f5125f = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: a */
    final boolean f5126a;

    /* renamed from: b */
    final boolean f5127b;
    @Nullable

    /* renamed from: c */
    final String[] f5128c;
    @Nullable

    /* renamed from: d */
    final String[] f5129d;

    ConnectionSpec(Builder builder) {
        this.f5126a = builder.tls;
        this.f5128c = builder.cipherSuites;
        this.f5129d = builder.tlsVersions;
        this.f5127b = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.f5126a;
    }

    @Nullable
    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.f5128c;
        if (strArr != null) {
            return CipherSuite.m3325a(strArr);
        }
        return null;
    }

    @Nullable
    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.f5129d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean supportsTlsExtensions() {
        return this.f5127b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24710a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m3333b(sSLSocket, z);
        String[] strArr = b.f5129d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f5128c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m3333b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f5128c != null) {
            strArr = C2434Util.intersect(CipherSuite.f5113a, sSLSocket.getEnabledCipherSuites(), this.f5128c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5129d != null) {
            strArr2 = C2434Util.intersect(C2434Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.f5129d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = C2434Util.indexOf(CipherSuite.f5113a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && indexOf != -1) {
            strArr = C2434Util.concat(strArr, supportedCipherSuites[indexOf]);
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(strArr2).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f5126a) {
            return false;
        }
        if (this.f5129d != null && !C2434Util.nonEmptyIntersection(C2434Util.NATURAL_ORDER, this.f5129d, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f5128c == null || C2434Util.nonEmptyIntersection(CipherSuite.f5113a, this.f5128c, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f5126a;
        if (z != connectionSpec.f5126a) {
            return false;
        }
        return !z || (Arrays.equals(this.f5128c, connectionSpec.f5128c) && Arrays.equals(this.f5129d, connectionSpec.f5129d) && this.f5127b == connectionSpec.f5127b);
    }

    public int hashCode() {
        if (this.f5126a) {
            return ((((527 + Arrays.hashCode(this.f5128c)) * 31) + Arrays.hashCode(this.f5129d)) * 31) + (this.f5127b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5126a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f5128c != null ? cipherSuites().toString() : str;
        if (this.f5129d != null) {
            str = tlsVersions().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f5127b + ")";
    }

    public static final class Builder {
        @Nullable
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        @Nullable
        String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.f5126a;
            this.cipherSuites = connectionSpec.f5128c;
            this.tlsVersions = connectionSpec.f5129d;
            this.supportsTlsExtensions = connectionSpec.f5127b;
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
                    strArr[i] = cipherSuiteArr[i].f5115b;
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
