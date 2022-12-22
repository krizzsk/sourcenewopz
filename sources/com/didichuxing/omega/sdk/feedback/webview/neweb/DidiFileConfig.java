package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.constant.FileNameConstant;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DidiFileConfig {
    private static String CACHE_ROOT = "";
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    private static String getSDPath() {
        return mContext.getCacheDir().getPath() + "/";
    }

    private static String getCacheRoot() {
        if (TextUtils.isEmpty(CACHE_ROOT)) {
            CACHE_ROOT = getSDPath() + FileNameConstant.ROOT_FOLDER;
            File file = new File(CACHE_ROOT);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return CACHE_ROOT;
    }

    private static String getPhotoCachePath() {
        String str = getCacheRoot() + "photo/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File getPhotoOutputFile() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(getPhotoCachePath() + File.separator + "IMG_" + format + ".jpg");
    }
}
