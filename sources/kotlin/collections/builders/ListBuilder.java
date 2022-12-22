package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001QB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBM\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J&\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\"\u001a\u00020\bH\u0002J\u001d\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\u0014\u0010(\u001a\u00020\u000f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0013\u0010-\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010.H\u0002J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\bH\u0016J\u0015\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\u000fH\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0002J\u0015\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0015\u0010;\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010<\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0002\u00100J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\bH\u0002¢\u0006\u0002\u00100J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0016\u0010B\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J.\u0010C\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u001e\u0010E\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0016J\u0015\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010J\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006R"}, mo175978d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "Itr", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ListBuilder.kt */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, KMutableList {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public E[] f59830a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f59831b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f59832c;

    /* renamed from: d */
    private boolean f59833d;

    /* renamed from: e */
    private final ListBuilder<E> f59834e;

    /* renamed from: f */
    private final ListBuilder<E> f59835f;

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f59830a = eArr;
        this.f59831b = i;
        this.f59832c = i2;
        this.f59833d = z;
        this.f59834e = listBuilder;
        this.f59835f = listBuilder2;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }

    public final List<E> build() {
        if (this.f59834e == null) {
            m42642a();
            this.f59833d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public int getSize() {
        return this.f59832c;
    }

    public boolean isEmpty() {
        return this.f59832c == 0;
    }

    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.f59832c);
        return this.f59830a[this.f59831b + i];
    }

    public E set(int i, E e) {
        m42642a();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.f59832c);
        E[] eArr = this.f59830a;
        int i2 = this.f59831b;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.f59832c; i++) {
            if (Intrinsics.areEqual((Object) this.f59830a[this.f59831b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = this.f59832c - 1; i >= 0; i--) {
            if (Intrinsics.areEqual((Object) this.f59830a[this.f59831b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new Itr<>(this, 0);
    }

    public ListIterator<E> listIterator() {
        return new Itr<>(this, 0);
    }

    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.f59832c);
        return new Itr<>(this, i);
    }

    public boolean add(E e) {
        m42642a();
        m42645a(this.f59831b + this.f59832c, e);
        return true;
    }

    public void add(int i, E e) {
        m42642a();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.f59832c);
        m42645a(this.f59831b + i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        m42642a();
        int size = collection.size();
        m42646a(this.f59831b + this.f59832c, collection, size);
        return size > 0;
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        m42642a();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.f59832c);
        int size = collection.size();
        m42646a(this.f59831b + i, collection, size);
        return size > 0;
    }

    public void clear() {
        m42642a();
        m42649b(this.f59831b, this.f59832c);
    }

    public E removeAt(int i) {
        m42642a();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.f59832c);
        return m42650c(this.f59831b + i);
    }

    public boolean remove(Object obj) {
        m42642a();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        m42642a();
        return m42641a(this.f59831b, this.f59832c, collection, false) > 0;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        m42642a();
        return m42641a(this.f59831b, this.f59832c, collection, true) > 0;
    }

    public List<E> subList(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.f59832c);
        E[] eArr = this.f59830a;
        int i3 = this.f59831b + i;
        int i4 = i2 - i;
        boolean z = this.f59833d;
        ListBuilder<E> listBuilder = this.f59835f;
        return new ListBuilder<>(eArr, i3, i4, z, this, listBuilder != null ? listBuilder : this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "destination");
        int length = tArr.length;
        int i = this.f59832c;
        if (length < i) {
            E[] eArr = this.f59830a;
            int i2 = this.f59831b;
            T[] copyOfRange = Arrays.copyOfRange(eArr, i2, i + i2, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "java.util.Arrays.copyOfR…h, destination.javaClass)");
            return copyOfRange;
        }
        E[] eArr2 = this.f59830a;
        if (eArr2 != null) {
            int i3 = this.f59831b;
            ArraysKt.copyInto((T[]) eArr2, tArr, 0, i3, i + i3);
            int length2 = tArr.length;
            int i4 = this.f59832c;
            if (length2 > i4) {
                tArr[i4] = null;
            }
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public Object[] toArray() {
        E[] eArr = this.f59830a;
        int i = this.f59831b;
        Object[] copyOfRange = ArraysKt.copyOfRange((T[]) eArr, i, this.f59832c + i);
        if (copyOfRange != null) {
            return copyOfRange;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && m42647a((List<?>) (List) obj));
    }

    public int hashCode() {
        return ListBuilderKt.m42653b(this.f59830a, this.f59831b, this.f59832c);
    }

    public String toString() {
        return ListBuilderKt.m42651a(this.f59830a, this.f59831b, this.f59832c);
    }

    /* renamed from: a */
    private final void m42643a(int i) {
        if (this.f59834e != null) {
            throw new IllegalStateException();
        } else if (i > this.f59830a.length) {
            this.f59830a = ListBuilderKt.copyOfUninitializedElements(this.f59830a, ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.f59830a.length, i));
        }
    }

    /* renamed from: a */
    private final void m42642a() {
        ListBuilder<E> listBuilder;
        if (this.f59833d || ((listBuilder = this.f59835f) != null && listBuilder.f59833d)) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b */
    private final void m42648b(int i) {
        m42643a(this.f59832c + i);
    }

    /* renamed from: a */
    private final boolean m42647a(List<?> list) {
        return ListBuilderKt.m42652a(this.f59830a, this.f59831b, this.f59832c, list);
    }

    /* renamed from: a */
    private final void m42644a(int i, int i2) {
        m42648b(i2);
        E[] eArr = this.f59830a;
        ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i + i2, i, this.f59831b + this.f59832c);
        this.f59832c += i2;
    }

    /* renamed from: a */
    private final void m42645a(int i, E e) {
        ListBuilder<E> listBuilder = this.f59834e;
        if (listBuilder != null) {
            listBuilder.m42645a(i, e);
            this.f59830a = this.f59834e.f59830a;
            this.f59832c++;
            return;
        }
        m42644a(i, 1);
        this.f59830a[i] = e;
    }

    /* renamed from: a */
    private final void m42646a(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.f59834e;
        if (listBuilder != null) {
            listBuilder.m42646a(i, collection, i2);
            this.f59830a = this.f59834e.f59830a;
            this.f59832c += i2;
            return;
        }
        m42644a(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f59830a[i + i3] = it.next();
        }
    }

    /* renamed from: c */
    private final E m42650c(int i) {
        ListBuilder<E> listBuilder = this.f59834e;
        if (listBuilder != null) {
            this.f59832c--;
            return listBuilder.m42650c(i);
        }
        E[] eArr = this.f59830a;
        E e = eArr[i];
        ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i, i + 1, this.f59831b + this.f59832c);
        ListBuilderKt.resetAt(this.f59830a, (this.f59831b + this.f59832c) - 1);
        this.f59832c--;
        return e;
    }

    /* renamed from: b */
    private final void m42649b(int i, int i2) {
        ListBuilder<E> listBuilder = this.f59834e;
        if (listBuilder != null) {
            listBuilder.m42649b(i, i2);
        } else {
            E[] eArr = this.f59830a;
            ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i, i + i2, this.f59832c);
            E[] eArr2 = this.f59830a;
            int i3 = this.f59832c;
            ListBuilderKt.resetRange(eArr2, i3 - i2, i3);
        }
        this.f59832c -= i2;
    }

    /* renamed from: a */
    private final int m42641a(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.f59834e;
        if (listBuilder != null) {
            int a = listBuilder.m42641a(i, i2, collection, z);
            this.f59832c -= a;
            return a;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.f59830a[i5]) == z) {
                E[] eArr = this.f59830a;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.f59830a;
        ArraysKt.copyInto((T[]) eArr2, (T[]) eArr2, i + i4, i2 + i, this.f59832c);
        E[] eArr3 = this.f59830a;
        int i7 = this.f59832c;
        ListBuilderKt.resetRange(eArr3, i7 - i6, i7);
        this.f59832c -= i6;
        return i6;
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ListBuilder.kt */
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int index;
        private int lastIndex = -1;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.list = listBuilder;
            this.index = i;
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public boolean hasNext() {
            return this.index < this.list.f59832c;
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i = this.index;
            if (i > 0) {
                int i2 = i - 1;
                this.index = i2;
                this.lastIndex = i2;
                return this.list.f59830a[this.list.f59831b + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public E next() {
            if (this.index < this.list.f59832c) {
                int i = this.index;
                this.index = i + 1;
                this.lastIndex = i;
                return this.list.f59830a[this.list.f59831b + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public void set(E e) {
            if (this.lastIndex != -1) {
                this.list.set(this.lastIndex, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }

        public void add(E e) {
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, e);
            this.lastIndex = -1;
        }

        public void remove() {
            if (this.lastIndex != -1) {
                this.list.remove(this.lastIndex);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }
    }
}
