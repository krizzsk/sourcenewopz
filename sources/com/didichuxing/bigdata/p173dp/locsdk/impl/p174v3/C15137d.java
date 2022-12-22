package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.d */
/* compiled from: LocBizWraper */
class C15137d<T> {

    /* renamed from: a */
    private List<C15138e<T>> f45933a = new CopyOnWriteArrayList();

    C15137d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114562a(C15138e eVar) {
        if (!this.f45933a.contains(eVar)) {
            this.f45933a.add(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo114563b(C15138e eVar) {
        if (this.f45933a.contains(eVar)) {
            this.f45933a.remove(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public T mo114561a(T t) {
        for (C15138e next : this.f45933a) {
            if (t == null) {
                break;
            }
            t = next.intercept(t);
        }
        return t;
    }
}
