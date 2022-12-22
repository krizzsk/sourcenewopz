package com.cardinalcommerce.p060a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.Serializable;
import java.util.TimeZone;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setTextSelectHandleRight */
public final class setTextSelectHandleRight implements Serializable, Runnable {
    private static int getProxyAddress = 0;
    private static int setChallengeTimeout = 1;
    public int Cardinal;
    public int CardinalActionCode;
    public int CardinalConfigurationParameters;
    public boolean CardinalEnvironment;
    public boolean CardinalError;
    public char[] CardinalRenderType;
    public char[] CardinalUiType;
    public char[] cca_continue;
    public boolean cleanup;
    public char[] configure;
    public boolean getActionCode;
    private char[] getEnvironment;
    public char[] getInstance;
    public boolean getRequestTimeout;
    public char[] getSDKVersion;
    public boolean getString;
    public boolean getWarnings;
    public char[] init;
    public int setRequestTimeout;
    public char[] valueOf;
    public char[] values;

    setTextSelectHandleRight(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            this.configure = setHorizontallyScrolling.getInstance(telephonyManager.getMmsUAProfUrl());
            this.getInstance = setHorizontallyScrolling.getInstance(telephonyManager.getMmsUserAgent());
            this.Cardinal = telephonyManager.getNetworkType();
            this.getSDKVersion = setHorizontallyScrolling.getInstance(telephonyManager.getNetworkOperator());
            this.values = setHorizontallyScrolling.getInstance(telephonyManager.getNetworkOperatorName());
            this.CardinalRenderType = setHorizontallyScrolling.getInstance(telephonyManager.getSimCountryIso());
            this.CardinalUiType = setHorizontallyScrolling.getInstance(telephonyManager.getSimOperator());
            this.valueOf = setHorizontallyScrolling.getInstance(telephonyManager.getSimOperatorName());
            this.CardinalActionCode = telephonyManager.getSimState();
            this.CardinalEnvironment = telephonyManager.hasIccCard();
            if (Build.VERSION.SDK_INT >= 23) {
                this.setRequestTimeout = telephonyManager.getPhoneCount();
                this.getWarnings = telephonyManager.isHearingAidCompatibilitySupported();
                this.CardinalError = telephonyManager.isTtyModeSupported();
                this.cleanup = telephonyManager.isWorldPhone();
            }
            this.getString = telephonyManager.isNetworkRoaming();
            this.getRequestTimeout = telephonyManager.isSmsCapable();
            if (Build.VERSION.SDK_INT >= 22) {
                this.getActionCode = telephonyManager.isVoiceCapable();
            }
            this.init = setHorizontallyScrolling.getInstance(telephonyManager.getNetworkCountryIso());
            this.cca_continue = setHorizontallyScrolling.getInstance(TimeZone.getDefault().getDisplayName());
            int phoneType = telephonyManager.getPhoneType();
            this.CardinalConfigurationParameters = phoneType;
            if (phoneType == 0) {
                this.getEnvironment = setHorizontallyScrolling.getInstance("PHONE_TYPE_NONE");
            } else if (phoneType == 1) {
                this.getEnvironment = setHorizontallyScrolling.getInstance("PHONE_TYPE_GSM");
            } else if (phoneType == 2) {
                this.getEnvironment = setHorizontallyScrolling.getInstance("CDMA");
            }
        }
    }

    public final JSONObject configure() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("HasIccCard", Boolean.valueOf(this.CardinalEnvironment));
            jSONObject.putOpt("IsHearingAidCompatibilitySupported", Boolean.valueOf(this.getWarnings));
            jSONObject.putOpt("IsNetworkRoaming", Boolean.valueOf(this.getString));
            jSONObject.putOpt("IsSmsCapable", Boolean.valueOf(this.getRequestTimeout));
            jSONObject.putOpt("IsTtySupported", Boolean.valueOf(this.CardinalError));
            jSONObject.putOpt("IsVoiceCapable", Boolean.valueOf(this.getActionCode));
            jSONObject.putOpt("IsWorldPhone", Boolean.valueOf(this.cleanup));
            jSONObject.putOpt("MmsUAProfUrl", setHorizontallyScrolling.configure(this.configure));
            jSONObject.putOpt("MmsUserAgent", setHorizontallyScrolling.configure(this.getInstance));
            jSONObject.putOpt("NetworkCountryISO", setHorizontallyScrolling.configure(this.init));
            jSONObject.putOpt("NetworkOperator", setHorizontallyScrolling.configure(this.getSDKVersion));
            jSONObject.putOpt("NetworkOperatorName", setHorizontallyScrolling.configure(this.values));
            jSONObject.putOpt("NetworkType", Integer.valueOf(this.Cardinal));
            jSONObject.putOpt("PhoneCount", Integer.valueOf(this.setRequestTimeout));
            jSONObject.putOpt("PhoneType", Integer.valueOf(this.CardinalConfigurationParameters));
            jSONObject.putOpt("PhoneTypeString", setHorizontallyScrolling.configure(this.getEnvironment));
            jSONObject.putOpt("SimCountryISO", setHorizontallyScrolling.configure(this.CardinalRenderType));
            jSONObject.putOpt("SimOperator", setHorizontallyScrolling.configure(this.CardinalUiType));
            jSONObject.putOpt("SimOperatorName", setHorizontallyScrolling.configure(this.valueOf));
            jSONObject.putOpt("SimState", Integer.valueOf(this.CardinalActionCode));
            jSONObject.putOpt("TimeZone", setHorizontallyScrolling.configure(this.cca_continue));
            int i = getProxyAddress;
            int i2 = i ^ 101;
            int i3 = (i & 101) << 1;
            int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
            setChallengeTimeout = i4 % 128;
            int i5 = i4 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), (String) null);
        }
        int i6 = setChallengeTimeout;
        int i7 = ((((i6 | 122) << 1) - (i6 ^ 122)) + 0) - 1;
        getProxyAddress = i7 % 128;
        if ((i7 % 2 != 0 ? 18 : Matrix.MATRIX_TYPE_RANDOM_LT) != 18) {
            return jSONObject;
        }
        int i8 = 6 / 0;
        return jSONObject;
    }

    public final void run() {
        int i = getProxyAddress;
        int i2 = (i ^ 73) + ((i & 73) << 1);
        setChallengeTimeout = i2 % 128;
        int i3 = i2 % 2;
        setHorizontallyScrolling.getInstance(this.cca_continue);
        setHorizontallyScrolling.getInstance(this.init);
        this.Cardinal = 0;
        setHorizontallyScrolling.getInstance(this.configure);
        setHorizontallyScrolling.getInstance(this.getInstance);
        setHorizontallyScrolling.getInstance(this.getSDKVersion);
        setHorizontallyScrolling.getInstance(this.values);
        this.getWarnings = false;
        this.CardinalError = false;
        this.cleanup = false;
        setHorizontallyScrolling.getInstance(this.CardinalRenderType);
        setHorizontallyScrolling.getInstance(this.CardinalUiType);
        setHorizontallyScrolling.getInstance(this.valueOf);
        this.CardinalActionCode = 0;
        this.CardinalEnvironment = false;
        this.getString = false;
        this.getRequestTimeout = false;
        this.getActionCode = false;
        this.setRequestTimeout = 0;
        setHorizontallyScrolling.getInstance(this.getEnvironment);
        this.CardinalConfigurationParameters = 0;
        int i4 = setChallengeTimeout;
        int i5 = i4 & 29;
        int i6 = -(-((i4 ^ 29) | i5));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        getProxyAddress = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 79 / 0;
        }
    }
}
