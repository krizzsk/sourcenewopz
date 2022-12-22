package com.didi.dimina.webview.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.didi.sdk.util.GlobalCountryCode;
import com.google.common.base.Ascii;
import java.io.File;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

/* renamed from: com.didi.dimina.webview.util.Util */
public class C7819Util {

    /* renamed from: a */
    private static final char[] f18433a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final String f18434b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: c */
    private static final String[] f18435c = {"Byte", "KB", "MB", GlobalCountryCode.ENGLAND, "TB"};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static volatile int f18436d = -1;
    public static int firstLaunchCachedUrlCount = 0;
    public static int firstLaunchRequestUrlCount = 0;
    public static boolean isUsePicDiskCache = false;

    /* renamed from: com.didi.dimina.webview.util.Util$WebViewAvailableCallBack */
    public interface WebViewAvailableCallBack {
        void call(boolean z);
    }

    @Deprecated
    public static boolean hasStoragePermissions(Context context) {
        return false;
    }

    public static String getVersionNameAndCode(Context context) {
        try {
            String appVersionName = WsgSafeUtil.getAppVersionName(context);
            int appVersionCode = WsgSafeUtil.getAppVersionCode(context);
            return appVersionName + "_" + appVersionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static File getDiskCacheDir(Context context, String str) {
        String str2;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || Environment.isExternalStorageRemovable()) {
                str2 = context.getCacheDir().getPath();
                return new File(str2 + File.separator + str);
            }
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                str2 = externalCacheDir.getPath();
            } else {
                str2 = context.getCacheDir().getPath();
            }
            return new File(str2 + File.separator + str);
        } catch (Exception unused) {
            str2 = context.getCacheDir().getPath();
        }
    }

    public static String join(String str, List<String> list) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return "";
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                sb.append(list.get(i));
                sb.append(str);
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static boolean isApkDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getSHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            byte[] bytes = str.getBytes();
            instance.update(bytes, 0, bytes.length);
            return m13682a(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m13682a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f18433a[(b & 240) >>> 4]);
            sb.append(f18433a[b & Ascii.f53593SI]);
        }
        return sb.toString();
    }

    public static String generateRandomString(int i) {
        SecureRandom secureRandom = new SecureRandom();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = f18434b.charAt(secureRandom.nextInt(36));
        }
        return new String(cArr);
    }

    public static String smartConvert(long j) {
        for (int i = 0; i < f18435c.length; i++) {
            if (j < 1024) {
                return j + f18435c[i];
            }
            j /= 1024;
        }
        return "";
    }

    public static boolean checkPermissionAllGranted(Context context, String[] strArr) {
        for (String a : strArr) {
            if (!m13683a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m13683a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static void isWebViewAvailableAsync(final Activity activity, final WebViewAvailableCallBack webViewAvailableCallBack) {
        boolean z = true;
        if (f18436d != -1) {
            if (f18436d != 1) {
                z = false;
            }
            webViewAvailableCallBack.call(z);
        } else if (Build.VERSION.SDK_INT < 21) {
            f18436d = 1;
            webViewAvailableCallBack.call(true);
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Class<?> cls = Class.forName("android.webkit.WebView");
                        Method declaredMethod = cls.getDeclaredMethod("getFactory", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(cls, new Object[0]);
                        int unused = C7819Util.f18436d = 1;
                    } catch (Exception unused2) {
                        int unused3 = C7819Util.f18436d = 0;
                    }
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                WebViewAvailableCallBack webViewAvailableCallBack = webViewAvailableCallBack;
                                boolean z = true;
                                if (C7819Util.f18436d != 1) {
                                    z = false;
                                }
                                webViewAvailableCallBack.call(z);
                            }
                        });
                    }
                }
            }).start();
        }
    }
}
