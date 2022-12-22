package com.didi.component.openride.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.openride.newscan.GlobalOpenRideDriverInfoConfirmActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/openride/deeplink/OpenRideDriverPageHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "comp-openride_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenRideDriverPageHandler.kt */
public final class OpenRideDriverPageHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            FormStore.getInstance().setOpenRideHasOnlinePayAbility(TextUtils.equals("1", request.getUri().getQueryParameter("pay_method_check_result")));
            Bundle bundle = request.extra;
            String string = bundle == null ? null : bundle.getString("data");
            if (!TextUtils.isEmpty(string)) {
                PinCodeInfoResult pinCodeInfoResult = new PinCodeInfoResult();
                pinCodeInfoResult.parse(new JSONObject().putOpt("data", new JSONObject(string)).toString());
                FormStore.getInstance().setDriverInfo(pinCodeInfoResult);
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (currentActivity != null) {
                    Intent intent = new Intent(currentActivity, GlobalOpenRideDriverInfoConfirmActivity.class);
                    intent.putExtra("data", string);
                    currentActivity.startActivity(intent);
                }
            }
        } catch (Exception unused) {
        }
    }
}
