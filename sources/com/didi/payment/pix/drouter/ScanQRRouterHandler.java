package com.didi.payment.pix.drouter;

import android.net.Uri;
import android.os.Bundle;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.commonsdk.global.WalletGlobal;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.sdk.util.TextUtil;

public class ScanQRRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        try {
            Uri uri = request.getUri();
            PixQrCodeQueryResp.QRCodeData qRCodeData = new PixQrCodeQueryResp.QRCodeData();
            String queryParameter = uri.getQueryParameter("key");
            if (!TextUtil.isEmpty(queryParameter)) {
                qRCodeData.setKey(queryParameter);
                qRCodeData.setQrType(Integer.valueOf(uri.getQueryParameter("qrCodeType")));
                if (uri.getQueryParameter("amount") != null && Integer.valueOf(uri.getQueryParameter("amount")).intValue() > 0) {
                    qRCodeData.setAmount(Integer.valueOf(uri.getQueryParameter("amount")));
                }
                qRCodeData.setQrReferenceId(uri.getQueryParameter("qrReferenceId"));
                Bundle bundle = new Bundle();
                bundle.putSerializable("detected_qrcode", qRCodeData);
                ((Request) DRouter.build(PixRouter.build("/pix_transfer")).putExtras(bundle)).start(WalletGlobal.getAppContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
