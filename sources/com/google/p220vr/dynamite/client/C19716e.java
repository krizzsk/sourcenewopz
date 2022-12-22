package com.google.p220vr.dynamite.client;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Objects;

/* renamed from: com.google.vr.dynamite.client.e */
/* compiled from: TargetLibraryInfo */
final class C19716e {

    /* renamed from: a */
    private final String f53824a;

    /* renamed from: b */
    private final String f53825b;

    public C19716e(String str, String str2) {
        this.f53824a = str;
        this.f53825b = str2;
    }

    /* renamed from: a */
    public final String mo161022a() {
        return this.f53824a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C19716e) {
            C19716e eVar = (C19716e) obj;
            return Objects.equals(this.f53824a, eVar.f53824a) && Objects.equals(this.f53825b, eVar.f53825b);
        }
    }

    public final int hashCode() {
        return (Objects.hashCode(this.f53824a) * 37) + Objects.hashCode(this.f53825b);
    }

    public final String toString() {
        return "[packageName=" + this.f53824a + ",libraryName=" + this.f53825b + Const.jaRight;
    }
}
