package com.didi.raven.utils;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class StringUtils {
    public static String inputStreamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream2;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return "";
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static String mapToStrings(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(value);
            sb.append(ParamKeys.SIGN_AND);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
