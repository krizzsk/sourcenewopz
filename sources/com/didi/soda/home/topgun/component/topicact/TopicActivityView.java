package com.didi.soda.home.topgun.component.topicact;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.abnormal.topgun.ActivityAbnormalBinder;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.feed.base.HeaderViewIView;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.headerview.CustomerHeaderView;
import com.didi.soda.customer.widget.scroll.CustomerNavScrollListener;
import com.didi.soda.home.topgun.binder.DynamicRecyclerBinder;
import com.didi.soda.home.topgun.binder.FilterBinder;
import com.didi.soda.home.topgun.binder.HomeBusinessItemNewBinder;
import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.binder.HomeRecyclerBinder;
import com.didi.soda.home.topgun.binder.LandingHeaderBinder;
import com.didi.soda.home.topgun.component.feed.helper.HomeCalculateHeightUtil;
import com.didi.soda.home.topgun.component.topicact.Contract;
import com.didi.soda.home.topgun.component.topicact.title.AddressTitleLayout;
import com.didi.soda.home.topgun.component.topicact.title.DefaultTitleLayout;
import com.didi.soda.home.topgun.component.topicact.title.ITitleLayout;
import com.didi.soda.home.widget.LandingFloatLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020,H\u0014J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007H\u0002J\u0018\u00102\u001a\u0002002\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0019H\u0014J\b\u0010<\u001a\u00020\u001dH\u0014J\b\u0010=\u001a\u00020\u001dH\u0016J\b\u0010>\u001a\u00020\u001dH\u0016J\b\u0010?\u001a\u00020\u001dH\u0014J\u0012\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010(H\u0002J\b\u0010B\u001a\u00020\u001dH\u0016J\u0018\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010E\u001a\u00020\u001dH\u0016J\b\u0010F\u001a\u00020\u001dH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u0007H\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u0007H\u0016J\u001c\u0010K\u001a\u00020\u001d2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010O\u001a\u00020\u001d2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u00103\u001a\u00020 H\u0016J\u0010\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020(H\u0016J\b\u0010T\u001a\u00020\u001dH\u0002J\u0010\u0010U\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020,H\u0016J\b\u0010W\u001a\u00020\u001dH\u0016J\b\u0010X\u001a\u00020\u001dH\u0016J\b\u0010Y\u001a\u00020\u001dH\u0016J\b\u0010Z\u001a\u00020\u001dH\u0016J\u0012\u0010[\u001a\u00020\u001d2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\u0017\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020 H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActivityView;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityView;", "()V", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "Lcom/didi/soda/blocks/model/ComponentModel;", "lastCachedFirstOffset", "", "lastCachedFirstPostion", "mFloatLayout", "Lcom/didi/soda/home/widget/LandingFloatLayout;", "mTopicScence", "navScrollListener", "Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recycleView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "recyclerBinder", "Lcom/didi/soda/home/topgun/binder/HomeRecyclerBinder;", "getRecyclerBinder", "()Lcom/didi/soda/home/topgun/binder/HomeRecyclerBinder;", "setRecyclerBinder", "(Lcom/didi/soda/home/topgun/binder/HomeRecyclerBinder;)V", "titleContainer", "Landroid/view/ViewGroup;", "titleLayout", "Lcom/didi/soda/home/topgun/component/topicact/title/ITitleLayout;", "anchorFilterData", "", "targetPosition", "isFilterNone", "", "calculateAbnormalHeight", "dismissLoadingDialog", "fillRecyclerViewContentHeight", "hasMore", "footerViewMode", "Lcom/didi/soda/customer/component/feed/base/FooterViewIView$Mode;", "footerViewNoMoreTxt", "", "generateHeaderView", "Lcom/didi/app/nova/support/view/pullToRefresh/IRefreshView;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "generatePullToRefreshView", "Lcom/didi/app/nova/support/view/pullToRefresh/NovaPullRefreshLayout;", "getFilterDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "color", "getItemDecorator", "hasHeader", "getTitleLayout", "headerViewMode", "Lcom/didi/soda/customer/component/feed/base/HeaderViewIView$Mode;", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "initItemBinders", "intoFloating", "onCreate", "onDestroy", "parseColor", "str", "resetStyle", "scrollToFloatingState", "anchorTarget", "scrollToLastOffest", "scrollToTop", "setAnchorFooter", "footerOffset", "setConfigScene", "scene", "setRules", "rules", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "activityId", "setStyleByColorAndHeader", "colorEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$BgColorBean;", "setTitle", "title", "setUpNavBarAnimation", "setupNovaRecyclerView", "sodaRecyclerView", "showLoadingView", "showNavBarWhenError", "showNavBarWhenNormal", "showNetErrorToast", "switchTab", "data", "", "updateAngle", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "angleNum", "(Ljava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable$Orientation;", "useLinearLayout", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityView.kt */
public final class TopicActivityView extends Contract.AbsTopicActivityView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NovaRecyclerView f42929a;

    /* renamed from: b */
    private ViewGroup f42930b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ITitleLayout f42931c;

    /* renamed from: d */
    private CustomerNavScrollListener f42932d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f42933e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f42934f;

    /* renamed from: g */
    private RecyclerView.OnScrollListener f42935g;

    /* renamed from: h */
    private BinderRootConfig<ComponentModel> f42936h = new BinderRootConfig<>();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f42937i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LandingFloatLayout f42938j;
    public HomeRecyclerBinder recyclerBinder;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public final HomeRecyclerBinder getRecyclerBinder() {
        HomeRecyclerBinder homeRecyclerBinder = this.recyclerBinder;
        if (homeRecyclerBinder != null) {
            return homeRecyclerBinder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerBinder");
        return null;
    }

    public final void setRecyclerBinder(HomeRecyclerBinder homeRecyclerBinder) {
        Intrinsics.checkNotNullParameter(homeRecyclerBinder, "<set-?>");
        this.recyclerBinder = homeRecyclerBinder;
    }

    public void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.setTitle(str);
        }
    }

    public void setRules(ActivityInfoEntity.RuleLink ruleLink, String str) {
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.setRules(ruleLink, str);
        }
    }

    public void dismissLoadingDialog() {
        DialogUtil.hideLoadingDialog();
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public int calculateAbnormalHeight() {
        return (CustomerSystemUtil.getScreenHeight(getContext()) - CustomerSystemUtil.getStatusBarHeight(getContext())) - DisplayUtils.dip2px(getContext(), 120.0f);
    }

    public void showNavBarWhenError() {
        CustomerNavScrollListener customerNavScrollListener = this.f42932d;
        if (customerNavScrollListener != null) {
            customerNavScrollListener.setActive(false);
        }
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.showNavBarWhenError();
        }
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        ViewGroup.LayoutParams layoutParams = novaRecyclerView.getLayoutParams();
        if (layoutParams != null) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(3, R.id.customer_view_home_topic_shadow);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public void showNavBarWhenNormal() {
        CustomerNavScrollListener customerNavScrollListener = this.f42932d;
        if (customerNavScrollListener != null) {
            customerNavScrollListener.setActive(true);
        }
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.showNavBarWhenNormal();
        }
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        ViewGroup.LayoutParams layoutParams = novaRecyclerView.getLayoutParams();
        if (layoutParams != null) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        this.f42936h.setScopeContext(getScopeContext());
        this.f42936h.addOtherCallBack(BlocksConst.CALLBACK_NAME_TAB_SWITCH, new TopicActivityView$initItemBinders$1(this));
        setRecyclerBinder(new HomeRecyclerBinder(((Contract.AbsTopicActivityPresenter) getPresenter()).getScope(), m30407b(R.color.rf_color_white_100_alpha_0, true), this.f42936h));
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ComponentLogicUnit provideComponentLogicUnit = ((Contract.AbsTopicActivityPresenter) getPresenter()).provideComponentLogicUnit();
        Intrinsics.checkNotNullExpressionValue(provideComponentLogicUnit, "presenter.provideComponentLogicUnit()");
        FilterBinder filterBinder = new FilterBinder(scopeContext, provideComponentLogicUnit);
        filterBinder.setBgColor(ResourceHelper.getColor(R.color.transparent));
        filterBinder.setOnBindListener(new TopicActivityView$initItemBinders$2$1(this));
        filterBinder.addDecorator(m30406b(R.color.rf_color_white_100_alpha_0));
        Unit unit = Unit.INSTANCE;
        registerBinder(filterBinder);
        registerBinder(new HomeFilterNoResultBinder(((Contract.AbsTopicActivityPresenter) getPresenter()).provideComponentLogicUnit()));
        registerBinder(getRecyclerBinder());
        registerBinder(new DynamicRecyclerBinder(((Contract.AbsTopicActivityPresenter) getPresenter()).getScope()));
        registerBinder(new TopGunAbnormalViewBinder());
        registerBinder(new ActivityAbnormalBinder());
        registerBinder(new HomeBusinessItemNewBinder(TopicActOmegaHelper.Companion.getInstance()));
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        ItemDecorator b = m30407b(R.color.rf_color_white_100_alpha_0, true);
        ComponentLogicUnit provideComponentLogicUnit2 = ((Contract.AbsTopicActivityPresenter) getPresenter()).provideComponentLogicUnit();
        Intrinsics.checkNotNullExpressionValue(provideComponentLogicUnit2, "presenter.provideComponentLogicUnit()");
        registerBinder(new LandingHeaderBinder(scopeContext2, b, provideComponentLogicUnit2));
    }

    public void setConfigScene(int i) {
        this.f42937i = i;
        this.f42936h.setConfig("scene", Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_topic_activity_feed, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_rv_topic_feed);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_rv_topic_feed)");
        this.f42929a = (NovaRecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_home_topic_recycle_float);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…home_topic_recycle_float)");
        this.f42938j = (LandingFloatLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_fl_title_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ViewGroup>(…tomer_fl_title_container)");
        this.f42930b = (ViewGroup) findViewById3;
        ITitleLayout a = m30398a();
        this.f42931c = a;
        if (a != null) {
            ScopeContext scopeContext = getScopeContext();
            ViewGroup viewGroup2 = this.f42930b;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                viewGroup2 = null;
            }
            a.attachTo(scopeContext, viewGroup2);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…titleContainer)\n        }");
        return inflate;
    }

    public NovaPullRefreshLayout generatePullToRefreshView() {
        View findViewById = getView().findViewById(R.id.customer_custom_activity_pull_refresh);
        if (findViewById != null) {
            return (NovaPullRefreshLayout) findViewById;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout");
    }

    public HeaderViewIView.Mode headerViewMode() {
        return HeaderViewIView.Mode.ENABLED;
    }

    public IRefreshView generateHeaderView() {
        IRefreshView generateHeaderView = super.generateHeaderView();
        if (generateHeaderView != null) {
            CustomerHeaderView customerHeaderView = (CustomerHeaderView) generateHeaderView;
            customerHeaderView.changeStyle(CustomerHeaderView.HeaderStyle.GRAY);
            return customerHeaderView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.widget.headerview.CustomerHeaderView");
    }

    /* renamed from: a */
    private final ITitleLayout m30398a() {
        if (((Contract.AbsTopicActivityPresenter) getPresenter()).needShowAddressTitleLayout()) {
            return new AddressTitleLayout();
        }
        return new DefaultTitleLayout();
    }

    /* renamed from: b */
    private final void m30408b() {
        View titleLayout;
        CustomerNavScrollListener customerNavScrollListener = new CustomerNavScrollListener();
        ITitleLayout iTitleLayout = this.f42931c;
        int i = 0;
        if (!(iTitleLayout == null || (titleLayout = iTitleLayout.getTitleLayout()) == null)) {
            i = titleLayout.getHeight();
        }
        customerNavScrollListener.setOverlapHeight(i);
        ITitleLayout iTitleLayout2 = this.f42931c;
        NovaRecyclerView novaRecyclerView = null;
        customerNavScrollListener.setCallback(iTitleLayout2 == null ? null : iTitleLayout2.getScrollCallback());
        NovaRecyclerView novaRecyclerView2 = this.f42929a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        customerNavScrollListener.listenRecycleViewScrollEvent(novaRecyclerView);
        Unit unit = Unit.INSTANCE;
        this.f42932d = customerNavScrollListener;
    }

    public void onCreate() {
        super.onCreate();
        m30408b();
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.setOnBackClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    TopicActivityView.m30403a(TopicActivityView.this, view);
                }
            });
        }
        this.f42935g = new TopicActivityView$onCreate$2(this);
        NovaRecyclerView novaRecyclerView = this.f42929a;
        LandingFloatLayout landingFloatLayout = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        RecyclerView.OnScrollListener onScrollListener = this.f42935g;
        if (onScrollListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onScrollListener");
            onScrollListener = null;
        }
        novaRecyclerView.addOnScrollListener(onScrollListener);
        LandingFloatLayout landingFloatLayout2 = this.f42938j;
        if (landingFloatLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
        } else {
            landingFloatLayout = landingFloatLayout2;
        }
        landingFloatLayout.post(new Runnable() {
            public final void run() {
                TopicActivityView.m30401a(TopicActivityView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30403a(TopicActivityView topicActivityView, View view) {
        Intrinsics.checkNotNullParameter(topicActivityView, "this$0");
        Contract.AbsTopicActivityPresenter absTopicActivityPresenter = (Contract.AbsTopicActivityPresenter) topicActivityView.getPresenter();
        boolean z = false;
        if (absTopicActivityPresenter != null && absTopicActivityPresenter.onHandleBack()) {
            z = true;
        }
        if (!z) {
            topicActivityView.getScopeContext().getNavigator().finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30401a(TopicActivityView topicActivityView) {
        int i;
        View titleLayout;
        Intrinsics.checkNotNullParameter(topicActivityView, "this$0");
        LandingFloatLayout landingFloatLayout = topicActivityView.f42938j;
        Integer num = null;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.getStickItemImp().setGetStickLayoutHeight(new TopicActivityView$onCreate$3$1(topicActivityView));
        LandingFloatLayout landingFloatLayout2 = topicActivityView.f42938j;
        if (landingFloatLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout2 = null;
        }
        if (landingFloatLayout2.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            LandingFloatLayout landingFloatLayout3 = topicActivityView.f42938j;
            if (landingFloatLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
                landingFloatLayout3 = null;
            }
            ViewGroup.LayoutParams layoutParams = landingFloatLayout3.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                ITitleLayout iTitleLayout = topicActivityView.f42931c;
                if (!(iTitleLayout == null || (titleLayout = iTitleLayout.getTitleLayout()) == null)) {
                    num = Integer.valueOf(titleLayout.getHeight() - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_1));
                }
                if (num == null) {
                    i = ((Number) 0).intValue();
                } else {
                    i = num.intValue();
                }
                layoutParams2.topMargin = i;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        RecyclerView.OnScrollListener onScrollListener = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        RecyclerView.OnScrollListener onScrollListener2 = this.f42935g;
        if (onScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onScrollListener");
        } else {
            onScrollListener = onScrollListener2;
        }
        novaRecyclerView.removeOnScrollListener(onScrollListener);
        super.onDestroy();
    }

    public void scrollToTop() {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.scrollToPosition(0);
        ITitleLayout iTitleLayout = this.f42931c;
        if (iTitleLayout != null) {
            iTitleLayout.scrollToTop();
        }
    }

    public void intoFloating() {
        LandingFloatLayout landingFloatLayout = this.f42938j;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.intoFloating();
    }

    public void fillRecyclerViewContentHeight(boolean z) {
        ((Contract.AbsTopicActivityPresenter) getPresenter()).hideFooterBottomStubView();
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.post(new Runnable(z, this) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ TopicActivityView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                TopicActivityView.m30405a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30405a(boolean z, TopicActivityView topicActivityView) {
        View titleLayout;
        Intrinsics.checkNotNullParameter(topicActivityView, "this$0");
        if (!z) {
            NovaRecyclerView novaRecyclerView = topicActivityView.f42929a;
            LandingFloatLayout landingFloatLayout = null;
            if (novaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                novaRecyclerView = null;
            }
            RecyclerView recyclerView = novaRecyclerView;
            LandingFloatLayout landingFloatLayout2 = topicActivityView.f42938j;
            if (landingFloatLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            } else {
                landingFloatLayout = landingFloatLayout2;
            }
            int intoFloatDistance = landingFloatLayout.getIntoFloatDistance();
            ITitleLayout iTitleLayout = topicActivityView.f42931c;
            int i = 0;
            if (!(iTitleLayout == null || (titleLayout = iTitleLayout.getTitleLayout()) == null)) {
                i = titleLayout.getHeight();
            }
            topicActivityView.m30399a(HomeCalculateHeightUtil.getLandingContentFullScreenOffset(recyclerView, intoFloatDistance, i));
        }
    }

    public void scrollToFloatingState(int i, boolean z) {
        LandingFloatLayout landingFloatLayout = this.f42938j;
        NovaRecyclerView novaRecyclerView = null;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.banAcceptScroll();
        NovaRecyclerView novaRecyclerView2 = this.f42929a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        novaRecyclerView.post(new Runnable(i, z) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                TopicActivityView.m30402a(TopicActivityView.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30402a(TopicActivityView topicActivityView, int i, boolean z) {
        Intrinsics.checkNotNullParameter(topicActivityView, "this$0");
        topicActivityView.m30400a(i, z);
        NovaRecyclerView novaRecyclerView = topicActivityView.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.addOnLayoutChangeListener(new TopicActivityView$scrollToFloatingState$1$1(i, z, topicActivityView));
    }

    /* renamed from: a */
    private final void m30400a(int i, boolean z) {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        LandingFloatLayout landingFloatLayout = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = novaRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int i2 = i < 0 ? 0 : i;
            LandingFloatLayout landingFloatLayout2 = this.f42938j;
            if (landingFloatLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            } else {
                landingFloatLayout = landingFloatLayout2;
            }
            int anchorOffsetDistance = landingFloatLayout.getAnchorOffsetDistance();
            int childCount = linearLayoutManager.getChildCount();
            if (!z && i >= 0 && childCount - i2 <= 7) {
                m30399a(DisplayUtils.getScreenHeight(getContext()));
            }
            linearLayoutManager.scrollToPositionWithOffset(i2, anchorOffsetDistance);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30399a(int i) {
        if (i > 0) {
            ((Contract.AbsTopicActivityPresenter) getPresenter()).showFooterBottomStubView(i);
        } else {
            ((Contract.AbsTopicActivityPresenter) getPresenter()).hideFooterBottomStubView();
        }
    }

    public void scrollToLastOffest() {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        NovaRecyclerView novaRecyclerView2 = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = novaRecyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(this.f42933e, this.f42934f);
        }
        CustomerNavScrollListener customerNavScrollListener = this.f42932d;
        if (customerNavScrollListener != null) {
            NovaRecyclerView novaRecyclerView3 = this.f42929a;
            if (novaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            } else {
                novaRecyclerView2 = novaRecyclerView3;
            }
            customerNavScrollListener.forceScroll(novaRecyclerView2, 0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30404a(Object obj) {
        if (obj instanceof TabInfoEntity) {
            ((Contract.AbsTopicActivityPresenter) getPresenter()).onTabSwitched((TabInfoEntity) obj);
        }
    }

    public String footerViewNoMoreTxt() {
        String string = ResourceHelper.getString(R.string.customer_common_no_more);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.customer_common_no_more)");
        return string;
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        Intrinsics.checkNotNullParameter(iNovaRecyclerView, "sodaRecyclerView");
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
        iNovaRecyclerView.setFootLoadMoreEnable(true);
        LandingFloatLayout landingFloatLayout = this.f42938j;
        NovaRecyclerView novaRecyclerView = null;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        NovaRecyclerView novaRecyclerView2 = this.f42929a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        landingFloatLayout.attachRecycleView(novaRecyclerView);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public void resetStyle() {
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_v2_grey2_10_a100));
    }

    public void setStyleByColorAndHeader(ActivityInfoEntity.BgColorBean bgColorBean, boolean z) {
        if (bgColorBean == null) {
            getRecyclerBinder().addDecorator(m30407b(R.color.rf_color_v2_grey2_10_a100, z));
            return;
        }
        List arrayList = new ArrayList();
        arrayList.clear();
        if (bgColorBean.color != null) {
            try {
                List<String> list = bgColorBean.color;
                Intrinsics.checkNotNullExpressionValue(list, "colorEntity.color");
                for (String a : list) {
                    arrayList.add(Integer.valueOf(m30396a(a)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() == 1) {
            arrayList.add(Integer.valueOf(((Number) arrayList.get(0)).intValue()));
        }
        if (arrayList.size() == 0) {
            arrayList.add(Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)));
            arrayList.add(Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(CollectionsKt.toIntArray(arrayList));
        gradientDrawable.setOrientation(ExtentionsKt.updateAngle(gradientDrawable, Integer.valueOf(bgColorBean.angle)));
        NovaRecyclerView novaRecyclerView = this.f42929a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setBackground(gradientDrawable);
        getRecyclerBinder().addDecorator(m30407b(R.color.customer_color_transparent, z));
    }

    /* renamed from: b */
    private final ItemDecorator m30407b(int i, boolean z) {
        return new C14037b(z, ResourceHelper.getColor(i), DisplayUtils.dip2px(getContext(), 10.0f));
    }

    /* renamed from: b */
    private final ItemDecorator m30406b(int i) {
        return new C14036a(i, 0);
    }

    /* renamed from: a */
    private final GradientDrawable.Orientation m30397a(Integer num) {
        if (num != null && num.intValue() == 0) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (num != null && num.intValue() == 45) {
            return GradientDrawable.Orientation.BL_TR;
        }
        if (num != null && num.intValue() == 90) {
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        if (num != null && num.intValue() == 135) {
            return GradientDrawable.Orientation.BR_TL;
        }
        if (num != null && num.intValue() == 180) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (num != null && num.intValue() == 225) {
            return GradientDrawable.Orientation.TR_BL;
        }
        if (num != null && num.intValue() == 270) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (num != null && num.intValue() == 315) {
            return GradientDrawable.Orientation.TL_BR;
        }
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    /* renamed from: a */
    private final int m30396a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
        }
    }
}
