package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C18619i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cu */
final /* synthetic */ class C18365cu implements Runnable {

    /* renamed from: a */
    private final C18370cz f52961a;

    /* renamed from: b */
    private final List f52962b;

    /* renamed from: c */
    private final C18619i f52963c;

    /* renamed from: d */
    private final List f52964d;

    C18365cu(C18370cz czVar, List list, C18619i iVar, List list2) {
        this.f52961a = czVar;
        this.f52962b = list;
        this.f52963c = iVar;
        this.f52964d = list2;
    }

    public final void run() {
        this.f52961a.mo148999a(this.f52962b, this.f52963c, this.f52964d);
    }
}
