package com.didiglobal.p205sa.biz.tab.router;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.p205sa.biz.tab.manager.SATabManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/router/SaSwitchTabRouter;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.router.SaSwitchTabRouter */
/* compiled from: SaSwitchTabRouter.kt */
public final class SaSwitchTabRouter implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (SaApolloUtil.INSTANCE.getSaOneState()) {
            UiThreadHandler.getsUiHandler().post(new Runnable() {
                public final void run() {
                    SaSwitchTabRouter.m36704a(Request.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36704a(Request request) {
        Intrinsics.checkNotNullParameter(request, "$request");
        EventBus eventBus = EventBus.getDefault();
        String string = request.getString(ParamConst.PARAM_TAB_ID);
        if (string == null) {
            string = "";
        }
        eventBus.postSticky(new SATabManager.SaSwitchTabEvent(string));
    }
}
