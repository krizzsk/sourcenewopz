package com.squareup.haha.trove;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class THashMap<K, V> extends TObjectHash<K> implements Map<K, V> {
    protected transient V[] _values;

    public THashMap() {
    }

    public THashMap(TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super(tObjectHashingStrategy);
    }

    public THashMap(int i) {
        super(i);
    }

    public THashMap(int i, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super(i, tObjectHashingStrategy);
    }

    public THashMap(int i, float f) {
        super(i, f);
    }

    public THashMap(int i, float f, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super(i, f, tObjectHashingStrategy);
    }

    public THashMap(Map<K, V> map) {
        this(map.size());
        putAll(map);
    }

    public THashMap(Map<K, V> map, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        this(map.size(), tObjectHashingStrategy);
        putAll(map);
    }

    public THashMap<K, V> clone() {
        THashMap<K, V> tHashMap = (THashMap) super.clone();
        tHashMap._values = (Object[]) this._values.clone();
        return tHashMap;
    }

    /* access modifiers changed from: protected */
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = (Object[]) new Object[up];
        return up;
    }

    public V put(K k, V v) {
        if (k != null) {
            V v2 = null;
            int insertionIndex = insertionIndex(k);
            boolean z = false;
            boolean z2 = insertionIndex < 0;
            if (z2) {
                insertionIndex = (-insertionIndex) - 1;
                v2 = this._values[insertionIndex];
            }
            Object obj = this._set[insertionIndex];
            this._set[insertionIndex] = k;
            this._values[insertionIndex] = v;
            if (!z2) {
                if (obj == null) {
                    z = true;
                }
                postInsertHook(z);
            }
            return v2;
        }
        throw new NullPointerException("null keys not supported");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        return forEachEntry(new EqProcedure(map));
    }

    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f56028h;
    }

    final class HashProcedure implements TObjectObjectProcedure<K, V> {

        /* renamed from: h */
        int f56028h;

        HashProcedure() {
        }

        public final boolean execute(K k, V v) {
            this.f56028h += THashMap.this._hashingStrategy.computeHashCode(k) ^ (v == null ? 0 : v.hashCode());
            return true;
        }
    }

    static final class EqProcedure<K, V> implements TObjectObjectProcedure<K, V> {
        private final Map<K, V> _otherMap;

        EqProcedure(Map<K, V> map) {
            this._otherMap = map;
        }

        public final boolean execute(K k, V v) {
            V v2 = this._otherMap.get(k);
            if (v2 != v) {
                return v2 != null && v2.equals(v);
            }
            return true;
        }
    }

    public boolean forEachKey(TObjectProcedure<K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    public boolean forEachValue(TObjectProcedure<V> tObjectProcedure) {
        V[] vArr = this._values;
        Object[] objArr = this._set;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != null && objArr[i] != REMOVED && !tObjectProcedure.execute(vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean forEachEntry(TObjectObjectProcedure<K, V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != null && objArr[i] != REMOVED && !tObjectObjectProcedure.execute(objArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean retainEntries(TObjectObjectProcedure<K, V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        stopCompactingOnRemove();
        boolean z = false;
        try {
            int length = objArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (!(objArr[i] == null || objArr[i] == REMOVED || tObjectObjectProcedure.execute(objArr[i], vArr[i]))) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            startCompactingOnRemove(z);
        }
    }

    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        V[] vArr = this._values;
        Object[] objArr = this._set;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (!(objArr[i] == null || objArr[i] == REMOVED)) {
                    vArr[i] = tObjectFunction.execute$7713a341();
                }
                length = i;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        V[] vArr = this._values;
        this._set = new Object[i];
        this._values = (Object[]) new Object[i];
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                if (!(objArr[i2] == null || objArr[i2] == REMOVED)) {
                    Object obj = objArr[i2];
                    int insertionIndex = insertionIndex(obj);
                    if (insertionIndex < 0) {
                        throwObjectContractViolation(this._set[(-insertionIndex) - 1], obj);
                    }
                    this._set[insertionIndex] = obj;
                    this._values[insertionIndex] = vArr[i2];
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public V get(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    public void clear() {
        if (size() != 0) {
            super.clear();
            Object[] objArr = this._set;
            V[] vArr = this._values;
            int length = objArr.length;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    objArr[i] = null;
                    vArr[i] = null;
                    length = i;
                } else {
                    return;
                }
            }
        }
    }

    public V remove(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    public Collection<V> values() {
        return new ValueView();
    }

    public Set<K> keySet() {
        return new KeyView();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new EntryView();
    }

    public boolean containsValue(Object obj) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        if (obj == null) {
            int length = vArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != null && objArr[i] != REMOVED && obj == vArr[i]) {
                    return true;
                }
                length = i;
            }
        } else {
            int length2 = vArr.length;
            while (true) {
                int i2 = length2 - 1;
                if (length2 <= 0) {
                    return false;
                }
                if (objArr[i2] == null || objArr[i2] == REMOVED || (obj != vArr[i2] && !obj.equals(vArr[i2]))) {
                    length2 = i2;
                }
            }
            return true;
        }
    }

    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public class ValueView extends THashMap<K, V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        public final Iterator<V> iterator() {
            return new THashIterator<V>(THashMap.this) {
                /* access modifiers changed from: protected */
                public final V objectAtIndex(int i) {
                    return THashMap.this._values[i];
                }
            };
        }

        public final boolean containsElement(V v) {
            return THashMap.this.containsValue(v);
        }

        public final boolean removeElement(V v) {
            V[] vArr = THashMap.this._values;
            Object[] objArr = THashMap.this._set;
            int length = vArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (!(objArr[i] == null || objArr[i] == TObjectHash.REMOVED || v != vArr[i]) || (vArr[i] != null && vArr[i].equals(v))) {
                    THashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }
    }

    public class EntryView extends THashMap<K, V>.MapBackedView<Map.Entry<K, V>> {
        public final /* synthetic */ boolean containsElement(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = THashMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (value != obj2) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        public final /* synthetic */ boolean removeElement(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int index = THashMap.this.index(entry.getKey());
            if (index < 0) {
                return false;
            }
            V value = entry.getValue();
            if (value != THashMap.this._values[index] && (value == null || !value.equals(THashMap.this._values[index]))) {
                return false;
            }
            THashMap.this.removeAt(index);
            return true;
        }

        EntryView() {
            super();
        }

        final class EntryIterator extends THashIterator<Map.Entry<K, V>> {
            EntryIterator(THashMap<K, V> tHashMap) {
                super(tHashMap);
            }

            public final /* synthetic */ Object objectAtIndex(int i) {
                return new Entry(THashMap.this._set[i], THashMap.this._values[i], i);
            }
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(THashMap.this);
        }
    }

    abstract class MapBackedView<E> implements Set<E> {
        public abstract boolean containsElement(E e);

        public abstract Iterator<E> iterator();

        public abstract boolean removeElement(E e);

        MapBackedView() {
        }

        public boolean contains(Object obj) {
            return containsElement(obj);
        }

        public boolean remove(Object obj) {
            return removeElement(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object remove : collection) {
                if (remove(remove)) {
                    z = true;
                }
            }
            return z;
        }

        public void clear() {
            THashMap.this.clear();
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return THashMap.this.size();
        }

        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            }
            Iterator it = iterator();
            for (int i = 0; i < size; i++) {
                tArr[i] = it.next();
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        public boolean isEmpty() {
            return THashMap.this.isEmpty();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    public class KeyView extends THashMap<K, V>.MapBackedView<K> {
        KeyView() {
            super();
        }

        public final Iterator<K> iterator() {
            return new TObjectHashIterator(THashMap.this);
        }

        public final boolean removeElement(K k) {
            return THashMap.this.remove(k) != null;
        }

        public final boolean containsElement(K k) {
            return THashMap.this.contains(k);
        }
    }

    final class Entry implements Map.Entry<K, V> {
        private final int index;
        private final K key;
        private V val;

        Entry(K k, V v, int i) {
            this.key = k;
            this.val = v;
            this.index = i;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.val;
        }

        public final V setValue(V v) {
            if (THashMap.this._values[this.index] == this.val) {
                THashMap.this._values[this.index] = v;
                V v2 = this.val;
                this.val = v;
                return v2;
            }
            throw new ConcurrentModificationException();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this._size);
        SerializationProcedure serializationProcedure = new SerializationProcedure(objectOutputStream);
        if (!forEachEntry(serializationProcedure)) {
            throw serializationProcedure.exception;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt > 0) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
                readInt = i;
            } else {
                return;
            }
        }
    }
}
