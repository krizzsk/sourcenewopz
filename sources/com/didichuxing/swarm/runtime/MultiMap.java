package com.didichuxing.swarm.runtime;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MultiMap<K, V> implements Map<K, List<V>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<K, List<V>> f49213a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LinkedHashSet<V> f49214b;

    /* renamed from: c */
    private final Comparator<V> f49215c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f49216d;

    public MultiMap() {
        this.f49214b = new LinkedHashSet<>();
        this.f49216d = false;
        this.f49213a = new HashMap<>();
        this.f49215c = null;
    }

    public MultiMap(int i) {
        this.f49214b = new LinkedHashSet<>();
        this.f49216d = false;
        this.f49213a = new HashMap<>(i);
        this.f49215c = null;
    }

    public MultiMap(MultiMap<K, ? extends V> multiMap) {
        this();
        mo121234a(multiMap);
    }

    public MultiMap(Comparator<V> comparator) {
        this.f49214b = new LinkedHashSet<>();
        this.f49216d = false;
        this.f49213a = new HashMap<>();
        this.f49215c = comparator;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HashMap<K, List<V>> mo121232a() {
        return this.f49213a;
    }

    /* renamed from: a */
    public void mo121236a(K k, V v) {
        List list = this.f49213a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f49213a.put(k, list);
        }
        list.add(v);
        Comparator<V> comparator = this.f49215c;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        if (!this.f49216d) {
            this.f49214b.add(v);
        }
    }

    /* renamed from: a */
    public void mo121235a(K k) {
        if (this.f49213a.get(k) == null) {
            this.f49213a.put(k, new ArrayList());
        }
    }

    /* renamed from: b */
    public void mo121241b(K k, V v) {
        List list = this.f49213a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f49213a.put(k, list);
        }
        if (!list.contains(v)) {
            list.add(v);
            Comparator<V> comparator = this.f49215c;
            if (comparator != null) {
                Collections.sort(list, comparator);
            }
            if (!this.f49216d) {
                this.f49214b.add(v);
            }
        }
    }

    /* renamed from: a */
    public void mo121237a(K k, Collection<? extends V> collection) {
        List list = this.f49213a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f49213a.put(k, list);
        }
        list.addAll(collection);
        Comparator<V> comparator = this.f49215c;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        if (!this.f49216d) {
            this.f49214b.addAll(collection);
        }
    }

    /* renamed from: a */
    public void mo121234a(MultiMap<K, ? extends V> multiMap) {
        for (K next : multiMap.keySet()) {
            mo121237a(next, multiMap.get((Object) next));
        }
    }

    /* renamed from: b */
    public List<V> get(Object obj) {
        return this.f49213a.get(obj);
    }

    /* renamed from: c */
    public int mo121242c(K k, V v) {
        List b = get((Object) k);
        if (b == null) {
            return -1;
        }
        return b.indexOf(v);
    }

    public boolean remove(Object obj, Object obj2) {
        List b = get(obj);
        if (b == null) {
            return false;
        }
        boolean remove = b.remove(obj2);
        if (remove) {
            this.f49216d = true;
        }
        return remove;
    }

    /* renamed from: c */
    public List<V> remove(Object obj) {
        List<V> remove = this.f49213a.remove(obj);
        if (remove == null) {
            return null;
        }
        this.f49216d = true;
        return remove;
    }

    /* renamed from: d */
    public List<V> mo121248d(K k) {
        List<V> b = get((Object) k);
        return b == null ? Collections.emptyList() : b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo121240b() {
        this.f49214b.clear();
        for (List addAll : values()) {
            this.f49214b.addAll(addAll);
        }
        this.f49216d = false;
    }

    /* renamed from: c */
    public List<V> mo121243c() {
        if (this.f49216d) {
            mo121240b();
        }
        return new ArrayList(this.f49214b);
    }

    /* renamed from: a */
    public void mo121238a(K[] kArr, V v) {
        for (K b : kArr) {
            List b2 = get((Object) b);
            if (b2 != null) {
                b2.remove(v);
            }
        }
        this.f49216d = true;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public String toString() {
        return "MultiMap " + this.f49213a.toString();
    }

    private final class KeySet extends AbstractSet<K> {
        private final Set<K> keySet;

        protected KeySet() {
            this.keySet = MultiMap.this.f49213a.keySet();
        }

        public Iterator<K> iterator() {
            final Iterator<K> it = this.keySet.iterator();
            return new Iterator<K>() {
                private K element;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    K next = it.next();
                    this.element = next;
                    return next;
                }

                public void remove() {
                    MultiMap.this.remove((Object) this.element);
                }
            };
        }

        public int size() {
            return MultiMap.this.f49213a.size();
        }

        public boolean contains(Object obj) {
            return MultiMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            boolean z = MultiMap.this.remove(obj) != null;
            if (z) {
                boolean unused = MultiMap.this.f49216d = true;
            }
            return z;
        }

        public void clear() {
            MultiMap.this.clear();
            MultiMap.this.f49214b.clear();
            boolean unused = MultiMap.this.f49216d = false;
        }
    }

    public int size() {
        return this.f49213a.size();
    }

    public boolean isEmpty() {
        return this.f49213a.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f49213a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (this.f49216d) {
            mo121240b();
        }
        return this.f49214b.contains(obj);
    }

    /* renamed from: a */
    public List<V> put(K k, List<V> list) {
        throw new UnsupportedOperationException("put");
    }

    public void putAll(Map<? extends K, ? extends List<V>> map) {
        throw new UnsupportedOperationException("putAll");
    }

    public void clear() {
        this.f49213a.clear();
        this.f49214b.clear();
        this.f49216d = false;
    }

    public Collection<List<V>> values() {
        return this.f49213a.values();
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.f49213a.entrySet();
    }
}
