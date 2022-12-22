package com.didi.sdk.push;

import android.text.TextUtils;
import android.util.Log;
import com.didichuxing.apollo.sdk.Apollo;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.HttpDnsManager;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.IpRecord;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseSocketHttpDns implements Dns {
    private static final String APOLLO_KEY_PUSH_MULTI_ACCESS = "push_multi_access";
    private static final String EVENT_ID_PUSH_DNS_STATS = "push_dns_stats";
    private static final String TAG = "push-debug";
    private static final String TYPE_HTTP_DNS = "1";
    private static final String TYPE_LOCAL_DNS = "2";
    private static final String TYPE_NONE_DNS = "0";

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        DnsRecord fullLookup;
        ArrayList<InetAddress> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("host_name", str);
        try {
            if (Apollo.getToggle(APOLLO_KEY_PUSH_MULTI_ACCESS, true).allow() && (fullLookup = HttpDnsManager.getInstance().fullLookup(str)) != null) {
                PushLog.m26280d("push-debug", "lookup httpdns result: " + fullLookup.toString());
                for (IpRecord ip : fullLookup.getIps()) {
                    String ip2 = ip.getIp();
                    if (!TextUtils.isEmpty(ip2)) {
                        arrayList.add(InetAddress.getByName(ip2));
                    }
                }
                hashMap.put("type", "1");
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(Dns.SYSTEM.lookup(str));
                hashMap.put("type", "2");
            }
        } catch (Throwable th) {
            hashMap.put("e", Log.getStackTraceString(th));
        }
        if (arrayList.isEmpty()) {
            hashMap.put("type", "0");
        }
        if (Utils.isNetworkConnected(PushClient.getClient().getOption().getContext())) {
            PushLog.m26280d(EVENT_ID_PUSH_DNS_STATS, hashMap.toString());
            EventTracker.getInstance().trackEvent(EVENT_ID_PUSH_DNS_STATS, hashMap);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!PushClient.getClient().supportIpv6() || !HttpDnsApolloConfig.getConfig().getIpv6Hosts().contains(str)) {
            for (InetAddress inetAddress : arrayList) {
                if (!(inetAddress instanceof Inet6Address)) {
                    arrayList2.add(inetAddress);
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList = arrayList2;
        }
        PushLog.m26280d("push-debug", "dns result: " + arrayList.toString());
        return arrayList;
    }
}
