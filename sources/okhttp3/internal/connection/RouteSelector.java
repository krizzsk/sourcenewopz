package okhttp3.internal.connection;

import java.io.IOException;
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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.C2434Util;

public final class RouteSelector {

    /* renamed from: a */
    private final Address f5331a;

    /* renamed from: b */
    private final RouteDatabase f5332b;

    /* renamed from: c */
    private final Call f5333c;

    /* renamed from: d */
    private final EventListener f5334d;

    /* renamed from: e */
    private List<Proxy> f5335e = Collections.emptyList();

    /* renamed from: f */
    private int f5336f;

    /* renamed from: g */
    private List<InetSocketAddress> f5337g = Collections.emptyList();

    /* renamed from: h */
    private final List<Route> f5338h = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f5331a = address;
        this.f5332b = routeDatabase;
        this.f5333c = call;
        this.f5334d = eventListener;
        m3422a(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return m3423a() || !this.f5338h.isEmpty();
    }

    public Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (m3423a()) {
                Proxy b = m3424b();
                int size = this.f5337g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.f5331a, b, this.f5337g.get(i));
                    if (this.f5332b.shouldPostpone(route)) {
                        this.f5338h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f5338h);
                this.f5338h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f5331a.proxySelector() == null)) {
            this.f5331a.proxySelector().connectFailed(this.f5331a.url().uri(), route.proxy().address(), iOException);
        }
        this.f5332b.failed(route);
    }

    /* renamed from: a */
    private void m3422a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f5335e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f5331a.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = C2434Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C2434Util.immutableList(select);
            }
            this.f5335e = list;
        }
        this.f5336f = 0;
    }

    /* renamed from: a */
    private boolean m3423a() {
        return this.f5336f < this.f5335e.size();
    }

    /* renamed from: b */
    private Proxy m3424b() throws IOException {
        if (m3423a()) {
            List<Proxy> list = this.f5335e;
            int i = this.f5336f;
            this.f5336f = i + 1;
            Proxy proxy = list.get(i);
            m3421a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5331a.url().host() + "; exhausted proxy configurations: " + this.f5335e);
    }

    /* renamed from: a */
    private void m3421a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f5337g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f5331a.url().host();
            i = this.f5331a.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m3420a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f5337g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f5334d.dnsStart(this.f5333c, str);
            List<InetAddress> lookup = this.f5331a.dns().lookup(str);
            if (!lookup.isEmpty()) {
                this.f5334d.dnsEnd(this.f5333c, str, lookup);
                int size = lookup.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f5337g.add(new InetSocketAddress(lookup.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f5331a.dns() + " returned no addresses for " + str);
        }
    }

    /* renamed from: a */
    static String m3420a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class Selection {
        private int nextRouteIndex = 0;
        private final List<Route> routes;

        Selection(List<Route> list) {
            this.routes = list;
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i = this.nextRouteIndex;
                this.nextRouteIndex = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<Route> getAll() {
            return new ArrayList(this.routes);
        }
    }
}
