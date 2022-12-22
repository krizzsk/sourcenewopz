package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/TrackAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "checkAttrType", "", "value", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "trace")
/* compiled from: TrackAction.kt */
public final class TrackAction extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrackAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r13 = r12.get("key");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.blocks.action.ActionResult doExcute(android.content.Context r10, com.didi.soda.blocks.scope.IBlockScope r11, java.util.HashMap<java.lang.String, java.lang.Object> r12, com.didi.soda.blocks.widget.Buildable r13) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r10 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r10)
            java.lang.String r10 = "widget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r10)
            r10 = 0
            if (r12 != 0) goto L_0x0016
        L_0x0014:
            r13 = r10
            goto L_0x0023
        L_0x0016:
            java.lang.String r13 = "key"
            java.lang.Object r13 = r12.get(r13)
            if (r13 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            java.lang.String r13 = r13.toString()
        L_0x0023:
            r0 = 1
            if (r13 != 0) goto L_0x002d
            com.didi.soda.blocks.action.ActionResult$Companion r11 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r10 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r11, r10, r0, r10)
            return r10
        L_0x002d:
            java.lang.String r1 = "scope_context"
            java.lang.Object r11 = r11.getObject(r1)
            boolean r1 = r11 instanceof com.didi.app.nova.skeleton.ScopeContext
            if (r1 == 0) goto L_0x003b
            com.didi.app.nova.skeleton.ScopeContext r11 = (com.didi.app.nova.skeleton.ScopeContext) r11
            goto L_0x003c
        L_0x003b:
            r11 = r10
        L_0x003c:
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x004c
            com.didi.soda.blocks.action.ActionResult$Companion r11 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r10 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r11, r10, r0, r10)
            return r10
        L_0x004c:
            if (r11 != 0) goto L_0x0053
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r13)
            goto L_0x0057
        L_0x0053:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r13, r11)
        L_0x0057:
            if (r12 != 0) goto L_0x005b
            r13 = r10
            goto L_0x0061
        L_0x005b:
            java.lang.String r13 = "attr"
            java.lang.Object r13 = r12.get(r13)
        L_0x0061:
            boolean r1 = r13 instanceof java.util.HashMap
            if (r1 == 0) goto L_0x0068
            java.util.HashMap r13 = (java.util.HashMap) r13
            goto L_0x0069
        L_0x0068:
            r13 = r10
        L_0x0069:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            if (r13 == 0) goto L_0x00f2
            int r2 = r13.size()
            if (r2 <= 0) goto L_0x00f2
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0080:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x00ef
            java.lang.Object r2 = r13.next()
            java.lang.String r3 = "iterator.next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            boolean r4 = r3 instanceof java.lang.String
            r5 = 2
            r6 = 0
            if (r4 == 0) goto L_0x00b0
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "${"
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r7, r8, r6, r5, r10)
            if (r8 == 0) goto L_0x00b0
            java.lang.String r8 = "}"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r7, r8, r6, r5, r10)
            if (r7 == 0) goto L_0x00b0
            goto L_0x0080
        L_0x00b0:
            if (r4 == 0) goto L_0x00c8
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r7 = "{{$invoke."
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r4, r7, r6, r5, r10)
            if (r7 == 0) goto L_0x00c8
            java.lang.String r7 = "}}"
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r4, r7, r6, r5, r10)
            if (r4 == 0) goto L_0x00c8
            goto L_0x0080
        L_0x00c8:
            java.lang.String r4 = "nextValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r9.m28799a(r3)
            java.lang.String r5 = "next.key"
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r2 = r2.getKey()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r1.put(r2, r3)
            goto L_0x0080
        L_0x00e0:
            java.lang.Object r2 = r2.getKey()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.String r3 = r3.toString()
            r1.put(r2, r3)
            goto L_0x0080
        L_0x00ef:
            r11.addAllEventParam(r1)
        L_0x00f2:
            if (r12 != 0) goto L_0x00f6
        L_0x00f4:
            r12 = r10
            goto L_0x0103
        L_0x00f6:
            java.lang.String r13 = "enable_guide"
            java.lang.Object r12 = r12.get(r13)
            if (r12 != 0) goto L_0x00ff
            goto L_0x00f4
        L_0x00ff:
            java.lang.String r12 = r12.toString()
        L_0x0103:
            java.lang.String r13 = "1"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x010e
            r11.enableGuideParam()
        L_0x010e:
            com.didi.soda.customer.foundation.tracker.OmegaTracker r11 = r11.build()
            r11.track()
            com.didi.soda.blocks.action.ActionResult$Companion r11 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r10 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r11, r10, r0, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.TrackAction.doExcute(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }

    /* renamed from: a */
    private final boolean m28799a(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean);
    }
}
