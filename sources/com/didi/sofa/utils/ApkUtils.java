package com.didi.sofa.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

public class ApkUtils {
    public static boolean isInstalled(Context context, String str) {
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), str, 1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getSourceApkPath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void installApk(String str, Context context) {
        File file = new File(str);
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 28) {
                intent.setFlags(268435457);
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), "application/vnd.android.package-archive");
            } else if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(1);
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static String getPackageVersionName(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
