package com.didi.soda.home.efo.detail;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.compose.action.ComposeActionHelper;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.flutter.plugin.listener.SimpleCallPluginListener;
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.efo.model.DiscountDetailItemCardModel;
import com.didi.soda.home.topgun.manager.HomeEfoJumpHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002J\u001e\u0010\f\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002J0\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010\u0011\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010\u0012\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/efo/detail/DiscountDetailPluginListener;", "Lcom/didi/soda/customer/flutter/plugin/listener/SimpleCallPluginListener;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "pageId", "", "(Lcom/didi/app/nova/skeleton/ScopeContext;Ljava/lang/String;)V", "onBuyItem", "", "params", "", "", "onEFOAbnormal", "onMethodCall", "method", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "onRejectStrategy", "onSelectSKU", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiscountDetailPluginListener.kt */
public final class DiscountDetailPluginListener extends SimpleCallPluginListener {

    /* renamed from: a */
    private ScopeContext f42637a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscountDetailPluginListener(ScopeContext scopeContext, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "pageId");
        this.f42637a = scopeContext;
    }

    public void onMethodCall(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(map, "params");
        switch (str.hashCode()) {
            case -1263206797:
                if (str.equals(BlocksConst.SCOPE_ACTION_GOOD_ITEM_CLICK)) {
                    m30113b(map);
                    return;
                }
                return;
            case 244693689:
                if (str.equals("buyItem")) {
                    m30111a(map);
                    return;
                }
                return;
            case 1882149363:
                if (str.equals("discountDetailPageStatus")) {
                    m30114c(map);
                    return;
                }
                return;
            case 2142774740:
                if (str.equals("queryStayStrategy")) {
                    m30112a(map, onPluginResultListener);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m30111a(Map<String, ? extends Object> map) {
        String str = (String) get("fromPage", map);
        DiscountDetailItemCardModel discountDetailItemCardModel = (DiscountDetailItemCardModel) GsonUtils.fromJson((String) get("itemData", map), DiscountDetailItemCardModel.class);
        BusinessGoodsItemRvModel businessGoodsItemRvModel = new BusinessGoodsItemRvModel();
        if (discountDetailItemCardModel != null) {
            businessGoodsItemRvModel.mBusinessId = discountDetailItemCardModel.getShopId();
            businessGoodsItemRvModel.mGoodsId = discountDetailItemCardModel.getItemId();
            businessGoodsItemRvModel.mHasWine = discountDetailItemCardModel.getHasWine();
            businessGoodsItemRvModel.mMaxLevel = discountDetailItemCardModel.getMaxLevel();
            businessGoodsItemRvModel.mNode = discountDetailItemCardModel.getNode();
        }
        ScopeContext scopeContext = this.f42637a;
        if (scopeContext != null) {
            HomeEfoJumpHelper.handleEfoItemBuyClicked(scopeContext, 8, businessGoodsItemRvModel, str, (LoginListener) null);
        }
    }

    /* renamed from: b */
    private final void m30113b(Map<String, ? extends Object> map) {
        ScopeContext scopeContext;
        String str = (String) get("shopId", map);
        String str2 = (String) get(BlocksConst.ACTION_PARAMS_ITEM_ID, map);
        if (str != null && str2 != null && (scopeContext = this.f42637a) != null) {
            HomeEfoJumpHelper.handleEfoItemClicked(scopeContext, 8, str, str2, (LoginListener) null);
        }
    }

    /* renamed from: a */
    private final void m30112a(Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        ComposeActionEntity composeActionEntity = (ComposeActionEntity) GsonUtil.fromJson((String) get("stayStruct", map), ComposeActionEntity.class);
        ScopeContext scopeContext = this.f42637a;
        if (scopeContext != null) {
            ComposeActionHelper composeActionHelper = ComposeActionHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(composeActionEntity, "entity");
            composeActionHelper.doAction(scopeContext, composeActionEntity, new DiscountDetailPluginListener$onRejectStrategy$1$1(onPluginResultListener, scopeContext));
        }
    }

    /* renamed from: c */
    private final void m30114c(Map<String, ? extends Object> map) {
        Integer num = (Integer) get("activityStatus", map);
        if (num == null || num.intValue() != 0) {
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
        }
    }
}
