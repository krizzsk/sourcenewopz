package didihttpdns.p230db;

import android.content.Context;
import android.os.SystemClock;
import didihttpdns.cache.HttpDnsCache;
import didihttpdns.model.DnsRecord;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import java.util.HashMap;
import java.util.List;

/* renamed from: didihttpdns.db.UseOnceStrategy */
public class UseOnceStrategy implements DBCacheStrategy {
    public static final String TAG = "UseOnceStrategy";

    /* renamed from: a */
    Thread f57028a = new Thread() {
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            List<DnsRecord> queryAllDnsInfo = UseOnceStrategy.this.f57030c.queryAllDnsInfo();
            if (queryAllDnsInfo != null && queryAllDnsInfo.size() > 0) {
                for (DnsRecord next : queryAllDnsInfo) {
                    Logger.m40928d(UseOnceStrategy.TAG, "- ->" + next.getHost());
                    next.setType(DBCacheType.USE_CACHE_ONCE.getValue());
                    UseOnceStrategy.this.f57031d.put(next.getHost(), next);
                }
                long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("query ");
                sb.append(queryAllDnsInfo.size());
                sb.append(" data waste ");
                long j = currentThreadTimeMillis2 - currentThreadTimeMillis;
                sb.append(j);
                sb.append("ms");
                Logger.m40928d(UseOnceStrategy.TAG, sb.toString());
                if (queryAllDnsInfo.size() >= 100) {
                    UseOnceStrategy.this.m40921a(String.valueOf(queryAllDnsInfo.size()), String.valueOf(j / 1000));
                }
            }
        }
    };

    /* renamed from: b */
    private Context f57029b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DnsDBHelper f57030c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HttpDnsCache f57031d;

    public UseOnceStrategy(Context context, HttpDnsCache httpDnsCache) {
        this.f57029b = context;
        this.f57030c = DnsDBHelper.getInstance(context);
        this.f57031d = httpDnsCache;
    }

    public void readFromDb() {
        this.f57028a.start();
    }

    public void writeToDb(DnsRecord dnsRecord) {
        this.f57030c.insertOrUpdateDnsRecord(dnsRecord);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40921a(String str, String str2) {
        OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
        HashMap hashMap = new HashMap();
        hashMap.put("size", str);
        hashMap.put("waste_time", str2);
        omegaAPI.trackEvent("use_cache_stats", (String) null, hashMap);
    }
}
