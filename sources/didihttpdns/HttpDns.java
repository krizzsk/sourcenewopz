package didihttpdns;

import android.text.TextUtils;
import didihttp.Dns;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.IpRecord;
import didinet.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpDns implements Dns {

    /* renamed from: a */
    private static HttpDns f56985a;

    private HttpDns() {
    }

    public static HttpDns getInstance() {
        if (f56985a == null) {
            synchronized (HttpDns.class) {
                f56985a = new HttpDns();
            }
        }
        return f56985a;
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        DnsRecord fullLookup = HttpDnsManager.getInstance().fullLookup(str);
        if (fullLookup != null) {
            ArrayList arrayList = new ArrayList();
            for (IpRecord ip : fullLookup.getIps()) {
                String ip2 = ip.getIp();
                if (!TextUtils.isEmpty(ip2)) {
                    arrayList.add(InetAddress.getByName(ip2));
                }
            }
            if (arrayList.size() > 0) {
                Logger.m40928d("HttpDnsManager", "[use] httpdns for " + str + " success");
                return arrayList;
            }
            Logger.m40928d("HttpDnsManager", "[use] httpdns for " + str + " failed: ip list is empty!");
            return Arrays.asList(InetAddress.getAllByName(str));
        }
        Logger.m40928d("HttpDnsManager", "[use] httpdns for " + str + " failed: dnsRecord is null");
        return Arrays.asList(InetAddress.getAllByName(str));
    }
}
