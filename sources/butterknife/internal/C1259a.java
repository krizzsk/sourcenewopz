package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

/* renamed from: butterknife.internal.a */
/* compiled from: ImmutableList */
final class C1259a<T> extends AbstractList<T> implements RandomAccess {

    /* renamed from: a */
    private final T[] f445a;

    C1259a(T[] tArr) {
        this.f445a = tArr;
    }

    public T get(int i) {
        return this.f445a[i];
    }

    public int size() {
        return this.f445a.length;
    }

    public boolean contains(Object obj) {
        for (T t : this.f445a) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }
}
