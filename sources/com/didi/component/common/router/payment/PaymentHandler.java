package com.didi.component.common.router.payment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.didi.component.business.constant.BaseExtras;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import java.net.URLDecoder;

public class PaymentHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        try {
            Activity activity = (Activity) request.getContext();
            String queryParameter = uri.getQueryParameter("oid");
            String queryParameter2 = uri.getQueryParameter("bid");
            Bundle bundle = new Bundle();
            bundle.putString("order_id", URLDecoder.decode(queryParameter, "utf-8"));
            bundle.putString("product_id", queryParameter2);
            bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 2);
            Intent intent = new Intent();
            intent.setPackage(activity.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.payment");
            intent.putExtras(bundle);
            ((Request) DRouter.build("").putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).start(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
