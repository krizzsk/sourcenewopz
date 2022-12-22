package com.didi.component.common.router;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.component.business.receiver.ServiceReceiver;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.BroadcastSender;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalDelayBillingHandler implements IRouterHandler {

    /* renamed from: a */
    private static final String f11710a = "param";

    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter("param");
        if (queryParameter != null) {
            try {
                if (queryParameter.contains("%")) {
                    queryParameter = URLDecoder.decode(queryParameter, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (!TextUtils.isEmpty(queryParameter)) {
            JSONObject jSONObject = new JSONObject(queryParameter);
            String optString = jSONObject.optString("order_id");
            int optInt = jSONObject.optInt("business_id", 0);
            Intent intent = new Intent();
            intent.setAction(ReceiverConstant.ACTION_SERVICE);
            intent.putExtra("orderid", optString);
            intent.putExtra(ServiceReceiver.BID, optInt);
            BroadcastSender.getInstance(request.getContext()).sendBroadcast(intent);
        }
    }
}
