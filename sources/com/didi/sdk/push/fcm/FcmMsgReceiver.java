package com.didi.sdk.push.fcm;

import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.common.IThirdPartyMsgReceiver;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.util.OrderStatusParamsUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FcmMsgReceiver implements IThirdPartyMsgReceiver {
    private static final String TAG = "DPush-debug";
    private Logger logger = LoggerFactory.getLogger("FcmMsgReceiver");

    public void onReceiveMsg(String str) {
        this.logger.info("fcm onReceiveMsg", new Object[0]);
        Logger logger2 = this.logger;
        logger2.debugEvent(TAG, TAG, "data : " + str);
        OmegaSDKAdapter.trackEvent("fcm_msgreceive_error", "");
        if (!TextUtil.isEmpty(str)) {
            final JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                Logger logger3 = this.logger;
                logger3.infoEvent(TAG, TAG, "onReceiveMsg json error data : " + str);
                e.printStackTrace();
            }
            if (jSONObject != null) {
                if (jSONObject.has("lt")) {
                    try {
                        int i = jSONObject.getInt("lt");
                        DPushBody dPushBody = new DPushBody();
                        dPushBody.setData(jSONObject.toString().getBytes());
                        DPushManager instance = DPushManager.getInstance();
                        String name = DPushType.FCM_PUSH.getName();
                        instance.dispatcherPush(name, dPushBody, "" + i);
                        onIMMsgReceived(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if (Apollo.getToggle("global_fcm_dispatch_in_mainthread").allow()) {
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            FcmMsgReceiver.this.dispatchFcmMessage4Common(jSONObject);
                        }
                    });
                } else {
                    dispatchFcmMessage4Common(jSONObject);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchFcmMessage4Common(JSONObject jSONObject) {
        DPushBody dPushBody = new DPushBody();
        dPushBody.setData(jSONObject.toString().getBytes());
        trackOrderPush(DPushManager.getInstance().dispatcherPush(DPushType.FCM_PUSH.getName(), dPushBody, ScarShareReportModel.CHANNEL_TWITTER), jSONObject);
        FcmPushDispatcher.getInstance().dispatchMessages(dPushBody);
    }

    private void onIMMsgReceived(JSONObject jSONObject) {
        IToggle toggle = Apollo.getToggle("global_im_switch", false);
        if (toggle != null && toggle.allow() && jSONObject.has("c")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("c");
            if (optJSONObject.optInt("ty", 0) == 4096) {
                try {
                    IMEngine.pullMessagesSync(Integer.parseInt(optJSONObject.optString(InternalLogsFeature.ENV_NAME)));
                    OmegaSDKAdapter.trackEvent("IM_PullMessage_ApnsFCM");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void trackOrderPush(boolean z, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            HashMap hashMap = new HashMap();
            hashMap.put("service_send_time", jSONObject.optString("s_time", ""));
            hashMap.put("app_received_time", Long.valueOf(System.currentTimeMillis() / 1000));
            boolean isConnected = PushClient.getClient().isConnected();
            int i = 1;
            hashMap.put("in_background", Integer.valueOf(ActivityLifecycleManager.getInstance().isAppActive() ? 0 : 1));
            hashMap.put("update_order_detail", Integer.valueOf((isConnected || !z) ? 0 : 1));
            hashMap.put("order_id", jSONObject2.optString("order_id", ""));
            hashMap.put("status", Integer.valueOf(jSONObject2.optInt("status", 0)));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(jSONObject2.optInt(ParamKeys.PARAM_SUB_STATUS, 0)));
            hashMap.put("app_received_ntp_time", Long.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000));
            if (TimeServiceManager.getInstance().getNTPTimeDiffMillis() == 0) {
                i = 0;
            }
            hashMap.put("ntp_time_exist", Integer.valueOf(i));
            hashMap.put("local_order_id", OrderStatusParamsUtil.getLocalOrderId());
            hashMap.put("local_status", Integer.valueOf(OrderStatusParamsUtil.getLocalStatus()));
            hashMap.put("local_sub_status", Integer.valueOf(OrderStatusParamsUtil.getLocalSubStatus()));
            OmegaSDKAdapter.trackEvent("gp_OrderStatue_ApnsFCM_rsp", (Map<String, Object>) hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
