package com.google.android.play.core.internal;

import com.didi.dynamic.manager.DownloadManager;
import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bc */
final class C18455bc implements C18447av {
    C18455bc() {
    }

    /* renamed from: a */
    public final void mo149100a(ClassLoader classLoader, Set<File> set) {
        C18454bb.m37809b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo149101a(ClassLoader classLoader, File file, File file2, boolean z) {
        return C18454bb.m37807a(classLoader, file, file2, z, C18454bb.m37805a(), DownloadManager.MODULE_DIR_ZIP, C18454bb.m37808b());
    }
}
