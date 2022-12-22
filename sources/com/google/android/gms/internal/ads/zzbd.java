package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbd extends zzar {
    private final zzbf zzcv;
    private final SSLSocketFactory zzcw;

    public zzbd() {
        this((zzbf) null);
    }

    private zzbd(zzbf zzbf) {
        this((zzbf) null, (SSLSocketFactory) null);
    }

    private zzbd(zzbf zzbf, SSLSocketFactory sSLSocketFactory) {
        this.zzcv = null;
        this.zzcw = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbb zza(com.google.android.gms.internal.ads.zzab<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zzl {
        /*
            r6 = this;
            java.lang.String r0 = r7.getUrl()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.getHeaders()
            r1.putAll(r8)
            java.net.URL r8 = new java.net.URL
            r8.<init>(r0)
            java.net.URLConnection r0 = r8.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r0.setInstanceFollowRedirects(r2)
            int r2 = r7.zzi()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r8 = r8.getProtocol()
            java.lang.String r4 = "https"
            r4.equals(r8)
            java.util.Set r8 = r1.keySet()     // Catch:{ all -> 0x00fd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00fd }
        L_0x0048:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x00fd }
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00fd }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00fd }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x00fd }
            goto L_0x0048
        L_0x005e:
            int r8 = r7.getMethod()     // Catch:{ all -> 0x00fd }
            switch(r8) {
                case -1: goto L_0x00a1;
                case 0: goto L_0x009c;
                case 1: goto L_0x0093;
                case 2: goto L_0x008a;
                case 3: goto L_0x0084;
                case 4: goto L_0x007e;
                case 5: goto L_0x0078;
                case 6: goto L_0x0072;
                case 7: goto L_0x0069;
                default: goto L_0x0065;
            }     // Catch:{ all -> 0x00fd }
        L_0x0065:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fd }
            goto L_0x00f7
        L_0x0069:
            java.lang.String r8 = "PATCH"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            zza((java.net.HttpURLConnection) r0, (com.google.android.gms.internal.ads.zzab<?>) r7)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x0072:
            java.lang.String r8 = "TRACE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x0078:
            java.lang.String r8 = "OPTIONS"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x007e:
            java.lang.String r8 = "HEAD"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x0084:
            java.lang.String r8 = "DELETE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x008a:
            java.lang.String r8 = "PUT"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            zza((java.net.HttpURLConnection) r0, (com.google.android.gms.internal.ads.zzab<?>) r7)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x0093:
            java.lang.String r8 = "POST"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
            zza((java.net.HttpURLConnection) r0, (com.google.android.gms.internal.ads.zzab<?>) r7)     // Catch:{ all -> 0x00fd }
            goto L_0x00a1
        L_0x009c:
            java.lang.String r8 = "GET"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x00fd }
        L_0x00a1:
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x00fd }
            r1 = -1
            if (r8 == r1) goto L_0x00ef
            int r7 = r7.getMethod()     // Catch:{ all -> 0x00fd }
            r1 = 4
            if (r7 == r1) goto L_0x00c1
            r7 = 100
            if (r7 > r8) goto L_0x00b7
            r7 = 200(0xc8, float:2.8E-43)
            if (r8 < r7) goto L_0x00c1
        L_0x00b7:
            r7 = 204(0xcc, float:2.86E-43)
            if (r8 == r7) goto L_0x00c1
            r7 = 304(0x130, float:4.26E-43)
            if (r8 == r7) goto L_0x00c1
            r7 = 1
            goto L_0x00c2
        L_0x00c1:
            r7 = 0
        L_0x00c2:
            if (r7 != 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzbb r7 = new com.google.android.gms.internal.ads.zzbb     // Catch:{ all -> 0x00fd }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x00fd }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x00fd }
            r7.<init>(r8, r1)     // Catch:{ all -> 0x00fd }
            r0.disconnect()
            return r7
        L_0x00d5:
            com.google.android.gms.internal.ads.zzbb r7 = new com.google.android.gms.internal.ads.zzbb     // Catch:{ all -> 0x00ec }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x00ec }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x00ec }
            int r2 = r0.getContentLength()     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.ads.zzbg r4 = new com.google.android.gms.internal.ads.zzbg     // Catch:{ all -> 0x00ec }
            r4.<init>(r0)     // Catch:{ all -> 0x00ec }
            r7.<init>(r8, r1, r2, r4)     // Catch:{ all -> 0x00ec }
            return r7
        L_0x00ec:
            r7 = move-exception
            r2 = 1
            goto L_0x00fe
        L_0x00ef:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)     // Catch:{ all -> 0x00fd }
            throw r7     // Catch:{ all -> 0x00fd }
        L_0x00f7:
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)     // Catch:{ all -> 0x00fd }
            throw r7     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r7 = move-exception
        L_0x00fe:
            if (r2 != 0) goto L_0x0103
            r0.disconnect()
        L_0x0103:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbd.zza(com.google.android.gms.internal.ads.zzab, java.util.Map):com.google.android.gms.internal.ads.zzbb");
    }

    private static List<zzv> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String zzv : (List) next.getValue()) {
                    arrayList.add(new zzv((String) next.getKey(), zzv));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzab<?> zzab) throws IOException, zzl {
        byte[] zzg = zzab.zzg();
        if (zzg != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", "UTF-8".length() != 0 ? "application/x-www-form-urlencoded; charset=".concat("UTF-8") : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzg);
            dataOutputStream.close();
        }
    }
}
