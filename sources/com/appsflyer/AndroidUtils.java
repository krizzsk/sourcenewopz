package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class AndroidUtils {
    /* renamed from: ɩ */
    public static boolean m1526(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public static boolean isPermissionAvailable(Context context, String str) {
        if (str != null) {
            int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
            StringBuilder sb = new StringBuilder("is Permission Available: ");
            sb.append(str);
            sb.append("; res: ");
            sb.append(checkPermission);
            AFLogger.afRDLog(sb.toString());
            return checkPermission == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: ɩ */
    static boolean m1525() {
        return Build.BRAND.equals("OPPO");
    }

    /* renamed from: ι */
    static Map<String, String> m1527(Context context, Map<String, String> map, Uri uri) {
        boolean z;
        int i;
        if (uri.getQuery() != null) {
            z = false;
            for (String str : uri.getQuery().split(ParamKeys.SIGN_AND)) {
                int indexOf = str.indexOf("=");
                String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
                if (!map.containsKey(substring)) {
                    if (substring.equals("c")) {
                        substring = "campaign";
                    } else if (substring.equals("pid")) {
                        substring = Const.CampaignKey.KEY_MEDIA_SOURCE;
                    } else if (substring.equals("af_prt")) {
                        z = true;
                        substring = "agency";
                    }
                    map.put(substring, "");
                }
                map.put(substring, (indexOf <= 0 || str.length() <= (i = indexOf + 1)) ? null : str.substring(i));
            }
        } else {
            z = false;
        }
        try {
            if (!map.containsKey("install_time")) {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                long j = packageInfo.firstInstallTime;
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                map.put("install_time", simpleDateFormat.format(new Date(j)));
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("Could not fetch install time. ", e);
        }
        if (uri.getQueryParameter("af_deeplink") != null && !map.containsKey("af_status")) {
            map.put("af_status", "Non-organic");
        }
        if (z) {
            map.remove(Const.CampaignKey.KEY_MEDIA_SOURCE);
        }
        String path = uri.getPath();
        if (path != null) {
            map.put("path", path);
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            map.put("scheme", scheme);
        }
        String host = uri.getHost();
        if (host != null) {
            map.put("host", host);
        }
        return map;
    }

    public static String signature(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = SystemUtils.getPackageInfo(packageManager, str, 64).signatures;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        instance.update(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded());
        return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
    }
}
