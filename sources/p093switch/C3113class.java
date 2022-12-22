package p093switch;

/* renamed from: switch.class */
/* compiled from: Throttler */
public class C3113class<T> {

    /* renamed from: a */
    private T f6941a = null;

    /* renamed from: b */
    private long f6942b = -1;

    /* renamed from: c */
    private final long f6943c;

    public C3113class(long j) {
        this.f6943c = j;
    }

    /* renamed from: do */
    public T mo38617do() {
        return this.f6941a;
    }

    /* renamed from: if */
    public T mo38619if(T t) {
        if ((this.f6942b != -1 && System.currentTimeMillis() - this.f6942b < this.f6943c) || t == this.f6941a) {
            return this.f6941a;
        }
        this.f6941a = t;
        this.f6942b = System.currentTimeMillis();
        return t;
    }

    /* renamed from: do */
    public void mo38618do(T t) {
        this.f6941a = t;
        this.f6942b = System.currentTimeMillis();
    }
}
