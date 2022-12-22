package com.didichuxing.omega.sdk.corelink.node;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.tencent.mmkv.MMKV;
import java.io.File;

public class EventRecordPathNode {
    private static String mRecordDataPath;
    private static String mRecordRootPath;

    public static void init(Context context) {
        mRecordRootPath = context.getFilesDir().getAbsolutePath() + File.separator + "omega";
        mRecordDataPath = mRecordRootPath + File.separator + "cache";
        if (TextUtils.isEmpty(MMKV.getRootDir())) {
            try {
                MMKV.initialize(context.getFilesDir().getAbsolutePath());
            } catch (Throwable unused) {
                OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION = false;
            }
        }
    }

    static String getRecordRootPath() {
        return mRecordRootPath;
    }

    public static String getRecordDataPath() {
        return mRecordDataPath;
    }

    static String getPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (RuntimeCheck.IsMainProcess()) {
            return str;
        }
        return str + "_" + RuntimeCheck.getProcessNameInMD5();
    }
}
