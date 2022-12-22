package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.internal.C18500i;
import com.google.android.play.core.splitinstall.C18589p;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
final class C18401j implements AssetPackManager {

    /* renamed from: a */
    private static final C18432ag f53077a = new C18432ag("AssetPackManager");

    /* renamed from: b */
    private final C18319bb f53078b;

    /* renamed from: c */
    private final C18490ck<C18415w> f53079c;

    /* renamed from: d */
    private final C18313aw f53080d;

    /* renamed from: e */
    private final C18589p f53081e;

    /* renamed from: f */
    private final C18360cp f53082f;

    /* renamed from: g */
    private final C18343bz f53083g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C18331bn f53084h;

    /* renamed from: i */
    private final C18490ck<Executor> f53085i;

    /* renamed from: j */
    private final Handler f53086j = new Handler(Looper.getMainLooper());

    /* renamed from: k */
    private boolean f53087k;

    C18401j(C18319bb bbVar, C18490ck<C18415w> ckVar, C18313aw awVar, C18589p pVar, C18360cp cpVar, C18343bz bzVar, C18331bn bnVar, C18490ck<Executor> ckVar2) {
        this.f53078b = bbVar;
        this.f53079c = ckVar;
        this.f53080d = awVar;
        this.f53081e = pVar;
        this.f53082f = cpVar;
        this.f53083g = bzVar;
        this.f53084h = bnVar;
        this.f53085i = ckVar2;
    }

    /* renamed from: c */
    private final void m37698c() {
        this.f53085i.mo149139a().execute(new C18396e(this));
    }

    /* renamed from: d */
    private final void m37699d() {
        this.f53085i.mo149139a().execute(new C18397f(this));
        this.f53087k = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo149052a(int i, String str) {
        if (!this.f53078b.mo148914a(str) && i == 4) {
            return 8;
        }
        if (!this.f53078b.mo148914a(str) || i == 4) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149053a() {
        this.f53078b.mo148925d();
        this.f53078b.mo148922c();
        this.f53078b.mo148930e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo149054a(String str, C18619i iVar) {
        if (this.f53078b.mo148926d(str)) {
            iVar.mo149340a(null);
            this.f53079c.mo149139a().mo148895a(str);
            return;
        }
        iVar.mo149339a((Exception) new IOException(String.format("Failed to remove pack %s.", new Object[]{str})));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo149055a(boolean z) {
        boolean b = this.f53080d.mo149192b();
        this.f53080d.mo149190a(z);
        if (z && !b) {
            m37698c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo149056b() {
        C18319bb bbVar = this.f53078b;
        bbVar.getClass();
        this.f53079c.mo149139a().mo148890a(this.f53078b.mo148918b()).addOnSuccessListener(this.f53085i.mo149139a(), C18398g.m37695a(bbVar)).addOnFailureListener(this.f53085i.mo149139a(), C18399h.f53074a);
    }

    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> a = this.f53082f.mo148975a(list);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = a.get(next);
            hashMap.put(next, AssetPackState.m37427a(next, num == null ? 0 : num.intValue(), 0, 0, 0, 0.0d, 1));
        }
        this.f53079c.mo149139a().mo148896a(list);
        return AssetPackStates.m37429a(0, (Map<String, AssetPackState>) hashMap);
    }

    public final void clearListeners() {
        this.f53080d.mo149187a();
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> b = this.f53078b.mo148918b();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(b.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.f53079c.mo149139a().mo148889a((List<String>) arrayList2, (List<String>) arrayList, b);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(C18500i.m37926a("status", next), 4);
            bundle.putInt(C18500i.m37926a("error_code", next), 0);
            bundle.putLong(C18500i.m37926a("total_bytes_to_download", next), 0);
            bundle.putLong(C18500i.m37926a("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.m38221a(AssetPackStates.m37430a(bundle, this.f53083g));
    }

    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.f53087k) {
            this.f53085i.mo149139a().execute(new C18397f(this));
            this.f53087k = true;
        }
        if (this.f53078b.mo148914a(str)) {
            try {
                assetPackLocation = this.f53078b.mo148915b(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.f53081e.mo149300a().contains(str)) {
                assetPackLocation = AssetPackLocation.m37424a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.f53078b.mo148907a(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.f53078b.mo148908a(str, str2, assetPackLocation);
        }
        f53077a.mo149081a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    public final AssetPackLocation getPackLocation(String str) {
        if (!this.f53087k) {
            m37699d();
        }
        if (this.f53078b.mo148914a(str)) {
            try {
                return this.f53078b.mo148915b(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.f53081e.mo149300a().contains(str)) {
            return AssetPackLocation.m37424a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> a = this.f53078b.mo148911a();
        HashMap hashMap = new HashMap();
        for (String put : this.f53081e.mo149300a()) {
            hashMap.put(put, AssetPackLocation.m37424a());
        }
        a.putAll(hashMap);
        return a;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.f53079c.mo149139a().mo148888a(list, (C18316az) new C18344c(this), this.f53078b.mo148918b());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean b = this.f53080d.mo149192b();
        this.f53080d.mo149188a(assetPackStateUpdateListener);
        if (!b) {
            m37698c();
        }
    }

    public final Task<Void> removePack(String str) {
        C18619i iVar = new C18619i();
        this.f53085i.mo149139a().execute(new C18371d(this, str, iVar));
        return iVar.mo149338a();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (activity == null) {
            return Tasks.m38220a((Exception) new AssetPackException(-3));
        }
        if (this.f53084h.mo148960a() == null) {
            return Tasks.m38220a((Exception) new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f53084h.mo148960a());
        C18619i iVar = new C18619i();
        intent.putExtra("result_receiver", new C18400i(this, this.f53086j, iVar));
        activity.startActivity(intent);
        return iVar.mo149338a();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.f53080d.mo149191b(assetPackStateUpdateListener);
    }
}
