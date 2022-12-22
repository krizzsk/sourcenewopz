package org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class WeakHashtable extends Hashtable {
    private static final int MAX_CHANGES_BEFORE_PURGE = 100;
    private static final int PARTIAL_PURGE_COUNT = 10;
    private static final long serialVersionUID = -1546036869799732453L;
    private int changeCount = 0;
    private final ReferenceQueue queue = new ReferenceQueue();

    public boolean containsKey(Object obj) {
        return super.containsKey(new Referenced(obj, (C25261) null));
    }

    public Enumeration elements() {
        purge();
        return super.elements();
    }

    public Set entrySet() {
        purge();
        Set<Map.Entry> entrySet = super.entrySet();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : entrySet) {
            Object access$100 = Referenced.access$100((Referenced) entry.getKey());
            Object value = entry.getValue();
            if (access$100 != null) {
                hashSet.add(new Entry(access$100, value, (C25261) null));
            }
        }
        return hashSet;
    }

    public Object get(Object obj) {
        return super.get(new Referenced(obj, (C25261) null));
    }

    public Enumeration keys() {
        purge();
        return new Enumeration(this, super.keys()) {
            private final WeakHashtable this$0;
            private final Enumeration val$enumer;

            {
                this.this$0 = r1;
                this.val$enumer = r2;
            }

            public boolean hasMoreElements() {
                return this.val$enumer.hasMoreElements();
            }

            public Object nextElement() {
                return Referenced.access$100((Referenced) this.val$enumer.nextElement());
            }
        };
    }

    public Set keySet() {
        purge();
        Set<Referenced> keySet = super.keySet();
        HashSet hashSet = new HashSet();
        for (Referenced access$100 : keySet) {
            Object access$1002 = Referenced.access$100(access$100);
            if (access$1002 != null) {
                hashSet.add(access$1002);
            }
        }
        return hashSet;
    }

    public synchronized Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("Null keys are not allowed");
        } else if (obj2 != null) {
            int i = this.changeCount;
            int i2 = i + 1;
            this.changeCount = i2;
            if (i > 100) {
                purge();
                this.changeCount = 0;
            } else if (i2 % 10 == 0) {
                purgeOne();
            }
        } else {
            throw new NullPointerException("Null values are not allowed");
        }
        return super.put(new Referenced(obj, this.queue, (C25261) null), obj2);
    }

    public void putAll(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Collection values() {
        purge();
        return super.values();
    }

    public synchronized Object remove(Object obj) {
        int i = this.changeCount;
        int i2 = i + 1;
        this.changeCount = i2;
        if (i > 100) {
            purge();
            this.changeCount = 0;
        } else if (i2 % 10 == 0) {
            purgeOne();
        }
        return super.remove(new Referenced(obj, (C25261) null));
    }

    public boolean isEmpty() {
        purge();
        return super.isEmpty();
    }

    public int size() {
        purge();
        return super.size();
    }

    public String toString() {
        purge();
        return super.toString();
    }

    /* access modifiers changed from: protected */
    public void rehash() {
        purge();
        super.rehash();
    }

    private void purge() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.queue) {
            while (true) {
                WeakKey weakKey = (WeakKey) this.queue.poll();
                if (weakKey != null) {
                    arrayList.add(WeakKey.access$400(weakKey));
                }
            }
            while (true) {
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            super.remove(arrayList.get(i));
        }
    }

    private void purgeOne() {
        synchronized (this.queue) {
            WeakKey weakKey = (WeakKey) this.queue.poll();
            if (weakKey != null) {
                super.remove(WeakKey.access$400(weakKey));
            }
        }
    }

    private static final class Entry implements Map.Entry {
        private final Object key;
        private final Object value;

        Entry(Object obj, Object obj2, C25261 r3) {
            this(obj, obj2);
        }

        private Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getKey() == null ? 0 : getKey().hashCode();
            if (getValue() != null) {
                i = getValue().hashCode();
            }
            return hashCode ^ i;
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Entry.setValue is not supported.");
        }

        public Object getValue() {
            return this.value;
        }

        public Object getKey() {
            return this.key;
        }
    }

    private static final class Referenced {
        private final int hashCode;
        private final WeakReference reference;

        Referenced(Object obj, ReferenceQueue referenceQueue, C25261 r3) {
            this(obj, referenceQueue);
        }

        Referenced(Object obj, C25261 r2) {
            this(obj);
        }

        static Object access$100(Referenced referenced) {
            return referenced.getValue();
        }

        private Referenced(Object obj) {
            this.reference = new WeakReference(obj);
            this.hashCode = obj.hashCode();
        }

        private Referenced(Object obj, ReferenceQueue referenceQueue) {
            this.reference = new WeakKey(obj, referenceQueue, this, (C25261) null);
            this.hashCode = obj.hashCode();
        }

        public int hashCode() {
            return this.hashCode;
        }

        private Object getValue() {
            return this.reference.get();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Referenced)) {
                return false;
            }
            Referenced referenced = (Referenced) obj;
            Object value = getValue();
            Object value2 = referenced.getValue();
            if (value != null) {
                return value.equals(value2);
            }
            if (!(value2 == null) || hashCode() != referenced.hashCode()) {
                return false;
            }
            return true;
        }
    }

    private static final class WeakKey extends WeakReference {
        private final Referenced referenced;

        WeakKey(Object obj, ReferenceQueue referenceQueue, Referenced referenced2, C25261 r4) {
            this(obj, referenceQueue, referenced2);
        }

        static Referenced access$400(WeakKey weakKey) {
            return weakKey.getReferenced();
        }

        private WeakKey(Object obj, ReferenceQueue referenceQueue, Referenced referenced2) {
            super(obj, referenceQueue);
            this.referenced = referenced2;
        }

        private Referenced getReferenced() {
            return this.referenced;
        }
    }
}
