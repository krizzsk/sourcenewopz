package com.didi.payment.wallet.open;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.open.param.GlobalTopUpParam;

public class TopUpAmountHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        if (request.getContext() != null) {
            GlobalTopUpParam globalTopUpParam = new GlobalTopUpParam();
            globalTopUpParam.page = 1;
            DidiWalletFactory.createGlobalWalletApi().openTopUpPage(request.getContext(), globalTopUpParam, true);
        }
    }
}
