package com.didi.sdk.logging.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class StringUtils {
    public static String dumpBundleArray(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        for (int i = 0; i < bundleArr.length; i++) {
            sb.append(dumpBundle(bundleArr[i]));
            if (i < bundleArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public static String dumpBundle(Bundle bundle) {
        String str;
        if (bundle == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(Const.joLeft);
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            sb.append(str2);
            sb.append("=");
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                if (obj == bundle) {
                    str = "{this}";
                } else {
                    str = dumpBundle((Bundle) obj);
                }
            } else if (obj instanceof Bundle[]) {
                str = dumpBundleArray((Bundle[]) obj);
            } else if (obj instanceof Object[]) {
                str = Arrays.toString((Object[]) obj);
            } else {
                str = String.valueOf(obj);
            }
            sb.append(str);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String MD5(String str) {
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
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String ellipsize(String str, int i, int i2) {
        if (TextUtils.isEmpty(str) || str.length() <= i) {
            return str;
        }
        if (i >= 1) {
            return str.substring(0, (i - 1) - i2) + "..." + str.substring(str.length() - i2);
        }
        throw new IllegalArgumentException("maxCharacters must be at least 1 because the ellipsis already take up 1 characters");
    }
}
