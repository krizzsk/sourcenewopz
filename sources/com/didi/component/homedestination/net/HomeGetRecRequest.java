package com.didi.component.homedestination.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import java.util.HashMap;
import java.util.Map;

public class HomeGetRecRequest extends BaseRequest {

    /* renamed from: a */
    private Context f14101a;

    public HomeGetRecRequest(Context context) {
        this.f14101a = context;
    }

    public void getRecRequest(Map map, ResponseListener<HomeCardListResponse> responseListener) {
        if (!NationComponentDataUtil.isLoginNow()) {
            HomeCardListResponse homeCardListResponse = new HomeCardListResponse();
            homeCardListResponse.errno = 101;
            homeCardListResponse.errmsg = "Login expired";
            responseListener.onFinish(homeCardListResponse);
            return;
        }
        Map<String, Object> createBaseParams = createBaseParams(this.f14101a);
        if (map != null) {
            Object obj = map.get("user_loc_lng");
            Object obj2 = map.get("user_loc_lat");
            if (obj2 != null && obj != null) {
                if ((obj2 instanceof Double) && (obj instanceof Double)) {
                    double doubleValue = ((Double) obj2).doubleValue();
                    double doubleValue2 = ((Double) obj).doubleValue();
                    if (doubleValue == 0.0d && doubleValue2 == 0.0d) {
                        return;
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("product_id", Integer.valueOf(Integer.parseInt(BusinessDataUtil.getProductId())));
                hashMap.put("acc_key", map.get("acc_key"));
                hashMap.put("platform", "2");
                hashMap.put("app_id", map.get("app_id"));
                hashMap.put("map_type", map.get("map_type"));
                hashMap.put("coordinate_type", map.get("coordinate_type"));
                hashMap.put("requester_type", "1");
                hashMap.put("user_loc_lng", map.get("user_loc_lng"));
                hashMap.put("user_loc_lat", map.get("user_loc_lat"));
                hashMap.put("imei", createBaseParams.get("imei"));
                hashMap.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
                hashMap.put("networky_type", map.get("networky_type"));
                Bff.call(new IBffProxy.Ability.Builder(this.f14101a, BffConstants.AbilityID.ABILITY_GET_RECOMMEND_DEST).setParams(hashMap).setCallback(new BffTravelCallbackAdapter(responseListener, this.f14101a, true)).build());
            }
        }
    }
}
