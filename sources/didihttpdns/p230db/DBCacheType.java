package didihttpdns.p230db;

/* renamed from: didihttpdns.db.DBCacheType */
public enum DBCacheType {
    NO_CACHE(0),
    USE_CACHE_ONCE(1),
    USE_CACHE_ONE_TTL(2);
    
    private int value;

    private DBCacheType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static DBCacheType valueOf(int i) {
        if (i == 0) {
            return NO_CACHE;
        }
        if (i == 1) {
            return USE_CACHE_ONCE;
        }
        if (i != 2) {
            return NO_CACHE;
        }
        return USE_CACHE_ONE_TTL;
    }
}
