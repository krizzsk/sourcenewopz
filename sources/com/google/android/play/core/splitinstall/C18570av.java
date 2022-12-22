package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18442aq;
import com.google.android.play.core.internal.C18474bv;
import com.google.android.play.core.internal.C18478bz;
import com.google.android.play.core.splitcompat.C18546p;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.av */
final class C18570av {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C18432ag f53301b = new C18432ag("SplitInstallService");

    /* renamed from: c */
    private static final Intent f53302c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C18442aq<C18474bv> f53303a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f53304d;

    public C18570av(Context context) {
        this.f53304d = context.getPackageName();
        if (C18478bz.m37892a(context)) {
            this.f53303a = new C18442aq(C18546p.m38075a(context), f53301b, "SplitInstallService", f53302c, C18552ad.f53274a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m38122a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m38123b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10802);
        return bundle;
    }

    /* renamed from: b */
    static /* synthetic */ ArrayList m38124b(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("language", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: d */
    private static <T> Task<T> m38126d() {
        f53301b.mo149083b("onError(%d)", -14);
        return Tasks.m38220a((Exception) new SplitInstallException(-14));
    }

    /* renamed from: a */
    public final Task<List<SplitInstallSessionState>> mo149278a() {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("getSessionStates", new Object[0]);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18559ak(this, iVar, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<SplitInstallSessionState> mo149279a(int i) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("getSessionState(%d)", Integer.valueOf(i));
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18558aj(this, iVar, i, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<Integer> mo149280a(Collection<String> collection, Collection<String> collection2) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("startInstall(%s,%s)", collection, collection2);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18553ae(this, iVar, collection, collection2, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<Void> mo149281a(List<String> list) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("deferredUninstall(%s)", list);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18554af(this, iVar, list, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: b */
    public final Task<Void> mo149282b(int i) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("cancelInstall(%d)", Integer.valueOf(i));
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18560al(this, iVar, i, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: b */
    public final Task<Void> mo149283b(List<String> list) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("deferredInstall(%s)", list);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18555ag(this, iVar, list, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: c */
    public final Task<Void> mo149284c(List<String> list) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("deferredLanguageInstall(%s)", list);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18556ah(this, iVar, list, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: d */
    public final Task<Void> mo149285d(List<String> list) {
        if (this.f53303a == null) {
            return m38126d();
        }
        f53301b.mo149084c("deferredLanguageUninstall(%s)", list);
        C18619i iVar = new C18619i();
        this.f53303a.mo149093a((C18433ah) new C18557ai(this, iVar, list, iVar));
        return iVar.mo149338a();
    }
}
