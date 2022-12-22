package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public final class Backstack implements Iterable<RouterTransaction> {

    /* renamed from: a */
    private static final String f8274a = "Backstack.entries";

    /* renamed from: b */
    private final Deque<RouterTransaction> f8275b = new ArrayDeque();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo40571a() {
        return this.f8275b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo40572b() {
        return this.f8275b.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public RouterTransaction mo40575c() {
        if (this.f8275b.size() > 0) {
            return this.f8275b.getLast();
        }
        return null;
    }

    public Iterator<RouterTransaction> iterator() {
        return this.f8275b.iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Iterator<RouterTransaction> mo40577d() {
        return this.f8275b.descendingIterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<RouterTransaction> mo40568a(RouterTransaction routerTransaction) {
        ArrayList arrayList = new ArrayList();
        if (this.f8275b.contains(routerTransaction)) {
            while (this.f8275b.peek() != routerTransaction) {
                arrayList.add(mo40579e());
            }
            return arrayList;
        }
        throw new RuntimeException("Tried to pop to a transaction that was not on the back stack");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public RouterTransaction mo40579e() {
        RouterTransaction pop = this.f8275b.pop();
        pop.f8345a.mo40608d();
        return pop;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public RouterTransaction mo40580f() {
        return this.f8275b.peek();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40574b(RouterTransaction routerTransaction) {
        this.f8275b.removeFirstOccurrence(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo40576c(RouterTransaction routerTransaction) {
        this.f8275b.push(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public List<RouterTransaction> mo40581g() {
        ArrayList arrayList = new ArrayList();
        while (!mo40571a()) {
            arrayList.add(mo40579e());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40570a(List<RouterTransaction> list) {
        boolean z;
        for (RouterTransaction next : this.f8275b) {
            Iterator<RouterTransaction> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (next.f8345a == it.next().f8345a) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                if (next.f8345a.isAttached()) {
                    if (!(next.f8345a.getRouter() == null || next.f8345a.getView() == null || next.f8345a.getRouter().f8332d == null)) {
                        next.f8345a.getRouter().f8332d.removeView(next.f8345a.getView());
                    }
                    next.f8345a.mo40593a(next.f8345a.getView(), true, false);
                }
                next.f8345a.mo40608d();
            }
        }
        this.f8275b.clear();
        for (RouterTransaction push : list) {
            this.f8275b.push(push);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo40578d(RouterTransaction routerTransaction) {
        return this.f8275b.contains(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40569a(Bundle bundle) {
        ArrayList arrayList = new ArrayList(this.f8275b.size());
        for (RouterTransaction saveInstanceState : this.f8275b) {
            arrayList.add(saveInstanceState.saveInstanceState());
        }
        bundle.putParcelableArrayList(f8274a, arrayList);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40573b(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f8274a);
        if (parcelableArrayList != null) {
            Collections.reverse(parcelableArrayList);
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                this.f8275b.push(new RouterTransaction((Bundle) it.next()));
            }
        }
    }
}
