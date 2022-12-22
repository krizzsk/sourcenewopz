package com.didi.soda.customer.compose.action;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionHelper;", "", "()V", "TAG", "", "doAction", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity;", "interceptListener", "Lcom/didi/soda/customer/compose/action/ActionInterceptListener;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionHelper.kt */
public final class ComposeActionHelper {
    public static final ComposeActionHelper INSTANCE = new ComposeActionHelper();
    public static final String TAG = "ComposeActionHelper";

    private ComposeActionHelper() {
    }

    public final void doAction(ScopeContext scopeContext, ComposeActionEntity composeActionEntity, ActionInterceptListener actionInterceptListener) {
        Unit unit;
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(composeActionEntity, "entity");
        List<String> actions = composeActionEntity.getActions();
        if (actions == null) {
            unit = null;
        } else {
            ComposeActionExecute composeActionExecute = new ComposeActionExecute();
            for (String next : actions) {
                LogUtil.m29104i(TAG, Intrinsics.stringPlus("action = ", next));
                composeActionExecute.execute(scopeContext, next, composeActionEntity, actionInterceptListener);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ComposeActionHelper composeActionHelper = this;
            LogUtil.m29104i(TAG, "onActionIntercept = false");
            if (actionInterceptListener != null) {
                actionInterceptListener.onActionIntercept(false);
            }
        }
    }
}
