package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import com.google.android.play.core.splitinstall.C18576d;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.i */
final class C18602i implements C18576d {

    /* renamed from: a */
    final /* synthetic */ List f53389a;

    /* renamed from: b */
    final /* synthetic */ List f53390b;

    /* renamed from: c */
    final /* synthetic */ long f53391c;

    /* renamed from: d */
    final /* synthetic */ boolean f53392d;

    /* renamed from: e */
    final /* synthetic */ List f53393e;

    /* renamed from: f */
    final /* synthetic */ FakeSplitInstallManager f53394f;

    C18602i(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f53394f = fakeSplitInstallManager;
        this.f53389a = list;
        this.f53390b = list2;
        this.f53391c = j;
        this.f53392d = z;
        this.f53393e = list3;
    }

    /* renamed from: a */
    public final void mo149292a() {
        this.f53394f.f53359l.addAll(this.f53389a);
        this.f53394f.f53360m.addAll(this.f53390b);
        this.f53394f.m38192a(5, 0, Long.valueOf(this.f53391c), Long.valueOf(this.f53391c), (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* renamed from: a */
    public final void mo149293a(int i) {
        this.f53394f.m38191a(i);
    }

    /* renamed from: b */
    public final void mo149294b() {
        if (!this.f53392d) {
            this.f53394f.m38190a((List<Intent>) this.f53393e, (List<String>) this.f53389a, (List<String>) this.f53390b, this.f53391c, true);
        }
    }
}
