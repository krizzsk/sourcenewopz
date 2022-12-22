package com.didi.dqr.oned.rss.expanded;

import com.didi.dqr.oned.rss.DataCharacter;
import com.didi.dqr.oned.rss.FinderPattern;

/* renamed from: com.didi.dqr.oned.rss.expanded.b */
/* compiled from: ExpandedPair */
final class C7856b {

    /* renamed from: a */
    private final boolean f18819a;

    /* renamed from: b */
    private final DataCharacter f18820b;

    /* renamed from: c */
    private final DataCharacter f18821c;

    /* renamed from: d */
    private final FinderPattern f18822d;

    C7856b(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.f18820b = dataCharacter;
        this.f18821c = dataCharacter2;
        this.f18822d = finderPattern;
        this.f18819a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo58404a() {
        return this.f18819a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public DataCharacter mo58405b() {
        return this.f18820b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public DataCharacter mo58406c() {
        return this.f18821c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public FinderPattern mo58407d() {
        return this.f18822d;
    }

    /* renamed from: e */
    public boolean mo58408e() {
        return this.f18821c == null;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f18820b);
        sb.append(" , ");
        sb.append(this.f18821c);
        sb.append(" : ");
        FinderPattern finderPattern = this.f18822d;
        if (finderPattern == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(finderPattern.getValue());
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7856b)) {
            return false;
        }
        C7856b bVar = (C7856b) obj;
        if (!m13971a(this.f18820b, bVar.f18820b) || !m13971a(this.f18821c, bVar.f18821c) || !m13971a(this.f18822d, bVar.f18822d)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m13971a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        return (m13970a(this.f18820b) ^ m13970a(this.f18821c)) ^ m13970a(this.f18822d);
    }

    /* renamed from: a */
    private static int m13970a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
