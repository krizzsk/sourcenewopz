package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18433ah;
import com.google.android.play.core.internal.C18442aq;
import com.google.android.play.core.internal.C18478bz;
import com.google.android.play.core.internal.C18511t;
import com.google.android.play.core.splitcompat.C18546p;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.ar */
final class C18308ar implements C18415w {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C18432ag f52755a = new C18432ag("AssetPackServiceImpl");

    /* renamed from: b */
    private static final Intent f52756b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f52757c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C18343bz f52758d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C18442aq<C18511t> f52759e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C18442aq<C18511t> f52760f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f52761g = new AtomicBoolean();

    C18308ar(Context context, C18343bz bzVar) {
        this.f52757c = context.getPackageName();
        this.f52758d = bzVar;
        if (C18478bz.m37892a(context)) {
            this.f52759e = new C18442aq(C18546p.m38075a(context), f52755a, "AssetPackService", f52756b, C18416x.f53110a);
            this.f52760f = new C18442aq(C18546p.m38075a(context), f52755a, "AssetPackService-keepAlive", f52756b, C18417y.f53111a);
        }
        f52755a.mo149081a("AssetPackService initiated.", new Object[0]);
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m37466a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ List m37467a(C18308ar arVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AssetPackState next = AssetPackStates.m37430a((Bundle) it.next(), arVar.f52758d).packStates().values().iterator().next();
            if (next == null) {
                f52755a.mo149083b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C18373db.m37639a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m37468a(int i, String str, int i2) {
        if (this.f52759e != null) {
            f52755a.mo149084c("notifyModuleCompleted", new Object[0]);
            C18619i iVar = new C18619i();
            this.f52759e.mo149093a((C18433ah) new C18297ag(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C18339bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m37472b(Map map) {
        Bundle e = m37482e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e.putParcelableArrayList("installed_asset_module", arrayList);
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m37476c(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m37477c(int i, String str) {
        Bundle c = m37476c(i);
        c.putString("module_name", str);
        return c;
    }

    /* renamed from: c */
    static /* synthetic */ Bundle m37478c(int i, String str, String str2, int i2) {
        Bundle c = m37477c(i, str);
        c.putString("slice_id", str2);
        c.putInt("chunk_number", i2);
        return c;
    }

    /* renamed from: d */
    private static <T> Task<T> m37481d() {
        f52755a.mo149083b("onError(%d)", -11);
        return Tasks.m38220a((Exception) new AssetPackException(-11));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static Bundle m37482e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10802);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo148888a(List<String> list, C18316az azVar, Map<String, Long> map) {
        if (this.f52759e == null) {
            return m37481d();
        }
        f52755a.mo149084c("getPackStates(%s)", list);
        C18619i iVar = new C18619i();
        this.f52759e.mo149093a((C18433ah) new C18295ae(this, iVar, list, map, iVar, azVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo148889a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.f52759e == null) {
            return m37481d();
        }
        f52755a.mo149084c("startDownload(%s)", list2);
        C18619i iVar = new C18619i();
        this.f52759e.mo149093a((C18433ah) new C18292ab(this, iVar, list2, map, iVar, list));
        iVar.mo149338a().addOnSuccessListener(new C18418z(this));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo148890a(Map<String, Long> map) {
        if (this.f52759e == null) {
            return m37481d();
        }
        f52755a.mo149084c("syncPacks", new Object[0]);
        C18619i iVar = new C18619i();
        this.f52759e.mo149093a((C18433ah) new C18294ad(this, iVar, map, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final synchronized void mo148891a() {
        if (this.f52760f == null) {
            f52755a.mo149085d("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        f52755a.mo149084c("keepAlive", new Object[0]);
        if (!this.f52761g.compareAndSet(false, true)) {
            f52755a.mo149084c("Service is already kept alive.", new Object[0]);
            return;
        }
        C18619i iVar = new C18619i();
        this.f52760f.mo149093a((C18433ah) new C18300aj(this, iVar, iVar));
    }

    /* renamed from: a */
    public final void mo148892a(int i) {
        if (this.f52759e != null) {
            f52755a.mo149084c("notifySessionFailed", new Object[0]);
            C18619i iVar = new C18619i();
            this.f52759e.mo149093a((C18433ah) new C18298ah(this, iVar, i, iVar));
            return;
        }
        throw new C18339bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo148893a(int i, String str) {
        m37468a(i, str, 10);
    }

    /* renamed from: a */
    public final void mo148894a(int i, String str, String str2, int i2) {
        if (this.f52759e != null) {
            f52755a.mo149084c("notifyChunkTransferred", new Object[0]);
            C18619i iVar = new C18619i();
            this.f52759e.mo149093a((C18433ah) new C18296af(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C18339bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo148895a(String str) {
        if (this.f52759e != null) {
            f52755a.mo149084c("removePack(%s)", str);
            C18619i iVar = new C18619i();
            this.f52759e.mo149093a((C18433ah) new C18291aa(this, iVar, str, iVar));
        }
    }

    /* renamed from: a */
    public final void mo148896a(List<String> list) {
        if (this.f52759e != null) {
            f52755a.mo149084c("cancelDownloads(%s)", list);
            C18619i iVar = new C18619i();
            this.f52759e.mo149093a((C18433ah) new C18293ac(this, iVar, list, iVar));
        }
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo148897b(int i, String str, String str2, int i2) {
        if (this.f52759e == null) {
            return m37481d();
        }
        f52755a.mo149084c("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        C18619i iVar = new C18619i();
        this.f52759e.mo149093a((C18433ah) new C18299ai(this, iVar, i, str, str2, i2, iVar));
        return iVar.mo149338a();
    }
}
