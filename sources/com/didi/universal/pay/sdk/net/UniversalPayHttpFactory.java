package com.didi.universal.pay.sdk.net;

import android.content.Context;
import com.didi.universal.pay.sdk.model.UniversalPayParams;

public class UniversalPayHttpFactory {
    public static IUniversalPayHttp get(Context context, UniversalPayParams universalPayParams) {
        if (universalPayParams == null) {
            return null;
        }
        if (universalPayParams.isTrip) {
            return new UniversalPayTripHttp(context, universalPayParams);
        }
        return new UniversalPayNoTripHttp(context, universalPayParams);
    }
}
