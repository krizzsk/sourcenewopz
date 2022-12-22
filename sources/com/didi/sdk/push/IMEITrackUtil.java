package com.didi.sdk.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.common.base.Ascii;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017J\n\u0010#\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010$\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\rH\u0002J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006+"}, mo175978d2 = {"Lcom/didi/sdk/push/IMEITrackUtil;", "", "()V", "hasTrack", "", "getHasTrack", "()Z", "setHasTrack", "(Z)V", "log", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mDeviceId", "", "getMDeviceId", "()Ljava/lang/String;", "setMDeviceId", "(Ljava/lang/String;)V", "strImei", "getStrImei", "setStrImei", "checkPermission", "context", "Landroid/content/Context;", "permission", "defalutValue", "clearCacheIMEI", "", "fixDuplicateIMEI", "getCacheIMEI", "getHexchar", "", "value", "", "getIMEI", "getLastModifiedMD5Str", "getVirutalIMEI", "isSameChar", "str", "md5", "", "s", "trackIMEI", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMEITrackUtil.kt */
public final class IMEITrackUtil {
    public static final IMEITrackUtil INSTANCE = new IMEITrackUtil();
    private static boolean hasTrack;
    private static final Logger log = LoggerFactory.getLogger("IMEITrackUtil");
    private static String mDeviceId;
    private static String strImei = "";

    private final char getHexchar(int i) {
        return (char) (i < 10 ? i + 48 : (i + 65) - 10);
    }

    private IMEITrackUtil() {
    }

    public final String getStrImei() {
        return strImei;
    }

    public final void setStrImei(String str) {
        strImei = str;
    }

    public final String getMDeviceId() {
        return mDeviceId;
    }

    public final void setMDeviceId(String str) {
        mDeviceId = str;
    }

    public final boolean getHasTrack() {
        return hasTrack;
    }

    public final void setHasTrack(boolean z) {
        hasTrack = z;
    }

    public final void trackIMEI(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!hasTrack) {
            Map hashMap = new HashMap();
            String str = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(str, "BRAND");
            hashMap.put("brand", str);
            String str2 = Build.CPU_ABI;
            Intrinsics.checkNotNullExpressionValue(str2, "CPU_ABI");
            hashMap.put("cpu_abi", str2);
            String str3 = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(str3, "DEVICE");
            hashMap.put("device", str3);
            String str4 = Build.DISPLAY;
            Intrinsics.checkNotNullExpressionValue(str4, "DISPLAY");
            hashMap.put("display", str4);
            String str5 = Build.HOST;
            Intrinsics.checkNotNullExpressionValue(str5, "HOST");
            hashMap.put("host", str5);
            String str6 = Build.ID;
            Intrinsics.checkNotNullExpressionValue(str6, "ID");
            hashMap.put("id", str6);
            String str7 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(str7, "MANUFACTURER");
            hashMap.put("manufacturer", str7);
            String str8 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(str8, "MODEL");
            hashMap.put("model", str8);
            String str9 = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(str9, "PRODUCT");
            hashMap.put("product", str9);
            String str10 = Build.TAGS;
            Intrinsics.checkNotNullExpressionValue(str10, "TAGS");
            hashMap.put("tags", str10);
            String str11 = Build.TYPE;
            Intrinsics.checkNotNullExpressionValue(str11, "TYPE");
            hashMap.put("type", str11);
            String str12 = Build.USER;
            Intrinsics.checkNotNullExpressionValue(str12, "USER");
            hashMap.put("user", str12);
            String lastModifiedMD5Str = getLastModifiedMD5Str();
            String str13 = "";
            if (lastModifiedMD5Str == null) {
                lastModifiedMD5Str = str13;
            }
            hashMap.put("last_modify_md5_str", lastModifiedMD5Str);
            String imei = getIMEI(context);
            if (imei == null) {
                imei = str13;
            }
            hashMap.put("imei", imei);
            String cacheIMEI = getCacheIMEI(context);
            if (cacheIMEI != null) {
                str13 = cacheIMEI;
            }
            hashMap.put("cache_imei", str13);
            if (checkPermission(context, Permission.READ_PHONE_STATE)) {
                hashMap.put("has_phone_state", 1);
            } else {
                hashMap.put("has_phone_state", 0);
            }
            OmegaSDKAdapter.trackEvent("tech_imei_show", (Map<String, Object>) hashMap);
            hasTrack = true;
        }
    }

    private final String getCacheIMEI(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, Intrinsics.stringPlus(context.getPackageName(), "_preferences"), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…Name + \"_preferences\", 0)");
        return sharedPreferences.getString("imei_", (String) null);
    }

    private final boolean checkPermission(Context context, String str) {
        return checkPermission(context, str, false);
    }

    private final boolean checkPermission(Context context, String str, boolean z) {
        try {
            Intrinsics.checkNotNull(str);
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception unused) {
            return z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) strImei, (java.lang.Object) "null") == false) goto L_0x0110;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getIMEI(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = strImei
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x0010
            java.lang.String r7 = strImei
            return r7
        L_0x0010:
            java.lang.String r0 = mDeviceId
            strImei = r0
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r0 = r6.checkPermission(r7, r0)
            if (r0 != 0) goto L_0x0021
            java.lang.String r7 = r6.getVirutalIMEI()
            return r7
        L_0x0021:
            java.lang.String r0 = "phone"
            java.lang.Object r7 = r7.getSystemService(r0)
            if (r7 == 0) goto L_0x011d
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7
            java.lang.String r0 = mDeviceId     // Catch:{ all -> 0x003d }
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r0)     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x004b
            java.lang.String r7 = r7.getDeviceId()     // Catch:{ all -> 0x003d }
            mDeviceId = r7     // Catch:{ all -> 0x003d }
            strImei = r7     // Catch:{ all -> 0x003d }
            goto L_0x004b
        L_0x003d:
            r7 = move-exception
            r3 = r7
            r0 = 6
            r5 = 108(0x6c, float:1.51E-43)
            java.lang.String r1 = "SystemUtil"
            java.lang.String r2 = ""
            java.lang.String r4 = "com.didi.sdk.push.IMEITrackUtil"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x004b:
            java.lang.String r7 = strImei
            boolean r7 = r6.isSameChar(r7)
            if (r7 == 0) goto L_0x0056
            r7 = 0
            strImei = r7
        L_0x0056:
            java.lang.String r7 = strImei
            if (r7 == 0) goto L_0x0071
            r0 = 0
            if (r7 != 0) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0065
            r0 = 1
        L_0x0065:
            if (r0 != 0) goto L_0x0071
            java.lang.String r7 = strImei
            java.lang.String r0 = "null"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x0110
        L_0x0071:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "35"
            r7.append(r0)
            java.lang.String r0 = android.os.Build.BOARD
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.BRAND
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.CPU_ABI
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.DEVICE
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.DISPLAY
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.HOST
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.ID
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.MODEL
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.PRODUCT
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.TAGS
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.TYPE
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r0 = android.os.Build.USER
            int r0 = r0.length()
            int r0 = r0 % 10
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            strImei = r7
        L_0x0110:
            java.lang.String r7 = strImei
            java.lang.String r0 = r6.getLastModifiedMD5Str()
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r0)
            strImei = r7
            return r7
        L_0x011d:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.IMEITrackUtil.getIMEI(android.content.Context):java.lang.String");
    }

    private final boolean isSameChar(String str) {
        if (str == null || Intrinsics.areEqual((Object) "", (Object) str)) {
            return false;
        }
        int length = str.length() - 1;
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (str.charAt(i) != str.charAt(i2)) {
                    return false;
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }

    private final String getVirutalIMEI() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    private final String getLastModifiedMD5Str() {
        char[] md5 = md5(String.valueOf(new File("/system/build.prop").lastModified()));
        if (md5 == null) {
            return null;
        }
        return new String(md5);
    }

    private final char[] md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length << 1;
            char[] cArr = new char[length];
            byte b = 0;
            for (int i = 0; i < length; i += 2) {
                byte b2 = (byte) (digest[b] & -1);
                b = (byte) (b + 1);
                if (b2 < 16) {
                    cArr[i] = '0';
                    cArr[i + 1] = getHexchar(b2);
                } else {
                    cArr[i] = getHexchar(b2 >> 4);
                    cArr[i + 1] = getHexchar(b2 & Ascii.f53593SI);
                }
            }
            return cArr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void fixDuplicateIMEI(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!IMEIApolloUtil.INSTANCE.needClear()) {
            log.info("未命中清除缓存阿波罗", new Object[0]);
            return;
        }
        log.info("fixDuplicateIMEI", new Object[0]);
        String cacheIMEI = getCacheIMEI(context);
        if (cacheIMEI == null) {
            cacheIMEI = "";
        }
        String imei = getIMEI(context);
        log.info(Intrinsics.stringPlus("cacheIMEI:", cacheIMEI), new Object[0]);
        log.info(Intrinsics.stringPlus("iMei:", imei), new Object[0]);
        boolean z = true;
        if (imei == null || !StringsKt.startsWith$default(imei, cacheIMEI, false, 2, (Object) null)) {
            z = false;
        }
        if (z) {
            log.info("清除缓存", new Object[0]);
            clearCacheIMEI(context);
        }
    }

    private final void clearCacheIMEI(Context context) {
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, Intrinsics.stringPlus(context.getPackageName(), "_preferences"), 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…Name + \"_preferences\", 0)");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                SharedPreferences.Editor putString = edit.putString("imei_", "");
                if (putString != null) {
                    putString.apply();
                }
            }
            log.info("清除成功", new Object[0]);
        } catch (Exception unused) {
        }
    }
}
