package com.didi.map.global.component.slideCars.api;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;
import com.didi.sdk.util.TextUtil;
import java.util.HashMap;
import java.util.Map;

public class SingleCarNavigatorImpl extends ICarNavigatorApi {
    public SingleCarNavigatorImpl(Context context) {
        super(context);
    }

    public void getCarNavigator(CarNavigatorRequest carNavigatorRequest, ICarNavigatorCallback iCarNavigatorCallback) {
        if (iCarNavigatorCallback == null) {
            return;
        }
        if (carNavigatorRequest == null) {
            iCarNavigatorCallback.onFails("param can not null");
        } else {
            RequestManager.getInstance(this.context).getSingleCarNavigator(packageParamToMap(carNavigatorRequest), iCarNavigatorCallback, carNavigatorRequest.getClientConfigParam());
        }
    }

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
                put(hashMap, "sdkmaptype", carNavigatorRequest.getSdkMapType());
                if (carNavigatorRequest.getDriverId() != null && !carNavigatorRequest.getDriverId().isEmpty()) {
                    put(hashMap, "diverIds", carNavigatorRequest.getDriverId());
                }
            } catch (Exception unused) {
                DLog.m7384d("slidingCar", "single->packageParamToMap ->异常", new Object[0]);
            } catch (Throwable unused2) {
            }
        }
        put(hashMap, "role", Integer.valueOf(PaxEnvironment.getInstance().getRoleType() == RoleType.PASSENGER ? 1 : 0));
        put(hashMap, "token", PaxEnvironment.getInstance().getToken());
        if (carNavigatorRequest.getEndPosition() != null) {
            put(hashMap, "passLocPoints", "[\"" + carNavigatorRequest.getEndPosition().latitude + "|" + carNavigatorRequest.getEndPosition().longitude + "\"]");
        }
        put(hashMap, "is_eta", false);
        put(hashMap, "timestamp", Long.valueOf(System.currentTimeMillis()));
        put(hashMap, "platform", 1);
        put(hashMap, "ostype", 2);
        put(hashMap, "coord_type", 3);
        return hashMap;
        return hashMap;
    }
}
