package com.didi.app.router.sidebar;

import android.content.Context;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/app/router/sidebar/ModifyEmailDRouterHandler;", "Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "()V", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ModifyEmailDRouterHandler.kt */
public final class ModifyEmailDRouterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        OmegaSDKAdapter.trackEvent("pas_profile_emailedit_ck");
        Context context = request.getContext();
        if (context != null) {
            OneLoginFacade.getAction().go2ModifyEmail(context, (LoginListeners.ModifyEmailListener) null);
        }
    }
}
