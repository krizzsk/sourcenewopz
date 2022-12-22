package com.didi.component.homedestination.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import java.util.HashMap;
import java.util.Map;

public class HomeOrderBanRequest extends BaseRequest {

    /* renamed from: a */
    private Context f14102a;

    public HomeOrderBanRequest(Context context) {
        this.f14102a = context;
    }

    public void getOrderBanRequest(Map map, ResponseListener<OrderBanCardInfo> responseListener) {
        if (!NationComponentDataUtil.isLoginNow()) {
            OrderBanCardInfo orderBanCardInfo = new OrderBanCardInfo();
            orderBanCardInfo.errno = 101;
            orderBanCardInfo.errmsg = "Login expired";
            responseListener.onFinish(orderBanCardInfo);
            return;
        }
        if (map == null) {
            map = new HashMap();
        }
        Bff.call(new IBffProxy.Ability.Builder(this.f14102a, BffConstants.AbilityID.ABILITY_GET_ORDER_BAN_INFO).setParams(map).setCallback(new BffTravelCallbackAdapter(responseListener, this.f14102a, true)).build());
    }
}
