package com.didichuxing.diface.appeal.mexico.toolkit;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Counter<T> {

    /* renamed from: a */
    private final Runnable f47082a;

    /* renamed from: b */
    private HashSet f47083b;

    public Counter(Collection<? extends T> collection, Runnable runnable) {
        this.f47083b = new HashSet(collection);
        this.f47082a = runnable;
    }

    public int residue() {
        return this.f47083b.size();
    }

    public void remove(T t) {
        Runnable runnable;
        Iterator it = this.f47083b.iterator();
        while (true) {
            if (it.hasNext()) {
                if (t.equals(it.next())) {
                    it.remove();
                    break;
                }
            } else {
                break;
            }
        }
        if (this.f47083b.size() == 0 && (runnable = this.f47082a) != null) {
            runnable.run();
        }
    }
}
