package com.didi.component.common.push;

import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.push.model.CommonNotificationModel;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.common.push.model.VibrationModel;
import com.didi.component.common.push.model.WalletChangeDialogModel;
import com.didi.component.common.util.GLog;
import com.didi.component.common.voip.VoipComponentImpl;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.payment.commonsdk.push.WPushMsgListener;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.messagecenter.p152pb.CommonMsgReq;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import com.didi.sdk.push.fcm.FcmPushDispatcher;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.core.order.OrderService;
import com.didi.travel.psnger.model.response.NextCommonPushMsg;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.utils.OrderStatusOmegaEvent;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonPushManager {

    /* renamed from: a */
    private static final String f11687a = "CommonPushManager";

    /* renamed from: b */
    private static volatile CommonPushManager f11688b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<String, WPushMsgListener> f11689c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Vibrator f11690d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f11691e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f11692f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AudioAttributes f11693g;

    /* renamed from: h */
    private FcmPushDispatcher.FcmPushListener f11694h = new FcmPushDispatcher.FcmPushListener() {
        public void onMessageReceived(DPushBody dPushBody) {
            JSONObject optJSONObject;
            String str = new String(dPushBody.getData());
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ty")) {
                    int i = jSONObject.getInt("ty");
                    if (i == 10) {
                        CommonPushManager.this.m7923e(str);
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_SHOW_COMPENSATION_4_WAIT, str);
                    } else if (i == 12) {
                        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE, str);
                    } else if (i == 15) {
                        SystemUtils.log(3, CommonPushManager.f11687a, "onMessageReceived: " + jSONObject.toString(), (Throwable) null, "com.didi.component.common.push.CommonPushManager$1", 139);
                        String optString = jSONObject.optString("link");
                        if (!TextUtils.isEmpty(optString)) {
                            Uri parse = Uri.parse(optString);
                            Intent intent = new Intent(DIDIApplication.getAppContext(), SchemeDispatcherImpl.class);
                            intent.addFlags(268435456);
                            intent.setData(parse);
                            DIDIApplication.getAppContext().startActivity(intent);
                        }
                    } else if (i == 18) {
                        if (jSONObject.has("GulfstreamDriverSysPush") && (optJSONObject = jSONObject.optJSONObject("GulfstreamDriverSysPush")) != null && optJSONObject.has(VoipBusinessActivity.KEY_VOIP_DATA)) {
                            VoipComponentImpl.onPushClick(DIDIApplication.getAppContext(), optJSONObject.optString(VoipBusinessActivity.KEY_VOIP_DATA));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    /* renamed from: i */
    private DPushListener f11695i = new DPushListener() {
        final int msgType = PushMessageType.kPushMessageTypeCommonMsgReq.getValue();

        public DPushType pushType() {
            return DPushType.TENCENT_PUSH;
        }

        public void pushBody(DPushBody dPushBody) {
            if (!TextUtils.isEmpty(new String(dPushBody.getData()))) {
                try {
                    CommonMsgReq commonMsgReq = (CommonMsgReq) new Wire((Class<?>[]) new Class[0]).parseFrom(dPushBody.getData(), CommonMsgReq.class);
                    if (commonMsgReq != null) {
                        int intValue = ((Integer) Wire.get(commonMsgReq.recommond_type, CommonMsgReq.DEFAULT_RECOMMOND_TYPE)).intValue();
                        String str = (String) Wire.get(commonMsgReq.recommond_msg, "");
                        SystemUtils.log(3, CommonPushManager.f11687a, "receive a new push: recommendType=" + intValue + ", recommendMsg=" + str, (Throwable) null, "com.didi.component.common.push.CommonPushManager$2", 193);
                        GLog.m7971i(CommonPushManager.f11687a, "receive a new push: recommendType=" + intValue + ", recommendMsg=" + str);
                        switch (intValue) {
                            case 53:
                                CommonPushManager.this.m7910a(new NextCommonPushMsg(53, str));
                                return;
                            case 105:
                                CommonPushManager.this.m7920d(str);
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_SHOW_COMPENSATION_4_WAIT, str);
                                return;
                            case 106:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_ASK_SPLIT_FARE, str);
                                return;
                            case 107:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_SPLIT_FARE_USER_LIST_UPDATE, str);
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_SPLIT_STREET_SHOW);
                                return;
                            case 166:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_DRIVER_TRAIL_REJECT_ORDER, str);
                                return;
                            case 173:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, str);
                                return;
                            case 174:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_COMMON_ALERT, str);
                                return;
                            case 176:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_INDRIVER);
                                return;
                            case 179:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_FLEX);
                                return;
                            case 200:
                                ExpectationManagementModel expectationManagementPair = CommonPushManager.getExpectationManagementPair(str);
                                if (expectationManagementPair != null) {
                                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, expectationManagementPair);
                                    return;
                                }
                                return;
                            case 211:
                                SystemUtils.log(3, CommonPushManager.f11687a, "receive notification msg，pushBody:  = " + str, (Throwable) null, "com.didi.component.common.push.CommonPushManager$2", 228);
                                CommonPushManager.this.m7917c(str);
                                return;
                            case 220:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_ON_SERVICE_EVALUATE, str);
                                return;
                            case 222:
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_COMPONENT_CONFIG_LEGO_ALERT, str);
                                return;
                            case 240:
                                CommonPushManager.this.handle99TopupNoticeMsg(str);
                                return;
                            case 260:
                                CommonPushManager.this.handleWalletChangeResultWithUnregisted(str);
                                return;
                            case 270:
                                if (!CollectionUtil.isEmpty((Map<?, ?>) CommonPushManager.this.f11689c)) {
                                    for (Map.Entry entry : CommonPushManager.this.f11689c.entrySet()) {
                                        try {
                                            GLog.m7964d("expand push msg to " + entry.getValue());
                                            if (!((WPushMsgListener) entry.getValue()).onHandlePushMsg(intValue, str)) {
                                                CommonPushManager.this.m7914b(str);
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return;
                                }
                                return;
                            case 280:
                                GLog.m7964d("lxs push" + str);
                                CommonPushManager.this.m7911a(str);
                                return;
                            case 320:
                                GLog.m7964d("gxh push" + str);
                                CommonPushManager.this.m7926f(str);
                                return;
                            case 321:
                                GLog.m7964d("gxh push" + str);
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_CHANGE_PAYWAY_RESULT, str);
                                return;
                            case 6001:
                                GLog.m7964d("gxh push" + str);
                                VoipComponentImpl.onPushMsg(DIDIApplication.getAppContext(), str);
                                return;
                            default:
                                return;
                        }
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public String topic() {
            return this.msgType + "";
        }
    };

    /* renamed from: j */
    private OrderService f11696j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<WeakReference<IDiDiCoreCallback>> f11697k = new ArrayList();

    /* renamed from: l */
    private final IDiDiCoreCallback f11698l = new DefaultDiDiCoreCallback() {
        public void onOrderPollTimeChange(int i) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onOrderPollTimeChange(i);
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onOrderPollTimeChange(i);
                    }
                }
            }
        }

        public void onOrderStatusChange(IOrderStatus iOrderStatus) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onOrderStatusChange(iOrderStatus);
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onOrderStatusChange(iOrderStatus);
                    }
                }
            }
        }

        public void onOrderStatusTimeOut() {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onOrderStatusTimeOut();
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onOrderStatusTimeOut();
                    }
                }
            }
        }

        public void onCarpoolInfoChange() {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onCarpoolInfoChange();
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onCarpoolInfoChange();
                    }
                }
            }
        }

        public void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onRealtimePriceRefresh(orderRealtimePriceCount);
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onRealtimePriceRefresh(orderRealtimePriceCount);
                    }
                }
            }
        }

        public void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onTotalFeeDetailReceive(nextTotalFeeDetail);
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onTotalFeeDetailReceive(nextTotalFeeDetail);
                    }
                }
            }
        }

        public void onPayResultReceive(NextPayResult nextPayResult) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onPayResultReceive(nextPayResult);
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onPayResultReceive(nextPayResult);
                    }
                }
            }
        }

        public void onCommonMessageReceive(int i, String str) {
            IDiDiCoreCallback iDiDiCoreCallback;
            super.onCommonMessageReceive(i, str);
            GLog.m7965d(CommonPushManager.f11687a, "[recommendType:" + i + "] & [recommendMessage:" + str + Const.jaRight);
            CommonPushManager.this.m7910a(new NextCommonPushMsg(i, str));
            if (CommonPushManager.this.f11697k.size() > 0) {
                for (WeakReference weakReference : CommonPushManager.this.f11697k) {
                    if (!(weakReference == null || (iDiDiCoreCallback = (IDiDiCoreCallback) weakReference.get()) == null)) {
                        iDiDiCoreCallback.onCommonMessageReceive(i, str);
                    }
                }
            }
        }
    };

    /* renamed from: e */
    static /* synthetic */ int m7921e(CommonPushManager commonPushManager) {
        int i = commonPushManager.f11691e;
        commonPushManager.f11691e = i + 1;
        return i;
    }

    private CommonPushManager() {
        Iterator<S> it = ServiceLoader.load(WPushMsgListener.class).iterator();
        while (it.hasNext()) {
            WPushMsgListener wPushMsgListener = (WPushMsgListener) it.next();
            this.f11689c.put(wPushMsgListener.getClass().getCanonicalName(), wPushMsgListener);
        }
    }

    public static CommonPushManager getInstance() {
        if (f11688b == null) {
            synchronized (CommonPushManager.class) {
                if (f11688b == null) {
                    f11688b = new CommonPushManager();
                }
            }
        }
        return f11688b;
    }

    public void register() {
        DPushManager.getInstance().registerPush(this.f11695i);
        FcmPushDispatcher.getInstance().addListener(this.f11694h);
    }

    public void unregister() {
        DPushManager.getInstance().unregisterPush(this.f11695i);
        FcmPushDispatcher.getInstance().removeListener(this.f11694h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7911a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("common_notice_info");
                if (optJSONObject != null) {
                    NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1001, optJSONObject.optString("title"), optJSONObject.optString("subtitle"), false, false, false, (String) null);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7914b(String str) {
        CommonNotificationModel commonNotificationModel;
        if (TextUtils.isEmpty(str) || (commonNotificationModel = (CommonNotificationModel) new Gson().fromJson(str, CommonNotificationModel.class)) == null) {
            return;
        }
        if (!TextUtils.isEmpty(commonNotificationModel.title) || !TextUtils.isEmpty(commonNotificationModel.content)) {
            NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1001, commonNotificationModel.title, commonNotificationModel.content, false, true, true, commonNotificationModel.link);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7917c(String str) {
        CommonNotificationModel commonNotificationModel;
        if (!TextUtils.isEmpty(str) && (commonNotificationModel = (CommonNotificationModel) new Gson().fromJson(str, CommonNotificationModel.class)) != null) {
            NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1001, commonNotificationModel.title, commonNotificationModel.content, false, true, true, commonNotificationModel.link);
        }
    }

    public void handle99TopupNoticeMsg(String str) {
        GLog.m7965d(f11687a, "new push: " + str);
        if (!TextUtils.isEmpty(str)) {
            CommonNotificationModel commonNotificationModel = (CommonNotificationModel) new Gson().fromJson(str, CommonNotificationModel.class);
            if (commonNotificationModel == null) {
                GLog.m7965d(f11687a, "new push: parse 99topup pushmsg model fail return null");
            } else {
                NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1113, commonNotificationModel.title, commonNotificationModel.content, false, true, true, commonNotificationModel.link, true);
            }
        }
    }

    public void handleWalletChangeResultWithUnregisted(String str) {
        WalletChangeDialogModel walletChangeDialogModel;
        if (!TextUtils.isEmpty(str) && (walletChangeDialogModel = (WalletChangeDialogModel) new Gson().fromJson(str, WalletChangeDialogModel.class)) != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Push.EVENT_WALLET_CHANGE_ALERT, walletChangeDialogModel);
        }
    }

    public static ExpectationManagementModel getExpectationManagementPair(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ExpectationManagementModel expectationManagementModel = new ExpectationManagementModel();
            expectationManagementModel.duse_status = jSONObject.optInt("duse_status", -1);
            expectationManagementModel.order_feature = jSONObject.optLong("order_feature", 0);
            expectationManagementModel.wait_time = jSONObject.optInt(ParamConst.PARAM_WAIT_TIME, -1);
            expectationManagementModel.driver_num = jSONObject.optInt("driver_num", 0);
            expectationManagementModel.use_pmsg = jSONObject.optInt("use_pmsg", 0);
            expectationManagementModel.pmsg = jSONObject.optString("pmsg", "");
            expectationManagementModel.oid_base64 = jSONObject.optString("oid_base64", "");
            expectationManagementModel.oid = jSONObject.optString("oid", "");
            expectationManagementModel.did = jSONObject.optString("did", "");
            expectationManagementModel.lat = jSONObject.optDouble("lat", -2.147483647E9d);
            expectationManagementModel.lng = jSONObject.optDouble("lng", -2.147483647E9d);
            expectationManagementModel.showtime = jSONObject.optInt("showtime", 15);
            expectationManagementModel.scene = jSONObject.optInt("scene");
            expectationManagementModel.scene_countdown_time = jSONObject.optInt("scene_countdown_time");
            return expectationManagementModel;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7920d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            hashMap.put("act_id", jSONObject.get("act_id"));
            hashMap.put(ParamConst.TRACE_ID, jSONObject.get(ParamConst.TRACE_ID));
            if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().orderState == null)) {
                hashMap.put("order_statue", Integer.valueOf(CarOrderHelper.getOrder().orderState.subStatus));
            }
            OmegaSDKAdapter.trackEvent("gp_WaitMustPay_Push_LongConnect_rsp", (Map<String, Object>) hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7923e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            hashMap.put("act_id", jSONObject.get("act_id"));
            hashMap.put("in_forground", Integer.valueOf(ActivityLifecycleManager.getInstance().isAppActive() ? 1 : 0));
            if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().orderState == null)) {
                hashMap.put("order_statue", Integer.valueOf(CarOrderHelper.getOrder().orderState.subStatus));
            }
            if (jSONObject.has(ParamConst.TRACE_ID)) {
                hashMap.put(ParamConst.TRACE_ID, jSONObject.get(ParamConst.TRACE_ID));
            }
            OmegaSDKAdapter.trackEvent("gp_WaitMustPay_Push_ApnsFCM_rsp", (Map<String, Object>) hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void startPushOrderService() {
        if (this.f11696j == null) {
            this.f11696j = (OrderService) TravelSDK.getService("order");
        }
        OrderService orderService = this.f11696j;
        if (orderService != null) {
            orderService.addOrderPushCallback(this.f11698l);
            this.f11696j.registerPush();
        }
    }

    public void stopPushOrderService() {
        OrderService orderService = this.f11696j;
        if (orderService != null) {
            orderService.unregisterPush();
            this.f11696j.removeOrderPushCallback(this.f11698l);
            this.f11696j = null;
        }
    }

    public void registerDidiPushCoreBack(IDiDiCoreCallback iDiDiCoreCallback) {
        IDiDiCoreCallback iDiDiCoreCallback2;
        if (iDiDiCoreCallback != null) {
            if (this.f11696j == null) {
                startPushOrderService();
            }
            boolean z = false;
            Iterator<WeakReference<IDiDiCoreCallback>> it = this.f11697k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference next = it.next();
                if (next != null && (iDiDiCoreCallback2 = (IDiDiCoreCallback) next.get()) != null && iDiDiCoreCallback2.equals(iDiDiCoreCallback)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.f11697k.add(new WeakReference(iDiDiCoreCallback));
                OrderStatusOmegaEvent.orderStatusOmegaTrace("tech_pax_order_status_start", true);
            }
        }
    }

    public void unregisterDidiPushCoreBack(IDiDiCoreCallback iDiDiCoreCallback) {
        IDiDiCoreCallback iDiDiCoreCallback2;
        if (iDiDiCoreCallback != null) {
            WeakReference weakReference = null;
            if (this.f11697k.size() > 0) {
                Iterator<WeakReference<IDiDiCoreCallback>> it = this.f11697k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference next = it.next();
                    if (next != null && (iDiDiCoreCallback2 = (IDiDiCoreCallback) next.get()) != null && iDiDiCoreCallback2.equals(iDiDiCoreCallback)) {
                        weakReference = next;
                        break;
                    }
                }
            }
            if (weakReference != null) {
                this.f11697k.remove(weakReference);
                OrderStatusOmegaEvent.orderStatusOmegaTrace("tech_pax_order_status_finish", true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7910a(NextCommonPushMsg nextCommonPushMsg) {
        if (CarOrderHelper.getOrder() != null && nextCommonPushMsg != null) {
            int recommendType = nextCommonPushMsg.getRecommendType();
            GLog.m7971i(f11687a, "消息类型：" + recommendType);
            if (recommendType == 53) {
                GLog.m7971i("car_upgrade", "发送前:" + nextCommonPushMsg.getDialogMessage().toString());
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_CAR_UPGRADE, nextCommonPushMsg.getDialogMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m7926f(String str) {
        VibrationModel vibrationModel;
        if (!TextUtils.isEmpty(str) && (vibrationModel = (VibrationModel) new Gson().fromJson(str, VibrationModel.class)) != null) {
            boolean z = false;
            try {
                this.f11691e = 0;
                this.f11692f = Integer.parseInt(vibrationModel.count);
                int parseInt = Integer.parseInt(vibrationModel.duration);
                this.f11690d = (Vibrator) DIDIApplication.getAppContext().getSystemService("vibrator");
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f11693g = new AudioAttributes.Builder().setContentType(4).setUsage(4).build();
                }
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        CommonPushManager.this.f11690d.vibrate(1000, CommonPushManager.this.f11693g);
                        CommonPushManager.m7921e(CommonPushManager.this);
                        if (CommonPushManager.this.f11691e >= CommonPushManager.this.f11692f) {
                            timer.cancel();
                        }
                    }
                }, 0, (long) (parseInt * 1000));
                HashMap hashMap = new HashMap();
                if (!Utils.isAppFront()) {
                    z = true;
                }
                hashMap.put("front-end", Boolean.valueOf(z));
                hashMap.put("push_permission", NotificationUtils.isNotificationEnabled(DIDIApplication.getAppContext()) ? "1" : "0");
                GlobalOmegaUtils.trackEvent("map_vibration_bt", (Map<String, Object>) hashMap);
                HashMap hashMap2 = new HashMap();
                if (ContextCompat.checkSelfPermission(DIDIBaseApplication.getAppContext(), "android.permission.VIBRATE") == 0) {
                    hashMap2.put("vibration_permission", "1");
                } else {
                    hashMap2.put("vibration_permission", "0");
                }
                GlobalOmegaUtils.trackEvent("map_vibration_permission_bt", (Map<String, Object>) hashMap2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
