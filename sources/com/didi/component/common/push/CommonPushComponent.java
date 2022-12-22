package com.didi.component.common.push;

import android.content.Context;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.push.handler.OrderHandler;
import com.didi.component.common.push.model.MessagePullItem;
import com.didi.component.common.push.model.MessagePullModel;
import com.didi.component.common.push.model.PushDispatchBody;
import com.didi.component.common.push.request.GlobalMessagePullRequest;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushType;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonPushComponent extends GlobalAbsPushComponent {

    /* renamed from: a */
    private static volatile CommonPushComponent f11683a;

    /* renamed from: b */
    private GlobalMessagePullRequest f11684b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11685c = false;

    /* renamed from: d */
    private DPushListener f11686d = new DPushListener() {
        final int msgType = PushMessageType.kPushMessageTypeCommonMsgReq.getValue();

        public DPushType pushType() {
            return DPushType.FCM_PUSH;
        }

        public void pushBody(DPushBody dPushBody) {
            try {
                JSONObject jSONObject = new JSONObject(new String(dPushBody.getData()));
                if (!jSONObject.has("ty")) {
                    return;
                }
                if (jSONObject.getInt("ty") == 11) {
                    if (!PushClient.getClient().isConnected() && GlobalApolloUtil.getOrderStatusFcmEnable()) {
                        new OrderHandler().handle(jSONObject);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String topic() {
            return this.msgType + "";
        }
    };

    public void initPush(Context context) {
    }

    private CommonPushComponent() {
    }

    public static CommonPushComponent getInstance() {
        if (f11683a == null) {
            synchronized (CommonPushComponent.class) {
                if (f11683a == null) {
                    f11683a = new CommonPushComponent();
                }
            }
        }
        return f11683a;
    }

    public void getMessagePull(Context context) {
        if (!this.f11685c) {
            if (this.f11684b == null) {
                this.f11684b = new GlobalMessagePullRequest();
            }
            this.f11684b.getMessageFromServerByPull(context, new RpcService.Callback<String>() {
                public void onFailure(IOException iOException) {
                }

                public void onSuccess(String str) {
                    try {
                        MessagePullModel messagePullModel = (MessagePullModel) new Gson().fromJson(str, MessagePullModel.class);
                        if (!(messagePullModel == null || messagePullModel.msgbody == null || messagePullModel.msgbody.isEmpty())) {
                            CommonPushComponent.this.m7905a(messagePullModel.msgbody);
                        }
                        boolean unused = CommonPushComponent.this.f11685c = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7905a(ArrayList<MessagePullItem> arrayList) {
        int i;
        MessagePullDispatcher messagePullDispatcher = new MessagePullDispatcher();
        ArrayList arrayList2 = new ArrayList();
        Iterator<MessagePullItem> it = arrayList.iterator();
        while (it.hasNext()) {
            MessagePullItem next = it.next();
            PushDispatchBody pushDispatchBody = new PushDispatchBody();
            pushDispatchBody.pid = next.pid;
            pushDispatchBody.originContent = next.content;
            try {
                JSONObject jSONObject = new JSONObject(next.content);
                if (!jSONObject.has("ty")) {
                    if (!jSONObject.has("lt")) {
                        break;
                    }
                    i = jSONObject.getInt("lt");
                } else {
                    i = jSONObject.getInt("ty");
                }
                pushDispatchBody.f11703ty = i;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList2.add(pushDispatchBody);
        }
        if (!arrayList2.isEmpty()) {
            messagePullDispatcher.setListAndDispatch(arrayList2);
        }
    }

    public void startPush() {
        super.startPush();
        registerPush(this.f11686d);
    }

    public void stopPush() {
        super.stopPush();
        DPushListener dPushListener = this.f11686d;
        if (dPushListener != null) {
            unregisterPush(dPushListener);
        }
    }

    public void dispatcherPush(String str, DPushBody dPushBody) {
        super.dispatcherPush(str, dPushBody);
    }
}
