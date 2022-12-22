package com.didi.unifylogin.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.didi.sdk.apm.SystemUtils;

public class MetaDataUtils {
    public static <T> T getMetaDataByKey(Context context, String str, T t) {
        T t2;
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16512);
            if (packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (t2 = packageInfo.applicationInfo.metaData.get(str)) == null) {
                return t;
            }
            return t2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
