package com.didichuxing.mlcp.drtc.interfaces;

import java.util.Vector;

/* renamed from: com.didichuxing.mlcp.drtc.interfaces.e */
/* compiled from: ListenerList */
public class C15891e {

    /* renamed from: a */
    private final Vector<C15889c> f48326a = new Vector<>();

    /* renamed from: a */
    public int mo118942a(C15889c cVar) {
        int size;
        synchronized (this.f48326a) {
            if (cVar != null) {
                if (!this.f48326a.contains(cVar)) {
                    this.f48326a.add(cVar);
                }
            }
            size = this.f48326a.size();
        }
        return size;
    }

    /* renamed from: b */
    public int mo118944b(C15889c cVar) {
        int size;
        synchronized (this.f48326a) {
            if (cVar != null) {
                this.f48326a.remove(cVar);
            }
            size = this.f48326a.size();
        }
        return size;
    }

    /* renamed from: c */
    public int mo118946c() {
        int size;
        synchronized (this.f48326a) {
            size = this.f48326a.size();
        }
        return size;
    }

    /* renamed from: a */
    public void mo118943a() {
        synchronized (this.f48326a) {
            this.f48326a.clear();
        }
    }

    /* renamed from: b */
    public C15889c[] mo118945b() {
        C15889c[] cVarArr;
        synchronized (this.f48326a) {
            cVarArr = new C15889c[this.f48326a.size()];
            this.f48326a.toArray(cVarArr);
        }
        return cVarArr;
    }
}
