package com.didi.one.netdetect.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

@Deprecated
public class NetUtil {
    public static final String NETWORKTYPE_INVALID = "UNKNOWN";
    public static final String NETWORKTYPE_WAP = "WAP";
    public static final String NETWORKTYPE_WIFI = "WIFI";
    public static final String OPEN_IP = "";
    public static final String OPERATOR_URL = "";

    /* renamed from: a */
    private static final Pattern f29483a = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* renamed from: b */
    private static final Pattern f29484b = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4})*)?)::((?:([0-9A-Fa-f]{1,4}:)*[0-9A-Fa-f]{1,4})?)$");

    /* renamed from: c */
    private static final Pattern f29485c = Pattern.compile("^(::(?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5})|((?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5}::)$");

    public static int getCellId(Context context) {
        return -1;
    }

    public static int getLac(Context context) {
        return -1;
    }

    public static void getTestInfo(Context context) {
    }

    public static String getNetWorkType(Context context) {
        return WsgSecInfo.networkType(context);
    }

    public static Boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public static String getMobileOperator(Context context) {
        return WsgSecInfo.networkOperator(context);
    }

    @Deprecated
    public static String getMobileOperatorDirectly(Context context) {
        return WsgSecInfo.networkOperator(context);
    }

    public static String getLocalIpByWifi(Context context) {
        return WsgSecInfo.localIp(context);
    }

    public static String getLocalIpBy3G() {
        return WsgSecInfo.localIp();
    }

    public static String pingGateWayInWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "wifiManager not found";
        }
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        if (dhcpInfo == null) {
            return null;
        }
        int i = dhcpInfo.gateway;
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(i & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 24) & 255)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        if (r2 == null) goto L_0x0049;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d, all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007d A[SYNTHETIC, Splitter:B:38:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLocalDns(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            r3.<init>()     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            java.lang.String r4 = "getprop net."
            r3.append(r4)     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            r3.append(r6)     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            java.lang.String r6 = r3.toString()     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            java.lang.Process r6 = r2.exec(r6)     // Catch:{ IOException -> 0x006a, InterruptedException -> 0x0060, all -> 0x005d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0058, InterruptedException -> 0x0053, all -> 0x0051 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0058, InterruptedException -> 0x0053, all -> 0x0051 }
            java.io.InputStream r4 = r6.getInputStream()     // Catch:{ IOException -> 0x0058, InterruptedException -> 0x0053, all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0058, InterruptedException -> 0x0053, all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0058, InterruptedException -> 0x0053, all -> 0x0051 }
        L_0x002a:
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            if (r1 == 0) goto L_0x0040
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            r3.<init>()     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            r3.append(r0)     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            r3.append(r1)     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            goto L_0x002a
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
            r6.waitFor()     // Catch:{ IOException -> 0x004f, InterruptedException -> 0x004d }
        L_0x0046:
            r2.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0049:
            r6.destroy()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0074
        L_0x004d:
            r1 = move-exception
            goto L_0x0064
        L_0x004f:
            r1 = move-exception
            goto L_0x006e
        L_0x0051:
            r0 = move-exception
            goto L_0x007b
        L_0x0053:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0064
        L_0x0058:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x006e
        L_0x005d:
            r0 = move-exception
            r6 = r1
            goto L_0x007b
        L_0x0060:
            r6 = move-exception
            r2 = r1
            r1 = r6
            r6 = r2
        L_0x0064:
            r1.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0049
            goto L_0x0046
        L_0x006a:
            r6 = move-exception
            r2 = r1
            r1 = r6
            r6 = r2
        L_0x006e:
            r1.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0049
            goto L_0x0046
        L_0x0074:
            java.lang.String r6 = r0.trim()
            return r6
        L_0x0079:
            r0 = move-exception
            r1 = r2
        L_0x007b:
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ Exception -> 0x0083 }
        L_0x0080:
            r6.destroy()     // Catch:{ Exception -> 0x0083 }
        L_0x0083:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.util.NetUtil.getLocalDns(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> getDomainIp(java.lang.String r12) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "useTime"
            java.lang.String r2 = "remoteInet"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4 = 0
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0039, all -> 0x0036 }
            java.net.InetAddress[] r12 = java.net.InetAddress.getAllByName(r12)     // Catch:{ UnknownHostException -> 0x0034, all -> 0x0036 }
            if (r12 == 0) goto L_0x002d
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x002b }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x002b }
            r9.<init>()     // Catch:{ UnknownHostException -> 0x002b }
            long r7 = r7 - r5
            r9.append(r7)     // Catch:{ UnknownHostException -> 0x002b }
            r9.append(r0)     // Catch:{ UnknownHostException -> 0x002b }
            java.lang.String r4 = r9.toString()     // Catch:{ UnknownHostException -> 0x002b }
            goto L_0x002d
        L_0x002b:
            r7 = move-exception
            goto L_0x003d
        L_0x002d:
            r3.put(r2, r12)
            r3.put(r1, r4)
            goto L_0x005a
        L_0x0034:
            r7 = move-exception
            goto L_0x003c
        L_0x0036:
            r0 = move-exception
            r12 = r4
            goto L_0x0061
        L_0x0039:
            r7 = move-exception
            r5 = 0
        L_0x003c:
            r12 = r4
        L_0x003d:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r10.<init>()     // Catch:{ all -> 0x005d }
            long r8 = r8 - r5
            r10.append(r8)     // Catch:{ all -> 0x005d }
            r10.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r12 = r10.toString()     // Catch:{ all -> 0x005d }
            r7.printStackTrace()     // Catch:{ all -> 0x005b }
            r3.put(r2, r4)
            r3.put(r1, r12)
        L_0x005a:
            return r3
        L_0x005b:
            r0 = move-exception
            goto L_0x0061
        L_0x005d:
            r0 = move-exception
            r11 = r4
            r4 = r12
            r12 = r11
        L_0x0061:
            r3.put(r2, r4)
            r3.put(r1, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.one.netdetect.util.NetUtil.getDomainIp(java.lang.String):java.util.Map");
    }

    /* renamed from: a */
    private static String m20753a(Context context) {
        return WsgSecInfo.networkType(context);
    }

    public static String getStringFromStream(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        String str = "";
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                str = str + new String(bArr, 0, read, "gbk");
            } catch (IOException e) {
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean isIpAddress(String str) {
        return isIpv4(str) || isIpv6(str);
    }

    public static boolean isIpv4(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 7 && str.length() <= 15) {
            try {
                return Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)").matcher(str.trim()).find();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isIpv6(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == ':') {
                i++;
            }
        }
        if (i > 7) {
            return false;
        }
        if (f29483a.matcher(str).matches()) {
            return true;
        }
        if (i == 7) {
            return f29485c.matcher(str).matches();
        }
        return f29484b.matcher(str).matches();
    }
}
