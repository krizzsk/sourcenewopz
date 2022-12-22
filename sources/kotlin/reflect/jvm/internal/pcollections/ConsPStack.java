package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ConsPStack<E> implements Iterable<E> {

    /* renamed from: c */
    private static final ConsPStack<Object> f61205c = new ConsPStack<>();

    /* renamed from: a */
    final E f61206a;

    /* renamed from: b */
    final ConsPStack<E> f61207b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f61208d;

    /* renamed from: a */
    public static <E> ConsPStack<E> m45110a() {
        return f61205c;
    }

    private ConsPStack() {
        this.f61208d = 0;
        this.f61206a = null;
        this.f61207b = null;
    }

    private ConsPStack(E e, ConsPStack<E> consPStack) {
        this.f61206a = e;
        this.f61207b = consPStack;
        this.f61208d = consPStack.f61208d + 1;
    }

    /* renamed from: a */
    public E mo180219a(int i) {
        if (i < 0 || i > this.f61208d) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return m45112c(i).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }

    public Iterator<E> iterator() {
        return m45112c(0);
    }

    /* renamed from: b */
    public int mo180221b() {
        return this.f61208d;
    }

    /* renamed from: c */
    private Iterator<E> m45112c(int i) {
        return new Itr(m45113d(i));
    }

    private static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        public boolean hasNext() {
            return this.next.f61208d > 0;
        }

        public E next() {
            E e = this.next.f61206a;
            this.next = this.next.f61207b;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public ConsPStack<E> mo180220a(E e) {
        return new ConsPStack<>(e, this);
    }

    /* renamed from: b */
    private ConsPStack<E> m45111b(Object obj) {
        if (this.f61208d == 0) {
            return this;
        }
        if (this.f61206a.equals(obj)) {
            return this.f61207b;
        }
        ConsPStack<E> b = this.f61207b.m45111b(obj);
        if (b == this.f61207b) {
            return this;
        }
        return new ConsPStack<>(this.f61206a, b);
    }

    /* renamed from: b */
    public ConsPStack<E> mo180222b(int i) {
        return m45111b(mo180219a(i));
    }

    /* renamed from: d */
    private ConsPStack<E> m45113d(int i) {
        if (i < 0 || i > this.f61208d) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.f61207b.m45113d(i - 1);
        }
    }
}
