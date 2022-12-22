package com.didichuxing.mas.sdk.quality.report.utils;

import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;

public class TraceRouteWithPing {
    private static final int COUNT = 1;
    private static final String[] DNS_PROPS = {"dhcp.wlan0.dns1", "dhcp.wlan0.dns2", "dhcp.wlan0.dns3", "dhcp.wlan0.dns4", "net.rmnet0.dns1", "net.rmnet0.dns2", "net.rmnet0.dns3", "net.rmnet0.dns4", "net.dns1", "net.dns2"};
    private static final String ELAPSED_TIME = "elapsedTime";
    private static final String EQUALITY_SIGN_PING = "=";
    private static final String ERROR_PING = "transmitted";
    private static final String FROM_PING = "From";
    private static final String GETPROP_COMMAND = "getprop";
    private static final String PARENTHESE_CLOSE_PING = ")";
    private static final String PARENTHESE_OPEN_PING = "(";
    private static final String PERCENT_SIGN_PING = "%";
    private static final String PING = "PING";
    private static final String RECEIVE_PING = "received";
    private static final String SMALL_FROM_PING = "from";
    private static final int TIMEOUT = 10;
    private static final String TIME_PING = "min/avg/max";

    private TraceRouteWithPing() {
    }

    public static String executeTraceroute(String str, int i) {
        return traceRoute(str, i);
    }

    private static String traceRoute(String str, int i) {
        String str2 = "Realm Name To Ping: " + str + "\n";
        int i2 = 0;
        boolean z = false;
        while (i2 < i && !z) {
            i2++;
            String ping = ping(1, 10, i2, str);
            if (i2 == 1) {
                str2 = str2 + "Ip To Ping: " + parseIpToPingFromPing(ping) + "\n";
            }
            String parseIpToPingFromPing = parseIpToPingFromPing(ping);
            String parseIpFromPing = parseIpFromPing(ping);
            str2 = str2 + "ttl: " + i2 + " " + parseIpFromPing + " " + parseElapsedTimeFromPing(ping) + "\n";
            if (parseIpToPingFromPing != null && parseIpToPingFromPing.equals(parseIpFromPing)) {
                z = true;
            }
        }
        return str2;
    }

    public static String ping(int i, int i2, String str) {
        return ping(i, i2, -1, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Process} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc A[SYNTHETIC, Splitter:B:42:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6 A[SYNTHETIC, Splitter:B:47:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String ping(int r5, int r6, int r7, java.lang.String r8) {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            if (r7 >= 0) goto L_0x001d
            java.lang.Object[] r7 = new java.lang.Object[r0]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r7[r2] = r5
            r7[r1] = r8
            java.lang.String r5 = "ping -c %d -w %d %s"
            java.lang.String r5 = java.lang.String.format(r5, r7)
            goto L_0x003a
        L_0x001d:
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r4[r2] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4[r1] = r5
            r4[r0] = r8
            java.lang.String r5 = "ping -c %d -w %d -t %d %s"
            java.lang.String r5 = java.lang.String.format(r5, r4)
        L_0x003a:
            long r6 = java.lang.System.nanoTime()
            r8 = 0
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x004d
            java.lang.Process r5 = r2.exec(r5)     // Catch:{ all -> 0x00c5 }
            goto L_0x004e
        L_0x004d:
            r5 = r1
        L_0x004e:
            if (r5 == 0) goto L_0x00b0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00ab }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ab }
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ all -> 0x00ab }
            r3.<init>(r4)     // Catch:{ all -> 0x00ab }
            r2.<init>(r3)     // Catch:{ all -> 0x00ab }
        L_0x005e:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x0093
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r3.<init>()     // Catch:{ all -> 0x00a9 }
            r3.append(r0)     // Catch:{ all -> 0x00a9 }
            r3.append(r1)     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "From"
            boolean r3 = r1.contains(r3)     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x0088
            java.lang.String r3 = "from"
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x005e
        L_0x0088:
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00a9 }
            long r3 = r3 - r6
            float r8 = (float) r3     // Catch:{ all -> 0x00a9 }
            r1 = 1232348160(0x49742400, float:1000000.0)
            float r8 = r8 / r1
            goto L_0x005e
        L_0x0093:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r6.<init>()     // Catch:{ all -> 0x00a9 }
            r6.append(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.String r7 = " elapsedTime: "
            r6.append(r7)     // Catch:{ all -> 0x00a9 }
            r6.append(r8)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00a9 }
            r1 = r2
            goto L_0x00b0
        L_0x00a9:
            r6 = move-exception
            goto L_0x00ad
        L_0x00ab:
            r6 = move-exception
            r2 = r1
        L_0x00ad:
            r1 = r5
            r5 = r6
            goto L_0x00c7
        L_0x00b0:
            if (r1 == 0) goto L_0x00ba
            r1.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ba:
            if (r5 == 0) goto L_0x00e9
            r5.destroy()     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00e9
        L_0x00c0:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x00e9
        L_0x00c5:
            r5 = move-exception
            r2 = r1
        L_0x00c7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r6.<init>()     // Catch:{ all -> 0x00ea }
            r6.append(r0)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00ea }
            r6.append(r5)     // Catch:{ all -> 0x00ea }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00ea }
            if (r2 == 0) goto L_0x00e4
            r2.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            r1.destroy()     // Catch:{ Exception -> 0x00c0 }
        L_0x00e9:
            return r0
        L_0x00ea:
            r5 = move-exception
            if (r2 == 0) goto L_0x00f5
            r2.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f5
        L_0x00f1:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f5:
            if (r1 == 0) goto L_0x00ff
            r1.destroy()     // Catch:{ Exception -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ff:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing.ping(int, int, int, java.lang.String):java.lang.String");
    }

    public static String parseIpFromPing(String str) {
        int i;
        int i2;
        if (str == null) {
            return "";
        }
        try {
            if (str.length() < 1) {
                return "";
            }
            if (str.contains("From")) {
                String substring = str.substring(str.indexOf("From") + 5);
                if (substring.contains(PARENTHESE_OPEN_PING)) {
                    return substring.substring(substring.indexOf(PARENTHESE_OPEN_PING) + 1, substring.indexOf(PARENTHESE_CLOSE_PING));
                }
                String substring2 = substring.substring(0, substring.indexOf("\n"));
                if (substring2.contains(":")) {
                    i2 = substring2.indexOf(":");
                } else {
                    i2 = substring2.indexOf(" ");
                }
                return substring2.substring(0, i2);
            } else if (str.contains("from")) {
                String substring3 = str.substring(str.indexOf("from") + 5);
                if (substring3.contains(PARENTHESE_OPEN_PING)) {
                    return substring3.substring(substring3.indexOf(PARENTHESE_OPEN_PING) + 1, substring3.indexOf(PARENTHESE_CLOSE_PING));
                }
                String substring4 = substring3.substring(0, substring3.indexOf("\n"));
                if (substring4.contains(":")) {
                    i = substring4.indexOf(":");
                } else {
                    i = substring4.indexOf(" ");
                }
                return substring4.substring(0, i);
            } else if (str.contains(PING)) {
                return parseIpToPingFromPing(str);
            } else {
                return "*";
            }
        } catch (Exception unused) {
            OLog.m34418e("parseIpFromPing error");
            return "*";
        }
    }

    private static String parseIpToPingFromPing(String str) {
        if (str != null && str.contains(PING)) {
            int indexOf = str.indexOf(PARENTHESE_OPEN_PING);
            int indexOf2 = str.indexOf(PARENTHESE_CLOSE_PING);
            if (indexOf > -1 && indexOf2 > indexOf && indexOf2 <= str.length()) {
                return str.substring(indexOf + 1, indexOf2);
            }
        }
        return "";
    }

    public static float parseAvgTimeFromPing(String str) {
        try {
            if (!str.contains(TIME_PING)) {
                return 0.0f;
            }
            String trim = str.substring(str.indexOf(TIME_PING) + 11).trim();
            String trim2 = trim.substring(trim.indexOf("=") + 1).trim();
            String trim3 = trim2.substring(0, trim2.indexOf(" ")).trim();
            String substring = trim3.substring(trim3.indexOf("/") + 1);
            return Float.parseFloat(substring.substring(0, substring.indexOf("/")).trim());
        } catch (Exception unused) {
            OLog.m34418e("parseAllTimeFromPing error");
            return 0.0f;
        }
    }

    public static float parseErrorRatio(String str) {
        try {
            if (!str.contains(ERROR_PING)) {
                return 0.0f;
            }
            String substring = str.substring(str.indexOf(RECEIVE_PING) + 9);
            return Float.parseFloat(substring.substring(0, substring.indexOf("%")).trim());
        } catch (NumberFormatException unused) {
            OLog.m34418e("parseErrorRatio NumberFormatException");
            return 0.0f;
        } catch (Exception unused2) {
            OLog.m34418e("parseErrorRatio error");
            return 0.0f;
        }
    }

    private String parseTimeFromPing(String str) {
        if (!str.contains(TIME_PING)) {
            return "";
        }
        String substring = str.substring(str.indexOf(TIME_PING) + 5);
        return substring.substring(0, substring.indexOf(" "));
    }

    private static String parseElapsedTimeFromPing(String str) {
        if (str == null || !str.contains(ELAPSED_TIME)) {
            return "";
        }
        String substring = str.substring(str.indexOf(ELAPSED_TIME));
        return substring.substring(substring.lastIndexOf(" "));
    }

    public static String getDNS() {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : DNS_PROPS) {
                String excuteCommand = excuteCommand("getprop " + str);
                if (!TextUtils.isEmpty(excuteCommand)) {
                    if (!arrayList.contains(excuteCommand)) {
                        arrayList.add(excuteCommand);
                    }
                }
            }
        } catch (Exception unused) {
            OLog.m34418e("getDNS error");
        }
        return arrayList.toString().replace(Const.jaLeft, "").replace(Const.jaRight, "");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Process} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073 A[SYNTHETIC, Splitter:B:33:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007d A[SYNTHETIC, Splitter:B:38:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String excuteCommand(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x000e
            java.lang.Process r6 = r2.exec(r6)     // Catch:{ all -> 0x005c }
            goto L_0x000f
        L_0x000e:
            r6 = r1
        L_0x000f:
            if (r6 == 0) goto L_0x0047
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0041 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0041 }
            java.io.InputStream r4 = r6.getInputStream()     // Catch:{ all -> 0x0041 }
            r3.<init>(r4)     // Catch:{ all -> 0x0041 }
            r2.<init>(r3)     // Catch:{ all -> 0x0041 }
        L_0x001f:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r3.<init>()     // Catch:{ all -> 0x003c }
            r3.append(r0)     // Catch:{ all -> 0x003c }
            r3.append(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r1 = "\n"
            r3.append(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x003c }
            goto L_0x001f
        L_0x003a:
            r1 = r2
            goto L_0x0047
        L_0x003c:
            r1 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x005e
        L_0x0041:
            r2 = move-exception
            r5 = r1
            r1 = r6
            r6 = r2
            r2 = r5
            goto L_0x005e
        L_0x0047:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0051:
            if (r6 == 0) goto L_0x0080
            r6.destroy()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0080
        L_0x0057:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0080
        L_0x005c:
            r6 = move-exception
            r2 = r1
        L_0x005e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r3.<init>()     // Catch:{ all -> 0x0085 }
            r3.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0085 }
            r3.append(r6)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007b:
            if (r1 == 0) goto L_0x0080
            r1.destroy()     // Catch:{ Exception -> 0x0057 }
        L_0x0080:
            java.lang.String r6 = r0.trim()
            return r6
        L_0x0085:
            r6 = move-exception
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0090:
            if (r1 == 0) goto L_0x009a
            r1.destroy()     // Catch:{ Exception -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing.excuteCommand(java.lang.String):java.lang.String");
    }
}
