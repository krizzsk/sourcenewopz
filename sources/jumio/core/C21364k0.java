package jumio.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: jumio.core.k0 */
/* compiled from: RootCheck */
public final class C21364k0 {

    /* renamed from: a */
    public static final String[] f59639a = {StringDeobfuscator.deobfuscate(new byte[]{-112, -24, 54, Ascii.NAK, -60, -21, 55, -112, 4, 6, 53, 99, Ascii.f53594SO, -90, 42, -126, -120, -6, 45, -57, -108, -30, -117}, -8487608571793451177L), StringDeobfuscator.deobfuscate(new byte[]{32, 115, 53, 117, 114, Ascii.f53584CR, 78, -113, 58, 120, 110, 99, 81, -116, 7, -5, Byte.MIN_VALUE, Byte.MIN_VALUE, 78, -80, -118, 34, -79, 79, 100, -2, 41, 82, -118}, -8029906233449326913L), StringDeobfuscator.deobfuscate(new byte[]{-94, Ascii.f53586FF, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, -88, -97, -50, Ascii.DC4, 85, -91, -36, -110, 40, 117, 38, 104, -17, 87, -61}, -3261248787677980597L), StringDeobfuscator.deobfuscate(new byte[]{-125, Byte.MAX_VALUE, 1, -92, Ascii.ESC, 60, Ascii.DC2, 99, -45, 101, -23, -60, -126, 91, -122, -69, 115, -14, 36, 54, 111, 7, -19, -1, -108, -103}, -8395865714933300392L), StringDeobfuscator.deobfuscate(new byte[]{-54, 34, -83, -46, -78, -104, -4, -81, -17, -4, -58, 75, 42, 119, -121, 74, 52, -79, -127, -5, Ascii.f53588GS, -122, 43, 45}, -6153163343165779037L), StringDeobfuscator.deobfuscate(new byte[]{57, 49, 5, 94, -124, -34, -63, 17, -15, 64, 116, -51, -125, Ascii.ESC, 32}, 8911359989896711776L)};

    /* renamed from: b */
    public static final String[] f59640b = {StringDeobfuscator.deobfuscate(new byte[]{-55, -100, 54, -110, -99, 104, -30, -88, -117, 85, 125, -46, 104, -64, -117, 55, Ascii.CAN, -4, 96, 43, -111, 54, -9, 110, -66, 61, Ascii.f53584CR}, 9151558827609761157L), StringDeobfuscator.deobfuscate(new byte[]{80, -66, -64, -127, -18, -35, Ascii.f53588GS, 70, -60, 11, Ascii.SYN, Ascii.f53594SO, 93, -24, -91, 71, 121, -31, 105, -5, -114, 116, -40, 42, -96, -108, -58}, 7367759678796982280L), StringDeobfuscator.deobfuscate(new byte[]{-84, -66, 35, -31, -25, -120, 86, 73, -17, Ascii.f53586FF, 37, -78, -29, -124, 1, -55, 99, 34, -23, -7, 8, -76}, -5465061677096261914L), StringDeobfuscator.deobfuscate(new byte[]{39, 68, -78, -17, 109, -6, -20, -35, 94, 74, -20, 60, -47, -101, 124, 77, -52, -2, 120, 97, -113, -76, -13, 80, 74, -42}, 7767155038365976375L)};

    /* renamed from: a */
    public static boolean m42129a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(StringDeobfuscator.deobfuscate(new byte[]{66, -7, 92, -66, -25, 92, 17, -43, 111, -16, 54, 51, 76}, 7072531674044459636L), "1");
        hashMap.put(StringDeobfuscator.deobfuscate(new byte[]{55, 59, -108, -12, -98, 75, 73, -79, -34}, -2033597383599115943L), "0");
        boolean z = false;
        boolean a = m42130a(context, f59640b) | m42130a(context, f59639a) | false | (m42131a(StringDeobfuscator.deobfuscate(new byte[]{76, Byte.MIN_VALUE}, -602338539832695767L)) || m42133b(StringDeobfuscator.deobfuscate(new byte[]{60, -95}, -19473538672391723L))) | m42132a((Map<String, String>) hashMap);
        String str = Build.TAGS;
        if (str != null && str.contains(StringDeobfuscator.deobfuscate(new byte[]{45, -7, -106, -107, 33, -38, -107, 37, -97}, 948885450557109957L))) {
            z = true;
        }
        return a | z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[SYNTHETIC, Splitter:B:19:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[Catch:{ Exception -> 0x005d }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m42133b(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0052 }
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x0052 }
            r5 = 5
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0052 }
            r6 = 113(0x71, float:1.58E-43)
            r5[r1] = r6     // Catch:{ all -> 0x0052 }
            r6 = -68
            r7 = 1
            r5[r7] = r6     // Catch:{ all -> 0x0052 }
            r6 = -4
            r5[r3] = r6     // Catch:{ all -> 0x0052 }
            r3 = 3
            r6 = -3
            r5[r3] = r6     // Catch:{ all -> 0x0052 }
            r3 = 4
            r6 = 41
            r5[r3] = r6     // Catch:{ all -> 0x0052 }
            r8 = -3585060780676057064(0xce3f4e36e59e7818, double:-8.4399528872688E68)
            java.lang.String r3 = com.jumio.commons.obfuscate.StringDeobfuscator.deobfuscate(r5, r8)     // Catch:{ all -> 0x0052 }
            r4[r1] = r3     // Catch:{ all -> 0x0052 }
            r4[r7] = r10     // Catch:{ all -> 0x0052 }
            java.lang.Process r10 = r2.exec(r4)     // Catch:{ all -> 0x0052 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0050 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0050 }
            java.io.InputStream r4 = r10.getInputStream()     // Catch:{ all -> 0x0050 }
            r3.<init>(r4)     // Catch:{ all -> 0x0050 }
            r2.<init>(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x0047
            r1 = 1
        L_0x0047:
            r10.destroy()     // Catch:{ Exception -> 0x004d }
            r2.close()     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            return r1
        L_0x004e:
            r0 = r2
            goto L_0x0053
        L_0x0050:
            goto L_0x0053
        L_0x0052:
            r10 = r0
        L_0x0053:
            if (r10 == 0) goto L_0x0058
            r10.destroy()     // Catch:{ Exception -> 0x005d }
        L_0x0058:
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21364k0.m42133b(java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m42131a(String str) {
        boolean z = false;
        for (String str2 : System.getenv(StringDeobfuscator.deobfuscate(new byte[]{Ascii.f53593SI, 77, 96, -6}, 5148579034595742065L)).split(":")) {
            z |= new File(str2 + File.separator + str).exists();
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m42130a(Context context, String[] strArr) {
        PackageManager packageManager = context.getPackageManager();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                SystemUtils.getPackageInfo(packageManager, strArr[i], 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                i++;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd A[SYNTHETIC, Splitter:B:30:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[Catch:{ Exception -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9 A[SYNTHETIC, Splitter:B:39:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ce A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m42132a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "\\[("
            r0.append(r1)
            java.util.Set r1 = r10.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r2 = "|"
            r0.append(r2)
            goto L_0x0012
        L_0x0027:
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            r0.deleteCharAt(r1)
            java.lang.String r1 = ")\\]: \\[(.*)\\]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = 0
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r5 = 7
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = 57
            r5[r3] = r6     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = -55
            r5[r2] = r6     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = -61
            r7 = 2
            r5[r7] = r6     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = 3
            r8 = -20
            r5[r6] = r8     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = 4
            r8 = -93
            r5[r6] = r8     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = 5
            r8 = 11
            r5[r6] = r8     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r6 = 6
            r8 = 46
            r5[r6] = r8     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            r8 = 9000845540372033634(0x7ce96d549808b062, double:5.074837535125339E293)
            java.lang.String r5 = com.jumio.commons.obfuscate.StringDeobfuscator.deobfuscate(r5, r8)     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            java.lang.Process r4 = r4.exec(r5)     // Catch:{ Exception -> 0x00c6, all -> 0x00b9 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.io.InputStream r8 = r4.getInputStream()     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
        L_0x0082:
            java.lang.String r1 = r5.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r1 == 0) goto L_0x00a7
            java.util.regex.Matcher r1 = r0.matcher(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            boolean r6 = r1.find()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r6 == 0) goto L_0x0082
            java.lang.String r6 = r1.group(r2)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.Object r6 = r10.get(r6)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r1 = r1.group(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r1 == 0) goto L_0x0082
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            r4.destroy()     // Catch:{ Exception -> 0x00ae }
            r5.close()     // Catch:{ Exception -> 0x00ae }
        L_0x00ae:
            r3 = r2
            goto L_0x00d1
        L_0x00b0:
            r10 = move-exception
            r1 = r5
            goto L_0x00bb
        L_0x00b3:
            r1 = r5
            goto L_0x00c7
        L_0x00b5:
            r10 = move-exception
            goto L_0x00bb
        L_0x00b7:
            goto L_0x00c7
        L_0x00b9:
            r10 = move-exception
            r4 = r1
        L_0x00bb:
            if (r4 == 0) goto L_0x00c0
            r4.destroy()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c0:
            if (r1 == 0) goto L_0x00c5
            r1.close()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c5:
            throw r10
        L_0x00c6:
            r4 = r1
        L_0x00c7:
            if (r4 == 0) goto L_0x00cc
            r4.destroy()     // Catch:{ Exception -> 0x00d1 }
        L_0x00cc:
            if (r1 == 0) goto L_0x00d1
            r1.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21364k0.m42132a(java.util.Map):boolean");
    }
}
