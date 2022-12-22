package com.didi.map.global.component.slideCars.api;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;
import com.didi.sdk.util.TextUtil;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class MultiCarNavigatorImpl extends ICarNavigatorApi {
    public MultiCarNavigatorImpl(Context context) {
        super(context);
    }

    public void getCarNavigator(CarNavigatorRequest carNavigatorRequest, ICarNavigatorCallback iCarNavigatorCallback) {
        if (iCarNavigatorCallback == null) {
            return;
        }
        if (carNavigatorRequest == null) {
            iCarNavigatorCallback.onFails("param can not null");
        } else if (this.context == null) {
            iCarNavigatorCallback.onFails("context can not null");
        } else {
            RequestManager.getInstance(this.context).getMultiCarNavigators(packageParamToMap(carNavigatorRequest), iCarNavigatorCallback, carNavigatorRequest.getClientConfigParam());
        }
    }

    /* access modifiers changed from: protected */
    public Map packageParamToMap(CarNavigatorRequest carNavigatorRequest) {
        HashMap hashMap = new HashMap();
        if (carNavigatorRequest != null) {
            try {
                String phoneNumber = PaxEnvironment.getInstance().getPhoneNumber();
                if (!TextUtil.isEmpty(phoneNumber)) {
                    put(hashMap, "phone_num", phoneNumber + ICarNavigatorApi.PHONE_NUM_SUFFIX);
                }
                if (carNavigatorRequest.getStartPosition() != null) {
                    put(hashMap, "lat", Double.valueOf(carNavigatorRequest.getStartPosition().latitude));
                    put(hashMap, "lng", Double.valueOf(carNavigatorRequest.getStartPosition().longitude));
                }
                if (carNavigatorRequest.getEndPosition() != null) {
                    put(hashMap, "tlat", Double.valueOf(carNavigatorRequest.getEndPosition().latitude));
                    put(hashMap, "tlng", Double.valueOf(carNavigatorRequest.getEndPosition().longitude));
                }
                put(hashMap, "product_id", carNavigatorRequest.getProductId());
                put(hashMap, "type", Integer.valueOf(carNavigatorRequest.getType()));
                put(hashMap, "order_stat", Integer.valueOf(carNavigatorRequest.getOrderState()));
                if (carNavigatorRequest.getSdkMapType() != null && !carNavigatorRequest.getSdkMapType().isEmpty()) {
                    put(hashMap, "sdkmaptype", carNavigatorRequest.getSdkMapType());
                }
                if (carNavigatorRequest.getXtags() != null && !carNavigatorRequest.getXtags().isEmpty()) {
                    put(hashMap, "xtags", carNavigatorRequest.getXtags());
                }
                if (carNavigatorRequest.getExtra() != null && !carNavigatorRequest.getExtra().isEmpty()) {
                    put(hashMap, "extra", carNavigatorRequest.getExtra());
                }
                if (carNavigatorRequest.getBubbleId() != null && !carNavigatorRequest.getBubbleId().isEmpty()) {
                    put(hashMap, "bubble_id", carNavigatorRequest.getBubbleId());
                }
                if (carNavigatorRequest.getCarLevel() != 0) {
                    put(hashMap, "car_level", Integer.valueOf(carNavigatorRequest.getCarLevel()));
                }
                if (carNavigatorRequest.getOrderTab() != 0) {
                    put(hashMap, ServerParamConstant.PARAM_ORDER_TAB, Integer.valueOf(carNavigatorRequest.getOrderTab()));
                }
                if (carNavigatorRequest.getPid() != null && !carNavigatorRequest.getPid().isEmpty()) {
                    put(hashMap, "pid", carNavigatorRequest.getPid());
                }
            } catch (Exception unused) {
                DLog.m7384d("slidingCar", "multi->packageParamToMap ->异常", new Object[0]);
            } catch (Throwable unused2) {
            }
        }
        put(hashMap, "role", Integer.valueOf(PaxEnvironment.getInstance().getRoleType() == RoleType.PASSENGER ? 1 : 0));
        put(hashMap, "radius", 5000);
        put(hashMap, "timestamp", Long.valueOf(System.currentTimeMillis()));
        put(hashMap, "platform", 1);
        put(hashMap, "ostype", 2);
        put(hashMap, "coord_type", 3);
        put(hashMap, "utc_offset", TimeZone.getDefault().getDisplayName(true, 0));
        put(hashMap, "trip_country", PaxEnvironment.getInstance().getCountryCode());
        put(hashMap, "location_country", PaxEnvironment.getInstance().getCountryCode());
        if (carNavigatorRequest.getIsAnyCarIntl() != -1) {
            put(hashMap, ServerParamConstant.PARAM_ANYCAR_TAG, "" + carNavigatorRequest.getIsAnyCarIntl());
        }
        if (carNavigatorRequest.getAnyCarInfo() != null) {
            put(hashMap, ServerParamConstant.PARAM_ANYCAR_INFO, new Gson().toJson((Object) carNavigatorRequest.getAnyCarInfo()));
        }
        if (carNavigatorRequest.getAnyCarPriority() != -1) {
            put(hashMap, ServerParamConstant.PARAM_ANYCAR_PRIORITY, "" + carNavigatorRequest.getAnyCarPriority());
        }
        return hashMap;
        return hashMap;
    }

    protected static void put(Map map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtil.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }
}
