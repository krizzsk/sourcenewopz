package com.didi.sdk.recover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.common.TaskScheduler;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.event.ThreadMode;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider(alias = "framework", value = {ActivityDelegate.class})
public class RecoverActivityCallback extends ActivityDelegate {
    private static final long MIN_TIME_DELAT = 10000;
    protected static Logger log = LoggerFactory.getLogger("RecoverActivityCallback");
    /* access modifiers changed from: private */
    public String cacheRecoverOrderId;
    /* access modifiers changed from: private */
    public Context context;
    private FetchCallback<RecoverInfo> fetchCallback = new FetchCallback<RecoverInfo>() {
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008f, code lost:
            com.didi.sdk.recover.RecoverActivityCallback.access$000(r8.this$0, "success");
            org.greenrobot.eventbus.EventBus.getDefault().post(new com.didi.sdk.events.SwitchTypeEvent("ride"));
            r3 = com.didi.sdk.app.BroadcastSender.getInstance(com.didi.sdk.recover.RecoverActivityCallback.access$400(r8.this$0));
            r4 = new java.util.HashMap();
            r4.put(com.didichuxing.afanty.common.utils.Constants.JSON_BUSINESS_ID, "extended");
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent("tone_orderrecover_switch_biz", (java.util.Map<java.lang.String, java.lang.Object>) r4);
            r5 = new android.content.Intent();
            r5.setAction(com.didi.component.business.receiver.ReceiverConstant.ACTION_RECOVERY);
            r5.setData(android.net.Uri.parse("OneReceiver://" + "extended" + com.didi.component.business.receiver.ReceiverConstant.MATCHER_RECOVER));
            r5.putExtra("oid", r1);
            r5.putExtra("msg", r9.getMessage());
            r5.putExtra("type", r9.getType());
            r5.putExtra("did", r9.getDriverId());
            r5.putExtra("order_status", r9.getOrderStatus());
            r5.putExtra("pay_status", r9.getPayStatus());
            r5.putExtra("extra", (java.io.Serializable) r9.getExtra());
            r5.putExtra("product_id", r9.getProductId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0136, code lost:
            if (com.didi.sdk.bff.BffUtils.isBffStageNewFifth() == false) goto L_0x0142;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0138, code lost:
            r5.putExtra("order_detail", r9.getOrderDetail());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0142, code lost:
            r3.sendBroadcast(r5);
            r9 = com.didi.sdk.recover.RecoverActivityCallback.log;
            r9.debug("sendOrderRecoverRequest onSuccesss:" + r4.toString(), new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0162, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(com.didi.sdk.recover.RecoverInfo r9) {
            /*
                r8 = this;
                com.didi.sdk.logging.Logger r0 = com.didi.sdk.recover.RecoverActivityCallback.log
                java.lang.String r1 = "sendOrderRecoverRequest onSuccesss"
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r2]
                r0.debug((java.lang.String) r1, (java.lang.Object[]) r3)
                int r0 = r9.getErrorNo()
                if (r0 == 0) goto L_0x0032
                com.didi.sdk.recover.RecoverActivityCallback r0 = com.didi.sdk.recover.RecoverActivityCallback.this
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "errno = "
                r1.append(r2)
                int r9 = r9.getErrorNo()
                r1.append(r9)
                java.lang.String r9 = r1.toString()
                r0.trackRecoverResult(r9)
                com.didi.sdk.recover.RecoverActivityCallback r9 = com.didi.sdk.recover.RecoverActivityCallback.this
                r0 = 1
                boolean unused = r9.needRefresh = r0
                return
            L_0x0032:
                com.didi.sdk.recover.RecoverActivityCallback r0 = com.didi.sdk.recover.RecoverActivityCallback.this
                boolean unused = r0.needRefresh = r2
                java.lang.String r0 = "extended"
                java.lang.String r1 = r9.getProductType()
                if (r1 != 0) goto L_0x0055
                com.didi.sdk.logging.Logger r1 = com.didi.sdk.recover.RecoverActivityCallback.log
                java.lang.String r3 = "no recover"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r1.debug((java.lang.String) r3, (java.lang.Object[]) r2)
                com.didi.sdk.recover.RecoverActivityCallback r1 = com.didi.sdk.recover.RecoverActivityCallback.this
                java.lang.String r2 = "no productType"
                r1.trackRecoverResult(r2)
                com.didi.sdk.recover.RecoverActivityCallback r1 = com.didi.sdk.recover.RecoverActivityCallback.this
                r1.sendNoRecoverBroadcast(r0, r9)
                return
            L_0x0055:
                java.lang.String r1 = r9.getOrderId()
                if (r1 != 0) goto L_0x0071
                com.didi.sdk.recover.RecoverActivityCallback r1 = com.didi.sdk.recover.RecoverActivityCallback.this
                java.lang.String r3 = "no orderId"
                r1.trackRecoverResult(r3)
                com.didi.sdk.logging.Logger r1 = com.didi.sdk.recover.RecoverActivityCallback.log
                java.lang.String r3 = "no oid"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r1.debug((java.lang.String) r3, (java.lang.Object[]) r2)
                com.didi.sdk.recover.RecoverActivityCallback r1 = com.didi.sdk.recover.RecoverActivityCallback.this
                r1.sendNoRecoverBroadcast(r0, r9)
                return
            L_0x0071:
                java.lang.Class<com.didi.sdk.recover.RecoverActivityCallback> r3 = com.didi.sdk.recover.RecoverActivityCallback.class
                monitor-enter(r3)
                com.didi.sdk.recover.RecoverActivityCallback r4 = com.didi.sdk.recover.RecoverActivityCallback.this     // Catch:{ all -> 0x0163 }
                java.lang.String r4 = r4.cacheRecoverOrderId     // Catch:{ all -> 0x0163 }
                boolean r4 = r1.equals(r4)     // Catch:{ all -> 0x0163 }
                if (r4 == 0) goto L_0x0089
                com.didi.sdk.recover.RecoverActivityCallback r9 = com.didi.sdk.recover.RecoverActivityCallback.this     // Catch:{ all -> 0x0163 }
                java.lang.String r0 = "already recovered"
                r9.trackRecoverResult(r0)     // Catch:{ all -> 0x0163 }
                monitor-exit(r3)     // Catch:{ all -> 0x0163 }
                return
            L_0x0089:
                com.didi.sdk.recover.RecoverActivityCallback r4 = com.didi.sdk.recover.RecoverActivityCallback.this     // Catch:{ all -> 0x0163 }
                java.lang.String unused = r4.cacheRecoverOrderId = r1     // Catch:{ all -> 0x0163 }
                monitor-exit(r3)     // Catch:{ all -> 0x0163 }
                com.didi.sdk.recover.RecoverActivityCallback r3 = com.didi.sdk.recover.RecoverActivityCallback.this
                java.lang.String r4 = "success"
                r3.trackRecoverResult(r4)
                org.greenrobot.eventbus.EventBus r3 = org.greenrobot.eventbus.EventBus.getDefault()
                com.didi.sdk.events.SwitchTypeEvent r4 = new com.didi.sdk.events.SwitchTypeEvent
                java.lang.String r5 = "ride"
                r4.<init>(r5)
                r3.post(r4)
                com.didi.sdk.recover.RecoverActivityCallback r3 = com.didi.sdk.recover.RecoverActivityCallback.this
                android.content.Context r3 = r3.context
                com.didi.sdk.app.IBroadcastSender r3 = com.didi.sdk.app.BroadcastSender.getInstance(r3)
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                java.lang.String r5 = "businessId"
                r4.put(r5, r0)
                java.lang.String r5 = "tone_orderrecover_switch_biz"
                com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r4)
                android.content.Intent r5 = new android.content.Intent
                r5.<init>()
                java.lang.String r6 = "com.xiaojukeji.action.ORDER_RECOVER"
                r5.setAction(r6)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "OneReceiver://"
                r6.append(r7)
                r6.append(r0)
                java.lang.String r0 = "/recover"
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.net.Uri r0 = android.net.Uri.parse(r0)
                r5.setData(r0)
                java.lang.String r0 = "oid"
                r5.putExtra(r0, r1)
                java.lang.String r0 = "msg"
                java.lang.String r1 = r9.getMessage()
                r5.putExtra(r0, r1)
                java.lang.String r0 = "type"
                int r1 = r9.getType()
                r5.putExtra(r0, r1)
                java.lang.String r0 = "did"
                java.lang.String r1 = r9.getDriverId()
                r5.putExtra(r0, r1)
                java.lang.String r0 = "order_status"
                int r1 = r9.getOrderStatus()
                r5.putExtra(r0, r1)
                java.lang.String r0 = "pay_status"
                int r1 = r9.getPayStatus()
                r5.putExtra(r0, r1)
                java.lang.String r0 = "extra"
                java.util.Map r1 = r9.getExtra()
                java.io.Serializable r1 = (java.io.Serializable) r1
                r5.putExtra(r0, r1)
                java.lang.String r0 = "product_id"
                int r1 = r9.getProductId()
                r5.putExtra(r0, r1)
                boolean r0 = com.didi.sdk.bff.BffUtils.isBffStageNewFifth()
                if (r0 == 0) goto L_0x0142
                java.lang.String r0 = "order_detail"
                java.lang.String r9 = r9.getOrderDetail()
                r5.putExtra(r0, r9)
            L_0x0142:
                r3.sendBroadcast(r5)
                com.didi.sdk.logging.Logger r9 = com.didi.sdk.recover.RecoverActivityCallback.log
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "sendOrderRecoverRequest onSuccesss:"
                r0.append(r1)
                java.lang.String r1 = r4.toString()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Object[] r1 = new java.lang.Object[r2]
                r9.debug((java.lang.String) r0, (java.lang.Object[]) r1)
                return
            L_0x0163:
                r9 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0163 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.recover.RecoverActivityCallback.C129991.onSuccess(com.didi.sdk.recover.RecoverInfo):void");
        }

        public void onFail(int i) {
            RecoverActivityCallback.log.error("errorNo: %d", Integer.valueOf(i));
            RecoverActivityCallback recoverActivityCallback = RecoverActivityCallback.this;
            recoverActivityCallback.trackRecoverResult("errno2 = " + i);
            boolean unused = RecoverActivityCallback.this.needRefresh = true;
        }
    };
    private boolean hasSendNoRecover;
    private long lastFetchTime;
    protected LoginListeners.LoginListener loginListener = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            RecoverActivityCallback.this.sendOrderRecoverRequest();
        }
    };
    /* access modifiers changed from: private */
    public boolean needRefresh;

    /* access modifiers changed from: private */
    public void sendNoRecoverBroadcast(String str, RecoverInfo recoverInfo) {
        Intent intent = new Intent();
        intent.setAction(ReceiverConstant.ACTION_NO_RECOVER);
        intent.setData(Uri.parse("OneReceiver://" + str + ReceiverConstant.MATCHER_NO_RECOVER));
        intent.putExtra("msg", recoverInfo.getMessage());
        intent.putExtra("type", recoverInfo.getType());
        intent.putExtra("did", recoverInfo.getDriverId());
        intent.putExtra("order_status", recoverInfo.getOrderStatus());
        intent.putExtra("pay_status", recoverInfo.getPayStatus());
        intent.putExtra("extra", (Serializable) recoverInfo.getExtra());
        intent.putExtra("product_id", recoverInfo.getProductId());
        BroadcastSender.getInstance(this.context).sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    public void trackRecoverResult(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", str);
        OmegaSDKAdapter.trackEvent("tone_orderrecover", (Map<String, Object>) hashMap);
    }

    public void onCreate(final Activity activity) {
        log.debug("RecoverActivityCallback", new Object[0]);
        super.onCreate(activity);
        this.context = activity.getApplicationContext();
        registerLoginOut();
        RecoverStore.getInstance().registerReceiver(this);
        TaskScheduler.getDefault().scheduleUiTask(new Runnable() {
            public void run() {
                RecoverActivityCallback.this.judgeLoginState(activity);
            }
        }, 2);
    }

    private void registerLoginOut() {
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                RecoverActivityCallback.log.debug("login out", new Object[0]);
                synchronized (RecoverActivityCallback.class) {
                    String unused = RecoverActivityCallback.this.cacheRecoverOrderId = null;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void judgeLoginState(Activity activity) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            log.debug("already login...", new Object[0]);
            Intent intent = activity.getIntent();
            boolean z = true;
            if (intent != null) {
                z = true ^ intent.getBooleanExtra("switch_locale", false);
            }
            if (z) {
                sendOrderRecoverRequest();
            } else {
                return;
            }
        } else {
            log.debug("not login", new Object[0]);
        }
        OneLoginFacade.getFunction().addLoginListener(this.loginListener);
    }

    /* access modifiers changed from: protected */
    public void sendOrderRecoverRequest() {
        Logger logger = log;
        logger.debug("sendOrderRecoverRequest" + SaApolloUtil.INSTANCE.getSaState(), new Object[0]);
        if (!SaApolloUtil.INSTANCE.getSaState()) {
            this.lastFetchTime = System.currentTimeMillis();
            OmegaSDKAdapter.trackEvent("tone_orderrecover_total");
            RecoverStore.getInstance().orderRecover(this.context, this.fetchCallback);
        }
    }

    @EventReceiver(ThreadMode.Async)
    private void onReceive(DefaultEvent defaultEvent) {
        if (RecoverStore.ACTION_REFRESH_RECOVER.equals(defaultEvent.getType())) {
            RecoverStore.getInstance();
            boolean isNewOrderRecover = RecoverStore.isNewOrderRecover();
            Logger logger = log;
            logger.debug("RecoverActivityCallback recevier ACTION_REFRESH_RECOVER event... isNewRecover = " + isNewOrderRecover + " needRefresh = " + this.needRefresh, new Object[0]);
            if (isNewOrderRecover && this.needRefresh && !RecoverStore.getInstance().isRecoverSuccess() && System.currentTimeMillis() - this.lastFetchTime >= 10000) {
                if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                    log.debug("already login refresh...", new Object[0]);
                    sendOrderRecoverRequest();
                    return;
                }
                log.debug("not login not refresh", new Object[0]);
            }
        } else if (RecoverStore.ACTION_REFRESH_RECOVER_FORCE.equals(defaultEvent.getType())) {
            this.cacheRecoverOrderId = null;
            if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                log.debug("already login refresh...", new Object[0]);
                sendOrderRecoverRequest();
                return;
            }
            log.debug("not login not refresh", new Object[0]);
        }
    }
}
