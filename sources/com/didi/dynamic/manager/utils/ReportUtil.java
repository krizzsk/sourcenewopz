package com.didi.dynamic.manager.utils;

import android.content.Context;
import android.os.Build;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.dynamic.manager.Module;
import java.util.HashMap;

public class ReportUtil {
    public static final int STATUS_DOWNLOADED = 1;
    public static final int STATUS_DOWNLOADED_AFTER_FAILED = 5;
    public static final int STATUS_DOWNLOAD_FAILED = 4;
    public static final int STATUS_LOAD_FAILED = 3;
    public static final int STATUS_LOAD_FAILED_AFTER_SUCCEEDED = 7;
    public static final int STATUS_LOAD_SUCCESS = 2;
    public static final int STATUS_LOAD_SUCCESS_AFTER_FAILED = 6;
    public static final int STATUS_NOT_DOWNLOAD = 0;

    /* renamed from: a */
    private static final String f19395a = "DM.ReportUtil";

    /* renamed from: b */
    private static final String f19396b = "module_code";

    /* renamed from: c */
    private static final String f19397c = "app_version";

    /* renamed from: d */
    private static final String f19398d = "app_key";

    /* renamed from: e */
    private static final String f19399e = "device_id";

    /* renamed from: f */
    private static final String f19400f = "device_type";

    /* renamed from: g */
    private static final boolean f19401g = true;

    /* renamed from: h */
    private static final String f19402h = "/api/dynamicmodule/report";

    public static void report(Context context, String str, Module module, int i, long j, String str2) {
        Module module2 = module;
        if (module2 != null && DownloadUtil.isMainProcess(context)) {
            final String str3 = module2.moduleCode;
            final String str4 = module2.version;
            final Context context2 = context;
            final String str5 = str;
            final int i2 = i;
            final long j2 = j;
            final String str6 = str2;
            ThreadUtil.execute(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("app_version", DownloadUtil.getVersionNameAndCode(context2));
                    hashMap.put("app_key", str5);
                    hashMap.put("device_id", IDUtil.getUUID(context2));
                    hashMap.put("module_code", str3);
                    hashMap.put("device_type", Build.MODEL + "_" + Build.VERSION.SDK_INT);
                    hashMap.put("number", str4);
                    hashMap.put("status", i2 + "");
                    hashMap.put("time_spent", j2 + "");
                    hashMap.put("error_msg", str6 + "");
                    try {
                        String appendQueryParams = HttpUtil.appendQueryParams(DownloadManager.getModuleUrl(ReportUtil.f19402h), hashMap);
                        String str = HttpUtil.get(appendQueryParams);
                        Log.m14484d(ReportUtil.f19395a, "report, url =" + appendQueryParams);
                        Log.m14484d(ReportUtil.f19395a, "report, response =" + str);
                    } catch (Throwable th) {
                        Log.m14494w(ReportUtil.f19395a, th);
                    }
                }
            });
        }
    }
}
