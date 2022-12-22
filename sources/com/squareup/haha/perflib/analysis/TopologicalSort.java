package com.squareup.haha.perflib.analysis;

import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.guava.collect.UnmodifiableIterator;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.NonRecursiveVisitor;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.Snapshot;
import com.squareup.haha.trove.TLongHashSet;
import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
    public static ImmutableList<Instance> compute(Iterable<RootObj> iterable) {
        TopologicalSortVisitor topologicalSortVisitor = new TopologicalSortVisitor();
        topologicalSortVisitor.doVisit(iterable);
        ImmutableList<Instance> orderedInstances = topologicalSortVisitor.getOrderedInstances();
        int i = 0;
        Snapshot.SENTINEL_ROOT.setTopologicalOrder(0);
        UnmodifiableIterator<Instance> it = orderedInstances.iterator();
        while (it.hasNext()) {
            i++;
            it.next().setTopologicalOrder(i);
        }
        return orderedInstances;
    }

    static class TopologicalSortVisitor extends NonRecursiveVisitor {
        private final List<Instance> mPostorder;
        private final TLongHashSet mVisited;

        private TopologicalSortVisitor() {
            this.mVisited = new TLongHashSet();
            this.mPostorder = new ArrayList();
        }

        public void visitLater(Instance instance, Instance instance2) {
            if (!this.mSeen.contains(instance2.getId())) {
                this.mStack.push(instance2);
            }
        }

        public void doVisit(Iterable<? extends Instance> iterable) {
            for (Instance accept : iterable) {
                accept.accept(this);
            }
            while (!this.mStack.isEmpty()) {
                Instance instance = (Instance) this.mStack.peek();
                if (this.mSeen.add(instance.getId())) {
                    instance.accept(this);
                } else {
                    this.mStack.pop();
                    if (this.mVisited.add(instance.getId())) {
                        this.mPostorder.add(instance);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Instance> getOrderedInstances() {
            return ImmutableList.copyOf(Joiner.reverse(this.mPostorder));
        }
    }
}
