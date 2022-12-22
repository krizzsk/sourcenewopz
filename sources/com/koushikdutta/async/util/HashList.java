package com.koushikdutta.async.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class HashList<T> {

    /* renamed from: a */
    Hashtable<String, TaggedList<T>> f55468a = new Hashtable<>();

    public Set<String> keySet() {
        return this.f55468a.keySet();
    }

    public synchronized <V> V tag(String str) {
        TaggedList taggedList = this.f55468a.get(str);
        if (taggedList == null) {
            return null;
        }
        return taggedList.tag();
    }

    public synchronized <V> void tag(String str, V v) {
        TaggedList taggedList = this.f55468a.get(str);
        if (taggedList == null) {
            taggedList = new TaggedList();
            this.f55468a.put(str, taggedList);
        }
        taggedList.tag(v);
    }

    public synchronized ArrayList<T> remove(String str) {
        return this.f55468a.remove(str);
    }

    public synchronized int size() {
        return this.f55468a.size();
    }

    public synchronized ArrayList<T> get(String str) {
        return this.f55468a.get(str);
    }

    public synchronized boolean contains(String str) {
        ArrayList arrayList;
        arrayList = get(str);
        return arrayList != null && arrayList.size() > 0;
    }

    public synchronized void add(String str, T t) {
        ArrayList arrayList = get(str);
        if (arrayList == null) {
            arrayList = new TaggedList();
            this.f55468a.put(str, arrayList);
        }
        arrayList.add(t);
    }

    public synchronized T pop(String str) {
        TaggedList taggedList = this.f55468a.get(str);
        if (taggedList == null) {
            return null;
        }
        if (taggedList.size() == 0) {
            return null;
        }
        return taggedList.remove(taggedList.size() - 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean removeItem(java.lang.String r2, T r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Hashtable<java.lang.String, com.koushikdutta.async.util.TaggedList<T>> r0 = r1.f55468a     // Catch:{ all -> 0x001a }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001a }
            com.koushikdutta.async.util.TaggedList r2 = (com.koushikdutta.async.util.TaggedList) r2     // Catch:{ all -> 0x001a }
            r0 = 0
            if (r2 != 0) goto L_0x000e
            monitor-exit(r1)
            return r0
        L_0x000e:
            r2.remove(r3)     // Catch:{ all -> 0x001a }
            int r2 = r2.size()     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x0018
            r0 = 1
        L_0x0018:
            monitor-exit(r1)
            return r0
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.util.HashList.removeItem(java.lang.String, java.lang.Object):boolean");
    }
}
