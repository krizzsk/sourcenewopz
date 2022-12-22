package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitinstall.C18583k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bb */
final class C18454bb implements C18447av {
    C18454bb() {
    }

    /* renamed from: a */
    static C18453ba m37805a() {
        return new C18449ax();
    }

    /* renamed from: a */
    static Object m37806a(ClassLoader classLoader) {
        return C18470br.m37844a((Object) classLoader, "pathList", Object.class).mo149107a();
    }

    /* renamed from: a */
    static boolean m37807a(ClassLoader classLoader, File file, File file2, boolean z, C18453ba baVar, String str, C18451az azVar) {
        ArrayList arrayList = new ArrayList();
        Object a = m37806a(classLoader);
        C18469bq b = C18470br.m37858b(a, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.mo149107a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a2 : asList) {
            arrayList2.add(C18470br.m37844a(a2, str, File.class).mo149107a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || azVar.mo149103a(a, file2, file)) {
            b.mo149109a((Collection) Arrays.asList(baVar.mo149102a(a, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            C18468bp bpVar = new C18468bp("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                SystemUtils.log(6, "SplitCompat", "DexPathList.makeDexElement failed", iOException, "com.google.android.play.core.internal.bb", -1);
                C18489cj.m37906a(bpVar, iOException);
            }
            C18470br.m37858b(a, "dexElementsSuppressedExceptions", IOException.class).mo149109a((Collection) arrayList);
            throw bpVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        SystemUtils.log(5, "SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
        return false;
    }

    /* renamed from: b */
    static C18451az m37808b() {
        return new C18450ay();
    }

    /* renamed from: b */
    static void m37809b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                SystemUtils.log(3, "Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
                hashSet.add(next.getParentFile());
            }
            C18469bq b = C18470br.m37858b(m37806a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.mo149107a()));
            synchronized (C18583k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                SystemUtils.log(3, "Splitcompat", sb.toString(), (Throwable) null, "com.google.android.play.core.internal.bb", -1);
                b.mo149111b(hashSet);
            }
        }
    }

    /* renamed from: a */
    public final void mo149100a(ClassLoader classLoader, Set<File> set) {
        m37809b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo149101a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m37807a(classLoader, file, file2, z, m37805a(), DownloadManager.MODULE_DIR_ZIP, m37808b());
    }
}
