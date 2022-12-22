package didihttpdns.p230db;

import android.content.Context;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import didihttpdns.cache.HttpDnsCache;
import didihttpdns.model.DnsRecord;
import didinet.Logger;
import java.util.List;

/* renamed from: didihttpdns.db.UseOneTTLStrategy */
public class UseOneTTLStrategy implements DBCacheStrategy {
    public static final String TAG = "UseOneTTLStrategy";

    /* renamed from: a */
    Thread f57032a = new Thread() {
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            List<DnsRecord> queryAllDnsInfo = UseOneTTLStrategy.this.f57034c.queryAllDnsInfo();
            if (queryAllDnsInfo != null && queryAllDnsInfo.size() > 0) {
                for (DnsRecord next : queryAllDnsInfo) {
                    Logger.m40928d(UseOneTTLStrategy.TAG, "-->" + next.getHost());
                    next.setT(Math.min(next.getT(), 60));
                    next.setType(DBCacheType.USE_CACHE_ONE_TTL.getValue());
                    UseOneTTLStrategy.this.f57035d.put(next.getHost(), next);
                }
                long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                Logger.m40928d(UseOneTTLStrategy.TAG, "query " + queryAllDnsInfo.size() + " data waste " + (currentThreadTimeMillis2 - currentThreadTimeMillis) + "ms");
            }
        }
    };

    /* renamed from: b */
    private Context f57033b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DnsDBHelper f57034c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HttpDnsCache f57035d;

    public UseOneTTLStrategy(Context context, HttpDnsCache httpDnsCache) {
        this.f57033b = context;
        this.f57034c = DnsDBHelper.getInstance(context);
        this.f57035d = httpDnsCache;
    }

    public void readFromDb() {
        SystemUtils.startThread(this.f57032a);
    }

    public void writeToDb(DnsRecord dnsRecord) {
        this.f57034c.insertOrUpdateDnsRecord(dnsRecord);
    }
}
