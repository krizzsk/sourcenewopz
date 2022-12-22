package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.home.manager.LandingLogicModel;
import com.didi.soda.home.manager.LandinglogicRepo;
import com.didi.soda.home.topgun.binder.model.LandingHeaderRvModel;
import com.didi.soda.home.topgun.widget.LandingHeaderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001c\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0003\u001c\u001d\u001eB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\u001c\u0010\u0016\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\f\u0010\u001b\u001a\u00060\u0002R\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$LandingHeaderBinderLogic;", "Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$ViewHolder;", "mScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setMScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "LandingHeaderBinderLogic", "LandingHeaderBinderLogicImpl", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingHeaderBinder.kt */
public final class LandingHeaderBinder extends CustomerLogicItemBinder<LandingHeaderBinderLogic, LandingHeaderRvModel, ViewHolder> {

    /* renamed from: a */
    private ScopeContext f42762a;

    public Class<LandingHeaderRvModel> bindDataType() {
        return LandingHeaderRvModel.class;
    }

    public final ScopeContext getMScopeContext() {
        return this.f42762a;
    }

    public final void setMScopeContext(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "<set-?>");
        this.f42762a = scopeContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingHeaderBinder(ScopeContext scopeContext, ItemDecorator itemDecorator, ComponentLogicUnit componentLogicUnit) {
        super(itemDecorator, componentLogicUnit);
        Intrinsics.checkNotNullParameter(scopeContext, "mScopeContext");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        this.f42762a = scopeContext;
    }

    public LandingHeaderBinderLogic onCreateBinderLogic() {
        return new LandingHeaderBinderLogicImpl(this);
    }

    public void bind(ViewHolder viewHolder, LandingHeaderRvModel landingHeaderRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(landingHeaderRvModel, "item");
        ScopeContext scopeContext = this.f42762a;
        BinderLogic binderLogic = getBinderLogic();
        Intrinsics.checkNotNullExpressionValue(binderLogic, "binderLogic");
        ((LandingHeaderView) viewHolder.itemView).bindData(scopeContext, landingHeaderRvModel, new LandingHeaderBinder$bind$1(binderLogic));
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(this, new LandingHeaderView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "itemView", "Landroid/view/View;", "(Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder;Landroid/view/View;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LandingHeaderBinder.kt */
    public final class ViewHolder extends ItemViewHolder<LandingHeaderRvModel> {
        final /* synthetic */ LandingHeaderBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(LandingHeaderBinder landingHeaderBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(landingHeaderBinder, "this$0");
            this.this$0 = landingHeaderBinder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$LandingHeaderBinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/home/manager/LandinglogicRepo;", "(Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder;)V", "onTabClick", "", "tabInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LandingHeaderBinder.kt */
    public abstract class LandingHeaderBinderLogic extends BinderLogic<LandinglogicRepo> {
        final /* synthetic */ LandingHeaderBinder this$0;

        public abstract void onTabClick(TabInfoEntity tabInfoEntity);

        public LandingHeaderBinderLogic(LandingHeaderBinder landingHeaderBinder) {
            Intrinsics.checkNotNullParameter(landingHeaderBinder, "this$0");
            this.this$0 = landingHeaderBinder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$LandingHeaderBinderLogicImpl;", "Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder$LandingHeaderBinderLogic;", "Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder;", "(Lcom/didi/soda/home/topgun/binder/LandingHeaderBinder;)V", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/soda/home/manager/LandinglogicRepo;", "onTabClick", "", "tabInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LandingHeaderBinder.kt */
    public final class LandingHeaderBinderLogicImpl extends LandingHeaderBinderLogic {
        final /* synthetic */ LandingHeaderBinder this$0;

        public Class<LandinglogicRepo> bindLogicRepoType() {
            return LandinglogicRepo.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LandingHeaderBinderLogicImpl(LandingHeaderBinder landingHeaderBinder) {
            super(landingHeaderBinder);
            Intrinsics.checkNotNullParameter(landingHeaderBinder, "this$0");
            this.this$0 = landingHeaderBinder;
        }

        public void onTabClick(TabInfoEntity tabInfoEntity) {
            Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfo");
            LandingLogicModel landingLogicModel = new LandingLogicModel(LandinglogicRepo.LOGIC_TYPE_ON_TAB_CLICK);
            landingLogicModel.setTabInfo(tabInfoEntity);
            Unit unit = Unit.INSTANCE;
            ((LandinglogicRepo) getLogicRepo()).setValue(landingLogicModel);
        }
    }
}
