package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.a */
/* compiled from: StreamCompleteListenerManager */
class C15778a {

    /* renamed from: a */
    private boolean f47997a = false;

    /* renamed from: b */
    private ArrayList<StreamCompleteListener> f47998b = new ArrayList<>();

    C15778a() {
    }

    /* renamed from: a */
    public boolean mo118239a() {
        boolean z;
        synchronized (this) {
            z = this.f47997a;
        }
        return z;
    }

    /* renamed from: a */
    public void mo118238a(StreamCompleteListener streamCompleteListener) {
        synchronized (this.f47998b) {
            this.f47998b.add(streamCompleteListener);
        }
    }

    /* renamed from: b */
    public void mo118241b(StreamCompleteListener streamCompleteListener) {
        synchronized (this.f47998b) {
            this.f47998b.remove(streamCompleteListener);
        }
    }

    /* renamed from: a */
    public void mo118237a(StreamCompleteEvent streamCompleteEvent) {
        if (!m34259b()) {
            for (StreamCompleteListener streamComplete : m34260c()) {
                streamComplete.streamComplete(streamCompleteEvent);
            }
        }
    }

    /* renamed from: b */
    public void mo118240b(StreamCompleteEvent streamCompleteEvent) {
        if (!m34259b()) {
            for (StreamCompleteListener streamError : m34260c()) {
                streamError.streamError(streamCompleteEvent);
            }
        }
    }

    /* renamed from: b */
    private boolean m34259b() {
        boolean a;
        synchronized (this) {
            a = mo118239a();
            if (!a) {
                this.f47997a = true;
            }
        }
        return a;
    }

    /* renamed from: c */
    private List<StreamCompleteListener> m34260c() {
        ArrayList arrayList;
        synchronized (this.f47998b) {
            arrayList = new ArrayList(this.f47998b);
            this.f47998b.clear();
        }
        return arrayList;
    }
}
