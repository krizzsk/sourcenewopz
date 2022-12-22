package p096try;

import com.iproov.sdk.core.C19887for;
import com.iproov.sdk.core.exception.IProovException;
import p093switch.C3113class;
import p096try.C3138if;

/* renamed from: try.for */
/* compiled from: StateManager */
public final class C3137for {

    /* renamed from: a */
    private static final C3138if f6985a = new C3138if.C3144goto();

    /* renamed from: b */
    private final C3138if.C3147this f6986b;

    /* renamed from: c */
    private volatile C3138if f6987c = f6985a;

    /* renamed from: d */
    private final C3113class<C3136do> f6988d = new C3113class<>(750);

    public C3137for(C3138if.C3147this thisR) {
        this.f6986b = thisR;
    }

    /* renamed from: do */
    public synchronized C3138if.C3143for mo38663do(String str) {
        C3138if.C3143for forR;
        if (!(this.f6987c instanceof C3138if.C3146new)) {
            forR = null;
        } else {
            forR = (C3138if.C3143for) m4112a(new C3138if.C3143for(str));
        }
        return forR;
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized C3138if.C3141do m46216for() {
        return this.f6987c.mo38675if() ? null : (C3138if.C3141do) m4112a(new C3138if.C3141do());
    }

    /* renamed from: if */
    public synchronized C3138if mo38668if() {
        return this.f6987c;
    }

    /* renamed from: new  reason: not valid java name */
    public synchronized C3138if.C3146new m46217new() {
        C3138if.C3146new newR;
        if (!(this.f6987c == f6985a)) {
            newR = null;
        } else {
            newR = (C3138if.C3146new) m4112a(new C3138if.C3146new());
        }
        return newR;
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized C3138if.C3142else m46218try() {
        if (this.f6987c instanceof C3138if.C3145if) {
            C3138if.C3145if ifVar = (C3138if.C3145if) this.f6987c;
            if (ifVar.m46229for()) {
                return (C3138if.C3142else) m4112a(new C3138if.C3142else(ifVar.m46231try()));
            }
        }
        return null;
    }

    /* renamed from: do */
    public synchronized boolean mo38666do() {
        return (this.f6987c instanceof C3138if.C3145if) || (this.f6987c instanceof C3138if.C3143for);
    }

    /* renamed from: do */
    public synchronized C3138if.C3145if mo38664do(C3138if.C3145if ifVar) {
        return !mo38666do() ? null : (C3138if.C3145if) m4112a(ifVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p096try.C3138if.C3142else mo38662do(p235for.C20836do r2, int r3, float r4, float r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            try.if r0 = r1.f6987c     // Catch:{ all -> 0x0022 }
            boolean r0 = r0 instanceof p096try.C3138if.C3146new     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0010
            try.if r0 = r1.f6987c     // Catch:{ all -> 0x0022 }
            boolean r0 = r0 instanceof p096try.C3138if.C3142else     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 != 0) goto L_0x0015
            r2 = 0
            goto L_0x0020
        L_0x0015:
            try.if$else r0 = new try.if$else     // Catch:{ all -> 0x0022 }
            r0.<init>(r2, r3, r4, r5)     // Catch:{ all -> 0x0022 }
            try.if r2 = r1.m4112a(r0)     // Catch:{ all -> 0x0022 }
            try.if$else r2 = (p096try.C3138if.C3142else) r2     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r1)
            return r2
        L_0x0022:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p096try.C3137for.mo38662do(for.do, int, float, float):try.if$else");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001b  */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p096try.C3138if.C3139break mo38660do(double r2, java.lang.String r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            try.if r0 = r1.f6987c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p096try.C3138if.C3145if     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0016
            try.if r0 = r1.f6987c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p096try.C3138if.C3142else     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0016
            try.if r0 = r1.f6987c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p096try.C3138if.C3139break     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            if (r0 != 0) goto L_0x001b
            r2 = 0
            goto L_0x0026
        L_0x001b:
            try.if$break r0 = new try.if$break     // Catch:{ all -> 0x0028 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x0028 }
            try.if r2 = r1.m4112a(r0)     // Catch:{ all -> 0x0028 }
            try.if$break r2 = (p096try.C3138if.C3139break) r2     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)
            return r2
        L_0x0028:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p096try.C3137for.mo38660do(double, java.lang.String):try.if$break");
    }

    /* renamed from: do */
    public synchronized C3138if.C3148try mo38665do(IProovException iProovException) {
        return this.f6987c.mo38675if() ? null : (C3138if.C3148try) m4112a(new C3138if.C3148try(iProovException));
    }

    /* renamed from: do */
    public synchronized C3138if.C3140case mo38661do(C19887for forR) {
        return this.f6987c.mo38675if() ? null : (C3138if.C3140case) m4112a(new C3138if.C3140case(forR));
    }

    /* renamed from: a */
    private synchronized <S extends C3138if> S m4112a(S s) {
        if ((this.f6987c instanceof C3138if.C3145if) && (s instanceof C3138if.C3145if)) {
            C3138if.C3145if ifVar = (C3138if.C3145if) s;
            C3136do doVar = this.f6988d.mo38617do();
            if (doVar != null && doVar.mo38659if()) {
                return null;
            }
            if (ifVar.m46230new().m46215for()) {
                if (doVar == this.f6988d.mo38619if(ifVar.m46230new())) {
                    return null;
                }
            } else if (doVar == ifVar.m46230new()) {
                return null;
            } else {
                this.f6988d.mo38618do(ifVar.m46230new());
            }
        }
        this.f6987c = s;
        this.f6987c.mo38674if(this.f6986b);
        return s;
    }
}
