package com.didi.component.common.router;

import android.content.Intent;
import android.net.Uri;
import com.didi.component.common.util.GLog;
import com.didi.consume.orderdetail.view.CsTopupOrderDetailActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.TextUtil;
import com.didi.wallet.dimina.DiminaLaunchModel;

public class TopupOrderDetailHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        int i;
        Uri uri = request.getUri();
        GLog.m7965d("hgl_tag", "TopupOrderDetailHandler uri = " + uri);
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("orderId");
            String queryParameter2 = uri.getQueryParameter(DiminaLaunchModel.PRODUCT_LINE);
            if (TextUtil.isEmpty(queryParameter2) || TextUtil.isEmpty(queryParameter)) {
                GLog.m7965d("hgl_tag", "invalid query params");
                return;
            }
            try {
                i = Integer.valueOf(queryParameter2).intValue();
            } catch (Exception e) {
                GLog.m7965d("hgl_tag", "catch exception when parse productline " + e.getMessage());
                i = -1;
            }
            if (i != -1) {
                Intent intent = new Intent(DIDIApplication.getAppContext(), CsTopupOrderDetailActivity.class);
                intent.putExtra("product_line", i);
                intent.putExtra("order_id", queryParameter);
                intent.putExtra("order_type", 1);
                intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
                intent.putExtra("confirm_button_dismiss", 1);
                GLog.m7965d("hgl_tag", "PayResult Activity productLine: " + i + " order_id:" + queryParameter);
                intent.addFlags(268435456);
                DIDIApplication.getAppContext().startActivity(intent);
            }
        }
    }
}
