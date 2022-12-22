package com.squareup.haha.guava.collect;

import java.util.AbstractCollection;
import java.util.Map;
import javax.annotation.Nullable;

abstract class Multimaps$Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
    /* access modifiers changed from: package-private */
    public abstract Multimap<K, V> multimap();

    Multimaps$Entries() {
    }

    public int size() {
        return multimap().size();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return multimap().containsEntry(entry.getKey(), entry.getValue());
    }

    public boolean remove(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return multimap().remove(entry.getKey(), entry.getValue());
    }

    public void clear() {
        multimap().clear();
    }
}
