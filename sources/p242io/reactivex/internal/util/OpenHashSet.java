package p242io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.OpenHashSet */
public final class OpenHashSet<T> {

    /* renamed from: f */
    private static final int f59293f = -1640531527;

    /* renamed from: a */
    final float f59294a;

    /* renamed from: b */
    int f59295b;

    /* renamed from: c */
    int f59296c;

    /* renamed from: d */
    int f59297d;

    /* renamed from: e */
    T[] f59298e;

    /* renamed from: a */
    static int m41866a(int i) {
        int i2 = i * f59293f;
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f59294a = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.f59295b = roundToPowerOfTwo - 1;
        this.f59297d = (int) (f * ((float) roundToPowerOfTwo));
        this.f59298e = (Object[]) new Object[roundToPowerOfTwo];
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.f59298e;
        int i = this.f59295b;
        int a = m41866a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a] = t;
        int i2 = this.f59296c + 1;
        this.f59296c = i2;
        if (i2 >= this.f59297d) {
            mo175254a();
        }
        return true;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.f59298e;
        int i = this.f59295b;
        int a = m41866a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return mo175255a(a, tArr, i);
        }
        do {
            a = (a + 1) & i;
            t2 = tArr[a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return mo175255a(a, tArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175255a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f59296c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = m41866a(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= a || a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175254a() {
        T[] tArr = this.f59298e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (Object[]) new Object[i];
        int i3 = this.f59296c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a = m41866a(tArr[length].hashCode()) & i2;
                if (tArr2[a] != null) {
                    do {
                        a = (a + 1) & i2;
                    } while (tArr2[a] != null);
                }
                tArr2[a] = tArr[length];
                i3 = i4;
            } else {
                this.f59295b = i2;
                this.f59297d = (int) (((float) i) * this.f59294a);
                this.f59298e = tArr2;
                return;
            }
        }
    }

    public Object[] keys() {
        return this.f59298e;
    }

    public int size() {
        return this.f59296c;
    }
}
