package com.google.android.play.core.internal;

import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.bk */
final class C18463bk implements C18451az {
    C18463bk() {
    }

    /* renamed from: a */
    public final boolean mo149103a(Object obj, File file, File file2) {
        try {
            return !((Boolean) C18470br.m37845a((Class) Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            SystemUtils.log(6, "SplitCompat", "Unexpected missing dalvik.system.DexFile.", (Throwable) null, "com.google.android.play.core.internal.bk", -1);
            return false;
        }
    }
}
