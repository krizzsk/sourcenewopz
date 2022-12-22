package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzou implements zzot {
    private static final Pattern zzbiy = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbiz = new AtomicReference<>();
    private final boolean zzbja;
    private final int zzbjb;
    private final int zzbjc;
    private final String zzbjd;
    private final zzpp<String> zzbje = null;
    private final zzox zzbjf;
    private final zzox zzbjg;
    private final zzpd<? super zzou> zzbjh;
    private zzos zzbji;
    private HttpURLConnection zzbjj;
    private InputStream zzbjk;
    private boolean zzbjl;
    private long zzbjm;
    private long zzbjn;
    private long zzbjo;
    private long zzcp;

    public zzou(String str, zzpp<String> zzpp, zzpd<? super zzou> zzpd, int i, int i2, boolean z, zzox zzox) {
        this.zzbjd = zzpg.checkNotEmpty(str);
        this.zzbjh = zzpd;
        this.zzbjg = new zzox();
        this.zzbjb = i;
        this.zzbjc = i2;
        this.zzbja = true;
        this.zzbjf = null;
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final long zza(zzos zzos) throws zzov {
        HttpURLConnection httpURLConnection;
        HttpURLConnection zza;
        zzos zzos2 = zzos;
        this.zzbji = zzos2;
        long j = 0;
        this.zzcp = 0;
        this.zzbjo = 0;
        try {
            URL url = new URL(zzos2.uri.toString());
            byte[] bArr = zzos2.zzbiv;
            long j2 = zzos2.position;
            long j3 = zzos2.zzco;
            boolean isFlagSet = zzos2.isFlagSet(1);
            if (!this.zzbja) {
                httpURLConnection = zza(url, bArr, j2, j3, isFlagSet, true);
            } else {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        int i3 = i2;
                        long j4 = j3;
                        long j5 = j2;
                        zza = zza(url2, bArr2, j2, j3, isFlagSet, false);
                        int responseCode = zza.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != 307) {
                                    if (responseCode != 308) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = zza.getHeaderField("Location");
                        zza.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url3, headerField);
                            String protocol = url2.getProtocol();
                            if ("https".equals(protocol) || "http".equals(protocol)) {
                                i = i3;
                                j3 = j4;
                                j2 = j5;
                            } else {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnection = zza;
            }
            this.zzbjj = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map headerFields = this.zzbjj.getHeaderFields();
                    zziv();
                    zzoy zzoy = new zzoy(responseCode2, headerFields, zzos2);
                    if (responseCode2 == 416) {
                        zzoy.initCause(new zzop(0));
                    }
                    throw zzoy;
                }
                this.zzbjj.getContentType();
                if (responseCode2 == 200 && zzos2.position != 0) {
                    j = zzos2.position;
                }
                this.zzbjm = j;
                if (!zzos2.isFlagSet(1)) {
                    long j6 = -1;
                    if (zzos2.zzco != -1) {
                        this.zzbjn = zzos2.zzco;
                    } else {
                        long zzc = zzc(this.zzbjj);
                        if (zzc != -1) {
                            j6 = zzc - this.zzbjm;
                        }
                        this.zzbjn = j6;
                    }
                } else {
                    this.zzbjn = zzos2.zzco;
                }
                try {
                    this.zzbjk = this.zzbjj.getInputStream();
                    this.zzbjl = true;
                    zzpd<? super zzou> zzpd = this.zzbjh;
                    if (zzpd != null) {
                        zzpd.zza(this, zzos2);
                    }
                    return this.zzbjn;
                } catch (IOException e) {
                    zziv();
                    throw new zzov(e, zzos2, 1);
                }
            } catch (IOException e2) {
                IOException iOException = e2;
                zziv();
                String valueOf2 = String.valueOf(zzos2.uri.toString());
                throw new zzov(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), iOException, zzos2, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzos2.uri.toString());
            throw new zzov(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzos2, 1);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws zzov {
        try {
            if (this.zzbjo != this.zzbjm) {
                byte[] andSet = zzbiz.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbjo != this.zzbjm) {
                    int read = this.zzbjk.read(andSet, 0, (int) Math.min(this.zzbjm - this.zzbjo, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbjo += (long) read;
                        if (this.zzbjh != null) {
                            this.zzbjh.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzbiz.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbjn != -1) {
                long j = this.zzbjn - this.zzcp;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbjk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcp += (long) read2;
                if (this.zzbjh != null) {
                    this.zzbjh.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbjn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzov(e, this.zzbji, 2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.p003v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzov {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbjk     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbjj     // Catch:{ all -> 0x008e }
            long r3 = r9.zzbjn     // Catch:{ all -> 0x008e }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbjn     // Catch:{ all -> 0x008e }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbjn     // Catch:{ all -> 0x008e }
            long r7 = r9.zzcp     // Catch:{ all -> 0x008e }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 20
            if (r7 != r8) goto L_0x006b
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006b }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006b }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r2 = r9.zzbjk     // Catch:{ IOException -> 0x0071 }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzos r4 = r9.zzbji     // Catch:{ all -> 0x008e }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzos) r4, (int) r5)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x007b:
            r9.zzbjk = r0
            r9.zziv()
            boolean r0 = r9.zzbjl
            if (r0 == 0) goto L_0x008d
            r9.zzbjl = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzou> r0 = r9.zzbjh
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            return
        L_0x008e:
            r2 = move-exception
            r9.zzbjk = r0
            r9.zziv()
            boolean r0 = r9.zzbjl
            if (r0 == 0) goto L_0x00a1
            r9.zzbjl = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzou> r0 = r9.zzbjh
            if (r0 == 0) goto L_0x00a1
            r0.zze(r9)
        L_0x00a1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.close():void");
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbjb);
        httpURLConnection.setReadTimeout(this.zzbjc);
        for (Map.Entry next : this.zzbjg.zziw().entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.zzbjd);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r13) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r13.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L_0x003c
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0013 }
            goto L_0x003e
        L_0x0013:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r6 = r3.toString()
            r4 = 6
            r7 = 0
            r9 = 186(0xba, float:2.6E-43)
            java.lang.String r5 = "DefaultHttpDataSource"
            java.lang.String r8 = "com.google.android.gms.internal.ads.zzou"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x003c:
            r3 = -1
        L_0x003e:
            java.lang.String r1 = "Content-Range"
            java.lang.String r13 = r13.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto L_0x00e1
            java.util.regex.Pattern r1 = zzbiy
            java.util.regex.Matcher r1 = r1.matcher(r13)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x00e1
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x00b8 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x00b8 }
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ NumberFormatException -> 0x00b8 }
            long r7 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00b8 }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0074
            r3 = r5
            goto L_0x00e1
        L_0x0074:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00e1
            java.lang.String r8 = "DefaultHttpDataSource"
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00b8 }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00b8 }
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r13)     // Catch:{ NumberFormatException -> 0x00b8 }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00b8 }
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00b8 }
            r7.<init>(r1)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x00b8 }
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00b8 }
            r7.append(r13)     // Catch:{ NumberFormatException -> 0x00b8 }
            r7.append(r2)     // Catch:{ NumberFormatException -> 0x00b8 }
            java.lang.String r9 = r7.toString()     // Catch:{ NumberFormatException -> 0x00b8 }
            r7 = 5
            r10 = 0
            java.lang.String r11 = "com.google.android.gms.internal.ads.zzou"
            r12 = 196(0xc4, float:2.75E-43)
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ NumberFormatException -> 0x00b8 }
            long r0 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x00b8 }
            r3 = r0
            goto L_0x00e1
        L_0x00b8:
            java.lang.String r0 = java.lang.String.valueOf(r13)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r13)
            r1.append(r2)
            java.lang.String r7 = r1.toString()
            r5 = 6
            r8 = 0
            r10 = 200(0xc8, float:2.8E-43)
            java.lang.String r6 = "DefaultHttpDataSource"
            java.lang.String r9 = "com.google.android.gms.internal.ads.zzou"
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)
        L_0x00e1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.zzc(java.net.HttpURLConnection):long");
    }

    private final void zziv() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                SystemUtils.log(6, "DefaultHttpDataSource", "Unexpected error while disconnecting", e, "com.google.android.gms.internal.ads.zzou", 206);
            }
            this.zzbjj = null;
        }
    }
}
