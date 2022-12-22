package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements RandomAccess, LazyStringList {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyStringList f60787a;

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f60787a = lazyStringList;
    }

    public String get(int i) {
        return (String) this.f60787a.get(i);
    }

    public int size() {
        return this.f60787a.size();
    }

    public ByteString getByteString(int i) {
        return this.f60787a.getByteString(i);
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>() {
            ListIterator<String> iter = UnmodifiableLazyStringList.this.f60787a.listIterator(i);

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return this.iter.next();
            }

            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            public String previous() {
                return this.iter.previous();
            }

            public int nextIndex() {
                return this.iter.nextIndex();
            }

            public int previousIndex() {
                return this.iter.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> iter = UnmodifiableLazyStringList.this.f60787a.iterator();

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public List<?> getUnderlyingElements() {
        return this.f60787a.getUnderlyingElements();
    }
}
