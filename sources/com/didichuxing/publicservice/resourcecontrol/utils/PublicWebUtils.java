package com.didichuxing.publicservice.resourcecontrol.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class PublicWebUtils {
    public static Intent getWebActivity(Context context, String str) {
        Intent intent;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("fusion=true")) {
            intent = new Intent("didi.passenger.intent.action.FusionWebActivity");
        } else {
            intent = new Intent("didi.passenger.intent.action.WebActivity");
        }
        intent.setPackage(context.getPackageName());
        intent.putExtra("url", str);
        return intent;
    }
}
