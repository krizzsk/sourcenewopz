package com.didi.sdk.push.manager;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.global.component.slideCars.api.ICarNavigatorApi;
import com.didi.sdk.app.DiPushApolloHelper;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.config.GlobalConfigCenter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.DPushUtil;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushConnectionListener;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushMsgResponse;
import com.didi.sdk.push.PushOption;
import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushRequest;
import com.didi.sdk.push.PushRole;
import com.didi.sdk.spi.IAppTool;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DiDiPush {
    private static boolean isFirstLaunch = true;
    private Context context;
    private Map<DPushListener, PushReceiveListener> listMap = new HashMap();
    private Logger logger = LoggerFactory.getLogger("DiPush");

    DiDiPush() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void initPush(Context context2) {
        this.context = context2;
        setPushOption(context2);
    }

    private void setPushOption(Context context2) {
        IAppTool iAppTool;
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        String phone = nationComponentData.getLoginInfo().getPhone();
        String token = nationComponentData.getLoginInfo().getToken();
        if (DiPushApolloHelper.isNewPhoneFormatOpen(context2) && (iAppTool = (IAppTool) ComponentLoadUtil.getComponent(IAppTool.class)) != null && iAppTool.isBrazilApp(context2) && !TextUtils.isEmpty(phone)) {
            String phoneCountryCode = nationComponentData.getLoginInfo().getPhoneCountryCode();
            if (DPushUtil.isReconnectedThreshold() && DPushUtil.isChinesePrefix(phoneCountryCode)) {
                phoneCountryCode = DPushUtil.defaultBrazilPrefix();
                HashMap hashMap = new HashMap();
                hashMap.put("phone", phone);
                OmegaSDKAdapter.trackEvent("phoneCountryCodeChanged", (Map<String, Object>) hashMap);
            }
            phone = phoneCountryCode + nationComponentData.getLoginInfo().getPhone() + ICarNavigatorApi.PHONE_NUM_SUFFIX;
        }
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(token)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("phone", phone);
            hashMap2.put("token", token);
            hashMap2.put("time", Long.valueOf(System.currentTimeMillis()));
            hashMap2.put("isFirstLaunch", Integer.valueOf(isFirstLaunch ? 1 : 0));
            if (isFirstLaunch) {
                isFirstLaunch = false;
            }
            OmegaSDKAdapter.trackEvent("startPushSetOptions", (Map<String, Object>) hashMap2);
        }
        this.logger.debug("dipush connect phone:    " + phone, new Object[0]);
        PushOption.Builder builder = new PushOption.Builder();
        builder.context(context2.getApplicationContext()).appId("60000").mo95545ip(GlobalConfigCenter.getConfigCenter().getPushParameter().f35704ip).port(GlobalConfigCenter.getConfigCenter().getPushParameter().port).role(PushRole.PSNGER.getValue()).phone(phone).token(token);
        PushOption build = builder.build();
        PushClient.getClient().setOption(build);
        this.logger.debug("setOption ip = " + GlobalConfigCenter.getConfigCenter().getPushParameter().f35704ip + ",port = " + GlobalConfigCenter.getConfigCenter().getPushParameter().port, new Object[0]);
        PushOption option = PushClient.getClient().getOption();
        if (option != null && !TextUtils.equals(token, option.getToken())) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("nowToken", token);
            hashMap3.put("pushOptionsToken", option.getToken());
            hashMap3.put("nowPhone", phone);
            hashMap3.put("pushOptionsPhone", option.getPhone());
            hashMap3.put("optionsEqual", Boolean.valueOf(TextUtils.equals(build.toString(), option.toString())));
            OmegaSDKAdapter.trackEvent("pushOptionsNotMatch", (Map<String, Object>) hashMap3);
        }
    }

    /* access modifiers changed from: package-private */
    public void addTopic(DPushListener dPushListener) {
        try {
            int parseInt = Integer.parseInt(dPushListener.topic());
            com.didi.sdk.log.Logger.easylog("TPush", "register topic------->" + dPushListener.topic());
            PushReceiver pushReceiver = new PushReceiver(String.valueOf(parseInt), dPushListener);
            this.listMap.put(dPushListener, pushReceiver);
            PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(parseInt), pushReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class PushReceiver implements PushReceiveListener<PushMsgResponse> {
        private DPushListener listener;
        private String type;

        PushReceiver(String str, DPushListener dPushListener) {
            this.type = str;
            this.listener = dPushListener;
        }

        public void onReceive(PushMsgResponse pushMsgResponse) {
            if (pushMsgResponse != null && pushMsgResponse.getPushMsg() != null) {
                PushMsg pushMsg = pushMsgResponse.getPushMsg();
                byte[] byteArray = pushMsg.payload.toByteArray();
                DPushBody dPushBody = new DPushBody();
                dPushBody.setData(byteArray);
                if (pushMsg.activity_id != null) {
                    dPushBody.setActivityId(pushMsg.activity_id.longValue());
                }
                dPushBody.setTopic(this.type);
                dPushBody.setPid(pushMsg.p_id);
                com.didi.sdk.log.Logger.easylog("TPush", "receiver tipoc------->" + this.listener.topic());
                com.didi.sdk.log.Logger.easylog("TPush", "onPushMessageReceived() called with:  msgType = [" + this.type + "], data = [" + new String(byteArray) + Const.jaRight);
                this.listener.pushBody(dPushBody);
                DPushManager.getInstance().dispatcherPush(DPushType.TENCENT_PUSH.getName(), dPushBody, this.listener.topic());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeTopic(DPushListener dPushListener) {
        if (!TextUtils.isEmpty(dPushListener.topic())) {
            int parseInt = Integer.parseInt(dPushListener.topic());
            PushClient.getClient().unregisterMessageListener(PushKey.Creator.createAppPushMsgKey(parseInt), this.listMap.remove(dPushListener));
        }
    }

    /* access modifiers changed from: package-private */
    public void registerPush(DPushListener dPushListener) {
        if (dPushListener != null) {
            addTopic(dPushListener);
        }
    }

    public void registerReconnectionListener(PushConnectionListener pushConnectionListener) {
        PushClient.getClient().registerConnectionListener(pushConnectionListener);
    }

    /* access modifiers changed from: package-private */
    public void unRegistConnectionListener(PushConnectionListener pushConnectionListener) {
        PushClient.getClient().unregisterConnectionListener(pushConnectionListener);
    }

    /* access modifiers changed from: package-private */
    public void unregisterPush(DPushListener dPushListener) {
        if (dPushListener != null) {
            removeTopic(dPushListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void sendRequest(byte[] bArr, int i, boolean z, int i2, byte[] bArr2) {
        PushClient.getClient().sendRequest(new PushRequest.Builder().data(bArr).msgType(i).needResponse(z).priority(i2).seqIdOut(bArr2).build());
    }

    /* access modifiers changed from: package-private */
    public void startPush() {
        setPushOption(this.context);
        PushClient.getClient().startPush();
    }

    /* access modifiers changed from: package-private */
    public void isConnected() {
        PushClient.getClient().isConnected();
    }

    /* access modifiers changed from: package-private */
    public void stopPush() {
        PushClient.getClient().stopPush();
        DPushUtil.setReconnectedThreshold(false);
    }
}
