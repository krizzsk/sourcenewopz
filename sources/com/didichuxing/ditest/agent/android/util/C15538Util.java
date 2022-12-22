package com.didichuxing.ditest.agent.android.util;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didichuxing.ditest.agent.android.util.Util */
public class C15538Util {
    private static final Random random = new Random();
    private static final Pattern urlPathPattern = Pattern.compile("http(s)*://([a-z]|[A-Z]|[0-9]|\\.|/|_|-)+(?=[\\?|#]*)");

    public static String slurp(InputStream inputStream) throws IOException {
        char[] cArr = new char[8192];
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read < 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public static String sanitizeUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append(HWMapConstant.HTTP.SEPARATOR);
            stringBuffer.append(url.getHost());
            if (url.getPort() != -1) {
                stringBuffer.append(":");
                stringBuffer.append(url.getPort());
            }
            stringBuffer.append(url.getPath());
            return stringBuffer.toString();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static Random getRandom() {
        return random;
    }

    public static String getHost(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        Matcher matcher = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public static String getUrlPath(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = urlPathPattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
