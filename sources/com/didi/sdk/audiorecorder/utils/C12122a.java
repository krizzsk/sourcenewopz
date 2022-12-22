package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: com.didi.sdk.audiorecorder.utils.a */
/* compiled from: LogRootDir */
final class C12122a {
    private C12122a() {
    }

    /* renamed from: a */
    public static File m25180a(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return externalFilesDir;
        }
        File file = new File(externalFilesDir.getAbsolutePath(), "\\.WL");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
