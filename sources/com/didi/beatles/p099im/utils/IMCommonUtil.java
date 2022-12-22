package com.didi.beatles.p099im.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.api.url.IMApiUrl;
import com.didi.beatles.p099im.event.IMInnerSchemeEvent;
import com.google.common.base.Ascii;
import com.taxis99.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.utils.IMCommonUtil */
public class IMCommonUtil {

    /* renamed from: a */
    private static final String f9749a = IMCommonUtil.class.getSimpleName();

    /* renamed from: b */
    private static final String f9750b = "diditravel";

    /* renamed from: c */
    private static final String f9751c = "didiim";

    public static boolean isTopActivy(Context context, String str) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ComponentName componentName = activityManager.getRunningTasks(1).size() > 0 ? activityManager.getRunningTasks(1).get(0).topActivity : null;
        if (componentName == null) {
            return false;
        }
        return componentName.getClassName().equals(str);
    }

    public static byte[] intToBytes(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (24 - (i2 * 8)));
        }
        return bArr;
    }

    public static byte[] float2byte(float f) {
        int floatToIntBits = Float.floatToIntBits(f);
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) (floatToIntBits >> (24 - (i * 8)));
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        for (int i2 = 0; i2 < 2; i2++) {
            byte b = bArr2[i2];
            int i3 = (4 - i2) - 1;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
        }
        return bArr2;
    }

    public static int byteArray2int(byte[] bArr) {
        return (bArr[0] << Ascii.CAN) + (bArr[1] << 16) + (bArr[2] << 8) + bArr[3];
    }

    public static String matchUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("[http]+[://]+[0-9A-Za-z:/[-]_#[?][=][.][&]]*", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static void startUriActivity(Context context, String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9749a, "[startUriActivity] Null action.");
            return;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null || !parse.getScheme().equals(f9751c)) {
            startUriActivity(context, str);
        } else {
            EventBus.getDefault().post(new IMInnerSchemeEvent(parse.getPath(), obj));
        }
    }

    public static void startUriActivity(Context context, String str) {
        if (context == null) {
            IMLog.m6632e(f9749a, "[startUriActivity] Null context.");
        } else if (TextUtils.isEmpty(str)) {
            IMLog.m6632e(f9749a, "[startUriActivity] Null action.");
        } else if (IMContextInfoHelper.handLink(context, str)) {
            IMLog.m6630d("business has hand link : " + str);
        } else {
            IMLog.m6630d("business not hand link : " + str);
            try {
                Uri parse = Uri.parse(getWebUrl(str));
                Intent intent = new Intent("android.intent.action.VIEW");
                if (IMContextInfoHelper.getContext() != null) {
                    intent.setPackage(IMContextInfoHelper.getContext().getPackageName());
                }
                intent.addFlags(268435456);
                intent.setData(parse);
                context.startActivity(intent);
            } catch (Exception e) {
                IMLog.m6632e("im_sdk", "startUriActivity failed whie action = " + str + " exception = " + e.toString());
                e.printStackTrace();
            }
        }
    }

    public static String getWebUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(f9750b)) {
            String schemeHost = IMEngine.getInstance((Context) null).getCurrentBusinessConfig(259).getSchemeHost();
            if (!TextUtils.isEmpty(schemeHost)) {
                return str.replace(f9750b, schemeHost);
            }
        }
        if (!str.startsWith("http")) {
            return str;
        }
        String webActivityScheme = IMContextInfoHelper.getWebActivityScheme();
        if (webActivityScheme != null) {
            return String.format(webActivityScheme, new Object[]{Uri.encode(str)});
        } else if (IMApiUrl.getCommonHost().contains("99taxis")) {
            return String.format(IMContextInfoHelper.getContext().getString(R.string.im_common_web_uri_brazil), new Object[]{Uri.encode(str)});
        } else if (IMApiUrl.getCommonHost().contains("global")) {
            return String.format(IMContextInfoHelper.getContext().getString(R.string.im_common_web_uri_global), new Object[]{Uri.encode(str)});
        } else {
            return String.format(IMContextInfoHelper.getContext().getString(R.string.im_common_web_uri), new Object[]{Uri.encode(str)});
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0032 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x002c
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            r7 = r8
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0031
            r8.close()
        L_0x0031:
            return r7
        L_0x0032:
            r9 = move-exception
        L_0x0033:
            if (r7 == 0) goto L_0x0038
            r7.close()
        L_0x0038:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.utils.IMCommonUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static int getDefaultPannelHeight(Context context) {
        if (context != null) {
            return (int) (((double) getElementSzie(context)) * 5.5d);
        }
        return 300;
    }

    public static int getAudioBkSize(int i, Context context) {
        int dp2px = IMViewUtil.dp2px(context, (float) getElementSzie(context));
        if (i <= 0) {
            return -1;
        }
        if (i <= 2) {
            return dp2px;
        }
        if (i <= 10) {
            float f = (float) dp2px;
            return (int) (f + (((float) (((double) (i - 2)) / 8.0d)) * f));
        } else if (i <= 60) {
            return (int) (((float) (dp2px * 2)) + (((float) (((double) (i - 10)) / 50.0d)) * ((float) dp2px)));
        } else {
            return -1;
        }
    }

    public static int getElementSzie(Context context) {
        if (context == null) {
            return 40;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp2px = IMViewUtil.dp2px(context, (float) displayMetrics.heightPixels);
        int dp2px2 = IMViewUtil.dp2px(context, (float) displayMetrics.widthPixels);
        int i = dp2px2 / 6;
        if (dp2px2 >= 800) {
            return 60;
        }
        if (dp2px2 >= 650) {
            return 55;
        }
        if (dp2px2 < 600) {
            if (dp2px <= 400) {
                return 20;
            }
            if (dp2px <= 480) {
                return 25;
            }
            if (dp2px <= 520) {
                return 30;
            }
            if (dp2px <= 570) {
                return 35;
            }
            if (dp2px > 640) {
                return i;
            }
            if (displayMetrics.heightPixels > 960) {
                if (displayMetrics.heightPixels <= 1000) {
                    return 45;
                }
                return i;
            }
        }
        return 50;
    }

    /* renamed from: a */
    private static int m6595a(float f, Context context) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private static float m6594a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static void hideInput(Activity activity) {
        View peekDecorView = activity.getWindow().peekDecorView();
        if (peekDecorView != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037 A[SYNTHETIC, Splitter:B:26:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0032=Splitter:B:23:0x0032, B:16:0x0027=Splitter:B:16:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getmem_TOLAL() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0025, all -> 0x0023 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0025, all -> 0x0023 }
            r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0025, all -> 0x0023 }
            r0 = 8
            r2.<init>(r3, r0)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x0025, all -> 0x0023 }
            java.lang.String r0 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0021, IOException -> 0x001f }
            if (r0 == 0) goto L_0x0016
            r1 = r0
        L_0x0016:
            r2.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x003a
        L_0x001a:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x003a
        L_0x001f:
            r0 = move-exception
            goto L_0x0027
        L_0x0021:
            r0 = move-exception
            goto L_0x0032
        L_0x0023:
            r0 = move-exception
            goto L_0x005a
        L_0x0025:
            r0 = move-exception
            r2 = r1
        L_0x0027:
            r0.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x003a
        L_0x0030:
            r0 = move-exception
            r2 = r1
        L_0x0032:
            r0.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x001a }
        L_0x003a:
            if (r1 == 0) goto L_0x0052
            r0 = 58
            int r0 = r1.indexOf(r0)
            r2 = 107(0x6b, float:1.5E-43)
            int r2 = r1.indexOf(r2)
            int r0 = r0 + 1
            java.lang.String r0 = r1.substring(r0, r2)
            java.lang.String r1 = r0.trim()
        L_0x0052:
            int r0 = java.lang.Integer.parseInt(r1)
            long r0 = (long) r0
            return r0
        L_0x0058:
            r0 = move-exception
            r1 = r2
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.utils.IMCommonUtil.getmem_TOLAL():long");
    }

    public static boolean isMobileNO(String str) {
        return Pattern.compile("((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}d{1}-?d{8}$)|(^0[3-9] {1}d{2}-?d{7,8}$)|(^0[1,2]{1}d{1}-?d{8}-(d{1,4})$)|(^0[3-9]{1}d{2}-? d{7,8}-(d{1,4})$))").matcher(str).matches();
    }
}
