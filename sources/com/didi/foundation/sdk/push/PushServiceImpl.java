package com.didi.foundation.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.delegate.MsgGateService;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.p154ms.push.ITokenOperation;
import com.didi.sdk.push.common.FoodTabParams;
import com.didi.sdk.push.common.ILoginInfoDelegate;
import com.didi.sdk.push.common.IThirdPartyMsgParamsGetter;
import com.didi.sdk.push.common.IThirdPartyMsgReceiver;
import com.didi.sdk.push.common.LoginParams;
import com.didi.sdk.push.common.PushAckParams;
import com.didi.sdk.push.common.ThirdPartyMsgHttpApi;
import com.didi.sdk.push.common.ThirdPartyMsgManager;
import com.didi.sdk.push.common.UploadThirdIdParams;
import com.didi.sdk.tpush.ILogCallbackListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@ServiceProvider({PushServiceProvider.class})
public class PushServiceImpl implements PushServiceProvider {

    /* renamed from: a */
    private ThirdPartMessageReceiverImpl f21293a;

    public int getPushType() {
        return 3;
    }

    public void init(final Context context, final PushParam pushParam, final LogListener logListener) {
        if (context != null && pushParam != null) {
            ThirdPartyMsgManager.getInstance().init(new IThirdPartyMsgParamsGetter() {
                public UploadThirdIdParams getUploadThirdIdParams() {
                    UploadThirdIdParams uploadThirdIdParams = new UploadThirdIdParams();
                    uploadThirdIdParams.app_type = pushParam.getAppType();
                    uploadThirdIdParams.appversion = pushParam.getAppVersion();
                    uploadThirdIdParams.imei = pushParam.getImei();
                    if (pushParam.getCityId() != -1) {
                        uploadThirdIdParams.area_id = pushParam.getCityId();
                    }
                    uploadThirdIdParams.fcm_id = PushServiceImpl.this.m15643a(context, (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.GMS));
                    uploadThirdIdParams.huawei_token = PushServiceImpl.this.m15643a(context, (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.HMS));
                    uploadThirdIdParams.host = pushParam.getHost();
                    DIDILocation lastKnownLocation = LocationService.getInstance().getLastKnownLocation();
                    if (lastKnownLocation != null) {
                        uploadThirdIdParams.lat = lastKnownLocation.getLatitude();
                        uploadThirdIdParams.lng = lastKnownLocation.getLongitude();
                    }
                    PushServiceImpl.this.m15646a(uploadThirdIdParams, pushParam);
                    return uploadThirdIdParams;
                }

                public PushAckParams getPushAckParams() {
                    PushAckParams pushAckParams = new PushAckParams();
                    pushAckParams.host = MsgGateService.URL;
                    return pushAckParams;
                }
            }, new ILoginInfoDelegate() {
                public boolean isTestEnviroment() {
                    return pushParam.isTestEnvironment();
                }

                public LoginParams getLoginParams() {
                    LoginParams loginParams = new LoginParams();
                    loginParams.phone = pushParam.getPhone();
                    loginParams.token = pushParam.getUserToken();
                    loginParams.uid = pushParam.getUid();
                    return loginParams;
                }
            }, new ILogCallbackListener() {
                public void onRequested(int i, int i2, byte[] bArr) {
                }

                public void onLog(int i, String str) {
                    LogListener logListener = logListener;
                    if (logListener != null) {
                        logListener.onLog(str);
                    }
                }
            });
        }
    }

    public void uploadPushParam(Context context, PushParam pushParam) {
        if (pushParam != null) {
            UploadThirdIdParams uploadThirdIdParams = new UploadThirdIdParams();
            uploadThirdIdParams.app_type = pushParam.getAppType();
            uploadThirdIdParams.fcm_id = m15643a(context, (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.GMS));
            uploadThirdIdParams.huawei_token = m15643a(context, (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.HMS));
            uploadThirdIdParams.appversion = pushParam.getAppVersion();
            uploadThirdIdParams.imei = pushParam.getImei();
            m15646a(uploadThirdIdParams, pushParam);
            ThirdPartyMsgHttpApi.uploadThirdId(context, uploadThirdIdParams);
        }
    }

    public void registerMessageReceiver(PushMessageReceiver pushMessageReceiver) {
        if (pushMessageReceiver != null) {
            if (this.f21293a == null) {
                this.f21293a = new ThirdPartMessageReceiverImpl();
                ThirdPartyMsgManager.getInstance().addMsgReceiver(this.f21293a);
            }
            this.f21293a.addPushMessageReceiver(pushMessageReceiver);
        }
    }

    public void unRegisterMessageReceiver(PushMessageReceiver pushMessageReceiver) {
        ThirdPartMessageReceiverImpl thirdPartMessageReceiverImpl;
        if (pushMessageReceiver != null && (thirdPartMessageReceiverImpl = this.f21293a) != null) {
            thirdPartMessageReceiverImpl.removePushMessageReceiver(pushMessageReceiver);
        }
    }

    public void release() {
        ThirdPartMessageReceiverImpl thirdPartMessageReceiverImpl = this.f21293a;
        if (thirdPartMessageReceiverImpl != null) {
            thirdPartMessageReceiverImpl.clearPushMessageReceiver();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15646a(UploadThirdIdParams uploadThirdIdParams, PushParam pushParam) {
        if (!TextUtils.isEmpty(pushParam.getDeviceToken())) {
            uploadThirdIdParams.deviceToken = pushParam.getDeviceToken();
        }
        FoodTabParams foodTabParams = new FoodTabParams();
        foodTabParams.foodLegalAgreementTime = pushParam.getFoodLegalAgreementTime();
        foodTabParams.foodDeliveryCity = pushParam.getFoodDeliveryCity();
        foodTabParams.isFoodLegalAgreement = pushParam.getIsFoodLegalAgreement();
        uploadThirdIdParams.foodTabParams = foodTabParams;
        uploadThirdIdParams.firstOpenTime = pushParam.getFirstOpenTime();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m15643a(Context context, ITokenOperation iTokenOperation) {
        if (iTokenOperation == null) {
            return "";
        }
        String tokenCached = iTokenOperation.getTokenCached(context);
        return TextUtils.isEmpty(tokenCached) ? iTokenOperation.getTokenSync(context) : tokenCached;
    }

    public class ThirdPartMessageReceiverImpl implements IThirdPartyMsgReceiver {
        private CopyOnWriteArrayList<PushMessageReceiver> mPushMessageReceivers;

        private ThirdPartMessageReceiverImpl() {
            this.mPushMessageReceivers = new CopyOnWriteArrayList<>();
        }

        public void onReceiveMsg(String str) {
            Iterator<PushMessageReceiver> it = this.mPushMessageReceivers.iterator();
            while (it.hasNext()) {
                PushMessageReceiver next = it.next();
                if (next != null) {
                    next.onMessageReceived(str);
                }
            }
        }

        /* access modifiers changed from: private */
        public void addPushMessageReceiver(PushMessageReceiver pushMessageReceiver) {
            this.mPushMessageReceivers.add(pushMessageReceiver);
        }

        /* access modifiers changed from: private */
        public void removePushMessageReceiver(PushMessageReceiver pushMessageReceiver) {
            this.mPushMessageReceivers.remove(pushMessageReceiver);
        }

        /* access modifiers changed from: private */
        public void clearPushMessageReceiver() {
            this.mPushMessageReceivers.clear();
        }
    }
}
