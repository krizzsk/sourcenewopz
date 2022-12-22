package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C18619i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cv */
final /* synthetic */ class C18366cv implements Runnable {

    /* renamed from: a */
    private final C18370cz f52965a;

    /* renamed from: b */
    private final List f52966b;

    /* renamed from: c */
    private final C18316az f52967c;

    /* renamed from: d */
    private final C18619i f52968d;

    C18366cv(C18370cz czVar, List list, C18316az azVar, C18619i iVar) {
        this.f52965a = czVar;
        this.f52966b = list;
        this.f52967c = azVar;
        this.f52968d = iVar;
    }

    public final void run() {
        this.f52965a.mo148998a(this.f52966b, this.f52967c, this.f52968d);
    }
}
