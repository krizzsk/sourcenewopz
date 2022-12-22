package didihttpdns.cache;

import didihttpdns.model.DnsRecord;
import java.util.List;

public interface HttpDnsCache {
    void evict(String str);

    void evictAll();

    DnsRecord get(String str);

    void put(String str, DnsRecord dnsRecord);

    void putAll(List<DnsRecord> list, boolean z);
}
