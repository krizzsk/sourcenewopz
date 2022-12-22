package com.jumio.core.network;

import android.os.AsyncTask;
import com.jumio.commons.log.Log;
import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.plugins.C20007a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 $2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0003$%&B\u001b\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J%\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0004J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0004J\b\u0010\u0014\u001a\u00020\u0006H\u0014J'\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\t\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0014J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001f\u001a\u00020\u001eH\u0016¨\u0006'"}, mo175978d2 = {"Lcom/jumio/core/network/DownloadTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "", "", "start", "startSync", "", "params", "doInBackground", "([Ljava/lang/Void;)[B", "Ljava/net/HttpURLConnection;", "connection", "close", "Ljava/io/InputStream;", "inputStream", "length", "processInputStream", "onPreExecute", "values", "onProgressUpdate", "([Ljava/lang/Integer;)V", "bytes", "onPostExecute", "onCancelled", "Lcom/jumio/core/network/DownloadTask$ProgressListener;", "mListener", "setListener", "", "getCallId", "mUrl", "timeout", "<init>", "(Ljava/lang/String;I)V", "Companion", "ProgressListener", "a", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DownloadTask.kt */
public final class DownloadTask extends AsyncTask<Void, Integer, byte[]> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final String f54902a;

    /* renamed from: b */
    public Timer f54903b;

    /* renamed from: c */
    public ProgressListener f54904c;

    /* renamed from: d */
    public int f54905d;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/jumio/core/network/DownloadTask$Companion;", "", "", "NO_TIMEOUT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DownloadTask.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&¨\u0006\r"}, mo175978d2 = {"Lcom/jumio/core/network/DownloadTask$ProgressListener;", "", "", "percent", "", "onProgressUpdate", "", "data", "onProgressDone", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onProgressException", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DownloadTask.kt */
    public interface ProgressListener {
        void onProgressDone(byte[] bArr);

        void onProgressException(Exception exc);

        void onProgressUpdate(float f);
    }

    /* renamed from: com.jumio.core.network.DownloadTask$a */
    /* compiled from: DownloadTask.kt */
    public final class C19996a extends TimerTask {

        /* renamed from: a */
        public final AsyncTask<?, ?, ?> f54906a;

        public C19996a(DownloadTask downloadTask, AsyncTask<?, ?, ?> asyncTask) {
            Intrinsics.checkNotNullParameter(downloadTask, "this$0");
            this.f54906a = asyncTask;
        }

        public void run() {
            AsyncTask<?, ?, ?> asyncTask = this.f54906a;
            if (asyncTask != null && asyncTask.getStatus() != AsyncTask.Status.FINISHED && !this.f54906a.isCancelled()) {
                this.f54906a.cancel(true);
                Log.m39471v("DownloadTask", "timer fired - killing task");
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DownloadTask(String str) {
        this(str, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "mUrl");
    }

    public DownloadTask(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "mUrl");
        this.f54902a = str;
        if (i != -1) {
            this.f54903b = new Timer("TimeoutTaskKiller");
            this.f54905d = i;
        }
    }

    public final void close(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
            try {
                if (httpURLConnection.getDoOutput()) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (Exception e3) {
                Log.printStackTrace(e3);
            }
            httpURLConnection.disconnect();
        }
    }

    public String getCallId() {
        String simpleName = DownloadTask.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "DownloadTask::class.java.simpleName");
        return simpleName;
    }

    public void onPreExecute() {
        super.onPreExecute();
        Timer timer = this.f54903b;
        if (timer != null) {
            timer.schedule(new C19996a(this, this), (long) this.f54905d);
        }
    }

    public final void setListener(ProgressListener progressListener) {
        this.f54904c = progressListener;
    }

    public final void start() {
        execute(new Void[0]);
    }

    public final byte[] startSync() {
        return doInBackground(new Void[0]);
    }

    public byte[] doInBackground(Void... voidArr) {
        int i;
        HttpsURLConnection httpsURLConnection;
        Throwable th;
        Intrinsics.checkNotNullParameter(voidArr, "params");
        String callId = getCallId();
        C20007a.C20010c cVar = C20007a.C20010c.DATADOG;
        byte[] bArr = null;
        AnalyticsPlugin analyticsPlugin = C20007a.m39595c(cVar) ? (AnalyticsPlugin) C20007a.m39594b(cVar) : null;
        try {
            URL url = new URL(this.f54902a);
            if (url.getProtocol().equals("https")) {
                URLConnection openConnection = url.openConnection();
                if (openConnection != null) {
                    httpsURLConnection = (HttpsURLConnection) openConnection;
                    try {
                        String host = url.getHost();
                        Intrinsics.checkNotNullExpressionValue(host, "url.host");
                        httpsURLConnection.setSSLSocketFactory(new C20001e(new TrustManager[]{new C19997a(host)}));
                        httpsURLConnection.setDoInput(true);
                        if (analyticsPlugin != null) {
                            String str = this.f54902a;
                            String requestMethod = httpsURLConnection.getRequestMethod();
                            Intrinsics.checkNotNullExpressionValue(requestMethod, "connection.requestMethod");
                            analyticsPlugin.reportRequest(callId, str, 0, requestMethod);
                        }
                        httpsURLConnection.connect();
                        i = httpsURLConnection.getResponseCode();
                        if (analyticsPlugin != null) {
                            try {
                                AnalyticsPlugin.C20006a.m39588a(analyticsPlugin, callId, this.f54902a, Integer.valueOf(httpsURLConnection.getContentLength()), i, (Exception) null, 16, (Object) null);
                            } catch (Throwable th2) {
                                th = th2;
                                close(httpsURLConnection);
                                throw th;
                            }
                        }
                        if (httpsURLConnection.getResponseCode() != 200) {
                            try {
                                close(httpsURLConnection);
                                return null;
                            } catch (Exception e) {
                                Exception exc = e;
                                int i2 = i;
                                if (analyticsPlugin != null) {
                                    analyticsPlugin.reportResponse(callId, this.f54902a, (Integer) null, i2, exc);
                                }
                                Log.m39462e("DownloadTask", "", (Throwable) exc);
                                ProgressListener progressListener = this.f54904c;
                                if (progressListener != null) {
                                    progressListener.onProgressException(exc);
                                }
                            }
                        } else {
                            bArr = processInputStream(httpsURLConnection.getInputStream(), httpsURLConnection.getContentLength());
                            close(httpsURLConnection);
                            return bArr;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i = 0;
                        close(httpsURLConnection);
                        throw th;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                }
            } else {
                throw new Exception("Only https DownloadTasks are supported!");
            }
        } catch (Throwable th4) {
            th = th4;
            httpsURLConnection = null;
            i = 0;
            close(httpsURLConnection);
            throw th;
        }
    }

    public void onCancelled(byte[] bArr) {
        super.onCancelled(bArr);
    }

    public void onPostExecute(byte[] bArr) {
        super.onPostExecute(bArr);
        ProgressListener progressListener = this.f54904c;
        if (progressListener != null) {
            progressListener.onProgressDone(bArr);
        }
        Timer timer = this.f54903b;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public void onProgressUpdate(Integer... numArr) {
        Intrinsics.checkNotNullParameter(numArr, "values");
        super.onProgressUpdate(Arrays.copyOf(numArr, numArr.length));
        ProgressListener progressListener = this.f54904c;
        if (progressListener != null) {
            Integer num = numArr[0];
            progressListener.onProgressUpdate(num == null ? 0.0f : (float) num.intValue());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047 A[SYNTHETIC, Splitter:B:22:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[SYNTHETIC, Splitter:B:27:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] processInputStream(java.io.InputStream r9, int r10) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "DownloadTask"
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0043 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0043 }
            r3.<init>()     // Catch:{ all -> 0x0043 }
            r4 = 0
            r5 = 0
        L_0x000f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ all -> 0x0041 }
            int r6 = r9.read(r2)     // Catch:{ all -> 0x0041 }
            if (r6 <= 0) goto L_0x002c
            r3.write(r2, r4, r6)     // Catch:{ all -> 0x0041 }
            int r5 = r5 + r6
            r6 = 1
            java.lang.Integer[] r6 = new java.lang.Integer[r6]     // Catch:{ all -> 0x0041 }
            int r7 = r5 * 100
            int r7 = r7 / r10
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0041 }
            r6[r4] = r7     // Catch:{ all -> 0x0041 }
            r8.publishProgress(r6)     // Catch:{ all -> 0x0041 }
            goto L_0x000f
        L_0x002c:
            byte[] r10 = r3.toByteArray()     // Catch:{ all -> 0x0041 }
            r3.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r2 = move-exception
            com.jumio.commons.log.Log.m39462e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0038:
            r9.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r9 = move-exception
            com.jumio.commons.log.Log.m39462e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0040:
            return r10
        L_0x0041:
            r10 = move-exception
            goto L_0x0045
        L_0x0043:
            r10 = move-exception
            r3 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x004f
            r3.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r2 = move-exception
            com.jumio.commons.log.Log.m39462e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x004f:
            if (r9 == 0) goto L_0x0059
            r9.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r9 = move-exception
            com.jumio.commons.log.Log.m39462e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0059:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.DownloadTask.processInputStream(java.io.InputStream, int):byte[]");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadTask(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? -1 : i);
    }
}
