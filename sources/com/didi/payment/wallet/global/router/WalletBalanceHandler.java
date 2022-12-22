package com.didi.payment.wallet.global.router;

import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.unifiedPay.util.LogUtil;
import com.google.gson.Gson;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import org.json.JSONObject;

public class WalletBalanceHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        try {
            JSONObject jSONObject = new JSONObject(uri.getQueryParameter("params"));
            PayRichInfo payRichInfo = (PayRichInfo) new Gson().fromJson(jSONObject.optString("balanceMessage"), PayRichInfo.class);
            int optInt = jSONObject.optInt("channelId");
            int optInt2 = jSONObject.optInt("status");
            WalletRouter.gotoAccountBalancePage(request.getContext(), payRichInfo, optInt, jSONObject.optString("detailsMessage"), jSONObject.optDouble("balanceAmount"), optInt2, (IWalletService.AccountInfo) null, true, jSONObject.optInt(GlobalPayOmegaConstant.EventKey.TAB) == 2 ? 7 : 6);
        } catch (Exception e) {
            LogUtil.m31684d("WalletBalanceHandler", "catch exception when receive router request with uri: " + String.valueOf(uri));
            e.printStackTrace();
        }
    }
}
