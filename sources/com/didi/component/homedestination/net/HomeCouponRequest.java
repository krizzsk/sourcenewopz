package com.didi.component.homedestination.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.common.model.HomeCouponPerception;
import com.didi.component.homedestination.model.HomeCouponAssistantModel;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.utils.NumberUtil;
import java.util.HashMap;
import java.util.Map;

public class HomeCouponRequest extends BaseRequest {

    /* renamed from: a */
    private Context f14100a;

    public HomeCouponRequest(Context context) {
        this.f14100a = context;
    }

    public void fetchHomeCoupon(Context context, Map<String, Object> map, ResponseListener<HomeCouponPerception> responseListener) {
        Map<String, Object> a = m9838a(this.f14100a, map);
        if (a != null) {
            a.put("first_login", map.get("first_login"));
            m9839a(this.f14100a, BffConstants.AbilityID.ABILITY_GET_HOME_COUPON_INFO, a, responseListener);
        }
    }

    public void getHomeCouponAssistant(Context context, Map<String, Object> map, ResponseListener<HomeCouponAssistantModel> responseListener) {
        Map<String, Object> a = m9838a(this.f14100a, map);
        if (a != null) {
            m9839a(this.f14100a, BffConstants.AbilityID.ABILITY_COUPON_ASSISTANT_HOME, a, responseListener);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m9838a(Context context, Map<String, Object> map) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", map.get("product_id"));
        hashMap.put("lat", createBaseParams.get("userlat"));
        hashMap.put("lng", createBaseParams.get("userlng"));
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        hashMap.put("location_cityid", Integer.valueOf(NumberUtil.strToInt(nationComponentData.getCityId())));
        hashMap.put("utc_offset", Integer.valueOf(nationComponentData.getTimeZoneUtcOffset()));
        return hashMap;
    }

    /* renamed from: a */
    private <T extends BaseObject> void m9839a(Context context, String str, Map<String, Object> map, ResponseListener<T> responseListener) {
        Bff.call(new IBffProxy.Ability.Builder(context, str).setParams(map).setCallback(new BffTravelCallbackAdapter(responseListener, context)).build());
    }
}
