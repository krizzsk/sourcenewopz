package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.Utils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.guideentrance.GuideEntranceParam;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class EntrancePriorityManager {

    /* renamed from: a */
    private static final String f26844a = "EntrancePriorityManager";

    public interface EntranceCallback {
        void onPriorityFail();

        void onPrioritySuccess(GuideEntranceResult guideEntranceResult);
    }

    /* renamed from: a */
    private int m18964a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            return i != 2 ? 0 : 4;
        }
        return 2;
    }

    private EntrancePriorityManager() {
    }

    private static class HOLDER {
        /* access modifiers changed from: private */
        public static EntrancePriorityManager instance = new EntrancePriorityManager();

        private HOLDER() {
        }
    }

    public static EntrancePriorityManager getInstance() {
        return HOLDER.instance;
    }

    public void getEntrancePriorities(Context context, Map map, EntranceParam entranceParam, final EntranceCallback entranceCallback) {
        if (entranceParam != null) {
            GuideEntranceParam guideEntranceParam = new GuideEntranceParam();
            guideEntranceParam.mapType = map.getMapVendor().toString();
            if (entranceParam.selectLat != null) {
                guideEntranceParam.select_lat = entranceParam.selectLat.latitude;
                guideEntranceParam.select_lng = entranceParam.selectLat.longitude;
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(context);
            if (lastKnownLocation != null) {
                guideEntranceParam.user_loc_lat = lastKnownLocation.getLatitude();
                guideEntranceParam.user_loc_lng = lastKnownLocation.getLongitude();
                guideEntranceParam.accuracy = lastKnownLocation.getAccuracy();
                guideEntranceParam.provider = lastKnownLocation.getProvider();
            }
            guideEntranceParam.uid = PaxEnvironment.getInstance().getUid();
            guideEntranceParam.poiInfo = m18965a(entranceParam);
            guideEntranceParam.isCarpool = entranceParam.isCarpool ? 1 : 0;
            guideEntranceParam.orderId = entranceParam.orderId;
            guideEntranceParam.orderStatus = m18964a(entranceParam.orderStatus);
            guideEntranceParam.orderType = String.valueOf(entranceParam.orderType);
            guideEntranceParam.model = Utils.getModel();
            guideEntranceParam.platformVersion = String.valueOf(Build.VERSION.SDK_INT);
            guideEntranceParam.networkType = SystemUtil.getNetworkType();
            int[] batteryLevelAndStatus = com.didi.map.global.flow.utils.SystemUtil.getBatteryLevelAndStatus(context);
            guideEntranceParam.battery = batteryLevelAndStatus[0];
            guideEntranceParam.batteryStatus = batteryLevelAndStatus[1];
            guideEntranceParam.isArAcoreSupported = ARCoreCheckerAndGenerator.checkAvailabilityOfArcoreExtend(context);
            guideEntranceParam.height = DisplayUtils.dp2px(context, 335.0f);
            guideEntranceParam.width = DisplayUtils.dp2px(context, 233.0f);
            guideEntranceParam.heading = 90;
            guideEntranceParam.uid = PaxEnvironment.getInstance().getUid();
            guideEntranceParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            guideEntranceParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            guideEntranceParam.productId = PaxEnvironment.getInstance().getProductId();
            guideEntranceParam.token = PaxEnvironment.getInstance().getToken();
            guideEntranceParam.cityId = PaxEnvironment.getInstance().getCityId();
            guideEntranceParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            guideEntranceParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            DLog.m7384d(f26844a, "getEntrancePriorities: param = " + guideEntranceParam.toString(), new Object[0]);
            PoiBaseApiFactory.createDidiApi(context).getGuideEntrancePriority(guideEntranceParam, new IHttpListener<GuideEntranceResult>() {
                public void onSuccess(GuideEntranceResult guideEntranceResult) {
                    DLog.m7384d(EntrancePriorityManager.f26844a, "entrance priority onSuccess: result = " + guideEntranceResult, new Object[0]);
                    EntranceCallback entranceCallback = entranceCallback;
                    if (entranceCallback != null) {
                        entranceCallback.onPrioritySuccess(guideEntranceResult);
                    }
                }

                public void onFail(IOException iOException) {
                    DLog.m7384d(EntrancePriorityManager.f26844a, "onFail: exception = " + iOException, new Object[0]);
                    EntranceCallback entranceCallback = entranceCallback;
                    if (entranceCallback != null) {
                        entranceCallback.onPriorityFail();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private String m18965a(EntranceParam entranceParam) {
        JSONObject jSONObject = new JSONObject();
        if (entranceParam == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put("poi_id", entranceParam.poiId);
            jSONObject.put("displayname", entranceParam.displayName);
            if (entranceParam.latLng != null) {
                jSONObject.put("lat", entranceParam.latLng.latitude);
                jSONObject.put("lng", entranceParam.latLng.longitude);
            }
            jSONObject.put(DepartureConstants.SRCTAG, entranceParam.srcTag);
            jSONObject.put("coordinate_type", "wgs84");
            if (!TextUtils.isEmpty(entranceParam.walkGuideLink)) {
                jSONObject.put("walk_guide_link", entranceParam.walkGuideLink);
            }
            if (!TextUtils.isEmpty(entranceParam.walkGuidePhoto)) {
                jSONObject.put("walk_guide_photo", entranceParam.walkGuidePhoto);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            SystemUtils.log(6, f26844a, "getEntrancePriorities: create poiInfo error ", (Throwable) null, "com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntrancePriorityManager", 155);
            return "";
        }
    }
}
