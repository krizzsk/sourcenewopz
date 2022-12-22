package com.didi.sdk.event.compat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class EventDispatcherCompat<K, V> {

    /* renamed from: a */
    private final Map<K, Set<ReceiverCompat<? super K, ? super V>>> f35863a = new HashMap(24);

    protected EventDispatcherCompat() {
    }

    public boolean registerReceiver(K k, ReceiverCompat<? super K, ? super V> receiverCompat) {
        Set set;
        boolean add;
        if (k == null || receiverCompat == null) {
            return false;
        }
        synchronized (this.f35863a) {
            set = this.f35863a.get(k);
            if (set == null) {
                set = new HashSet();
                this.f35863a.put(k, set);
            }
        }
        synchronized (set) {
            add = set.add(receiverCompat);
        }
        return add;
    }

    public boolean removeReceiver(K k, ReceiverCompat<? super K, ? super V> receiverCompat) {
        Set set;
        boolean remove;
        if (k == null || receiverCompat == null) {
            return false;
        }
        synchronized (this.f35863a) {
            set = this.f35863a.get(k);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(receiverCompat);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public void publish(K k, V v) {
        Set set;
        HashSet<ReceiverCompat> hashSet;
        if (k != null) {
            synchronized (this.f35863a) {
                set = this.f35863a.get(k);
            }
            if (set != null) {
                synchronized (set) {
                    hashSet = new HashSet<>(set);
                }
                for (ReceiverCompat onReceive : hashSet) {
                    onReceive.onReceive(k, v);
                }
            }
        }
    }
}
