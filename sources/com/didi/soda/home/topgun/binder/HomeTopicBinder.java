package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.style.DynamicContainerBinder;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.actions.CheckStatuOpenPageAction;
import com.didi.soda.customer.blocks.actions.FastBuyAction;
import com.didi.soda.customer.coordshop.CoordShopManager;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeTopicRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.HomeTopicView;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTopicBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$ViewHolder;", "mScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setMScopeContext", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTopicBinder.kt */
public final class HomeTopicBinder extends CustomerLogicItemBinder<Companion.Logic, HomeTopicRvModel, Companion.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ScopeContext f42761a;

    public Class<HomeTopicRvModel> bindDataType() {
        return HomeTopicRvModel.class;
    }

    public final ScopeContext getMScopeContext() {
        return this.f42761a;
    }

    public final void setMScopeContext(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "<set-?>");
        this.f42761a = scopeContext;
    }

    public HomeTopicBinder(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "mScopeContext");
        this.f42761a = scopeContext;
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion;", "", "()V", "Logic", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTopicBinder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: HomeTopicBinder.kt */
        public static final class ViewHolder extends ItemViewHolder<HomeTopicRvModel> {
            public ViewHolder(View view) {
                super(view);
            }
        }

        private Companion() {
        }

        @Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J:\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016J\u0006\u0010\u0017\u001a\u00020\rJ:\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "()V", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "getModel", "()Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "setModel", "(Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;)V", "bindLogicRepoType", "Ljava/lang/Class;", "fastBuy", "", "context", "Landroid/content/Context;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onTimerFinished", "openPage", "showItemGood", "good", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "showItemShop", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "toMorePage", "isTitleCK", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: HomeTopicBinder.kt */
        public static final class Logic extends BinderLogic<EmptyLogicRepo> {
            private HomeTopicRvModel model;

            public Class<EmptyLogicRepo> bindLogicRepoType() {
                return EmptyLogicRepo.class;
            }

            public final HomeTopicRvModel getModel() {
                return this.model;
            }

            public final void setModel(HomeTopicRvModel homeTopicRvModel) {
                this.model = homeTopicRvModel;
            }

            public final void onTimerFinished() {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
            }

            public final void toMorePage(HomeTopicRvModel homeTopicRvModel) {
                ActInfoEntity actInfoEntity;
                Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                Request.Builder putString = DiRouter.request().path(RoutePath.BLOCKS_LANDING_PAGE).putString(Const.PageParams.COMPONENT_ID, homeTopicRvModel.mComponentId).putString("recid", homeTopicRvModel.mRecId);
                HomeTopicEntity data = homeTopicRvModel.getData();
                ActInfoEntity actInfoEntity2 = null;
                Request.Builder putString2 = putString.putString("scene", String.valueOf(ExtentionsKt.orZero(data == null ? null : Integer.valueOf(data.scene))));
                HomeTopicEntity data2 = homeTopicRvModel.getData();
                Request.Builder putString3 = putString2.putString(Const.PageParams.TOPIC_TITLE, data2 == null ? null : data2.mTopicTitle).putString("homepage_source", "1");
                HomeTopicEntity data3 = homeTopicRvModel.getData();
                if (((data3 == null || (actInfoEntity = data3.actInfo) == null) ? null : actInfoEntity.getActId()) != null) {
                    HomeTopicEntity data4 = homeTopicRvModel.getData();
                    if (data4 != null) {
                        actInfoEntity2 = data4.actInfo;
                    }
                    putString3.putString(Const.PageParams.ACT_INFO, GsonUtil.toJson(actInfoEntity2));
                }
                putString3.open();
            }

            public final void toMorePage(HomeTopicRvModel homeTopicRvModel, boolean z) {
                Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                toMorePage(homeTopicRvModel);
                HomeOmegaHelper.getInstance().traceTopicMoreCK(homeTopicRvModel, z);
            }

            public final void fastBuy(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(iBlockScope, "scope");
                Intrinsics.checkNotNullParameter(hashMap, "map");
                new FastBuyAction((WidgetNodeModel) null, context, (HashMap<String, Object>) null).doExcute(context, iBlockScope, hashMap, new DynamicContainerBinder(context));
            }

            public final void openPage(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(iBlockScope, "scope");
                Intrinsics.checkNotNullParameter(hashMap, "map");
                new CheckStatuOpenPageAction((WidgetNodeModel) null, context, (HashMap<String, Object>) null).doExcute(context, iBlockScope, hashMap, new DynamicContainerBinder(context));
            }

            public final void showItemShop(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
                Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "shop");
                CoordShopManager.Companion.get().triggerTopicSw(homeBusinessInfoRvModel);
                HomeOmegaHelper.getInstance().traceTopicShopItemSW(this.model, homeBusinessInfoRvModel);
            }

            public final void showItemGood(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "good");
                HomeOmegaHelper.getInstance().traceTopicGoodsItemSW(this.model, businessGoodsItemRvModel);
            }
        }
    }

    public Companion.ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new Companion.ViewHolder(new HomeTopicView(context));
    }

    public void bind(Companion.ViewHolder viewHolder, HomeTopicRvModel homeTopicRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "item");
        HomeTopicView homeTopicView = (HomeTopicView) viewHolder.itemView;
        homeTopicView.setLogic((Companion.Logic) getBinderLogic());
        Companion.Logic logic = homeTopicView.getLogic();
        if (logic != null) {
            logic.setModel(homeTopicRvModel);
        }
        homeTopicView.bindData(this.f42761a, homeTopicRvModel);
        HomeOmegaHelper.getInstance().traceTopicSW(homeTopicRvModel);
    }

    public Companion.Logic onCreateBinderLogic() {
        return new Companion.Logic();
    }
}
