package com.cardinalcommerce.p060a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.didi.dcrypto.DCryptoMainFragment;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xcrash.TombstoneParser;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawableTintList */
public final class setCompoundDrawableTintList implements Serializable, Runnable {
    private static int getRenderType = 0;
    private static int setRenderType = 1;
    public long Cardinal;
    public char[] CardinalActionCode;
    public int CardinalConfigurationParameters;
    public char[] CardinalEnvironment;
    public char[] CardinalError;
    public char[] CardinalRenderType;
    public char[] CardinalUiType;
    public char[] cca_continue;
    public char[] cleanup;
    public char[] configure;
    public char[] getActionCode;
    public double getChallengeTimeout;
    public double getEnvironment;
    public char[] getInstance;
    public long getProxyAddress;
    public float getRequestTimeout;
    public char[] getSDKVersion;
    public char[] getString;
    private char[] getUiType;
    public char[] getWarnings;
    public char[] init;
    public float setChallengeTimeout;
    private int setEnvironment;
    public char[] setRequestTimeout;
    private char[] setUiType;
    public char[] valueOf;
    public char[] values;

    public setCompoundDrawableTintList(Context context) {
        this.setUiType = setHorizontallyScrolling.getInstance(String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
        this.setEnvironment = (int) context.getResources().getDisplayMetrics().density;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(displayMetrics.widthPixels);
        sb.append("*");
        sb.append(displayMetrics.heightPixels);
        this.cca_continue = setHorizontallyScrolling.getInstance(sb.toString());
        this.getWarnings = setHorizontallyScrolling.getInstance(Resources.getSystem().getConfiguration().locale.toString().replaceAll("_", "-"));
        if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                this.cleanup = setHorizontallyScrolling.getInstance(defaultAdapter.getName());
            }
        } else if (Build.VERSION.SDK_INT >= 31 || ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") != 0) {
            this.cleanup = setHorizontallyScrolling.getInstance(DCryptoMainFragment.DCRYPTO_NA);
        } else {
            BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter2 != null) {
                this.cleanup = setHorizontallyScrolling.getInstance(defaultAdapter2.getName());
            }
        }
        this.CardinalError = setHorizontallyScrolling.getInstance(Build.BOOTLOADER);
        this.init = setHorizontallyScrolling.getInstance(Build.BRAND);
        this.values = setHorizontallyScrolling.getInstance(Build.DEVICE);
        this.getSDKVersion = setHorizontallyScrolling.getInstance(Build.DISPLAY);
        this.CardinalRenderType = setHorizontallyScrolling.getInstance(Build.HARDWARE);
        this.configure = setHorizontallyScrolling.getInstance(Build.MANUFACTURER);
        this.CardinalActionCode = setHorizontallyScrolling.getInstance(Build.PRODUCT);
        this.valueOf = setHorizontallyScrolling.getInstance(Build.RADIO);
        this.getActionCode = setHorizontallyScrolling.getInstance(Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
        this.setRequestTimeout = setHorizontallyScrolling.getInstance(Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
        this.getString = setHorizontallyScrolling.getInstance(Build.TAGS);
        this.Cardinal = Build.TIME;
        this.CardinalEnvironment = setHorizontallyScrolling.getInstance(Build.TYPE);
        this.CardinalUiType = setHorizontallyScrolling.getInstance(Build.USER);
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        this.getRequestTimeout = displayMetrics2.density;
        this.CardinalConfigurationParameters = displayMetrics2.densityDpi;
        this.setChallengeTimeout = displayMetrics2.scaledDensity;
        this.getEnvironment = (double) displayMetrics2.xdpi;
        this.getChallengeTimeout = (double) displayMetrics2.ydpi;
        this.getInstance = setHorizontallyScrolling.getInstance(Build.MODEL);
        this.init = setHorizontallyScrolling.getInstance(Build.BRAND);
        this.configure = setHorizontallyScrolling.getInstance(Build.MANUFACTURER);
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        this.getProxyAddress = statFs.getTotalBytes();
        this.getUiType = setHorizontallyScrolling.getInstance(statFs.toString());
    }

    public final JSONObject cca_continue() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("AdvertisingId", setHorizontallyScrolling.configure((char[]) null));
            jSONObject.putOpt("BootLoader", setHorizontallyScrolling.configure(this.CardinalError));
            jSONObject.putOpt(TombstoneParser.keyBrand, setHorizontallyScrolling.configure(this.init));
            jSONObject.putOpt("ColorDepth", setHorizontallyScrolling.configure(this.setUiType));
            jSONObject.putOpt("Density", Integer.valueOf(Integer.parseInt(String.valueOf(Math.round(this.getRequestTimeout)))));
            jSONObject.putOpt("DensityDpi", Integer.valueOf(this.CardinalConfigurationParameters));
            jSONObject.putOpt("Device", setHorizontallyScrolling.configure(this.values));
            jSONObject.putOpt("DeviceName", setHorizontallyScrolling.configure(this.cleanup));
            jSONObject.putOpt("Display", setHorizontallyScrolling.configure(this.getSDKVersion));
            jSONObject.putOpt("GetTotalBytes", Long.valueOf(this.getProxyAddress));
            jSONObject.putOpt("Hardware", setHorizontallyScrolling.configure(this.CardinalRenderType));
            jSONObject.putOpt("Locale", setHorizontallyScrolling.configure(this.getWarnings));
            jSONObject.putOpt(TombstoneParser.keyManufacturer, setHorizontallyScrolling.configure(this.configure));
            jSONObject.putOpt("Model", setHorizontallyScrolling.configure(this.getInstance));
            jSONObject.putOpt("Product", setHorizontallyScrolling.configure(this.CardinalActionCode));
            jSONObject.putOpt("Radio", setHorizontallyScrolling.configure(this.valueOf));
            jSONObject.putOpt("ScaledDensity", Float.valueOf(this.setChallengeTimeout));
            jSONObject.putOpt("ScreenDensity", Integer.valueOf(this.setEnvironment));
            jSONObject.putOpt("ScreenResolution", setHorizontallyScrolling.configure(this.cca_continue));
            if (setHorizontallyScrolling.init(this.getActionCode)) {
                jSONObject.putOpt("Supported32BitAbis", new JSONArray(Collections.singletonList(setHorizontallyScrolling.configure(this.getActionCode))));
                int i = (setRenderType + 94) - 1;
                getRenderType = i % 128;
                int i2 = i % 2;
            }
            if (setHorizontallyScrolling.init(this.setRequestTimeout)) {
                jSONObject.putOpt("Supported64BitAbis", new JSONArray(Collections.singletonList(setHorizontallyScrolling.configure(this.setRequestTimeout))));
                int i3 = getRenderType;
                int i4 = i3 & 105;
                int i5 = (i3 ^ 105) | i4;
                int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
                setRenderType = i6 % 128;
                int i7 = i6 % 2;
            }
            jSONObject.putOpt("Tags", setHorizontallyScrolling.configure(this.getString));
            jSONObject.putOpt("Time", String.valueOf(this.Cardinal));
            jSONObject.putOpt("Type", setHorizontallyScrolling.configure(this.CardinalEnvironment));
            jSONObject.putOpt("User", setHorizontallyScrolling.configure(this.CardinalUiType));
            jSONObject.putOpt("Xdpi", Double.valueOf(this.getEnvironment));
            jSONObject.putOpt("Ydpi", Double.valueOf(this.getChallengeTimeout));
            int i8 = getRenderType;
            int i9 = (i8 & 29) + (i8 | 29);
            setRenderType = i9 % 128;
            int i10 = i9 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), (String) null);
        }
        int i11 = (getRenderType + 82) - 1;
        setRenderType = i11 % 128;
        int i12 = i11 % 2;
        return jSONObject;
    }

    public final void run() {
        int i = getRenderType;
        int i2 = (((i ^ 84) + ((i & 84) << 1)) - 0) - 1;
        setRenderType = i2 % 128;
        int i3 = i2 % 2;
        setHorizontallyScrolling.getInstance(this.getInstance);
        setHorizontallyScrolling.getInstance(this.init);
        setHorizontallyScrolling.getInstance(this.configure);
        this.Cardinal = 0;
        setHorizontallyScrolling.getInstance(this.cca_continue);
        this.setEnvironment = 0;
        setHorizontallyScrolling.getInstance(this.setUiType);
        setHorizontallyScrolling.getInstance(this.getWarnings);
        setHorizontallyScrolling.getInstance((char[]) null);
        setHorizontallyScrolling.getInstance(this.cleanup);
        setHorizontallyScrolling.getInstance(this.CardinalError);
        setHorizontallyScrolling.getInstance(this.values);
        setHorizontallyScrolling.getInstance(this.getSDKVersion);
        setHorizontallyScrolling.getInstance(this.CardinalRenderType);
        setHorizontallyScrolling.getInstance(this.CardinalActionCode);
        setHorizontallyScrolling.getInstance(this.valueOf);
        setHorizontallyScrolling.getInstance(this.CardinalUiType);
        setHorizontallyScrolling.getInstance(this.CardinalEnvironment);
        setHorizontallyScrolling.getInstance(this.getString);
        setHorizontallyScrolling.getInstance(this.getActionCode);
        setHorizontallyScrolling.getInstance(this.setRequestTimeout);
        this.getRequestTimeout = 0.0f;
        this.CardinalConfigurationParameters = 0;
        this.setChallengeTimeout = 0.0f;
        this.getEnvironment = 0.0d;
        this.getChallengeTimeout = 0.0d;
        setHorizontallyScrolling.getInstance(this.getUiType);
        this.getProxyAddress = 0;
        int i4 = setRenderType;
        int i5 = (((i4 | 116) << 1) - (i4 ^ 116)) - 1;
        getRenderType = i5 % 128;
        int i6 = i5 % 2;
    }
}
