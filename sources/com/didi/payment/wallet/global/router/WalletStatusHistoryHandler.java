package com.didi.payment.wallet.global.router;

import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.wallet.view.activity.WalletStatusHistoryActivity;

public class WalletStatusHistoryHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (request.getContext() != null) {
            int i = 0;
            try {
                i = Integer.parseInt(uri.getQueryParameter("product_line"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            WalletStatusHistoryActivity.startActivity(request.getContext(), i);
        }
    }
}
