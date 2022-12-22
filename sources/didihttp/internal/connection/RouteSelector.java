package didihttp.internal.connection;

import didihttp.Address;
import didihttp.Call;
import didihttp.HttpUrl;
import didihttp.LogEventListener;
import didihttp.Route;
import didihttp.internal.C20747Util;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.HttpDnsManager;
import didinet.ApolloAPI;
import didinet.NetEngine;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector {

    /* renamed from: a */
    private static final String f56669a = "android_http_disable_ipv6";

    /* renamed from: b */
    private final Address f56670b;

    /* renamed from: c */
    private final RouteDatabase f56671c;

    /* renamed from: d */
    private Proxy f56672d;

    /* renamed from: e */
    private InetSocketAddress f56673e;

    /* renamed from: f */
    private List<Proxy> f56674f = Collections.emptyList();

    /* renamed from: g */
    private int f56675g;

    /* renamed from: h */
    private List<InetSocketAddress> f56676h = Collections.emptyList();

    /* renamed from: i */
    private int f56677i;

    /* renamed from: j */
    private int f56678j;

    /* renamed from: k */
    private final List<Route> f56679k = new ArrayList();

    /* renamed from: l */
    private Call f56680l;

    /* renamed from: m */
    private LogEventListener f56681m;

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, LogEventListener logEventListener) {
        this.f56670b = address;
        this.f56671c = routeDatabase;
        this.f56680l = call;
        this.f56681m = logEventListener;
        m40690a(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return m40695d() || m40693b() || m40697f();
    }

    public Route next() throws IOException {
        if (!m40695d()) {
            if (m40693b()) {
                this.f56672d = m40694c();
            } else if (m40697f()) {
                return m40698g();
            } else {
                if (m40692a()) {
                    int i = this.f56678j + 1;
                    this.f56678j = i;
                    this.f56678j = i % this.f56676h.size();
                    return new Route(this.f56670b, this.f56672d, this.f56676h.get(this.f56678j));
                }
                throw new NoSuchElementException();
            }
        }
        InetSocketAddress e = m40696e();
        this.f56673e = e;
        Route route = new Route(this.f56670b, this.f56672d, e);
        if (!this.f56671c.shouldPostpone(route)) {
            return route;
        }
        this.f56679k.add(route);
        return next();
    }

    public Route tryNext() {
        try {
            return next();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m40692a() {
        return NetEngine.getInstance().getNetConfig().useTotalTimeout() && hasInetSocketAddress();
    }

    public boolean hasInetSocketAddress() {
        return this.f56676h.size() > 0;
    }

    public void resetProxy() {
        m40690a(this.f56670b.url(), this.f56670b.proxy());
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f56670b.proxySelector() == null)) {
            this.f56670b.proxySelector().connectFailed(this.f56670b.url().uri(), route.proxy().address(), iOException);
        }
        this.f56671c.failed(route);
    }

    /* renamed from: a */
    private void m40690a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f56674f = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f56670b.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = C20747Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C20747Util.immutableList(select);
            }
            this.f56674f = list;
        }
        this.f56675g = 0;
    }

    /* renamed from: b */
    private boolean m40693b() {
        return this.f56675g < this.f56674f.size();
    }

    /* renamed from: c */
    private Proxy m40694c() throws IOException {
        if (m40693b()) {
            List<Proxy> list = this.f56674f;
            int i = this.f56675g;
            this.f56675g = i + 1;
            Proxy proxy = list.get(i);
            m40691a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f56670b.url().host() + "; exhausted proxy configurations: " + this.f56674f);
    }

    /* renamed from: a */
    private void m40691a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f56676h = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f56670b.url().host();
            i = this.f56670b.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m40689a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f56676h.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f56681m.dnsStart(this.f56680l, str);
            try {
                List<InetAddress> lookup = this.f56670b.dns().lookup(str);
                ArrayList arrayList = new ArrayList();
                ApolloAPI.Toggle toggle = NetEngine.getInstance().getApolloAPI().getToggle(f56669a);
                if (toggle == null || !toggle.allow()) {
                    for (InetAddress next : lookup) {
                        if (next instanceof Inet6Address) {
                            arrayList.add(next);
                        }
                    }
                    for (InetAddress next2 : lookup) {
                        if (!arrayList.contains(next2)) {
                            arrayList.add(next2);
                        }
                    }
                } else {
                    for (InetAddress next3 : lookup) {
                        if (!(next3 instanceof Inet6Address)) {
                            arrayList.add(next3);
                        }
                    }
                }
                this.f56681m.dnsEnd(this.f56680l, str, arrayList);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f56676h.add(new InetSocketAddress((InetAddress) arrayList.get(i2), i));
                }
            } catch (UnknownHostException e) {
                this.f56681m.dnsFailed(this.f56680l, str, e);
                throw new UnknownHostException("unable to resolve host " + str);
            }
        }
        this.f56677i = 0;
    }

    /* renamed from: a */
    static String m40689a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: d */
    private boolean m40695d() {
        return this.f56677i < this.f56676h.size();
    }

    /* renamed from: e */
    private InetSocketAddress m40696e() throws IOException {
        if (m40695d()) {
            List<InetSocketAddress> list = this.f56676h;
            int i = this.f56677i;
            this.f56677i = i + 1;
            InetSocketAddress inetSocketAddress = list.get(i);
            if (!HttpDnsManager.getInstance().ignoreIpv6Limit(inetSocketAddress)) {
                while (inetSocketAddress.getAddress() != null && (inetSocketAddress.getAddress() instanceof Inet6Address) && (!NetEngine.getInstance().supportIpv6() || (HttpDnsApolloConfig.getConfig().isEnableIpv6Apollo() && !HttpDnsApolloConfig.getConfig().isIpv6Permit(this.f56670b.url().toString())))) {
                    if (m40695d()) {
                        List<InetSocketAddress> list2 = this.f56676h;
                        int i2 = this.f56677i;
                        this.f56677i = i2 + 1;
                        inetSocketAddress = list2.get(i2);
                    } else {
                        throw new SocketException("No route to " + this.f56670b.url().host() + "; exhausted inet socket addresses: " + this.f56676h);
                    }
                }
            }
            return inetSocketAddress;
        }
        throw new SocketException("No route to " + this.f56670b.url().host() + "; exhausted inet socket addresses: " + this.f56676h);
    }

    /* renamed from: f */
    private boolean m40697f() {
        return !this.f56679k.isEmpty();
    }

    /* renamed from: g */
    private Route m40698g() {
        return this.f56679k.remove(0);
    }
}
