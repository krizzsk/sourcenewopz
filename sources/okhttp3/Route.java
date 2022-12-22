package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {

    /* renamed from: a */
    final Address f5252a;

    /* renamed from: b */
    final Proxy f5253b;

    /* renamed from: c */
    final InetSocketAddress f5254c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f5252a = address;
            this.f5253b = proxy;
            this.f5254c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.f5252a;
    }

    public Proxy proxy() {
        return this.f5253b;
    }

    public InetSocketAddress socketAddress() {
        return this.f5254c;
    }

    public boolean requiresTunnel() {
        return this.f5252a.f5082i != null && this.f5253b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f5252a.equals(this.f5252a) && route.f5253b.equals(this.f5253b) && route.f5254c.equals(this.f5254c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f5252a.hashCode()) * 31) + this.f5253b.hashCode()) * 31) + this.f5254c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f5254c + "}";
    }
}
