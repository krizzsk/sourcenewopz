package com.cardinalcommerce.p060a;

import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.cardinalcommerce.a.setKeyListener */
public class setKeyListener {
    private static int CardinalEnvironment = 1;
    private static int CardinalUiType;
    int Cardinal;
    private byte[] CardinalError;
    HttpsURLConnection cca_continue;
    setMovementMethod cleanup;
    OutputStreamWriter configure;
    String getInstance;
    public ExecutorService getSDKVersion;
    String getWarnings;
    DataOutputStream init;
    HashMap<String, String> values = new HashMap<>();

    public void cca_continue(Exception exc, setMin setmin) {
        int i = CardinalUiType;
        int i2 = (i & 73) + (i | 73);
        CardinalEnvironment = i2 % 128;
        if (!(i2 % 2 != 0)) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void cca_continue(String str) {
        int i = CardinalUiType;
        int i2 = i & 97;
        int i3 = -(-((i ^ 97) | i2));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        CardinalEnvironment = i4 % 128;
        if ((i4 % 2 == 0 ? '0' : '.') == '0') {
            Object obj = null;
            super.hashCode();
        }
    }

    public void configure() {
        int i = CardinalUiType + 82;
        int i2 = ((i | -1) << 1) - (i ^ -1);
        CardinalEnvironment = i2 % 128;
        int i3 = i2 % 2;
    }

    public void getInstance(String str, int i) {
        int i2 = CardinalEnvironment;
        int i3 = i2 & 63;
        int i4 = -(-(i2 | 63));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        CardinalUiType = i5 % 128;
        int i6 = i5 % 2;
    }

    static /* synthetic */ byte[] cca_continue(setKeyListener setkeylistener) {
        int i = (CardinalUiType + 14) - 1;
        CardinalEnvironment = i % 128;
        int i2 = i % 2;
        byte[] bArr = setkeylistener.CardinalError;
        int i3 = CardinalUiType;
        int i4 = i3 ^ 37;
        int i5 = -(-((i3 & 37) << 1));
        int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
        CardinalEnvironment = i6 % 128;
        int i7 = i6 % 2;
        return bArr;
    }

    public final void configure(String str, String str2, int i) {
        int i2 = CardinalUiType;
        int i3 = i2 | 77;
        int i4 = i3 << 1;
        int i5 = -((~(i2 & 77)) & i3);
        int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
        CardinalEnvironment = i6 % 128;
        int i7 = i6 % 2;
        this.getInstance = str;
        this.cleanup = setMovementMethod.JSON;
        this.Cardinal = i;
        this.getWarnings = str2;
        this.values.put("Content-Type", "application/json");
        this.values.put(HttpHeaders.ACCEPT, "application/json");
        this.getSDKVersion = Executors.newFixedThreadPool(5);
        int i8 = CardinalUiType;
        int i9 = (i8 ^ 11) + ((i8 & 11) << 1);
        CardinalEnvironment = i9 % 128;
        int i10 = i9 % 2;
    }

    public final void Cardinal(String str, byte[] bArr) {
        this.getInstance = str;
        this.CardinalError = bArr;
        this.cleanup = setMovementMethod.JOSE;
        this.Cardinal = 10000;
        HashMap<String, String> hashMap = new HashMap<>();
        this.values = hashMap;
        hashMap.put("Content-Type", "application/jose;charset=utf-8");
        this.values.put(HttpHeaders.ACCEPT, "application/jose");
        this.values.put("charset", "UTF-8");
        this.getSDKVersion = Executors.newFixedThreadPool(5);
        int i = CardinalUiType;
        int i2 = ((i | 41) << 1) - (i ^ 41);
        CardinalEnvironment = i2 % 128;
        int i3 = i2 % 2;
    }

    public final boolean init() {
        int i = CardinalEnvironment;
        int i2 = i & 67;
        int i3 = ((i | 67) & (~i2)) + (i2 << 1);
        CardinalUiType = i3 % 128;
        int i4 = i3 % 2;
        boolean isShutdown = this.getSDKVersion.isShutdown();
        int i5 = CardinalUiType;
        int i6 = (i5 & -76) | ((~i5) & 75);
        int i7 = (i5 & 75) << 1;
        int i8 = (i6 & i7) + (i7 | i6);
        CardinalEnvironment = i8 % 128;
        int i9 = i8 % 2;
        return isShutdown;
    }
}
