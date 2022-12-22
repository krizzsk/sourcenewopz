package com.didi.component.framework.pages.invitation.helper;

import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/helper/InvitePageController$refreshInviteList$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageController.kt */
public final class InvitePageController$refreshInviteList$1 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ InvitePageController.CallbackList $callback;

    InvitePageController$refreshInviteList$1(InvitePageController.CallbackList callbackList) {
        this.$callback = callbackList;
    }

    public void onSuccess(JsonObject jsonObject) {
        Integer errno;
        if (jsonObject != null) {
            InviteListModel inviteListModel = (InviteListModel) new Gson().fromJson((JsonElement) jsonObject, InviteListModel.class);
            boolean z = false;
            if (!(inviteListModel == null || (errno = inviteListModel.getErrno()) == null || errno.intValue() != 0)) {
                z = true;
            }
            if (z) {
                this.$callback.onSuccess(inviteListModel);
            } else {
                this.$callback.onFailure(inviteListModel.getErrmsg());
            }
        }
    }

    public void onFailure(IOException iOException) {
        this.$callback.onError(iOException);
    }
}
