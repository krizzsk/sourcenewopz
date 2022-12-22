package com.didi.sdk.event;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.event.d */
/* compiled from: PendingPost */
final class C12184d {

    /* renamed from: d */
    private static final List<C12184d> f35864d = new ArrayList();

    /* renamed from: a */
    Event f35865a;

    /* renamed from: b */
    C12188h f35866b;

    /* renamed from: c */
    C12184d f35867c;

    private C12184d(Event event, C12188h hVar) {
        this.f35865a = event;
        this.f35866b = hVar;
    }

    /* renamed from: a */
    static C12184d m25404a(C12188h hVar, Event event) {
        synchronized (f35864d) {
            int size = f35864d.size();
            if (size <= 0) {
                return new C12184d(event, hVar);
            }
            C12184d remove = f35864d.remove(size - 1);
            remove.f35865a = event;
            remove.f35866b = hVar;
            remove.f35867c = null;
            return remove;
        }
    }

    /* renamed from: a */
    static void m25405a(C12184d dVar) {
        dVar.f35865a = null;
        dVar.f35866b = null;
        dVar.f35867c = null;
        synchronized (f35864d) {
            if (f35864d.size() < 10000) {
                f35864d.add(dVar);
            }
        }
    }
}
