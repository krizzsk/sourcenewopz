package com.didi.sdk.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.didi.sdk.protobuf.CoordinateType;
import com.didi.sdk.protobuf.UserAgent;
import com.didi.sdk.push.IPush;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PushClient {
    private static final int OP_CODE_INIT = 1;
    private static final int OP_CODE_START_PUSH = 2;
    private static final int OP_CODE_STOP_PUSH = 3;
    private static final String TAG = PushClient.class.getSimpleName();
    private static PushClient sClient;
    private int debugMode;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private boolean init;
    /* access modifiers changed from: private */

    /* renamed from: ip */
    public String f37077ip;
    private boolean isStart = false;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public volatile PushOption mOption;
    /* access modifiers changed from: private */
    public IPush mPush;
    /* access modifiers changed from: private */
    public int port;
    /* access modifiers changed from: private */
    public volatile RouteSelector routeSelector;

    private PushClient() {
        HandlerThread handlerThread = new HandlerThread("didi_push");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    PushClient.this.createPush();
                } else if (i == 2) {
                    PushClient.this.startPushInternal();
                } else if (i == 3) {
                    PushClient.this.stopPushInternal();
                }
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void createPush() {
        Dns dns = (Dns) SpiComponentManager.getInstance().getComponent(Dns.class);
        if (dns == null) {
            dns = this.mOption.getDns();
        }
        Dns dns2 = dns;
        if (this.mPush == null) {
            IPush createPush = createPush(Push.getInstance());
            this.mPush = createPush;
            if (createPush == null) {
                PushLog.m26282e(TAG, "createPush failed when first calling setOption.");
                return;
            }
            if ((createPush instanceof PushImplV5) && PushSelector.getDefault().isDQuicOpen()) {
                this.mPush.setBusinessType(IPush.BusinessType.BUSINESS_TYPE_DQUIC);
            } else if (PushSelector.getDefault().isTLSOpen()) {
                this.mPush.setBusinessType(IPush.BusinessType.BUSINESS_TYPE_TLS);
            } else {
                this.mPush.setBusinessType(IPush.BusinessType.BUSINESS_TYPE_NORMAL);
            }
            this.mPush.setPushCallback(new PushCallback());
            this.mPush.setDebugMode(this.debugMode);
        }
        this.routeSelector = new RouteSelector(this.mOption.getContext(), this.mOption.getIp(), this.mOption.getPort(), dns2, RouteStrategyFactory.create(PushSelector.getDefault().getRouteType()));
    }

    private IPush createPush(Push push) {
        String pushVer = PushSelector.getDefault().getPushVer();
        if (pushVer.equals("1")) {
            return new PushImplV1(push);
        }
        if (pushVer.equals("2")) {
            return new PushImplV2(push);
        }
        if (pushVer.equals("4")) {
            return new PushImplV4(push);
        }
        if (pushVer.equals("5")) {
            return new PushImplV5(push);
        }
        return null;
    }

    public void setDebugModeState(int i) {
        this.debugMode = i;
        IPush iPush = this.mPush;
        if (iPush != null) {
            iPush.setDebugMode(i);
        }
    }

    public static PushClient getClient() {
        if (sClient == null) {
            synchronized (PushClient.class) {
                if (sClient == null) {
                    sClient = new PushClient();
                }
            }
        }
        return sClient;
    }

    public synchronized void setOption(PushOption pushOption) {
        this.mOption = pushOption;
        this.mHandler.sendEmptyMessage(1);
    }

    public synchronized PushOption getOption() {
        return this.mOption;
    }

    public boolean isConnected() {
        IPush iPush = this.mPush;
        if (iPush == null) {
            return false;
        }
        return iPush.isConnected();
    }

    public synchronized void startPush() {
        this.isStart = true;
        this.mHandler.sendEmptyMessage(2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startPushInternal() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.didi.sdk.push.IPush r0 = r3.mPush     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0073
            boolean r0 = r3.isStart     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0073
        L_0x000a:
            com.didi.sdk.push.PushOption r0 = r3.mOption     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0071
            com.didi.sdk.push.PushOption r0 = r3.mOption     // Catch:{ all -> 0x0075 }
            boolean r0 = r0.checkValid()     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0017
            goto L_0x0071
        L_0x0017:
            boolean r0 = r3.init     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0065
            com.didi.sdk.push.PushOption r0 = r3.mOption     // Catch:{ all -> 0x0075 }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.NetworkChangeHandler r1 = com.didi.sdk.push.NetworkChangeHandler.getDefault()     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.PushOption r2 = r3.mOption     // Catch:{ all -> 0x0075 }
            android.content.Context r2 = r2.getContext()     // Catch:{ all -> 0x0075 }
            r1.init(r2)     // Catch:{ all -> 0x0075 }
            boolean r1 = r0 instanceof android.app.Application     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0035
        L_0x0032:
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0075 }
            goto L_0x003a
        L_0x0035:
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0075 }
            goto L_0x0032
        L_0x003a:
            com.didi.sdk.push.ActivityLifecycleManager r1 = com.didi.sdk.push.ActivityLifecycleManager.getInstance()     // Catch:{ all -> 0x0075 }
            r1.init(r0)     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.ActivityLifecycleManager r0 = com.didi.sdk.push.ActivityLifecycleManager.getInstance()     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.PushClient$2 r1 = new com.didi.sdk.push.PushClient$2     // Catch:{ all -> 0x0075 }
            r1.<init>()     // Catch:{ all -> 0x0075 }
            r0.registerAppStateListener(r1)     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.IPush r0 = r3.mPush     // Catch:{ all -> 0x0075 }
            r1 = 0
            r0.init(r1)     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.IPush r0 = r3.mPush     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.PushConfig r1 = new com.didi.sdk.push.PushConfig     // Catch:{ all -> 0x0075 }
            r1.<init>()     // Catch:{ all -> 0x0075 }
            r0.config(r1)     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.IPush r0 = r3.mPush     // Catch:{ all -> 0x0075 }
            r0.startLoop()     // Catch:{ all -> 0x0075 }
            r0 = 1
            r3.init = r0     // Catch:{ all -> 0x0075 }
        L_0x0065:
            java.util.concurrent.ExecutorService r0 = r3.executorService     // Catch:{ all -> 0x0075 }
            com.didi.sdk.push.PushClient$3 r1 = new com.didi.sdk.push.PushClient$3     // Catch:{ all -> 0x0075 }
            r1.<init>()     // Catch:{ all -> 0x0075 }
            r0.execute(r1)     // Catch:{ all -> 0x0075 }
            monitor-exit(r3)
            return
        L_0x0071:
            monitor-exit(r3)
            return
        L_0x0073:
            monitor-exit(r3)
            return
        L_0x0075:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.PushClient.startPushInternal():void");
    }

    public synchronized void stopPush() {
        if (this.mPush != null) {
            this.isStart = false;
            this.mHandler.sendEmptyMessage(3);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void stopPushInternal() {
        this.executorService.execute(new Runnable() {
            public void run() {
                PushClient.this.mPush.stopConnChannel();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onAppEvent(int i, int i2) {
        IPush iPush = this.mPush;
        if (iPush != null) {
            iPush.onAppEvent(i, i2);
        }
    }

    public int sendRequest(PushRequest pushRequest) {
        return sendRequest(pushRequest, (PushRequestCallback) null);
    }

    public int sendRequest(PushRequest pushRequest, PushRequestCallback pushRequestCallback) {
        IPush iPush = this.mPush;
        if (iPush == null) {
            return -1;
        }
        return iPush.request(pushRequest, pushRequestCallback);
    }

    public void registerConnectionListener(PushConnectionListener pushConnectionListener) {
        PushConnectionDispatcher.getInstance().registerConnectionListener(pushConnectionListener);
    }

    public void unregisterConnectionListener(PushConnectionListener pushConnectionListener) {
        PushConnectionDispatcher.getInstance().unregisterConnectionListener(pushConnectionListener);
    }

    public void registerMessageListener(PushKey pushKey, PushReceiveListener pushReceiveListener) {
        PushMessageDispatcher.getInstance().registerRcvDataListener(pushKey, pushReceiveListener);
    }

    public void unregisterMessageListener(PushKey pushKey, PushReceiveListener pushReceiveListener) {
        PushMessageDispatcher.getInstance().unregisterRcvDataListener(pushKey, pushReceiveListener);
    }

    public void registerMessageInterceptor(PushReceiveInterceptor pushReceiveInterceptor) {
        PushMessageDispatcher.getInstance().registerInterceptor(pushReceiveInterceptor);
    }

    public void unregisterMessageInterceptor(PushReceiveInterceptor pushReceiveInterceptor) {
        PushMessageDispatcher.getInstance().unregisterInterceptor(pushReceiveInterceptor);
    }

    public void mockPublishMessage(int i, byte[] bArr, byte[] bArr2) {
        PushMessageDispatcher.getInstance().dispatcherMessage(i, bArr, bArr2);
    }

    /* access modifiers changed from: private */
    public static UserAgent buildUserAgent(PushOption pushOption) {
        String str;
        UserAgent.Builder builder = new UserAgent.Builder();
        String[] networkAndOperator = Utils.getNetworkAndOperator(pushOption.getContext());
        String str2 = "";
        if (networkAndOperator == null || networkAndOperator.length <= 1) {
            str = str2;
        } else {
            String str3 = networkAndOperator[0];
            str2 = networkAndOperator[1];
            str = str3;
        }
        builder.os_type("android").os_ver(WsgSecInfo.osVersion(pushOption.getContext())).model(WsgSecInfo.model(pushOption.getContext())).client_ver(WsgSecInfo.appVersionName(pushOption.getContext())).network(str2).location(String.format("%d,%3.5f,%3.5f", new Object[]{Integer.valueOf(CoordinateType.GCJ_02.getValue()), Double.valueOf(pushOption.getLng()), Double.valueOf(pushOption.getLat())})).carrier_operator(str);
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public synchronized void setConnectIp(String str) {
        this.f37077ip = str;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setConnectPort(int i) {
        this.port = i;
    }

    public synchronized String getConnectIp() {
        return this.f37077ip;
    }

    public synchronized int getConnectPort() {
        return this.port;
    }

    private boolean supportSendAckCallbackFeature() {
        return PushSelector.getDefault().getPushVer().equals("4");
    }

    public int localIPStackDetect() {
        IPush iPush = this.mPush;
        if (iPush == null) {
            return 1;
        }
        return iPush.localIPStackDetect();
    }

    public boolean supportIpv6() {
        int localIPStackDetect = localIPStackDetect();
        return localIPStackDetect == 2 || localIPStackDetect == 3;
    }
}
