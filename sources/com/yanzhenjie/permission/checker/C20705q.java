package com.yanzhenjie.permission.checker;

import android.os.Environment;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.checker.q */
/* compiled from: StorageWriteTest */
class C20705q implements PermissionTest {
    C20705q() {
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            return true;
        }
        File externalStorageDirectory = SystemUtils.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return true;
        }
        File file = new File(externalStorageDirectory, "Android");
        if (file.exists() && file.isFile() && !file.delete()) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file, "ANDROID.PERMISSION.TEST");
        if (file2.exists()) {
            return file2.delete();
        }
        return file2.createNewFile();
    }
}
