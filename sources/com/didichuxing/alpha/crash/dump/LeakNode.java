package com.didichuxing.alpha.crash.dump;

import com.squareup.haha.perflib.Instance;

final class LeakNode {
    final Exclusion exclusion;
    final Instance instance;
    final LeakReference leakReference;
    final LeakNode parent;

    LeakNode(Exclusion exclusion2, Instance instance2, LeakNode leakNode, LeakReference leakReference2) {
        this.exclusion = exclusion2;
        this.instance = instance2;
        this.parent = leakNode;
        this.leakReference = leakReference2;
    }

    public String toString() {
        return super.toString();
    }
}
