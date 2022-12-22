package com.didi.dqr.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.oned.rss.expanded.c */
/* compiled from: ExpandedRow */
final class C7857c {

    /* renamed from: a */
    private final List<C7856b> f18823a;

    /* renamed from: b */
    private final int f18824b;

    /* renamed from: c */
    private final boolean f18825c;

    C7857c(List<C7856b> list, int i, boolean z) {
        this.f18823a = new ArrayList(list);
        this.f18824b = i;
        this.f18825c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C7856b> mo58412a() {
        return this.f18823a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58414b() {
        return this.f18824b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo58415c() {
        return this.f18825c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo58413a(List<C7856b> list) {
        return this.f18823a.equals(list);
    }

    public String toString() {
        return "{ " + this.f18823a + " }";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7857c)) {
            return false;
        }
        C7857c cVar = (C7857c) obj;
        if (!this.f18823a.equals(cVar.mo58412a()) || this.f18825c != cVar.f18825c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f18823a.hashCode() ^ Boolean.valueOf(this.f18825c).hashCode();
    }
}
