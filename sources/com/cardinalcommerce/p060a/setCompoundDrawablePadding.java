package com.cardinalcommerce.p060a;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executors;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawablePadding */
public final class setCompoundDrawablePadding implements setAutoSizeTextTypeUniformWithPresetSizes, Serializable {
    private static int CardinalActionCode = 0;
    private static int CardinalEnvironment = 1;
    public char[] Cardinal;
    public setCompoundDrawables CardinalError;
    private final setTextMetricsParams CardinalRenderType = setTextMetricsParams.getSDKVersion();
    private char[] CardinalUiType = cca_continue();
    public setTextSelectHandleLeft cca_continue = new setTextSelectHandleLeft();
    public JSONObject cleanup;
    public setCompoundDrawableTintList configure;
    public setTextSelectHandleRight getInstance;
    public boolean getSDKVersion;
    public setTextCursorDrawable getWarnings;
    public setTextSize init;
    private char[] valueOf = setHorizontallyScrolling.getInstance(Locale.getDefault().getDisplayLanguage());
    public setCompoundDrawableTintBlendMode values = new setCompoundDrawableTintBlendMode();

    private static char[] cca_continue() {
        int i = CardinalEnvironment;
        int i2 = i & 7;
        int i3 = -(-((i ^ 7) | i2));
        int i4 = (i2 & i3) + (i3 | i2);
        CardinalActionCode = i4 % 128;
        if (!(i4 % 2 != 0)) {
            return setHorizontallyScrolling.getInstance("2.2.7-2");
        }
        int i5 = 29 / 0;
        return setHorizontallyScrolling.getInstance("2.2.7-2");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008d, code lost:
        if (r0.init() != false) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(android.content.Context r9) {
        /*
            r8 = this;
            com.cardinalcommerce.a.setMaxLines r0 = new com.cardinalcommerce.a.setMaxLines
            r0.<init>(r9)
            boolean r1 = r0.Cardinal()
            java.lang.String r2 = "NativeData Data"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0034
            com.cardinalcommerce.a.setTextSelectHandleRight r1 = new com.cardinalcommerce.a.setTextSelectHandleRight     // Catch:{ Exception -> 0x002a }
            r1.<init>(r9)     // Catch:{ Exception -> 0x002a }
            r8.getInstance = r1     // Catch:{ Exception -> 0x002a }
            int r1 = CardinalEnvironment
            r5 = r1 ^ 32
            r1 = r1 & 32
            int r1 = r1 << r4
            int r5 = r5 + r1
            r1 = r5 & -1
            r5 = r5 | -1
            int r1 = r1 + r5
            int r5 = r1 % 128
            CardinalActionCode = r5
            int r1 = r1 % 2
            goto L_0x0034
        L_0x002a:
            r1 = move-exception
            com.cardinalcommerce.a.setTextMetricsParams r5 = r8.CardinalRenderType
            java.lang.String r1 = r1.getMessage()
            r5.configure(r2, r1, r3)
        L_0x0034:
            com.cardinalcommerce.a.setTextMetricsParams r1 = r8.CardinalRenderType
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Location Data Consent Given : "
            r5.<init>(r6)
            boolean r6 = r8.getSDKVersion
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "LASSOEvent"
            r1.init(r6, r5, r3)
            boolean r1 = r8.getSDKVersion
            r5 = 0
            if (r1 == 0) goto L_0x0052
            r1 = 0
            goto L_0x0053
        L_0x0052:
            r1 = 1
        L_0x0053:
            if (r1 == r4) goto L_0x00b1
            int r1 = CardinalActionCode
            int r1 = r1 + 114
            r6 = r1 ^ -1
            r1 = r1 & -1
            int r1 = r1 << r4
            int r6 = r6 + r1
            int r1 = r6 % 128
            CardinalEnvironment = r1
            int r6 = r6 % 2
            boolean r1 = r0.configure()
            r6 = 21
            if (r1 != 0) goto L_0x0070
            r1 = 35
            goto L_0x0072
        L_0x0070:
            r1 = 21
        L_0x0072:
            if (r1 == r6) goto L_0x008f
            int r1 = CardinalActionCode
            r6 = r1 | 51
            int r6 = r6 << r4
            r7 = r1 & -52
            int r1 = ~r1
            r1 = r1 & 51
            r1 = r1 | r7
            int r1 = -r1
            int r1 = ~r1
            int r6 = r6 - r1
            int r6 = r6 - r4
            int r1 = r6 % 128
            CardinalEnvironment = r1
            int r6 = r6 % 2
            boolean r1 = r0.init()
            if (r1 == 0) goto L_0x00b1
        L_0x008f:
            com.cardinalcommerce.a.l r1 = new com.cardinalcommerce.a.l     // Catch:{ Exception -> 0x00a7 }
            r1.<init>(r8, r9)     // Catch:{ Exception -> 0x00a7 }
            int r1 = CardinalActionCode
            r2 = r1 & 117(0x75, float:1.64E-43)
            r1 = r1 ^ 117(0x75, float:1.64E-43)
            r1 = r1 | r2
            r6 = r2 | r1
            int r6 = r6 << r4
            r1 = r1 ^ r2
            int r6 = r6 - r1
            int r1 = r6 % 128
            CardinalEnvironment = r1
            int r6 = r6 % 2
            goto L_0x00b1
        L_0x00a7:
            r1 = move-exception
            com.cardinalcommerce.a.setTextMetricsParams r6 = r8.CardinalRenderType
            java.lang.String r1 = r1.getMessage()
            r6.configure(r2, r1, r3)
        L_0x00b1:
            boolean r1 = r0.getInstance()
            if (r1 == 0) goto L_0x00d0
            com.cardinalcommerce.a.setCompoundDrawablesRelative r1 = new com.cardinalcommerce.a.setCompoundDrawablesRelative
            r1.<init>(r9)
            com.cardinalcommerce.a.setCompoundDrawables r2 = r8.CardinalError
            r2.getInstance = r1
            int r1 = CardinalEnvironment
            r2 = r1 & 53
            int r6 = ~r2
            r1 = r1 | 53
            r1 = r1 & r6
            int r2 = r2 << r4
            int r1 = r1 + r2
            int r2 = r1 % 128
            CardinalActionCode = r2
            int r1 = r1 % 2
        L_0x00d0:
            boolean r0 = r0.cca_continue()
            if (r0 == 0) goto L_0x00d8
            r0 = 0
            goto L_0x00d9
        L_0x00d8:
            r0 = 1
        L_0x00d9:
            if (r0 == 0) goto L_0x00dc
            goto L_0x010c
        L_0x00dc:
            int r0 = CardinalEnvironment
            r1 = r0 & 33
            int r2 = ~r1
            r0 = r0 | 33
            r0 = r0 & r2
            int r1 = r1 << r4
            int r0 = r0 + r1
            int r1 = r0 % 128
            CardinalActionCode = r1
            int r0 = r0 % 2
            com.cardinalcommerce.a.setCompoundDrawables r0 = r8.CardinalError
            com.cardinalcommerce.a.setCompoundDrawableTintMode r0 = r0.cca_continue
            r0.init(r9)
            int r9 = CardinalEnvironment
            r0 = r9 ^ 105(0x69, float:1.47E-43)
            r1 = r9 & 105(0x69, float:1.47E-43)
            r0 = r0 | r1
            int r0 = r0 << r4
            r1 = r9 & -106(0xffffffffffffff96, float:NaN)
            int r9 = ~r9
            r9 = r9 & 105(0x69, float:1.47E-43)
            r9 = r9 | r1
            int r9 = -r9
            r1 = r0 & r9
            r9 = r9 | r0
            int r1 = r1 + r9
            int r9 = r1 % 128
            CardinalActionCode = r9
            int r1 = r1 % 2
        L_0x010c:
            int r9 = CardinalEnvironment
            int r9 = r9 + 104
            int r9 = r9 - r4
            int r0 = r9 % 128
            CardinalActionCode = r0
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x011a
            goto L_0x011b
        L_0x011a:
            r5 = 1
        L_0x011b:
            if (r5 == r4) goto L_0x0123
            super.hashCode()     // Catch:{ all -> 0x0121 }
            return
        L_0x0121:
            r9 = move-exception
            throw r9
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCompoundDrawablePadding.cca_continue(android.content.Context):void");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, java.lang.String] */
    public final JSONObject Cardinal() {
        JSONObject jSONObject = new JSONObject();
        ? r1 = 0;
        boolean z = true;
        if ((this.CardinalError != null ? Matrix.MATRIX_TYPE_ZERO : Typography.greater) != '>') {
            int i = CardinalEnvironment + 99;
            CardinalActionCode = i % 128;
            int i2 = i % 2;
            jSONObject.putOpt("ConnectionData", this.CardinalError.getInstance());
            int i3 = CardinalActionCode;
            int i4 = ((((i3 ^ 113) | (i3 & 113)) << 1) - (~(-(((~i3) & 113) | (i3 & -114))))) - 1;
            CardinalEnvironment = i4 % 128;
            int i5 = i4 % 2;
        }
        try {
            if ((this.valueOf != null ? 24 : VersionRange.RIGHT_OPEN) == 24) {
                int i6 = CardinalActionCode;
                int i7 = (i6 & 15) + (i6 | 15);
                CardinalEnvironment = i7 % 128;
                if ((i7 % 2 == 0 ? (char) 6 : 29) != 29) {
                    jSONObject.putOpt("Language", setHorizontallyScrolling.configure(this.valueOf));
                    int length = r1.length;
                } else {
                    jSONObject.putOpt("Language", setHorizontallyScrolling.configure(this.valueOf));
                }
            }
            if ((this.values != null ? 29 : 'E') != 'E') {
                int i8 = CardinalEnvironment;
                int i9 = i8 & 43;
                int i10 = -(-(i8 | 43));
                int i11 = (i9 & i10) + (i10 | i9);
                CardinalActionCode = i11 % 128;
                int i12 = i11 % 2;
                if (this.getSDKVersion) {
                    int i13 = CardinalActionCode;
                    int i14 = i13 & 41;
                    int i15 = (i14 - (~((i13 ^ 41) | i14))) - 1;
                    CardinalEnvironment = i15 % 128;
                    if ((i15 % 2 == 0 ? (char) 16 : 27) != 16) {
                        jSONObject.putOpt("LocationData", this.values.init());
                    } else {
                        jSONObject.putOpt("LocationData", this.values.init());
                        int length2 = r1.length;
                    }
                }
            }
            if ((this.configure != null ? VersionRange.LEFT_CLOSED : '4') != '4') {
                int i16 = CardinalEnvironment;
                int i17 = (i16 ^ 101) + ((i16 & 101) << 1);
                CardinalActionCode = i17 % 128;
                int i18 = i17 % 2;
                jSONObject.putOpt("DeviceData", this.configure.cca_continue());
                int i19 = CardinalActionCode;
                int i20 = i19 & 83;
                int i21 = (i20 - (~((i19 ^ 83) | i20))) - 1;
                CardinalEnvironment = i21 % 128;
                int i22 = i21 % 2;
            }
            if ((this.cca_continue != null ? (char) 10 : 4) == 10) {
                int i23 = CardinalEnvironment;
                int i24 = ((i23 | 3) << 1) - (i23 ^ 3);
                CardinalActionCode = i24 % 128;
                int i25 = i24 % 2;
                jSONObject.putOpt("OS", this.cca_continue.getInstance());
                int i26 = CardinalEnvironment;
                int i27 = (((i26 ^ 111) | (i26 & 111)) << 1) - (((~i26) & 111) | (i26 & -112));
                CardinalActionCode = i27 % 128;
                int i28 = i27 % 2;
            }
            if (this.getInstance != null) {
                int i29 = (CardinalActionCode + 68) - 1;
                CardinalEnvironment = i29 % 128;
                int i30 = i29 % 2;
                jSONObject.putOpt("TelephonyData", this.getInstance.configure());
                int i31 = CardinalEnvironment;
                int i32 = i31 ^ 23;
                int i33 = (((i31 & 23) | i32) << 1) - i32;
                CardinalActionCode = i33 % 128;
                int i34 = i33 % 2;
            }
            if ((this.cleanup != null ? 'b' : VersionRange.LEFT_OPEN) != '(') {
                int i35 = CardinalEnvironment;
                int i36 = i35 & 71;
                int i37 = (i35 ^ 71) | i36;
                int i38 = ((i36 | i37) << 1) - (i37 ^ i36);
                CardinalActionCode = i38 % 128;
                int i39 = i38 % 2;
                jSONObject.putOpt("ConfigurationData", this.cleanup);
                int i40 = CardinalActionCode;
                int i41 = i40 & 41;
                int i42 = i41 + ((i40 ^ 41) | i41);
                CardinalEnvironment = i42 % 128;
                int i43 = i42 % 2;
            }
            if ((this.init != null ? 25 : '`') != '`') {
                int i44 = CardinalEnvironment;
                int i45 = (((i44 | 70) << 1) - (i44 ^ 70)) - 1;
                CardinalActionCode = i45 % 128;
                if (i45 % 2 != 0) {
                    jSONObject.putOpt("UserData", this.init.Cardinal());
                    super.hashCode();
                } else {
                    jSONObject.putOpt("UserData", this.init.Cardinal());
                }
            }
            if (this.getWarnings != null) {
                int i46 = CardinalActionCode + 120;
                int i47 = (i46 ^ -1) + ((i46 & -1) << 1);
                CardinalEnvironment = i47 % 128;
                if ((i47 % 2 == 0 ? '^' : 'X') != 'X') {
                    jSONObject.putOpt("SecurityWarnings", this.getWarnings.Cardinal());
                    super.hashCode();
                } else {
                    jSONObject.putOpt("SecurityWarnings", this.getWarnings.Cardinal());
                }
            }
            if ((this.CardinalUiType != null ? 19 : '+') != '+') {
                int i48 = CardinalActionCode;
                int i49 = i48 & 85;
                int i50 = (i49 - (~(-(-((i48 ^ 85) | i49))))) - 1;
                CardinalEnvironment = i50 % 128;
                if ((i50 % 2 == 0 ? Matrix.MATRIX_TYPE_RANDOM_UT : '*') != '*') {
                    jSONObject.putOpt("SdkVersion", setHorizontallyScrolling.configure(this.CardinalUiType));
                    super.hashCode();
                } else {
                    jSONObject.putOpt("SdkVersion", setHorizontallyScrolling.configure(this.CardinalUiType));
                }
            }
            if ((this.Cardinal != null ? (char) 0 : 12) != 12) {
                int i51 = CardinalActionCode;
                int i52 = i51 & 29;
                int i53 = i52 + ((i51 ^ 29) | i52);
                CardinalEnvironment = i53 % 128;
                if (i53 % 2 != 0) {
                    jSONObject.putOpt("SDKAppId", setHorizontallyScrolling.configure(this.Cardinal));
                } else {
                    jSONObject.putOpt("SDKAppId", setHorizontallyScrolling.configure(this.Cardinal));
                    int i54 = 21 / 0;
                }
                int i55 = CardinalEnvironment;
                int i56 = ((((i55 ^ 53) | (i55 & 53)) << 1) - (~(-(((~i55) & 53) | (i55 & -54))))) - 1;
                CardinalActionCode = i56 % 128;
                int i57 = i56 % 2;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = setHeight.init.iterator();
            int i58 = CardinalActionCode;
            int i59 = i58 & 69;
            int i60 = (((69 | i58) & (~i59)) - (~(-(-(i59 << 1))))) - 1;
            CardinalEnvironment = i60 % 128;
            int i61 = i60 % 2;
            while (true) {
                if ((it.hasNext() ? 'A' : '\'') != 'A') {
                    break;
                }
                int i62 = CardinalEnvironment;
                int i63 = ((i62 | 12) << 1) - (i62 ^ 12);
                int i64 = ((i63 | -1) << 1) - (i63 ^ -1);
                CardinalActionCode = i64 % 128;
                int i65 = i64 % 2;
                jSONArray.put(it.next());
                int i66 = CardinalEnvironment;
                int i67 = i66 & 17;
                int i68 = i66 | 17;
                int i69 = (i67 ^ i68) + ((i68 & i67) << 1);
                CardinalActionCode = i69 % 128;
                int i70 = i69 % 2;
            }
            jSONObject.putOpt("SDK3DSSupport", jSONArray);
            int i71 = CardinalActionCode;
            int i72 = ((i71 | 70) << 1) - (i71 ^ 70);
            int i73 = ((i72 | -1) << 1) - (i72 ^ -1);
            CardinalEnvironment = i73 % 128;
            int i74 = i73 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), r1);
        }
        int i75 = CardinalActionCode;
        int i76 = i75 & 105;
        int i77 = (i75 ^ 105) | i76;
        int i78 = (i76 & i77) + (i77 | i76);
        CardinalEnvironment = i78 % 128;
        if (i78 % 2 != 0) {
            z = false;
        }
        if (!z) {
            return jSONObject;
        }
        int i79 = 45 / 0;
        return jSONObject;
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [com.cardinalcommerce.a.setCompoundDrawableTintList, char[], com.cardinalcommerce.a.setCompoundDrawableTintBlendMode, org.json.JSONObject, java.lang.Object, com.cardinalcommerce.a.setTextSelectHandleRight, com.cardinalcommerce.a.setTextSelectHandleLeft] */
    public final void init() {
        int i = CardinalActionCode;
        int i2 = i ^ 113;
        int i3 = ((i & 113) | i2) << 1;
        int i4 = -i2;
        int i5 = (i3 & i4) + (i3 | i4);
        CardinalEnvironment = i5 % 128;
        int i6 = i5 % 2;
        ? r3 = 0;
        if (this.CardinalError != null) {
            int i7 = CardinalEnvironment;
            int i8 = (i7 & -110) | ((~i7) & 109);
            int i9 = (i7 & 109) << 1;
            int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
            CardinalActionCode = i10 % 128;
            if (i10 % 2 != 0) {
                Executors.newSingleThreadExecutor().execute(this.CardinalError);
                this.cleanup = r3;
                int length = r3.length;
            } else {
                Executors.newSingleThreadExecutor().execute(this.CardinalError);
                this.cleanup = r3;
            }
            int i11 = CardinalActionCode;
            int i12 = ((i11 | 84) << 1) - (i11 ^ 84);
            int i13 = (i12 & -1) + (i12 | -1);
            CardinalEnvironment = i13 % 128;
            int i14 = i13 % 2;
        }
        if (this.valueOf != null) {
            int i15 = CardinalActionCode;
            int i16 = i15 & 29;
            int i17 = ((i15 | 29) & (~i16)) + (i16 << 1);
            CardinalEnvironment = i17 % 128;
            int i18 = i17 % 2;
            setHorizontallyScrolling.getInstance(this.valueOf);
            this.valueOf = r3;
            int i19 = CardinalActionCode;
            int i20 = i19 & 123;
            int i21 = ((i19 ^ 123) | i20) << 1;
            int i22 = -((i19 | 123) & (~i20));
            int i23 = ((i21 | i22) << 1) - (i22 ^ i21);
            CardinalEnvironment = i23 % 128;
            int i24 = i23 % 2;
        }
        if (this.values != null) {
            int i25 = CardinalActionCode;
            int i26 = i25 & 31;
            int i27 = i26 + ((i25 ^ 31) | i26);
            CardinalEnvironment = i27 % 128;
            if (i27 % 2 != 0) {
                Executors.newSingleThreadExecutor().execute(this.values);
                this.values = r3;
            } else {
                Executors.newSingleThreadExecutor().execute(this.values);
                this.values = r3;
                int i28 = 68 / 0;
            }
        }
        if ((this.configure != null ? 18 : '%') == 18) {
            int i29 = CardinalEnvironment;
            int i30 = (i29 & 35) + (i29 | 35);
            CardinalActionCode = i30 % 128;
            int i31 = i30 % 2;
            Executors.newSingleThreadExecutor().execute(this.configure);
            this.configure = r3;
            int i32 = CardinalActionCode;
            int i33 = ((i32 & -38) | ((~i32) & 37)) + ((i32 & 37) << 1);
            CardinalEnvironment = i33 % 128;
            int i34 = i33 % 2;
        }
        setTextSelectHandleLeft settextselecthandleleft = this.cca_continue;
        if (settextselecthandleleft != null) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                private static int configure = 1;
                private static int getInstance;

                public final void run() {
                    int i = getInstance;
                    int i2 = i ^ 13;
                    int i3 = (((i & 13) | i2) << 1) - i2;
                    configure = i3 % 128;
                    int i4 = i3 % 2;
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.cca_continue);
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.Cardinal);
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.init);
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.configure);
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.getInstance);
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.CardinalError);
                    setTextSelectHandleLeft.this.cleanup = 0;
                    setTextSelectHandleLeft.this.getSDKVersion = 0;
                    setHorizontallyScrolling.getInstance(setTextSelectHandleLeft.this.values);
                    int i5 = configure;
                    int i6 = (i5 & 125) + (i5 | 125);
                    getInstance = i6 % 128;
                    if ((i6 % 2 != 0 ? Typography.greater : '.') == '>') {
                        int i7 = 78 / 0;
                    }
                }
            });
            this.cca_continue = r3;
            int i35 = (CardinalActionCode + 27) - 1;
            int i36 = (i35 & -1) + (i35 | -1);
            CardinalEnvironment = i36 % 128;
            int i37 = i36 % 2;
        }
        if (this.getInstance != null) {
            int i38 = (CardinalEnvironment + 106) - 1;
            CardinalActionCode = i38 % 128;
            int i39 = i38 % 2;
            Executors.newSingleThreadExecutor().execute(this.getInstance);
            this.getInstance = r3;
            int i40 = CardinalEnvironment;
            int i41 = ((i40 & 42) + (i40 | 42)) - 1;
            CardinalActionCode = i41 % 128;
            int i42 = i41 % 2;
        }
        if (!(this.cleanup == null)) {
            int i43 = CardinalActionCode;
            int i44 = i43 & 65;
            int i45 = (i43 | 65) & (~i44);
            int i46 = -(-(i44 << 1));
            int i47 = (i45 & i46) + (i45 | i46);
            CardinalEnvironment = i47 % 128;
            if (i47 % 2 != 0) {
                this.cleanup = r3;
            } else {
                this.cleanup = r3;
                int length2 = r3.length;
            }
            int i48 = CardinalActionCode;
            int i49 = (((i48 & -108) | ((~i48) & 107)) - (~(-(-((i48 & 107) << 1))))) - 1;
            CardinalEnvironment = i49 % 128;
            int i50 = i49 % 2;
        }
        if ((this.CardinalUiType != null ? '.' : 'c') != 'c') {
            int i51 = CardinalActionCode;
            int i52 = (((i51 & 74) + (i51 | 74)) - 0) - 1;
            CardinalEnvironment = i52 % 128;
            int i53 = i52 % 2;
            setHorizontallyScrolling.getInstance(this.CardinalUiType);
            this.CardinalUiType = r3;
            int i54 = CardinalEnvironment;
            int i55 = (i54 & -70) | ((~i54) & 69);
            int i56 = (i54 & 69) << 1;
            int i57 = (i55 & i56) + (i56 | i55);
            CardinalActionCode = i57 % 128;
            int i58 = i57 % 2;
        }
        if ((this.Cardinal != null ? (char) 1 : 11) == 1) {
            int i59 = CardinalEnvironment;
            int i60 = (i59 & 77) + (i59 | 77);
            CardinalActionCode = i60 % 128;
            if ((i60 % 2 != 0 ? (char) 29 : 1) != 29) {
                setHorizontallyScrolling.getInstance(this.Cardinal);
                this.Cardinal = r3;
            } else {
                setHorizontallyScrolling.getInstance(this.Cardinal);
                this.Cardinal = r3;
                super.hashCode();
            }
        }
        int i61 = CardinalActionCode;
        int i62 = i61 & 91;
        int i63 = ((i61 | 91) & (~i62)) + (i62 << 1);
        CardinalEnvironment = i63 % 128;
        int i64 = i63 % 2;
    }

    public final void init(setCompoundDrawableTintBlendMode setcompounddrawabletintblendmode) {
        int i = CardinalEnvironment;
        int i2 = i & 3;
        int i3 = (i | 3) & (~i2);
        int i4 = i2 << 1;
        int i5 = (i3 & i4) + (i3 | i4);
        CardinalActionCode = i5 % 128;
        int i6 = i5 % 2;
        this.values = setcompounddrawabletintblendmode;
        int i7 = CardinalEnvironment;
        int i8 = ((i7 & -32) | ((~i7) & 31)) + ((i7 & 31) << 1);
        CardinalActionCode = i8 % 128;
        if ((i8 % 2 != 0 ? CharUtils.f5620CR : '0') == 13) {
            Object obj = null;
            super.hashCode();
        }
    }
}
