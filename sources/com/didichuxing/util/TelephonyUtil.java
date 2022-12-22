package com.didichuxing.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didichuxing.diface.logger.DiFaceLogger;

public final class TelephonyUtil {
    public static final String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
        }
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + String.valueOf(Build.BOARD.length() % 10) + String.valueOf(Build.BRAND.length() % 10) + String.valueOf(Build.CPU_ABI.length() % 10) + String.valueOf(Build.DEVICE.length() % 10) + String.valueOf(Build.DISPLAY.length() % 10) + String.valueOf(Build.HOST.length() % 10) + String.valueOf(Build.ID.length() % 10) + String.valueOf(Build.MANUFACTURER.length() % 10) + String.valueOf(Build.MODEL.length() % 10) + String.valueOf(Build.PRODUCT.length() % 10) + String.valueOf(Build.TAGS.length() % 10) + String.valueOf(Build.TYPE.length() % 10) + String.valueOf(Build.USER.length() % 10) + AlgorithmUtil.md5(String.valueOf(SystemUtil.getLastModified()));
    }

    private TelephonyUtil() {
    }
}
