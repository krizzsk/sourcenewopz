package com.didi.beatles.p099im.thirty.greenrobot.dao.internal;

import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog;
import java.util.Arrays;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.LongHashMap */
public final class LongHashMap<T> {

    /* renamed from: a */
    private Entry<T>[] f9700a;

    /* renamed from: b */
    private int f9701b;

    /* renamed from: c */
    private int f9702c;

    /* renamed from: d */
    private int f9703d;

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.LongHashMap$Entry */
    static final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        Entry(long j, T t, Entry<T> entry) {
            this.key = j;
            this.value = t;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.f9701b = i;
        this.f9702c = (i * 4) / 3;
        this.f9700a = new Entry[i];
    }

    public boolean containsKey(long j) {
        for (Entry<T> entry = this.f9700a[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f9701b]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public T get(long j) {
        for (Entry<T> entry = this.f9700a[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f9701b]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return entry.value;
            }
        }
        return null;
    }

    public T put(long j, T t) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f9701b;
        Entry<T> entry = this.f9700a[i];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j) {
                T t2 = entry2.value;
                entry2.value = t;
                return t2;
            }
        }
        this.f9700a[i] = new Entry<>(j, t, entry);
        int i2 = this.f9703d + 1;
        this.f9703d = i2;
        if (i2 <= this.f9702c) {
            return null;
        }
        setCapacity(this.f9701b * 2);
        return null;
    }

    public T remove(long j) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f9701b;
        Entry<T> entry = this.f9700a[i];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j) {
                if (entry2 == null) {
                    this.f9700a[i] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.f9703d--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void clear() {
        this.f9703d = 0;
        Arrays.fill(this.f9700a, (Object) null);
    }

    public int size() {
        return this.f9703d;
    }

    public void setCapacity(int i) {
        Entry<T>[] entryArr = new Entry[i];
        for (Entry<T> entry : this.f9700a) {
            while (entry != null) {
                long j = entry.key;
                int i2 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i2];
                entryArr[i2] = entry;
                entry = entry2;
            }
        }
        this.f9700a = entryArr;
        this.f9701b = i;
        this.f9702c = (i * 4) / 3;
    }

    public void reserveRoom(int i) {
        setCapacity((i * 5) / 3);
    }

    public void logStats() {
        int i = 0;
        for (Entry<T> entry : this.f9700a) {
            while (entry != null && entry.next != null) {
                i++;
                entry = entry.next;
            }
        }
        DaoLog.m6524d("load: " + (((float) this.f9703d) / ((float) this.f9701b)) + ", size: " + this.f9703d + ", capa: " + this.f9701b + ", collisions: " + i + ", collision ratio: " + (((float) i) / ((float) this.f9703d)));
    }
}
