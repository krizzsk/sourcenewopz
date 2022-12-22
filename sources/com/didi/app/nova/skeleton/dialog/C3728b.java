package com.didi.app.nova.skeleton.dialog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.app.nova.skeleton.dialog.b */
/* compiled from: Stack */
final class C3728b implements Iterable<C3727a> {

    /* renamed from: a */
    private final Deque<C3727a> f8439a = new ArrayDeque();

    C3728b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo40926a() {
        return this.f8439a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo40927b() {
        return this.f8439a.size();
    }

    public Iterator<C3727a> iterator() {
        return this.f8439a.iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C3727a mo40929c() {
        return this.f8439a.peek();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C3727a mo40931d() {
        return this.f8439a.pop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40925a(C3727a aVar) {
        this.f8439a.removeFirstOccurrence(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40928b(C3727a aVar) {
        this.f8439a.push(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo40930c(C3727a aVar) {
        return this.f8439a.contains(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public List<C3727a> mo40932e() {
        ArrayList arrayList = new ArrayList();
        while (!mo40926a()) {
            arrayList.add(mo40931d());
        }
        return arrayList;
    }
}
