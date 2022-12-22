package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.TaskCenterEntity;
import com.didi.soda.home.topgun.binder.model.HomeTaskCenterRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.HomeTaskCenterView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001c\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0003\u0017\u0018\u0019B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u001c\u0010\u0011\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\f\u0010\u0016\u001a\u00060\u0002R\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$HomeTaskCenterBinderLogic;", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$ViewHolder;", "mScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setMScopeContext", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "HomeTaskCenterBinderLogic", "HomeTaskCenterBinderLogicImpl", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTaskCenterBinder.kt */
public final class HomeTaskCenterBinder extends CustomerLogicItemBinder<HomeTaskCenterBinderLogic, HomeTaskCenterRvModel, ViewHolder> {

    /* renamed from: a */
    private ScopeContext f42759a;

    public Class<HomeTaskCenterRvModel> bindDataType() {
        return HomeTaskCenterRvModel.class;
    }

    public final ScopeContext getMScopeContext() {
        return this.f42759a;
    }

    public final void setMScopeContext(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "<set-?>");
        this.f42759a = scopeContext;
    }

    public HomeTaskCenterBinder(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "mScopeContext");
        this.f42759a = scopeContext;
    }

    public HomeTaskCenterBinderLogic onCreateBinderLogic() {
        return new HomeTaskCenterBinderLogicImpl(this);
    }

    public void bind(ViewHolder viewHolder, HomeTaskCenterRvModel homeTaskCenterRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "item");
        BinderLogic binderLogic = getBinderLogic();
        Intrinsics.checkNotNullExpressionValue(binderLogic, "binderLogic");
        ((HomeTaskCenterView) viewHolder.itemView).bindData(homeTaskCenterRvModel, (HomeTaskCenterBinderLogic) binderLogic);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(this, new HomeTaskCenterView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "itemView", "Landroid/view/View;", "(Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;Landroid/view/View;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTaskCenterBinder.kt */
    public final class ViewHolder extends ItemViewHolder<HomeTaskCenterRvModel> {
        final /* synthetic */ HomeTaskCenterBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(HomeTaskCenterBinder homeTaskCenterBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(homeTaskCenterBinder, "this$0");
            this.this$0 = homeTaskCenterBinder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b¦\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$HomeTaskCenterBinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "(Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;)V", "onTaskCenterClick", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "onTaskCenterExposure", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTaskCenterBinder.kt */
    public abstract class HomeTaskCenterBinderLogic extends BinderLogic<EmptyLogicRepo> {
        final /* synthetic */ HomeTaskCenterBinder this$0;

        public abstract void onTaskCenterClick(HomeTaskCenterRvModel homeTaskCenterRvModel);

        public abstract void onTaskCenterExposure(HomeTaskCenterRvModel homeTaskCenterRvModel);

        public HomeTaskCenterBinderLogic(HomeTaskCenterBinder homeTaskCenterBinder) {
            Intrinsics.checkNotNullParameter(homeTaskCenterBinder, "this$0");
            this.this$0 = homeTaskCenterBinder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$HomeTaskCenterBinderLogicImpl;", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder$HomeTaskCenterBinderLogic;", "Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;", "(Lcom/didi/soda/home/topgun/binder/HomeTaskCenterBinder;)V", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "onTaskCenterClick", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "onTaskCenterExposure", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTaskCenterBinder.kt */
    public final class HomeTaskCenterBinderLogicImpl extends HomeTaskCenterBinderLogic {
        final /* synthetic */ HomeTaskCenterBinder this$0;

        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HomeTaskCenterBinderLogicImpl(HomeTaskCenterBinder homeTaskCenterBinder) {
            super(homeTaskCenterBinder);
            Intrinsics.checkNotNullParameter(homeTaskCenterBinder, "this$0");
            this.this$0 = homeTaskCenterBinder;
        }

        public void onTaskCenterClick(HomeTaskCenterRvModel homeTaskCenterRvModel) {
            Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "rvModel");
            SchemeHelper.dispatchMsg(homeTaskCenterRvModel.getTaskEntranceUrl());
            HomeOmegaHelper instance = HomeOmegaHelper.getInstance();
            String activityId = homeTaskCenterRvModel.getActivityId();
            List<TaskCenterEntity.TaskNodeEntity> taskNodeList = homeTaskCenterRvModel.getTaskNodeList();
            instance.trackTaskCenterCk(activityId, taskNodeList == null ? 0 : taskNodeList.size(), homeTaskCenterRvModel.getResourceId());
        }

        public void onTaskCenterExposure(HomeTaskCenterRvModel homeTaskCenterRvModel) {
            Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "rvModel");
            StringBuilder sb = new StringBuilder("");
            List<TaskCenterEntity.TaskNodeEntity> taskNodeList = homeTaskCenterRvModel.getTaskNodeList();
            Collection collection = taskNodeList;
            int i = 0;
            if (!(collection == null || collection.isEmpty())) {
                int size = taskNodeList.size();
                if (size > 0) {
                    while (true) {
                        int i2 = i + 1;
                        TaskCenterEntity.TaskNodeEntity taskNodeEntity = taskNodeList.get(i);
                        if (i == 0) {
                            sb.append(taskNodeEntity.getTaskStatus());
                        } else {
                            sb.append(",");
                            sb.append(taskNodeEntity.getTaskStatus());
                        }
                        if (i2 >= size) {
                            break;
                        }
                        i = i2;
                    }
                }
                i = size;
            }
            HomeOmegaHelper.getInstance().trackTaskCenterSw(homeTaskCenterRvModel.getActivityId(), i, sb.toString(), homeTaskCenterRvModel.getResourceId());
        }
    }
}
