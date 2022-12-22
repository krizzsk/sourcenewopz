package com.didi.onekeyshare.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;

public class SmsUtil {
    public static void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            context.startActivity(intent);
        } catch (Exception e) {
            SystemUtils.log(3, "sendSMS Exception", "--->>>" + e.getMessage(), (Throwable) null, "com.didi.onekeyshare.util.SmsUtil", 24);
        }
    }
}
