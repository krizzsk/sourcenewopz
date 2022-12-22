package com.didi.security.wireless;

import android.content.Context;
import com.didi.security.uuid.DeviceTokenManager;

public class Region {
    public static void initOne(Context context) {
        AIdClient.getInstance().init(context);
    }

    public static void initTwo(Context context) {
        DeviceTokenManager.getInstance().init(context);
    }

    public static void updateInfo() {
        String str;
        String str2;
        String str3;
        String str4 = "";
        try {
            str3 = DAQUtils.getUserPhone();
            try {
                str2 = DAQUtils.getUserId();
                try {
                    str = DAQUtils.getTicket();
                    try {
                        str4 = DeviceTokenManager.getInstance().getDeviceToken();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str = str4;
                }
            } catch (Exception unused3) {
                str2 = str4;
                str = str2;
                SecurityLib.nativeUpdate(str2, str3, str, str4);
            }
        } catch (Exception unused4) {
            str3 = str4;
            str2 = str3;
            str = str2;
            SecurityLib.nativeUpdate(str2, str3, str, str4);
        }
        SecurityLib.nativeUpdate(str2, str3, str, str4);
    }
}
