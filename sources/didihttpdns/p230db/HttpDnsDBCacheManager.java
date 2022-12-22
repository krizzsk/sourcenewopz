package didihttpdns.p230db;

import didihttpdns.model.DnsRecord;

/* renamed from: didihttpdns.db.HttpDnsDBCacheManager */
public class HttpDnsDBCacheManager {

    /* renamed from: a */
    private DBCacheStrategy f57027a;

    public HttpDnsDBCacheManager(DBCacheStrategy dBCacheStrategy) {
        this.f57027a = dBCacheStrategy;
    }

    public void readFromDb() {
        DBCacheStrategy dBCacheStrategy = this.f57027a;
        if (dBCacheStrategy != null) {
            dBCacheStrategy.readFromDb();
        }
    }

    public void writeToDb(DnsRecord dnsRecord) {
        DBCacheStrategy dBCacheStrategy = this.f57027a;
        if (dBCacheStrategy != null) {
            dBCacheStrategy.writeToDb(dnsRecord);
        }
    }
}
