package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C18420a;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.listener.C18519b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.aw */
final class C18313aw extends C18519b<AssetPackState> {

    /* renamed from: c */
    private final C18360cp f52771c;

    /* renamed from: d */
    private final C18340bw f52772d;

    /* renamed from: e */
    private final C18490ck<C18415w> f52773e;

    /* renamed from: f */
    private final C18331bn f52774f;

    /* renamed from: g */
    private final C18343bz f52775g;

    /* renamed from: h */
    private final C18420a f52776h;

    /* renamed from: i */
    private final C18490ck<Executor> f52777i;

    /* renamed from: j */
    private final C18490ck<Executor> f52778j;

    /* renamed from: k */
    private final Handler f52779k = new Handler(Looper.getMainLooper());

    C18313aw(Context context, C18360cp cpVar, C18340bw bwVar, C18490ck<C18415w> ckVar, C18343bz bzVar, C18331bn bnVar, C18420a aVar, C18490ck<Executor> ckVar2, C18490ck<Executor> ckVar3) {
        super(new C18432ag("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f52771c = cpVar;
        this.f52772d = bwVar;
        this.f52773e = ckVar;
        this.f52775g = bzVar;
        this.f52774f = bnVar;
        this.f52776h = aVar;
        this.f52777i = ckVar2;
        this.f52778j = ckVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo148800a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f53193a.mo149083b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
            if (bundleExtra2 != null) {
                this.f52776h.mo149064a(bundleExtra2);
            }
            AssetPackState a = AssetPackState.m37426a(bundleExtra, stringArrayList.get(0), this.f52775g, C18315ay.f52789a);
            this.f53193a.mo149081a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f52774f.mo148961a(pendingIntent);
            }
            this.f52778j.mo149139a().execute(new C18311au(this, bundleExtra, a));
            this.f52777i.mo149139a().execute(new C18312av(this, bundleExtra));
            return;
        }
        this.f53193a.mo149083b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo148901a(Bundle bundle) {
        if (this.f52771c.mo148979a(bundle)) {
            this.f52772d.mo148966a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo148902a(Bundle bundle, AssetPackState assetPackState) {
        if (this.f52771c.mo148984b(bundle)) {
            mo148903a(assetPackState);
            this.f52773e.mo149139a().mo148891a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo148903a(AssetPackState assetPackState) {
        this.f52779k.post(new C18310at(this, assetPackState));
    }
}
