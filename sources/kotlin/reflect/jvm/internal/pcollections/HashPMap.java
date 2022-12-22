package kotlin.reflect.jvm.internal.pcollections;

public final class HashPMap<K, V> {

    /* renamed from: a */
    private static final HashPMap<Object, Object> f61209a = new HashPMap<>(C21783b.m45128a(), 0);

    /* renamed from: b */
    private final C21783b<ConsPStack<MapEntry<K, V>>> f61210b;

    /* renamed from: c */
    private final int f61211c;

    /* renamed from: b */
    private static /* synthetic */ void m45120b(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<Object, Object> hashPMap = f61209a;
        if (hashPMap == null) {
            m45120b(0);
        }
        return hashPMap;
    }

    private HashPMap(C21783b<ConsPStack<MapEntry<K, V>>> bVar, int i) {
        this.f61210b = bVar;
        this.f61211c = i;
    }

    public int size() {
        return this.f61211c;
    }

    public boolean containsKey(Object obj) {
        return m45118a(m45119a(obj.hashCode()), obj) != -1;
    }

    public V get(Object obj) {
        ConsPStack<E> a = m45119a(obj.hashCode());
        while (a != null && a.mo180221b() > 0) {
            MapEntry mapEntry = (MapEntry) a.f61206a;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            a = a.f61207b;
        }
        return null;
    }

    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack a = m45119a(k.hashCode());
        int b = a.mo180221b();
        int a2 = m45118a(a, k);
        if (a2 != -1) {
            a = a.mo180222b(a2);
        }
        ConsPStack a3 = a.mo180220a(new MapEntry(k, v));
        return new HashPMap<>(this.f61210b.mo180239a(k.hashCode(), a3), (this.f61211c - b) + a3.mo180221b());
    }

    public HashPMap<K, V> minus(Object obj) {
        ConsPStack a = m45119a(obj.hashCode());
        int a2 = m45118a(a, obj);
        if (a2 == -1) {
            return this;
        }
        ConsPStack b = a.mo180222b(a2);
        if (b.mo180221b() == 0) {
            return new HashPMap<>(this.f61210b.mo180240b(obj.hashCode()), this.f61211c - 1);
        }
        return new HashPMap<>(this.f61210b.mo180239a(obj.hashCode(), b), this.f61211c - 1);
    }

    /* renamed from: a */
    private ConsPStack<MapEntry<K, V>> m45119a(int i) {
        ConsPStack<MapEntry<K, V>> a = this.f61210b.mo180238a(i);
        return a == null ? ConsPStack.m45110a() : a;
    }

    /* renamed from: a */
    private static <K, V> int m45118a(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i = 0;
        ConsPStack<E> consPStack2 = consPStack;
        while (consPStack2 != null && consPStack2.mo180221b() > 0) {
            if (((MapEntry) consPStack2.f61206a).key.equals(obj)) {
                return i;
            }
            i++;
            consPStack2 = consPStack2.f61207b;
        }
        return -1;
    }
}
