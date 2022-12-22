package com.didi.payment.pix.drouter;

import android.os.Bundle;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.pix.constant.PixRouter;

public class PixBankAccountRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter("source");
        Bundle bundle = new Bundle();
        bundle.putString("target_fragment", "/pix_bank_transfer");
        bundle.putString("source", queryParameter);
        ((Request) DRouter.build(PixRouter.build("/pix_transfer")).putExtras(bundle)).start(request.getContext());
    }
}
