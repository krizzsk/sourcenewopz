package com.didi.soda.customer.compose.action;

import android.net.Uri;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionExecute;", "", "()V", "doAction", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/ComposeActionEntity;", "interceptListener", "Lcom/didi/soda/customer/compose/action/ActionInterceptListener;", "doTrack", "execute", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComposeActionExecute.kt */
public final class ComposeActionExecute {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "name";
    public static final String PARAMS = "params";
    public static final String TAG = "ComposeActionExecute";
    public static final String TYPE = "type";

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComposeActionExecute.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ComposePathType.values().length];
            iArr[ComposePathType.ACTION.ordinal()] = 1;
            iArr[ComposePathType.TRACK.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void execute(ScopeContext scopeContext, String str, ComposeActionEntity composeActionEntity, ActionInterceptListener actionInterceptListener) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(str, "action");
        ComposePathType doUrlPathAnalyse = new ComposeActionAnalyse().doUrlPathAnalyse(str);
        int i = doUrlPathAnalyse == null ? -1 : WhenMappings.$EnumSwitchMapping$0[doUrlPathAnalyse.ordinal()];
        if (i == 1) {
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("do ACTION action = ", str));
            m29012a(scopeContext, str, composeActionEntity, actionInterceptListener);
        } else if (i != 2) {
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("SchemeHelper dispatchMsg action = ", str));
            SchemeHelper.dispatchMsg(str);
        } else {
            LogUtil.m29104i(TAG, Intrinsics.stringPlus("do TRACK action = ", str));
            m29013a(str);
        }
    }

    /* renamed from: a */
    private final void m29012a(ScopeContext scopeContext, String str, ComposeActionEntity composeActionEntity, ActionInterceptListener actionInterceptListener) {
        String queryParameter = Uri.parse(str).getQueryParameter("type");
        ComposeActionType[] values = ComposeActionType.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            ComposeActionType composeActionType = values[i];
            i++;
            if (Intrinsics.areEqual((Object) composeActionType.getType(), (Object) queryParameter)) {
                boolean doAction = composeActionType.doAction(scopeContext, composeActionEntity);
                LogUtil.m29104i(TAG, "action type = " + queryParameter + " match action ,intercept = " + doAction);
                if (actionInterceptListener != null) {
                    actionInterceptListener.onActionIntercept(doAction);
                    return;
                }
                return;
            }
        }
        LogUtil.m29104i(TAG, Intrinsics.stringPlus("no action type match ActionIntercept false ,type = ", queryParameter));
        if (actionInterceptListener != null) {
            actionInterceptListener.onActionIntercept(false);
        }
    }

    /* renamed from: a */
    private final void m29013a(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("name");
        String queryParameter2 = parse.getQueryParameter("params");
        if (queryParameter != null && queryParameter2 != null) {
            List<String> split$default = StringsKt.split$default((CharSequence) queryParameter2, new String[]{ParamKeys.SIGN_AND}, false, 0, 6, (Object) null);
            HashMap hashMap = new HashMap();
            for (String split$default2 : split$default) {
                List split$default3 = StringsKt.split$default((CharSequence) split$default2, new String[]{"="}, false, 0, 6, (Object) null);
                if (split$default3.size() > 1) {
                    String str2 = (String) split$default3.get(0);
                    String str3 = (String) split$default3.get(1);
                    hashMap.put(str2, str3);
                    LogUtil.m29104i(TAG, "doTrack eventName = " + queryParameter + ", map key = " + str2 + ", map value = " + str3);
                }
            }
            OmegaTracker.Builder.create(queryParameter).addAllEventParam(hashMap).build().track();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/compose/action/ComposeActionExecute$Companion;", "", "()V", "NAME", "", "PARAMS", "TAG", "TYPE", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComposeActionExecute.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
