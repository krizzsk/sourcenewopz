package com.didichuxing.mas.sdk.quality.report.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class CommonUtil {
    private static Context mContext;
    private static SavedState mSavedState;

    public static void init(Context context) {
        mContext = context;
        SavedState savedState = new SavedState(context);
        mSavedState = savedState;
        String string = savedState.getString("omega_custom_host");
        if (!TextUtils.isEmpty(string)) {
            MASConfig.UPLOAD_HOST = string;
        }
    }

    public static int getAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String time2Human(Date date) {
        return new SimpleDateFormat("MM-dd HH:mm:ss").format(date);
    }

    public static String time2Human(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String time2Human(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String roundHalfUp(double d) {
        return new BigDecimal(d + "").setScale(2, 4).toPlainString();
    }

    public static String bytes4Human(long j) {
        double d = ((double) j) * 1.0d;
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return j + "B";
        }
        double d3 = d / 1048576.0d;
        if (d3 < 1.0d) {
            return roundHalfUp(d2) + "KB";
        }
        double d4 = d / 1.073741824E9d;
        if (d4 < 1.0d) {
            return roundHalfUp(d3) + "MB";
        }
        return roundHalfUp(d4) + GlobalCountryCode.ENGLAND;
    }

    public static byte[] stream2ByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                OLog.m34425w("stream2ByteArray fail", e);
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static String getTraceInfo(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static String simplifyClassName(String str) {
        String[] split = str.split("\\.");
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i].charAt(0));
            sb.append(".");
        }
        sb.append(split[split.length - 1]);
        return sb.toString();
    }

    public static void sendToast(String str, int i) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
                SystemUtils.showToast(Toast.makeText(mContext, str, i));
                Looper.loop();
                return;
            }
            SystemUtils.showToast(Toast.makeText(mContext, str, i));
        } catch (Throwable unused) {
        }
    }

    public static String randomBase64UUID() {
        UUID randomUUID = UUID.randomUUID();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(randomUUID.getMostSignificantBits());
        wrap.putLong(randomUUID.getLeastSignificantBits());
        return Base64.encodeToString(wrap.array(), 11).replace('_', '-');
    }

    public static int parseInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        try {
            return Integer.valueOf(String.valueOf(obj)).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long parseLong(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).longValue();
        }
        try {
            return Long.valueOf(String.valueOf(obj)).longValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getManifestString(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str)) {
                return "";
            }
            Object obj = applicationInfo.metaData.get(str);
            if (obj instanceof String) {
                return ((String) obj).trim();
            }
            if (obj != null) {
                return new BigDecimal(obj.toString()).toPlainString();
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isUpperLimitByDay(String str, int i) {
        long currentTimeMillis = (System.currentTimeMillis() + 28800000) / 86400000;
        if (currentTimeMillis != mSavedState.getLong(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(currentTimeMillis);
        return mSavedState.getInt(sb.toString()) >= i;
    }

    public static void addUpperLimitByDay(String str) {
        long currentTimeMillis = (System.currentTimeMillis() + 28800000) / 86400000;
        String str2 = str + currentTimeMillis;
        long j = mSavedState.getLong(str);
        if (currentTimeMillis != j) {
            mSavedState.remove(str + j);
            mSavedState.save(str, currentTimeMillis);
            mSavedState.save(str2, 1);
            return;
        }
        mSavedState.save(str2, mSavedState.getInt(str2) + 1);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String getMD5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            char[] cArr2 = new char[(r1 * 2)];
            int i = 0;
            for (byte b : instance.digest()) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & Ascii.f53593SI];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void operateErr(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (!isApkInDebug()) {
                if (!TextUtils.isEmpty(str) && str.length() >= 23) {
                    str = str.substring(0, 22);
                }
                SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.CommonUtil", 376);
                return;
            }
            throw new RuntimeException(str2);
        }
    }

    public static void operateErr(String str, Throwable th) {
        operateErr(str, th, false);
    }

    public static void operateErr(String str, Throwable th, boolean z) {
        if (th != null) {
            if (!isApkInDebug()) {
                if (!TextUtils.isEmpty(str) && str.length() >= 23) {
                    str = str.substring(0, 22);
                }
                if (!TextUtils.isEmpty(th.getMessage())) {
                    SystemUtils.log(6, str, th.getMessage(), (Throwable) null, "com.didichuxing.mas.sdk.quality.report.utils.CommonUtil", 412);
                    if (z) {
                        Tracker.trackGood(str, th);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static boolean isApkInDebug() {
        try {
            if (mContext == null || (mContext.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
