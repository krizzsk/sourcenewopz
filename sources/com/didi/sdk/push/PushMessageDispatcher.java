package com.didi.sdk.push;

import android.os.Handler;
import com.didi.sdk.protobuf.MsgType;
import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.ByteArrayPushResponse;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushMsgResponse;
import com.didi.sdk.push.thread.AsyncHandler;
import com.didi.sdk.push.thread.BackgroundHandler;
import com.didi.sdk.push.thread.MainHandler;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PushMessageDispatcher {
    private static final ThreadLocal<Wire> WIRE_THREAD_LOCAL = new ThreadLocal<>();
    private final AsyncHandler mAsyncGroundHandler;
    private final BackgroundHandler mBackGroundHandler;
    private final ExecutorService mExecutor;
    private final Handler mMainThreadHandler;
    private final Map<Long, Set<PushReceiveListener>> pushRcvDataListenerMap;
    private final Set<PushReceiveInterceptor> pushRcvInterceptor;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static PushMessageDispatcher INSTANCE = new PushMessageDispatcher();

        private SingletonHolder() {
        }
    }

    public static PushMessageDispatcher getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private PushMessageDispatcher() {
        this.pushRcvDataListenerMap = new HashMap();
        this.pushRcvInterceptor = new HashSet();
        Iterator<S> it = ServiceLoader.load(PushReceiveListener.class).iterator();
        while (it.hasNext()) {
            PushReceiveListener pushReceiveListener = (PushReceiveListener) it.next();
            if (pushReceiveListener != null && (pushReceiveListener instanceof PushKey)) {
                registerRcvDataListener((PushKey) pushReceiveListener, pushReceiveListener);
            }
        }
        this.mMainThreadHandler = new MainHandler();
        this.mBackGroundHandler = new BackgroundHandler();
        this.mAsyncGroundHandler = new AsyncHandler();
        this.mExecutor = Executors.newCachedThreadPool();
    }

    /* access modifiers changed from: package-private */
    public void registerRcvDataListener(PushKey pushKey, PushReceiveListener pushReceiveListener) {
        if (pushReceiveListener != null) {
            synchronized (this.pushRcvDataListenerMap) {
                long generateKey = pushKey.generateKey();
                Set set = this.pushRcvDataListenerMap.get(Long.valueOf(generateKey));
                if (set == null) {
                    set = new LinkedHashSet();
                    this.pushRcvDataListenerMap.put(Long.valueOf(generateKey), set);
                }
                set.add(pushReceiveListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterRcvDataListener(PushKey pushKey, PushReceiveListener pushReceiveListener) {
        if (pushReceiveListener != null) {
            synchronized (this.pushRcvDataListenerMap) {
                Set set = this.pushRcvDataListenerMap.get(Long.valueOf(pushKey.generateKey()));
                if (set != null) {
                    set.remove(pushReceiveListener);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatcherMessage(int i, byte[] bArr, byte[] bArr2) {
        handlePushMsg(i, bArr, bArr2);
        handleAppPushMsg(i, bArr, bArr2);
    }

    private void handlePushMsg(int i, byte[] bArr, byte[] bArr2) {
        final LinkedHashSet linkedHashSet;
        final ByteArrayPushResponse.Builder builder = new ByteArrayPushResponse.Builder();
        builder.msgType(i).seqId(bArr).originData(bArr2);
        final long generateKey = PushKey.Creator.createPushMsgKey(i).generateKey();
        synchronized (this.pushRcvInterceptor) {
            linkedHashSet = new LinkedHashSet(this.pushRcvInterceptor);
        }
        if (linkedHashSet.size() == 0) {
            dispatchByKey(generateKey, builder.build());
        } else {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    PushMessageDispatcher.this.dispatchByKey(generateKey, PushMessageDispatcher.this.intercept(builder.build(), linkedHashSet));
                }
            });
        }
    }

    private void handleAppPushMsg(int i, byte[] bArr, byte[] bArr2) {
        if (i == MsgType.kMsgTypeAppPushMessageReq.getValue()) {
            PushMsg pushMsg = null;
            try {
                Wire wire = WIRE_THREAD_LOCAL.get();
                if (wire == null) {
                    wire = new Wire((Class<?>[]) new Class[0]);
                    WIRE_THREAD_LOCAL.set(wire);
                }
                pushMsg = (PushMsg) wire.parseFrom(bArr2, PushMsg.class);
            } catch (Throwable unused) {
            }
            if (pushMsg != null) {
                PushMsgResponse.Builder builder = new PushMsgResponse.Builder();
                builder.msgType(i).seqId(bArr).pushMsg(pushMsg);
                dispatchByKey(PushKey.Creator.createAppPushMsgKey(((Integer) Wire.get(pushMsg.type, PushMsg.DEFAULT_TYPE)).intValue()).generateKey(), builder.build());
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchByKey(long j, PushResponse pushResponse) {
        LinkedHashSet<PushReceiveListener> linkedHashSet;
        synchronized (this.pushRcvDataListenerMap) {
            Set set = this.pushRcvDataListenerMap.get(Long.valueOf(j));
            linkedHashSet = set != null ? new LinkedHashSet<>(set) : null;
        }
        if (linkedHashSet != null) {
            for (PushReceiveListener onReceiveSingleListener : linkedHashSet) {
                onReceiveSingleListener(this.mExecutor, onReceiveSingleListener, pushResponse);
            }
        }
    }

    private void onReceiveSingleListener(ExecutorService executorService, final PushReceiveListener pushReceiveListener, final PushResponse pushResponse) {
        if (pushReceiveListener != null) {
            if (pushReceiveListener instanceof ThreadModePushRcvListener) {
                int i = C129513.$SwitchMap$com$didi$sdk$push$thread$ThreadMode[((ThreadModePushRcvListener) pushReceiveListener).getThreadMode().ordinal()];
                if (i == 1) {
                    this.mMainThreadHandler.post(new Runnable() {
                        public void run() {
                            pushReceiveListener.onReceive(pushResponse);
                        }
                    });
                } else if (i == 2) {
                    this.mBackGroundHandler.enqueue(executorService, pushReceiveListener, pushResponse);
                } else if (i == 3) {
                    this.mAsyncGroundHandler.enqueue(executorService, pushReceiveListener, pushResponse);
                }
            } else {
                this.mBackGroundHandler.enqueue(executorService, pushReceiveListener, pushResponse);
            }
        }
    }

    /* renamed from: com.didi.sdk.push.PushMessageDispatcher$3 */
    static /* synthetic */ class C129513 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$push$thread$ThreadMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.sdk.push.thread.ThreadMode[] r0 = com.didi.sdk.push.thread.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$push$thread$ThreadMode = r0
                com.didi.sdk.push.thread.ThreadMode r1 = com.didi.sdk.push.thread.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$push$thread$ThreadMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.push.thread.ThreadMode r1 = com.didi.sdk.push.thread.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$push$thread$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.push.thread.ThreadMode r1 = com.didi.sdk.push.thread.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.PushMessageDispatcher.C129513.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void registerInterceptor(PushReceiveInterceptor pushReceiveInterceptor) {
        if (pushReceiveInterceptor != null) {
            synchronized (this.pushRcvInterceptor) {
                this.pushRcvInterceptor.add(pushReceiveInterceptor);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterInterceptor(PushReceiveInterceptor pushReceiveInterceptor) {
        if (pushReceiveInterceptor != null) {
            synchronized (this.pushRcvInterceptor) {
                this.pushRcvInterceptor.remove(pushReceiveInterceptor);
            }
        }
    }

    /* access modifiers changed from: private */
    public PushResponse intercept(PushResponse pushResponse, Set<PushReceiveInterceptor> set) {
        if (set == null) {
            return pushResponse;
        }
        for (PushReceiveInterceptor intercept : set) {
            pushResponse = intercept.intercept(pushResponse);
        }
        return pushResponse;
    }
}
