package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18448aw;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.internal.C18500i;
import com.google.android.play.core.tasks.C18619i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cz */
final class C18370cz implements C18415w {

    /* renamed from: a */
    private static final C18432ag f52975a = new C18432ag("FakeAssetPackService");

    /* renamed from: h */
    private static final AtomicInteger f52976h = new AtomicInteger(1);

    /* renamed from: b */
    private final String f52977b;

    /* renamed from: c */
    private final C18313aw f52978c;

    /* renamed from: d */
    private final C18343bz f52979d;

    /* renamed from: e */
    private final Context f52980e;

    /* renamed from: f */
    private final C18383dl f52981f;

    /* renamed from: g */
    private final C18490ck<Executor> f52982g;

    /* renamed from: i */
    private final Handler f52983i = new Handler(Looper.getMainLooper());

    C18370cz(File file, C18313aw awVar, C18343bz bzVar, Context context, C18383dl dlVar, C18490ck<Executor> ckVar) {
        this.f52977b = file.getAbsolutePath();
        this.f52978c = awVar;
        this.f52979d = bzVar;
        this.f52980e = context;
        this.f52981f = dlVar;
        this.f52982g = ckVar;
    }

    /* renamed from: a */
    static long m37614a(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    /* renamed from: a */
    private final AssetPackState m37615a(String str, int i) throws LocalTestingException {
        long j = 0;
        for (File length : m37618b(str)) {
            j += length.length();
        }
        return AssetPackState.m37427a(str, i, 0, m37614a(i, j), j, this.f52979d.mo148972b(str), 1);
    }

    /* renamed from: a */
    private static String m37616a(File file) throws LocalTestingException {
        try {
            return C18373db.m37638a((List<File>) Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e);
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
        }
    }

    /* renamed from: a */
    private final void m37617a(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f52981f.mo149013a());
        bundle.putInt("session_id", i);
        File[] b = m37618b(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : b) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a = C18448aw.m37796a(file);
            bundle.putParcelableArrayList(C18500i.m37927a("chunk_intents", str, a), arrayList2);
            bundle.putString(C18500i.m37927a("uncompressed_hash_sha256", str, a), m37616a(file));
            bundle.putLong(C18500i.m37927a("uncompressed_size", str, a), file.length());
            arrayList.add(a);
        }
        bundle.putStringArrayList(C18500i.m37926a("slice_ids", str), arrayList);
        bundle.putLong(C18500i.m37926a("pack_version", str), (long) this.f52981f.mo149013a());
        bundle.putInt(C18500i.m37926a("status", str), i2);
        bundle.putInt(C18500i.m37926a("error_code", str), 0);
        bundle.putLong(C18500i.m37926a("bytes_downloaded", str), m37614a(i2, j));
        bundle.putLong(C18500i.m37926a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m37614a(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f52983i.post(new C18369cy(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: b */
    private final File[] m37618b(String str) throws LocalTestingException {
        File file = new File(this.f52977b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C18368cx(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a : listFiles) {
                        if (C18448aw.m37796a(a).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo148888a(List<String> list, C18316az azVar, Map<String, Long> map) {
        f52975a.mo149084c("getPackStates(%s)", list);
        C18619i iVar = new C18619i();
        this.f52982g.mo149139a().execute(new C18366cv(this, list, azVar, iVar));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo148889a(List<String> list, List<String> list2, Map<String, Long> map) {
        f52975a.mo149084c("startDownload(%s)", list2);
        C18619i iVar = new C18619i();
        this.f52982g.mo149139a().execute(new C18365cu(this, list2, iVar, list));
        return iVar.mo149338a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo148890a(Map<String, Long> map) {
        f52975a.mo149084c("syncPacks()", new Object[0]);
        return Tasks.m38221a(new ArrayList());
    }

    /* renamed from: a */
    public final void mo148891a() {
        f52975a.mo149084c("keepAlive", new Object[0]);
    }

    /* renamed from: a */
    public final void mo148892a(int i) {
        f52975a.mo149084c("notifySessionFailed", new Object[0]);
    }

    /* renamed from: a */
    public final void mo148893a(int i, String str) {
        f52975a.mo149084c("notifyModuleCompleted", new Object[0]);
        this.f52982g.mo149139a().execute(new C18367cw(this, i, str));
    }

    /* renamed from: a */
    public final void mo148894a(int i, String str, String str2, int i2) {
        f52975a.mo149084c("notifyChunkTransferred", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo148997a(Intent intent) {
        this.f52978c.mo148800a(this.f52980e, intent);
    }

    /* renamed from: a */
    public final void mo148895a(String str) {
        f52975a.mo149084c("removePack(%s)", str);
    }

    /* renamed from: a */
    public final void mo148896a(List<String> list) {
        f52975a.mo149084c("cancelDownload(%s)", list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo148998a(List list, C18316az azVar, C18619i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a = m37615a(str, azVar.mo148904a(8, str));
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
            } catch (LocalTestingException e) {
                iVar.mo149339a((Exception) e);
                return;
            }
        }
        iVar.mo149340a(AssetPackStates.m37429a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo148999a(List list, C18619i iVar, List list2) {
        C18619i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a = m37615a(str, 1);
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
            } catch (LocalTestingException e) {
                iVar2.mo149339a((Exception) e);
                return;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            try {
                int andIncrement = f52976h.getAndIncrement();
                m37617a(andIncrement, str2, 1);
                m37617a(andIncrement, str2, 2);
                m37617a(andIncrement, str2, 3);
            } catch (LocalTestingException e2) {
                iVar2.mo149339a((Exception) e2);
                return;
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            hashMap.put(str3, AssetPackState.m37427a(str3, 4, 0, 0, 0, 0.0d, 1));
        }
        iVar2.mo149340a(AssetPackStates.m37429a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo148897b(int i, String str, String str2, int i2) {
        f52975a.mo149084c("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        C18619i iVar = new C18619i();
        try {
            for (File file : m37618b(str)) {
                if (C18448aw.m37796a(file).equals(str2)) {
                    iVar.mo149340a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.mo149338a();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f52975a.mo149085d("getChunkFileDescriptor failed", e);
            iVar.mo149339a((Exception) new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f52975a.mo149085d("getChunkFileDescriptor failed", e2);
            iVar.mo149339a((Exception) e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo149000b(int i, String str) {
        try {
            m37617a(i, str, 4);
        } catch (LocalTestingException e) {
            f52975a.mo149085d("notifyModuleCompleted failed", e);
        }
    }
}
