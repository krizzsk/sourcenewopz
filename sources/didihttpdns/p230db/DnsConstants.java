package didihttpdns.p230db;

/* renamed from: didihttpdns.db.DnsConstants */
public interface DnsConstants {
    public static final String CREATE_DNS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS dns(id INTEGER PRIMARY KEY AUTOINCREMENT,host TEXT,ips TEXT,type INTEGER,time INTEGER,ttl INTEGER);";
    public static final String DATABASE_NAME = "dns_record.db";
    public static final int DATABASE_VERSION = 5;
    public static final String DELETE_ALL_DNS_SQL = "DELETE FROM dns";
    public static final String DNS_TABLE_NAME = "dns";
    public static final String HOST = "host";

    /* renamed from: ID */
    public static final String f57023ID = "id";
    public static final String IPS = "ips";
    public static final String TIME = "time";
    public static final String TTL = "ttl";
    public static final String TYPE = "type";
}
