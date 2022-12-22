package com.didi.component.common.router;

import android.content.Intent;
import android.net.Uri;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.component.common.net.CarServerParam;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import java.net.URLDecoder;
import java.util.Objects;

public class EntregaToRideTripHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (uri != null) {
            try {
                String decode = URLDecoder.decode(uri.getQueryParameter("orderid"), "utf-8");
                int parseInt = Integer.parseInt((String) Objects.requireNonNull(uri.getQueryParameter(CarServerParam.PARAM_PRODUCTID)));
                if (decode != null) {
                    Intent intent = new Intent();
                    intent.setAction(ReceiverConstant.ACTION_RECOVERY);
                    intent.setData(Uri.parse("OneReceiver://" + "extended" + ReceiverConstant.MATCHER_RECOVER));
                    intent.putExtra("oid", decode);
                    intent.putExtra("product_id", parseInt);
                    new GlobalOrderRecovery((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext()).onCurrentOrderRecovery(intent, 999);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
