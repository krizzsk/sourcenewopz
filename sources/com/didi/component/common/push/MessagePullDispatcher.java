package com.didi.component.common.push;

import android.text.TextUtils;
import com.didi.component.common.push.handler.IMHandler;
import com.didi.component.common.push.handler.OrderHandler;
import com.didi.component.common.push.handler.Pay4WaitingHandler;
import com.didi.component.common.push.handler.PushHandler;
import com.didi.component.common.push.model.PushDispatchBody;
import com.didi.component.common.push.request.GlobalMessageUpdateRequest;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class MessagePullDispatcher {

    /* renamed from: a */
    private ArrayList<PushDispatchBody> f11701a;

    /* renamed from: b */
    private GlobalMessageUpdateRequest f11702b;

    public void setListAndDispatch(ArrayList<PushDispatchBody> arrayList) {
        this.f11701a = arrayList;
        m7928a();
        m7929b();
    }

    /* renamed from: a */
    private void m7928a() {
        ArrayList<PushDispatchBody> arrayList = this.f11701a;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (this.f11702b == null) {
                this.f11702b = new GlobalMessageUpdateRequest();
            }
            Iterator<PushDispatchBody> it = this.f11701a.iterator();
            while (it.hasNext()) {
                PushDispatchBody next = it.next();
                if (!TextUtils.isEmpty(next.pid)) {
                    OmegaSDKAdapter.trackEvent("gp_msggate_pullmessage_upload");
                    this.f11702b.uploadPushId(next.pid, (RpcService.Callback<String>) null);
                }
            }
        }
    }

    /* renamed from: b */
    private void m7929b() {
        JSONObject jSONObject;
        ArrayList<PushDispatchBody> arrayList = this.f11701a;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<PushDispatchBody> arrayList2 = this.f11701a;
            PushDispatchBody pushDispatchBody = arrayList2.get(arrayList2.size() - 1);
            PushHandler pushHandler = null;
            try {
                jSONObject = new JSONObject(pushDispatchBody.originContent);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                int i = pushDispatchBody.f11703ty;
                if (i == 10) {
                    pushHandler = new Pay4WaitingHandler();
                } else if (i == 11) {
                    pushHandler = new OrderHandler();
                } else if (i == 259) {
                    pushHandler = new IMHandler();
                }
                if (pushHandler != null) {
                    pushHandler.handle(jSONObject);
                }
            }
        }
    }
}
