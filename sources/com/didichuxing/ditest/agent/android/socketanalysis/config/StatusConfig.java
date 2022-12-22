package com.didichuxing.ditest.agent.android.socketanalysis.config;

import android.content.Context;
import com.didichuxing.ditest.agent.android.SavedState;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;

public class StatusConfig {
    private static final String fileCreatedTimeKey = "fileCreatedTimeKey";
    private static SavedState mSavedState;

    public static void setSaveState(Context context) {
        mSavedState = new SavedState(context);
    }

    public static boolean isUpperLimitByDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_socket_key", SocketConfig.MAX_UPLOAD_LIMIT_PER_DAY);
    }

    public static void addNetEventNum() {
        CommonUtil.addUpperLimitByDay("upper_limit_socket_key");
    }

    public static void savefileCreatedTime() {
        mSavedState.save(fileCreatedTimeKey, System.currentTimeMillis());
    }

    public static long getfileCreatedTime() {
        return mSavedState.getLong(fileCreatedTimeKey);
    }

    public static boolean hasFileExpiration() {
        long j = getfileCreatedTime();
        if (j == 0 || System.currentTimeMillis() - j <= SocketConfig.FILE_EXPIRATION_TIME) {
            return false;
        }
        OLog.m34761d("file has expirated, delete it!");
        return true;
    }
}
