package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C18492cm;
import com.google.android.play.core.internal.C18494co;
import com.google.android.play.core.splitinstall.testing.C18604k;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.c */
public final class C18575c implements C18585m {

    /* renamed from: a */
    private C18494co<Context> f53309a;

    /* renamed from: b */
    private C18494co<C18570av> f53310b;

    /* renamed from: c */
    private C18494co<C18593t> f53311c;

    /* renamed from: d */
    private C18494co<C18589p> f53312d = C18492cm.m37910a(C18590q.m38173a(this.f53309a));

    /* renamed from: e */
    private C18494co<C18572ax> f53313e;

    /* renamed from: f */
    private C18494co<C18607w> f53314f;

    /* renamed from: g */
    private C18494co<File> f53315g;

    /* renamed from: h */
    private C18494co<FakeSplitInstallManager> f53316h;

    /* renamed from: i */
    private C18494co<C18581i> f53317i;

    /* renamed from: j */
    private C18494co<SplitInstallManager> f53318j;

    /* synthetic */ C18575c(C18609y yVar) {
        C18610z zVar = new C18610z(yVar);
        this.f53309a = zVar;
        this.f53310b = C18492cm.m37910a(new C18571aw(zVar));
        this.f53311c = C18492cm.m37910a(new C18550ab(yVar));
        C18494co<C18572ax> a = C18492cm.m37910a(new C18573ay(this.f53309a));
        this.f53313e = a;
        this.f53314f = C18492cm.m37910a(new C18608x(this.f53310b, this.f53311c, this.f53312d, a));
        C18494co<File> a2 = C18492cm.m37910a(new C18549aa(this.f53309a));
        this.f53315g = a2;
        C18494co<FakeSplitInstallManager> a3 = C18492cm.m37910a(new C18604k(this.f53309a, a2, this.f53312d));
        this.f53316h = a3;
        C18494co<C18581i> a4 = C18492cm.m37910a(new C18582j(this.f53314f, a3, this.f53315g));
        this.f53317i = a4;
        this.f53318j = C18492cm.m37910a(new C18551ac(yVar, a4));
    }

    /* renamed from: a */
    public final SplitInstallManager mo149290a() {
        return this.f53318j.mo148801a();
    }

    /* renamed from: b */
    public final File mo149291b() {
        return this.f53315g.mo148801a();
    }
}
