package didihttp;

import didihttp.internal.C20747Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {

    /* renamed from: a */
    final HttpUrl f56308a;

    /* renamed from: b */
    final Dns f56309b;

    /* renamed from: c */
    final SocketFactory f56310c;

    /* renamed from: d */
    final Authenticator f56311d;

    /* renamed from: e */
    final List<Protocol> f56312e;

    /* renamed from: f */
    final List<ConnectionSpec> f56313f;

    /* renamed from: g */
    final ProxySelector f56314g;

    /* renamed from: h */
    final Proxy f56315h;

    /* renamed from: i */
    final SSLSocketFactory f56316i;

    /* renamed from: j */
    final HostnameVerifier f56317j;

    /* renamed from: k */
    final CertificatePinner f56318k;

    public Address(HttpUrl httpUrl, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f56308a = httpUrl;
        if (dns != null) {
            this.f56309b = dns;
            if (socketFactory != null) {
                this.f56310c = socketFactory;
                if (authenticator != null) {
                    this.f56311d = authenticator;
                    if (list != null) {
                        this.f56312e = C20747Util.immutableList(list);
                        if (list2 != null) {
                            this.f56313f = C20747Util.immutableList(list2);
                            if (proxySelector != null) {
                                this.f56314g = proxySelector;
                                this.f56315h = proxy;
                                this.f56316i = sSLSocketFactory;
                                this.f56317j = hostnameVerifier;
                                this.f56318k = certificatePinner;
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
        return this.f56308a;
    }

    public Dns dns() {
        return this.f56309b;
    }

    public SocketFactory socketFactory() {
        return this.f56310c;
    }

    public Authenticator proxyAuthenticator() {
        return this.f56311d;
    }

    public List<Protocol> protocols() {
        return this.f56312e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f56313f;
    }

    public ProxySelector proxySelector() {
        return this.f56314g;
    }

    public Proxy proxy() {
        return this.f56315h;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f56316i;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f56317j;
    }

    public CertificatePinner certificatePinner() {
        return this.f56318k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (!this.f56308a.equals(address.f56308a) || !this.f56309b.equals(address.f56309b) || !this.f56311d.equals(address.f56311d) || !this.f56312e.equals(address.f56312e) || !this.f56313f.equals(address.f56313f) || !this.f56314g.equals(address.f56314g) || !C20747Util.equal(this.f56315h, address.f56315h) || !C20747Util.equal(this.f56316i, address.f56316i) || !C20747Util.equal(this.f56317j, address.f56317j) || !C20747Util.equal(this.f56318k, address.f56318k)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f56308a.hashCode()) * 31) + this.f56309b.hashCode()) * 31) + this.f56311d.hashCode()) * 31) + this.f56312e.hashCode()) * 31) + this.f56313f.hashCode()) * 31) + this.f56314g.hashCode()) * 31;
        Proxy proxy = this.f56315h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f56316i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f56317j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f56318k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f56308a.host());
        sb.append(":");
        sb.append(this.f56308a.port());
        if (this.f56315h != null) {
            sb.append(", proxy=");
            sb.append(this.f56315h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f56314g);
        }
        sb.append("}");
        return sb.toString();
    }
}
