package com.didi.entrega.customer.foundation.locale;

import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.foundation.sdk.service.LocaleConfig;

/* renamed from: com.didi.entrega.customer.foundation.locale.-$$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8 implements LocaleConfig.ErrorTrackCallBack {
    public static final /* synthetic */ $$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8 INSTANCE = new $$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8();

    private /* synthetic */ $$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8() {
    }

    public final void trackError(String str, String str2) {
        ErrorTracker.create(ErrorConst.ErrorName.SALING_C_M_LOCALE_ERROR).addModuleName("locale").addErrorType(str).addErrorMsg(str2).build().trackError();
    }
}
