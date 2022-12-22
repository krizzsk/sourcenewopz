package com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.identityscope.IdentityScopeObject */
public class IdentityScopeObject<K, T> implements IdentityScope<K, T> {

    /* renamed from: a */
    private final HashMap<K, Reference<T>> f9693a = new HashMap<>();

    /* renamed from: b */
    private final ReentrantLock f9694b = new ReentrantLock();

    public void reserveRoom(int i) {
    }

    public T get(K k) {
        this.f9694b.lock();
        try {
            Reference reference = this.f9693a.get(k);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f9694b.unlock();
        }
    }

    public T getNoLock(K k) {
        Reference reference = this.f9693a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void put(K k, T t) {
        this.f9694b.lock();
        try {
            this.f9693a.put(k, new WeakReference(t));
        } finally {
            this.f9694b.unlock();
        }
    }

    public void putNoLock(K k, T t) {
        this.f9693a.put(k, new WeakReference(t));
    }

    public boolean detach(K k, T t) {
        boolean z;
        this.f9694b.lock();
        try {
            if (get(k) != t || t == null) {
                z = false;
            } else {
                remove(k);
                z = true;
            }
            return z;
        } finally {
            this.f9694b.unlock();
        }
    }

    public void remove(K k) {
        this.f9694b.lock();
        try {
            this.f9693a.remove(k);
        } finally {
            this.f9694b.unlock();
        }
    }

    public void remove(Iterable<K> iterable) {
        this.f9694b.lock();
        try {
            for (K remove : iterable) {
                this.f9693a.remove(remove);
            }
        } finally {
            this.f9694b.unlock();
        }
    }

    public void clear() {
        this.f9694b.lock();
        try {
            this.f9693a.clear();
        } finally {
            this.f9694b.unlock();
        }
    }

    public void lock() {
        this.f9694b.lock();
    }

    public void unlock() {
        this.f9694b.unlock();
    }
}
