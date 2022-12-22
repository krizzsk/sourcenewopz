package com.didi.payment.pix.drouter;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.commonsdk.global.WalletGlobal;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.sdk.util.TextUtil;

public class PixRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter("orderId");
        if (!TextUtil.isEmpty(queryParameter)) {
            ((Request) DRouter.build(PixRouter.build("/pix_order_detail")).putExtra("order_id", queryParameter)).start(WalletGlobal.getAppContext());
        }
    }
}
