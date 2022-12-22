package com.didichuxing.omega.sdk.common.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class ApiSigner {
    private static final String TAG = "ApiSigner";

    public static String sign(Map<String, Object> map) {
        int i;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        synchronized (map) {
            Iterator<String> it = map.keySet().iterator();
            boolean z = true;
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    try {
                        String encode = URLEncoder.encode(map.get(next).toString(), "UTF-8");
                        if (z) {
                            sb.append(next);
                            sb.append("=");
                            sb.append(encode);
                            z = false;
                        } else {
                            sb.append(ParamKeys.SIGN_AND);
                            sb.append(next);
                            sb.append("=");
                            sb.append(encode);
                        }
                        arrayList.add(next);
                    } catch (UnsupportedEncodingException e) {
                        SystemUtils.log(6, TAG, "encode url err:" + e.toString() + " value:" + map.get(next).toString(), (Throwable) null, "com.didichuxing.omega.sdk.common.utils.ApiSigner", 37);
                    }
                }
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        for (i = 0; i < arrayList.size(); i++) {
            sb2.append((String) arrayList.get(i));
            sb2.append("=");
            sb2.append(map.get(arrayList.get(i)));
        }
        sb.append("&sign=");
        sb2.append("psk");
        sb.append(md5Encode(sb2.toString()));
        return sb.toString();
    }

    public static String md5Encode(String str) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
