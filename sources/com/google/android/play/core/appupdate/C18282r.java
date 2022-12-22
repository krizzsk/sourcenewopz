package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* renamed from: com.google.android.play.core.appupdate.r */
final class C18282r {

    /* renamed from: a */
    private final Context f52652a;

    C18282r(Context context) {
        this.f52652a = context;
    }

    /* renamed from: a */
    private static long m37404a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File a : listFiles) {
                j += m37404a(a);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo148812a() {
        return m37404a(new File(this.f52652a.getFilesDir(), "assetpacks"));
    }
}
