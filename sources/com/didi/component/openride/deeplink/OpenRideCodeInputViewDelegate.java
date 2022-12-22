package com.didi.component.openride.deeplink;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.ViewClickDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "openride", value = {ViewClickDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/openride/deeplink/OpenRideCodeInputViewDelegate;", "Lcom/didiglobal/scan/delegate/ViewClickDelegate;", "()V", "onEnterPinClick", "", "scheme", "", "comp-openride_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenRideCodeInputViewDelegate.kt */
public final class OpenRideCodeInputViewDelegate implements ViewClickDelegate {
    public void onEnterPinClick(String str) {
        Intrinsics.checkNotNullParameter(str, "scheme");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(scheme)");
        FormStore.getInstance().setOpenRideHasOnlinePayAbility(TextUtils.equals("1", parse.getQueryParameter("pay_method_check_result")) || FormStore.getInstance().getOpenRideHasOnlinePayAbility());
        if (!FormStore.getInstance().getOpenRideHasOnlinePayAbility()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_BIND_CARD);
        } else {
            DRouter.build(str).start();
        }
    }
}
