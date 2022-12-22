package p242io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p242io.reactivex.internal.fuseable.SimplePlainQueue;
import p242io.reactivex.internal.util.Pow2;

/* renamed from: io.reactivex.internal.queue.SpscLinkedArrayQueue */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: a */
    static final int f59191a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f59192j = new Object();

    /* renamed from: b */
    final AtomicLong f59193b = new AtomicLong();

    /* renamed from: c */
    int f59194c;

    /* renamed from: d */
    long f59195d;

    /* renamed from: e */
    final int f59196e;

    /* renamed from: f */
    AtomicReferenceArray<Object> f59197f;

    /* renamed from: g */
    final int f59198g;

    /* renamed from: h */
    AtomicReferenceArray<Object> f59199h;

    /* renamed from: i */
    final AtomicLong f59200i = new AtomicLong();

    /* renamed from: b */
    private static int m41852b(int i) {
        return i;
    }

    public SpscLinkedArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.f59197f = atomicReferenceArray;
        this.f59196e = i2;
        m41846a(roundToPowerOfTwo);
        this.f59199h = atomicReferenceArray;
        this.f59198g = i2;
        this.f59195d = (long) (i2 - 1);
        m41847a(0);
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f59197f;
            long c = m41857c();
            int i = this.f59196e;
            int a = m41842a(c, i);
            if (c < this.f59195d) {
                return m41851a(atomicReferenceArray, t, c, a);
            }
            long j = ((long) this.f59194c) + c;
            if (m41854b(atomicReferenceArray, m41842a(j, i)) == null) {
                this.f59195d = j - 1;
                return m41851a(atomicReferenceArray, t, c, a);
            } else if (m41854b(atomicReferenceArray, m41842a(1 + c, i)) == null) {
                return m41851a(atomicReferenceArray, t, c, a);
            } else {
                m41849a(atomicReferenceArray, c, a, t, (long) i);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    /* renamed from: a */
    private boolean m41851a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m41848a(atomicReferenceArray, i, (Object) t);
        m41847a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m41849a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f59197f = atomicReferenceArray2;
        this.f59195d = (j2 + j) - 1;
        m41848a(atomicReferenceArray2, i, (Object) t);
        m41850a(atomicReferenceArray, atomicReferenceArray2);
        m41848a(atomicReferenceArray, i, f59192j);
        m41847a(j + 1);
    }

    /* renamed from: a */
    private void m41850a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m41848a(atomicReferenceArray, m41852b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m41845a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b = m41852b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m41854b(atomicReferenceArray, b);
        m41848a(atomicReferenceArray, b, (Object) null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f59199h;
        long d = m41858d();
        int i = this.f59198g;
        int a = m41842a(d, i);
        T b = m41854b(atomicReferenceArray, a);
        boolean z = b == f59192j;
        if (b != null && !z) {
            m41848a(atomicReferenceArray, a, (Object) null);
            m41856b(d + 1);
            return b;
        } else if (z) {
            return m41844a(m41845a(atomicReferenceArray, i + 1), d, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m41844a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f59199h = atomicReferenceArray;
        int a = m41842a(j, i);
        T b = m41854b(atomicReferenceArray, a);
        if (b != null) {
            m41848a(atomicReferenceArray, a, (Object) null);
            m41856b(j + 1);
        }
        return b;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f59199h;
        long d = m41858d();
        int i = this.f59198g;
        T b = m41854b(atomicReferenceArray, m41842a(d, i));
        return b == f59192j ? m41855b(m41845a(atomicReferenceArray, i + 1), d, i) : b;
    }

    /* renamed from: b */
    private T m41855b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f59199h = atomicReferenceArray;
        return m41854b(atomicReferenceArray, m41842a(j, i));
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public int size() {
        long b = m41853b();
        while (true) {
            long a = m41843a();
            long b2 = m41853b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public boolean isEmpty() {
        return m41843a() == m41853b();
    }

    /* renamed from: a */
    private void m41846a(int i) {
        this.f59194c = Math.min(i / 4, f59191a);
    }

    /* renamed from: a */
    private long m41843a() {
        return this.f59193b.get();
    }

    /* renamed from: b */
    private long m41853b() {
        return this.f59200i.get();
    }

    /* renamed from: c */
    private long m41857c() {
        return this.f59193b.get();
    }

    /* renamed from: d */
    private long m41858d() {
        return this.f59200i.get();
    }

    /* renamed from: a */
    private void m41847a(long j) {
        this.f59193b.lazySet(j);
    }

    /* renamed from: b */
    private void m41856b(long j) {
        this.f59200i.lazySet(j);
    }

    /* renamed from: a */
    private static int m41842a(long j, int i) {
        return m41852b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m41848a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: b */
    private static <E> Object m41854b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f59197f;
        long a = m41843a();
        int i = this.f59196e;
        long j = 2 + a;
        if (m41854b(atomicReferenceArray, m41842a(j, i)) == null) {
            int a2 = m41842a(a, i);
            m41848a(atomicReferenceArray, a2 + 1, (Object) t2);
            m41848a(atomicReferenceArray, a2, (Object) t);
            m41847a(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f59197f = atomicReferenceArray2;
        int a3 = m41842a(a, i);
        m41848a(atomicReferenceArray2, a3 + 1, (Object) t2);
        m41848a(atomicReferenceArray2, a3, (Object) t);
        m41850a(atomicReferenceArray, atomicReferenceArray2);
        m41848a(atomicReferenceArray, a3, f59192j);
        m41847a(j);
        return true;
    }
}
