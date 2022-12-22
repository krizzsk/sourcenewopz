package com.didi.sdk.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.didi.sdk.protobuf.MsgType;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushRequest;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

class PushConnectDetector {
    private static final String APOLLO_NAME = "LonglinkUpAckStat";
    private static final String APOLLO_PARAM_KEY_INTERVAL = "inteveal";
    private static final String APOLLO_PARAM_KEY_TIMEOUT = "timeout";
    private static final int MIN_LOOP_INTERVAL = 10;
    private static final int MIN_TIMEOUT = 10;
    private static final int MSG_CHECK_TIMEOUT = 1;
    private static final int MSG_CONNECT = 0;
    private static final String TAG = "PushConnectDetector";
    private boolean apolloEnabled;
    private ConnectDetectorHandler handler;
    /* access modifiers changed from: private */
    public Lock lock = new ReentrantLock();
    private int looperInterval = 10;
    /* access modifiers changed from: private */
    public Map<Long, Long> sendMap = new HashMap();
    private int timeout = 10;

    PushConnectDetector() {
        IToggle toggle = Apollo.getToggle(APOLLO_NAME);
        boolean allow = toggle.allow();
        this.apolloEnabled = allow;
        PushLog.m26280d(TAG, String.format("apollo allow => %s", new Object[]{Boolean.valueOf(allow)}));
        if (this.apolloEnabled) {
            IExperiment experiment = toggle.getExperiment();
            this.looperInterval = ((Integer) experiment.getParam(APOLLO_PARAM_KEY_INTERVAL, 0)).intValue();
            this.timeout = ((Integer) experiment.getParam("timeout", 0)).intValue();
            checkData();
            registerCallback();
        }
    }

    /* access modifiers changed from: package-private */
    public void startCheck() {
        if (this.apolloEnabled) {
            HandlerThread handlerThread = new HandlerThread("PushDetectHandler");
            handlerThread.start();
            ConnectDetectorHandler connectDetectorHandler = new ConnectDetectorHandler(handlerThread.getLooper());
            this.handler = connectDetectorHandler;
            connectDetectorHandler.sendEmptyMessageDelayed(0, (long) (this.looperInterval * 1000));
        }
    }

    private void registerCallback() {
        PushClient.getClient().registerMessageListener(PushKey.Creator.createPushMsgKey(MsgType.kMsgTypeConnsvrDetectRsp.getValue()), new PushReceiveListener() {
            /* JADX INFO: finally extract failed */
            public void onReceive(PushResponse pushResponse) {
                if (pushResponse != null) {
                    long j = ByteBuffer.wrap(pushResponse.getSeqId()).order(ByteOrder.LITTLE_ENDIAN).getLong();
                    PushConnectDetector.this.lock.lock();
                    try {
                        Long l = (Long) PushConnectDetector.this.sendMap.remove(Long.valueOf(j));
                        PushConnectDetector.this.lock.unlock();
                        int i = 1;
                        if (l != null) {
                            long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
                            PushLog.m26280d(PushConnectDetector.TAG, String.format("seqid[%d] cost %d ms", new Object[]{Long.valueOf(j), Long.valueOf(elapsedRealtime)}));
                            HashMap hashMap = new HashMap();
                            hashMap.put("dur", Long.valueOf(elapsedRealtime));
                            hashMap.put(NotificationCompat.CATEGORY_ERROR, 0);
                            hashMap.put("ip", "" + PushClient.getClient().getConnectIp());
                            hashMap.put(AgentOptions.PORT, Integer.valueOf(PushClient.getClient().getConnectPort()));
                            hashMap.put("pushver", PushSelector.getDefault().getPushVer());
                            if (PushSelector.getDefault().isTLSOpen()) {
                                i = 2;
                            }
                            hashMap.put("tls", Integer.valueOf(i));
                            EventTracker.getInstance().trackEvent("trace_socket_upack", hashMap);
                            return;
                        }
                        PushLog.m26280d(PushConnectDetector.TAG, String.format("Can not find value by key[%d]", new Object[]{Long.valueOf(j)}));
                    } catch (Throwable th) {
                        PushConnectDetector.this.lock.unlock();
                        throw th;
                    }
                }
            }
        });
    }

    private void checkData() {
        if (this.looperInterval < 10) {
            this.looperInterval = 10;
        }
        if (this.timeout < 10) {
            this.timeout = 10;
        }
    }

    private class ConnectDetectorHandler extends Handler {
        public ConnectDetectorHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                PushConnectDetector.this.sendMsg();
            } else if (i == 1) {
                PushConnectDetector.this.handleTimeout(((Long) message.obj).longValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleTimeout(long j) {
        this.lock.lock();
        try {
            if (this.sendMap.containsKey(Long.valueOf(j))) {
                this.sendMap.remove(Long.valueOf(j));
                this.lock.unlock();
                int i = 1;
                PushLog.m26280d(TAG, String.format("seqId[%d] timeout", new Object[]{Long.valueOf(j)}));
                HashMap hashMap = new HashMap();
                hashMap.put("dur", 0);
                hashMap.put(NotificationCompat.CATEGORY_ERROR, -1);
                hashMap.put("ip", "" + PushClient.getClient().getConnectIp());
                hashMap.put(AgentOptions.PORT, Integer.valueOf(PushClient.getClient().getConnectPort()));
                hashMap.put("pushver", PushSelector.getDefault().getPushVer());
                if (PushSelector.getDefault().isTLSOpen()) {
                    i = 2;
                }
                hashMap.put("tls", Integer.valueOf(i));
                EventTracker.getInstance().trackEvent("trace_socket_upack", hashMap);
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void sendMsg() {
        PushLog.m26280d(TAG, "start request");
        this.handler.sendEmptyMessageDelayed(0, (long) (this.looperInterval * 1000));
        if (PushClient.getClient().isConnected()) {
            this.lock.lock();
            try {
                byte[] bArr = new byte[8];
                PushRequest.Builder builder = new PushRequest.Builder();
                builder.msgType(MsgType.kMsgTypeConnsvrDetectReq.getValue()).seqIdOut(bArr).data(new byte[0]).priority(0).needResponse(false);
                if (PushClient.getClient().sendRequest(builder.build()) != 0) {
                    PushLog.m26280d(TAG, "send failed");
                    return;
                }
                long j = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
                this.sendMap.put(Long.valueOf(j), Long.valueOf(SystemClock.elapsedRealtime()));
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = Long.valueOf(j);
                this.handler.sendMessageDelayed(obtain, (long) (this.timeout * 1000));
                this.lock.unlock();
            } finally {
                this.lock.unlock();
            }
        }
    }
}
