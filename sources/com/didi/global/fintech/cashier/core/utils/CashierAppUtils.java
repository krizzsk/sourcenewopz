package com.didi.global.fintech.cashier.core.utils;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Process;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/CashierAppUtils;", "", "()V", "sHashMapMetaDataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "doClip", "", "context", "Landroid/content/Context;", "pixCode", "getAppName", "getMetaDataByKey", "key", "getPackageName", "isSchemeSupport", "", "uri", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierAppUtils.kt */
public final class CashierAppUtils {
    public static final CashierAppUtils INSTANCE = new CashierAppUtils();

    /* renamed from: a */
    private static final HashMap<String, String> f21489a = new HashMap<>();

    private CashierAppUtils() {
    }

    public final String getMetaDataByKey(Context context, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = "unknown";
        if (!TextUtil.isEmpty(f21489a.get(str))) {
            String str3 = f21489a.get(str);
            return str3 == null ? str2 : str3;
        }
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16512);
            if (!(packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (obj = packageInfo.applicationInfo.metaData.get(str)) == null)) {
                str2 = obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f21489a.put(str, str2);
        return str2;
    }

    public final String getPackageName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return "";
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final boolean isSchemeSupport(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(URLDecoder.decode(str)));
            intent.setAction("android.intent.action.VIEW");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, 0)");
            if (queryIntentActivities.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void doClip(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pixCode");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", str));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String string = context.getResources().getString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(labelRes)");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
