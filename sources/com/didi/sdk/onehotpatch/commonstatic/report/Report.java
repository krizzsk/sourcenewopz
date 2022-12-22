package com.didi.sdk.onehotpatch.commonstatic.report;

import android.content.Context;
import android.os.Build;
import com.didi.dynamic.manager.utils.HttpUtil;
import com.didi.dynamic.manager.utils.IDUtil;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Report {
    private static final String PATCH_SP = "patch_sp";
    public static final int STATUS_DOWNLOADED = 1;
    public static final int STATUS_DOWNLOADED_AFTER_FAILED = 5;
    public static final int STATUS_DOWNLOAD_FAILED = 4;
    public static final int STATUS_LOAD_FAILED = 3;
    public static final int STATUS_LOAD_FAILED_AFTER_SUCCEEDED = 7;
    public static final int STATUS_LOAD_SUCCESS = 2;
    public static final int STATUS_LOAD_SUCCESS_AFTER_FAILED = 6;
    public static final int STATUS_NOT_DOWNLOAD = 0;

    public static class ReportModule {
        public String errorMsg;
        public boolean isLoadSuccess;
        public long loadTime;
    }

    public static void report(final Context context, final PatchModule patchModule, final ReportModule reportModule) {
        if (UtilsHub.isMainProcess(context)) {
            new Thread(new Runnable() {
                public void run() {
                    Report.doReport(context, patchModule, reportModule);
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public static void doReport(Context context, PatchModule patchModule, ReportModule reportModule) {
        int i;
        try {
            SharedPreferencesWrapper of = SharedPreferencesWrapper.m14516of(context, PATCH_SP, 4);
            String spKey = getSpKey(reportModule.isLoadSuccess, patchModule);
            if (!of.getBoolean(spKey, false)) {
                if (reportModule.isLoadSuccess) {
                    i = 2;
                    if (of.getBoolean(getSpKey(false, patchModule), false)) {
                        i = 6;
                    }
                } else {
                    i = 3;
                    if (of.getBoolean(getSpKey(true, patchModule), false)) {
                        i = 7;
                    }
                }
                String appKey = PatchManager.getAppKey(context);
                StringBuilder sb = new StringBuilder();
                sb.append("?app_key=");
                sb.append(appKey);
                sb.append("&number=");
                sb.append(encode(patchModule != null ? patchModule.version : ""));
                sb.append("&device_type=");
                sb.append(encode(WsgSecInfo.model(context) + "_" + Build.VERSION.SDK_INT));
                sb.append("&module_code=");
                sb.append(patchModule != null ? patchModule.moduleCode : "hotpatch");
                sb.append("&status=");
                sb.append(encode("" + i));
                sb.append("&device_id=");
                sb.append(encode(IDUtil.getUUID(context)));
                sb.append("&app_version=");
                sb.append(encode(UtilsHub.getVersionNameAndCode(context)));
                if (reportModule.isLoadSuccess) {
                    sb.append("&time_spent=");
                    sb.append(reportModule.loadTime);
                } else {
                    sb.append("&error_msg=");
                    sb.append(reportModule.errorMsg);
                }
                String str = PatchManager.getHost(context) + "/api/dynamicmodule/report" + sb.toString();
                Logger.log("request:" + str, new Object[0]);
                Logger.log("get response:" + HttpUtil.get(str), new Object[0]);
                of.edit().putBoolean(spKey, true).apply();
            }
        } catch (Throwable th) {
            Logger.warn(th);
        }
    }

    private static String getSpKey(boolean z, PatchModule patchModule) {
        if (z) {
            return "succ_" + patchModule.moduleCode + patchModule.version;
        }
        return "fail_" + patchModule.moduleCode + patchModule.version;
    }

    private static String encode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.warn(e);
            return "";
        }
    }
}
