package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18442aq;
import com.google.android.play.core.internal.C18478bz;
import com.google.android.play.core.internal.C18506o;
import com.google.android.play.core.splitcompat.C18546p;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.appupdate.p */
final class C18280p {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C18432ag f52644b = new C18432ag("AppUpdateService");

    /* renamed from: c */
    private static final Intent f52645c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C18442aq<C18506o> f52646a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f52647d;

    /* renamed from: e */
    private final Context f52648e;

    /* renamed from: f */
    private final C18282r f52649f;

    public C18280p(Context context, C18282r rVar) {
        this.f52647d = context.getPackageName();
        this.f52648e = context;
        this.f52649f = rVar;
        if (C18478bz.m37892a(context)) {
            this.f52646a = new C18442aq(C18546p.m38075a(context), f52644b, "AppUpdateService", f52645c, C18274j.f52632a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Bundle m37394a(C18280p pVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(m37400d());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(SystemUtils.getPackageInfo(pVar.f52648e.getPackageManager(), pVar.f52648e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f52644b.mo149083b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    static /* synthetic */ AppUpdateInfo m37395a(C18280p pVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return AppUpdateInfo.m37370a(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle2.getInt("client.version.staleness")), bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), pVar.f52649f.mo148812a(), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }

    /* renamed from: c */
    private static <T> Task<T> m37399c() {
        f52644b.mo149083b("onError(%d)", -9);
        return Tasks.m38220a((Exception) new InstallException(-9));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Bundle m37400d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10802);
        return bundle;
    }

    /* renamed from: a */
    public final Task<AppUpdateInfo> mo148810a(String str) {
        if (this.f52646a == null) {
            return m37399c();
        }
        f52644b.mo149084c("requestUpdateInfo(%s)", str);
        C18619i iVar = new C18619i();
        this.f52646a.mo149093a((C18433ah) new C18275k(this, iVar, str, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: b */
    public final Task<Void> mo148811b(String str) {
        if (this.f52646a == null) {
            return m37399c();
        }
        f52644b.mo149084c("completeUpdate(%s)", str);
        C18619i iVar = new C18619i();
        this.f52646a.mo149093a((C18433ah) new C18276l(this, iVar, iVar, str));
        return iVar.mo149338a();
    }
}
