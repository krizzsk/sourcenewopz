package com.didi.component.splitfare.model;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplitFareManager {
    public static int ACTION_CANCEL = 2;
    public static int ACTION_DEL_USER = 3;
    public static int ACTION_USER_ACCEPT = 1;
    public static int ACTION_USER_REJECT = 2;
    public static int ACTION_USER_STOP = 6;
    public static final int SPLIT_FARE_ACCEPT_ERROR = 700011;
    public static final int SPLIT_FARE_NOT_IN_ORDER_ERROR = 700017;
    public static final int SPLIT_FARE_PAY_CANCEL_FEE = 1020;
    public static final int SPLIT_FARE_UNBIND_CARD_ERROR = 700012;

    /* renamed from: a */
    private static final int f15962a = 0;

    /* renamed from: b */
    private static final int f15963b = 1;

    /* renamed from: c */
    private static final int f15964c = 3;

    /* renamed from: d */
    private final Context f15965d;

    public SplitFareManager(Context context) {
        this.f15965d = context;
    }

    public void acceptSplitFare(Map<String, Object> map, ResponseListener<UpdateSplitFareInfo> responseListener) {
        m11670a(map, ACTION_USER_ACCEPT, responseListener);
    }

    public void rejectSplitFare(Map<String, Object> map, ResponseListener<UpdateSplitFareInfo> responseListener) {
        m11670a(map, ACTION_USER_REJECT, responseListener);
    }

    /* renamed from: a */
    private void m11670a(Map<String, Object> map, int i, ResponseListener<? extends BaseObject> responseListener) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("status", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(this.f15965d, BffConstants.AbilityID.ABILITY_SPLIT_FARE_UPDATE).setParams(map).setCallback(new BffTravelCallbackAdapter(responseListener, this.f15965d)).build());
    }

    public void startSplitFare(Map<String, Object> map, ResponseListener<UpdateSplitFarePartner> responseListener) {
        m11671b(map, 0, responseListener);
    }

    public void deleteSplitFare(CarOrder carOrder, String str, ResponseListener<UpdateSplitFarePartner> responseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", carOrder.getOid());
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jSONArray.put(jSONObject);
        hashMap.put("pids", jSONArray.toString());
        m11671b(hashMap, 1, responseListener);
    }

    public void stopSplitFare(CarOrder carOrder, ResponseListener<UpdateSplitFarePartner> responseListener) {
        HashMap hashMap = new HashMap();
        if (carOrder != null) {
            hashMap.put("order_id", carOrder.getOid());
        }
        JSONArray jSONArray = new JSONArray();
        if (!(carOrder == null || carOrder.splitFareInfo == null || carOrder.splitFareInfo.split_user_list == null)) {
            for (DTSDKSplitFareInfo.SplitUser next : carOrder.splitFareInfo.split_user_list) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(next.pid)) {
                    try {
                        jSONObject.put("pid", next.pid);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                jSONArray.put(jSONObject);
            }
        }
        hashMap.put("pids", new Gson().toJson((Object) jSONArray));
        m11671b(hashMap, 3, responseListener);
    }

    /* renamed from: b */
    private void m11671b(Map<String, Object> map, int i, final ResponseListener<UpdateSplitFarePartner> responseListener) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("type", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(this.f15965d, BffConstants.AbilityID.ABILITY_SPLIT_FARE_UPDATE_PARTNER).setParams(map).setCallback(new RpcService.Callback<JsonObject>() {
            /* JADX INFO: finally extract failed */
            public void onSuccess(JsonObject jsonObject) {
                UpdateSplitFarePartner updateSplitFarePartner = new UpdateSplitFarePartner();
                try {
                    updateSplitFarePartner.parse(jsonObject.toString());
                    if (responseListener != null) {
                        if (updateSplitFarePartner.isAvailable()) {
                            responseListener.onSuccess(updateSplitFarePartner);
                        } else {
                            responseListener.onFail(updateSplitFarePartner);
                        }
                    }
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onFinish(updateSplitFarePartner);
                    }
                } catch (Throwable th) {
                    ResponseListener responseListener2 = responseListener;
                    if (responseListener2 != null) {
                        responseListener2.onFinish(updateSplitFarePartner);
                    }
                    throw th;
                }
            }

            public void onFailure(IOException iOException) {
                if (responseListener != null) {
                    UpdateSplitFarePartner updateSplitFarePartner = new UpdateSplitFarePartner();
                    updateSplitFarePartner.errmsg = ResourcesHelper.getString(DIDIApplication.getAppContext(), R.string.car_confrim_cancel_fail);
                    responseListener.onError(updateSplitFarePartner);
                    responseListener.onFinish(updateSplitFarePartner);
                }
            }
        }).build());
    }

    public static DTSDKSplitFareInfo.SplitUser getSplitFareOwner(CarOrder carOrder) {
        if (carOrder != null && carOrder.isSplitFareOrder()) {
            for (DTSDKSplitFareInfo.SplitUser next : carOrder.splitFareInfo.split_user_list) {
                if (isSplitFareOwner(next)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean isSplitFareOwner(DTSDKSplitFareInfo.SplitUser splitUser) {
        return splitUser != null && splitUser.role == 1;
    }

    public static boolean isMe(DTSDKSplitFareInfo.SplitUser splitUser) {
        String uid = OneLoginFacade.getStore().getUid();
        if (TextUtils.isEmpty(uid)) {
            return false;
        }
        return uid.equals(splitUser.pid);
    }
}
