package com.didi.sdk.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class AnalysisAPK {
    public static final String CHANNEL_HUAWEI_PRE_INSTALL = "huaweiPreInstall";
    public static final String MS_FLAVOR_GMS = "gms";
    public static final String MS_FLAVOR_HMS = "hms";
    public static final String REGION_FLAVOR_BRAZIL = "brazil";
    public static final String REGION_FLAVOR_GLOBAL = "global";

    /* renamed from: a */
    private static final String f37548a = AnalysisAPK.class.getSimpleName();

    /* renamed from: b */
    private static BuildType f37549b;

    /* renamed from: c */
    private static String f37550c = "";

    /* renamed from: d */
    private static String f37551d = "";

    /* renamed from: e */
    private static String f37552e = "";

    public enum BuildType {
        debug,
        release,
        grey
    }

    public static void analysisBuildType(Context context) {
        try {
            f37549b = BuildType.valueOf(SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString("build_type"));
            SystemUtils.log(3, "didi", "buildType = " + f37549b, (Throwable) null, "com.didi.sdk.util.AnalysisAPK", 59);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BuildType getBuildType() {
        return f37549b;
    }

    public static String getApkSignature(String str) {
        Object obj;
        Object obj2;
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            Class[] clsArr = {String.class};
            Object[] objArr = {str};
            if (Build.VERSION.SDK_INT > 19) {
                obj = cls.newInstance();
            } else {
                obj = cls.getConstructor(clsArr).newInstance(objArr);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            if (Build.VERSION.SDK_INT > 19) {
                Object[] objArr2 = {new File(str), 64};
                Method declaredMethod = cls.getDeclaredMethod("parsePackage", clsArr);
                declaredMethod.setAccessible(true);
                Class<File> cls2 = File.class;
                Class cls3 = Integer.TYPE;
                obj2 = declaredMethod.invoke(obj, objArr2);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                obj2 = declaredMethod2.invoke(obj, new Object[]{new File(str), str, displayMetrics, 64});
            }
            cls.getDeclaredMethod("collectCertificates", new Class[]{obj2.getClass(), Integer.TYPE}).invoke(obj, new Object[]{obj2, 64});
            return ((Signature[]) obj2.getClass().getDeclaredField("mSignatures").get(obj2))[0].toCharsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    public static String getPackageName(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.applicationInfo.packageName;
        }
        return null;
    }

    public static String getRegionFlavor(Context context) {
        if (!TextUtils.isEmpty(f37550c)) {
            return f37550c;
        }
        try {
            f37550c = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString("flavor_region");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = f37548a;
        LogUtil.m26099i(str, "getRegionFlavor : sRegionFlavor = " + f37550c);
        return f37550c;
    }

    public static String getMobileServiceFlavor(Context context) {
        if (!TextUtils.isEmpty(f37551d)) {
            return f37551d;
        }
        try {
            f37551d = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString("flavor_mobile_service");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = f37548a;
        LogUtil.m26099i(str, "getMobileServiceFlavor : sMobileServiceFlavor = " + f37551d);
        return f37551d;
    }

    public static String getChannelFlavor(Context context) {
        if (!TextUtils.isEmpty(f37552e)) {
            return f37552e;
        }
        try {
            f37552e = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.getString("flavor_channel");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = f37548a;
        LogUtil.m26099i(str, "getChannelFlavor : sChannelFlavor = " + f37552e);
        return f37551d;
    }

    public static boolean isGlobalHmsApk(Context context) {
        return "global".equals(getRegionFlavor(context)) && "hms".equals(getMobileServiceFlavor(context));
    }

    public static boolean isGlobalHmsPreInstallApk(Context context) {
        return "global".equals(getRegionFlavor(context)) && "hms".equals(getMobileServiceFlavor(context)) && CHANNEL_HUAWEI_PRE_INSTALL.equals(getChannelFlavor(context));
    }
}
