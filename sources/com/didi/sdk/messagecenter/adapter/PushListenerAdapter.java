package com.didi.sdk.messagecenter.adapter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.messagecenter.deserializer.DeserializerFactory;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.model.UnifyMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushLisenter;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class PushListenerAdapter {

    /* renamed from: a */
    private DPushLisenter f36759a;

    /* renamed from: b */
    private Handler f36760b = new Handler(Looper.getMainLooper());
    public Subscription subscription;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26029b(DPushBody dPushBody, Subscription subscription2) {
        try {
            m26028a(dPushBody, subscription2);
        } catch (IncompatibleClassChangeError e) {
            Log.d("PushListenerAdapter", "dispatch error", e);
        }
    }

    public PushListenerAdapter(Subscription subscription2) {
        this.f36759a = m26024a(subscription2);
        this.subscription = subscription2;
        MLog.m26060i("register push listener: " + this.f36759a);
        DPushManager.getInstance().registerPush(this.f36759a);
    }

    public void release() {
        MLog.m26060i("unregister push listener: " + this.f36759a);
        DPushManager.getInstance().unregisterPush(this.f36759a);
    }

    /* renamed from: a */
    private DPushLisenter m26024a(Subscription subscription2) {
        return new DPushListenerAdapter(subscription2);
    }

    /* renamed from: a */
    private void m26028a(DPushBody dPushBody, final Subscription subscription2) {
        if (dPushBody == null || dPushBody.getData() == null || subscription2 == null) {
            MLog.m26061w("dispatch: pushBody or subscription is null");
            return;
        }
        MLog.m26060i("dispatch: " + subscription2.type + "|" + subscription2.subscriberTopic);
        final PushMessage deserialize = DeserializerFactory.getDeserializer(subscription2.subscriberMessageClz, subscription2.type).deserialize(dPushBody.getData(), subscription2.subscriberMessageClz);
        if (deserialize == null) {
            MLog.m26061w("dispatch: message is null");
        } else if (!(deserialize instanceof UnifyMessage) || ((UnifyMessage) deserialize).f36775id == subscription2.subscriberUnifyId) {
            this.f36760b.post(new Runnable() {
                public void run() {
                    MLog.m26058d("dispatch: will handle message");
                    try {
                        subscription2.messageHandler.handle(deserialize);
                    } catch (Exception e) {
                        MLog.m26059e("dispatch: catch error [" + e.getMessage() + Const.jaRight);
                        e.printStackTrace();
                    }
                }
            });
        } else {
            MLog.m26060i("dispatch: unify id match failed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public DPushType m26026a(String str) {
        if (TextUtils.equals(str, DPushType.GEITUI_PUSH.getName())) {
            return DPushType.GEITUI_PUSH;
        }
        if (TextUtils.equals(str, DPushType.GEITUI_PUSH_MIS_CLICK.getName())) {
            return DPushType.GEITUI_PUSH_MIS_CLICK;
        }
        if (TextUtils.equals(str, DPushType.XIAOMI_PUSH.getName())) {
            return DPushType.XIAOMI_PUSH;
        }
        if (TextUtils.equals(str, DPushType.FCM_PUSH.getName())) {
            return DPushType.FCM_PUSH;
        }
        if (TextUtils.equals(str, DPushType.TENCENT_PUSH.getName())) {
            return DPushType.TENCENT_PUSH;
        }
        return DPushType.TENCENT_PUSH;
    }

    private class DPushListenerAdapter implements DPushLisenter {
        private Subscription subscription;

        public DPushListenerAdapter(Subscription subscription2) {
            this.subscription = subscription2;
        }

        public DPushType pushType() {
            return PushListenerAdapter.this.m26026a(this.subscription.type);
        }

        public void pushBody(DPushBody dPushBody) {
            PushListenerAdapter.this.m26029b(dPushBody, this.subscription);
        }

        public String topic() {
            return this.subscription.subscriberTopic;
        }
    }
}
