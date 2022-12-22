package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.BindViewHolderCallBack;
import com.didi.soda.home.topgun.widget.HomeFilterLayout;
import com.didi.soda.home.topgun.widget.floatlayout.IStickHolder;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u001c\u0010\u001c\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/FilterBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeHeaderBinderLogic;", "Lcom/didi/soda/home/topgun/binder/model/FilterRvModel;", "Lcom/didi/soda/home/topgun/binder/FilterBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "onBindListener", "Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "getOnBindListener", "()Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "setOnBindListener", "(Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterBinder.kt */
public class FilterBinder extends CustomerLogicItemBinder<HomeHeaderBinderLogic, FilterRvModel, ViewHolder> {
    private int bgColor = ResourceHelper.getColor(R.color.rf_color_v2_grey2_10_a100);
    private BindViewHolderCallBack onBindListener;
    /* access modifiers changed from: private */
    public ScopeContext scopeContext;

    public Class<FilterRvModel> bindDataType() {
        return FilterRvModel.class;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterBinder(ScopeContext scopeContext2, ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        this.scopeContext = scopeContext2;
    }

    public final BindViewHolderCallBack getOnBindListener() {
        return this.onBindListener;
    }

    public final void setOnBindListener(BindViewHolderCallBack bindViewHolderCallBack) {
        this.onBindListener = bindViewHolderCallBack;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_home_header_filter, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(this, inflate);
    }

    public void bind(ViewHolder viewHolder, FilterRvModel filterRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(filterRvModel, "item");
        viewHolder.setData(filterRvModel);
    }

    public HomeHeaderBinderLogic onCreateBinderLogic() {
        return new HomeHeaderBinderLogic();
    }

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/FilterBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/FilterRvModel;", "Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "rootView", "Landroid/view/View;", "(Lcom/didi/soda/home/topgun/binder/FilterBinder;Landroid/view/View;)V", "bindPosition", "", "filterLayout", "Lcom/didi/soda/home/topgun/widget/HomeFilterLayout;", "getStickParent", "Landroid/view/ViewGroup;", "getStickView", "isFloating", "", "openStick", "recordScrollPosition", "", "restoreScrollPosition", "setData", "item", "updateWhenFloating", "positionStart", "itemCount", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterBinder.kt */
    public final class ViewHolder extends ItemViewHolder<FilterRvModel> implements IStickHolder {
        private int bindPosition = -1;
        private final HomeFilterLayout filterLayout;
        final /* synthetic */ FilterBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(FilterBinder filterBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(filterBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = filterBinder;
            View findViewById = view.findViewById(R.id.customer_fl_home_feed_filter_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…_home_feed_filter_layout)");
            this.filterLayout = (HomeFilterLayout) findViewById;
            recordScrollPosition();
        }

        public final void setData(FilterRvModel filterRvModel) {
            Intrinsics.checkNotNullParameter(filterRvModel, "item");
            this.bindPosition = getAdapterPosition();
            FilterDataManager filterManager = filterRvModel.getFilterManager();
            if (filterManager != null) {
                this.itemView.setVisibility(0);
                this.filterLayout.setOnBindListener(new FilterBinder$ViewHolder$setData$1(this.this$0));
                this.filterLayout.setFilterClickListener(new FilterBinder$ViewHolder$setData$2(this.this$0, this));
                List<FilterModel> filterModelListWithoutMain = filterManager.getFilterModelListWithoutMain(filterRvModel.getHasAnim());
                this.filterLayout.bindData(filterManager.getMainFilterModel(), filterModelListWithoutMain, filterManager.getScene());
            } else {
                this.itemView.setVisibility(8);
            }
            this.filterLayout.setBackgroundColor(this.this$0.getBgColor());
            restoreScrollPosition();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void restoreScrollPosition() {
            /*
                r6 = this;
                com.didi.soda.home.topgun.widget.HomeFilterLayout r0 = r6.filterLayout
                androidx.recyclerview.widget.RecyclerView r0 = r0.getRecycleView()
                androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
                boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
                r2 = 0
                if (r1 == 0) goto L_0x0012
                androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
                goto L_0x0013
            L_0x0012:
                r0 = r2
            L_0x0013:
                com.didi.soda.home.topgun.binder.FilterBinder r1 = r6.this$0
                com.didi.app.nova.skeleton.ScopeContext r1 = r1.scopeContext
                java.lang.String r3 = "key_filter_binder_pos"
                java.lang.Object r1 = r1.getObject(r3)
                boolean r3 = r1 instanceof java.lang.Integer
                if (r3 == 0) goto L_0x0026
                java.lang.Integer r1 = (java.lang.Integer) r1
                goto L_0x0027
            L_0x0026:
                r1 = r2
            L_0x0027:
                r3 = -1
                if (r1 != 0) goto L_0x002c
                r1 = -1
                goto L_0x0030
            L_0x002c:
                int r1 = r1.intValue()
            L_0x0030:
                com.didi.soda.home.topgun.binder.FilterBinder r4 = r6.this$0
                com.didi.app.nova.skeleton.ScopeContext r4 = r4.scopeContext
                java.lang.String r5 = "key_filter_binder_offset"
                java.lang.Object r4 = r4.getObject(r5)
                boolean r5 = r4 instanceof java.lang.Integer
                if (r5 == 0) goto L_0x0043
                r2 = r4
                java.lang.Integer r2 = (java.lang.Integer) r2
            L_0x0043:
                if (r2 != 0) goto L_0x0046
                goto L_0x004a
            L_0x0046:
                int r3 = r2.intValue()
            L_0x004a:
                if (r1 < 0) goto L_0x0052
                if (r0 != 0) goto L_0x004f
                goto L_0x0052
            L_0x004f:
                r0.scrollToPositionWithOffset(r1, r3)
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.binder.FilterBinder.ViewHolder.restoreScrollPosition():void");
        }

        private final void recordScrollPosition() {
            this.filterLayout.getRecycleView().addOnScrollListener(new FilterBinder$ViewHolder$recordScrollPosition$1(this.this$0));
        }

        public boolean openStick() {
            return this.itemView.getVisibility() == 0 && this.filterLayout.getVisibility() == 0;
        }

        public View getStickView() {
            return this.filterLayout;
        }

        public ViewGroup getStickParent() {
            return (ViewGroup) this.itemView;
        }

        /* access modifiers changed from: private */
        public final boolean isFloating() {
            return !Intrinsics.areEqual((Object) this.filterLayout.getParent(), (Object) this.itemView);
        }

        public void updateWhenFloating(int i, int i2) {
            FilterDataManager filterManager;
            if (getAdapterPosition() <= 0) {
                int i3 = this.bindPosition;
                if ((i <= i3 || i3 < i + i2) && (filterManager = ((FilterRvModel) getItem()).getFilterManager()) != null) {
                    List filterModelListWithoutMain$default = FilterDataManager.getFilterModelListWithoutMain$default(filterManager, false, 1, (Object) null);
                    this.filterLayout.bindData(filterManager.getMainFilterModel(), filterModelListWithoutMain$default, filterManager.getScene());
                }
            }
        }
    }
}
