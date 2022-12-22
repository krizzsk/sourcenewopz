package com.didi.soda.home.topgun.component.filter;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/FilterHelper;", "", "scene", "", "(I)V", "doConfirmFromBlock", "Lkotlin/Function0;", "", "<set-?>", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "filterManager", "getFilterManager", "()Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "isActive", "", "onFilterEvent", "Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;", "getOnFilterEvent", "()Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;", "setOnFilterEvent", "(Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;)V", "getScene", "()I", "clickItem", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "confirm", "doConfirmFromFilterPage", "isReset", "isOriginalFilter", "onPause", "onResume", "reset", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterHelper.kt */
public final class FilterHelper {

    /* renamed from: a */
    private final int f42843a;

    /* renamed from: b */
    private FilterDataManager f42844b;

    /* renamed from: c */
    private OnFilterEvent f42845c;

    /* renamed from: d */
    private Function0<Unit> f42846d;

    /* renamed from: e */
    private boolean f42847e;

    public FilterHelper() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public FilterHelper(@FilterDataManagerScene int i) {
        this.f42843a = i;
        this.f42844b = FilterDataManager.Companion.getInstanceByScene(this.f42843a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterHelper(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i);
    }

    public final int getScene() {
        return this.f42843a;
    }

    public final FilterDataManager getFilterManager() {
        return this.f42844b;
    }

    public final OnFilterEvent getOnFilterEvent() {
        return this.f42845c;
    }

    public final void setOnFilterEvent(OnFilterEvent onFilterEvent) {
        this.f42845c = onFilterEvent;
    }

    public final boolean isOriginalFilter() {
        return this.f42844b.isOriginalFilterData();
    }

    public static /* synthetic */ void doConfirmFromFilterPage$default(FilterHelper filterHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        filterHelper.doConfirmFromFilterPage(z);
    }

    public final void doConfirmFromFilterPage(boolean z) {
        Function0<Unit> filterHelper$doConfirmFromFilterPage$1 = new FilterHelper$doConfirmFromFilterPage$1(this);
        this.f42846d = filterHelper$doConfirmFromFilterPage$1;
        if (this.f42847e) {
            if (filterHelper$doConfirmFromFilterPage$1 != null) {
                filterHelper$doConfirmFromFilterPage$1.invoke();
            }
            this.f42846d = null;
        }
    }

    public final void onResume() {
        this.f42847e = true;
        Function0<Unit> function0 = this.f42846d;
        if (function0 != null) {
            function0.invoke();
        }
        this.f42846d = null;
    }

    public final void onPause() {
        this.f42847e = false;
    }

    public final void confirm() {
        OnFilterEvent onFilterEvent = this.f42845c;
        if (onFilterEvent != null) {
            onFilterEvent.onConfirm(this.f42844b);
        }
    }

    public final void reset() {
        this.f42844b.resetAllFilter();
        confirm();
    }

    public final void clickItem(FilterModel filterModel, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        if (filterModel.mShowType == 5) {
            if (filterModel.mFilterComponent.size() > 0 && filterModel.mFilterComponent.get(0).mItems.size() > 0) {
                FilterModel.FilterItemRvModel filterItemRvModel = filterModel.mFilterComponent.get(0).mItems.get(0);
                filterItemRvModel.mIsSelected = !filterItemRvModel.mIsSelected;
                this.f42844b.saveFilterGroupChange(filterModel);
                confirm();
                HomeOmegaHelper.getInstance().headerFilterItemOutClick(filterModel.getOutFilterId(), this.f42843a, filterItemRvModel.mIsSelected, filterModel.mResourceId);
            }
        } else if (filterModel.mShowType == 6) {
            HomeOmegaHelper.getInstance().traceFilterResetCK();
            reset();
        } else {
            Request.Builder putInt = DiRouter.request().path(RoutePath.FILTER_PAGE).setFromPage(scopeContext).putInt(Const.FilterPageParam.KEY_MODEL_ID, filterModel.mNativeId).putInt(Const.FilterPageParam.KEY_FROM_SCENE, this.f42843a).putInt(Const.FilterPageParam.KEY_TOPIC_FROM_SCENE, filterModel.mTopicFromScence);
            String str = filterModel.mTimePeriod;
            if (str == null) {
                str = "";
            }
            putInt.putString("time_period", str).open();
            HomeOmegaHelper.getInstance().headerFilterClick(filterModel.mShowType, this.f42843a);
        }
    }
}
