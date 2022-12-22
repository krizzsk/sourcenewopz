package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.C2434Util;

public final class Address {

    /* renamed from: a */
    final HttpUrl f5074a;

    /* renamed from: b */
    final Dns f5075b;

    /* renamed from: c */
    final SocketFactory f5076c;

    /* renamed from: d */
    final Authenticator f5077d;

    /* renamed from: e */
    final List<Protocol> f5078e;

    /* renamed from: f */
    final List<ConnectionSpec> f5079f;

    /* renamed from: g */
    final ProxySelector f5080g;
    @Nullable

    /* renamed from: h */
    final Proxy f5081h;
    @Nullable

    /* renamed from: i */
    final SSLSocketFactory f5082i;
    @Nullable

    /* renamed from: j */
    final HostnameVerifier f5083j;
    @Nullable

    /* renamed from: k */
    final CertificatePinner f5084k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f5074a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns != null) {
            this.f5075b = dns;
            if (socketFactory != null) {
                this.f5076c = socketFactory;
                if (authenticator != null) {
                    this.f5077d = authenticator;
                    if (list != null) {
                        this.f5078e = C2434Util.immutableList(list);
                        if (list2 != null) {
                            this.f5079f = C2434Util.immutableList(list2);
                            if (proxySelector != null) {
                                this.f5080g = proxySelector;
                                this.f5081h = proxy;
                                this.f5082i = sSLSocketFactory;
                                this.f5083j = hostnameVerifier;
                                this.f5084k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public HttpUrl url() {
        return this.f5074a;
    }

    public Dns dns() {
        return this.f5075b;
    }

    public SocketFactory socketFactory() {
        return this.f5076c;
    }

    public Authenticator proxyAuthenticator() {
        return this.f5077d;
    }

    public List<Protocol> protocols() {
        return this.f5078e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f5079f;
    }

    public ProxySelector proxySelector() {
        return this.f5080g;
    }

    @Nullable
    public Proxy proxy() {
        return this.f5081h;
    }

    @Nullable
    public SSLSocketFactory sslSocketFactory() {
        return this.f5082i;
    }

    @Nullable
    public HostnameVerifier hostnameVerifier() {
        return this.f5083j;
    }

    @Nullable
    public CertificatePinner certificatePinner() {
        return this.f5084k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.f5074a.equals(address.f5074a) && mo24586a(address);
        }
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f5074a.hashCode()) * 31) + this.f5075b.hashCode()) * 31) + this.f5077d.hashCode()) * 31) + this.f5078e.hashCode()) * 31) + this.f5079f.hashCode()) * 31) + this.f5080g.hashCode()) * 31;
        Proxy proxy = this.f5081h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f5082i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f5083j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f5084k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo24586a(Address address) {
        return this.f5075b.equals(address.f5075b) && this.f5077d.equals(address.f5077d) && this.f5078e.equals(address.f5078e) && this.f5079f.equals(address.f5079f) && this.f5080g.equals(address.f5080g) && C2434Util.equal(this.f5081h, address.f5081h) && C2434Util.equal(this.f5082i, address.f5082i) && C2434Util.equal(this.f5083j, address.f5083j) && C2434Util.equal(this.f5084k, address.f5084k) && url().port() == address.url().port();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f5074a.host());
        sb.append(":");
        sb.append(this.f5074a.port());
        if (this.f5081h != null) {
            sb.append(", proxy=");
            sb.append(this.f5081h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f5080g);
        }
        sb.append("}");
        return sb.toString();
    }
}
