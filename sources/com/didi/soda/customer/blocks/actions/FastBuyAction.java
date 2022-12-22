package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.home.manager.ActivityValidateCheckHelper;
import com.didi.soda.home.topgun.manager.HomeEfoJumpHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J:\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\bH\u0002¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/FastBuyAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "doFastBuy", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "fromType", "", "source", "businessRvModel", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "fromPage", "actInfo", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "fastBuy")
/* compiled from: FastBuyAction.kt */
public final class FastBuyAction extends BaseAction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f40551a = "FastBuyAction";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastBuyAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28791a(int i, Ref.ObjectRef objectRef, ScopeContext scopeContext, String str) {
        Intrinsics.checkNotNullParameter(objectRef, "$mActInfo");
        Intrinsics.checkNotNullParameter(scopeContext, "$scopeContext");
        if (i == 1 || i == 2) {
            ActivityValidateCheckHelper.checkActivityValidate((ActInfoEntity) objectRef.element, scopeContext);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r12 = r12.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.blocks.action.ActionResult doExcute(android.content.Context r11, com.didi.soda.blocks.scope.IBlockScope r12, java.util.HashMap<java.lang.String, java.lang.Object> r13, com.didi.soda.blocks.widget.Buildable r14) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r11 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r11)
            java.lang.String r11 = "widget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r11)
            r11 = 1
            r14 = 0
            if (r13 != 0) goto L_0x001c
            com.didi.soda.blocks.action.ActionResult$Companion r12 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r11 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r12, r14, r11, r14)
            return r11
        L_0x001c:
            java.lang.String r0 = "scope_context"
            java.lang.Object r12 = r12.getObject(r0)
            r1 = r12
            com.didi.app.nova.skeleton.ScopeContext r1 = (com.didi.app.nova.skeleton.ScopeContext) r1
            if (r1 != 0) goto L_0x002f
            com.didi.soda.blocks.action.ActionResult$Companion r12 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r11 = com.didi.soda.blocks.action.ActionResult.Companion.reject$default(r12, r14, r11, r14)
            return r11
        L_0x002f:
            java.lang.String r12 = "fromPage"
            java.lang.Object r12 = r1.getObject(r12)
            r5 = r12
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r12 = "fromType"
            java.lang.Object r12 = r13.get(r12)
            r0 = 0
            if (r12 != 0) goto L_0x0043
        L_0x0041:
            r2 = 0
            goto L_0x004f
        L_0x0043:
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L_0x004a
            goto L_0x0041
        L_0x004a:
            int r12 = java.lang.Integer.parseInt(r12)
            r2 = r12
        L_0x004f:
            java.lang.String r12 = "sceneType"
            java.lang.Object r12 = r13.get(r12)
            if (r12 != 0) goto L_0x005a
        L_0x0058:
            r12 = 0
            goto L_0x0065
        L_0x005a:
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L_0x0061
            goto L_0x0058
        L_0x0061:
            int r12 = java.lang.Integer.parseInt(r12)
        L_0x0065:
            java.lang.String r3 = "source"
            java.lang.Object r3 = r13.get(r3)
            if (r3 != 0) goto L_0x0070
        L_0x006e:
            r3 = 0
            goto L_0x007b
        L_0x0070:
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0077
            goto L_0x006e
        L_0x0077:
            int r3 = java.lang.Integer.parseInt(r3)
        L_0x007b:
            java.lang.String r4 = "actValidateType"
            java.lang.Object r4 = r13.get(r4)
            if (r4 != 0) goto L_0x0085
        L_0x0083:
            r4 = 0
            goto L_0x0090
        L_0x0085:
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L_0x008c
            goto L_0x0083
        L_0x008c:
            int r4 = java.lang.Integer.parseInt(r4)
        L_0x0090:
            java.lang.String r6 = "actInfo"
            java.lang.Object r6 = r13.get(r6)
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x009c
        L_0x009a:
            r6 = r7
            goto L_0x00a3
        L_0x009c:
            java.lang.String r6 = r6.toString()
            if (r6 != 0) goto L_0x00a3
            goto L_0x009a
        L_0x00a3:
            com.didi.soda.business.model.BusinessGoodsItemRvModel r7 = new com.didi.soda.business.model.BusinessGoodsItemRvModel
            r7.<init>()
            java.lang.String r8 = "shopId"
            java.lang.Object r8 = r13.get(r8)
            if (r8 != 0) goto L_0x00b3
            r8 = r14
            goto L_0x00b7
        L_0x00b3:
            java.lang.String r8 = r8.toString()
        L_0x00b7:
            r7.mBusinessId = r8
            java.lang.String r8 = "itemId"
            java.lang.Object r8 = r13.get(r8)
            if (r8 != 0) goto L_0x00c3
            r8 = r14
            goto L_0x00c7
        L_0x00c3:
            java.lang.String r8 = r8.toString()
        L_0x00c7:
            r7.mGoodsId = r8
            java.lang.String r8 = "cHasWine"
            java.lang.Object r8 = r13.get(r8)
            if (r8 != 0) goto L_0x00d3
        L_0x00d1:
            r8 = 0
            goto L_0x00de
        L_0x00d3:
            java.lang.String r8 = r8.toString()
            if (r8 != 0) goto L_0x00da
            goto L_0x00d1
        L_0x00da:
            int r8 = java.lang.Integer.parseInt(r8)
        L_0x00de:
            r7.mHasWine = r8
            java.lang.String r8 = "maxLevel"
            java.lang.Object r8 = r13.get(r8)
            if (r8 != 0) goto L_0x00ea
        L_0x00e8:
            r8 = 0
            goto L_0x00f5
        L_0x00ea:
            java.lang.String r8 = r8.toString()
            if (r8 != 0) goto L_0x00f1
            goto L_0x00e8
        L_0x00f1:
            int r8 = java.lang.Integer.parseInt(r8)
        L_0x00f5:
            r7.mMaxLevel = r8
            java.lang.String r8 = "itemNode"
            java.lang.Object r13 = r13.get(r8)
            if (r13 != 0) goto L_0x0100
            goto L_0x010e
        L_0x0100:
            java.lang.String r13 = r13.toString()
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity> r8 = com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity.class
            java.lang.Object r13 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r13, r8)
            com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity r13 = (com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity) r13
            r7.mNode = r13
        L_0x010e:
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity> r8 = com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity.class
            java.lang.Object r8 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r6, r8)     // Catch:{ Exception -> 0x011c }
            r13.element = r8     // Catch:{ Exception -> 0x011c }
            goto L_0x0123
        L_0x011c:
            java.lang.String r8 = "FastBuyAction"
            java.lang.String r9 = "actInfoStr parse error: $e|$actInfoStr"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29104i((java.lang.String) r8, (java.lang.String) r9)
        L_0x0123:
            boolean r8 = com.didi.soda.customer.foundation.util.LoginUtil.isLogin()
            if (r8 != 0) goto L_0x0139
            com.didi.soda.customer.foundation.util.LoginUtil.updateLoginPopToRootStatus(r0)
            android.content.Context r0 = com.didi.soda.customer.app.GlobalContext.getContext()
            com.didi.soda.customer.blocks.actions.-$$Lambda$FastBuyAction$z-p55wdy1dzt0nyW3CHYgv8_LP0 r2 = new com.didi.soda.customer.blocks.actions.-$$Lambda$FastBuyAction$z-p55wdy1dzt0nyW3CHYgv8_LP0
            r2.<init>(r4, r13, r1)
            com.didi.soda.customer.foundation.util.LoginUtil.loginActivityAndTrack(r0, r12, r2)
            goto L_0x0149
        L_0x0139:
            r12 = 2
            if (r4 != r12) goto L_0x0144
            T r12 = r13.element
            com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r12 = (com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity) r12
            com.didi.soda.home.manager.ActivityValidateCheckHelper.checkActivityValidate(r12, r1)
            goto L_0x0149
        L_0x0144:
            r0 = r10
            r4 = r7
            r0.m28792a(r1, r2, r3, r4, r5, r6)
        L_0x0149:
            com.didi.soda.blocks.action.ActionResult$Companion r12 = com.didi.soda.blocks.action.ActionResult.Companion
            com.didi.soda.blocks.action.ActionResult r11 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r12, r14, r11, r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.FastBuyAction.doExcute(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }

    /* renamed from: a */
    private final void m28792a(ScopeContext scopeContext, int i, int i2, BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo((ActInfoEntity) null);
        HomeEfoJumpHelper.handleEfoItemBuyClicked(scopeContext, i, i2, businessGoodsItemRvModel, str, str2);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/FastBuyAction$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastBuyAction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
