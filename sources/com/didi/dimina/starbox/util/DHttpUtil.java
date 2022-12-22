package com.didi.dimina.starbox.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class DHttpUtil {

    /* renamed from: a */
    private static final int f18153a = 8192;

    public static String get(String str) {
        try {
            return get(str, (Map<String, String>) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String get(String str, Map<String, String> map) {
        try {
            return fetch("GET", str, (String) null, map);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String fetch(String str, String str2, String str3, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            if (str != null) {
                httpURLConnection.setRequestMethod(str);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    httpURLConnection.addRequestProperty(next, map.get(next));
                }
            }
            if (str3 != null) {
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str3.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String streamToString = streamToString(inputStream);
            inputStream.close();
            return httpURLConnection.getResponseCode() == 301 ? fetch(str, httpURLConnection.getHeaderField("Location"), str3, map) : streamToString;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void download(String str, File file) throws Exception {
        InputStream inputStream = new URL(str).openConnection().getInputStream();
        byte[] bArr = new byte[4096];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    public static String streamToString(InputStream inputStream) {
        char[] cArr = new char[2048];
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            while (true) {
                int read = inputStreamReader.read(cArr, 0, 2048);
                if (read < 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (IOException | UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }
}
