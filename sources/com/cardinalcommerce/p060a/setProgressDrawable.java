package com.cardinalcommerce.p060a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.didi.sdk.apm.SystemUtils;
import java.security.KeyPair;
import java.util.UUID;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: com.cardinalcommerce.a.setProgressDrawable */
public final class setProgressDrawable {

    /* renamed from: d */
    private static int f2943d = 0;

    /* renamed from: e */
    private static int f2944e = 1;
    public String Cardinal;

    /* renamed from: a */
    private setProgressBackgroundTintMode f2945a;

    /* renamed from: b */
    private char[] f2946b;

    /* renamed from: c */
    private String f2947c;
    public String cca_continue;
    public final setTextCursorDrawable cleanup;
    public UiCustomization configure;
    public String getInstance;
    public String getSDKVersion;
    public KeyPair getWarnings;
    public final Context init;

    public setProgressDrawable(Context context, String str, UiCustomization uiCustomization, char[] cArr, setTextCursorDrawable settextcursordrawable, String str2) {
        this.f2945a = setProgressBackgroundTintMode.init();
        setProgress.Cardinal();
        boolean instance = getInstance();
        setCompoundDrawablePadding setcompounddrawablepadding = setProgress.getInstance;
        Context applicationContext = context.getApplicationContext();
        setcompounddrawablepadding.getSDKVersion = instance;
        setcompounddrawablepadding.CardinalError = new setCompoundDrawables();
        setcompounddrawablepadding.cca_continue(applicationContext);
        setcompounddrawablepadding.init = new setTextSize(applicationContext);
        setcompounddrawablepadding.configure = new setCompoundDrawableTintList(applicationContext);
        C2014init.init();
        setcompounddrawablepadding.Cardinal = setHorizontallyScrolling.getInstance(C2014init.configure(setShadowLayer.cca_continue));
        this.f2945a.Cardinal("TransactionConfigurationParameters", "LASSO Configured");
        this.init = context;
        this.cca_continue = str;
        this.configure = uiCustomization;
        this.f2946b = cArr;
        this.getInstance = setHeight.getSDKVersion;
        this.cleanup = settextcursordrawable;
        this.Cardinal = m2070a(context);
        this.f2947c = str2;
    }

    public setProgressDrawable() {
        this.cleanup = null;
        Context context = setShadowLayer.cca_continue;
        this.init = context;
        this.Cardinal = m2070a(context);
    }

    public final char[] init() {
        int i = f2944e;
        int i2 = i & 13;
        int i3 = (i2 - (~((i ^ 13) | i2))) - 1;
        f2943d = i3 % 128;
        int i4 = i3 % 2;
        char[] cArr = this.f2946b;
        int i5 = f2944e;
        int i6 = ((i5 ^ 21) | (i5 & 21)) << 1;
        int i7 = -(((~i5) & 21) | (i5 & -22));
        int i8 = (i6 & i7) + (i7 | i6);
        f2943d = i8 % 128;
        if (i8 % 2 == 0) {
            return cArr;
        }
        int i9 = 28 / 0;
        return cArr;
    }

    /* renamed from: a */
    private String m2070a(Context context) {
        long j;
        long j2;
        setLines setlines;
        int i = f2943d;
        int i2 = i & 55;
        int i3 = i2 - (~(-(-((i ^ 55) | i2))));
        boolean z = true;
        int i4 = i3 - 1;
        f2944e = i4 % 128;
        if (!(i4 % 2 == 0)) {
            setlines = setLines.init(context);
            this.Cardinal = setlines.cca_continue("SDKAppID", (String) null);
            j2 = setlines.getInstance("LastUpdatedTime");
            try {
                j = SystemUtils.getPackageInfo(context.getPackageManager(), this.init.getPackageName(), 0).lastUpdateTime;
            } catch (PackageManager.NameNotFoundException unused) {
                j = 0;
            }
        } else {
            setlines = setLines.init(context);
            this.Cardinal = setlines.cca_continue("SDKAppID", (String) null);
            j2 = setlines.getInstance("LastUpdatedTime");
            j = 1;
            try {
                j = SystemUtils.getPackageInfo(context.getPackageManager(), this.init.getPackageName(), 1).lastUpdateTime;
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        int i5 = f2944e;
        int i6 = i5 & 35;
        int i7 = (i5 | 35) & (~i6);
        int i8 = i6 << 1;
        int i9 = ((i7 | i8) << 1) - (i7 ^ i8);
        f2943d = i9 % 128;
        int i10 = i9 % 2;
        if ((this.Cardinal != null ? 'E' : 19) != 19) {
            int i11 = f2944e;
            int i12 = i11 & 23;
            int i13 = (i11 ^ 23) | i12;
            int i14 = (i12 ^ i13) + ((i13 & i12) << 1);
            f2943d = i14 % 128;
            int i15 = i14 % 2;
            if ((j2 != 0 ? Matrix.MATRIX_TYPE_ZERO : '5') == 'Z') {
                int i16 = (f2944e + 122) - 1;
                f2943d = i16 % 128;
                int i17 = i16 % 2;
                if (!(j2 != j)) {
                    String str = this.Cardinal;
                    int i18 = (((f2943d + 75) - 1) - 0) - 1;
                    f2944e = i18 % 128;
                    if (i18 % 2 != 0) {
                        z = false;
                    }
                    if (!z) {
                        return str;
                    }
                    int i19 = 33 / 0;
                    return str;
                }
            }
        }
        String obj = UUID.randomUUID().toString();
        setlines.Cardinal("SDKAppID", obj);
        setlines.configure("LastUpdatedTime", j);
        int i20 = f2943d;
        int i21 = i20 & 7;
        int i22 = -(-((i20 ^ 7) | i21));
        int i23 = (i21 ^ i22) + ((i22 & i21) << 1);
        f2944e = i23 % 128;
        int i24 = i23 % 2;
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if ((r8.f2947c == null) != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if ((r8.f2947c != null) != true) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        if ((r8.f2947c.equals("true") ? 'D' : 8) != 8) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        if ((r8.f2947c.equals("true")) != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0094, code lost:
        r1 = ((f2944e + 38) - 0) - 1;
        f2943d = r1 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        if ((r1 % 2) == 0) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a2, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a3, code lost:
        if (r2 == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a8, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ab, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getInstance() {
        /*
            r8 = this;
            int r0 = f2944e
            r1 = r0 ^ 87
            r0 = r0 & 87
            r2 = 1
            int r0 = r0 << r2
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f2943d = r0
            r0 = 2
            int r1 = r1 % r0
            r3 = 0
            if (r1 == 0) goto L_0x0016
            r1 = 0
            goto L_0x0017
        L_0x0016:
            r1 = 1
        L_0x0017:
            r4 = 0
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r8.f2947c
            if (r1 == 0) goto L_0x0020
            r1 = 0
            goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            if (r1 == 0) goto L_0x0031
            goto L_0x0094
        L_0x0025:
            java.lang.String r1 = r8.f2947c
            r5 = 6
            int r5 = r5 / r3
            if (r1 == 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == r2) goto L_0x0031
            goto L_0x0094
        L_0x0031:
            int r1 = f2943d
            r5 = r1 ^ 101(0x65, float:1.42E-43)
            r1 = r1 & 101(0x65, float:1.42E-43)
            r1 = r1 | r5
            int r1 = r1 << r2
            int r1 = r1 - r5
            int r5 = r1 % 128
            f2944e = r5
            int r1 = r1 % r0
            r5 = 19
            if (r1 != 0) goto L_0x0046
            r1 = 19
            goto L_0x0047
        L_0x0046:
            r1 = 2
        L_0x0047:
            java.lang.String r6 = "true"
            if (r1 == r5) goto L_0x005e
            java.lang.String r1 = r8.f2947c
            boolean r1 = r1.equals(r6)
            r5 = 8
            if (r1 == 0) goto L_0x0059
            r1 = 68
            goto L_0x005b
        L_0x0059:
            r1 = 8
        L_0x005b:
            if (r1 == r5) goto L_0x0094
            goto L_0x006d
        L_0x005e:
            java.lang.String r1 = r8.f2947c
            boolean r1 = r1.equals(r6)
            r5 = 1
            int r5 = r5 / r3
            if (r1 == 0) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            if (r1 == 0) goto L_0x0094
        L_0x006d:
            int r1 = f2944e
            r5 = 69
            r6 = r1 ^ 69
            r7 = r1 & 69
            r6 = r6 | r7
            int r6 = r6 << r2
            r7 = r1 & -70
            int r1 = ~r1
            r1 = r1 & r5
            r1 = r1 | r7
            int r1 = -r1
            r5 = r6 ^ r1
            r1 = r1 & r6
            int r1 = r1 << r2
            int r5 = r5 + r1
            int r1 = r5 % 128
            f2943d = r1
            int r5 = r5 % r0
            if (r5 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r3 = 1
        L_0x008b:
            if (r3 == 0) goto L_0x008e
            return r2
        L_0x008e:
            super.hashCode()     // Catch:{ all -> 0x0092 }
            return r2
        L_0x0092:
            r0 = move-exception
            throw r0
        L_0x0094:
            int r1 = f2944e
            int r1 = r1 + 38
            int r1 = r1 - r3
            int r1 = r1 - r2
            int r5 = r1 % 128
            f2943d = r5
            int r1 = r1 % r0
            if (r1 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r2 = 0
        L_0x00a3:
            if (r2 == 0) goto L_0x00ab
            super.hashCode()     // Catch:{ all -> 0x00a9 }
            return r3
        L_0x00a9:
            r0 = move-exception
            throw r0
        L_0x00ab:
            return r3
        L_0x00ac:
            r0 = move-exception
            throw r0
        L_0x00ae:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressDrawable.getInstance():boolean");
    }
}
