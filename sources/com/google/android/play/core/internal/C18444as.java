package com.google.android.play.core.internal;

import android.content.Intent;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitinstall.C18576d;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.as */
final class C18444as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f53151a;

    /* renamed from: b */
    final /* synthetic */ C18576d f53152b;

    /* renamed from: c */
    final /* synthetic */ C18445at f53153c;

    C18444as(C18445at atVar, List list, C18576d dVar) {
        this.f53153c = atVar;
        this.f53151a = list;
        this.f53152b = dVar;
    }

    public final void run() {
        try {
            if (this.f53153c.f53156c.mo149099a((List<Intent>) this.f53151a)) {
                C18445at.m37787a(this.f53153c, this.f53152b);
            } else {
                C18445at.m37788a(this.f53153c, this.f53151a, this.f53152b);
            }
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error checking verified files.", e, "com.google.android.play.core.internal.as", -1);
            this.f53152b.mo149293a(-11);
        }
    }
}
