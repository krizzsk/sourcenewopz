package com.google.p220vr.dynamite.client;

import java.util.Objects;

/* renamed from: com.google.vr.dynamite.client.f */
/* compiled from: Version */
public final class C19717f {

    /* renamed from: a */
    private final int f53826a;

    /* renamed from: b */
    private final int f53827b;

    /* renamed from: c */
    private final int f53828c;

    public C19717f(int i, int i2, int i3) {
        this.f53826a = i;
        this.f53827b = i2;
        this.f53828c = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C19717f)) {
            return false;
        }
        C19717f fVar = (C19717f) obj;
        if (this.f53826a == fVar.f53826a && this.f53827b == fVar.f53827b && this.f53828c == fVar.f53828c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f53826a), Integer.valueOf(this.f53827b), Integer.valueOf(this.f53828c)});
    }

    public final String toString() {
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf(this.f53826a), Integer.valueOf(this.f53827b), Integer.valueOf(this.f53828c)});
    }
}
