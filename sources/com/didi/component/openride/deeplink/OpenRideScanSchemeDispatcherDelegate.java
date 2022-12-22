package com.didi.component.openride.deeplink;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.google.gson.JsonObject;

@ServiceProvider({ScanSchemeDispatcherDelegate.class})
public class OpenRideScanSchemeDispatcherDelegate implements ScanSchemeDispatcherDelegate {
    public boolean handleScheme(String str, ScanSchemeDispatcherDelegate.ActionType actionType, JsonObject jsonObject) {
        boolean equals = ScanSchemeDispatcherDelegate.ActionType.OPENRIDE.name().equals(actionType.name());
        if (equals) {
            try {
                boolean equals2 = TextUtils.equals("1", Uri.parse(str).getQueryParameter("pay_method_check_result"));
                FormStore.getInstance().setOpenRideHasOnlinePayAbility(equals2);
                if (!equals2) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_BIND_CARD);
                    return true;
                } else if (jsonObject == null) {
                    return true;
                } else {
                    String jsonObject2 = jsonObject.toString();
                    FormStore.getInstance().setIsFromOpenRide(true);
                    ((Request) DRouter.build(str).putExtra("data", jsonObject2)).start();
                }
            } catch (Exception unused) {
            }
        }
        return equals;
    }
}
