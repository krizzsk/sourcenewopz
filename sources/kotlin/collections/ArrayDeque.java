package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, mo175978d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ArrayDeque.kt */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final Object[] f59808d = new Object[0];

    /* renamed from: e */
    private static final int f59809e = 2147483639;

    /* renamed from: f */
    private static final int f59810f = 10;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f59811a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object[] f59812b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f59813c;

    public int getSize() {
        return this.f59813c;
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = f59808d;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        this.f59812b = objArr;
    }

    public ArrayDeque() {
        this.f59812b = f59808d;
    }

    public ArrayDeque(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean z = false;
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            this.f59812b = array;
            this.f59813c = array.length;
            if (array.length == 0 ? true : z) {
                this.f59812b = f59808d;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: a */
    private final void m42593a(int i) {
        if (i >= 0) {
            Object[] objArr = this.f59812b;
            if (i > objArr.length) {
                if (objArr == f59808d) {
                    this.f59812b = new Object[RangesKt.coerceAtLeast(i, 10)];
                } else {
                    m42596b(Companion.newCapacity$kotlin_stdlib(objArr.length, i));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    /* renamed from: b */
    private final void m42596b(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.f59812b;
        ArraysKt.copyInto((T[]) objArr2, (T[]) objArr, 0, this.f59811a, objArr2.length);
        Object[] objArr3 = this.f59812b;
        int length = objArr3.length;
        int i2 = this.f59811a;
        ArraysKt.copyInto((T[]) objArr3, (T[]) objArr, length - i2, 0, i2);
        this.f59811a = 0;
        this.f59812b = objArr;
    }

    /* renamed from: c */
    private final E m42597c(int i) {
        return this.f59812b[i];
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final int m42598d(int i) {
        Object[] objArr = this.f59812b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final int m42599e(int i) {
        return i < 0 ? i + this.f59812b.length : i;
    }

    /* renamed from: f */
    private final int m42600f(int i) {
        return m42598d(this.f59811a + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final int m42601g(int i) {
        if (i == ArraysKt.getLastIndex((T[]) this.f59812b)) {
            return 0;
        }
        return i + 1;
    }

    /* renamed from: h */
    private final int m42602h(int i) {
        return i == 0 ? ArraysKt.getLastIndex((T[]) this.f59812b) : i - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final E first() {
        if (!isEmpty()) {
            return this.f59812b[this.f59811a];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.f59812b[this.f59811a];
    }

    public final E last() {
        if (!isEmpty()) {
            return this.f59812b[m42598d(this.f59811a + CollectionsKt.getLastIndex(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.f59812b[m42598d(this.f59811a + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E e) {
        m42593a(size() + 1);
        int h = m42602h(this.f59811a);
        this.f59811a = h;
        this.f59812b[h] = e;
        this.f59813c = size() + 1;
    }

    public final void addLast(E e) {
        m42593a(size() + 1);
        this.f59812b[m42598d(this.f59811a + size())] = e;
        this.f59813c = size() + 1;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E e = this.f59812b[this.f59811a];
            Object[] objArr = this.f59812b;
            int i = this.f59811a;
            objArr[i] = null;
            this.f59811a = m42601g(i);
            this.f59813c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int access$positiveMod = m42598d(this.f59811a + CollectionsKt.getLastIndex(this));
            E e = this.f59812b[access$positiveMod];
            this.f59812b[access$positiveMod] = null;
            this.f59813c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void add(int i, E e) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (i == size()) {
            addLast(e);
        } else if (i == 0) {
            addFirst(e);
        } else {
            m42593a(size() + 1);
            int access$positiveMod = m42598d(this.f59811a + i);
            if (i < ((size() + 1) >> 1)) {
                int h = m42602h(access$positiveMod);
                int h2 = m42602h(this.f59811a);
                int i2 = this.f59811a;
                if (h >= i2) {
                    Object[] objArr = this.f59812b;
                    objArr[h2] = objArr[i2];
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i2, i2 + 1, h + 1);
                } else {
                    Object[] objArr2 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, i2 - 1, i2, objArr2.length);
                    Object[] objArr3 = this.f59812b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, 0, 1, h + 1);
                }
                this.f59812b[h] = e;
                this.f59811a = h2;
            } else {
                int access$positiveMod2 = m42598d(this.f59811a + size());
                if (access$positiveMod < access$positiveMod2) {
                    Object[] objArr4 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr4, (T[]) objArr4, access$positiveMod + 1, access$positiveMod, access$positiveMod2);
                } else {
                    Object[] objArr5 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, 1, 0, access$positiveMod2);
                    Object[] objArr6 = this.f59812b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, access$positiveMod + 1, access$positiveMod, objArr6.length - 1);
                }
                this.f59812b[access$positiveMod] = e;
            }
            this.f59813c = size() + 1;
        }
    }

    /* renamed from: a */
    private final void m42594a(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f59812b.length;
        while (i < length && it.hasNext()) {
            this.f59812b[i] = it.next();
            i++;
        }
        int i2 = this.f59811a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f59812b[i3] = it.next();
        }
        this.f59813c = size() + collection.size();
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m42593a(size() + collection.size());
        m42594a(m42598d(this.f59811a + size()), collection);
        return true;
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        m42593a(size() + collection.size());
        int access$positiveMod = m42598d(this.f59811a + size());
        int access$positiveMod2 = m42598d(this.f59811a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.f59811a;
            int i3 = i2 - size;
            if (access$positiveMod2 < i2) {
                Object[] objArr = this.f59812b;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i3, i2, objArr.length);
                if (size >= access$positiveMod2) {
                    Object[] objArr2 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, objArr2.length - size, 0, access$positiveMod2);
                } else {
                    Object[] objArr3 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr4, (T[]) objArr4, 0, size, access$positiveMod2);
                }
            } else if (i3 >= 0) {
                Object[] objArr5 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, i3, i2, access$positiveMod2);
            } else {
                Object[] objArr6 = this.f59812b;
                i3 += objArr6.length;
                int i4 = access$positiveMod2 - i2;
                int length = objArr6.length - i3;
                if (length >= i4) {
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, i3, i2, access$positiveMod2);
                } else {
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, i3, i2, i2 + length);
                    Object[] objArr7 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, this.f59811a + length, access$positiveMod2);
                }
            }
            this.f59811a = i3;
            m42594a(m42599e(access$positiveMod2 - size), collection);
        } else {
            int i5 = access$positiveMod2 + size;
            if (access$positiveMod2 < access$positiveMod) {
                int i6 = size + access$positiveMod;
                Object[] objArr8 = this.f59812b;
                if (i6 <= objArr8.length) {
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, i5, access$positiveMod2, access$positiveMod);
                } else if (i5 >= objArr8.length) {
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, i5 - objArr8.length, access$positiveMod2, access$positiveMod);
                } else {
                    int length2 = access$positiveMod - (i6 - objArr8.length);
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, 0, length2, access$positiveMod);
                    Object[] objArr9 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr9, (T[]) objArr9, i5, access$positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr10, (T[]) objArr10, size, 0, access$positiveMod);
                Object[] objArr11 = this.f59812b;
                if (i5 >= objArr11.length) {
                    ArraysKt.copyInto((T[]) objArr11, (T[]) objArr11, i5 - objArr11.length, access$positiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto((T[]) objArr11, (T[]) objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f59812b;
                    ArraysKt.copyInto((T[]) objArr12, (T[]) objArr12, i5, access$positiveMod2, objArr12.length - size);
                }
            }
            m42594a(access$positiveMod2, collection);
        }
        return true;
    }

    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return this.f59812b[m42598d(this.f59811a + i)];
    }

    public E set(int i, E e) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        int access$positiveMod = m42598d(this.f59811a + i);
        E e2 = this.f59812b[access$positiveMod];
        this.f59812b[access$positiveMod] = e;
        return e2;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public int indexOf(Object obj) {
        int i;
        int access$positiveMod = m42598d(this.f59811a + size());
        int i2 = this.f59811a;
        if (i2 < access$positiveMod) {
            while (i2 < access$positiveMod) {
                if (Intrinsics.areEqual(obj, this.f59812b[i2])) {
                    i = this.f59811a;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < access$positiveMod) {
            return -1;
        } else {
            int length = this.f59812b.length;
            while (true) {
                if (i2 >= length) {
                    int i3 = 0;
                    while (i3 < access$positiveMod) {
                        if (Intrinsics.areEqual(obj, this.f59812b[i3])) {
                            i2 = i3 + this.f59812b.length;
                            i = this.f59811a;
                        } else {
                            i3++;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.f59812b[i2])) {
                    i = this.f59811a;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    public int lastIndexOf(Object obj) {
        int i;
        int i2;
        int access$positiveMod = m42598d(this.f59811a + size());
        int i3 = this.f59811a;
        if (i3 < access$positiveMod) {
            i = access$positiveMod - 1;
            if (i < i3) {
                return -1;
            }
            while (!Intrinsics.areEqual(obj, this.f59812b[i])) {
                if (i == i3) {
                    return -1;
                }
                i--;
            }
            i2 = this.f59811a;
        } else if (i3 <= access$positiveMod) {
            return -1;
        } else {
            int i4 = access$positiveMod - 1;
            while (true) {
                if (i4 < 0) {
                    int lastIndex = ArraysKt.getLastIndex((T[]) this.f59812b);
                    int i5 = this.f59811a;
                    if (lastIndex < i5) {
                        return -1;
                    }
                    while (!Intrinsics.areEqual(obj, this.f59812b[i])) {
                        if (i == i5) {
                            return -1;
                        }
                        lastIndex = i - 1;
                    }
                    i2 = this.f59811a;
                } else if (Intrinsics.areEqual(obj, this.f59812b[i4])) {
                    i = i4 + this.f59812b.length;
                    i2 = this.f59811a;
                    break;
                } else {
                    i4--;
                }
            }
        }
        return i - i2;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public E removeAt(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        if (i == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int access$positiveMod = m42598d(this.f59811a + i);
        E e = this.f59812b[access$positiveMod];
        if (i < (size() >> 1)) {
            int i2 = this.f59811a;
            if (access$positiveMod >= i2) {
                Object[] objArr = this.f59812b;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i2 + 1, i2, access$positiveMod);
            } else {
                Object[] objArr2 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, 1, 0, access$positiveMod);
                Object[] objArr3 = this.f59812b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.f59811a;
                ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.f59812b;
            int i4 = this.f59811a;
            objArr4[i4] = null;
            this.f59811a = m42601g(i4);
        } else {
            int access$positiveMod2 = m42598d(this.f59811a + CollectionsKt.getLastIndex(this));
            if (access$positiveMod <= access$positiveMod2) {
                Object[] objArr5 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, access$positiveMod, access$positiveMod + 1, access$positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, access$positiveMod, access$positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.f59812b;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, 1, access$positiveMod2 + 1);
            }
            this.f59812b[access$positiveMod2] = null;
        }
        this.f59813c = size() - 1;
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m42595a(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x00ca
            java.lang.Object[] r0 = r11.f59812b
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0016
            goto L_0x00ca
        L_0x0016:
            int r0 = r11.size()
            int r3 = r11.f59811a
            int r3 = r3 + r0
            int r0 = r11.m42598d(r3)
            int r3 = r11.f59811a
            int r4 = r11.f59811a
            r5 = 0
            if (r4 >= r0) goto L_0x005c
            int r4 = r11.f59811a
        L_0x0032:
            if (r4 >= r0) goto L_0x0054
            java.lang.Object[] r6 = r11.f59812b
            r6 = r6[r4]
            java.lang.Object r7 = r12.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0050
            java.lang.Object[] r7 = r11.f59812b
            int r8 = r3 + 1
            r7[r3] = r6
            r3 = r8
            goto L_0x0051
        L_0x0050:
            r1 = 1
        L_0x0051:
            int r4 = r4 + 1
            goto L_0x0032
        L_0x0054:
            java.lang.Object[] r12 = r11.f59812b
            kotlin.collections.ArraysKt.fill((T[]) r12, r5, (int) r3, (int) r0)
            goto L_0x00bc
        L_0x005c:
            int r4 = r11.f59811a
            java.lang.Object[] r6 = r11.f59812b
            int r6 = r6.length
            r7 = 0
        L_0x0066:
            if (r4 >= r6) goto L_0x008e
            java.lang.Object[] r8 = r11.f59812b
            r8 = r8[r4]
            java.lang.Object[] r9 = r11.f59812b
            r9[r4] = r5
            java.lang.Object r9 = r12.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x008a
            java.lang.Object[] r9 = r11.f59812b
            int r10 = r3 + 1
            r9[r3] = r8
            r3 = r10
            goto L_0x008b
        L_0x008a:
            r7 = 1
        L_0x008b:
            int r4 = r4 + 1
            goto L_0x0066
        L_0x008e:
            int r3 = r11.m42598d(r3)
        L_0x0092:
            if (r1 >= r0) goto L_0x00bb
            java.lang.Object[] r4 = r11.f59812b
            r4 = r4[r1]
            java.lang.Object[] r6 = r11.f59812b
            r6[r1] = r5
            java.lang.Object r6 = r12.invoke(r4)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00b7
            java.lang.Object[] r6 = r11.f59812b
            r6[r3] = r4
            int r3 = r11.m42601g(r3)
            goto L_0x00b8
        L_0x00b7:
            r7 = 1
        L_0x00b8:
            int r1 = r1 + 1
            goto L_0x0092
        L_0x00bb:
            r1 = r7
        L_0x00bc:
            if (r1 == 0) goto L_0x00ca
            int r12 = r11.f59811a
            int r3 = r3 - r12
            int r12 = r11.m42599e(r3)
            r11.f59813c = r12
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.m42595a(kotlin.jvm.functions.Function1):boolean");
    }

    public void clear() {
        int access$positiveMod = m42598d(this.f59811a + size());
        int i = this.f59811a;
        if (i < access$positiveMod) {
            ArraysKt.fill((T[]) this.f59812b, null, i, access$positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.f59812b;
            ArraysKt.fill((T[]) objArr, null, this.f59811a, objArr.length);
            ArraysKt.fill((T[]) this.f59812b, null, 0, access$positiveMod);
        }
        this.f59811a = 0;
        this.f59813c = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = ArraysKt.arrayOfNulls(tArr, size());
        }
        if (tArr != null) {
            int access$positiveMod = m42598d(this.f59811a + size());
            int i = this.f59811a;
            if (i < access$positiveMod) {
                ArraysKt.copyInto$default(this.f59812b, (Object[]) tArr, 0, i, access$positiveMod, 2, (Object) null);
            } else if (!isEmpty()) {
                Object[] objArr = this.f59812b;
                ArraysKt.copyInto((T[]) objArr, tArr, 0, this.f59811a, objArr.length);
                Object[] objArr2 = this.f59812b;
                ArraysKt.copyInto((T[]) objArr2, tArr, objArr2.length - this.f59811a, 0, access$positiveMod);
            }
            if (tArr.length > size()) {
                tArr[size()] = null;
            }
            if (tArr != null) {
                return tArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return toArray(tArr);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ArrayDeque.kt */
    public static final class Companion {
        public final int newCapacity$kotlin_stdlib(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - ArrayDeque.f59809e <= 0) {
                return i3;
            }
            if (i2 > ArrayDeque.f59809e) {
                return Integer.MAX_VALUE;
            }
            return ArrayDeque.f59809e;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r1 = r2.f59811a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void internalStructure$kotlin_stdlib(kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Object[], kotlin.Unit> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "structure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r2.size()
            int r1 = r2.f59811a
            int r1 = r1 + r0
            int r0 = r2.m42598d(r1)
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x0022
            int r1 = r2.f59811a
            if (r1 >= r0) goto L_0x001d
            goto L_0x0022
        L_0x001d:
            java.lang.Object[] r0 = r2.f59812b
            int r0 = r0.length
            int r1 = r1 - r0
            goto L_0x0024
        L_0x0022:
            int r1 = r2.f59811a
        L_0x0024:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r1 = r2.toArray()
            r3.invoke(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.internalStructure$kotlin_stdlib(kotlin.jvm.functions.Function2):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x00c0
            java.lang.Object[] r0 = r11.f59812b
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 == 0) goto L_0x001b
            goto L_0x00c0
        L_0x001b:
            int r0 = r11.size()
            int r3 = r11.f59811a
            int r3 = r3 + r0
            int r0 = r11.m42598d(r3)
            int r3 = r11.f59811a
            int r4 = r11.f59811a
            r5 = 0
            if (r4 >= r0) goto L_0x005c
            int r4 = r11.f59811a
        L_0x0037:
            if (r4 >= r0) goto L_0x0054
            java.lang.Object[] r6 = r11.f59812b
            r6 = r6[r4]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x0050
            java.lang.Object[] r7 = r11.f59812b
            int r8 = r3 + 1
            r7[r3] = r6
            r3 = r8
            goto L_0x0051
        L_0x0050:
            r1 = 1
        L_0x0051:
            int r4 = r4 + 1
            goto L_0x0037
        L_0x0054:
            java.lang.Object[] r12 = r11.f59812b
            kotlin.collections.ArraysKt.fill((T[]) r12, r5, (int) r3, (int) r0)
            goto L_0x00b2
        L_0x005c:
            int r4 = r11.f59811a
            java.lang.Object[] r6 = r11.f59812b
            int r6 = r6.length
            r7 = 0
        L_0x0066:
            if (r4 >= r6) goto L_0x0089
            java.lang.Object[] r8 = r11.f59812b
            r8 = r8[r4]
            java.lang.Object[] r9 = r11.f59812b
            r9[r4] = r5
            boolean r9 = r12.contains(r8)
            r9 = r9 ^ r2
            if (r9 == 0) goto L_0x0085
            java.lang.Object[] r9 = r11.f59812b
            int r10 = r3 + 1
            r9[r3] = r8
            r3 = r10
            goto L_0x0086
        L_0x0085:
            r7 = 1
        L_0x0086:
            int r4 = r4 + 1
            goto L_0x0066
        L_0x0089:
            int r3 = r11.m42598d(r3)
        L_0x008d:
            if (r1 >= r0) goto L_0x00b1
            java.lang.Object[] r4 = r11.f59812b
            r4 = r4[r1]
            java.lang.Object[] r6 = r11.f59812b
            r6[r1] = r5
            boolean r6 = r12.contains(r4)
            r6 = r6 ^ r2
            if (r6 == 0) goto L_0x00ad
            java.lang.Object[] r6 = r11.f59812b
            r6[r3] = r4
            int r3 = r11.m42601g(r3)
            goto L_0x00ae
        L_0x00ad:
            r7 = 1
        L_0x00ae:
            int r1 = r1 + 1
            goto L_0x008d
        L_0x00b1:
            r1 = r7
        L_0x00b2:
            if (r1 == 0) goto L_0x00c0
            int r12 = r11.f59811a
            int r3 = r3 - r12
            int r12 = r11.m42599e(r3)
            r11.f59813c = r12
        L_0x00c0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x00bd
            java.lang.Object[] r0 = r11.f59812b
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 == 0) goto L_0x001b
            goto L_0x00bd
        L_0x001b:
            int r0 = r11.size()
            int r3 = r11.f59811a
            int r3 = r3 + r0
            int r0 = r11.m42598d(r3)
            int r3 = r11.f59811a
            int r4 = r11.f59811a
            r5 = 0
            if (r4 >= r0) goto L_0x005b
            int r4 = r11.f59811a
        L_0x0037:
            if (r4 >= r0) goto L_0x0053
            java.lang.Object[] r6 = r11.f59812b
            r6 = r6[r4]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x004f
            java.lang.Object[] r7 = r11.f59812b
            int r8 = r3 + 1
            r7[r3] = r6
            r3 = r8
            goto L_0x0050
        L_0x004f:
            r1 = 1
        L_0x0050:
            int r4 = r4 + 1
            goto L_0x0037
        L_0x0053:
            java.lang.Object[] r12 = r11.f59812b
            kotlin.collections.ArraysKt.fill((T[]) r12, r5, (int) r3, (int) r0)
            goto L_0x00af
        L_0x005b:
            int r4 = r11.f59811a
            java.lang.Object[] r6 = r11.f59812b
            int r6 = r6.length
            r7 = 0
        L_0x0065:
            if (r4 >= r6) goto L_0x0087
            java.lang.Object[] r8 = r11.f59812b
            r8 = r8[r4]
            java.lang.Object[] r9 = r11.f59812b
            r9[r4] = r5
            boolean r9 = r12.contains(r8)
            if (r9 == 0) goto L_0x0083
            java.lang.Object[] r9 = r11.f59812b
            int r10 = r3 + 1
            r9[r3] = r8
            r3 = r10
            goto L_0x0084
        L_0x0083:
            r7 = 1
        L_0x0084:
            int r4 = r4 + 1
            goto L_0x0065
        L_0x0087:
            int r3 = r11.m42598d(r3)
        L_0x008b:
            if (r1 >= r0) goto L_0x00ae
            java.lang.Object[] r4 = r11.f59812b
            r4 = r4[r1]
            java.lang.Object[] r6 = r11.f59812b
            r6[r1] = r5
            boolean r6 = r12.contains(r4)
            if (r6 == 0) goto L_0x00aa
            java.lang.Object[] r6 = r11.f59812b
            r6[r3] = r4
            int r3 = r11.m42601g(r3)
            goto L_0x00ab
        L_0x00aa:
            r7 = 1
        L_0x00ab:
            int r1 = r1 + 1
            goto L_0x008b
        L_0x00ae:
            r1 = r7
        L_0x00af:
            if (r1 == 0) goto L_0x00bd
            int r12 = r11.f59811a
            int r3 = r3 - r12
            int r12 = r11.m42599e(r3)
            r11.f59813c = r12
        L_0x00bd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }
}
