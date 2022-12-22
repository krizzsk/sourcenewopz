package com.didichuxing.omega.sdk.leak;

class LeakRef {
    public byte curGCTimes;
    public long lastGCTime;
    private KeyedWeakReference ref;
    public long startWatchTime;

    public LeakRef(KeyedWeakReference keyedWeakReference) {
        this.ref = keyedWeakReference;
    }

    public boolean isLeak() {
        if (get() == null) {
            return false;
        }
        if (this.curGCTimes <= LeakCollector.MAX_GC_TIMES && this.lastGCTime - this.startWatchTime <= ((long) LeakCollector.MAX_WATCH_TIME)) {
            return false;
        }
        return true;
    }

    public String getName() {
        KeyedWeakReference keyedWeakReference = this.ref;
        if (keyedWeakReference != null) {
            return keyedWeakReference.name;
        }
        return null;
    }

    public Object get() {
        KeyedWeakReference keyedWeakReference = this.ref;
        if (keyedWeakReference != null) {
            return keyedWeakReference.get();
        }
        return null;
    }
}
