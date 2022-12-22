package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.internal.C18500i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.cp */
final class C18360cp {

    /* renamed from: a */
    private static final C18432ag f52941a = new C18432ag("ExtractorSessionStoreView");

    /* renamed from: b */
    private final C18319bb f52942b;

    /* renamed from: c */
    private final C18490ck<C18415w> f52943c;

    /* renamed from: d */
    private final C18343bz f52944d;

    /* renamed from: e */
    private final C18490ck<Executor> f52945e;

    /* renamed from: f */
    private final Map<Integer, C18357cm> f52946f = new HashMap();

    /* renamed from: g */
    private final ReentrantLock f52947g = new ReentrantLock();

    C18360cp(C18319bb bbVar, C18490ck<C18415w> ckVar, C18343bz bzVar, C18490ck<Executor> ckVar2) {
        this.f52942b = bbVar;
        this.f52943c = ckVar;
        this.f52944d = bzVar;
        this.f52945e = ckVar2;
    }

    /* renamed from: a */
    private final <T> T m37588a(C18359co<T> coVar) {
        try {
            mo148976a();
            return coVar.mo148973a();
        } finally {
            mo148981b();
        }
    }

    /* renamed from: d */
    private final Map<String, C18357cm> m37589d(List<String> list) {
        return (Map) m37588a(new C18350cf(this, list));
    }

    /* renamed from: e */
    private final C18357cm m37590e(int i) {
        Map<Integer, C18357cm> map = this.f52946f;
        Integer valueOf = Integer.valueOf(i);
        C18357cm cmVar = map.get(valueOf);
        if (cmVar != null) {
            return cmVar;
        }
        throw new C18339bv(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }

    /* renamed from: e */
    private static String m37591e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C18339bv("Session without pack received.");
    }

    /* renamed from: e */
    private static <T> List<T> m37592e(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, Integer> mo148975a(List<String> list) {
        return (Map) m37588a(new C18353ci(this, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo148976a() {
        this.f52947g.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo148977a(int i) {
        m37588a(new C18352ch(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo148978a(String str, int i, long j) {
        m37588a(new C18349ce(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo148979a(Bundle bundle) {
        return ((Boolean) m37588a(new C18347cc(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Map mo148980b(List list) {
        int i;
        Map<String, C18357cm> d = m37589d((List<String>) list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C18357cm cmVar = d.get(str);
            if (cmVar == null) {
                i = 8;
            } else {
                if (C18373db.m37639a(cmVar.f52934c.f52929c)) {
                    try {
                        cmVar.f52934c.f52929c = 6;
                        this.f52945e.mo149139a().execute(new C18354cj(this, cmVar));
                        this.f52944d.mo148971a(str);
                    } catch (C18339bv unused) {
                        f52941a.mo149084c("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(cmVar.f52932a), str);
                    }
                }
                i = cmVar.f52934c.f52929c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo148981b() {
        this.f52947g.unlock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo148982b(int i) {
        m37590e(i).f52934c.f52929c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo148983b(String str, int i, long j) {
        C18357cm cmVar = m37589d((List<String>) Arrays.asList(new String[]{str})).get(str);
        if (cmVar == null || C18373db.m37642b(cmVar.f52934c.f52929c)) {
            f52941a.mo149083b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        this.f52942b.mo148934f(str, i, j);
        cmVar.f52934c.f52929c = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo148984b(Bundle bundle) {
        return ((Boolean) m37588a(new C18348cd(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Boolean mo148985c(Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map<Integer, C18357cm> map = this.f52946f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return true;
        }
        C18357cm cmVar = this.f52946f.get(valueOf);
        if (cmVar.f52934c.f52929c == 6) {
            z = false;
        } else {
            z = !C18373db.m37640a(cmVar.f52934c.f52929c, bundle.getInt(C18500i.m37926a("status", m37591e(bundle))));
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<Integer, C18357cm> mo148986c() {
        return this.f52946f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Map mo148987c(List list) {
        HashMap hashMap = new HashMap();
        for (C18357cm next : this.f52946f.values()) {
            String str = next.f52934c.f52927a;
            if (list.contains(str)) {
                C18357cm cmVar = (C18357cm) hashMap.get(str);
                if ((cmVar == null ? -1 : cmVar.f52932a) < next.f52932a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo148988c(int i) {
        C18357cm e = m37590e(i);
        if (C18373db.m37642b(e.f52934c.f52929c)) {
            C18319bb bbVar = this.f52942b;
            C18356cl clVar = e.f52934c;
            bbVar.mo148934f(clVar.f52927a, e.f52933b, clVar.f52928b);
            C18356cl clVar2 = e.f52934c;
            int i2 = clVar2.f52929c;
            if (i2 == 5 || i2 == 6) {
                this.f52942b.mo148926d(clVar2.f52927a);
                return;
            }
            return;
        }
        throw new C18339bv(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ Boolean mo148989d(Bundle bundle) {
        C18358cn cnVar;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return false;
        }
        Map<Integer, C18357cm> map = this.f52946f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        if (map.containsKey(valueOf)) {
            C18357cm e = m37590e(i);
            int i2 = bundle2.getInt(C18500i.m37926a("status", e.f52934c.f52927a));
            if (C18373db.m37640a(e.f52934c.f52929c, i2)) {
                f52941a.mo149081a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(e.f52934c.f52929c));
                C18356cl clVar = e.f52934c;
                String str = clVar.f52927a;
                int i3 = clVar.f52929c;
                if (i3 == 4) {
                    this.f52943c.mo149139a().mo148893a(i, str);
                } else if (i3 == 5) {
                    this.f52943c.mo149139a().mo148892a(i);
                } else if (i3 == 6) {
                    this.f52943c.mo149139a().mo148896a((List<String>) Arrays.asList(new String[]{str}));
                }
            } else {
                e.f52934c.f52929c = i2;
                if (C18373db.m37642b(i2)) {
                    mo148977a(i);
                    this.f52944d.mo148971a(e.f52934c.f52927a);
                } else {
                    for (C18358cn next : e.f52934c.f52931e) {
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(C18500i.m37927a("chunk_intents", e.f52934c.f52927a, next.f52935a));
                        if (parcelableArrayList != null) {
                            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                    next.f52938d.get(i4).f52926a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String e2 = m37591e(bundle);
            long j = bundle2.getLong(C18500i.m37926a("pack_version", e2));
            int i5 = bundle2.getInt(C18500i.m37926a("status", e2));
            long j2 = bundle2.getLong(C18500i.m37926a("total_bytes_to_download", e2));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(C18500i.m37926a("slice_ids", e2));
            ArrayList arrayList = new ArrayList();
            for (T t : m37592e(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(C18500i.m37927a("chunk_intents", e2, (String) t));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : m37592e(parcelableArrayList2)) {
                    if (intent == null) {
                        z = false;
                    }
                    arrayList2.add(new C18355ck(z));
                    z = true;
                }
                String string = bundle2.getString(C18500i.m37927a("uncompressed_hash_sha256", e2, (String) t));
                long j3 = bundle2.getLong(C18500i.m37927a("uncompressed_size", e2, (String) t));
                int i6 = bundle2.getInt(C18500i.m37927a("patch_format", e2, (String) t), 0);
                if (i6 != 0) {
                    cnVar = new C18358cn(t, string, j3, arrayList2, 0, i6);
                } else {
                    cnVar = new C18358cn(t, string, j3, arrayList2, bundle2.getInt(C18500i.m37927a("compression_format", e2, (String) t), 0), 0);
                }
                arrayList.add(cnVar);
                z = true;
            }
            this.f52946f.put(Integer.valueOf(i), new C18357cm(i, bundle2.getInt("app_version_code"), new C18356cl(e2, j, i5, j2, arrayList)));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo148990d(int i) {
        m37588a(new C18351cg(this, i));
    }
}
