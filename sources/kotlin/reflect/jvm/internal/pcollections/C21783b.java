package kotlin.reflect.jvm.internal.pcollections;

/* renamed from: kotlin.reflect.jvm.internal.pcollections.b */
/* compiled from: IntTreePMap */
final class C21783b<V> {

    /* renamed from: a */
    private static final C21783b<Object> f61218a = new C21783b<>(C21782a.f61212a);

    /* renamed from: b */
    private final C21782a<V> f61219b;

    /* renamed from: a */
    public static <V> C21783b<V> m45128a() {
        return f61218a;
    }

    private C21783b(C21782a<V> aVar) {
        this.f61219b = aVar;
    }

    /* renamed from: a */
    private C21783b<V> m45129a(C21782a<V> aVar) {
        if (aVar == this.f61219b) {
            return this;
        }
        return new C21783b<>(aVar);
    }

    /* renamed from: a */
    public V mo180238a(int i) {
        return this.f61219b.mo180235a((long) i);
    }

    /* renamed from: a */
    public C21783b<V> mo180239a(int i, V v) {
        return m45129a(this.f61219b.mo180236a((long) i, v));
    }

    /* renamed from: b */
    public C21783b<V> mo180240b(int i) {
        return m45129a(this.f61219b.mo180237b((long) i));
    }
}
