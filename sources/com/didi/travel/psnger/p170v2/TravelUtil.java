package com.didi.travel.psnger.p170v2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.KeyUtil;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.IClientConfig;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.bff.BffUtils;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarUpdateAddress;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.api.GetOrderDetailBffCallbackAdapter;
import com.didi.travel.psnger.p170v2.api.GetOrderDetailRpcCallbackAdapter;
import com.didi.travel.psnger.p170v2.session.OrderEvent;
import com.didi.travel.psnger.utils.WindowUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.travel.psnger.v2.TravelUtil */
public class TravelUtil {

    /* renamed from: a */
    private static final String f44244a = TravelUtil.class.getSimpleName();

    /* renamed from: b */
    private static final Map<String, Integer> f44245b = new HashMap();

    /* renamed from: c */
    private static final Map<Integer, String> f44246c = new HashMap();

    /* renamed from: d */
    private static final String f44247d = "*&didi@";

    public static HashMap<String, Object> createBaseParams(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
            hashMap.put("userlat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("userlng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        if (TEBridge.clientConfig() != null) {
            IClientConfig clientConfig = TEBridge.clientConfig();
            hashMap.put("origin_id", clientConfig.originId());
            hashMap.put("map_type", clientConfig.mapType());
            hashMap.put("maptype", clientConfig.mapType());
            hashMap.put("token", clientConfig.token());
            hashMap.put("lang", clientConfig.locale());
            hashMap.put("idfa", clientConfig.idfa());
            hashMap.put("cityIid", Integer.valueOf(clientConfig.cityId()));
        }
        hashMap.put("app_version", SystemUtil.getVersionName());
        hashMap.put("client_type", 1);
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("wifi_mac", SystemUtil.getMacSerialno());
        hashMap.put("pixels", WindowUtil.getScreenPixels());
        hashMap.put("android_id", SecurityUtil.getAndroidID());
        hashMap.put("networkType", SystemUtil.getNetworkType());
        hashMap.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("dviceid", SecurityUtil.getDeviceId());
        hashMap.put("device_id", SecurityUtil.getDeviceId());
        hashMap.put("appversion", SystemUtil.getVersionName());
        hashMap.put("datatype", 1);
        hashMap.put("data_type", "android");
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5.toMD5(SUUIDHelper.getDiDiSUUID() + f44247d).toLowerCase());
        hashMap.put("cancel", sb.toString());
        hashMap.put("sig", SecurityUtil.generateSignature(hashMap));
        hashMap.put("uuid", SecurityUtil.getUUID());
        return hashMap;
    }

    /* renamed from: a */
    private static void m31443a(CarOrder carOrder, CarUpdateAddress carUpdateAddress) {
        if (carOrder != null && carOrder.startAddress != null && carUpdateAddress != null) {
            carOrder.startAddress.latitude = carUpdateAddress.lat;
            carOrder.startAddress.longitude = carUpdateAddress.lng;
            carOrder.startAddress.address = carUpdateAddress.address;
            carOrder.startAddress.displayName = carUpdateAddress.name;
            carOrder.startAddress.uid = carUpdateAddress.poiId;
        }
    }

    public static String generateCarOrderStoreKey(String str) {
        return KeyUtil.generateStoreKey(TravelConstant.BIZ_KEY_EXPRESS, TravelConstant.API_KEY_ORDER_CREATE_ORDER, str);
    }

    public static String generateOrderStatusPollKey(String str) {
        return KeyUtil.generatePollKey(TravelConstant.BIZ_KEY_EXPRESS, TravelConstant.API_KEY_ORDER_GET_ORDER_STATUS, str);
    }

    public static Scene getScene(int i) {
        return ExpressSceneContainer.getInstance().getScene(i);
    }

    /* renamed from: a */
    private static String m31442a(Object obj) {
        if (obj == null) {
            return "object is null";
        }
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

    public static void setCarOrder(CarOrder carOrder) {
        Store store;
        if (carOrder != null && !TextUtils.isEmpty(carOrder.oid) && (store = Store.getStore(generateCarOrderStoreKey(carOrder.oid))) != null) {
            store.setStore(Store.S_NONE_INVOKE_ARGS, carOrder);
        }
    }

    public static void getOrderDetail(Session session, String str, ITravelOrderListener iTravelOrderListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        IExpress iExpress = (IExpress) (session != null ? session.getIBiz(IExpress.class) : TravelSDKV2.getIBiz(IExpress.class));
        if (BffUtils.isBffStageNewFifth()) {
            iExpress.getOrderDetailByBff(hashMap, new GetOrderDetailBffCallbackAdapter(iTravelOrderListener));
        } else {
            iExpress.getOrderDetailByRpc(hashMap, new GetOrderDetailRpcCallbackAdapter(iTravelOrderListener));
        }
    }

    public static void checkSessionCarOrder(String str, CarOrder carOrder) {
        if (carOrder != null && !TextUtils.isEmpty(carOrder.oid)) {
            Store store = Store.getStore(generateCarOrderStoreKey(carOrder.oid));
            if (store == null) {
                LogUtils.m31492e(str, "checkSessionCarOrder:not found carOrder in Store, carOrder.oid = " + getRichOid(carOrder.oid));
            } else if (store.getData() != carOrder) {
                StringBuilder sb = new StringBuilder();
                sb.append("checkSessionCarOrder:the same order is not same object, carOrder = ");
                sb.append(carOrder);
                String str2 = "";
                sb.append(getRichOid(carOrder == null ? str2 : carOrder.oid));
                sb.append(", store = ");
                sb.append(store.getData());
                if (store.getData() != null) {
                    str2 = ((CarOrder) store.getData()).oid;
                }
                sb.append(getRichOid(str2));
                LogUtils.m31492e(str, sb.toString());
            }
        }
    }

    public static Bundle getBundleOnCreateSession(Bundle bundle, boolean z, String str, boolean z2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean(TravelConstant.EXTRA_CREATE_SESSION, z);
        bundle.putString(TravelConstant.EXTRA_SESSION_TAG, str);
        bundle.putBoolean(TravelConstant.EXTRA_IS_FILL_CAR_ORDER_ON_CREATE_SESSION, z2);
        return bundle;
    }

    public static void updateOrderId(int i, String str) {
        BaseEventPublisher.getPublisher().publishSync(EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID, new OrderEvent(i, str));
    }

    public static synchronized void checkAndStoreOid(String str, String str2) {
        synchronized (TravelUtil.class) {
            if (!TextUtils.isEmpty(str)) {
                if (!f44245b.containsKey(str)) {
                    f44245b.put(str, Integer.valueOf(f44246c.size() + 1));
                    f44246c.put(Integer.valueOf(f44246c.size() + 1), str);
                    LogUtils.m31492e(f44244a + "." + str2, "checkAndStoreOid:new oid = " + getRichOid(str));
                }
            }
        }
    }

    public static synchronized String getOid(int i) {
        String str;
        synchronized (TravelUtil.class) {
            str = f44246c.get(Integer.valueOf(i));
        }
        return str;
    }

    public static synchronized int getOidPosition(String str) {
        synchronized (TravelUtil.class) {
            if (!f44245b.containsKey(str)) {
                return -1;
            }
            int intValue = f44245b.get(str).intValue();
            return intValue;
        }
    }

    public static String getRichOid(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + Const.jaLeft + getOidPosition(str) + Const.jaRight;
    }
}
