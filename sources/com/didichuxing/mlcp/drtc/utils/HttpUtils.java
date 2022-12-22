package com.didichuxing.mlcp.drtc.utils;

import android.os.StrictMode;
import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpGet;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

class HttpUtils {
    HttpUtils() {
    }

    private static String readInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void Connection_Async(String str, HttpConnectCallback httpConnectCallback) {
        AsyncHttpClient.getDefaultInstance().execute(str, httpConnectCallback);
    }

    /* access modifiers changed from: protected */
    public void HttpGet_Async(String str, AsyncHttpClient.JSONObjectCallback jSONObjectCallback) {
        AsyncHttpGet asyncHttpGet = new AsyncHttpGet(str);
        asyncHttpGet.setTimeout(5000);
        AsyncHttpClient.getDefaultInstance().executeJSONObject(asyncHttpGet, jSONObjectCallback);
    }

    /* access modifiers changed from: protected */
    public String HttpGet_Sync(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.setReadTimeout(2000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            httpURLConnection.setRequestProperty("X-TOKEN", str2);
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            SystemUtils.log(6, "HttpMessenger", e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.utils.HttpUtils", 31);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void HttpPost_Async(String str, String str2, AsyncHttpClient.JSONObjectCallback jSONObjectCallback) {
        JSONObject jSONObject;
        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(str);
        asyncHttpPost.setTimeout(1000);
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e) {
            SystemUtils.log(3, "DRTCLOG", "JSON Ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.utils.HttpUtils", 7);
            jSONObject = null;
        }
        asyncHttpPost.setBody(new JSONObjectBody(jSONObject));
        AsyncHttpClient.getDefaultInstance().executeJSONObject(asyncHttpPost, jSONObjectCallback);
    }

    /* access modifiers changed from: protected */
    public boolean HttpPost_Sync(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            httpURLConnection.connect();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(str2);
            bufferedWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                return true;
            }
            SystemUtils.log(6, "HttpMessenger", "Response code: is " + responseCode, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.HttpUtils", 19);
            return false;
        } catch (Exception e) {
            SystemUtils.log(6, "HttpMessenger", e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.utils.HttpUtils", 23);
            return false;
        }
    }
}
