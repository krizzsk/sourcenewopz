package didihttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {

    /* renamed from: a */
    final Address f56505a;

    /* renamed from: b */
    final Proxy f56506b;

    /* renamed from: c */
    final InetSocketAddress f56507c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f56505a = address;
            this.f56506b = proxy;
            this.f56507c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.f56505a;
    }

    public Proxy proxy() {
        return this.f56506b;
    }

    public InetSocketAddress socketAddress() {
        return this.f56507c;
    }

    public boolean requiresTunnel() {
        return this.f56505a.f56316i != null && this.f56506b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (!this.f56505a.equals(route.f56505a) || !this.f56506b.equals(route.f56506b) || !this.f56507c.equals(route.f56507c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f56505a.hashCode()) * 31) + this.f56506b.hashCode()) * 31) + this.f56507c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f56507c + "}";
    }
}
