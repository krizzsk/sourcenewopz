package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18490ck;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bw */
final class C18340bw {

    /* renamed from: a */
    private static final C18432ag f52880a = new C18432ag("ExtractorLooper");

    /* renamed from: b */
    private final C18360cp f52881b;

    /* renamed from: c */
    private final C18337bt f52882c;

    /* renamed from: d */
    private final C18393dv f52883d;

    /* renamed from: e */
    private final C18377df f52884e;

    /* renamed from: f */
    private final C18381dj f52885f;

    /* renamed from: g */
    private final C18386do f52886g;

    /* renamed from: h */
    private final C18490ck<C18415w> f52887h;

    /* renamed from: i */
    private final C18363cs f52888i;

    /* renamed from: j */
    private final AtomicBoolean f52889j = new AtomicBoolean(false);

    C18340bw(C18360cp cpVar, C18490ck<C18415w> ckVar, C18337bt btVar, C18393dv dvVar, C18377df dfVar, C18381dj djVar, C18386do doVar, C18363cs csVar) {
        this.f52881b = cpVar;
        this.f52887h = ckVar;
        this.f52882c = btVar;
        this.f52883d = dvVar;
        this.f52884e = dfVar;
        this.f52885f = djVar;
        this.f52886g = doVar;
        this.f52888i = csVar;
    }

    /* renamed from: a */
    private final void m37570a(int i, Exception exc) {
        try {
            this.f52881b.mo148990d(i);
            this.f52881b.mo148977a(i);
        } catch (C18339bv unused) {
            f52880a.mo149083b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo148966a() {
        f52880a.mo149081a("Run extractor loop", new Object[0]);
        if (this.f52889j.compareAndSet(false, true)) {
            while (true) {
                C18362cr crVar = null;
                try {
                    crVar = this.f52888i.mo148991a();
                } catch (C18339bv e) {
                    f52880a.mo149083b("Error while getting next extraction task: %s", e.getMessage());
                    if (e.f52879a >= 0) {
                        this.f52887h.mo149139a().mo148892a(e.f52879a);
                        m37570a(e.f52879a, e);
                    }
                }
                if (crVar != null) {
                    try {
                        if (crVar instanceof C18336bs) {
                            this.f52882c.mo148965a((C18336bs) crVar);
                        } else if (crVar instanceof C18392du) {
                            this.f52883d.mo149037a((C18392du) crVar);
                        } else if (crVar instanceof C18376de) {
                            this.f52884e.mo149010a((C18376de) crVar);
                        } else if (crVar instanceof C18379dh) {
                            this.f52885f.mo149012a((C18379dh) crVar);
                        } else if (crVar instanceof C18385dn) {
                            this.f52886g.mo149014a((C18385dn) crVar);
                        } else {
                            f52880a.mo149083b("Unknown task type: %s", crVar.getClass().getName());
                        }
                    } catch (Exception e2) {
                        f52880a.mo149083b("Error during extraction task: %s", e2.getMessage());
                        this.f52887h.mo149139a().mo148892a(crVar.f52952j);
                        m37570a(crVar.f52952j, e2);
                    }
                } else {
                    this.f52889j.set(false);
                    return;
                }
            }
        } else {
            f52880a.mo149085d("runLoop already looping; return", new Object[0]);
        }
    }
}
