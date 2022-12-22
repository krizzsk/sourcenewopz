package com.didi.sdk.webview.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.didi.commoninterfacelib.permission.IntentUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ImageFileConfig {

    /* renamed from: a */
    private static final String f38450a = ".fileprovider";

    public static File getPhotoOutputFile(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalFilesDir, "IMG_" + format + ".jpg");
    }

    public static Intent getCameraIntent(Activity activity, File file) {
        String absolutePath = file.getAbsolutePath();
        return IntentUtil.getCameraIntent(activity, absolutePath, activity.getPackageName() + f38450a);
    }
}
