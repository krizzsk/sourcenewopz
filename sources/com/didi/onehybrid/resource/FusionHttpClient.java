package com.didi.onehybrid.resource;

import android.os.Looper;
import android.text.TextUtils;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.util.FileUtil;
import com.didi.onehybrid.util.HttpUtil;
import com.didi.onehybrid.util.OmegaUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.web.config.WebConstant;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class FusionHttpClient {
    public static final int CONNECT_CODE_ERROR_IOE = -102;
    public static final int CONNECT_CODE_ERROR_MUE = -101;
    public static final int CONNECT_CODE_ERROR_STE = -103;
    public static final int CONNECT_CODE_ERROR_UNKNOW = -100;
    public static final int CONNECT_CODE_SUCCESS = 0;

    /* renamed from: a */
    private static final int f29683a = 4096;

    /* renamed from: b */
    private static final int f29684b = 5000;

    /* renamed from: c */
    private static final int f29685c = 10000;

    /* renamed from: d */
    private final String f29686d;

    /* renamed from: e */
    private Map<String, String> f29687e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HttpURLConnection f29688f;

    /* renamed from: g */
    private BufferedInputStream f29689g;

    /* renamed from: h */
    private long f29690h;

    /* renamed from: i */
    private long f29691i;

    public FusionHttpClient(String str) {
        this.f29686d = str;
        this.f29687e = new HashMap(1);
    }

    public FusionHttpClient(String str, Map<String, String> map) {
        this.f29686d = str;
        this.f29687e = map;
        if (map == null) {
            this.f29687e = new HashMap(1);
        }
    }

    public long getFlow() {
        return this.f29690h;
    }

    public String getRequestUrl() {
        return this.f29686d;
    }

    public Map<String, String> getRequestHeader() {
        return this.f29687e;
    }

    public String executeGetRequest() {
        String str = "";
        if (m20848a(false, false) == 0) {
            BufferedInputStream bufferedInputStream = null;
            try {
                if (getResponseCode() == 200 && (bufferedInputStream = getResponseStream()) != null) {
                    str = HttpUtil.streamToString(bufferedInputStream);
                }
            } finally {
                FileUtil.closeQuietly(bufferedInputStream);
                disconnect();
            }
        }
        return str;
    }

    public boolean executeDownload(File file) {
        boolean z = false;
        if (file == null) {
            return false;
        }
        this.f29691i = System.currentTimeMillis();
        try {
            if (m20848a(false, true) == 0 && getResponseCode() == 200) {
                BufferedInputStream responseStream = getResponseStream();
                OmegaUtils.offline_http_length(this.f29686d, this.f29688f.getContentLength());
                if (responseStream != null) {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    z = writeInputStreamToOutputStream(responseStream, new FileOutputStream(file));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            OmegaUtils.offline_error("executeDownload: " + e.getMessage());
        } catch (Throwable th) {
            disconnect();
            throw th;
        }
        disconnect();
        return z;
    }

    public boolean writeInputStreamToOutputStream(BufferedInputStream bufferedInputStream, OutputStream outputStream) {
        boolean z = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream2.write(bArr, 0, read);
                    this.f29690h += (long) read;
                }
                bufferedOutputStream2.flush();
                if (this.f29690h == ((long) this.f29688f.getContentLength())) {
                    z = true;
                }
                FileUtil.closeQuietly(bufferedInputStream);
                FileUtil.closeQuietly(bufferedOutputStream2);
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    OmegaUtils.offline_error("writeInputStreamToOutputStream" + e.getMessage());
                    SystemUtils.log(3, "ResponseStreamrror: ", e.getMessage() + " download not finished", (Throwable) null, "com.didi.onehybrid.resource.FusionHttpClient", 172);
                    FileUtil.closeQuietly(bufferedInputStream);
                    FileUtil.closeQuietly(bufferedOutputStream);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    FileUtil.closeQuietly(bufferedInputStream);
                    FileUtil.closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                FileUtil.closeQuietly(bufferedInputStream);
                FileUtil.closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            OmegaUtils.offline_error("writeInputStreamToOutputStream" + e.getMessage());
            SystemUtils.log(3, "ResponseStreamrror: ", e.getMessage() + " download not finished", (Throwable) null, "com.didi.onehybrid.resource.FusionHttpClient", 172);
            FileUtil.closeQuietly(bufferedInputStream);
            FileUtil.closeQuietly(bufferedOutputStream);
            return z;
        }
        return z;
    }

    public int connect() {
        return m20848a(true, false);
    }

    /* renamed from: a */
    private int m20848a(boolean z, boolean z2) {
        try {
            URLConnection openConnection = new URL(this.f29686d).openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                return -100;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            this.f29688f = httpURLConnection;
            httpURLConnection.setConnectTimeout(5000);
            int i = 10000;
            Object attr = FusionEngine.getAttr(WebConstant.READ_TIMEOUT);
            if (attr instanceof Integer) {
                i = ((Integer) attr).intValue();
            }
            this.f29688f.setReadTimeout(i);
            this.f29688f.setInstanceFollowRedirects(true);
            if (this.f29687e != null && !this.f29687e.isEmpty()) {
                for (Map.Entry next : this.f29687e.entrySet()) {
                    this.f29688f.setRequestProperty((String) next.getKey(), (String) next.getValue());
                }
            }
            if (z2) {
                this.f29688f.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            }
            if (z) {
                String cookie = FusionCacheClient.sInstance.getCookie(this.f29686d);
                if (!TextUtils.isEmpty(cookie)) {
                    this.f29688f.setRequestProperty(HttpHeaders.COOKIE, cookie);
                }
            }
            this.f29688f.connect();
            return 0;
        } catch (MalformedURLException unused) {
            return -101;
        } catch (IOException e) {
            if (e instanceof SocketTimeoutException) {
                return -103;
            }
            e.printStackTrace();
            return -102;
        }
    }

    public int getResponseCode() {
        try {
            return this.f29688f.getResponseCode();
        } catch (IOException e) {
            return e instanceof SocketTimeoutException ? -103 : -102;
        }
    }

    public boolean isNotModified(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            int responseCode = getResponseCode();
            if (responseCode == 304) {
                return true;
            }
            if (responseCode == 200) {
                String headerValue = getHeaderValue(HttpHeaders.ETAG);
                if (!TextUtils.isEmpty(headerValue) && headerValue.equals(map.get("if-none-match"))) {
                    return true;
                }
                String headerValue2 = getHeaderValue(HttpHeaders.LAST_MODIFIED);
                if (TextUtils.isEmpty(headerValue2) || !headerValue2.equals(map.get("if-modified-since"))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String getHeaderValue(String str) {
        return this.f29688f.getHeaderField(str);
    }

    public Map<String, List<String>> getResponseHeader() {
        return this.f29688f.getHeaderFields();
    }

    public BufferedInputStream getResponseStream() {
        HttpURLConnection httpURLConnection = this.f29688f;
        if (httpURLConnection != null && this.f29689g == null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(this.f29688f.getContentEncoding())) {
                    this.f29689g = new BufferedInputStream(new GZIPInputStream(inputStream));
                } else {
                    this.f29689g = new BufferedInputStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.f29689g;
    }

    public void disconnect() {
        if (this.f29688f == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    FusionHttpClient.this.f29688f.disconnect();
                }
            });
        } else {
            this.f29688f.disconnect();
        }
    }
}
