package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Function;
import com.squareup.haha.guava.base.Joiner;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class Maps {

    enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            public final /* synthetic */ Object apply(Object obj) {
                return ((Map.Entry) obj).getKey();
            }
        },
        VALUE {
            public final /* synthetic */ Object apply(Object obj) {
                return ((Map.Entry) obj).getValue();
            }
        };

        static {
            KEY = new EntryFunction("KEY", 0) {
                public final /* synthetic */ Object apply(Object obj) {
                    return ((Map.Entry) obj).getKey();
                }
            };
            C205382 r0 = new EntryFunction("VALUE", 1) {
                public final /* synthetic */ Object apply(Object obj) {
                    return ((Map.Entry) obj).getValue();
                }
            };
            VALUE = r0;
            new EntryFunction[2][1] = r0;
        }
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }

    static abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> createEntrySet();

        ImprovedAbstractMap() {
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Values values2 = new Values(this);
            this.values = values2;
            return values2;
        }
    }

    static <V> V safeGet(Map<?, V> map, @Nullable Object obj) {
        Joiner.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean safeContainsKey(Map<?, ?> map, Object obj) {
        Joiner.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V safeRemove(Map<?, V> map, Object obj) {
        Joiner.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static {
        new Joiner.MapJoiner(Collections2.STANDARD_JOINER, "=", (byte) 0);
    }

    static class KeySet<K, V> extends Sets$ImprovedAbstractSet<K> {
        final Map<K, V> map;

        KeySet(Map<K, V> map2) {
            this.map = (Map) Joiner.checkNotNull(map2);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            this.map.remove(obj);
            return true;
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(this.map.entrySet().iterator());
        }

        public int size() {
            return this.map.size();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        public void clear() {
            this.map.clear();
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        private Map<K, V> map;

        Values(Map<K, V> map2) {
            this.map = (Map) Joiner.checkNotNull(map2);
        }

        public final boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry next : this.map.entrySet()) {
                    if (Joiner.equal(obj, next.getValue())) {
                        this.map.remove(next.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public final boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry next : this.map.entrySet()) {
                    if (collection.contains(next.getValue())) {
                        hashSet.add(next.getKey());
                    }
                }
                return this.map.keySet().removeAll(hashSet);
            }
        }

        public final boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry next : this.map.entrySet()) {
                    if (collection.contains(next.getValue())) {
                        hashSet.add(next.getKey());
                    }
                }
                return this.map.keySet().retainAll(hashSet);
            }
        }

        public final Iterator<V> iterator() {
            return Maps.valueIterator(this.map.entrySet().iterator());
        }

        public final int size() {
            return this.map.size();
        }

        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        public final boolean contains(@Nullable Object obj) {
            return this.map.containsValue(obj);
        }

        public final void clear() {
            this.map.clear();
        }
    }

    static abstract class EntrySet<K, V> extends Sets$ImprovedAbstractSet<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object safeGet = Maps.safeGet(map(), key);
                if (!Joiner.equal(safeGet, entry.getValue()) || (safeGet == null && !map().containsKey(key))) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(Object obj) {
            if (contains(obj)) {
                return map().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Joiner.removeAllImpl((Set<?>) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet(Maps.capacity(collection.size()));
                for (Object next : collection) {
                    if (contains(next)) {
                        hashSet.add(((Map.Entry) next).getKey());
                    }
                }
                return map().keySet().retainAll(hashSet);
            }
        }
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> it) {
        return Iterators.transform(it, EntryFunction.KEY);
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> it) {
        return Iterators.transform(it, EntryFunction.VALUE);
    }

    public static int capacity(int i) {
        if (i < 3) {
            if (i >= 0) {
                return i + 1;
            }
            throw new IllegalArgumentException("expectedSize" + " cannot be negative but was: " + i);
        } else if (i < 1073741824) {
            return i + (i / 3);
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
