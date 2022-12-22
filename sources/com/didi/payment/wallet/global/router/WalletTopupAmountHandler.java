package com.didi.payment.wallet.global.router;

import android.net.Uri;
import android.os.Bundle;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.util.TextUtil;

public class WalletTopupAmountHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (request.getContext() != null) {
            String queryParameter = uri.getQueryParameter("extMetaData");
            Bundle bundle = null;
            if (!TextUtil.isEmpty(queryParameter)) {
                bundle = new Bundle();
                bundle.putInt("order_type", 1);
                bundle.putString(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA, queryParameter);
            }
            WalletRouter.gotoTopupOnlinePay(request.getContext(), bundle, 1771);
        }
    }
}
