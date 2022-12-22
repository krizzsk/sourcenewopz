package com.wujie.dimina.bridge.plugin.international.login;

import android.app.Activity;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.raven.config.RavenKey;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/wujie/dimina/bridge/plugin/international/login/InternationalOneLoginSubJSBridge$mLoginStatusNotifyListener$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "s", "", "bridge-international-login_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: InternationalOneLoginSubJSBridge.kt */
public final class InternationalOneLoginSubJSBridge$mLoginStatusNotifyListener$1 implements LoginListeners.LoginListener {
    final /* synthetic */ InternationalOneLoginSubJSBridge this$0;

    public void onCancel() {
    }

    InternationalOneLoginSubJSBridge$mLoginStatusNotifyListener$1(InternationalOneLoginSubJSBridge internationalOneLoginSubJSBridge) {
        this.this$0 = internationalOneLoginSubJSBridge;
    }

    public void onSuccess(Activity activity, String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, RavenKey.STACK);
        if (this.this$0.mLoginDoingStatus.get() == 0) {
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "action", (Object) "login");
            this.this$0.mDMMina.getMessageTransfer().sendMessageToServiceFromNative("notifyLoginStatusChanged", new MessageWrapperBuilder().data(jSONObject).build());
        }
    }
}
