package com.didichuxing.omega.sdk.common.collector;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class CustomCollector {
    private static String mAppKey = null;
    private static String mChannel = null;
    private static String mDidiDeviceId = "";
    private static String mDidiSuuid;
    private static String mGetuiCid;
    private static String mNewSessionId;
    private static String mSessionId;

    public static void init() {
    }

    public static String getPhoneNumber() {
        return OmegaConfig.PHONE_NUMBER;
    }

    public static String getUid() {
        try {
            if (OmegaConfig.iGetUid == null) {
                return OmegaConfig.userIdFromH5;
            }
            String didiPassengerUid = OmegaConfig.iGetUid.getDidiPassengerUid();
            if (didiPassengerUid != null) {
                return didiPassengerUid;
            }
            return "";
        } catch (Throwable th) {
            Tracker.trackGood("getUid fail", th);
            return "";
        }
    }

    public static String getUtk() {
        String didiToken;
        try {
            if (OmegaConfig.iGetDidiToken == null || (didiToken = OmegaConfig.iGetDidiToken.getDidiToken()) == null || didiToken.length() <= 0) {
                return null;
            }
            return didiToken;
        } catch (Throwable th) {
            Tracker.trackGood("getUtk fail", th);
            return null;
        }
    }

    public static int getCityId() {
        try {
            if (OmegaConfig.iGetCityId != null) {
                return OmegaConfig.iGetCityId.getCityId();
            }
            return OmegaConfig.cityIdFromH5;
        } catch (Throwable th) {
            Tracker.trackGood("getCityId fail", th);
            return 0;
        }
    }

    public static String getPhone() {
        try {
            if (OmegaConfig.iGetPhone == null) {
                return OmegaConfig.phoneNumberFromH5;
            }
            String phone = OmegaConfig.iGetPhone.getPhone();
            if (phone == null || phone.length() <= 0) {
                return null;
            }
            return phone;
        } catch (Throwable th) {
            Tracker.trackGood("getPhone fail", th);
            return null;
        }
    }

    public static String getDailingCountryCode() {
        String dailingCountryCode;
        try {
            if (OmegaConfig.iGetDailingCountryCode == null || (dailingCountryCode = OmegaConfig.iGetDailingCountryCode.getDailingCountryCode()) == null || dailingCountryCode.length() <= 0) {
                return null;
            }
            return dailingCountryCode;
        } catch (Throwable th) {
            Tracker.trackGood("getDailingCountryCode fail", th);
            return null;
        }
    }

    public static void startSession() {
        mSessionId = CommonUtil.randomBase64UUID();
    }

    public static boolean isInSession() {
        return mSessionId != null;
    }

    public static String getSessionId() {
        return mSessionId;
    }

    public static void stopSession() {
        mSessionId = null;
    }

    public static String getNewSessionId() {
        if (TextUtils.isEmpty(mNewSessionId)) {
            mNewSessionId = CommonUtil.randomBase64UUID();
        }
        return mNewSessionId;
    }

    public static String getChannel() {
        return mChannel;
    }

    public static void setChannel(String str) {
        mChannel = str;
    }

    public static String getAppKey() {
        return mAppKey;
    }

    public static void setAppKey(String str) {
        mAppKey = str;
    }

    public static void setDidiDeviceId(String str) {
        mDidiDeviceId = str;
    }

    public static String getDidiDeviceId() {
        return mDidiDeviceId;
    }

    public static void setDidiSuuid(String str) {
        mDidiSuuid = str;
    }

    public static String getDidiSuuid() {
        return mDidiSuuid;
    }

    public static void setGetuiCid(String str) {
        mGetuiCid = str;
    }

    public static String getGetuiCid() {
        return mGetuiCid;
    }
}
