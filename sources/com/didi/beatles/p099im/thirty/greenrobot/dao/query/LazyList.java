package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import android.database.Cursor;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.InternalQueryDaoAccess;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.LazyList */
public class LazyList<E> implements Closeable, List<E> {

    /* renamed from: a */
    private final InternalQueryDaoAccess<E> f9726a;

    /* renamed from: b */
    private final Cursor f9727b;

    /* renamed from: c */
    private final List<E> f9728c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f9729d;

    /* renamed from: e */
    private final ReentrantLock f9730e;

    /* renamed from: f */
    private volatile int f9731f;

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.LazyList$LazyIterator */
    protected class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i, boolean z) {
            this.index = i;
            this.closeWhenDone = z;
        }

        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i = this.index;
            if (i > 0) {
                int i2 = i - 1;
                this.index = i2;
                return LazyList.this.get(i2);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.index < LazyList.this.f9729d;
        }

        public E next() {
            if (this.index < LazyList.this.f9729d) {
                E e = LazyList.this.get(this.index);
                int i = this.index + 1;
                this.index = i;
                if (i == LazyList.this.f9729d && this.closeWhenDone) {
                    close();
                }
                return e;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void close() {
            LazyList.this.close();
        }
    }

    LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean z) {
        this.f9727b = cursor;
        this.f9726a = internalQueryDaoAccess;
        this.f9729d = cursor.getCount();
        if (z) {
            this.f9728c = new ArrayList(this.f9729d);
            for (int i = 0; i < this.f9729d; i++) {
                this.f9728c.add((Object) null);
            }
        } else {
            this.f9728c = null;
        }
        if (this.f9729d == 0) {
            cursor.close();
        }
        this.f9730e = new ReentrantLock();
    }

    public void loadRemaining() {
        checkCached();
        int size = this.f9728c.size();
        for (int i = 0; i < size; i++) {
            get(i);
        }
    }

    /* access modifiers changed from: protected */
    public void checkCached() {
        if (this.f9728c == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    public E peak(int i) {
        List<E> list = this.f9728c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public void close() {
        this.f9727b.close();
    }

    public boolean isClosed() {
        return this.f9727b.isClosed();
    }

    public int getLoadedCount() {
        return this.f9731f;
    }

    public boolean isLoadedCompletely() {
        return this.f9731f == this.f9729d;
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        loadRemaining();
        return this.f9728c.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.f9728c.containsAll(collection);
    }

    public E get(int i) {
        List<E> list = this.f9728c;
        if (list != null) {
            E e = list.get(i);
            if (e == null) {
                this.f9730e.lock();
                try {
                    e = this.f9728c.get(i);
                    if (e == null) {
                        e = loadEntity(i);
                        this.f9728c.set(i, e);
                        this.f9731f++;
                        if (this.f9731f == this.f9729d) {
                            this.f9727b.close();
                        }
                    }
                } finally {
                    this.f9730e.unlock();
                }
            }
            return e;
        }
        this.f9730e.lock();
        try {
            return loadEntity(i);
        } finally {
            this.f9730e.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public E loadEntity(int i) {
        if (this.f9727b.moveToPosition(i)) {
            E loadCurrent = this.f9726a.loadCurrent(this.f9727b, 0, true);
            if (loadCurrent != null) {
                return loadCurrent;
            }
            throw new DaoException("Loading of entity failed (null) at position " + i);
        }
        throw new DaoException("Could not move to cursor location " + i);
    }

    public int indexOf(Object obj) {
        loadRemaining();
        return this.f9728c.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f9729d == 0;
    }

    public Iterator<E> iterator() {
        return new LazyIterator(0, false);
    }

    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.f9728c.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    public ListIterator<E> listIterator(int i) {
        return new LazyIterator(i, false);
    }

    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f9729d;
    }

    public List<E> subList(int i, int i2) {
        checkCached();
        for (int i3 = i; i3 < i2; i3++) {
            get(i3);
        }
        return this.f9728c.subList(i, i2);
    }

    public Object[] toArray() {
        loadRemaining();
        return this.f9728c.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return this.f9728c.toArray(tArr);
    }
}
