package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import com.google.android.play.core.splitinstall.C18583k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bg */
final class C18459bg implements C18447av {
    C18459bg() {
    }

    /* renamed from: a */
    static C18453ba m37817a() {
        return new C18456bd();
    }

    /* renamed from: a */
    public static void m37818a(ClassLoader classLoader, Set<File> set, C18458bf bfVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a = C18454bb.m37806a(classLoader);
            C18469bq<List> a2 = C18470br.m37844a(a, "nativeLibraryDirectories", List.class);
            synchronized (C18583k.class) {
                ArrayList arrayList = new ArrayList(a2.mo149107a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                a2.mo149108a(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a3 = bfVar.mo149106a(a, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                C18468bp bpVar = new C18468bp("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    C18489cj.m37906a(bpVar, (IOException) arrayList2.get(i));
                }
                throw bpVar;
            }
            synchronized (C18583k.class) {
                C18470br.m37858b(a, "nativeLibraryPathElements", Object.class).mo149111b(Arrays.asList(a3));
            }
        }
    }

    /* renamed from: b */
    static C18458bf m37819b() {
        return new C18457be();
    }

    /* renamed from: b */
    public static boolean m37820b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C18454bb.m37807a(classLoader, file, file2, z, m37817a(), DownloadManager.MODULE_DIR_ZIP, C18454bb.m37808b());
    }

    /* renamed from: a */
    public final void mo149100a(ClassLoader classLoader, Set<File> set) {
        m37818a(classLoader, set, m37819b());
    }

    /* renamed from: a */
    public final boolean mo149101a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m37820b(classLoader, file, file2, z);
    }
}
