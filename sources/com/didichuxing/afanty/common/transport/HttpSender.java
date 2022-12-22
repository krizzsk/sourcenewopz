package com.didichuxing.afanty.common.transport;

public class HttpSender {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0123 A[SYNTHETIC, Splitter:B:101:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x012d A[SYNTHETIC, Splitter:B:106:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0137 A[SYNTHETIC, Splitter:B:111:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0141 A[SYNTHETIC, Splitter:B:116:0x0141] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x014d A[SYNTHETIC, Splitter:B:123:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0157 A[SYNTHETIC, Splitter:B:128:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0161 A[SYNTHETIC, Splitter:B:133:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x016b A[SYNTHETIC, Splitter:B:138:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String dopost(java.lang.String r7, java.io.File r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            java.lang.String r0 = ""
            if (r8 == 0) goto L_0x0174
            boolean r1 = r8.exists()
            if (r1 == 0) goto L_0x0174
            long r1 = r8.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0016
            goto L_0x0174
        L_0x0016:
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0114, all -> 0x010e }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0114, all -> 0x010e }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ Exception -> 0x0114, all -> 0x010e }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0114, all -> 0x010e }
            r2 = 1024(0x400, float:1.435E-42)
            r7.setChunkedStreamingMode(r2)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r3 = 1
            r7.setDoOutput(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r3 = "POST"
            r7.setRequestMethod(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            r7.setReadTimeout(r3)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r9 == 0) goto L_0x005a
            java.util.Set r3 = r9.keySet()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
        L_0x0042:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.Object r5 = r9.get(r4)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            if (r5 == 0) goto L_0x0042
            r7.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            goto L_0x0042
        L_0x005a:
            java.io.OutputStream r9 = r7.getOutputStream()     // Catch:{ Exception -> 0x0107, all -> 0x0100 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r3.<init>(r8)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            byte[] r8 = new byte[r2]     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
        L_0x0065:
            int r2 = r3.read(r8)     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            r4 = -1
            if (r2 == r4) goto L_0x0071
            r4 = 0
            r9.write(r8, r4, r2)     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            goto L_0x0065
        L_0x0071:
            r9.flush()     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            r8 = 200(0xc8, float:2.8E-43)
            int r2 = r7.getResponseCode()     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            if (r8 == r2) goto L_0x0094
            if (r7 == 0) goto L_0x0081
            r7.disconnect()
        L_0x0081:
            if (r9 == 0) goto L_0x008b
            r9.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008b:
            r3.close()     // Catch:{ Exception -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0093:
            return r0
        L_0x0094:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            r8.<init>()     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ Exception -> 0x00f6, all -> 0x00f2 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r2, r6)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        L_0x00a9:
            java.lang.String r1 = r4.readLine()     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            if (r1 == 0) goto L_0x00b8
            r8.append(r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            java.lang.String r1 = "\n"
            r8.append(r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            goto L_0x00a9
        L_0x00b8:
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x00ea, all -> 0x00e8 }
            if (r7 == 0) goto L_0x00c1
            r7.disconnect()
        L_0x00c1:
            if (r9 == 0) goto L_0x00cb
            r9.close()     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00cb:
            r3.close()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00d3:
            if (r2 == 0) goto L_0x00dd
            r2.close()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00dd:
            r4.close()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x0144
        L_0x00e2:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0144
        L_0x00e8:
            r8 = move-exception
            goto L_0x0105
        L_0x00ea:
            r8 = move-exception
            goto L_0x010c
        L_0x00ec:
            r8 = move-exception
            r4 = r1
            goto L_0x0105
        L_0x00ef:
            r8 = move-exception
            r4 = r1
            goto L_0x010c
        L_0x00f2:
            r8 = move-exception
            r2 = r1
            r4 = r2
            goto L_0x0105
        L_0x00f6:
            r8 = move-exception
            r2 = r1
            r4 = r2
            goto L_0x010c
        L_0x00fa:
            r8 = move-exception
            r2 = r1
            goto L_0x0103
        L_0x00fd:
            r8 = move-exception
            r2 = r1
            goto L_0x010a
        L_0x0100:
            r8 = move-exception
            r9 = r1
            r2 = r9
        L_0x0103:
            r3 = r2
            r4 = r3
        L_0x0105:
            r1 = r7
            goto L_0x0146
        L_0x0107:
            r8 = move-exception
            r9 = r1
            r2 = r9
        L_0x010a:
            r3 = r2
            r4 = r3
        L_0x010c:
            r1 = r7
            goto L_0x0119
        L_0x010e:
            r8 = move-exception
            r9 = r1
            r2 = r9
            r3 = r2
            r4 = r3
            goto L_0x0146
        L_0x0114:
            r8 = move-exception
            r9 = r1
            r2 = r9
            r3 = r2
            r4 = r3
        L_0x0119:
            r8.printStackTrace()     // Catch:{ all -> 0x0145 }
            if (r1 == 0) goto L_0x0121
            r1.disconnect()
        L_0x0121:
            if (r9 == 0) goto L_0x012b
            r9.close()     // Catch:{ Exception -> 0x0127 }
            goto L_0x012b
        L_0x0127:
            r7 = move-exception
            r7.printStackTrace()
        L_0x012b:
            if (r3 == 0) goto L_0x0135
            r3.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0135
        L_0x0131:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0135:
            if (r2 == 0) goto L_0x013f
            r2.close()     // Catch:{ Exception -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x013f:
            if (r4 == 0) goto L_0x0144
            r4.close()     // Catch:{ Exception -> 0x00e2 }
        L_0x0144:
            return r0
        L_0x0145:
            r8 = move-exception
        L_0x0146:
            if (r1 == 0) goto L_0x014b
            r1.disconnect()
        L_0x014b:
            if (r9 == 0) goto L_0x0155
            r9.close()     // Catch:{ Exception -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0155:
            if (r3 == 0) goto L_0x015f
            r3.close()     // Catch:{ Exception -> 0x015b }
            goto L_0x015f
        L_0x015b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x015f:
            if (r2 == 0) goto L_0x0169
            r2.close()     // Catch:{ Exception -> 0x0165 }
            goto L_0x0169
        L_0x0165:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0169:
            if (r4 == 0) goto L_0x0173
            r4.close()     // Catch:{ Exception -> 0x016f }
            goto L_0x0173
        L_0x016f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0173:
            throw r8
        L_0x0174:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.afanty.common.transport.HttpSender.dopost(java.lang.String, java.io.File, java.util.Map):java.lang.String");
    }
}
