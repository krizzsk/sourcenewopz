package com.didichuxing.foundation.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public abstract class TelephonyUtil {
    public static final String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            String deviceId = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String getSimSerialNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            if (!TextUtils.isEmpty(simSerialNumber)) {
                return simSerialNumber;
            }
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String getSimOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return simOperator;
            }
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String getSimOperatorName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            String simOperatorName = telephonyManager.getSimOperatorName();
            if (!TextUtils.isEmpty(simOperatorName)) {
                return simOperatorName;
            }
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    private TelephonyUtil() {
    }
}
