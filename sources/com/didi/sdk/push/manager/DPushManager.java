package com.didi.sdk.push.manager;

import android.content.Context;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IPushComponent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.PushConnectionListener;
import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.List;

public class DPushManager {
    private static final byte[] EMPTY = new byte[8];
    private static final String TAG = "DPushManager";
    private static Logger logger = LoggerFactory.getLogger(TAG);
    private List<IPushComponent> components = new ArrayList();
    private Context context;
    private boolean hasConfigInit;
    private boolean hasInit;
    private DiDiPush mDiPush = new DiDiPush();

    private DPushManager() {
    }

    public static DPushManager getInstance() {
        return (DPushManager) SingletonHolder.getInstance(DPushManager.class);
    }

    public void addExtraPushComponent(IPushComponent iPushComponent) {
        this.components.add(iPushComponent);
        Logger logger2 = logger;
        logger2.infoEvent(TAG, "addExtraPushComponent. pushComponent = " + iPushComponent + "components size = " + this.components.size());
    }

    public synchronized void initPushConfig(Context context2) {
        if (!this.hasConfigInit) {
            this.hasConfigInit = true;
            logger.infoEvent(TAG, "initPushConfig.");
            this.context = context2;
            for (IPushComponent initPushConfig : this.components) {
                initPushConfig.initPushConfig(this.context);
            }
        }
    }

    private void initPush() {
        logger.infoEvent(TAG, "initPush.");
        if (!this.hasInit) {
            this.hasInit = true;
            this.mDiPush.initPush(this.context);
        }
    }

    public void stopPush() {
        logger.infoEvent(TAG, "stopPush.");
        this.mDiPush.stopPush();
        for (IPushComponent stopPush : this.components) {
            stopPush.stopPush();
        }
    }

    public void startPush() {
        Logger logger2 = logger;
        logger2.infoEvent(TAG, "startPush. components size = " + this.components.size());
        initPush();
        this.mDiPush.startPush();
        for (IPushComponent startPush : this.components) {
            startPush.startPush();
        }
    }

    public boolean dispatcherPush(String str, DPushBody dPushBody, String str2) {
        Logger logger2 = logger;
        logger2.infoEvent(TAG, "dispatcherPush. pushKey = " + str + "content = " + dPushBody + ",topic = " + str2);
        for (IPushComponent dispatcherPush : this.components) {
            dispatcherPush.dispatcherPush(str, dPushBody, str2);
        }
        List<IPushComponent> list = this.components;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean dispatcherPush(String str, DPushBody dPushBody) {
        Logger logger2 = logger;
        logger2.infoEvent(TAG, "dispatcherPush. pushKey = " + str + "content = " + dPushBody);
        for (IPushComponent dispatcherPush : this.components) {
            dispatcherPush.dispatcherPush(str, dPushBody);
        }
        List<IPushComponent> list = this.components;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean unregisterPush(DPushListener dPushListener) {
        if (!(dPushListener == null || dPushListener.pushType() == null)) {
            String name = dPushListener.pushType().getName();
            Logger logger2 = logger;
            logger2.infoEvent(TAG, "registerPush. key = " + name + "listener = " + dPushListener);
            if (name.equals(DPushType.TENCENT_PUSH.getName())) {
                this.mDiPush.unregisterPush(dPushListener);
                return true;
            }
            IPushComponent iPushComponent = (IPushComponent) ComponentLoadUtil.getComponent(IPushComponent.class);
            if (iPushComponent != null) {
                return iPushComponent.unregisterPush(dPushListener);
            }
        }
        return false;
    }

    @Deprecated
    public boolean unregisterPush(DPushLisenter dPushLisenter) {
        return unregisterPush((DPushListener) dPushLisenter);
    }

    public void registerPush(DPushListener dPushListener) {
        if (dPushListener != null && dPushListener.pushType() != null) {
            DPushType pushType = dPushListener.pushType();
            Logger logger2 = logger;
            logger2.infoEvent(TAG, "registerPush. status = " + pushType + "listener = " + dPushListener);
            if (pushType.getName().equals(DPushType.TENCENT_PUSH.getName())) {
                this.mDiPush.registerPush(dPushListener);
                return;
            }
            IPushComponent iPushComponent = (IPushComponent) ComponentLoadUtil.getComponent(IPushComponent.class);
            if (iPushComponent != null) {
                iPushComponent.registerPush(dPushListener);
            }
        }
    }

    @Deprecated
    public void registerPush(DPushLisenter dPushLisenter) {
        registerPush((DPushListener) dPushLisenter);
    }

    public void registerReconnectionListener(PushConnectionListener pushConnectionListener) {
        Logger logger2 = logger;
        logger2.infoEvent(TAG, "registerReconnectionListener. listener = " + pushConnectionListener);
        this.mDiPush.registerReconnectionListener(pushConnectionListener);
    }

    public void sendPushMessage(int i, byte[] bArr) {
        this.mDiPush.sendRequest(bArr, i, true, 0, EMPTY);
    }
}
