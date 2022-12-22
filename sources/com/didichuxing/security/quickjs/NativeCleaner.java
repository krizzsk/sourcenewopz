package com.didichuxing.security.quickjs;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;

abstract class NativeCleaner<T> {
    private Set<NativeReference<T>> phantomReferences = new HashSet();
    private ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();

    public abstract void onRemove(long j);

    NativeCleaner() {
    }

    public int size() {
        return this.phantomReferences.size();
    }

    public void register(T t, long j) {
        this.phantomReferences.add(new NativeReference(t, j, this.referenceQueue));
    }

    public void clean() {
        while (true) {
            NativeReference nativeReference = (NativeReference) this.referenceQueue.poll();
            if (nativeReference == null) {
                return;
            }
            if (this.phantomReferences.contains(nativeReference)) {
                onRemove(nativeReference.pointer);
                this.phantomReferences.remove(nativeReference);
            }
        }
    }

    public void forceClean() {
        for (NativeReference<T> access$100 : this.phantomReferences) {
            onRemove(access$100.pointer);
        }
        this.phantomReferences.clear();
    }

    private static class NativeReference<T> extends PhantomReference<T> {
        /* access modifiers changed from: private */
        public long pointer;

        private NativeReference(T t, long j, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.pointer = j;
        }
    }
}
