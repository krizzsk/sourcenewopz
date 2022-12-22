package com.wujie.dimina.bridge.plugin.international.login;

import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "onSuccess"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: InternationalOneLoginSubJSBridge.kt */
final class InternationalOneLoginSubJSBridge$mLogoutStatusNotifyListener$1 implements LoginListeners.LoginOutListener {
    final /* synthetic */ InternationalOneLoginSubJSBridge this$0;

    InternationalOneLoginSubJSBridge$mLogoutStatusNotifyListener$1(InternationalOneLoginSubJSBridge internationalOneLoginSubJSBridge) {
        this.this$0 = internationalOneLoginSubJSBridge;
    }

    public final void onSuccess() {
        if (this.this$0.mLogoutDoingStatus.get() == 0) {
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "action", (Object) InternalJSMethod.LOGOUT);
            this.this$0.mDMMina.getMessageTransfer().sendMessageToServiceFromNative("notifyLoginStatusChanged", new MessageWrapperBuilder().data(jSONObject).build());
        }
    }
}
