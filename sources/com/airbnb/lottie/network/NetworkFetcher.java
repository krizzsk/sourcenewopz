package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {

    /* renamed from: a */
    private final Context f1581a;

    /* renamed from: b */
    private final String f1582b;

    /* renamed from: c */
    private final NetworkCache f1583c;

    public static LottieResult<LottieComposition> fetchSync(Context context, String str, String str2) {
        return new NetworkFetcher(context, str, str2).fetchSync();
    }

    private NetworkFetcher(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f1581a = applicationContext;
        this.f1582b = str;
        if (str2 == null) {
            this.f1583c = null;
        } else {
            this.f1583c = new NetworkCache(applicationContext);
        }
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition a = m1376a();
        if (a != null) {
            return new LottieResult<>(a);
        }
        Logger.debug("Animation for " + this.f1582b + " not found in cache. Fetching from network.");
        return m1378b();
    }

    /* renamed from: a */
    private LottieComposition m1376a() {
        Pair<FileExtension, InputStream> a;
        LottieResult<LottieComposition> lottieResult;
        NetworkCache networkCache = this.f1583c;
        if (networkCache == null || (a = networkCache.mo15461a(this.f1582b)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a.first;
        InputStream inputStream = (InputStream) a.second;
        if (fileExtension == FileExtension.ZIP) {
            lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.f1582b);
        } else {
            lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.f1582b);
        }
        if (lottieResult.getValue() != null) {
            return lottieResult.getValue();
        }
        return null;
    }

    /* renamed from: b */
    private LottieResult<LottieComposition> m1378b() {
        try {
            return m1380c();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: c */
    private LottieResult<LottieComposition> m1380c() throws IOException {
        Logger.debug("Fetching " + this.f1582b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1582b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null) {
                if (httpURLConnection.getResponseCode() == 200) {
                    LottieResult<LottieComposition> b = m1379b(httpURLConnection);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(b.getValue() != null);
                    Logger.debug(sb.toString());
                    httpURLConnection.disconnect();
                    return b;
                }
            }
            String a = m1377a(httpURLConnection);
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f1582b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + a));
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: a */
    private String m1377a(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    /* renamed from: b */
    private LottieResult<LottieComposition> m1379b(HttpURLConnection httpURLConnection) throws IOException {
        LottieResult<LottieComposition> lottieResult;
        FileExtension fileExtension;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.f1583c;
            if (networkCache == null) {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(httpURLConnection.getInputStream()), (String) null);
            } else {
                lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(networkCache.mo15462a(this.f1582b, httpURLConnection.getInputStream(), fileExtension))), this.f1582b);
            }
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache2 = this.f1583c;
            if (networkCache2 == null) {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(httpURLConnection.getInputStream(), (String) null);
            } else {
                lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(networkCache2.mo15462a(this.f1582b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f1582b);
            }
        }
        if (!(this.f1583c == null || lottieResult.getValue() == null)) {
            this.f1583c.mo15463a(this.f1582b, fileExtension);
        }
        return lottieResult;
    }
}
