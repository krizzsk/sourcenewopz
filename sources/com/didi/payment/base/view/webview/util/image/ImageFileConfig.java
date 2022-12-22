package com.didi.payment.base.view.webview.util.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.commoninterfacelib.permission.IntentUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ImageFileConfig {

    /* renamed from: a */
    private static final String f30093a = ".fileprovider";

    public static File getPhotoOutputFile(Context context) {
        File filesDir = context.getFilesDir();
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(filesDir, "IMG_" + format + ".jpg");
    }

    public static Intent getCameraIntent(Activity activity, File file) {
        String absolutePath = file.getAbsolutePath();
        return IntentUtil.getCameraIntent(activity, absolutePath, activity.getPackageName() + f30093a);
    }
}
