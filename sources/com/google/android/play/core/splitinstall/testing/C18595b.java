package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.b */
final /* synthetic */ class C18595b implements C18603j {

    /* renamed from: a */
    private final Integer f53365a;

    /* renamed from: b */
    private final int f53366b;

    /* renamed from: c */
    private final int f53367c;

    /* renamed from: d */
    private final Long f53368d;

    /* renamed from: e */
    private final Long f53369e;

    /* renamed from: f */
    private final List f53370f;

    /* renamed from: g */
    private final List f53371g;

    C18595b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.f53365a = num;
        this.f53366b = i;
        this.f53367c = i2;
        this.f53368d = l;
        this.f53369e = l2;
        this.f53370f = list;
        this.f53371g = list2;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo149310a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.m38184a(this.f53365a, this.f53366b, this.f53367c, this.f53368d, this.f53369e, this.f53370f, this.f53371g, splitInstallSessionState);
    }
}
