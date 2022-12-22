package com.didi.payment.base.flutter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;

public class FlutterConstant {
    public static final String FLUTTER_ROUTER_PREFIX = "wallet://flutter";

    public static void route(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            DRouter.build(FLUTTER_ROUTER_PREFIX + str).start(context);
        }
    }
}
