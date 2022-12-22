package p056catch;

/* renamed from: catch.if */
/* compiled from: Interpolator */
public abstract class C1280if<T> {

    /* renamed from: a */
    final T f477a;

    /* renamed from: b */
    final T f478b;

    /* renamed from: c */
    private final long f479c;

    /* renamed from: d */
    private long f480d = -1;

    C1280if(long j, T t, T t2) {
        this.f479c = j;
        this.f477a = t;
        this.f478b = t2;
    }

    /* renamed from: do */
    public T mo14151do() {
        if (this.f480d == -1) {
            return this.f477a;
        }
        return mo14149do(((float) Math.min(System.currentTimeMillis() - this.f480d, this.f479c)) / ((float) this.f479c));
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public abstract T mo14149do(float f);

    /* renamed from: if */
    public void mo14152if() {
        this.f480d = System.currentTimeMillis();
    }
}
