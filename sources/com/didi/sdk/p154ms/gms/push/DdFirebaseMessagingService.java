package com.didi.sdk.p154ms.gms.push;

import android.text.TextUtils;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.push.PushTokenInterceptor;
import com.didi.sdk.push.common.IThirdPartyMsgParamsGetter;
import com.didi.sdk.push.common.PushAckParams;
import com.didi.sdk.push.common.ThirdPartyMsgHttpApi;
import com.didi.sdk.push.common.ThirdPartyMsgManager;
import com.didi.sdk.push.dpush.LogUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.sdk.ms.gms.push.DdFirebaseMessagingService */
public class DdFirebaseMessagingService extends FirebaseMessagingService {
    public void onNewToken(String str) {
        super.onNewToken(str);
        List<PushTokenInterceptor.Interceptor> interceptors = PushTokenInterceptor.getInterceptors();
        if (interceptors != null) {
            for (PushTokenInterceptor.Interceptor onNewToken : interceptors) {
                onNewToken.onNewToken(getApplicationContext(), str, IMSType.GMS);
            }
        }
        sendRegistrationToServer(str);
    }

    private void sendRegistrationToServer(String str) {
        LogUtil.m26293d(3, "sendRegistrationToServer token: " + str);
        FcmUtil.saveFcmToken(getApplicationContext(), str);
        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
        if (serverParamsGetter == null) {
            LogUtil.m26293d(3, "sendRegistrationToServer IServerParamsGetter is null");
        } else if (!FcmUtil.getSyncStatus(getApplicationContext())) {
            serverParamsGetter.getUploadThirdIdParams().fcm_id = str;
            ThirdPartyMsgHttpApi.uploadThirdId(getApplicationContext(), serverParamsGetter.getUploadThirdIdParams(), (RpcService.Callback<String>) new RpcService.Callback<String>() {
                public void onSuccess(String str) {
                    FcmUtil.saveSyncStatus(DdFirebaseMessagingService.this.getApplicationContext(), true);
                }

                public void onFailure(IOException iOException) {
                    FcmUtil.saveSyncStatus(DdFirebaseMessagingService.this.getApplicationContext(), false);
                }
            });
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        if (remoteMessage == null) {
            LogUtil.m26293d(3, "onMessageReceived null");
            return;
        }
        LogUtil.m26293d(3, "From: " + remoteMessage.getFrom());
        Map<String, String> data = remoteMessage.getData();
        if (data == null) {
            LogUtil.m26293d(3, "onMessageReceived data null");
        }
        if (data != null && data.size() > 0) {
            LogUtil.m26293d(3, "Message data outer payload: " + data);
            String str2 = data.get("payload");
            if (!TextUtils.isEmpty(str2)) {
                ThirdPartyMsgManager.getInstance().dispatchMsg(str2);
                try {
                    String string = new JSONObject(str2).getString("p_id");
                    if (!TextUtils.isEmpty(string)) {
                        PushAckParams pushAckParams = new PushAckParams();
                        pushAckParams.pId = string;
                        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
                        if (!(serverParamsGetter == null || serverParamsGetter.getUploadThirdIdParams() == null)) {
                            pushAckParams.appType = serverParamsGetter.getUploadThirdIdParams().app_type;
                        }
                        pushAckParams.state = 3;
                        ThirdPartyMsgHttpApi.uploadBackToServer(getApplicationContext(), pushAckParams);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                HashMap hashMap = new HashMap();
                if (data == null) {
                    str = "data is null";
                } else {
                    str = data.toString();
                }
                hashMap.put("data", str);
                OmegaSDKAdapter.trackEvent("tech_push_data_no_payload", (Map<String, Object>) hashMap);
            }
        }
        if (remoteMessage.getNotification() != null) {
            LogUtil.m26293d(3, "Message Notification title: " + remoteMessage.getNotification().getTitle() + " body = " + remoteMessage.getNotification().getBody());
        }
    }
}
