package com.didi.sdk.audiorecorder.utils.log;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.utils.DeviceUtil;
import com.didi.sdk.audiorecorder.utils.IOUtil;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import com.didi.sdk.audiorecorder.utils.TextUtil;
import com.didi.sdk.audiorecorder.utils.TimeUtil;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class LogWriter {

    /* renamed from: a */
    private static final int f35594a = 10240;

    /* renamed from: b */
    private static final int f35595b = 24;

    /* renamed from: c */
    private static final int f35596c = 16;

    /* renamed from: d */
    private static final int f35597d = 8;

    /* renamed from: e */
    private static final int f35598e = 0;

    /* renamed from: f */
    private static final int f35599f = 255;

    /* renamed from: g */
    private static final String f35600g = "yyyyMMdd";

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3 A[Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce A[SYNTHETIC, Splitter:B:52:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x00a1=Splitter:B:25:0x00a1, B:40:0x00b9=Splitter:B:40:0x00b9} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x00b4=Splitter:B:37:0x00b4, B:43:0x00be=Splitter:B:43:0x00be} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m25187a(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            boolean r1 = com.didi.sdk.audiorecorder.utils.LogUtil.isDebuggable()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.String r2 = "\n"
            r3 = 1
            if (r1 != 0) goto L_0x0075
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            if (r1 != 0) goto L_0x0075
            int r1 = r8.length()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r4 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r4) goto L_0x0075
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.String r4 = "logback-"
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r1.append(r7)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.String r7 = r1.toString()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            com.didi.sdk.audiorecorder.utils.log.b r1 = new com.didi.sdk.audiorecorder.utils.log.b     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.String r6 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r1.<init>(r4, r3)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            com.didi.sdk.audiorecorder.utils.log.LogWriter$AESEncryptor r6 = new com.didi.sdk.audiorecorder.utils.log.LogWriter$AESEncryptor     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r7 = "dis&9*lf_628ns#e"
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r7.append(r2)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            byte[] r7 = m25188a((java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            if (r7 == 0) goto L_0x00a1
            int r8 = r7.length     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            if (r8 == 0) goto L_0x00a1
            byte[] r6 = r6.encrypt(r7)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            if (r6 == 0) goto L_0x00a1
            int r7 = r6.length     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            if (r7 == 0) goto L_0x00a1
            int r7 = r6.length     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            m25185a((java.io.OutputStream) r1, (int) r7)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r1.write(r6)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r1.flush()     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x00a1
        L_0x0075:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.lang.String r6 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r4.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            r1.<init>(r4, r3)     // Catch:{ FileNotFoundException -> 0x00c4, UnsupportedEncodingException -> 0x00bd, Exception -> 0x00b3 }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r7 = "utf-8"
            r6.<init>(r1, r7)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r6.write(r8)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r6.write(r2)     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r6.flush()     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
            r6.close()     // Catch:{ FileNotFoundException -> 0x00ae, UnsupportedEncodingException -> 0x00ab, Exception -> 0x00a8, all -> 0x00a5 }
        L_0x00a1:
            r1.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00cb
        L_0x00a5:
            r6 = move-exception
            r0 = r1
            goto L_0x00cc
        L_0x00a8:
            r6 = move-exception
            r0 = r1
            goto L_0x00b4
        L_0x00ab:
            r6 = move-exception
            r0 = r1
            goto L_0x00be
        L_0x00ae:
            r6 = move-exception
            r0 = r1
            goto L_0x00c5
        L_0x00b1:
            r6 = move-exception
            goto L_0x00cc
        L_0x00b3:
            r6 = move-exception
        L_0x00b4:
            r6.printStackTrace()     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x00cb
        L_0x00b9:
            r0.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00cb
        L_0x00bd:
            r6 = move-exception
        L_0x00be:
            r6.printStackTrace()     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x00cb
            goto L_0x00b9
        L_0x00c4:
            r6 = move-exception
        L_0x00c5:
            r6.printStackTrace()     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x00cb
            goto L_0x00b9
        L_0x00cb:
            return
        L_0x00cc:
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.utils.log.LogWriter.m25187a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private static final void m25185a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >>> 24) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write((i >>> 0) & 255);
    }

    /* renamed from: a */
    private static byte[] m25188a(String str) {
        try {
            return str.getBytes();
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static void m25190b(String str, String str2, String str3) {
        if (DeviceUtil.isSdcardMounted() && !TextUtil.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            String str4 = TimeUtil.formatCurrentTime(TimeUtil.YMD_HMSS) + "||" + str3;
            m25187a(str, (str2 + "_" + TimeUtil.formatTime(TimeUtil.currentTimeMillis(), "yyyyMMdd")) + ".txt", str4);
        }
    }

    /* renamed from: a */
    static void m25183a(Intent intent) {
        HashMap hashMap = (HashMap) intent.getSerializableExtra("params");
        int intExtra = intent.getIntExtra("action", 0);
        if (intExtra != 1) {
            String str = null;
            if (intExtra == 2) {
                String userPhone = AudioRecordManager.get().getUserPhone();
                if (TextUtil.isEmpty(userPhone)) {
                    userPhone = LogUtil.getUserPhone();
                }
                if (!TextUtil.isEmpty(userPhone)) {
                    String obj = hashMap.containsKey("folder") ? hashMap.get("folder").toString() : null;
                    if (TextUtil.isEmpty(obj)) {
                        File logDir = LogUtil.getLogDir();
                        if (logDir != null) {
                            obj = logDir.getAbsolutePath();
                        } else {
                            return;
                        }
                    }
                    String obj2 = hashMap.containsKey("fileName") ? hashMap.get("fileName").toString() : null;
                    if (hashMap.containsKey("log")) {
                        str = hashMap.get("log").toString();
                    }
                    if (TextUtil.isEmpty(obj2)) {
                        m25190b(obj, userPhone, str);
                        return;
                    }
                    m25190b(obj, userPhone + "_" + obj2, str);
                }
            } else if (intExtra == 4) {
                String obj3 = hashMap.containsKey("folder") ? hashMap.get("folder").toString() : null;
                if (TextUtil.isEmpty(obj3)) {
                    File logDir2 = LogUtil.getLogDir();
                    if (logDir2 != null) {
                        obj3 = logDir2.getAbsolutePath();
                    } else {
                        return;
                    }
                }
                String obj4 = hashMap.containsKey("originalFileName") ? hashMap.get("originalFileName").toString() : null;
                if (hashMap.containsKey("newFileName")) {
                    str = hashMap.get("newFileName").toString();
                }
                m25192c(obj3, obj4, str);
                m25186a(obj3, obj4);
            }
        } else {
            IOUtil.deleteExpireFile(LogUtil.getLogDir(), GlobalBubbleShowHelper.ONE_WEEK);
        }
    }

    /* renamed from: c */
    private static void m25192c(String str, String str2, String str3) {
        if (DeviceUtil.isSdcardMounted() && !TextUtil.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str2.equals(str3)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            m25184a(new File(str + str2 + ".txt"), new File(str + str3 + ".txt"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[SYNTHETIC, Splitter:B:30:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082 A[SYNTHETIC, Splitter:B:35:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m25186a(java.lang.String r3, java.lang.String r4) {
        /*
            boolean r0 = com.didi.sdk.audiorecorder.utils.DeviceUtil.isSdcardMounted()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = com.didi.sdk.audiorecorder.utils.TextUtil.isEmpty(r3)
            if (r0 != 0) goto L_0x008b
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0015
            goto L_0x008b
        L_0x0015:
            java.lang.String r0 = java.io.File.separator
            boolean r0 = r3.endsWith(r0)
            if (r0 != 0) goto L_0x002e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = java.io.File.separator
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x002e:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = ".txt"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ IOException -> 0x0071 }
            if (r4 != 0) goto L_0x0051
            r0.createNewFile()     // Catch:{ IOException -> 0x0071 }
        L_0x0051:
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x0071 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0071 }
            java.lang.String r3 = ""
            r4.write(r3)     // Catch:{ IOException -> 0x006a, all -> 0x0065 }
            r4.flush()     // Catch:{ IOException -> 0x006a, all -> 0x0065 }
            r4.close()     // Catch:{ IOException -> 0x006a, all -> 0x0065 }
            r4.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x0065:
            r3 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x0080
        L_0x006a:
            r3 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x0072
        L_0x006f:
            r4 = move-exception
            goto L_0x0080
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            r4.printStackTrace()     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x007f
            r3.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x007f:
            return
        L_0x0080:
            if (r3 == 0) goto L_0x008a
            r3.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r3 = move-exception
            r3.printStackTrace()
        L_0x008a:
            throw r4
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.utils.log.LogWriter.m25186a(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[SYNTHETIC, Splitter:B:22:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c A[SYNTHETIC, Splitter:B:28:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC, Splitter:B:33:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0047=Splitter:B:25:0x0047, B:19:0x003d=Splitter:B:19:0x003d} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m25184a(java.io.File r3, java.io.File r4) {
        /*
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x003c }
            r2 = 1
            r1.<init>(r4, r2)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x003c }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            java.lang.String r3 = "utf-8"
            r0.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            r4.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
        L_0x0018:
            java.lang.String r3 = r4.readLine()     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            if (r3 == 0) goto L_0x002a
            java.lang.String r0 = "\n"
            r1.write(r0)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            r1.write(r3)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            r1.flush()     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            goto L_0x0018
        L_0x002a:
            r4.close()     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0034, all -> 0x0031 }
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0031:
            r3 = move-exception
            r0 = r1
            goto L_0x0055
        L_0x0034:
            r3 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x0037:
            r3 = move-exception
            r0 = r1
            goto L_0x0047
        L_0x003a:
            r3 = move-exception
            goto L_0x0055
        L_0x003c:
            r3 = move-exception
        L_0x003d:
            r3.printStackTrace()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0054
            r0.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0046:
            r3 = move-exception
        L_0x0047:
            r3.printStackTrace()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0054
            r0.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0054:
            return
        L_0x0055:
            if (r0 == 0) goto L_0x005f
            r0.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.utils.log.LogWriter.m25184a(java.io.File, java.io.File):void");
    }

    static final class Action {
        static final int AMEND_FILE = 4;
        static final int DELETE = 1;
        static final int LOGIN_LOG = 3;
        static final int LOG_2_SD = 2;
        private final int mAction;
        private final HashMap<String, Object> mParams = new HashMap<>();

        Action(int i) {
            this.mAction = i;
        }

        /* access modifiers changed from: package-private */
        public Action put(String str, Object obj) {
            this.mParams.put(str, obj);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void send() {
            Intent intent = new Intent();
            intent.putExtra("action", this.mAction);
            intent.putExtra("params", this.mParams);
            LogWriter.m25191c(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m25191c(Intent intent) {
        try {
            m25183a(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private LogWriter() {
    }

    static final class AESEncryptor {
        private static final int BUFFER_SIZE = 16;
        private final IvParameterSpec mIvSpec;
        private final SecretKeySpec mKeySpec;

        public AESEncryptor(String str) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[16];
            System.arraycopy(bytes, 0, bArr, 0, Math.min(16, bytes.length));
            this.mKeySpec = new SecretKeySpec(bArr, "AES");
            this.mIvSpec = new IvParameterSpec(bytes);
        }

        public byte[] encrypt(byte[] bArr) {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, this.mKeySpec, this.mIvSpec);
                return instance.doFinal(bArr);
            } catch (Exception unused) {
                return bArr;
            }
        }

        public byte[] decrypt(byte[] bArr) {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, this.mKeySpec, this.mIvSpec);
                return instance.doFinal(bArr);
            } catch (Exception unused) {
                return bArr;
            }
        }
    }
}
