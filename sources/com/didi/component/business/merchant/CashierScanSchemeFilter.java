package com.didi.component.business.merchant;

import com.didi.drouter.api.DRouter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.didiglobal.scan.event.ScanCloseEvent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@ServiceProvider({ScanSchemeDispatcherDelegate.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/business/merchant/CashierScanSchemeFilter;", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate;", "()V", "handleScheme", "", "scheme", "", "actionType", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "extraData", "Lcom/google/gson/JsonObject;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierScanSchemeFilter.kt */
public final class CashierScanSchemeFilter implements ScanSchemeDispatcherDelegate {
    public boolean handleScheme(String str, ScanSchemeDispatcherDelegate.ActionType actionType, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(str, "scheme");
        Intrinsics.checkNotNullParameter(actionType, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        boolean equals = ScanSchemeDispatcherDelegate.ActionType.CASHIERCODE.name().equals(actionType.name());
        if (equals) {
            EventBus.getDefault().post(new ScanCloseEvent());
            DRouter.build(str).start();
        }
        return equals;
    }
}
