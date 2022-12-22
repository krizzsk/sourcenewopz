package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.List;
import javax.annotation.Nullable;
import org.osgi.framework.VersionRange;

final class SingletonImmutableList<E> extends ImmutableList<E> {
    private transient E element;

    public final boolean isEmpty() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    public final ImmutableList<E> reverse() {
        return this;
    }

    public final int size() {
        return 1;
    }

    SingletonImmutableList(E e) {
        this.element = Joiner.checkNotNull(e);
    }

    public final E get(int i) {
        Joiner.checkElementIndex(i, 1);
        return this.element;
    }

    public final int indexOf(@Nullable Object obj) {
        return this.element.equals(obj) ? 0 : -1;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public final int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    public final ImmutableList<E> subList(int i, int i2) {
        Joiner.checkPositionIndexes(i, i2, 1);
        return i == i2 ? ImmutableList.EMPTY : this;
    }

    public final boolean contains(@Nullable Object obj) {
        return this.element.equals(obj);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            return list.size() == 1 && this.element.equals(list.get(0));
        }
    }

    public final int hashCode() {
        return this.element.hashCode() + 31;
    }

    public final String toString() {
        String obj = this.element.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 2);
        sb.append(VersionRange.LEFT_CLOSED);
        sb.append(obj);
        sb.append(VersionRange.RIGHT_CLOSED);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }
}
