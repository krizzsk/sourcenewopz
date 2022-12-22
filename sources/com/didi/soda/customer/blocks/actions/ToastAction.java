package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ToastAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "toast")
/* compiled from: ToastAction.kt */
public final class ToastAction extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r3 = r4.get("message");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.blocks.action.ActionResult doExcute(android.content.Context r2, com.didi.soda.blocks.scope.IBlockScope r3, java.util.HashMap<java.lang.String, java.lang.Object> r4, com.didi.soda.blocks.widget.Buildable r5) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "widget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            r2 = 0
            if (r4 != 0) goto L_0x0016
        L_0x0014:
            r3 = r2
            goto L_0x0023
        L_0x0016:
            java.lang.String r3 = "message"
            java.lang.Object r3 = r4.get(r3)
            if (r3 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            java.lang.String r3 = r3.toString()
        L_0x0023:
            r4 = 1
            if (r3 != 0) goto L_0x002d
            com.didi.soda.blocks.action.ActionResult$Companion r3 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r2 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r3, r2, r4, r2)
            return r2
        L_0x002d:
            com.didi.soda.customer.foundation.util.ToastUtil.showCustomerToast(r2, r3)
            com.didi.soda.blocks.action.ActionResult$Companion r3 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r2 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r3, r2, r4, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.ToastAction.doExcute(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }
}
