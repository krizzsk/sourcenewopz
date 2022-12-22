package kshark.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00018\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006!"}, mo175978d2 = {"Lkshark/internal/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "cache", "Ljava/util/LinkedHashMap;", "<set-?>", "evictionCount", "getEvictionCount", "()I", "hitCount", "getHitCount", "getMaxSize", "missCount", "getMissCount", "putCount", "getPutCount", "size", "getSize", "evictAll", "", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LruCache.kt */
public final class LruCache<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f4649a;

    /* renamed from: b */
    private int f4650b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f4651c;

    /* renamed from: d */
    private int f4652d;

    /* renamed from: e */
    private int f4653e;

    /* renamed from: f */
    private final int f4654f;

    public LruCache(int i) {
        this.f4654f = i;
        if (i > 0) {
            this.f4649a = new LinkedHashMap<K, V>(this, this.f4654f, 0.75f, true) {
                final /* synthetic */ LruCache this$0;

                {
                    this.this$0 = r1;
                }

                public final Set<Map.Entry<K, V>> entrySet() {
                    return getEntries();
                }

                public Set getEntries() {
                    return super.entrySet();
                }

                public Set getKeys() {
                    return super.keySet();
                }

                public int getSize() {
                    return super.size();
                }

                public Collection getValues() {
                    return super.values();
                }

                public final Set<K> keySet() {
                    return getKeys();
                }

                public final int size() {
                    return getSize();
                }

                public final Collection<V> values() {
                    return getValues();
                }

                /* access modifiers changed from: protected */
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    if (size() < this.this$0.getMaxSize()) {
                        return false;
                    }
                    LruCache lruCache = this.this$0;
                    lruCache.f4651c = lruCache.getEvictionCount() + 1;
                    return true;
                }
            };
            return;
        }
        throw new IllegalArgumentException(("maxSize=" + this.f4654f + " <= 0").toString());
    }

    public final int getMaxSize() {
        return this.f4654f;
    }

    public final int getSize() {
        return this.f4649a.size();
    }

    public final int getPutCount() {
        return this.f4650b;
    }

    public final int getEvictionCount() {
        return this.f4651c;
    }

    public final int getHitCount() {
        return this.f4652d;
    }

    public final int getMissCount() {
        return this.f4653e;
    }

    public final V get(K k) {
        V v = this.f4649a.get(k);
        if (v != null) {
            this.f4652d++;
            return v;
        }
        this.f4653e++;
        return null;
    }

    public final V put(K k, V v) {
        this.f4650b++;
        return this.f4649a.put(k, v);
    }

    public final V remove(K k) {
        return this.f4649a.remove(k);
    }

    public final void evictAll() {
        this.f4649a.clear();
    }

    public String toString() {
        int i = this.f4652d;
        int i2 = this.f4653e + i;
        int i3 = i2 != 0 ? (i * 100) / i2 : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Arrays.copyOf(new Object[]{Integer.valueOf(this.f4654f), Integer.valueOf(this.f4652d), Integer.valueOf(this.f4653e), Integer.valueOf(i3)}, 4));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
