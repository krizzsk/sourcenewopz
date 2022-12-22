package com.didi.component.framework.pages.invitation.helper;

import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.model.InvitePageModel;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.component.framework.pages.invitation.model.RedirectModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/helper/InvitePageController$refreshInvitePage$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageController.kt */
public final class InvitePageController$refreshInvitePage$1 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ InvitePageController.CallbackPage $callback;
    final /* synthetic */ InvitePageController this$0;

    InvitePageController$refreshInvitePage$1(InvitePageController invitePageController, InvitePageController.CallbackPage callbackPage) {
        this.this$0 = invitePageController;
        this.$callback = callbackPage;
    }

    public void onSuccess(JsonObject jsonObject) {
        Integer errno;
        RedirectModel redirectModel;
        if (jsonObject != null) {
            InvitePageModel invitePageModel = (InvitePageModel) new Gson().fromJson((JsonElement) jsonObject, InvitePageModel.class);
            InvitePageController invitePageController = this.this$0;
            PageData data = invitePageModel.getData();
            String str = null;
            if (!(data == null || (redirectModel = data.getRedirectModel()) == null)) {
                str = redirectModel.getTheme();
            }
            InviteTheme access$parseThemes = invitePageController.m9642a(str);
            boolean z = false;
            if (!(invitePageModel == null || (errno = invitePageModel.getErrno()) == null || errno.intValue() != 0)) {
                z = true;
            }
            if (z) {
                this.$callback.onSuccess(invitePageModel.getData(), access$parseThemes);
            } else {
                this.$callback.onFailure(invitePageModel.getErrmsg());
            }
        }
    }

    public void onFailure(IOException iOException) {
        this.$callback.onError(iOException);
    }
}
