package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.net.URLEncoder;
import java.util.Map;

/* renamed from: com.didi.dimina.container.secondparty.http.e */
/* compiled from: Utils */
class C7535e {
    C7535e() {
    }

    /* renamed from: a */
    static String m12710a(String str, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf(38) > 0 || str.indexOf(63) > 0) {
                sb.append(ParamKeys.SIGN_AND);
            } else {
                sb.append("?");
            }
            try {
                for (Map.Entry next : map.entrySet()) {
                    if (next.getValue() != null && !TextUtils.isEmpty((CharSequence) next.getKey())) {
                        String encode = URLEncoder.encode((String) next.getKey(), "UTF-8");
                        String encode2 = URLEncoder.encode(next.getValue().toString(), "UTF-8");
                        sb.append(encode);
                        sb.append("=");
                        sb.append(encode2);
                        sb.append(ParamKeys.SIGN_AND);
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x004b A[SYNTHETIC, Splitter:B:37:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0050 A[Catch:{ IOException -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0055 A[Catch:{ IOException -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005c A[SYNTHETIC, Splitter:B:47:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0061 A[Catch:{ IOException -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0066 A[Catch:{ IOException -> 0x0069 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m12711a(java.io.InputStream r5, java.lang.String r6, java.lang.String r7) {
        /*
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = 0
            boolean r1 = r0.exists()     // Catch:{ IOException -> 0x006a }
            if (r1 != 0) goto L_0x0013
            r0.createNewFile()     // Catch:{ IOException -> 0x006a }
        L_0x0013:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
        L_0x001e:
            int r1 = r3.read(r6)     // Catch:{ Exception -> 0x0040, all -> 0x0039 }
            r4 = -1
            if (r1 == r4) goto L_0x0029
            r2.write(r6, r7, r1)     // Catch:{ Exception -> 0x0040, all -> 0x0039 }
            goto L_0x001e
        L_0x0029:
            r2.flush()     // Catch:{ Exception -> 0x0040, all -> 0x0039 }
            r6 = 1
            if (r5 == 0) goto L_0x0032
            r5.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0038 }
            r3.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r6
        L_0x0039:
            r6 = move-exception
            goto L_0x003d
        L_0x003b:
            r6 = move-exception
            r3 = r1
        L_0x003d:
            r1 = r2
            goto L_0x005a
        L_0x003f:
            r3 = r1
        L_0x0040:
            r1 = r2
            goto L_0x0046
        L_0x0042:
            r6 = move-exception
            r3 = r1
            goto L_0x005a
        L_0x0045:
            r3 = r1
        L_0x0046:
            r0.delete()     // Catch:{ all -> 0x0059 }
            if (r5 == 0) goto L_0x004e
            r5.close()     // Catch:{ IOException -> 0x0058 }
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0053:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            return r7
        L_0x0059:
            r6 = move-exception
        L_0x005a:
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ IOException -> 0x0069 }
        L_0x005f:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0064:
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            throw r6
        L_0x006a:
            r5 = move-exception
            r5.printStackTrace()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.http.C7535e.m12711a(java.io.InputStream, java.lang.String, java.lang.String):boolean");
    }
}
