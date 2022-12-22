package com.squareup.haha.perflib;

import com.squareup.haha.trove.TLongHashSet;
import java.util.ArrayDeque;
import java.util.Deque;

public class NonRecursiveVisitor implements Visitor {
    public final TLongHashSet mSeen = new TLongHashSet();
    public final Deque<Instance> mStack = new ArrayDeque();

    /* access modifiers changed from: protected */
    public void defaultAction(Instance instance) {
    }

    public void visitRootObj(RootObj rootObj) {
        defaultAction(rootObj);
    }

    public void visitArrayInstance(ArrayInstance arrayInstance) {
        defaultAction(arrayInstance);
    }

    public void visitClassInstance(ClassInstance classInstance) {
        defaultAction(classInstance);
    }

    public void visitClassObj(ClassObj classObj) {
        defaultAction(classObj);
    }

    public void visitLater(Instance instance, Instance instance2) {
        this.mStack.push(instance2);
    }

    public void doVisit(Iterable<? extends Instance> iterable) {
        for (Instance instance : iterable) {
            if (instance instanceof RootObj) {
                instance.accept(this);
            } else {
                visitLater((Instance) null, instance);
            }
        }
        while (!this.mStack.isEmpty()) {
            Instance pop = this.mStack.pop();
            if (this.mSeen.add(pop.getId())) {
                pop.accept(this);
            }
        }
    }
}
