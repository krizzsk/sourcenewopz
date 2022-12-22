package com.didi.foundation.sdk.liveconnection;

import android.content.Context;
import android.util.SparseArray;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.ByteArrayPushResponse;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushConnResult;
import com.didi.sdk.push.PushConnectionListener;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushMsgResponse;
import com.didi.sdk.push.PushOption;
import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushRequest;
import com.didi.sdk.push.PushResponse;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.squareup.wire.Wire;
import global.didi.pay.newview.pix.IPixView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@ServiceProvider({LiveConnectionServiceProvider.class})
public class LiveConnectionServiceImpl implements LiveConnectionServiceProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ThreadLocal<Wire> f21183a = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Logger f21184b = LogService.getLogger((Class<?>) LiveConnectionServiceImpl.class);

    /* renamed from: c */
    private PushConnectionListenerImpl f21185c;

    /* renamed from: d */
    private SparseArray<PushReceiveListenerImpl> f21186d;

    /* renamed from: e */
    private LogListener f21187e;

    public void config(Context context, Option option) {
        if (context == null) {
            this.f21184b.debug("init context null", new Object[0]);
        } else if (option == null) {
            this.f21184b.debug("init option null", new Object[0]);
        } else {
            this.f21184b.debug(IPixView.PAGE_STATUS_INIT, new Object[0]);
            String phone = option.getPhone();
            String token = option.getToken();
            String appId = option.getAppId();
            String ip = option.getIp();
            int port = option.getPort();
            int role = option.getRole();
            PushOption.Builder builder = new PushOption.Builder();
            builder.context(context).mo95545ip(ip).port(port).role(role).phone(phone).appId(appId).token(token);
            PushClient.getClient().setOption(builder.build());
        }
    }

    public void start() {
        this.f21184b.debug("start", new Object[0]);
        PushClient.getClient().startPush();
    }

    public void stop() {
        this.f21184b.debug("stop", new Object[0]);
        PushClient.getClient().stopPush();
    }

    public void release() {
        this.f21184b.debug("release", new Object[0]);
        removeAllConnectionListener();
        removeAllMessageListener();
    }

    public boolean isConnected() {
        boolean isConnected = PushClient.getClient().isConnected();
        Logger logger = this.f21184b;
        logger.debug("isConnected:" + isConnected, new Object[0]);
        return isConnected;
    }

    public void registerConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener == null) {
            this.f21184b.debug("registerConnectionListener connectionListener null", new Object[0]);
            return;
        }
        if (this.f21185c == null) {
            this.f21184b.debug("new instance mPushConnectionListener", new Object[0]);
            this.f21185c = new PushConnectionListenerImpl();
            PushClient.getClient().registerConnectionListener(this.f21185c);
        }
        this.f21185c.addConnectionListener(connectionListener);
    }

    public void unRegisterConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener == null) {
            this.f21184b.debug("unRegisterConnectionListener connectionListener null", new Object[0]);
            return;
        }
        PushConnectionListenerImpl pushConnectionListenerImpl = this.f21185c;
        if (pushConnectionListenerImpl == null) {
            this.f21184b.debug("unRegisterConnectionListener mPushConnectionListener null", new Object[0]);
        } else {
            pushConnectionListenerImpl.removeConnectionListener(connectionListener);
        }
    }

    public void removeAllConnectionListener() {
        if (this.f21185c == null) {
            this.f21184b.debug("removeAllConnectionListener mPushConnectionListener null", new Object[0]);
            return;
        }
        PushClient.getClient().unregisterConnectionListener(this.f21185c);
        this.f21185c.clearListeners();
        this.f21185c = null;
    }

    public void registerMessageListener(MessageListener messageListener) {
        if (messageListener == null) {
            this.f21184b.debug("registerMessageListener messageListener null", new Object[0]);
            return;
        }
        if (this.f21186d == null) {
            this.f21186d = new SparseArray<>();
        }
        int pushKey = messageListener.getPushKey();
        if (this.f21186d.indexOfKey(pushKey) >= 0) {
            this.f21184b.debug("mPushReceiveListenerSparseArray containsKey", new Object[0]);
            this.f21186d.get(pushKey).addMessageListener(messageListener);
            return;
        }
        this.f21184b.debug("mPushReceiveListenerSparseArray not containsKey", new Object[0]);
        PushReceiveListenerImpl pushReceiveListenerImpl = new PushReceiveListenerImpl();
        pushReceiveListenerImpl.addMessageListener(messageListener);
        this.f21186d.put(pushKey, pushReceiveListenerImpl);
        PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(pushKey), pushReceiveListenerImpl);
    }

    public void unRegisterMessageListener(MessageListener messageListener) {
        if (messageListener == null) {
            this.f21184b.debug("unRegisterMessageListener messageListener null", new Object[0]);
        } else if (this.f21186d == null) {
            this.f21184b.debug("unRegisterMessageListener mPushReceiveListenerSparseArray null", new Object[0]);
        } else {
            int pushKey = messageListener.getPushKey();
            if (this.f21186d.indexOfKey(pushKey) >= 0) {
                this.f21186d.get(pushKey).removeMessageListener(messageListener);
            }
        }
    }

    public void removeAllMessageListener() {
        if (this.f21186d == null) {
            this.f21184b.debug("removeAllMessageListener mPushReceiveListenerSparseArray null", new Object[0]);
            return;
        }
        for (int i = 0; i < this.f21186d.size(); i++) {
            int keyAt = this.f21186d.keyAt(i);
            PushReceiveListenerImpl pushReceiveListenerImpl = this.f21186d.get(keyAt);
            if (pushReceiveListenerImpl != null) {
                PushClient.getClient().unregisterMessageListener(PushKey.Creator.createAppPushMsgKey(keyAt), pushReceiveListenerImpl);
                pushReceiveListenerImpl.clearListeners();
            }
        }
        this.f21186d.clear();
        this.f21186d = null;
    }

    public void sendRequest(Request request) {
        if (request == null) {
            this.f21184b.debug("sendRequest request null", new Object[0]);
            return;
        }
        this.f21184b.debug("sendRequest", new Object[0]);
        PushRequest.Builder builder = new PushRequest.Builder();
        builder.msgType(request.getMessageType()).data(request.getData()).needResponse(request.isNeedResponse()).seqIdOut(request.getSeqIdOut());
        PushClient.getClient().sendRequest(builder.build());
    }

    public void setLogListener(LogListener logListener) {
        this.f21187e = logListener;
    }

    public LogListener getLogListener() {
        return this.f21187e;
    }

    public final class PushConnectionListenerImpl implements PushConnectionListener {
        private CopyOnWriteArrayList<ConnectionListener> mConnectionListeners;

        private PushConnectionListenerImpl() {
            this.mConnectionListeners = new CopyOnWriteArrayList<>();
        }

        /* access modifiers changed from: private */
        public void addConnectionListener(ConnectionListener connectionListener) {
            if (!this.mConnectionListeners.contains(connectionListener)) {
                this.mConnectionListeners.add(connectionListener);
            }
        }

        /* access modifiers changed from: private */
        public void removeConnectionListener(ConnectionListener connectionListener) {
            this.mConnectionListeners.remove(connectionListener);
        }

        /* access modifiers changed from: private */
        public void clearListeners() {
            this.mConnectionListeners.clear();
        }

        public void onConnection(PushConnResult pushConnResult) {
            if (pushConnResult != null) {
                Iterator<ConnectionListener> it = this.mConnectionListeners.iterator();
                while (it.hasNext()) {
                    ConnectionListener next = it.next();
                    if (next != null) {
                        next.onConnection(pushConnResult.getRetCode(), pushConnResult.getSubCode());
                    }
                }
                return;
            }
            LiveConnectionServiceImpl.this.f21184b.debug("PushConnectionListenerImpl onConnection pushConnResult null", new Object[0]);
        }
    }

    public final class PushReceiveListenerImpl implements PushReceiveListener<PushResponse> {
        private CopyOnWriteArrayList<MessageListener> mMessageListeners;

        private PushReceiveListenerImpl() {
            this.mMessageListeners = new CopyOnWriteArrayList<>();
        }

        /* access modifiers changed from: private */
        public void addMessageListener(MessageListener messageListener) {
            if (!this.mMessageListeners.contains(messageListener)) {
                this.mMessageListeners.add(messageListener);
            }
        }

        /* access modifiers changed from: private */
        public void removeMessageListener(MessageListener messageListener) {
            this.mMessageListeners.remove(messageListener);
        }

        /* access modifiers changed from: private */
        public void clearListeners() {
            this.mMessageListeners.clear();
        }

        public void onReceive(PushResponse pushResponse) {
            if (pushResponse == null) {
                LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive pushResponse null", new Object[0]);
            } else if (pushResponse instanceof PushMsgResponse) {
                LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive PushMsgResponse", new Object[0]);
                PushMsg pushMsg = ((PushMsgResponse) pushResponse).getPushMsg();
                if (pushMsg != null && pushMsg.payload != null) {
                    byte[] bytes = pushMsg.payload.utf8().getBytes();
                    Iterator<MessageListener> it = this.mMessageListeners.iterator();
                    while (it.hasNext()) {
                        MessageListener next = it.next();
                        if (next != null) {
                            next.onReceive(new Response(pushResponse.getMsgType(), pushResponse.getSeqId(), bytes));
                        }
                    }
                }
            } else if (pushResponse instanceof ByteArrayPushResponse) {
                LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive ByteArrayPushResponse", new Object[0]);
                byte[] originData = ((ByteArrayPushResponse) pushResponse).getOriginData();
                if (originData != null) {
                    try {
                        Wire wire = (Wire) LiveConnectionServiceImpl.f21183a.get();
                        if (wire == null) {
                            wire = new Wire((Class<?>[]) new Class[0]);
                            LiveConnectionServiceImpl.f21183a.set(wire);
                        }
                        PushMsg pushMsg2 = (PushMsg) wire.parseFrom(originData, PushMsg.class);
                        if (pushMsg2 == null) {
                            LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive PushMsg null", new Object[0]);
                        } else if (pushMsg2.payload == null) {
                            LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive msg.payload null", new Object[0]);
                        } else {
                            Iterator<MessageListener> it2 = this.mMessageListeners.iterator();
                            while (it2.hasNext()) {
                                MessageListener next2 = it2.next();
                                if (next2 != null) {
                                    next2.onReceive(new Response(pushResponse.getMsgType(), pushResponse.getSeqId(), pushMsg2.payload.utf8().getBytes()));
                                }
                            }
                        }
                    } catch (Throwable th) {
                        LiveConnectionServiceImpl.this.f21184b.debug("PushReceiveListenerImpl onReceive Wire parse exception", new Object[0]);
                        th.printStackTrace();
                    }
                }
            }
        }
    }
}
