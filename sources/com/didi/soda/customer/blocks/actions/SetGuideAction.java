package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/SetGuideAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "setGuide")
/* compiled from: SetGuideAction.kt */
public final class SetGuideAction extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetGuideAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r7 = r8.get(com.didi.soda.customer.blocks.BlocksConst.ACTION_PARAMS_GUIDE_LEVEL);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.blocks.action.ActionResult doExcute(android.content.Context r6, com.didi.soda.blocks.scope.IBlockScope r7, java.util.HashMap<java.lang.String, java.lang.Object> r8, com.didi.soda.blocks.widget.Buildable r9) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r6 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "widget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            r6 = 0
            if (r8 != 0) goto L_0x0016
        L_0x0014:
            r7 = r6
            goto L_0x0023
        L_0x0016:
            java.lang.String r7 = "guide_level"
            java.lang.Object r7 = r8.get(r7)
            if (r7 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            java.lang.String r7 = r7.toString()
        L_0x0023:
            r9 = 1
            if (r7 != 0) goto L_0x002d
            com.didi.soda.blocks.action.ActionResult$Companion r7 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r6 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r7, r6, r9, r6)
            return r6
        L_0x002d:
            int r0 = r7.hashCode()
            r1 = 49
            java.lang.String r2 = "recId"
            java.lang.String r3 = "location"
            java.lang.String r4 = "body"
            if (r0 == r1) goto L_0x00b4
            r1 = 51
            if (r0 == r1) goto L_0x0069
            r1 = 52
            if (r0 == r1) goto L_0x0046
            goto L_0x0127
        L_0x0046:
            java.lang.String r0 = "4"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0050
            goto L_0x0127
        L_0x0050:
            if (r8 != 0) goto L_0x0054
            goto L_0x0127
        L_0x0054:
            java.lang.Object r7 = r8.get(r4)
            if (r7 != 0) goto L_0x005c
            goto L_0x0127
        L_0x005c:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0064
            goto L_0x0127
        L_0x0064:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv4Body(r7)
            goto L_0x0127
        L_0x0069:
            java.lang.String r0 = "3"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0073
            goto L_0x0127
        L_0x0073:
            if (r8 != 0) goto L_0x0076
            goto L_0x0087
        L_0x0076:
            java.lang.Object r7 = r8.get(r3)
            if (r7 != 0) goto L_0x007d
            goto L_0x0087
        L_0x007d:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv3Location(r7)
        L_0x0087:
            if (r8 != 0) goto L_0x008a
            goto L_0x009b
        L_0x008a:
            java.lang.Object r7 = r8.get(r2)
            if (r7 != 0) goto L_0x0091
            goto L_0x009b
        L_0x0091:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv3RecId(r7)
        L_0x009b:
            if (r8 != 0) goto L_0x009f
            goto L_0x0127
        L_0x009f:
            java.lang.Object r7 = r8.get(r4)
            if (r7 != 0) goto L_0x00a7
            goto L_0x0127
        L_0x00a7:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x00af
            goto L_0x0127
        L_0x00af:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv3Body(r7)
            goto L_0x0127
        L_0x00b4:
            java.lang.String r0 = "1"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x00be
            goto L_0x0127
        L_0x00be:
            if (r8 != 0) goto L_0x00c1
            goto L_0x00d2
        L_0x00c1:
            java.lang.Object r7 = r8.get(r3)
            if (r7 != 0) goto L_0x00c8
            goto L_0x00d2
        L_0x00c8:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x00cf
            goto L_0x00d2
        L_0x00cf:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv1Location(r7)
        L_0x00d2:
            if (r8 != 0) goto L_0x00d5
            goto L_0x00e6
        L_0x00d5:
            java.lang.Object r7 = r8.get(r2)
            if (r7 != 0) goto L_0x00dc
            goto L_0x00e6
        L_0x00dc:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x00e3
            goto L_0x00e6
        L_0x00e3:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv1RecId(r7)
        L_0x00e6:
            if (r8 != 0) goto L_0x00e9
            goto L_0x00fc
        L_0x00e9:
            java.lang.String r7 = "filter"
            java.lang.Object r7 = r8.get(r7)
            if (r7 != 0) goto L_0x00f2
            goto L_0x00fc
        L_0x00f2:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x00f9
            goto L_0x00fc
        L_0x00f9:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv1Filter(r7)
        L_0x00fc:
            if (r8 != 0) goto L_0x00ff
            goto L_0x0110
        L_0x00ff:
            java.lang.Object r7 = r8.get(r4)
            if (r7 != 0) goto L_0x0106
            goto L_0x0110
        L_0x0106:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x010d
            goto L_0x0110
        L_0x010d:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv1Body(r7)
        L_0x0110:
            if (r8 != 0) goto L_0x0113
            goto L_0x0127
        L_0x0113:
            java.lang.String r7 = "parameter"
            java.lang.Object r7 = r8.get(r7)
            if (r7 != 0) goto L_0x011d
            goto L_0x0127
        L_0x011d:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.setLv1Parameter(r7)
        L_0x0127:
            com.didi.soda.blocks.action.ActionResult$Companion r7 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r6 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r7, r6, r9, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.SetGuideAction.doExcute(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }
}
