package didihttpdns.p230db;

import didihttpdns.model.DnsRecord;

/* renamed from: didihttpdns.db.DBCacheStrategy */
public interface DBCacheStrategy {
    void readFromDb();

    void writeToDb(DnsRecord dnsRecord);
}
