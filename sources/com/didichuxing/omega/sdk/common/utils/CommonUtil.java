package com.didichuxing.omega.sdk.common.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class CommonUtil {
    private static Context mContext;
    private static SimpleDateFormat mDateFormat;
    private static IOmegaApolloService mOmegaApolloService;
    private static SavedState mSavedState;

    public static void init(Context context) {
        mContext = context;
        mSavedState = new SavedState(context);
        Security.initHaidAndGaid(mContext);
        String string = mSavedState.getString("omega_custom_host");
        if (!TextUtils.isEmpty(string)) {
            OmegaConfig.setUploadHost(string);
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getString(String str) {
        return mSavedState.getString(str, "");
    }

    public static void save(String str, String str2) {
        mSavedState.save(str, str2);
    }

    public static int getAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public static void setApolloService(IOmegaApolloService iOmegaApolloService) {
        mOmegaApolloService = iOmegaApolloService;
    }

    public static boolean allow(String str) {
        IOmegaApolloService iOmegaApolloService = mOmegaApolloService;
        if (iOmegaApolloService == null) {
            return false;
        }
        return iOmegaApolloService.allow(str);
    }

    public static <T> T getParams(String str, String str2, T t) {
        IOmegaApolloService iOmegaApolloService = mOmegaApolloService;
        if (iOmegaApolloService == null) {
            return t;
        }
        return iOmegaApolloService.getParams(str, str2, t);
    }

    public static String time2Human(Date date) {
        if (mDateFormat == null) {
            mDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return mDateFormat.format(date);
    }

    public static String bytes4Human(long j) {
        if (j / 1000000000 > 0) {
            return "" + (((float) (j / 100000000)) / 10.0f) + "G";
        } else if (j / 1000000 > 0) {
            return "" + (((float) (j / 100000)) / 10.0f) + "M";
        } else if (j / 1000 > 0) {
            return "" + (((float) (j / 100)) / 10.0f) + "K";
        } else {
            return "" + j + "B";
        }
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
                OLog.m34770w("stream2ByteArray fail", e);
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
                SystemUtils.showToast(Toast.makeText(mContext.getApplicationContext(), str, i));
                Looper.loop();
                return;
            }
            SystemUtils.showToast(Toast.makeText(mContext.getApplicationContext(), str, i));
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

    public static String copyJoinStr(String str, int i) {
        StringBuilder sb = new StringBuilder(str.length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String getManifestIssue(Context context) {
        return Security.getManifestIssue(context);
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
}
