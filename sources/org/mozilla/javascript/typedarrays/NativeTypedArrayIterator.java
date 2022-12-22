package org.mozilla.javascript.typedarrays;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class NativeTypedArrayIterator<T> implements ListIterator<T> {
    private int lastPosition = -1;
    private int position;
    private final NativeTypedArrayView<T> view;

    NativeTypedArrayIterator(NativeTypedArrayView<T> nativeTypedArrayView, int i) {
        this.view = nativeTypedArrayView;
        this.position = i;
    }

    public boolean hasNext() {
        return this.position < this.view.length;
    }

    public boolean hasPrevious() {
        return this.position > 0;
    }

    public int nextIndex() {
        return this.position;
    }

    public int previousIndex() {
        return this.position - 1;
    }

    public T next() {
        if (hasNext()) {
            T t = this.view.get(this.position);
            int i = this.position;
            this.lastPosition = i;
            this.position = i + 1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public T previous() {
        if (hasPrevious()) {
            int i = this.position - 1;
            this.position = i;
            this.lastPosition = i;
            return this.view.get(i);
        }
        throw new NoSuchElementException();
    }

    public void set(T t) {
        int i = this.lastPosition;
        if (i >= 0) {
            this.view.js_set(i, t);
            return;
        }
        throw new IllegalStateException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
