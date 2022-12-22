package com.squareup.haha.perflib.analysis;

import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.guava.collect.Iterables;
import com.squareup.haha.perflib.Heap;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.Snapshot;

public class Dominators {
    private final Snapshot mSnapshot;
    private final ImmutableList<Instance> mTopSort;

    public Dominators(Snapshot snapshot, ImmutableList<Instance> immutableList) {
        this.mSnapshot = snapshot;
        this.mTopSort = immutableList;
        for (RootObj referredInstance : snapshot.getGCRoots()) {
            Instance referredInstance2 = referredInstance.getReferredInstance();
            if (referredInstance2 != null) {
                referredInstance2.setImmediateDominator(Snapshot.SENTINEL_ROOT);
            }
        }
    }

    private void computeDominators() {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            for (int i = 0; i < this.mTopSort.size(); i++) {
                Instance instance = (Instance) this.mTopSort.get(i);
                if (instance.getImmediateDominator() != Snapshot.SENTINEL_ROOT) {
                    Instance instance2 = null;
                    for (int i2 = 0; i2 < instance.getHardReferences().size(); i2++) {
                        Instance instance3 = instance.getHardReferences().get(i2);
                        if (instance3.getImmediateDominator() != null) {
                            if (instance2 == null) {
                                instance2 = instance3;
                            } else {
                                while (instance2 != instance3) {
                                    if (instance2.getTopologicalOrder() < instance3.getTopologicalOrder()) {
                                        instance3 = instance3.getImmediateDominator();
                                    } else {
                                        instance2 = instance2.getImmediateDominator();
                                    }
                                }
                            }
                        }
                    }
                    if (instance.getImmediateDominator() != instance2) {
                        instance.setImmediateDominator(instance2);
                        z = true;
                    }
                }
            }
        }
    }

    public void computeRetainedSizes() {
        for (Heap next : this.mSnapshot.getHeaps()) {
            for (T resetRetainedSize : Iterables.concat(next.getClasses(), next.getInstances())) {
                resetRetainedSize.resetRetainedSize();
            }
        }
        computeDominators();
        for (Instance next2 : this.mSnapshot.getReachableInstances()) {
            int heapIndex = this.mSnapshot.getHeapIndex(next2.getHeap());
            for (Instance immediateDominator = next2.getImmediateDominator(); immediateDominator != Snapshot.SENTINEL_ROOT; immediateDominator = immediateDominator.getImmediateDominator()) {
                immediateDominator.addRetainedSize(heapIndex, (long) next2.getSize());
            }
        }
    }
}
