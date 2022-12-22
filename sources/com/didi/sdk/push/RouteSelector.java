package com.didi.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.push.proxy.AddressProxy;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class RouteSelector {
    private List<InetAddress> addresses = new ArrayList();
    private Context context;
    private Dns dns;
    private String host;
    private int port;
    private IRouteStrategy strategy;

    public RouteSelector(Context context2, String str, int i, Dns dns2, IRouteStrategy iRouteStrategy) {
        this.context = context2;
        this.host = str;
        this.port = i;
        this.dns = dns2;
        this.strategy = iRouteStrategy;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ip */
    public String mo95582ip() {
        String ip = AddressProxy.getProxy(this.context).getIp();
        int port2 = AddressProxy.getProxy(this.context).getPort();
        if (!TextUtils.isEmpty(ip) && port2 > 0) {
            return ip;
        }
        return this.strategy.select(selectAll());
    }

    /* access modifiers changed from: package-private */
    public int port() {
        String ip = AddressProxy.getProxy(this.context).getIp();
        int port2 = AddressProxy.getProxy(this.context).getPort();
        if (!TextUtils.isEmpty(ip) && port2 > 0) {
            return port2;
        }
        int port3 = PushSelector.getDefault().getPort();
        return port3 > 0 ? port3 : this.port;
    }

    private List<String> selectAll() {
        resetInetSocketAddress();
        if (!this.addresses.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (InetAddress hostAddress : this.addresses) {
                arrayList.add(hostAddress.getHostAddress());
            }
            return arrayList;
        }
        return Arrays.asList(new String[]{this.host});
    }

    private void resetInetSocketAddress() {
        try {
            this.addresses.clear();
            List<InetAddress> lookup = this.dns.lookup(this.host);
            if (!PushClient.getClient().supportIpv6()) {
                Iterator<InetAddress> it = lookup.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof Inet6Address) {
                        PushLog.m26280d(PushCallback.TAG, "remove ipv6:");
                        it.remove();
                    }
                }
            }
            this.addresses.addAll(lookup);
        } catch (Throwable unused) {
        }
    }
}
