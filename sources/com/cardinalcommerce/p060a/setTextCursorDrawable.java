package com.cardinalcommerce.p060a;

import android.content.Context;
import android.os.Debug;
import com.cardinalcommerce.shared.models.Warning;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setTextCursorDrawable */
public final class setTextCursorDrawable {

    /* renamed from: f */
    private static int f3006f = 0;

    /* renamed from: g */
    private static int f3007g = 1;
    public JSONArray Cardinal;

    /* renamed from: a */
    private final boolean f3008a = m2100a();

    /* renamed from: b */
    private final boolean f3009b = m2104d();

    /* renamed from: c */
    private final boolean f3010c = m2103c();
    public List<Warning> cca_continue;

    /* renamed from: d */
    private final boolean f3011d = m2102b();

    /* renamed from: e */
    private final boolean f3012e;
    public boolean init;

    public setTextCursorDrawable(boolean z, Context context) {
        this.init = z;
        this.f3012e = m2101a(context);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        if (this.f3009b) {
            jSONArray.put("SW01");
            arrayList.add(new Warning("SW01", "The device is jailbroken.", setAutoSizeTextTypeWithDefaults.HIGH));
        }
        if (this.init) {
            jSONArray.put("SW02");
            arrayList.add(new Warning("SW02", "The integrity of the SDK has been tampered.", setAutoSizeTextTypeWithDefaults.HIGH));
        }
        if (this.f3008a) {
            jSONArray.put("SW03");
            arrayList.add(new Warning("SW03", "An emulator is being used to run the App.", setAutoSizeTextTypeWithDefaults.HIGH));
        }
        if (this.f3010c) {
            jSONArray.put("SW04");
            arrayList.add(new Warning("SW04", "A debugger is attached to the App.", setAutoSizeTextTypeWithDefaults.MEDIUM));
        }
        if (!this.f3011d) {
            jSONArray.put("SW05");
            arrayList.add(new Warning("SW05", "The OS or the OS version is not supported.", setAutoSizeTextTypeWithDefaults.HIGH));
        }
        if (!this.f3012e) {
            jSONArray.put("SW06");
            arrayList.add(new Warning("SW06", "The App is not installed from trusted source.", setAutoSizeTextTypeWithDefaults.HIGH));
        }
        this.Cardinal = jSONArray;
        this.cca_continue = arrayList;
    }

    /* renamed from: a */
    private boolean m2101a(Context context) {
        boolean contains = new ArrayList<String>() {
            {
                add("com.android.vending");
                add("com.amazon.venezia");
                add("com.sec.android.app.samsungapps");
                add("com.amazon.mshop.android");
            }
        }.contains(context.getPackageManager().getInstallerPackageName(context.getPackageName()));
        int i = f3006f;
        int i2 = i & 9;
        int i3 = ((((i ^ 9) | i2) << 1) - (~(-((i | 9) & (~i2))))) - 1;
        f3007g = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return contains;
        }
        Object obj = null;
        super.hashCode();
        return contains;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01cd, code lost:
        if ((!r1 ? 23 : '5') != 23) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e0, code lost:
        if ((android.os.Build.PRODUCT.contains("sdk_google")) != false) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        if ((!android.os.Build.DEVICE.startsWith("generic")) != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0246, code lost:
        if ((!r1 ? 'V' : 15) != 15) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x025a, code lost:
        if ((!android.os.Build.PRODUCT.contains("sdk_x86") ? '^' : org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_ZERO) != 'Z') goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02a2, code lost:
        if ((!android.os.Build.PRODUCT.contains("emulator") ? org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_ZERO : '@') != 'Z') goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02b9, code lost:
        if ((!android.os.Build.PRODUCT.contains("emulator") ? '3' : 12) != '3') goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
        if ((!android.os.Build.HARDWARE.contains("goldfish") ? (char) 2 : 24) != 2) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if ((!r1) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        if ((!android.os.Build.MODEL.contains("google_sdk") ? (char) 25 : 31) != 25) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011e, code lost:
        if ((!android.os.Build.MODEL.contains("google_sdk") ? 'I' : '\'') != 'I') goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0186, code lost:
        if ((!android.os.Build.MANUFACTURER.contains("Genymotion") ? org.osgi.framework.VersionRange.RIGHT_OPEN : 'W') != ')') goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x019a, code lost:
        if ((android.os.Build.MANUFACTURER.contains("Genymotion")) != false) goto L_0x0308;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2100a() {
        /*
            int r0 = f3006f
            r1 = r0 ^ 73
            r2 = 73
            r0 = r0 & r2
            r3 = 1
            int r0 = r0 << r3
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3007g = r0
            r0 = 2
            int r1 = r1 % r0
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r4 = "generic"
            boolean r1 = r1.startsWith(r4)
            r5 = 8
            r6 = 82
            if (r1 == 0) goto L_0x0021
            r1 = 82
            goto L_0x0023
        L_0x0021:
            r1 = 8
        L_0x0023:
            r7 = 31
            r8 = 0
            if (r1 == r6) goto L_0x0029
            goto L_0x004d
        L_0x0029:
            int r1 = f3006f
            r9 = r1 ^ 35
            r10 = r1 & 35
            r9 = r9 | r10
            int r9 = r9 << r3
            int r10 = ~r10
            r1 = r1 | 35
            r1 = r1 & r10
            int r1 = -r1
            r10 = r9 | r1
            int r10 = r10 << r3
            r1 = r1 ^ r9
            int r10 = r10 - r1
            int r1 = r10 % 128
            f3007g = r1
            int r10 = r10 % r0
            java.lang.String r1 = android.os.Build.DEVICE
            boolean r1 = r1.startsWith(r4)
            if (r1 != 0) goto L_0x004a
            r1 = 1
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            if (r1 == 0) goto L_0x0308
        L_0x004d:
            java.lang.String r1 = android.os.Build.FINGERPRINT
            boolean r1 = r1.startsWith(r4)
            r4 = 14
            if (r1 != 0) goto L_0x005a
            r1 = 14
            goto L_0x005c
        L_0x005a:
            r1 = 55
        L_0x005c:
            if (r1 == r4) goto L_0x0060
            goto L_0x0308
        L_0x0060:
            int r1 = f3006f
            r4 = r1 | 31
            int r9 = r4 << 1
            r1 = r1 & r7
            int r1 = ~r1
            r1 = r1 & r4
            int r1 = -r1
            r4 = r9 | r1
            int r4 = r4 << r3
            r1 = r1 ^ r9
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3007g = r1
            int r4 = r4 % r0
            java.lang.String r1 = android.os.Build.FINGERPRINT
            java.lang.String r4 = "unknown"
            boolean r1 = r1.startsWith(r4)
            if (r1 != 0) goto L_0x0080
            r1 = 0
            goto L_0x0081
        L_0x0080:
            r1 = 1
        L_0x0081:
            if (r1 == 0) goto L_0x0085
            goto L_0x0308
        L_0x0085:
            int r1 = f3006f
            r4 = r1 ^ 6
            r1 = r1 & 6
            int r1 = r1 << r3
            int r4 = r4 + r1
            int r4 = r4 - r3
            int r1 = r4 % 128
            f3007g = r1
            int r4 = r4 % r0
            r1 = 67
            if (r4 != 0) goto L_0x009a
            r4 = 67
            goto L_0x009c
        L_0x009a:
            r4 = 57
        L_0x009c:
            r9 = 24
            java.lang.String r10 = "goldfish"
            r11 = 0
            if (r4 == r1) goto L_0x00b3
            java.lang.String r1 = android.os.Build.HARDWARE
            boolean r1 = r1.contains(r10)
            if (r1 != 0) goto L_0x00ad
            r1 = 2
            goto L_0x00af
        L_0x00ad:
            r1 = 24
        L_0x00af:
            if (r1 == r0) goto L_0x00c1
            goto L_0x0308
        L_0x00b3:
            java.lang.String r1 = android.os.Build.HARDWARE
            boolean r1 = r1.contains(r10)
            int r4 = r11.length     // Catch:{ all -> 0x0306 }
            if (r1 != 0) goto L_0x00be
            r1 = 1
            goto L_0x00bf
        L_0x00be:
            r1 = 0
        L_0x00bf:
            if (r1 == 0) goto L_0x0308
        L_0x00c1:
            int r1 = f3006f
            r4 = r1 & 71
            r1 = r1 | 71
            int r4 = r4 + r1
            int r1 = r4 % 128
            f3007g = r1
            int r4 = r4 % r0
            java.lang.String r1 = android.os.Build.HARDWARE
            java.lang.String r4 = "ranchu"
            boolean r1 = r1.contains(r4)
            r4 = 77
            r10 = 43
            if (r1 != 0) goto L_0x00de
            r1 = 77
            goto L_0x00e0
        L_0x00de:
            r1 = 43
        L_0x00e0:
            if (r1 == r4) goto L_0x00e4
            goto L_0x0308
        L_0x00e4:
            int r1 = f3006f
            r4 = r1 & 18
            r1 = r1 | 18
            int r4 = r4 + r1
            int r4 = r4 - r8
            int r4 = r4 - r3
            int r1 = r4 % 128
            f3007g = r1
            int r4 = r4 % r0
            if (r4 != 0) goto L_0x00f6
            r1 = 1
            goto L_0x00f7
        L_0x00f6:
            r1 = 0
        L_0x00f7:
            java.lang.String r4 = "google_sdk"
            if (r1 == r3) goto L_0x010e
            java.lang.String r1 = android.os.Build.MODEL
            boolean r1 = r1.contains(r4)
            r2 = 25
            if (r1 != 0) goto L_0x0108
            r1 = 25
            goto L_0x010a
        L_0x0108:
            r1 = 31
        L_0x010a:
            if (r1 == r2) goto L_0x0122
            goto L_0x0308
        L_0x010e:
            java.lang.String r1 = android.os.Build.MODEL
            boolean r1 = r1.contains(r4)
            r12 = 34
            int r12 = r12 / r8
            if (r1 != 0) goto L_0x011c
            r1 = 73
            goto L_0x011e
        L_0x011c:
            r1 = 39
        L_0x011e:
            if (r1 == r2) goto L_0x0122
            goto L_0x0308
        L_0x0122:
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.String r2 = "Emulator"
            boolean r1 = r1.contains(r2)
            r2 = 60
            if (r1 != 0) goto L_0x012f
            goto L_0x0131
        L_0x012f:
            r9 = 60
        L_0x0131:
            if (r9 == r2) goto L_0x0308
            int r1 = f3006f
            r2 = r1 & 87
            int r9 = ~r2
            r1 = r1 | 87
            r1 = r1 & r9
            int r2 = r2 << r3
            int r2 = -r2
            int r2 = -r2
            r9 = r1 ^ r2
            r1 = r1 & r2
            int r1 = r1 << r3
            int r9 = r9 + r1
            int r1 = r9 % 128
            f3007g = r1
            int r9 = r9 % r0
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.String r2 = "Android SDK built for x86"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0154
            r1 = 0
            goto L_0x0155
        L_0x0154:
            r1 = 1
        L_0x0155:
            if (r1 == 0) goto L_0x0159
            goto L_0x0308
        L_0x0159:
            int r1 = f3007g
            r2 = r1 ^ 15
            r9 = r1 & 15
            r2 = r2 | r9
            int r2 = r2 << r3
            int r9 = ~r9
            r12 = 15
            r1 = r1 | r12
            r1 = r1 & r9
            int r2 = r2 - r1
            int r1 = r2 % 128
            f3006f = r1
            int r2 = r2 % r0
            if (r2 == 0) goto L_0x0171
            r1 = 8
            goto L_0x0173
        L_0x0171:
            r1 = 54
        L_0x0173:
            if (r1 == r5) goto L_0x018a
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r2 = "Genymotion"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0182
            r1 = 41
            goto L_0x0184
        L_0x0182:
            r1 = 87
        L_0x0184:
            r2 = 41
            if (r1 == r2) goto L_0x019e
            goto L_0x0308
        L_0x018a:
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r2 = "Genymotion"
            boolean r1 = r1.contains(r2)
            r2 = 39
            int r2 = r2 / r8
            if (r1 != 0) goto L_0x0199
            r1 = 0
            goto L_0x019a
        L_0x0199:
            r1 = 1
        L_0x019a:
            if (r1 == 0) goto L_0x019e
            goto L_0x0308
        L_0x019e:
            int r1 = f3006f
            r2 = r1 ^ 17
            r5 = r1 & 17
            r2 = r2 | r5
            int r2 = r2 << r3
            int r5 = ~r5
            r1 = r1 | 17
            r1 = r1 & r5
            int r1 = -r1
            r5 = r2 & r1
            r1 = r1 | r2
            int r5 = r5 + r1
            int r1 = r5 % 128
            f3007g = r1
            int r5 = r5 % r0
            if (r5 != 0) goto L_0x01b8
            r1 = 1
            goto L_0x01b9
        L_0x01b8:
            r1 = 0
        L_0x01b9:
            if (r1 == 0) goto L_0x01d3
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "sdk_google"
            boolean r1 = r1.contains(r2)
            int r2 = r11.length     // Catch:{ all -> 0x01d1 }
            if (r1 != 0) goto L_0x01c9
            r1 = 23
            goto L_0x01cb
        L_0x01c9:
            r1 = 53
        L_0x01cb:
            r2 = 23
            if (r1 == r2) goto L_0x01e4
            goto L_0x0308
        L_0x01d1:
            r0 = move-exception
            throw r0
        L_0x01d3:
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "sdk_google"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x01df
            r1 = 0
            goto L_0x01e0
        L_0x01df:
            r1 = 1
        L_0x01e0:
            if (r1 == 0) goto L_0x01e4
            goto L_0x0308
        L_0x01e4:
            java.lang.String r1 = android.os.Build.PRODUCT
            boolean r1 = r1.contains(r4)
            if (r1 != 0) goto L_0x01ee
            r1 = 1
            goto L_0x01ef
        L_0x01ee:
            r1 = 0
        L_0x01ef:
            if (r1 == r3) goto L_0x01f3
            goto L_0x0308
        L_0x01f3:
            int r1 = f3007g
            r2 = r1 & 13
            r1 = r1 ^ 13
            r1 = r1 | r2
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 - r3
            int r1 = r2 % 128
            f3006f = r1
            int r2 = r2 % r0
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "sdk"
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0211
            r1 = 91
            goto L_0x0213
        L_0x0211:
            r1 = 63
        L_0x0213:
            r2 = 91
            if (r1 == r2) goto L_0x0219
            goto L_0x0308
        L_0x0219:
            int r1 = f3007g
            r2 = r1 & 89
            r1 = r1 | 89
            int r1 = -r1
            int r1 = -r1
            r4 = r2 | r1
            int r4 = r4 << r3
            r1 = r1 ^ r2
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3006f = r1
            int r4 = r4 % r0
            if (r4 == 0) goto L_0x022f
            r1 = 1
            goto L_0x0230
        L_0x022f:
            r1 = 0
        L_0x0230:
            r2 = 90
            if (r1 == 0) goto L_0x024b
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r4 = "sdk_x86"
            boolean r1 = r1.contains(r4)
            super.hashCode()     // Catch:{ all -> 0x0249 }
            if (r1 != 0) goto L_0x0244
            r1 = 86
            goto L_0x0246
        L_0x0244:
            r1 = 15
        L_0x0246:
            if (r1 == r12) goto L_0x0308
            goto L_0x025c
        L_0x0249:
            r0 = move-exception
            throw r0
        L_0x024b:
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r4 = "sdk_x86"
            boolean r1 = r1.contains(r4)
            if (r1 != 0) goto L_0x0258
            r1 = 94
            goto L_0x025a
        L_0x0258:
            r1 = 90
        L_0x025a:
            if (r1 == r2) goto L_0x0308
        L_0x025c:
            int r1 = f3007g
            r4 = r1 & 69
            int r5 = ~r4
            r1 = r1 | 69
            r1 = r1 & r5
            int r4 = r4 << r3
            int r4 = -r4
            int r4 = -r4
            r5 = r1 ^ r4
            r1 = r1 & r4
            int r1 = r1 << r3
            int r5 = r5 + r1
            int r1 = r5 % 128
            f3006f = r1
            int r5 = r5 % r0
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r4 = "vbox86p"
            boolean r1 = r1.contains(r4)
            if (r1 != 0) goto L_0x027d
            r1 = 1
            goto L_0x027e
        L_0x027d:
            r1 = 0
        L_0x027e:
            if (r1 == r3) goto L_0x0282
            goto L_0x0308
        L_0x0282:
            int r1 = f3006f
            int r1 = r1 + 122
            int r1 = r1 - r3
            int r4 = r1 % 128
            f3007g = r4
            int r1 = r1 % r0
            if (r1 != 0) goto L_0x0290
            r1 = 1
            goto L_0x0291
        L_0x0290:
            r1 = 0
        L_0x0291:
            if (r1 == r3) goto L_0x02a5
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r4 = "emulator"
            boolean r1 = r1.contains(r4)
            if (r1 != 0) goto L_0x02a0
            r1 = 90
            goto L_0x02a2
        L_0x02a0:
            r1 = 64
        L_0x02a2:
            if (r1 == r2) goto L_0x02bc
            goto L_0x0308
        L_0x02a5:
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "emulator"
            boolean r1 = r1.contains(r2)
            r2 = 14
            int r2 = r2 / r8
            if (r1 != 0) goto L_0x02b5
            r1 = 51
            goto L_0x02b7
        L_0x02b5:
            r1 = 12
        L_0x02b7:
            r2 = 51
            if (r1 == r2) goto L_0x02bc
            goto L_0x0308
        L_0x02bc:
            int r1 = f3007g
            r2 = r1 & -44
            int r4 = ~r1
            r4 = r4 & r10
            r2 = r2 | r4
            r1 = r1 & r10
            int r1 = r1 << r3
            int r1 = -r1
            int r1 = -r1
            r4 = r2 | r1
            int r4 = r4 << r3
            r1 = r1 ^ r2
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3006f = r1
            int r4 = r4 % r0
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r2 = "simulator"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x02dd
            r1 = 0
            goto L_0x02de
        L_0x02dd:
            r1 = 1
        L_0x02de:
            if (r1 == r3) goto L_0x02e1
            goto L_0x0308
        L_0x02e1:
            int r1 = f3006f
            r2 = r1 ^ 117(0x75, float:1.64E-43)
            r1 = r1 & 117(0x75, float:1.64E-43)
            int r1 = r1 << r3
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 - r3
            int r1 = r2 % 128
            f3007g = r1
            int r2 = r2 % r0
            if (r2 != 0) goto L_0x02f5
            r0 = 82
            goto L_0x02f7
        L_0x02f5:
            r0 = 80
        L_0x02f7:
            if (r0 == r6) goto L_0x02fa
            return r8
        L_0x02fa:
            super.hashCode()     // Catch:{ all -> 0x02fe }
            return r8
        L_0x02fe:
            r0 = move-exception
            throw r0
        L_0x0300:
            r0 = move-exception
            throw r0
        L_0x0302:
            r0 = move-exception
            throw r0
        L_0x0304:
            r0 = move-exception
            throw r0
        L_0x0306:
            r0 = move-exception
            throw r0
        L_0x0308:
            int r1 = f3006f
            r2 = r1 & 45
            r1 = r1 ^ 45
            r1 = r1 | r2
            r4 = r2 | r1
            int r4 = r4 << r3
            r1 = r1 ^ r2
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3007g = r1
            int r4 = r4 % r0
            if (r4 != 0) goto L_0x031d
            r0 = 0
            goto L_0x031e
        L_0x031d:
            r0 = 1
        L_0x031e:
            if (r0 == r3) goto L_0x0324
            int r7 = r7 / r8
            return r3
        L_0x0322:
            r0 = move-exception
            throw r0
        L_0x0324:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextCursorDrawable.m2100a():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if ((android.os.Build.VERSION.SDK_INT >= 21 ? 'J' : org.osgi.framework.VersionRange.RIGHT_OPEN) != ')') goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        r1 = f3006f;
        r4 = (r1 & -120) | ((~r1) & 119);
        r1 = -(-((r1 & 119) << 1));
        r3 = (r4 ^ r1) + ((r1 & r4) << 1);
        f3007g = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if ((r3 % 2) != 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        if (r1 == true) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if ((android.os.Build.VERSION.SDK_INT >= 48 ? '4' : 7) != '4') goto L_0x005b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2102b() {
        /*
            int r0 = f3007g
            r1 = r0 & -28
            int r2 = ~r0
            r2 = r2 & 27
            r1 = r1 | r2
            r0 = r0 & 27
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3006f = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 == 0) goto L_0x002a
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 48
            r4 = 52
            if (r1 < r3) goto L_0x0026
            r1 = 52
            goto L_0x0027
        L_0x0026:
            r1 = 7
        L_0x0027:
            if (r1 == r4) goto L_0x0039
            goto L_0x005b
        L_0x002a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            r4 = 41
            if (r1 < r3) goto L_0x0035
            r1 = 74
            goto L_0x0037
        L_0x0035:
            r1 = 41
        L_0x0037:
            if (r1 == r4) goto L_0x005b
        L_0x0039:
            int r1 = f3007g
            r3 = r1 | 60
            int r3 = r3 << r2
            r1 = r1 ^ 60
            int r3 = r3 - r1
            int r3 = r3 - r0
            int r3 = r3 - r2
            int r1 = r3 % 128
            f3006f = r1
            int r3 = r3 % 2
            r1 = 26
            if (r3 == 0) goto L_0x0050
            r3 = 81
            goto L_0x0052
        L_0x0050:
            r3 = 26
        L_0x0052:
            if (r3 == r1) goto L_0x005a
            r1 = 54
            int r1 = r1 / r0
            return r2
        L_0x0058:
            r0 = move-exception
            throw r0
        L_0x005a:
            return r2
        L_0x005b:
            int r1 = f3006f
            r3 = 119(0x77, float:1.67E-43)
            r4 = r1 & -120(0xffffffffffffff88, float:NaN)
            int r5 = ~r1
            r5 = r5 & r3
            r4 = r4 | r5
            r1 = r1 & r3
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r3 = r4 ^ r1
            r1 = r1 & r4
            int r1 = r1 << r2
            int r3 = r3 + r1
            int r1 = r3 % 128
            f3007g = r1
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0077
            r1 = 1
            goto L_0x0078
        L_0x0077:
            r1 = 0
        L_0x0078:
            if (r1 == r2) goto L_0x007b
            return r0
        L_0x007b:
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x0080 }
            return r0
        L_0x0080:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextCursorDrawable.m2102b():boolean");
    }

    /* renamed from: c */
    private static boolean m2103c() {
        int i = f3006f;
        int i2 = (((i | 102) << 1) - (i ^ 102)) - 1;
        f3007g = i2 % 128;
        if ((i2 % 2 == 0 ? '?' : ' ') == ' ') {
            return Debug.isDebuggerConnected();
        }
        int i3 = 8 / 0;
        return Debug.isDebuggerConnected();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if ((!r1 ? 'c' : 0) != 'c') goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if ((!m2105e() ? kotlin.text.Typography.greater : org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_UNIX) != '/') goto L_0x0042;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2104d() {
        /*
            int r0 = f3006f
            r1 = r0 & 4
            r0 = r0 | 4
            int r1 = r1 + r0
            r0 = 0
            int r1 = r1 - r0
            r2 = 1
            int r1 = r1 - r2
            int r3 = r1 % 128
            f3007g = r3
            int r1 = r1 % 2
            r3 = 17
            if (r1 != 0) goto L_0x0018
            r1 = 19
            goto L_0x001a
        L_0x0018:
            r1 = 17
        L_0x001a:
            r4 = 0
            r5 = 62
            if (r1 == r3) goto L_0x0033
            boolean r1 = m2105e()
            super.hashCode()     // Catch:{ all -> 0x0031 }
            r3 = 99
            if (r1 != 0) goto L_0x002d
            r1 = 99
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == r3) goto L_0x0042
            goto L_0x008d
        L_0x0031:
            r0 = move-exception
            throw r0
        L_0x0033:
            boolean r1 = m2105e()
            r3 = 47
            if (r1 != 0) goto L_0x003e
            r1 = 62
            goto L_0x0040
        L_0x003e:
            r1 = 47
        L_0x0040:
            if (r1 == r3) goto L_0x008d
        L_0x0042:
            int r1 = f3006f
            r3 = 3
            r6 = r1 & -4
            int r7 = ~r1
            r7 = r7 & r3
            r6 = r6 | r7
            r1 = r1 & r3
            int r1 = r1 << r2
            r3 = r6 & r1
            r1 = r1 | r6
            int r3 = r3 + r1
            int r1 = r3 % 128
            f3007g = r1
            int r3 = r3 % 2
            boolean r1 = m2106f()
            if (r1 != 0) goto L_0x005e
            r1 = 0
            goto L_0x005f
        L_0x005e:
            r1 = 1
        L_0x005f:
            if (r1 == r2) goto L_0x008d
            int r1 = f3006f
            r3 = r1 & 24
            r1 = r1 | 24
            int r3 = r3 + r1
            r1 = r3 & -1
            r3 = r3 | -1
            int r1 = r1 + r3
            int r3 = r1 % 128
            f3007g = r3
            int r1 = r1 % 2
            boolean r1 = m2107g()
            if (r1 == 0) goto L_0x007c
            r1 = 27
            goto L_0x007e
        L_0x007c:
            r1 = 62
        L_0x007e:
            if (r1 == r5) goto L_0x0081
            goto L_0x008d
        L_0x0081:
            int r1 = f3006f
            int r1 = r1 + 42
            int r1 = r1 - r2
            int r2 = r1 % 128
            f3007g = r2
            int r1 = r1 % 2
            return r0
        L_0x008d:
            int r0 = f3006f
            r1 = 23
            r3 = r0 | 23
            int r3 = r3 << r2
            r5 = r0 & -24
            int r0 = ~r0
            r0 = r0 & r1
            r0 = r0 | r5
            int r0 = -r0
            r1 = r3 | r0
            int r1 = r1 << r2
            r0 = r0 ^ r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f3007g = r0
            int r1 = r1 % 2
            r0 = 77
            if (r1 != 0) goto L_0x00ac
            r1 = 77
            goto L_0x00ae
        L_0x00ac:
            r1 = 41
        L_0x00ae:
            if (r1 == r0) goto L_0x00b1
            return r2
        L_0x00b1:
            int r0 = r4.length     // Catch:{ all -> 0x00b3 }
            return r2
        L_0x00b3:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextCursorDrawable.m2104d():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if ((r2 != null ? 'N' : 'C') != 'C') goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if ((r2 != null ? (char) 1 : 18) != 18) goto L_0x003c;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2105e() {
        /*
            int r0 = f3006f
            r1 = r0 & 123(0x7b, float:1.72E-43)
            r0 = r0 ^ 123(0x7b, float:1.72E-43)
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3007g = r0
            int r2 = r2 % 2
            r0 = 0
            r1 = 1
            if (r2 != 0) goto L_0x0019
            r2 = 0
            goto L_0x001a
        L_0x0019:
            r2 = 1
        L_0x001a:
            r3 = 0
            if (r2 == r1) goto L_0x0030
            java.lang.String r2 = android.os.Build.TAGS
            super.hashCode()     // Catch:{ all -> 0x002e }
            r4 = 67
            if (r2 == 0) goto L_0x0029
            r5 = 78
            goto L_0x002b
        L_0x0029:
            r5 = 67
        L_0x002b:
            if (r5 == r4) goto L_0x0089
            goto L_0x003c
        L_0x002e:
            r0 = move-exception
            throw r0
        L_0x0030:
            java.lang.String r2 = android.os.Build.TAGS
            r4 = 18
            if (r2 == 0) goto L_0x0038
            r5 = 1
            goto L_0x003a
        L_0x0038:
            r5 = 18
        L_0x003a:
            if (r5 == r4) goto L_0x0089
        L_0x003c:
            java.lang.String r4 = "test-keys"
            boolean r2 = r2.contains(r4)
            r4 = 93
            if (r2 == 0) goto L_0x0049
            r2 = 93
            goto L_0x004b
        L_0x0049:
            r2 = 54
        L_0x004b:
            if (r2 == r4) goto L_0x004e
            goto L_0x0089
        L_0x004e:
            int r2 = f3007g
            r4 = r2 & 69
            r2 = r2 ^ 69
            r2 = r2 | r4
            r5 = r4 ^ r2
            r2 = r2 & r4
            int r2 = r2 << r1
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3006f = r2
            int r5 = r5 % 2
            r2 = 65
            if (r5 == 0) goto L_0x0067
            r4 = 55
            goto L_0x0069
        L_0x0067:
            r4 = 65
        L_0x0069:
            int r2 = f3007g
            r4 = r2 & 29
            r2 = r2 ^ 29
            r2 = r2 | r4
            int r2 = -r2
            int r2 = -r2
            r5 = r4 ^ r2
            r2 = r2 & r4
            int r2 = r2 << r1
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3006f = r2
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0080
            r0 = 1
        L_0x0080:
            if (r0 == 0) goto L_0x0088
            super.hashCode()     // Catch:{ all -> 0x0086 }
            return r1
        L_0x0086:
            r0 = move-exception
            throw r0
        L_0x0088:
            return r1
        L_0x0089:
            int r2 = f3006f
            r3 = r2 ^ 83
            r4 = r2 & 83
            r3 = r3 | r4
            int r3 = r3 << r1
            int r4 = ~r4
            r2 = r2 | 83
            r2 = r2 & r4
            int r2 = -r2
            r4 = r3 | r2
            int r1 = r4 << 1
            r2 = r2 ^ r3
            int r1 = r1 - r2
            int r2 = r1 % 128
            f3007g = r2
            int r1 = r1 % 2
            r2 = 90
            if (r1 != 0) goto L_0x00a9
            r1 = 90
            goto L_0x00ab
        L_0x00a9:
            r1 = 80
        L_0x00ab:
            if (r1 == r2) goto L_0x00ae
            return r0
        L_0x00ae:
            r1 = 78
            int r1 = r1 / r0
            return r0
        L_0x00b2:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextCursorDrawable.m2105e():boolean");
    }

    /* renamed from: f */
    private static boolean m2106f() {
        int i = (((f3006f + 69) - 1) - 0) - 1;
        f3007g = i % 128;
        int i2 = i % 2;
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int i3 = f3007g;
        int i4 = i3 & 59;
        int i5 = -(-((i3 ^ 59) | i4));
        int i6 = ((i4 | i5) << 1) - (i5 ^ i4);
        f3006f = i6 % 128;
        int i7 = i6 % 2;
        int i8 = 0;
        while (i8 < 10) {
            if (!new File(strArr[i8]).exists()) {
                i8++;
                int i9 = f3006f;
                int i10 = i9 & 73;
                int i11 = (i10 - (~(-(-((i9 ^ 73) | i10))))) - 1;
                f3007g = i11 % 128;
                int i12 = i11 % 2;
            } else {
                int i13 = f3006f;
                int i14 = (i13 & 64) + (i13 | 64);
                int i15 = (i14 ^ -1) + ((i14 & -1) << 1);
                f3007g = i15 % 128;
                boolean z = (i15 % 2 == 0 ? 1 : '9') == '9';
                int i16 = f3007g;
                int i17 = i16 & 81;
                int i18 = (i17 - (~((i16 ^ 81) | i17))) - 1;
                f3006f = i18 % 128;
                if ((i18 % 2 != 0 ? (char) 16 : 14) != 16) {
                    return z;
                }
                int i19 = 91 / 0;
                return z;
            }
        }
        int i20 = f3007g;
        int i21 = ((i20 | 60) << 1) - (i20 ^ 60);
        int i22 = ((i21 | -1) << 1) - (i21 ^ -1);
        f3006f = i22 % 128;
        if ((i22 % 2 != 0 ? 17 : '?') == '?') {
            return false;
        }
        int i23 = 47 / 0;
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Process} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0 A[RETURN] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2107g() {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "/system/xbin/which"
            java.lang.String r5 = "su"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch:{ all -> 0x00b5 }
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ all -> 0x00b5 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00b3 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x00b3 }
            java.io.InputStream r6 = r3.getInputStream()     // Catch:{ all -> 0x00b3 }
            r5.<init>(r6)     // Catch:{ all -> 0x00b3 }
            r4.<init>(r5)     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = r4.readLine()     // Catch:{ all -> 0x00b3 }
            r5 = 79
            r6 = 13
            if (r4 == 0) goto L_0x002e
            r4 = 79
            goto L_0x0030
        L_0x002e:
            r4 = 13
        L_0x0030:
            if (r4 == r6) goto L_0x0050
            int r4 = f3007g
            r7 = r4 & 73
            r4 = r4 ^ 73
            r4 = r4 | r7
            int r7 = r7 + r4
            int r4 = r7 % 128
            f3006f = r4
            int r7 = r7 % 2
            int r4 = f3006f
            r7 = r4 ^ 77
            r4 = r4 & 77
            int r4 = r4 << r2
            int r7 = r7 + r4
            int r4 = r7 % 128
            f3007g = r4
            int r7 = r7 % 2
            r4 = 1
            goto L_0x0065
        L_0x0050:
            int r4 = f3007g
            r7 = r4 & 57
            r4 = r4 ^ 57
            r4 = r4 | r7
            int r4 = -r4
            int r4 = -r4
            r8 = r7 | r4
            int r8 = r8 << r2
            r4 = r4 ^ r7
            int r8 = r8 - r4
            int r4 = r8 % 128
            f3006f = r4
            int r8 = r8 % 2
            r4 = 0
        L_0x0065:
            r7 = 83
            if (r3 == 0) goto L_0x006c
            r8 = 88
            goto L_0x006e
        L_0x006c:
            r8 = 83
        L_0x006e:
            if (r8 == r7) goto L_0x0095
            int r7 = f3007g
            r8 = r7 ^ 69
            r9 = r7 & 69
            r8 = r8 | r9
            int r8 = r8 << r2
            r9 = r7 & -70
            int r7 = ~r7
            r7 = r7 & 69
            r7 = r7 | r9
            int r8 = r8 - r7
            int r7 = r8 % 128
            f3006f = r7
            int r8 = r8 % 2
            r3.destroy()
            int r3 = f3007g
            r7 = r3 | 13
            int r7 = r7 << r2
            r3 = r3 ^ r6
            int r7 = r7 - r3
            int r3 = r7 % 128
            f3006f = r3
            int r7 = r7 % 2
        L_0x0095:
            int r3 = f3007g
            r6 = r3 & 79
            r3 = r3 ^ r5
            r3 = r3 | r6
            int r3 = -r3
            int r3 = -r3
            r5 = r6 | r3
            int r5 = r5 << r2
            r3 = r3 ^ r6
            int r5 = r5 - r3
            int r3 = r5 % 128
            f3006f = r3
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r0 = 1
        L_0x00ac:
            if (r0 == 0) goto L_0x00af
            return r4
        L_0x00af:
            int r0 = r1.length     // Catch:{ all -> 0x00b1 }
            return r4
        L_0x00b1:
            r0 = move-exception
            throw r0
        L_0x00b3:
            goto L_0x00b6
        L_0x00b5:
            r3 = r1
        L_0x00b6:
            if (r3 == 0) goto L_0x00c9
            r3.destroy()
            int r3 = f3007g
            r4 = r3 ^ 113(0x71, float:1.58E-43)
            r3 = r3 & 113(0x71, float:1.58E-43)
            int r3 = r3 << r2
            int r4 = r4 + r3
            int r3 = r4 % 128
            f3006f = r3
            int r4 = r4 % 2
        L_0x00c9:
            int r3 = f3007g
            r4 = r3 | 61
            int r4 = r4 << r2
            r5 = r3 & -62
            int r3 = ~r3
            r3 = r3 & 61
            r3 = r3 | r5
            int r3 = -r3
            r5 = r4 ^ r3
            r3 = r3 & r4
            int r2 = r3 << 1
            int r5 = r5 + r2
            int r2 = r5 % 128
            f3006f = r2
            int r5 = r5 % 2
            r2 = 30
            if (r5 == 0) goto L_0x00e8
            r3 = 54
            goto L_0x00ea
        L_0x00e8:
            r3 = 30
        L_0x00ea:
            if (r3 == r2) goto L_0x00f0
            int r1 = r1.length     // Catch:{ all -> 0x00ee }
            return r0
        L_0x00ee:
            r0 = move-exception
            throw r0
        L_0x00f0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextCursorDrawable.m2107g():boolean");
    }

    public final JSONObject Cardinal() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("IsAppTrusted", Boolean.valueOf(this.f3012e));
            jSONObject.putOpt("IsJailbroken", Boolean.valueOf(this.f3009b));
            jSONObject.putOpt("IsSDKTempered", Boolean.valueOf(this.init));
            jSONObject.putOpt("IsEmulator", Boolean.valueOf(this.f3008a));
            jSONObject.putOpt("IsDebuggerAttached", Boolean.valueOf(this.f3010c));
            jSONObject.putOpt("IsOSSupported", Boolean.valueOf(this.f3011d));
            int i = f3007g;
            int i2 = ((i | 5) << 1) - (i ^ 5);
            f3006f = i2 % 128;
            int i3 = i2 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), (String) null);
        }
        int i4 = f3007g + 41;
        f3006f = i4 % 128;
        int i5 = i4 % 2;
        return jSONObject;
    }
}
