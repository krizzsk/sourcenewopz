package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bl */
final class C18464bl implements C18447av {
    C18464bl() {
    }

    /* renamed from: b */
    static void m37829b(ClassLoader classLoader, Set<File> set) {
        C18459bg.m37818a(classLoader, set, new C18462bj());
    }

    /* renamed from: b */
    static boolean m37830b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C18454bb.m37807a(classLoader, file, file2, z, C18459bg.m37817a(), "path", new C18463bk());
    }

    /* renamed from: a */
    public final void mo149100a(ClassLoader classLoader, Set<File> set) {
        m37829b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo149101a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m37830b(classLoader, file, file2, z);
    }
}
