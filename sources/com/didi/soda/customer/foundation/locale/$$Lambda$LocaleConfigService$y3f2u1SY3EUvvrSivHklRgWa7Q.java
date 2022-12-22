package com.didi.soda.customer.foundation.locale;

import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;

/* renamed from: com.didi.soda.customer.foundation.locale.-$$Lambda$LocaleConfigService$y3f-2u1SY3EUvvrSivHklRgWa7Q  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LocaleConfigService$y3f2u1SY3EUvvrSivHklRgWa7Q implements LocaleConfig.ErrorTrackCallBack {
    public static final /* synthetic */ $$Lambda$LocaleConfigService$y3f2u1SY3EUvvrSivHklRgWa7Q INSTANCE = new $$Lambda$LocaleConfigService$y3f2u1SY3EUvvrSivHklRgWa7Q();

    private /* synthetic */ $$Lambda$LocaleConfigService$y3f2u1SY3EUvvrSivHklRgWa7Q() {
    }

    public final void trackError(String str, String str2) {
        ErrorTracker.create(ErrorConst.ErrorName.SALING_C_M_LOCALE_ERROR).addModuleName("locale").addErrorType(str).addErrorMsg(str2).build().trackError();
    }
}
