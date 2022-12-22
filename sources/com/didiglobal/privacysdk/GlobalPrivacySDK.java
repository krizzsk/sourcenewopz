package com.didiglobal.privacysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;

public class GlobalPrivacySDK {

    /* renamed from: a */
    private static GlobalPrivacyThemeOptions f50577a = new GlobalPrivacyThemeOptions();

    /* renamed from: b */
    private static GlobalPrivacyListeners.WebViewListener f50578b;

    /* renamed from: c */
    private static GlobalPrivacyListeners.GetCommonInfoListener f50579c;

    /* renamed from: d */
    private static GlobalPrivacyListeners.ItemDisplayListener f50580d;

    /* renamed from: e */
    private static GlobalPrivacyListeners.IAppInfo f50581e;

    /* renamed from: f */
    private static GlobalPrivacyListeners.OnItemClickedListener f50582f;

    /* renamed from: g */
    private static GlobalPrivacyListeners.BaseActivityDelegate f50583g;

    /* renamed from: h */
    private static boolean f50584h;

    /* renamed from: i */
    private static int f50585i;

    /* renamed from: j */
    private static boolean f50586j = true;

    /* renamed from: k */
    private static boolean f50587k = false;

    /* renamed from: l */
    private static String f50588l = "";

    public static void init(GlobalPrivacyInitParam globalPrivacyInitParam) {
        f50578b = globalPrivacyInitParam.webViewListener;
        f50579c = globalPrivacyInitParam.getCommonInfoListener;
        f50581e = globalPrivacyInitParam.appInfo;
        f50582f = globalPrivacyInitParam.onItemClickedListener;
        f50583g = globalPrivacyInitParam.baseActivityDelegate;
        GlobalPrivacyListeners.IAppInfo iAppInfo = f50581e;
        if (iAppInfo != null) {
            f50580d = iAppInfo.getItemDisplayListener();
        }
        if (f50580d == null) {
            f50580d = new GlobalPrivacyListeners.ItemDisplayListener() {
                public boolean displayDeleteAccount() {
                    return false;
                }

                public boolean displayDiscountEmail() {
                    return false;
                }

                public boolean displayDiscountPush() {
                    return false;
                }

                public boolean displayDownloadData() {
                    return false;
                }

                public boolean displayLocationShare() {
                    return false;
                }

                public boolean displaySms() {
                    return false;
                }

                public boolean displaySystemPermission() {
                    return false;
                }
            };
        }
        f50584h = globalPrivacyInitParam.configThemeResInt;
        f50585i = globalPrivacyInitParam.themeResInt;
        f50586j = globalPrivacyInitParam.itemTitleBold;
        f50587k = globalPrivacyInitParam.finishActivityWhenAppRestarted;
        f50588l = globalPrivacyInitParam.downloadDataUrl;
    }

    public static void go2PrivacyActivity(Context context) {
        m36342a(context, PrivacyActivity.class);
    }

    public static GlobalPrivacyThemeOptions getGlobalPrivacyThemeOptions() {
        return f50577a;
    }

    public static void setGlobalPrivacyThemeOptions(GlobalPrivacyThemeOptions globalPrivacyThemeOptions) {
        f50577a = globalPrivacyThemeOptions;
    }

    public static GlobalPrivacyListeners.WebViewListener getWebViewListener() {
        return f50578b;
    }

    public static GlobalPrivacyListeners.GetCommonInfoListener getCommonInfoListener() {
        return f50579c;
    }

    public static String getAccountType() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAccountType() : "";
    }

    public static String getUserId() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getUserId() : "";
    }

    public static String getToken() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getToken() : "";
    }

    public static String getAppId(Context context) {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAppId(context) : "";
    }

    public static String getAppType(Context context) {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAppType(context) : "";
    }

    public static GlobalPrivacyListeners.ItemDisplayListener getItemDisplayListener() {
        return f50580d;
    }

    public static GlobalPrivacyListeners.IAppInfo getAppInfo() {
        return f50581e;
    }

    public static GlobalPrivacyListeners.OnItemClickedListener getOnItemClickedListener() {
        return f50582f;
    }

    public static void setOnItemClickedListener(GlobalPrivacyListeners.OnItemClickedListener onItemClickedListener) {
        f50582f = onItemClickedListener;
    }

    public static GlobalPrivacyListeners.BaseActivityDelegate getBaseActivityDelegate() {
        return f50583g;
    }

    public static boolean hasConfigThemeResInt() {
        return f50584h;
    }

    public static int getThemeResInt() {
        return f50585i;
    }

    public static boolean isItemTitleBold() {
        return f50586j;
    }

    public static boolean isFinishActivityWhenAppRestarted() {
        return f50587k;
    }

    public static String getDownloadDataUrl() {
        return f50588l;
    }

    /* renamed from: a */
    private static void m36342a(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
