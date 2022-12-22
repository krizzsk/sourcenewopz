package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.C1850Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
    private final Set<Target<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void track(Target<?> target) {
        this.targets.add(target);
    }

    public void untrack(Target<?> target) {
        this.targets.remove(target);
    }

    public void onStart() {
        for (T onStart : C1850Util.getSnapshot(this.targets)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : C1850Util.getSnapshot(this.targets)) {
            onStop.onStop();
        }
    }

    public void onDestroy() {
        for (T onDestroy : C1850Util.getSnapshot(this.targets)) {
            onDestroy.onDestroy();
        }
    }

    public List<Target<?>> getAll() {
        return C1850Util.getSnapshot(this.targets);
    }

    public void clear() {
        this.targets.clear();
    }
}
