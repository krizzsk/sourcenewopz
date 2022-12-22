package com.didi.sdk.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.app.router.PageRouter;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.sdk.app.DiPushApolloHelper;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.lawpop.LawPreposeDialogHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.push.common.ThirdPartyMsgHttpApi;
import com.didi.sdk.push.common.UploadThirdIdParams;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.GlobalDomains;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.LoginGsonFormSerializer;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

public class DPushHelper {
    private static final int AUTH_FAILED_NUM = 2;
    private static final int KEY_BY_LOGOUT = 1;
    private static final String TAG = "tpush-debug";
    private static final int TYPE_KICKOFF = 2;
    private static DPushHelper instance = new DPushHelper();
    /* access modifiers changed from: private */
    public static boolean isFirstReturnErrCode = true;
    /* access modifiers changed from: private */
    public static Logger logger = LoggerFactory.getLogger("DPushHelper");
    /* access modifiers changed from: private */
    public Context context;
    private boolean hasInit;
    /* access modifiers changed from: private */
    public boolean isNextResponseAfterPushTicketSuccess = false;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                OneLoginFacade.getAction().passiveLogout(DPushHelper.this.context, LoginReason.SIGN_IN_OR_SIGN_OFF_KICK_OFF_LONG_LINK_TICKET_INVALID, "", "");
                DPushHelper.this.onLogoutAndNotifyMainaAtivty(message);
            }
        }
    };
    /* access modifiers changed from: private */
    public int pushTicketRequestSuccessTime = 0;
    /* access modifiers changed from: private */
    public int pushTicketRequestSuccessUpperLimit = 20;
    private int pushTicketRequestTime = 0;
    private Handler retryHandler;
    /* access modifiers changed from: private */
    public int retryTime = 0;
    private FcmRunnable runnable;

    public interface AddPushNewService extends RpcService {
        @Serialization(LoginGsonFormSerializer.class)
        @Path("/passport/login/v5/pushTicket")
        @Post
        @Deserialization(GsonDeserializer.class)
        void pushTicket(@BodyParameter("q") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<Result> callback);
    }

    @Path("/passenger")
    public interface AddPushService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/addpush")
        @Deserialization(GsonDeserializer.class)
        void addPush(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<Result> callback);
    }

    public interface Callback {
        void onFailure();

        void onSuccess();
    }

    static /* synthetic */ int access$608(DPushHelper dPushHelper) {
        int i = dPushHelper.pushTicketRequestSuccessTime;
        dPushHelper.pushTicketRequestSuccessTime = i + 1;
        return i;
    }

    private DPushHelper() {
    }

    public static DPushHelper getHelper() {
        return instance;
    }

    /* access modifiers changed from: protected */
    public void onLogoutAndNotifyMainaAtivty(Message message) {
        if (this.context != null) {
            try {
                Intent intent = new Intent();
                if (message.what == 1) {
                    intent.putExtra(Constant.LOGOUT_KEY, true);
                } else if (message.what == 2) {
                    intent.putExtra(Constant.AUTH_FAILED_KEY, true);
                }
                intent.setFlags(268435456);
                PageRouter.getInstance().startMainActivity(this.context, intent);
            } catch (SecurityException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void registerLoginLisenter(Context context2) {
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                DPushManager.getInstance().startPush();
                DPushHelper.this.addFcm();
            }
        });
    }

    public void registerOneConfListener() {
        OneConfStore.getInstance().addOneConfChangeListener(new OneConfStore.OneConfConfigChangeListener() {
            public void onChanged(OneConfData oneConfData, double d, double d2) {
                if (!NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                    DPushHelper.this.addFcm();
                    OneConfStore.getInstance().removeOneConfChangeListener(this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addFcm() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.didi.sdk.push.DPushHelper$FcmRunnable r0 = r2.runnable     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            if (r0 != 0) goto L_0x0012
            com.didi.sdk.push.DPushHelper$FcmRunnable r0 = new com.didi.sdk.push.DPushHelper$FcmRunnable     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1 = 0
            r0.<init>()     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r2.runnable = r0     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            android.content.Context r1 = r2.context     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r0.setParams(r1)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
        L_0x0012:
            com.didi.sdk.push.DPushHelper$FcmRunnable r0 = r2.runnable     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            com.didi.sdk.apm.utils.ApmThreadPool.executeOnSingle(r0)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x001b:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.DPushHelper.addFcm():void");
    }

    private class FcmRunnable implements Runnable {
        private Context context;

        private FcmRunnable() {
        }

        public void setParams(Context context2) {
            this.context = context2;
        }

        public void run() {
            UploadThirdIdParams uploadThirdIdParams = new UploadThirdIdParams();
            boolean hasAgreeForApp = LawPreposeDialogHelper.hasAgreeForApp(this.context);
            uploadThirdIdParams.legalAgreement = hasAgreeForApp ? 1 : 0;
            if (hasAgreeForApp) {
                uploadThirdIdParams.legalAgreementTime = LawPreposeDialogHelper.getAgreeTimeForApp(this.context);
            }
            ThirdPartyMsgHttpApi.uploadThirdId(this.context, uploadThirdIdParams);
        }
    }

    /* access modifiers changed from: protected */
    public void loginOutNotify(Context context2) {
        DPushManager.getInstance().stopPush();
    }

    public void initPush(Context context2) {
        Logger logger2 = logger;
        logger2.info("initPush" + this.hasInit, new Object[0]);
        if (!this.hasInit) {
            this.hasInit = true;
            this.context = context2;
            DPushManager.getInstance().initPushConfig(context2);
            registerPushConnection();
            registerLoginLisenter(context2);
            registerLoginOutListener(context2);
            if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                DPushManager.getInstance().startPush();
            }
        }
    }

    public void uploadCidForFcm() {
        if (this.hasInit) {
            addFcm();
        }
    }

    private void registerPushConnection() {
        DPushManager.getInstance().registerReconnectionListener(new PushConnectionListener() {
            public void onConnection(PushConnResult pushConnResult) {
                int retCode = pushConnResult.getRetCode();
                int subCode = pushConnResult.getSubCode();
                NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
                Logger access$300 = DPushHelper.logger;
                access$300.info("onPushConnection called code: " + retCode + " subCode：" + subCode, new Object[0]);
                if (!nationComponentData.getLoginInfo().isLoginNow()) {
                    DPushHelper.logger.info("onPushConnection called no login", new Object[0]);
                    return;
                }
                if (retCode != 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("phone", PushClient.getClient().getOption().getPhone());
                    hashMap.put("token", nationComponentData.getLoginInfo().getToken());
                    hashMap.put("pushOptionsToken", PushClient.getClient().getOption().getToken());
                    hashMap.put("errCode", Integer.valueOf(retCode));
                    hashMap.put("isFirstReturnErrCode", Integer.valueOf(DPushHelper.isFirstReturnErrCode ? 1 : 0));
                    hashMap.put("ErrAfterPushTicketSuccess", Integer.valueOf(DPushHelper.this.isNextResponseAfterPushTicketSuccess ? 1 : 0));
                    DLog.m23371d("pushClientCode", PushClient.getClient().getOption().getPhone());
                    OmegaSDKAdapter.trackEvent("pushConnectionErrCode", (Map<String, Object>) hashMap);
                }
                if (DPushHelper.isFirstReturnErrCode) {
                    boolean unused = DPushHelper.isFirstReturnErrCode = false;
                }
                if (DPushHelper.this.isNextResponseAfterPushTicketSuccess) {
                    boolean unused2 = DPushHelper.this.isNextResponseAfterPushTicketSuccess = false;
                }
                if (retCode == -21 || retCode == 130) {
                    if (Apollo.getToggle("isUsePushKickAndAddPush", true).allow()) {
                        DPushHelper.this.addPushByApollo(new Callback() {
                            public void onSuccess() {
                                if (DPushHelper.this.pushTicketRequestSuccessTime < DPushHelper.this.pushTicketRequestSuccessUpperLimit && DPushHelper.this.pushTicketRequestSuccessTime >= DPushHelper.this.pushTicketRequestSuccessUpperLimit - 2 && Apollo.getToggle("allow_dipush_phone_prefix_changed", true).allow()) {
                                    DPushUtil.setReconnectedThreshold(true);
                                }
                                DPushHelper.this.onValidResult(2, true);
                            }

                            public void onFailure() {
                                DPushHelper.this.onValidResult(2, false);
                                DPushHelper.this.mHandler.sendEmptyMessage(1);
                                DPushHelper.this.addLoginOutOmega();
                            }
                        });
                    }
                } else if (retCode == -17 || (retCode == 110 && subCode == 606)) {
                    DPushHelper.this.recallAddPush(2, retCode);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void recallAddPush(int i, final int i2) {
        addPushByApollo(new Callback() {
            public void onSuccess() {
                if (DPushHelper.this.pushTicketRequestSuccessTime < DPushHelper.this.pushTicketRequestSuccessUpperLimit && DPushHelper.this.pushTicketRequestSuccessTime >= DPushHelper.this.pushTicketRequestSuccessUpperLimit - 2 && Apollo.getToggle("allow_dipush_phone_prefix_changed", true).allow()) {
                    DPushUtil.setReconnectedThreshold(true);
                }
                DPushManager.getInstance().startPush();
                HashMap hashMap = new HashMap();
                hashMap.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
                hashMap.put("phone", NationTypeUtil.getNationComponentData().getLoginInfo().getPhone());
                hashMap.put("code", Integer.valueOf(i2));
                OmegaSDKAdapter.trackEvent("push_retcode_exception", (Map<String, Object>) hashMap);
            }

            public void onFailure() {
                DPushHelper.this.mHandler.sendEmptyMessage(1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void registerLoginOutListener(final Context context2) {
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                DPushHelper.logger.infoEvent(DPushHelper.TAG, DPushHelper.TAG, "loginOut");
                DPushHelper.this.loginOutNotify(context2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void addPushByApollo(Callback callback) {
        if (Apollo.getToggle("global_pushticket_instead_addpush", true).allow()) {
            addNewPushToken(callback);
        } else {
            addPushToken(callback);
        }
    }

    private void addPushToken(final Callback callback) {
        AddPushService addPushService = (AddPushService) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(AddPushService.class, "https://common.didiglobal.com");
        HashMap hashMap = new HashMap();
        hashMap.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        String phone = NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
        if (AppUtils.isBrazilApp(this.context) && DiPushApolloHelper.isNewPhoneFormatOpen(this.context)) {
            phone = PushClient.getClient().getOption().getPhone();
        }
        hashMap.put("phone", phone);
        CommonParamsUtil.addCommonParam(hashMap, this.context);
        addPushService.addPush(hashMap, new RpcService.Callback<Result>() {
            public void onFailure(IOException iOException) {
                iOException.printStackTrace();
            }

            public void onSuccess(Result result) {
                Callback callback;
                if (result.errno == 0) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onSuccess();
                    }
                } else if (result.errno == 101 && (callback = callback) != null) {
                    callback.onFailure();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String buildErrorMessage(int i) {
        return "errno is :" + i;
    }

    private void addNewPushToken(final Callback callback) {
        this.pushTicketRequestTime++;
        if (this.retryTime > 10) {
            setOmegaByPushTicketTooManyTimes();
        } else if (!getPushTicketUpperLimitApollo() || this.pushTicketRequestSuccessTime < this.pushTicketRequestSuccessUpperLimit) {
            AddPushNewService addPushNewService = (AddPushNewService) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(AddPushNewService.class, GlobalDomains.HOST_E_PASSPORT);
            HashMap hashMap = new HashMap();
            hashMap.put("ticket", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
            hashMap.put("appid", Integer.valueOf(AppUtils.isBrazilApp(this.context) ? 60004 : 60000));
            CommonParamsUtil.addCommonParam(hashMap, this.context);
            hashMap.put("datatype", "1");
            try {
                hashMap.put("city_id", Integer.valueOf(Integer.parseInt(NationTypeUtil.getNationComponentData().getCityId())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            addPushNewService.pushTicket(hashMap, new RpcService.Callback<Result>() {
                public void onFailure(IOException iOException) {
                    DPushHelper.this.setOmegaTrackEvent(false, iOException.getMessage());
                    DPushHelper.this.retryPushTicket(false);
                }

                public void onSuccess(Result result) {
                    if (result.errno == 0) {
                        DPushHelper.access$608(DPushHelper.this);
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onSuccess();
                        }
                        boolean unused = DPushHelper.this.isNextResponseAfterPushTicketSuccess = true;
                        int unused2 = DPushHelper.this.retryTime = 0;
                    } else if (result.errno == 52000) {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onFailure();
                        }
                        int unused3 = DPushHelper.this.retryTime = 0;
                    } else if (result.errno == 50000) {
                        DPushHelper.this.retryPushTicket(true);
                    } else {
                        DPushHelper.this.retryPushTicket(true);
                    }
                    if (result.errno != 0) {
                        DPushHelper dPushHelper = DPushHelper.this;
                        dPushHelper.setOmegaTrackEvent(false, dPushHelper.buildErrorMessage(result.errno));
                        return;
                    }
                    DPushHelper.this.setOmegaTrackEvent(true, "");
                }
            });
        } else {
            setOmegaByPushTicketSuccessTooManyTimes();
        }
    }

    /* access modifiers changed from: private */
    public void setOmegaTrackEvent(boolean z, String str) {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", PushClient.getClient().getOption().getPhone());
        hashMap.put("token", nationComponentData.getLoginInfo().getToken());
        hashMap.put("pushOptionsToken", PushClient.getClient().getOption().getToken());
        hashMap.put("requestSuccess", Integer.valueOf(z ? 1 : 0));
        hashMap.put("requestFailedReason", str);
        hashMap.put("requestTime", Integer.valueOf(this.pushTicketRequestTime));
        OmegaSDKAdapter.trackEvent("pushTicketRequest", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    public void retryPushTicket(boolean z) {
        if (z) {
            this.retryTime++;
        }
        if (this.retryTime > 9 && Apollo.getToggle("allow_dipush_phone_prefix_changed", true).allow()) {
            DPushUtil.setReconnectedThreshold(true);
        }
        if (this.retryHandler == null) {
            this.retryHandler = new Handler();
        }
        this.retryHandler.postDelayed(new Runnable() {
            public void run() {
                DPushManager.getInstance().startPush();
            }
        }, 10000);
    }

    private void setOmegaByPushTicketTooManyTimes() {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", PushClient.getClient().getOption().getPhone());
        hashMap.put("token", nationComponentData.getLoginInfo().getToken());
        hashMap.put("pushOptionsToken", PushClient.getClient().getOption().getToken());
        OmegaSDKAdapter.trackEvent("pushTicketRequestTooManyTimes", (Map<String, Object>) hashMap);
    }

    private void setOmegaByPushTicketSuccessTooManyTimes() {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", PushClient.getClient().getOption().getPhone());
        hashMap.put("token", nationComponentData.getLoginInfo().getToken());
        hashMap.put("pushOptionsToken", PushClient.getClient().getOption().getToken());
        OmegaSDKAdapter.trackEvent("pushTicketRequestSuccessTooManyTimes", (Map<String, Object>) hashMap);
    }

    class Result {
        public String errmsg;
        public int errno;

        Result() {
        }

        public String toString() {
            return "Result{errno=" + this.errno + "errmsg='" + this.errmsg + "'" + '}';
        }
    }

    /* access modifiers changed from: private */
    public void addLoginOutOmega() {
        try {
            OmegaSDKAdapter.trackEvent("one_p_x_logout_bypush");
            OneLoginFacade.getFunction().validate(this.context, new LoginListeners.ValidateTicketListener() {
                public void onFail(String str) {
                }

                public void onSucc() {
                    OmegaSDKAdapter.trackEvent("one_p_x_logouterr_bypush");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onValidResult(int i, boolean z) {
        if (z) {
            DPushManager.getInstance().startPush();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("reason", Integer.valueOf(i));
        hashMap.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        PushOption option = PushClient.getClient().getOption();
        hashMap.put("ip", option.getIp());
        hashMap.put(AgentOptions.PORT, Integer.valueOf(option.getPort()));
        hashMap.put("is_valid", Integer.valueOf(z ^ true ? 1 : 0));
        OmegaSDKAdapter.trackEvent("push_kick_and_addpush", (Map<String, Object>) hashMap);
    }

    private boolean getPushTicketUpperLimitApollo() {
        IToggle toggle = Apollo.getToggle("global_push_ticket_request_success_upper_limit", true);
        if (toggle.allow()) {
            this.pushTicketRequestSuccessUpperLimit = ((Integer) toggle.getExperiment().getParam("upper_limit", 20)).intValue();
        }
        return toggle.allow();
    }
}
