package com.cardinalcommerce.p060a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawableTintMode */
public final class setCompoundDrawableTintMode implements Serializable, Runnable {
    private static int CardinalActionCode = 0;
    private static int CardinalRenderType = 1;
    public boolean Cardinal;
    public boolean CardinalEnvironment;
    public boolean CardinalError;
    private final setTextMetricsParams CardinalUiType = setTextMetricsParams.getSDKVersion();
    public int cca_continue;
    public boolean cleanup;
    public char[] configure;
    public char[] getInstance;
    public boolean getSDKVersion;
    public boolean getWarnings;
    public char[] init = setHorizontallyScrolling.getInstance(init());
    public boolean values;

    setCompoundDrawableTintMode() {
    }

    public final void init(Context context) {
        int i = CardinalRenderType;
        int i2 = (i ^ 93) + ((i & 93) << 1);
        CardinalActionCode = i2 % 128;
        int i3 = i2 % 2;
        boolean z = false;
        if (!(Build.VERSION.SDK_INT < 23)) {
            int i4 = CardinalRenderType;
            int i5 = i4 & 31;
            int i6 = (i5 - (~((i4 ^ 31) | i5))) - 1;
            CardinalActionCode = i6 % 128;
            int i7 = i6 % 2;
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo wifiInfo = null;
            if (wifiManager != null) {
                z = true;
            }
            if (z) {
                int i8 = CardinalRenderType;
                int i9 = (i8 ^ 25) + ((i8 & 25) << 1);
                CardinalActionCode = i9 % 128;
                int i10 = i9 % 2;
                wifiInfo = wifiManager.getConnectionInfo();
                int i11 = CardinalActionCode;
                int i12 = (i11 ^ 15) + ((i11 & 15) << 1);
                CardinalRenderType = i12 % 128;
                int i13 = i12 % 2;
            }
            if ((wifiInfo != null ? VersionRange.LEFT_OPEN : '^') == '(') {
                int i14 = CardinalActionCode;
                int i15 = i14 & 65;
                int i16 = (i14 | 65) & (~i15);
                int i17 = -(-(i15 << 1));
                int i18 = (i16 & i17) + (i16 | i17);
                CardinalRenderType = i18 % 128;
                int i19 = i18 % 2;
                this.getInstance = setHorizontallyScrolling.getInstance(wifiInfo.getBSSID());
                this.configure = setHorizontallyScrolling.getInstance(wifiInfo.getSSID());
                this.cca_continue = wifiInfo.getNetworkId();
                this.Cardinal = wifiManager.is5GHzBandSupported();
                this.values = wifiManager.isDeviceToApRttSupported();
                this.CardinalError = wifiManager.isEnhancedPowerReportingSupported();
                this.cleanup = wifiManager.isP2pSupported();
                this.getSDKVersion = wifiManager.isPreferredNetworkOffloadSupported();
                this.getWarnings = wifiManager.isTdlsSupported();
                this.CardinalEnvironment = wifiManager.isScanAlwaysAvailable();
                int i20 = CardinalRenderType;
                int i21 = i20 & 41;
                int i22 = -(-((i20 ^ 41) | i21));
                int i23 = (i21 & i22) + (i22 | i21);
                CardinalActionCode = i23 % 128;
                int i24 = i23 % 2;
            }
        }
        int i25 = CardinalActionCode + 15;
        CardinalRenderType = i25 % 128;
        int i26 = i25 % 2;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r1 = r6.getHostAddress();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cc, code lost:
        r4 = CardinalActionCode;
        r5 = ((r4 ^ 32) + ((r4 & 32) << 1)) - 1;
        CardinalRenderType = r5 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        if ((r5 % 2) != 0) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e0, code lost:
        r3 = '!';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
        if (r3 == '!') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ea, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String init() {
        /*
            r9 = this;
            int r0 = CardinalRenderType
            r1 = r0 | 89
            int r2 = r1 << 1
            r3 = 89
            r0 = r0 & r3
            int r0 = ~r0
            r0 = r0 & r1
            int r0 = -r0
            r1 = r2 & r0
            r0 = r0 | r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            CardinalActionCode = r0
            int r1 = r1 % 2
            r0 = 0
            r1 = 0
            r2 = 1
            java.util.Enumeration r4 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x0110 }
            int r5 = CardinalActionCode
            r6 = r5 ^ 113(0x71, float:1.58E-43)
            r5 = r5 & 113(0x71, float:1.58E-43)
            int r5 = r5 << r2
            r7 = r6 & r5
            r5 = r5 | r6
            int r7 = r7 + r5
            int r5 = r7 % 128
            CardinalRenderType = r5
            int r7 = r7 % 2
        L_0x002e:
            boolean r5 = r4.hasMoreElements()     // Catch:{ Exception -> 0x0110 }
            r6 = 30
            if (r5 == 0) goto L_0x0039
            r5 = 84
            goto L_0x003b
        L_0x0039:
            r5 = 30
        L_0x003b:
            if (r5 == r6) goto L_0x00fd
            int r5 = CardinalRenderType
            r6 = r5 ^ 75
            r5 = r5 & 75
            int r5 = r5 << r2
            int r6 = r6 + r5
            int r5 = r6 % 128
            CardinalActionCode = r5
            int r6 = r6 % 2
            r5 = 74
            if (r6 == 0) goto L_0x0052
            r6 = 71
            goto L_0x0054
        L_0x0052:
            r6 = 74
        L_0x0054:
            if (r6 == r5) goto L_0x0066
            java.lang.Object r5 = r4.nextElement()     // Catch:{ Exception -> 0x0110 }
            java.net.NetworkInterface r5 = (java.net.NetworkInterface) r5     // Catch:{ Exception -> 0x0110 }
            java.util.Enumeration r5 = r5.getInetAddresses()     // Catch:{ Exception -> 0x0110 }
            r6 = 30
            int r6 = r6 / r1
            goto L_0x0070
        L_0x0064:
            r0 = move-exception
            throw r0
        L_0x0066:
            java.lang.Object r5 = r4.nextElement()     // Catch:{ Exception -> 0x0110 }
            java.net.NetworkInterface r5 = (java.net.NetworkInterface) r5     // Catch:{ Exception -> 0x0110 }
            java.util.Enumeration r5 = r5.getInetAddresses()     // Catch:{ Exception -> 0x0110 }
        L_0x0070:
            boolean r6 = r5.hasMoreElements()     // Catch:{ Exception -> 0x0110 }
            if (r6 == 0) goto L_0x0078
            r6 = 1
            goto L_0x0079
        L_0x0078:
            r6 = 0
        L_0x0079:
            if (r6 == 0) goto L_0x00ed
            int r6 = CardinalActionCode
            int r6 = r6 + 101
            int r6 = r6 - r2
            r7 = r6 ^ -1
            r6 = r6 & -1
            int r6 = r6 << r2
            int r7 = r7 + r6
            int r6 = r7 % 128
            CardinalRenderType = r6
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0090
            r6 = 1
            goto L_0x0091
        L_0x0090:
            r6 = 0
        L_0x0091:
            if (r6 == r2) goto L_0x00a7
            java.lang.Object r6 = r5.nextElement()     // Catch:{ Exception -> 0x0110 }
            java.net.InetAddress r6 = (java.net.InetAddress) r6     // Catch:{ Exception -> 0x0110 }
            boolean r7 = r6.isLoopbackAddress()     // Catch:{ Exception -> 0x0110 }
            r8 = 3
            if (r7 != 0) goto L_0x00a3
            r7 = 61
            goto L_0x00a4
        L_0x00a3:
            r7 = 3
        L_0x00a4:
            if (r7 == r8) goto L_0x00b9
            goto L_0x00c8
        L_0x00a7:
            java.lang.Object r6 = r5.nextElement()     // Catch:{ Exception -> 0x0110 }
            java.net.InetAddress r6 = (java.net.InetAddress) r6     // Catch:{ Exception -> 0x0110 }
            boolean r7 = r6.isLoopbackAddress()     // Catch:{ Exception -> 0x0110 }
            int r8 = r0.length     // Catch:{ all -> 0x00eb }
            if (r7 != 0) goto L_0x00b6
            r7 = 1
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            if (r7 == r2) goto L_0x00c8
        L_0x00b9:
            int r6 = CardinalRenderType
            r7 = r6 ^ 43
            r6 = r6 & 43
            int r6 = r6 << r2
            int r7 = r7 + r6
            int r6 = r7 % 128
            CardinalActionCode = r6
            int r7 = r7 % 2
            goto L_0x0070
        L_0x00c8:
            java.lang.String r1 = r6.getHostAddress()     // Catch:{ Exception -> 0x0110 }
            int r4 = CardinalActionCode
            r5 = r4 ^ 32
            r4 = r4 & 32
            int r4 = r4 << r2
            int r5 = r5 + r4
            int r5 = r5 - r2
            int r2 = r5 % 128
            CardinalRenderType = r2
            int r5 = r5 % 2
            r2 = 33
            if (r5 != 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r3 = 33
        L_0x00e2:
            if (r3 == r2) goto L_0x00ea
            super.hashCode()     // Catch:{ all -> 0x00e8 }
            return r1
        L_0x00e8:
            r0 = move-exception
            throw r0
        L_0x00ea:
            return r1
        L_0x00eb:
            r0 = move-exception
            throw r0
        L_0x00ed:
            int r5 = CardinalActionCode
            r6 = r5 | 39
            int r6 = r6 << r2
            r5 = r5 ^ 39
            int r6 = r6 - r5
            int r5 = r6 % 128
            CardinalRenderType = r5
            int r6 = r6 % 2
            goto L_0x002e
        L_0x00fd:
            int r3 = CardinalActionCode
            r4 = r3 & 105(0x69, float:1.47E-43)
            r3 = r3 ^ 105(0x69, float:1.47E-43)
            r3 = r3 | r4
            int r3 = -r3
            int r3 = -r3
            int r3 = ~r3
            int r4 = r4 - r3
            int r4 = r4 - r2
            int r3 = r4 % 128
            CardinalRenderType = r3
            int r4 = r4 % 2
            goto L_0x011c
        L_0x0110:
            r3 = move-exception
            com.cardinalcommerce.a.setTextMetricsParams r4 = r9.CardinalUiType
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "IP Address"
            r4.configure(r5, r3, r0)
        L_0x011c:
            int r3 = CardinalActionCode
            r4 = r3 & 59
            r3 = r3 | 59
            int r3 = -r3
            int r3 = -r3
            r5 = r4 | r3
            int r2 = r5 << 1
            r3 = r3 ^ r4
            int r2 = r2 - r3
            int r3 = r2 % 128
            CardinalRenderType = r3
            int r2 = r2 % 2
            r3 = 51
            if (r2 != 0) goto L_0x0137
            r2 = 51
            goto L_0x0139
        L_0x0137:
            r2 = 36
        L_0x0139:
            if (r2 == r3) goto L_0x013c
            return r0
        L_0x013c:
            r2 = 87
            int r2 = r2 / r1
            return r0
        L_0x0140:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCompoundDrawableTintMode.init():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String] */
    public final JSONObject getInstance() {
        JSONObject jSONObject = new JSONObject();
        ? r1 = 0;
        try {
            jSONObject.putOpt("Is5GHzBandSupport", Boolean.valueOf(this.Cardinal));
            jSONObject.putOpt("IsDeviceToApRttSupported", Boolean.valueOf(this.values));
            jSONObject.putOpt("IsEnhancedPowerReportingSupported", Boolean.valueOf(this.CardinalError));
            jSONObject.putOpt("IsP2pSupported", Boolean.valueOf(this.cleanup));
            jSONObject.putOpt("IsPreferredNetworkOffloadSupported", Boolean.valueOf(this.getSDKVersion));
            jSONObject.putOpt("IsScanAlwaysAvailable", Boolean.valueOf(this.CardinalEnvironment));
            jSONObject.putOpt("IsTdlsSupported", Boolean.valueOf(this.getWarnings));
            jSONObject.putOpt("BSSID", setHorizontallyScrolling.configure(this.getInstance));
            jSONObject.putOpt("NetworkID", Integer.valueOf(this.cca_continue));
            jSONObject.putOpt("SSID", setHorizontallyScrolling.configure(this.configure));
            int i = CardinalRenderType;
            int i2 = ((((i ^ 33) | (i & 33)) << 1) - (~(-(((~i) & 33) | (i & -34))))) - 1;
            CardinalActionCode = i2 % 128;
            int i3 = i2 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), r1);
        }
        int i4 = CardinalActionCode;
        int i5 = (i4 & 12) + (i4 | 12);
        int i6 = ((i5 | -1) << 1) - (i5 ^ -1);
        CardinalRenderType = i6 % 128;
        if (!(i6 % 2 == 0)) {
            return jSONObject;
        }
        int length = r1.length;
        return jSONObject;
    }

    public final void run() {
        boolean z = true;
        int i = (((CardinalRenderType + 75) - 1) - 0) - 1;
        CardinalActionCode = i % 128;
        int i2 = i % 2;
        setHorizontallyScrolling.getInstance(this.init);
        setHorizontallyScrolling.getInstance(this.getInstance);
        setHorizontallyScrolling.getInstance(this.configure);
        this.cca_continue = 0;
        this.Cardinal = false;
        this.values = false;
        this.CardinalError = false;
        this.cleanup = false;
        this.getSDKVersion = false;
        this.getWarnings = false;
        this.CardinalEnvironment = false;
        int i3 = CardinalActionCode;
        int i4 = (i3 & 13) + (i3 | 13);
        CardinalRenderType = i4 % 128;
        if (i4 % 2 != 0) {
            z = false;
        }
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }
}
