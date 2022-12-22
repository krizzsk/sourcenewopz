package com.didi.sdk.push.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.push.dpush.LogUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThirdPartyMsgHttpApi {
    public static final int MSG_ARRIVED = 2;
    public static final int MSG_ARRIVED_PASS = 3;
    public static final int MSG_CLICK = 4;
    public static final String URL = "https://msggate.didiglobal.com/server/msgmonitor";

    public interface UploadBackToServerService extends RpcService {
        @Serialization(FormSerializer.class)
        @Path("")
        @Deserialization(StringDeserializer.class)
        void uploadBackToServer(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.WORKER) RpcService.Callback<String> callback);
    }

    @Path("")
    public interface UploadThirdId extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("")
        @Deserialization(StringDeserializer.class)
        void uploadThirdId(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
    }

    public static void uploadThirdId(Context context, UploadThirdIdParams uploadThirdIdParams) {
        uploadThirdId(context, uploadThirdIdParams, (RpcService.Callback<String>) null);
    }

    public static void uploadThirdId(Context context, UploadThirdIdParams uploadThirdIdParams, RpcService.Callback<String> callback) {
        LoginParams loginParams;
        if (uploadThirdIdParams == null) {
            LogUtil.m26293d(4, "uploadThirdId  thirdIdParams is null");
        } else {
            LogUtil.m26293d(4, "uploadThirdId  thirdIdParams : " + uploadThirdIdParams);
        }
        ILoginInfoDelegate loginInfoDelegate = ThirdPartyMsgManager.getInstance().getLoginInfoDelegate();
        if (loginInfoDelegate == null) {
            LogUtil.m26293d(4, "uploadThirdId  loginInfoDelegate is null");
            loginParams = null;
        } else {
            loginParams = loginInfoDelegate.getLoginParams();
        }
        createParams(context, uploadThirdIdParams, loginParams, callback);
    }

    public static void uploadThirdId(Context context, UploadThirdIdParams uploadThirdIdParams, LoginParams loginParams) {
        if (uploadThirdIdParams == null) {
            LogUtil.m26293d(4, "uploadThirdId  thirdIdParams is null");
        } else {
            LogUtil.m26293d(4, "uploadThirdId  thirdIdParams : " + uploadThirdIdParams);
        }
        createParams(context, uploadThirdIdParams, loginParams, (RpcService.Callback<String>) null);
    }

    private static void createParams(Context context, UploadThirdIdParams uploadThirdIdParams, LoginParams loginParams, final RpcService.Callback<String> callback) {
        UploadThirdIdParams uploadThirdIdParams2;
        String str;
        HashMap hashMap = new HashMap();
        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
        if (serverParamsGetter != null) {
            uploadThirdIdParams2 = serverParamsGetter.getUploadThirdIdParams();
            updateThirdIdParams(hashMap, uploadThirdIdParams2);
        } else {
            uploadThirdIdParams2 = null;
        }
        if (uploadThirdIdParams != uploadThirdIdParams2) {
            updateThirdIdParams(hashMap, uploadThirdIdParams);
        }
        if (uploadThirdIdParams == null || uploadThirdIdParams.host == null || TextUtils.isEmpty(uploadThirdIdParams.host)) {
            str = (uploadThirdIdParams2 == null || uploadThirdIdParams2.host == null || TextUtils.isEmpty(uploadThirdIdParams2.host)) ? "" : uploadThirdIdParams2.host;
        } else {
            str = uploadThirdIdParams.host;
        }
        if (loginParams == null || loginParams.token == null || TextUtils.isEmpty(loginParams.token)) {
            LogUtil.m26293d(4, "uploadThirdId  loginParams : " + loginParams);
        } else {
            hashMap.put("uid", loginParams.uid);
            hashMap.put("token", loginParams.token);
            hashMap.put("phone", loginParams.phone);
        }
        hashMap.put("platform", 1);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("push_enabled", Integer.valueOf(NotificationUtil.areNotificationsEnabled(context) ? 1 : 0));
        ((UploadThirdId) new RpcServiceFactory(context).newRpcService(UploadThirdId.class, str)).uploadThirdId(hashMap, new RpcService.Callback<String>() {
            public void onFailure(IOException iOException) {
                LogUtil.m26293d(4, "fail() called with: ");
                try {
                    if (RpcService.Callback.this != null) {
                        RpcService.Callback.this.onFailure(iOException);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(String str) {
                try {
                    LogUtil.m26293d(4, "onSuccess() called with: data = [" + new String(str.getBytes(), "utf-8") + Const.jaRight);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    if (RpcService.Callback.this != null) {
                        RpcService.Callback.this.onSuccess(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public static void uploadBackToServer(Context context, PushAckParams pushAckParams) {
        if (pushAckParams == null) {
            LogUtil.m26293d(4, "uploadBackToServer is null");
            return;
        }
        LogUtil.m26293d(4, "uploadBackToServer params : " + pushAckParams);
        HashMap hashMap = new HashMap();
        hashMap.put("p_id", pushAckParams.pId);
        hashMap.put("state", Integer.valueOf(pushAckParams.state));
        hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, Integer.valueOf(pushAckParams.appType));
        hashMap.put("token", pushAckParams.token);
        ILoginInfoDelegate loginInfoDelegate = ThirdPartyMsgManager.getInstance().getLoginInfoDelegate();
        if (loginInfoDelegate != null) {
            LoginParams loginParams = loginInfoDelegate.getLoginParams();
            LogUtil.m26293d(4, "loginParams : " + loginParams);
            if (loginParams != null) {
                hashMap.put("token", loginParams.token);
            }
        }
        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
        PushAckParams pushAckParams2 = null;
        if (serverParamsGetter != null) {
            pushAckParams2 = serverParamsGetter.getPushAckParams();
        }
        String str = (!TextUtils.isEmpty(pushAckParams.host) || pushAckParams2 == null) ? pushAckParams.host : pushAckParams2.host;
        if (!TextUtils.isEmpty(str)) {
            ((UploadBackToServerService) new RpcServiceFactory(context).newRpcService(UploadBackToServerService.class, str)).uploadBackToServer(hashMap, new RpcService.Callback<String>() {
                public void onSuccess(String str) {
                    LogUtil.m26293d(4, "uploadBackToServer onSuccess() result = " + str);
                }

                public void onFailure(IOException iOException) {
                    LogUtil.m26293d(4, "uploadBackToServer fail");
                }
            });
        }
    }

    private static void updateThirdIdParams(HashMap<String, Object> hashMap, UploadThirdIdParams uploadThirdIdParams) {
        if (uploadThirdIdParams != null) {
            if (uploadThirdIdParams.imei != null && !uploadThirdIdParams.imei.isEmpty()) {
                hashMap.put("imei", uploadThirdIdParams.imei);
            }
            if (uploadThirdIdParams.area_id > -1) {
                hashMap.put("area_id", Integer.valueOf(uploadThirdIdParams.area_id));
            }
            if (uploadThirdIdParams.appversion != null && !uploadThirdIdParams.appversion.isEmpty()) {
                hashMap.put("appversion", uploadThirdIdParams.appversion);
            }
            if (uploadThirdIdParams.brand_id != null && !TextUtils.isEmpty(uploadThirdIdParams.brand_id)) {
                hashMap.put(ServerParam.PARAN_BRAND_ID, uploadThirdIdParams.brand_id);
            }
            if (uploadThirdIdParams.cid != null && !TextUtils.isEmpty(uploadThirdIdParams.cid)) {
                hashMap.put("cid", uploadThirdIdParams.cid);
            }
            if (uploadThirdIdParams.fcm_id != null && !TextUtils.isEmpty(uploadThirdIdParams.fcm_id)) {
                hashMap.put("fcm_id", uploadThirdIdParams.fcm_id);
            }
            if (uploadThirdIdParams.huawei_token != null && !TextUtils.isEmpty(uploadThirdIdParams.huawei_token)) {
                hashMap.put("huawei_token", uploadThirdIdParams.huawei_token);
            }
            if (uploadThirdIdParams.app_type > 0) {
                hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, Integer.valueOf(uploadThirdIdParams.app_type));
            }
            if (!(uploadThirdIdParams.lat == 0.0d || uploadThirdIdParams.lng == 0.0d)) {
                hashMap.put("lat", Double.valueOf(uploadThirdIdParams.lat));
                hashMap.put("lng", Double.valueOf(uploadThirdIdParams.lng));
            }
            if (uploadThirdIdParams.deviceToken != null && !uploadThirdIdParams.deviceToken.isEmpty()) {
                hashMap.put(ParamConst.PARAM_DEVICE_TOKEN, uploadThirdIdParams.deviceToken);
            }
            if (uploadThirdIdParams.device_id != null && !uploadThirdIdParams.device_id.isEmpty()) {
                hashMap.put("device_id", uploadThirdIdParams.device_id);
            }
            if (uploadThirdIdParams.firstOpenTime > 0) {
                hashMap.put("first_open_time", Long.valueOf(uploadThirdIdParams.firstOpenTime));
            }
            if (uploadThirdIdParams.legalAgreement > 0) {
                hashMap.put("legal_agreement", Integer.valueOf(uploadThirdIdParams.legalAgreement));
            }
            if (uploadThirdIdParams.legalAgreementTime > 0) {
                hashMap.put("legal_agreement_time", Long.valueOf(uploadThirdIdParams.legalAgreementTime));
            }
            if (uploadThirdIdParams.foodTabParams != null) {
                if (uploadThirdIdParams.foodTabParams.foodLegalAgreementTime > 0) {
                    hashMap.put("food_legal_agreement_time", Long.valueOf(uploadThirdIdParams.foodTabParams.foodLegalAgreementTime));
                }
                if (uploadThirdIdParams.foodTabParams.isFoodLegalAgreement > -1) {
                    hashMap.put("food_legal_agreement", Integer.valueOf(uploadThirdIdParams.foodTabParams.isFoodLegalAgreement));
                }
                if (uploadThirdIdParams.foodTabParams.foodDeliveryCity != null && !uploadThirdIdParams.foodTabParams.foodDeliveryCity.isEmpty()) {
                    hashMap.put("food_delivery_city", uploadThirdIdParams.foodTabParams.foodDeliveryCity);
                }
            }
            Map<String, Object> extras = uploadThirdIdParams.getExtras();
            Set<Map.Entry<String, Object>> entrySet = extras != null ? extras.entrySet() : null;
            if (entrySet != null && entrySet.size() > 0) {
                for (Map.Entry next : entrySet) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (!(str == null || value == null)) {
                        hashMap.put(str, value);
                    }
                }
            }
        }
    }
}
