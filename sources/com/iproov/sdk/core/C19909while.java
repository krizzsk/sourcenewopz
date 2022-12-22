package com.iproov.sdk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.iproov.sdk.core.while */
/* compiled from: PatchDetector */
public class C19909while {

    /* renamed from: a */
    static final Map<C19898import, C19910do> f54344a = new HashMap();

    /* renamed from: com.iproov.sdk.core.while$do */
    /* compiled from: PatchDetector */
    static class C19910do {

        /* renamed from: do */
        private long f54345do;

        /* renamed from: if */
        Boolean f54346if = null;

        public C19910do(C19898import importR) {
        }

        /* renamed from: do */
        public synchronized long mo162116do() {
            return this.f54345do;
        }

        /* renamed from: do */
        public synchronized void mo162117do(long j) {
            this.f54345do = j;
        }
    }

    /* renamed from: com.iproov.sdk.core.while$if */
    /* compiled from: PatchDetector */
    static class C19911if {

        /* renamed from: do */
        public final String f54347do;

        /* renamed from: if */
        public final String f54348if;

        public C19911if(StackTraceElement stackTraceElement) {
            this.f54347do = stackTraceElement.getClassName();
            this.f54348if = stackTraceElement.getMethodName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C19911if.class != obj.getClass()) {
                return false;
            }
            C19911if ifVar = (C19911if) obj;
            if (!Objects.equals(this.f54347do, ifVar.f54347do) || !Objects.equals(this.f54348if, ifVar.f54348if)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f54347do, this.f54348if});
        }

        public String toString() {
            return "M{c='" + this.f54347do + '\'' + ", m='" + this.f54348if + '\'' + '}';
        }
    }

    /* renamed from: do */
    public static void m39264do(C19898import importR) {
        Map<C19898import, C19910do> map = f54344a;
        C19910do doVar = map.get(importR);
        long currentTimeMillis = System.currentTimeMillis();
        if (doVar == null) {
            doVar = new C19910do(importR);
            map.put(importR, doVar);
        } else if (doVar.f54346if == Boolean.FALSE || doVar.mo162116do() > currentTimeMillis) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 5) {
            C19911if ifVar = new C19911if(stackTrace[3]);
            boolean z = true;
            boolean z2 = importR.f54323do.contains(ifVar.f54347do) && !ifVar.equals(new C19911if(stackTrace[4]));
            Boolean bool = doVar.f54346if;
            if (bool == null) {
                z = z2;
            } else if (!bool.booleanValue() || !z2) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            doVar.f54346if = valueOf;
            C19797b.m38875a(importR, valueOf);
        }
        doVar.mo162117do(currentTimeMillis + importR.f54324if);
    }
}
