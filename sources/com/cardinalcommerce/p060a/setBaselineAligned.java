package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64;
import com.didi.sdk.push.fcm.Constact;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setBaselineAligned */
public final class setBaselineAligned implements Serializable {
    private static int getThreeDSRequestorAppURL = 1;
    private static int isEnableDFSync;
    public String Cardinal;
    public setLinkTextColor CardinalActionCode;
    public String CardinalConfigurationParameters;
    public String CardinalEnvironment;
    public String CardinalError;
    public ArrayList<setCompoundDrawablesRelativeWithIntrinsicBounds> CardinalRenderType;
    public String CardinalUiType;
    public String cca_continue;
    public String cleanup;
    public String configure;
    public String getActionCode;
    public String getChallengeTimeout;
    public String getEnvironment;
    public String getInstance;
    public String getProxyAddress;
    public String getRenderType;
    public String getRequestTimeout;
    public String getSDKVersion;
    public setLinkTextColor getString;
    private String getUICustomization;
    public String getUiType;
    public String getWarnings;
    public String init;
    public String setChallengeTimeout;
    private boolean setEnableDFSync;
    public String setEnvironment;
    public boolean setProxyAddress;
    public setTransformationMethod setRenderType;
    public String setRequestTimeout;
    public String setUiType;
    public String valueOf;
    public String values;

    setBaselineAligned() {
    }

    public static setBaselineAlignedChildIndex init(setLayoutTransition setlayouttransition) throws ParseException {
        try {
            return setBaselineAlignedChildIndex.init((String) valueOf.getInstance(setlayouttransition, "kty", String.class));
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static List<Base64> Cardinal(setLayoutTransition setlayouttransition) throws ParseException {
        List<Base64> Cardinal2 = valueOf.Cardinal((setDescendantFocusability) valueOf.getInstance(setlayouttransition, "x5c", setDescendantFocusability.class));
        if (Cardinal2 == null || !Cardinal2.isEmpty()) {
            return Cardinal2;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if ((r4) != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        if ((!com.cardinalcommerce.p060a.setMinLines.configure(r8, com.didi.sdk.push.Constants.CONN_CHANNEL_RECVBUFFERSIZE)) != false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 & 57
            r0 = r0 ^ 57
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            r1 = 1
            int r0 = r0 << r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            isEnableDFSync = r0
            int r2 = r2 % 2
            boolean r0 = r8.isEmpty()
            r2 = 0
            if (r0 != 0) goto L_0x001e
            r0 = 0
            goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            r3 = 0
            if (r0 == r1) goto L_0x007a
            int r0 = isEnableDFSync
            int r0 = r0 + 72
            int r0 = r0 - r1
            int r4 = r0 % 128
            getThreeDSRequestorAppURL = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0031
            r0 = 0
            goto L_0x0032
        L_0x0031:
            r0 = 1
        L_0x0032:
            r4 = 102400(0x19000, float:1.43493E-40)
            if (r0 == r1) goto L_0x0048
            com.cardinalcommerce.a.setTransformationMethod r0 = r7.setRenderType
            boolean r4 = com.cardinalcommerce.p060a.setMinLines.configure(r8, r4)
            int r5 = r3.length     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x0042
            r4 = 0
            goto L_0x0043
        L_0x0042:
            r4 = 1
        L_0x0043:
            if (r4 == 0) goto L_0x0055
            goto L_0x007a
        L_0x0046:
            r8 = move-exception
            throw r8
        L_0x0048:
            com.cardinalcommerce.a.setTransformationMethod r0 = r7.setRenderType
            boolean r4 = com.cardinalcommerce.p060a.setMinLines.configure(r8, r4)
            if (r4 != 0) goto L_0x0052
            r4 = 1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            if (r4 == 0) goto L_0x007a
        L_0x0055:
            int r4 = getThreeDSRequestorAppURL
            r5 = r4 & 85
            r4 = r4 ^ 85
            r4 = r4 | r5
            int r4 = ~r4
            int r5 = r5 - r4
            int r5 = r5 - r1
            int r4 = r5 % 128
            isEnableDFSync = r4
            int r5 = r5 % 2
            r4 = 25
            if (r5 == 0) goto L_0x006c
            r5 = 25
            goto L_0x006e
        L_0x006c:
            r5 = 32
        L_0x006e:
            java.lang.String r6 = "acsHTMLRefresh"
            if (r5 == r4) goto L_0x0075
            r0.Cardinal = r2
            goto L_0x0077
        L_0x0075:
            r0.Cardinal = r1
        L_0x0077:
            r0.getInstance(r6)
        L_0x007a:
            r7.setUiType = r8
            int r8 = getThreeDSRequestorAppURL
            r0 = r8 ^ 113(0x71, float:1.58E-43)
            r8 = r8 & 113(0x71, float:1.58E-43)
            int r8 = r8 << r1
            int r0 = r0 + r8
            int r8 = r0 % 128
            isEnableDFSync = r8
            int r0 = r0 % 2
            r8 = 91
            if (r0 == 0) goto L_0x0091
            r0 = 91
            goto L_0x0093
        L_0x0091:
            r0 = 96
        L_0x0093:
            if (r0 == r8) goto L_0x0096
            return
        L_0x0096:
            int r8 = r3.length     // Catch:{ all -> 0x0098 }
            return
        L_0x0098:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setBaselineAligned.init(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if ((r8 >= 0 ? 'X' : '9') != '9') goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009d, code lost:
        if ((r8 >= 0 ? 8 : '5') != 8) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c5, code lost:
        if ((r8 > 3 ? '8' : '*') != '8') goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d2, code lost:
        if ((r8 > 5 ? '=' : 'W') != '=') goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fa, code lost:
        r8 = getThreeDSRequestorAppURL;
        r1 = (r8 ^ 17) + ((r8 & 17) << 1);
        isEnableDFSync = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0107, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean configure(java.lang.String r8) {
        /*
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 & 63
            r0 = r0 ^ 63
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 | r0
            r3 = 1
            int r2 = r2 << r3
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            isEnableDFSync = r0
            r0 = 2
            int r2 = r2 % r0
            java.lang.String r1 = ""
            boolean r1 = r8.equalsIgnoreCase(r1)
            r2 = 90
            if (r1 != 0) goto L_0x0022
            r1 = 90
            goto L_0x0024
        L_0x0022:
            r1 = 22
        L_0x0024:
            r4 = 62
            r5 = 0
            if (r1 == r2) goto L_0x003f
            int r8 = getThreeDSRequestorAppURL
            int r8 = r8 + 38
            int r8 = r8 - r3
            int r1 = r8 % 128
            isEnableDFSync = r1
            int r8 = r8 % r0
            if (r8 == 0) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r8 == 0) goto L_0x003e
            int r4 = r4 / r5
            return r3
        L_0x003c:
            r8 = move-exception
            throw r8
        L_0x003e:
            return r3
        L_0x003f:
            int r1 = isEnableDFSync
            r2 = r1 ^ 99
            r6 = r1 & 99
            r2 = r2 | r6
            int r2 = r2 << r3
            int r6 = ~r6
            r1 = r1 | 99
            r1 = r1 & r6
            int r1 = -r1
            r6 = r2 & r1
            r1 = r1 | r2
            int r6 = r6 + r1
            int r1 = r6 % 128
            getThreeDSRequestorAppURL = r1
            int r6 = r6 % r0
            boolean r1 = com.cardinalcommerce.p060a.setMinLines.cca_continue(r8, r0)
            if (r1 == 0) goto L_0x005d
            r2 = 0
            goto L_0x005e
        L_0x005d:
            r2 = 1
        L_0x005e:
            if (r2 == 0) goto L_0x0062
            goto L_0x00d4
        L_0x0062:
            int r2 = isEnableDFSync
            r6 = r2 & 35
            r2 = r2 ^ 35
            r2 = r2 | r6
            int r2 = -r2
            int r2 = -r2
            r7 = r6 ^ r2
            r2 = r2 & r6
            int r2 = r2 << r3
            int r7 = r7 + r2
            int r2 = r7 % 128
            getThreeDSRequestorAppURL = r2
            int r7 = r7 % r0
            r2 = 34
            if (r7 != 0) goto L_0x007b
            r4 = 34
        L_0x007b:
            if (r4 == r2) goto L_0x008d
            int r8 = java.lang.Integer.parseInt(r8)
            r2 = 57
            if (r8 < 0) goto L_0x0088
            r4 = 88
            goto L_0x008a
        L_0x0088:
            r4 = 57
        L_0x008a:
            if (r4 == r2) goto L_0x00fa
            goto L_0x00a0
        L_0x008d:
            int r8 = java.lang.Integer.parseInt(r8)
            r2 = 9
            int r2 = r2 / r5
            r2 = 8
            if (r8 < 0) goto L_0x009b
            r4 = 8
            goto L_0x009d
        L_0x009b:
            r4 = 53
        L_0x009d:
            if (r4 == r2) goto L_0x00a0
            goto L_0x00fa
        L_0x00a0:
            int r2 = getThreeDSRequestorAppURL
            r4 = r2 ^ 3
            r6 = 3
            r2 = r2 & r6
            r2 = r2 | r4
            int r2 = r2 << r3
            int r4 = -r4
            int r4 = ~r4
            int r2 = r2 - r4
            int r2 = r2 - r3
            int r4 = r2 % 128
            isEnableDFSync = r4
            int r2 = r2 % r0
            r4 = 45
            if (r2 == 0) goto L_0x00b8
            r2 = 68
            goto L_0x00ba
        L_0x00b8:
            r2 = 45
        L_0x00ba:
            if (r2 == r4) goto L_0x00c8
            r2 = 56
            if (r8 <= r6) goto L_0x00c3
            r8 = 56
            goto L_0x00c5
        L_0x00c3:
            r8 = 42
        L_0x00c5:
            if (r8 == r2) goto L_0x00fa
            goto L_0x00d4
        L_0x00c8:
            r2 = 5
            r4 = 61
            if (r8 <= r2) goto L_0x00d0
            r8 = 61
            goto L_0x00d2
        L_0x00d0:
            r8 = 87
        L_0x00d2:
            if (r8 == r4) goto L_0x00fa
        L_0x00d4:
            int r8 = isEnableDFSync
            r2 = r8 & -66
            int r4 = ~r8
            r4 = r4 & 65
            r2 = r2 | r4
            r8 = r8 & 65
            int r8 = r8 << r3
            r4 = r2 ^ r8
            r8 = r8 & r2
            int r8 = r8 << r3
            int r4 = r4 + r8
            int r8 = r4 % 128
            getThreeDSRequestorAppURL = r8
            int r4 = r4 % r0
            r8 = 50
            if (r4 != 0) goto L_0x00f0
            r0 = 60
            goto L_0x00f2
        L_0x00f0:
            r0 = 50
        L_0x00f2:
            if (r0 == r8) goto L_0x00f9
            r8 = 0
            int r8 = r8.length     // Catch:{ all -> 0x00f7 }
            return r1
        L_0x00f7:
            r8 = move-exception
            throw r8
        L_0x00f9:
            return r1
        L_0x00fa:
            int r8 = getThreeDSRequestorAppURL
            r1 = r8 ^ 17
            r8 = r8 & 17
            int r8 = r8 << r3
            int r1 = r1 + r8
            int r8 = r1 % 128
            isEnableDFSync = r8
            int r1 = r1 % r0
            return r5
        L_0x0108:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setBaselineAligned.configure(java.lang.String):boolean");
    }

    private void Cardinal(String str) {
        int i = isEnableDFSync;
        boolean z = true;
        int i2 = ((i ^ 57) - (~(-(-((i & 57) << 1))))) - 1;
        getThreeDSRequestorAppURL = i2 % 128;
        int i3 = i2 % 2;
        boolean configure2 = setMinLines.configure(str, 256);
        this.setEnableDFSync = configure2;
        setTransformationMethod settransformationmethod = this.setRenderType;
        if (!configure2) {
            int i4 = getThreeDSRequestorAppURL;
            int i5 = i4 & 5;
            int i6 = (i4 ^ 5) | i5;
            int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
            isEnableDFSync = i7 % 128;
            if ((i7 % 2 != 0 ? 'O' : '\'') != 'O') {
                settransformationmethod.Cardinal = false;
            } else {
                settransformationmethod.Cardinal = true;
            }
            settransformationmethod.getInstance("challengeAddInfo");
        }
        this.getInstance = str;
        int i8 = isEnableDFSync;
        int i9 = i8 & 117;
        int i10 = ((i8 | 117) & (~i9)) + (i9 << 1);
        getThreeDSRequestorAppURL = i10 % 128;
        if (i10 % 2 == 0) {
            z = false;
        }
        if (!z) {
            int i11 = 46 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012c, code lost:
        if ((!com.cardinalcommerce.p060a.setMinLines.configure(r8, 110) ? 9 : kotlin.text.Typography.amp) != 9) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0144, code lost:
        if ((!com.cardinalcommerce.p060a.setMinLines.configure(r8, 45) ? '@' : 14) != 14) goto L_0x0146;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getInstance(java.lang.String r15) throws org.json.JSONException {
        /*
            r14 = this;
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r15.length()
            r3 = 0
            if (r2 <= 0) goto L_0x002a
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0021 }
            r2.<init>(r15)     // Catch:{ JSONException -> 0x0021 }
            int r15 = isEnableDFSync
            r0 = r15 & 55
            r15 = r15 | 55
            int r0 = r0 + r15
            int r15 = r0 % 128
            getThreeDSRequestorAppURL = r15
            int r0 = r0 % 2
            r0 = r2
            goto L_0x002a
        L_0x0021:
            com.cardinalcommerce.a.setTransformationMethod r15 = r14.setRenderType
            r15.Cardinal = r3
            java.lang.String r2 = "ChallengeSelectInfo"
            r15.getInstance(r2)
        L_0x002a:
            r15 = 49
            if (r0 == 0) goto L_0x0031
            r2 = 49
            goto L_0x0033
        L_0x0031:
            r2 = 52
        L_0x0033:
            r4 = 45
            if (r2 == r15) goto L_0x0039
            goto L_0x01d1
        L_0x0039:
            int r15 = getThreeDSRequestorAppURL
            r2 = r15 | 25
            int r5 = r2 << 1
            r15 = r15 & 25
            int r15 = ~r15
            r15 = r15 & r2
            int r5 = r5 - r15
            int r15 = r5 % 128
            isEnableDFSync = r15
            int r5 = r5 % 2
            int r15 = r0.length()
            r2 = 65
            if (r15 <= 0) goto L_0x0055
            r15 = 46
            goto L_0x0057
        L_0x0055:
            r15 = 65
        L_0x0057:
            if (r15 == r2) goto L_0x01d1
            int r15 = isEnableDFSync
            r2 = r15 & 91
            r15 = r15 ^ 91
            r15 = r15 | r2
            int r2 = r2 + r15
            int r15 = r2 % 128
            getThreeDSRequestorAppURL = r15
            int r2 = r2 % 2
            r15 = 1
            if (r2 != 0) goto L_0x006c
            r2 = 1
            goto L_0x006d
        L_0x006c:
            r2 = 0
        L_0x006d:
            int r5 = isEnableDFSync
            r6 = r5 & 9
            r7 = 9
            r5 = r5 ^ r7
            r5 = r5 | r6
            int r5 = -r5
            int r5 = -r5
            r8 = r6 & r5
            r5 = r5 | r6
            int r8 = r8 + r5
            int r5 = r8 % 128
            getThreeDSRequestorAppURL = r5
            int r8 = r8 % 2
        L_0x0081:
            int r5 = r0.length()
            if (r2 >= r5) goto L_0x0089
            r5 = 0
            goto L_0x008a
        L_0x0089:
            r5 = 1
        L_0x008a:
            if (r5 == 0) goto L_0x009e
            r14.CardinalRenderType = r1
            int r0 = isEnableDFSync
            r1 = r0 ^ 109(0x6d, float:1.53E-43)
            r0 = r0 & 109(0x6d, float:1.53E-43)
            int r15 = r0 << 1
            int r1 = r1 + r15
            int r15 = r1 % 128
            getThreeDSRequestorAppURL = r15
            int r1 = r1 % 2
            return
        L_0x009e:
            int r5 = getThreeDSRequestorAppURL
            r6 = r5 ^ 29
            r5 = r5 & 29
            int r5 = r5 << r15
            int r6 = r6 + r5
            int r5 = r6 % 128
            isEnableDFSync = r5
            int r6 = r6 % 2
            org.json.JSONObject r5 = r0.getJSONObject(r2)
            java.util.Iterator r6 = r5.keys()
            int r8 = isEnableDFSync
            r9 = r8 ^ 73
            r10 = r8 & 73
            r9 = r9 | r10
            int r9 = r9 << r15
            int r10 = ~r10
            r8 = r8 | 73
            r8 = r8 & r10
            int r8 = -r8
            r10 = r9 ^ r8
            r8 = r8 & r9
            int r8 = r8 << r15
            int r10 = r10 + r8
            int r8 = r10 % 128
            getThreeDSRequestorAppURL = r8
            int r10 = r10 % 2
        L_0x00cc:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00d4
            r8 = 1
            goto L_0x00d5
        L_0x00d4:
            r8 = 0
        L_0x00d5:
            if (r8 == r15) goto L_0x00f8
            int r2 = r2 + -120
            r5 = r2 | -1
            int r5 = r5 << r15
            r2 = r2 ^ -1
            int r5 = r5 - r2
            r2 = 122(0x7a, float:1.71E-43)
            r6 = r5 | 122(0x7a, float:1.71E-43)
            int r6 = r6 << r15
            r8 = r5 & -123(0xffffffffffffff85, float:NaN)
            int r5 = ~r5
            r2 = r2 & r5
            r2 = r2 | r8
            int r2 = r6 - r2
            int r5 = isEnableDFSync
            int r5 = r5 + 11
            int r5 = r5 - r15
            int r5 = r5 - r15
            int r6 = r5 % 128
            getThreeDSRequestorAppURL = r6
            int r5 = r5 % 2
            goto L_0x0081
        L_0x00f8:
            int r8 = isEnableDFSync
            r9 = r8 ^ 23
            r10 = r8 & 23
            r9 = r9 | r10
            int r9 = r9 << r15
            int r10 = ~r10
            r8 = r8 | 23
            r8 = r8 & r10
            int r8 = -r8
            r10 = r9 ^ r8
            r8 = r8 & r9
            int r8 = r8 << r15
            int r10 = r10 + r8
            int r8 = r10 % 128
            getThreeDSRequestorAppURL = r8
            int r10 = r10 % 2
            if (r10 != 0) goto L_0x0114
            r8 = 0
            goto L_0x0115
        L_0x0114:
            r8 = 1
        L_0x0115:
            if (r8 == r15) goto L_0x012f
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            com.cardinalcommerce.a.setTransformationMethod r9 = r14.setRenderType
            r10 = 110(0x6e, float:1.54E-43)
            boolean r10 = com.cardinalcommerce.p060a.setMinLines.configure(r8, r10)
            if (r10 != 0) goto L_0x012a
            r10 = 9
            goto L_0x012c
        L_0x012a:
            r10 = 38
        L_0x012c:
            if (r10 == r7) goto L_0x0146
            goto L_0x016e
        L_0x012f:
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            com.cardinalcommerce.a.setTransformationMethod r9 = r14.setRenderType
            boolean r10 = com.cardinalcommerce.p060a.setMinLines.configure(r8, r4)
            r11 = 14
            if (r10 != 0) goto L_0x0142
            r10 = 64
            goto L_0x0144
        L_0x0142:
            r10 = 14
        L_0x0144:
            if (r10 == r11) goto L_0x016e
        L_0x0146:
            int r10 = getThreeDSRequestorAppURL
            r11 = r10 | 81
            int r12 = r11 << 1
            r10 = r10 & 81
            int r10 = ~r10
            r10 = r10 & r11
            int r10 = -r10
            r11 = r12 | r10
            int r11 = r11 << r15
            r10 = r10 ^ r12
            int r11 = r11 - r10
            int r10 = r11 % 128
            isEnableDFSync = r10
            int r11 = r11 % 2
            r9.Cardinal = r3
            java.lang.String r10 = "challengeSelectInfo name"
            r9.getInstance(r10)
            int r9 = isEnableDFSync
            int r9 = r9 + 78
            int r9 = r9 - r15
            int r10 = r9 % 128
            getThreeDSRequestorAppURL = r10
            int r9 = r9 % 2
        L_0x016e:
            java.lang.Object r9 = r5.get(r8)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            com.cardinalcommerce.a.setTransformationMethod r10 = r14.setRenderType
            boolean r11 = com.cardinalcommerce.p060a.setMinLines.configure(r9, r4)
            java.lang.String r12 = "challengeSelectInfo value"
            if (r11 != 0) goto L_0x0182
            r11 = 0
            goto L_0x0183
        L_0x0182:
            r11 = 1
        L_0x0183:
            if (r11 == r15) goto L_0x01b3
            int r11 = isEnableDFSync
            r13 = r11 & 17
            r11 = r11 | 17
            int r13 = r13 + r11
            int r11 = r13 % 128
            getThreeDSRequestorAppURL = r11
            int r13 = r13 % 2
            r11 = 97
            if (r13 != 0) goto L_0x0199
            r13 = 97
            goto L_0x019a
        L_0x0199:
            r13 = 1
        L_0x019a:
            r10.Cardinal = r3
            r10.getInstance(r12)
            int r10 = getThreeDSRequestorAppURL
            r11 = r10 & 15
            r10 = r10 ^ 15
            r10 = r10 | r11
            int r10 = -r10
            int r10 = -r10
            r12 = r11 | r10
            int r12 = r12 << r15
            r10 = r10 ^ r11
            int r12 = r12 - r10
            int r10 = r12 % 128
            isEnableDFSync = r10
            int r12 = r12 % 2
        L_0x01b3:
            com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds r10 = new com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds
            r10.<init>(r8, r9)
            r1.add(r10)
            int r8 = isEnableDFSync
            r9 = r8 & 7
            r8 = r8 ^ 7
            r8 = r8 | r9
            int r8 = -r8
            int r8 = -r8
            r10 = r9 ^ r8
            r8 = r8 & r9
            int r8 = r8 << r15
            int r10 = r10 + r8
            int r8 = r10 % 128
            getThreeDSRequestorAppURL = r8
            int r10 = r10 % 2
            goto L_0x00cc
        L_0x01d1:
            r14.CardinalRenderType = r1
            int r15 = getThreeDSRequestorAppURL
            r0 = r15 & 45
            r15 = r15 ^ r4
            r15 = r15 | r0
            int r0 = r0 + r15
            int r15 = r0 % 128
            isEnableDFSync = r15
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setBaselineAligned.getInstance(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r12.equals("") == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r0 == false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cca_continue(java.lang.String r12) {
        /*
            r11 = this;
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 ^ 7
            r2 = r0 & 7
            r1 = r1 | r2
            r3 = 1
            int r1 = r1 << r3
            int r2 = ~r2
            r0 = r0 | 7
            r0 = r0 & r2
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            int r0 = r0 << r3
            int r2 = r2 + r0
            int r0 = r2 % 128
            isEnableDFSync = r0
            int r2 = r2 % 2
            r0 = 70
            if (r2 == 0) goto L_0x0020
            r1 = 28
            goto L_0x0022
        L_0x0020:
            r1 = 70
        L_0x0022:
            java.lang.String r2 = ""
            if (r1 == r0) goto L_0x0033
            boolean r0 = r12.equals(r2)
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x021b
            goto L_0x0039
        L_0x0031:
            r12 = move-exception
            throw r12
        L_0x0033:
            boolean r0 = r12.equals(r2)
            if (r0 != 0) goto L_0x021b
        L_0x0039:
            r0 = 0
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0212 }
            r1.<init>(r12)     // Catch:{ JSONException -> 0x0212 }
            int r2 = r1.length()     // Catch:{ JSONException -> 0x0212 }
            r4 = 10
            if (r2 <= r4) goto L_0x0049
            r2 = 1
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            if (r2 == 0) goto L_0x0075
            int r1 = isEnableDFSync
            int r1 = r1 + 73
            int r2 = r1 % 128
            getThreeDSRequestorAppURL = r2
            int r1 = r1 % 2
            com.cardinalcommerce.a.setTransformationMethod r1 = r11.setRenderType     // Catch:{ JSONException -> 0x0212 }
            r1.Cardinal = r0     // Catch:{ JSONException -> 0x0212 }
            r1.getInstance(r12)     // Catch:{ JSONException -> 0x0212 }
            int r12 = getThreeDSRequestorAppURL
            r0 = 13
            r1 = r12 & -14
            int r2 = ~r12
            r2 = r2 & r0
            r1 = r1 | r2
            r12 = r12 & r0
            int r12 = r12 << r3
            int r12 = -r12
            int r12 = -r12
            r0 = r1 & r12
            r12 = r12 | r1
            int r0 = r0 + r12
            int r12 = r0 % 128
            isEnableDFSync = r12
            int r0 = r0 % 2
            return
        L_0x0075:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0212 }
            r12.<init>()     // Catch:{ JSONException -> 0x0212 }
            int r12 = isEnableDFSync
            r2 = r12 ^ 27
            r12 = r12 & 27
            int r12 = r12 << r3
            int r2 = r2 + r12
            int r12 = r2 % 128
            getThreeDSRequestorAppURL = r12
            int r2 = r2 % 2
            r12 = 0
        L_0x0089:
            int r2 = r1.length()     // Catch:{ JSONException -> 0x0212 }
            if (r12 >= r2) goto L_0x01f8
            org.json.JSONObject r2 = r1.getJSONObject(r12)     // Catch:{ JSONException -> 0x0212 }
            com.cardinalcommerce.a.setMinLines r4 = new com.cardinalcommerce.a.setMinLines     // Catch:{ JSONException -> 0x0212 }
            r4.<init>(r2)     // Catch:{ JSONException -> 0x0212 }
            com.cardinalcommerce.a.setTransformationMethod r2 = r11.setRenderType     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r5 = r4.init     // Catch:{ JSONException -> 0x0212 }
            r6 = 64
            boolean r5 = com.cardinalcommerce.p060a.setMinLines.configure(r5, r6)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r7 = "Message Extension Name"
            r8 = 52
            if (r5 != 0) goto L_0x00ab
            r5 = 20
            goto L_0x00ad
        L_0x00ab:
            r5 = 52
        L_0x00ad:
            if (r5 == r8) goto L_0x00d6
            int r5 = getThreeDSRequestorAppURL
            r8 = 115(0x73, float:1.61E-43)
            r9 = r5 & -116(0xffffffffffffff8c, float:NaN)
            int r10 = ~r5
            r10 = r10 & r8
            r9 = r9 | r10
            r5 = r5 & r8
            int r5 = r5 << r3
            int r9 = r9 + r5
            int r5 = r9 % 128
            isEnableDFSync = r5
            int r9 = r9 % 2
            r2.Cardinal = r0     // Catch:{ JSONException -> 0x0212 }
            r2.getInstance(r7)     // Catch:{ JSONException -> 0x0212 }
            int r2 = getThreeDSRequestorAppURL
            r5 = r2 ^ 9
            r2 = r2 & 9
            int r2 = r2 << r3
            int r2 = ~r2
            int r5 = r5 - r2
            int r5 = r5 - r3
            int r2 = r5 % 128
            isEnableDFSync = r2
            int r5 = r5 % 2
        L_0x00d6:
            com.cardinalcommerce.a.setTransformationMethod r2 = r11.setRenderType     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r5 = r4.getInstance     // Catch:{ JSONException -> 0x0212 }
            boolean r5 = com.cardinalcommerce.p060a.setMinLines.configure(r5, r6)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r6 = "Message Extension ID"
            if (r5 != 0) goto L_0x00e4
            r5 = 0
            goto L_0x00e5
        L_0x00e4:
            r5 = 1
        L_0x00e5:
            if (r5 == 0) goto L_0x00e8
            goto L_0x010f
        L_0x00e8:
            int r5 = isEnableDFSync
            r7 = r5 | 112(0x70, float:1.57E-43)
            int r7 = r7 << r3
            r5 = r5 ^ 112(0x70, float:1.57E-43)
            int r7 = r7 - r5
            r5 = r7 ^ -1
            r7 = r7 & -1
            int r7 = r7 << r3
            int r5 = r5 + r7
            int r7 = r5 % 128
            getThreeDSRequestorAppURL = r7
            int r5 = r5 % 2
            r2.Cardinal = r0     // Catch:{ JSONException -> 0x0212 }
            r2.getInstance(r6)     // Catch:{ JSONException -> 0x0212 }
            int r2 = isEnableDFSync
            r5 = r2 & 93
            r2 = r2 ^ 93
            r2 = r2 | r5
            int r5 = r5 + r2
            int r2 = r5 % 128
            getThreeDSRequestorAppURL = r2
            int r5 = r5 % 2
        L_0x010f:
            com.cardinalcommerce.a.setTransformationMethod r2 = r11.setRenderType     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r5 = r4.Cardinal     // Catch:{ JSONException -> 0x0212 }
            r6 = 8059(0x1f7b, float:1.1293E-41)
            boolean r5 = com.cardinalcommerce.p060a.setMinLines.configure(r5, r6)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r6 = "Message Extension Data"
            if (r5 != 0) goto L_0x011f
            r5 = 1
            goto L_0x0120
        L_0x011f:
            r5 = 0
        L_0x0120:
            if (r5 == 0) goto L_0x014b
            int r5 = getThreeDSRequestorAppURL
            r7 = 17
            r8 = r5 ^ 17
            r9 = r5 & 17
            r8 = r8 | r9
            int r8 = r8 << r3
            r9 = r5 & -18
            int r5 = ~r5
            r5 = r5 & r7
            r5 = r5 | r9
            int r5 = -r5
            r7 = r8 & r5
            r5 = r5 | r8
            int r7 = r7 + r5
            int r5 = r7 % 128
            isEnableDFSync = r5
            int r7 = r7 % 2
            r2.Cardinal = r0     // Catch:{ JSONException -> 0x0212 }
            r2.getInstance(r6)     // Catch:{ JSONException -> 0x0212 }
            int r2 = isEnableDFSync
            int r2 = r2 + 83
            int r5 = r2 % 128
            getThreeDSRequestorAppURL = r5
            int r2 = r2 % 2
        L_0x014b:
            com.cardinalcommerce.a.setTransformationMethod r2 = r11.setRenderType     // Catch:{ JSONException -> 0x0212 }
            boolean r5 = r4.cca_continue     // Catch:{ JSONException -> 0x0212 }
            r6 = 57
            if (r5 != 0) goto L_0x0156
            r5 = 36
            goto L_0x0158
        L_0x0156:
            r5 = 57
        L_0x0158:
            if (r5 == r6) goto L_0x0177
            int r5 = getThreeDSRequestorAppURL
            int r5 = r5 + 91
            int r6 = r5 % 128
            isEnableDFSync = r6
            int r5 = r5 % 2
            int r5 = isEnableDFSync
            r6 = r5 & 23
            r5 = r5 | 23
            int r5 = -r5
            int r5 = -r5
            int r5 = ~r5
            int r6 = r6 - r5
            int r6 = r6 - r3
            int r5 = r6 % 128
            getThreeDSRequestorAppURL = r5
            int r6 = r6 % 2
            r5 = 1
            goto L_0x0189
        L_0x0177:
            int r5 = getThreeDSRequestorAppURL
            r6 = r5 & 77
            r5 = r5 | 77
            r7 = r6 | r5
            int r7 = r7 << r3
            r5 = r5 ^ r6
            int r7 = r7 - r5
            int r5 = r7 % 128
            isEnableDFSync = r5
            int r7 = r7 % 2
            r5 = 0
        L_0x0189:
            java.lang.String r6 = "Message Extension criticality Indicator"
            if (r5 != 0) goto L_0x018f
            r5 = 1
            goto L_0x0190
        L_0x018f:
            r5 = 0
        L_0x0190:
            if (r5 == r3) goto L_0x0193
            goto L_0x01ae
        L_0x0193:
            int r5 = isEnableDFSync
            int r5 = r5 + 102
            int r5 = r5 - r3
            int r7 = r5 % 128
            getThreeDSRequestorAppURL = r7
            int r5 = r5 % 2
            r2.Cardinal = r0     // Catch:{ JSONException -> 0x0212 }
            r2.getInstance(r6)     // Catch:{ JSONException -> 0x0212 }
            int r2 = getThreeDSRequestorAppURL
            int r2 = r2 + 48
            int r2 = r2 - r3
            int r5 = r2 % 128
            isEnableDFSync = r5
            int r2 = r2 % 2
        L_0x01ae:
            boolean r2 = r4.cca_continue     // Catch:{ JSONException -> 0x0212 }
            if (r2 == 0) goto L_0x01e1
            r11.setProxyAddress = r3     // Catch:{ JSONException -> 0x0212 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0212 }
            r2.<init>()     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r4 = r4.getInstance     // Catch:{ JSONException -> 0x0212 }
            r2.append(r4)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r4 = ","
            r2.append(r4)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r4 = r11.getRenderType     // Catch:{ JSONException -> 0x0212 }
            r2.append(r4)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0212 }
            r11.getRenderType = r2     // Catch:{ JSONException -> 0x0212 }
            int r2 = getThreeDSRequestorAppURL
            r4 = r2 ^ 73
            r2 = r2 & 73
            r2 = r2 | r4
            int r2 = r2 << r3
            int r4 = -r4
            r5 = r2 & r4
            r2 = r2 | r4
            int r5 = r5 + r2
            int r2 = r5 % 128
            isEnableDFSync = r2
            int r5 = r5 % 2
        L_0x01e1:
            r2 = r12 | 1
            int r2 = r2 << r3
            r12 = r12 ^ 1
            int r12 = r2 - r12
            int r2 = getThreeDSRequestorAppURL
            r4 = r2 ^ 81
            r2 = r2 & 81
            int r2 = r2 << r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            isEnableDFSync = r2
            int r4 = r4 % 2
            goto L_0x0089
        L_0x01f8:
            int r12 = isEnableDFSync
            r0 = r12 ^ 65
            r1 = r12 & 65
            r0 = r0 | r1
            int r0 = r0 << r3
            r1 = r12 & -66
            int r12 = ~r12
            r12 = r12 & 65
            r12 = r12 | r1
            int r12 = -r12
            r1 = r0 & r12
            r12 = r12 | r0
            int r1 = r1 + r12
            int r12 = r1 % 128
            getThreeDSRequestorAppURL = r12
            int r1 = r1 % 2
            return
        L_0x0212:
            com.cardinalcommerce.a.setTransformationMethod r12 = r11.setRenderType
            r12.Cardinal = r0
            java.lang.String r0 = "Message Extension"
            r12.getInstance(r0)
        L_0x021b:
            int r12 = isEnableDFSync
            r0 = r12 ^ 121(0x79, float:1.7E-43)
            r1 = r12 & 121(0x79, float:1.7E-43)
            r0 = r0 | r1
            int r0 = r0 << r3
            int r1 = ~r1
            r12 = r12 | 121(0x79, float:1.7E-43)
            r12 = r12 & r1
            int r0 = r0 - r12
            int r12 = r0 % 128
            getThreeDSRequestorAppURL = r12
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setBaselineAligned.cca_continue(java.lang.String):void");
    }

    public setBaselineAligned(String str) throws JSONException {
        this.setProxyAddress = false;
        this.getRenderType = "";
        JSONObject jSONObject = new JSONObject(str);
        this.setRenderType = new setTransformationMethod();
        String optString = jSONObject.optString("threeDSServerTransID");
        boolean Cardinal2 = setMinLines.Cardinal(optString);
        this.setEnableDFSync = Cardinal2;
        setTransformationMethod settransformationmethod = this.setRenderType;
        if (!Cardinal2) {
            settransformationmethod.Cardinal = false;
            settransformationmethod.getInstance("threeDSServerTransID");
        }
        this.configure = optString;
        String optString2 = jSONObject.optString("acsCounterAtoS");
        boolean instance = setMinLines.getInstance(optString2, 3);
        this.setEnableDFSync = instance;
        setTransformationMethod settransformationmethod2 = this.setRenderType;
        if (!instance) {
            settransformationmethod2.Cardinal = false;
            settransformationmethod2.getInstance("acsCounterAtoS");
        }
        this.getEnvironment = optString2;
        String optString3 = jSONObject.optString("acsTransID");
        boolean Cardinal3 = setMinLines.Cardinal(optString3);
        this.setEnableDFSync = Cardinal3;
        setTransformationMethod settransformationmethod3 = this.setRenderType;
        if (!Cardinal3) {
            settransformationmethod3.Cardinal = false;
            settransformationmethod3.getInstance("acsTransID");
        }
        this.cca_continue = optString3;
        String optString4 = jSONObject.optString("challengeCompletionInd");
        boolean Cardinal4 = setMinLines.Cardinal(optString4, new String[]{C16471q.f49113b, "N"});
        this.setEnableDFSync = Cardinal4;
        setTransformationMethod settransformationmethod4 = this.setRenderType;
        if (!Cardinal4) {
            settransformationmethod4.Cardinal = false;
            settransformationmethod4.getInstance("challengeCompletionInd");
        }
        this.getWarnings = optString4;
        String optString5 = jSONObject.optString("transStatus");
        boolean configure2 = setMinLines.configure(optString5, 1);
        this.setEnableDFSync = configure2;
        setTransformationMethod settransformationmethod5 = this.setRenderType;
        if (!configure2) {
            settransformationmethod5.Cardinal = false;
            settransformationmethod5.getInstance("transStatus");
        }
        this.setChallengeTimeout = optString5;
        String optString6 = jSONObject.optString(Constact.KEY_LINK_MESSAGETYPE);
        boolean instance2 = setMinLines.getInstance(optString6, 4);
        this.setEnableDFSync = instance2;
        setTransformationMethod settransformationmethod6 = this.setRenderType;
        if (!instance2) {
            settransformationmethod6.Cardinal = false;
            settransformationmethod6.getInstance(Constact.KEY_LINK_MESSAGETYPE);
        }
        this.CardinalEnvironment = optString6;
        String optString7 = jSONObject.optString("sdkTransID");
        boolean Cardinal5 = setMinLines.Cardinal(optString7);
        this.setEnableDFSync = Cardinal5;
        setTransformationMethod settransformationmethod7 = this.setRenderType;
        if (!Cardinal5) {
            settransformationmethod7.Cardinal = false;
            settransformationmethod7.getInstance("sdkTransID");
        }
        this.setRequestTimeout = optString7;
        String optString8 = jSONObject.optString("messageVersion", "");
        boolean configure3 = setMinLines.configure(optString8, 8);
        this.setEnableDFSync = configure3;
        setTransformationMethod settransformationmethod8 = this.setRenderType;
        if (!configure3) {
            settransformationmethod8.Cardinal = false;
            settransformationmethod8.getInstance("messageVersion");
        }
        this.CardinalConfigurationParameters = optString8;
        String optString9 = jSONObject.optString("acsUiType", "");
        boolean configure4 = configure(optString9);
        this.setEnableDFSync = configure4;
        setTransformationMethod settransformationmethod9 = this.setRenderType;
        if (!configure4) {
            settransformationmethod9.Cardinal = false;
            settransformationmethod9.getInstance("uiType");
        }
        this.init = optString9;
        cca_continue(jSONObject.optString("messageExtension"));
        if (!jSONObject.has("acsUiType")) {
            return;
        }
        if (jSONObject.get("acsUiType").equals("05")) {
            String optString10 = jSONObject.optString("acsHTML");
            if (!setMinLines.configure(optString10, 307200)) {
                setTransformationMethod settransformationmethod10 = this.setRenderType;
                settransformationmethod10.Cardinal = false;
                settransformationmethod10.getInstance("acsHTML");
            } else {
                boolean configure5 = setMinLines.configure(optString10);
                this.setEnableDFSync = configure5;
                setTransformationMethod settransformationmethod11 = this.setRenderType;
                if (!configure5) {
                    settransformationmethod11.Cardinal = false;
                    settransformationmethod11.getInstance("acsHTML");
                }
            }
            this.Cardinal = optString10;
            if (Cardinal()) {
                init("");
            } else {
                init(jSONObject.optString("acsHTMLRefresh"));
            }
        } else {
            String optString11 = jSONObject.optString("challengeInfoHeader");
            boolean configure6 = setMinLines.configure(optString11, 45);
            this.setEnableDFSync = configure6;
            setTransformationMethod settransformationmethod12 = this.setRenderType;
            if (!configure6) {
                settransformationmethod12.Cardinal = false;
                settransformationmethod12.getInstance("challengeInfoHeader");
            }
            this.values = optString11;
            String optString12 = jSONObject.optString("challengeInfoText", "");
            boolean configure7 = setMinLines.configure(optString12, 350);
            this.setEnableDFSync = configure7;
            setTransformationMethod settransformationmethod13 = this.setRenderType;
            if (!configure7) {
                settransformationmethod13.Cardinal = false;
                settransformationmethod13.getInstance("challengeInfoText");
            }
            this.cleanup = optString12.replace("\\n", System.lineSeparator());
            String optString13 = jSONObject.optString("challengeInfoTextIndicator", "");
            boolean init2 = setMinLines.init(optString13, 1);
            this.setEnableDFSync = init2;
            setTransformationMethod settransformationmethod14 = this.setRenderType;
            if (!init2) {
                settransformationmethod14.Cardinal = false;
                settransformationmethod14.getInstance("challengeInfoTextIndicator");
            }
            this.CardinalError = optString13;
            String optString14 = jSONObject.optString("expandInfoLabel");
            boolean configure8 = setMinLines.configure(optString14, 45);
            this.setEnableDFSync = configure8;
            setTransformationMethod settransformationmethod15 = this.setRenderType;
            if (!configure8) {
                settransformationmethod15.Cardinal = false;
                settransformationmethod15.getInstance("expandInfoLabel");
            }
            this.CardinalUiType = optString14;
            String optString15 = jSONObject.optString("expandInfoText");
            boolean configure9 = setMinLines.configure(optString15, 256);
            this.setEnableDFSync = configure9;
            setTransformationMethod settransformationmethod16 = this.setRenderType;
            if (!configure9) {
                settransformationmethod16.Cardinal = false;
                settransformationmethod16.getInstance("expandInfoText");
            }
            this.valueOf = optString15;
            setLinkTextColor setlinktextcolor = new setLinkTextColor(jSONObject.optString("issuerImage"));
            boolean z = setlinktextcolor.init;
            this.setEnableDFSync = z;
            setTransformationMethod settransformationmethod17 = this.setRenderType;
            if (!z) {
                settransformationmethod17.Cardinal = false;
                settransformationmethod17.getInstance("issuerImage");
            }
            this.CardinalActionCode = setlinktextcolor;
            setLinkTextColor setlinktextcolor2 = new setLinkTextColor(jSONObject.optString("psImage"));
            boolean z2 = setlinktextcolor2.init;
            this.setEnableDFSync = z2;
            setTransformationMethod settransformationmethod18 = this.setRenderType;
            if (!z2) {
                settransformationmethod18.Cardinal = false;
                settransformationmethod18.getInstance("psImage");
            }
            this.getString = setlinktextcolor2;
            String optString16 = jSONObject.optString("submitAuthenticationLabel", "");
            boolean configure10 = setMinLines.configure(optString16, 45);
            this.setEnableDFSync = configure10;
            setTransformationMethod settransformationmethod19 = this.setRenderType;
            if (!configure10) {
                settransformationmethod19.Cardinal = false;
                settransformationmethod19.getInstance("submitAuthenticationLabel");
            }
            this.getProxyAddress = optString16;
            String optString17 = jSONObject.optString("whyInfoLabel");
            boolean configure11 = setMinLines.configure(optString17, 45);
            this.setEnableDFSync = configure11;
            setTransformationMethod settransformationmethod20 = this.setRenderType;
            if (!configure11) {
                settransformationmethod20.Cardinal = false;
                settransformationmethod20.getInstance("whyInfoLabel");
            }
            this.getChallengeTimeout = optString17;
            String optString18 = jSONObject.optString("whyInfoText");
            boolean configure12 = setMinLines.configure(optString18, 256);
            this.setEnableDFSync = configure12;
            setTransformationMethod settransformationmethod21 = this.setRenderType;
            if (!configure12) {
                settransformationmethod21.Cardinal = false;
                settransformationmethod21.getInstance("whyInfoText");
            }
            this.setEnvironment = optString18;
            String optString19 = jSONObject.optString("challengeInfoLabel");
            boolean configure13 = setMinLines.configure(optString19, 45);
            this.setEnableDFSync = configure13;
            setTransformationMethod settransformationmethod22 = this.setRenderType;
            if (!configure13) {
                settransformationmethod22.Cardinal = false;
                settransformationmethod22.getInstance("challengeInfoLabel");
            }
            this.getSDKVersion = optString19;
            if (Cardinal()) {
                String optString20 = jSONObject.optString("whitelistingInfoText");
                boolean configure14 = setMinLines.configure(optString20, 64);
                this.setEnableDFSync = configure14;
                setTransformationMethod settransformationmethod23 = this.setRenderType;
                if (!configure14) {
                    settransformationmethod23.Cardinal = false;
                    settransformationmethod23.getInstance("whitelistingInfoText");
                }
                this.getUiType = optString20;
            }
            String string = jSONObject.getString("acsUiType");
            char c = 65535;
            switch (string.hashCode()) {
                case 1537:
                    if (string.equals("01")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1538:
                    if (string.equals("02")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1539:
                    if (string.equals("03")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1540:
                    if (string.equals("04")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                String optString21 = jSONObject.optString("resendInformationLabel", "");
                boolean init3 = setMinLines.init(optString21, 45);
                this.setEnableDFSync = init3;
                setTransformationMethod settransformationmethod24 = this.setRenderType;
                if (!init3) {
                    settransformationmethod24.Cardinal = false;
                    settransformationmethod24.getInstance("resendInformationLabel");
                }
                this.getActionCode = optString21;
            } else if (c == 1 || c == 2) {
                getInstance(jSONObject.optString("challengeSelectInfo"));
            } else if (c == 3) {
                String optString22 = jSONObject.optString("oobAppURL");
                boolean configure15 = setMinLines.configure(optString22, 256);
                this.setEnableDFSync = configure15;
                setTransformationMethod settransformationmethod25 = this.setRenderType;
                if (!configure15) {
                    settransformationmethod25.Cardinal = false;
                    settransformationmethod25.getInstance("oobAppURL");
                }
                this.getUICustomization = optString22;
                jSONObject.optString("oobAppLabel");
                boolean configure16 = setMinLines.configure(this.getUICustomization, 256);
                this.setEnableDFSync = configure16;
                setTransformationMethod settransformationmethod26 = this.setRenderType;
                if (!configure16) {
                    settransformationmethod26.Cardinal = false;
                    settransformationmethod26.getInstance("oobAppLabel");
                }
                String optString23 = jSONObject.optString("oobContinueLabel");
                boolean configure17 = setMinLines.configure(optString23, 256);
                this.setEnableDFSync = configure17;
                setTransformationMethod settransformationmethod27 = this.setRenderType;
                if (!configure17) {
                    settransformationmethod27.Cardinal = false;
                    settransformationmethod27.getInstance("oobContinueLabel");
                }
                this.getRequestTimeout = optString23;
                if (Cardinal()) {
                    Cardinal("");
                } else {
                    Cardinal(jSONObject.optString("challengeAddInfo"));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if ((r5.CardinalConfigurationParameters.isEmpty()) != true) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if ((r0) != true) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if ((!r5.CardinalConfigurationParameters.equals("2.1.0") ? 18 : 'H') != 'H') goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        if ((!r5.CardinalConfigurationParameters.equals("2.1.0") ? 'O' : 29) != 'O') goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009e, code lost:
        r0 = getThreeDSRequestorAppURL;
        r1 = r0 & 121;
        r0 = (r0 ^ 121) | r1;
        r2 = (r1 & r0) + (r0 | r1);
        isEnableDFSync = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00af, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Cardinal() {
        /*
            r5 = this;
            int r0 = isEnableDFSync
            r1 = r0 | 34
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 34
            int r1 = r1 - r0
            r0 = r1 | -1
            int r0 = r0 << r2
            r1 = r1 ^ -1
            int r0 = r0 - r1
            int r1 = r0 % 128
            getThreeDSRequestorAppURL = r1
            int r0 = r0 % 2
            r1 = 33
            if (r0 != 0) goto L_0x001c
            r0 = 33
            goto L_0x001e
        L_0x001c:
            r0 = 47
        L_0x001e:
            r3 = 0
            r4 = 0
            if (r0 == r1) goto L_0x0030
            java.lang.String r0 = r5.CardinalConfigurationParameters
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x002c
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 1
        L_0x002d:
            if (r0 == r2) goto L_0x009e
            goto L_0x0040
        L_0x0030:
            java.lang.String r0 = r5.CardinalConfigurationParameters
            boolean r0 = r0.isEmpty()
            super.hashCode()     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x003d
            r0 = 0
            goto L_0x003e
        L_0x003d:
            r0 = 1
        L_0x003e:
            if (r0 == r2) goto L_0x009e
        L_0x0040:
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 ^ 7
            r0 = r0 & 7
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            isEnableDFSync = r0
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0052
            r0 = 0
            goto L_0x0053
        L_0x0052:
            r0 = 1
        L_0x0053:
            java.lang.String r1 = "2.1.0"
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r5.CardinalConfigurationParameters
            boolean r0 = r0.equals(r1)
            r1 = 72
            if (r0 != 0) goto L_0x0064
            r0 = 18
            goto L_0x0066
        L_0x0064:
            r0 = 72
        L_0x0066:
            if (r0 == r1) goto L_0x009e
            goto L_0x007d
        L_0x0069:
            java.lang.String r0 = r5.CardinalConfigurationParameters
            boolean r0 = r0.equals(r1)
            r1 = 3
            int r1 = r1 / r4
            r1 = 79
            if (r0 != 0) goto L_0x0078
            r0 = 79
            goto L_0x007a
        L_0x0078:
            r0 = 29
        L_0x007a:
            if (r0 == r1) goto L_0x007d
            goto L_0x009e
        L_0x007d:
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 & 118(0x76, float:1.65E-43)
            r0 = r0 | 118(0x76, float:1.65E-43)
            int r1 = r1 + r0
            int r1 = r1 - r4
            int r1 = r1 - r2
            int r0 = r1 % 128
            isEnableDFSync = r0
            int r1 = r1 % 2
            r0 = 92
            if (r1 == 0) goto L_0x0093
            r1 = 65
            goto L_0x0095
        L_0x0093:
            r1 = 92
        L_0x0095:
            if (r1 == r0) goto L_0x009b
            int r0 = r3.length     // Catch:{ all -> 0x0099 }
            return r2
        L_0x0099:
            r0 = move-exception
            throw r0
        L_0x009b:
            return r2
        L_0x009c:
            r0 = move-exception
            throw r0
        L_0x009e:
            int r0 = getThreeDSRequestorAppURL
            r1 = r0 & 121(0x79, float:1.7E-43)
            r0 = r0 ^ 121(0x79, float:1.7E-43)
            r0 = r0 | r1
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            isEnableDFSync = r0
            int r2 = r2 % 2
            return r4
        L_0x00b0:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setBaselineAligned.Cardinal():boolean");
    }
}
