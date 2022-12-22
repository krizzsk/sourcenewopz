package com.didi.app.router.sidebar;

import android.app.Activity;
import android.content.Intent;
import com.didi.app.router.PageRouter;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/app/router/sidebar/DeleteCountDRouterHandler$callRealHandle$1", "Lcom/didi/unifylogin/listener/LoginListeners$CancelAccFinishListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeleteCountDRouterHandler.kt */
public final class DeleteCountDRouterHandler$callRealHandle$1 implements LoginListeners.CancelAccFinishListener {
    final /* synthetic */ BaseBusinessContext $businessContext;

    public void onCancel() {
    }

    DeleteCountDRouterHandler$callRealHandle$1(BaseBusinessContext baseBusinessContext) {
        this.$businessContext = baseBusinessContext;
    }

    public void onSuccess(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.$businessContext.getNavigation().popBackStack(2);
        Intent intent = new Intent();
        intent.putExtra("logout_key_cancellation_account", true);
        PageRouter.getInstance().startMainActivity(activity, intent);
    }
}
