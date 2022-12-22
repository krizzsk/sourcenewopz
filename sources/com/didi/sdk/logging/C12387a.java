package com.didi.sdk.logging;

import java.io.File;
import java.util.Date;

/* renamed from: com.didi.sdk.logging.a */
/* compiled from: AbstractRollingPolicy */
abstract class C12387a {

    /* renamed from: a */
    protected Date f36518a = new Date();

    /* renamed from: a */
    public abstract void mo92595a();

    /* renamed from: a */
    public abstract boolean mo92597a(File file);

    /* renamed from: b */
    public abstract String mo92598b();

    /* renamed from: c */
    public abstract File mo92599c();

    C12387a() {
    }

    /* renamed from: a */
    public void mo92596a(long j) {
        this.f36518a.setTime(j);
    }
}
