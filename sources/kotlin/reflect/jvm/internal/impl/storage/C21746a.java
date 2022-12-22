package kotlin.reflect.jvm.internal.impl.storage;

/* renamed from: kotlin.reflect.jvm.internal.impl.storage.a */
/* compiled from: SingleThreadValue */
class C21746a<T> {

    /* renamed from: a */
    private final T f61077a;

    /* renamed from: b */
    private final Thread f61078b = Thread.currentThread();

    C21746a(T t) {
        this.f61077a = t;
    }

    /* renamed from: a */
    public boolean mo179969a() {
        return this.f61078b == Thread.currentThread();
    }

    /* renamed from: b */
    public T mo179970b() {
        if (mo179969a()) {
            return this.f61077a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }
}
