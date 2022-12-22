package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class StatusConfig {

    /* renamed from: a */
    private static final String f48047a = "fileCreatedTimeKey";

    /* renamed from: b */
    private static SavedState f48048b;

    public static void setSaveState(Context context) {
        f48048b = new SavedState(context);
    }

    public static boolean isUpperLimitByDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_socket_key", SocketConfig.MAX_UPLOAD_LIMIT_PER_DAY);
    }

    public static void addNetEventNum() {
        CommonUtil.addUpperLimitByDay("upper_limit_socket_key");
    }

    public static void savefileCreatedTime() {
        f48048b.save(f48047a, System.currentTimeMillis());
    }

    public static long getfileCreatedTime() {
        return f48048b.getLong(f48047a);
    }

    public static boolean hasFileExpiration() {
        long j = getfileCreatedTime();
        if (j == 0 || System.currentTimeMillis() - j <= SocketConfig.FILE_EXPIRATION_TIME) {
            return false;
        }
        OLog.m34416d("file has expirated, delete it!");
        return true;
    }
}
