package com.didi.component.common.push.handler;

import android.text.TextUtils;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.push.ExpressOrderPush;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderHandler implements PushHandler {
    public void handle(JSONObject jSONObject) {
        try {
            String jSONObject2 = jSONObject.getJSONObject("data").toString();
            ICarOrder order = DDTravelOrderStore.getOrder();
            DTSDKOrderStatus dTSDKOrderStatus = new DTSDKOrderStatus();
            dTSDKOrderStatus.parseRecommendMsg(jSONObject2);
            if (order == null) {
                ExpressOrderPush.sendOrderStatusEvent(TravelUtil.getScene(1008), dTSDKOrderStatus);
            } else if (TextUtils.equals(dTSDKOrderStatus.oid(), order.getOid())) {
                ExpressOrderPush.sendOrderStatusEvent(TravelUtil.getScene(1008), dTSDKOrderStatus);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
