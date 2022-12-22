package com.didi.payment.wallet.open;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.open.param.GlobalTopUpParam;

public class TopUpChannelHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        if (request.getContext() != null) {
            boolean z = request.getInt("key_from") != 3;
            GlobalTopUpParam globalTopUpParam = new GlobalTopUpParam();
            globalTopUpParam.page = 0;
            DidiWalletFactory.createGlobalWalletApi().openTopUpPage(request.getContext(), globalTopUpParam, z);
        }
    }
}
