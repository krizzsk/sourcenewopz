package didihttpdns.cache;

import android.util.LruCache;
import didihttpdns.model.DnsRecord;

public class LruHttpDnsCache implements HttpDnsCache {

    /* renamed from: a */
    private LruCache<String, DnsRecord> f57022a = new LruCache<>(500);

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.lang.String r2, didihttpdns.model.DnsRecord r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0010
            if (r3 != 0) goto L_0x0006
            goto L_0x0010
        L_0x0006:
            android.util.LruCache<java.lang.String, didihttpdns.model.DnsRecord> r0 = r1.f57022a     // Catch:{ all -> 0x000d }
            r0.put(r2, r3)     // Catch:{ all -> 0x000d }
            monitor-exit(r1)
            return
        L_0x000d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0010:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.cache.LruHttpDnsCache.put(java.lang.String, didihttpdns.model.DnsRecord):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putAll(java.util.List<didihttpdns.model.DnsRecord> r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x002c
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x000a
            goto L_0x002c
        L_0x000a:
            if (r3 != 0) goto L_0x000f
            r1.evictAll()     // Catch:{ all -> 0x0029 }
        L_0x000f:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0029 }
        L_0x0013:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0029 }
            didihttpdns.model.DnsRecord r3 = (didihttpdns.model.DnsRecord) r3     // Catch:{ all -> 0x0029 }
            java.lang.String r0 = r3.getHost()     // Catch:{ all -> 0x0029 }
            r1.put(r0, r3)     // Catch:{ all -> 0x0029 }
            goto L_0x0013
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x002c:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.cache.LruHttpDnsCache.putAll(java.util.List, boolean):void");
    }

    public synchronized DnsRecord get(String str) {
        return this.f57022a.get(str);
    }

    public synchronized void evictAll() {
        this.f57022a.evictAll();
    }

    public synchronized void evict(String str) {
        this.f57022a.remove(str);
    }
}
