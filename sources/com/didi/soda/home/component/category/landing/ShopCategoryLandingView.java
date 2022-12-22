package com.didi.soda.home.component.category.landing;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.GroceryHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.feed.base.HeaderViewIView;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.customer.widget.headerview.CustomerHeaderView;
import com.didi.soda.customer.widget.titlebar.OnBackClickListener;
import com.didi.soda.customer.widget.titlebar.OnRightClickListener;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.binder.CateLandingHeaderBinderLogic;
import com.didi.soda.home.binder.CateLandingNoResultBinderLogic;
import com.didi.soda.home.binder.CategoryNotifyTipsBinder;
import com.didi.soda.home.component.category.landing.Contract;
import com.didi.soda.home.kingkong.HomeKingKongBinder;
import com.didi.soda.home.kingkong.HomeKingKongItemAdapter;
import com.didi.soda.home.kingkong.KingKongItemModel;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.didi.soda.home.topgun.binder.FilterBinder;
import com.didi.soda.home.topgun.binder.HomeBusinessItemNewBinder;
import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.binder.HomeHeaderBinderLogic;
import com.didi.soda.home.topgun.component.feed.helper.HomeCalculateHeightUtil;
import com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper;
import com.didi.soda.home.widget.LandingFloatLayout;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002ABB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020\u000eH\u0014J\b\u0010,\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u000eH\u0014J\b\u0010/\u001a\u00020\u000eH\u0014J\u0018\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u00102\u001a\u00020\u000eH\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0010H\u0002J\u000e\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0012J\u0012\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u00109\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010;\u001a\u00020\u000eH\u0002J\b\u0010<\u001a\u00020\u000eH\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006C"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingView;", "Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingView;", "()V", "mFloatLayout", "Lcom/didi/soda/home/widget/LandingFloatLayout;", "mRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "mRefreshLayout", "Lcom/didi/app/nova/support/view/pullToRefresh/NovaPullRefreshLayout;", "mStatusView", "Landroid/view/View;", "mTitleBarView", "Lcom/didi/soda/customer/widget/titlebar/TitleBarView;", "anchorFilterData", "", "targetPosition", "", "isFilterNone", "", "dismissLoading", "fillRecyclerViewContentHeight", "hasMore", "footerViewMode", "Lcom/didi/soda/customer/component/feed/base/FooterViewIView$Mode;", "footerViewNoMoreTxt", "", "generateHeaderView", "Lcom/didi/app/nova/support/view/pullToRefresh/IRefreshView;", "generateNovaLayoutManager", "Lcom/didi/app/nova/support/view/recyclerview/view/layoutmanager/INovaLayoutManager;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "generatePullToRefreshView", "getBusinessBinderItemType", "getRightTxt", "headerViewMode", "Lcom/didi/soda/customer/component/feed/base/HeaderViewIView$Mode;", "hideShimmerView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "intoFloating", "onCreate", "onDestroy", "onResume", "scrollToFloatingState", "anchorTarget", "scrollToTop", "setAnchorFooter", "footerOffset", "setStatusBarBgLightning", "isStatusBarLightning", "setTitle", "title", "setupNovaRecyclerView", "novaRecyclerView", "setupView", "showLoading", "showNetErrorToast", "showShimmerView", "shimmerViewType", "Lcom/didi/soda/home/shimmer/ShimmerViewType;", "ShopCategoryLandingFilterBinder", "ShopCategoryLandingNoFilterResultBinder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingView.kt */
public final class ShopCategoryLandingView extends Contract.AbsShopCategoryLandingView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NovaRecyclerView f42569a;

    /* renamed from: b */
    private TitleBarView f42570b;

    /* renamed from: c */
    private NovaPullRefreshLayout f42571c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LandingFloatLayout f42572d;

    /* renamed from: e */
    private View f42573e;

    /* renamed from: c */
    private final String m30035c() {
        return "&em#{\"text\":\"rf_icon_v3_outlined_search\",\"color\":\"#000000\",\"size\":19,\"type\":3}&em#";
    }

    public String footerViewNoMoreTxt() {
        String string = ResourceHelper.getString(R.string.customer_footer_show_no_more_shop);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.custo…footer_show_no_more_shop)");
        return string;
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }

    public NovaPullRefreshLayout generatePullToRefreshView() {
        NovaPullRefreshLayout novaPullRefreshLayout = this.f42571c;
        if (novaPullRefreshLayout != null) {
            return novaPullRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        return null;
    }

    public HeaderViewIView.Mode headerViewMode() {
        return HeaderViewIView.Mode.ENABLED;
    }

    public IRefreshView generateHeaderView() {
        IRefreshView generateHeaderView = super.generateHeaderView();
        if (generateHeaderView != null) {
            CustomerHeaderView customerHeaderView = (CustomerHeaderView) generateHeaderView;
            customerHeaderView.changeStyle(CustomerHeaderView.HeaderStyle.GRAY);
            customerHeaderView.setPadding(customerHeaderView.getPaddingLeft(), customerHeaderView.getPaddingTop(), customerHeaderView.getPaddingRight(), customerHeaderView.getPaddingBottom() + DisplayUtils.dip2px(getContext(), 12.0f));
            return customerHeaderView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.widget.headerview.CustomerHeaderView");
    }

    public void onCreate() {
        super.onCreate();
        m30033b();
    }

    public final void setStatusBarBgLightning(boolean z) {
        CustomerSystemUtil.setStatusBarBgLightning(z);
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        if (iNovaRecyclerView != null) {
            iNovaRecyclerView.setItemDecorationEnable(true);
        }
        if (iNovaRecyclerView != null) {
            iNovaRecyclerView.setPreLoadNumber(10);
        }
        int a = m30026a();
        if (a > -1) {
            getNovaRecyclerView().getRecycledViewPool().setMaxRecycledViews(a, 8);
        }
        LandingFloatLayout landingFloatLayout = this.f42572d;
        NovaRecyclerView novaRecyclerView = null;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        NovaRecyclerView novaRecyclerView2 = this.f42569a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            novaRecyclerView = novaRecyclerView2;
        }
        landingFloatLayout.attachRecycleView(novaRecyclerView);
    }

    public void dismissLoading() {
        DialogUtil.hideLoadingDialog();
    }

    public void showLoading() {
        DialogUtil.showLoadingDialogForShopCateLanding(getScopeContext(), false);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f42569a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new CategoryNotifyTipsBinder());
        HomeKingKongBinder homeKingKongBinder = new HomeKingKongBinder();
        homeKingKongBinder.setOnItemClickListener(new HomeKingKongItemAdapter.OnItemClickListener() {
            public final void onItemClick(KingKongItemModel kingKongItemModel) {
                ShopCategoryLandingView.m30031a(ShopCategoryLandingView.this, kingKongItemModel);
            }
        });
        Unit unit = Unit.INSTANCE;
        registerBinder(homeKingKongBinder);
        registerBinder(new HomeBusinessItemNewBinder(ShopCateLandingOmegaHelper.getInstance()));
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ComponentLogicUnit provideComponentLogicUnit = ((Contract.AbsShopCategoryLandingPresenter) getPresenter()).provideComponentLogicUnit();
        Intrinsics.checkNotNullExpressionValue(provideComponentLogicUnit, "presenter.provideComponentLogicUnit()");
        ShopCategoryLandingFilterBinder shopCategoryLandingFilterBinder = new ShopCategoryLandingFilterBinder(scopeContext, provideComponentLogicUnit);
        shopCategoryLandingFilterBinder.setBgColor(ResourceHelper.getColor(R.color.transparent));
        registerBinder(shopCategoryLandingFilterBinder);
        ComponentLogicUnit provideComponentLogicUnit2 = ((Contract.AbsShopCategoryLandingPresenter) getPresenter()).provideComponentLogicUnit();
        Intrinsics.checkNotNullExpressionValue(provideComponentLogicUnit2, "presenter.provideComponentLogicUnit()");
        registerBinder(new ShopCategoryLandingNoFilterResultBinder(provideComponentLogicUnit2));
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30031a(ShopCategoryLandingView shopCategoryLandingView, KingKongItemModel kingKongItemModel) {
        String obj;
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        if (!ClickUtils.isFastClick() && kingKongItemModel != null) {
            Integer selected = kingKongItemModel.getSelected();
            boolean z = true;
            if (selected == null || selected.intValue() != 1) {
                Integer type = kingKongItemModel.getType();
                if (type != null && type.intValue() == 3) {
                    String url = kingKongItemModel.getUrl();
                    if (url != null) {
                        UrlBuilder create = UrlBuilder.create(url);
                        if (kingKongItemModel.getSubItems() != null) {
                            create.appendParam(Const.PageParams.SUB_ITEMS, GsonUtil.toJson(kingKongItemModel.getSubItems()));
                        }
                        if (kingKongItemModel.getPayload() != null) {
                            FeedPayload payload = kingKongItemModel.getPayload();
                            if (!TextUtils.isEmpty(payload == null ? null : payload.mRecId)) {
                                FeedPayload payload2 = kingKongItemModel.getPayload();
                                create.appendParam("recid", payload2 == null ? null : payload2.mRecId);
                            }
                        }
                        if (!TextUtils.isEmpty(kingKongItemModel.getCateId())) {
                            create.appendParam(Const.PageParams.KEY_CATE_ID, kingKongItemModel.getCateId());
                        }
                        create.appendParam(Const.PageParams.ALL_CATEGORY_PAGE_OPEN_SOURCE, Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE);
                        String path = create.buildUri().getPath();
                        if (path == null || (obj = StringsKt.trim(path).toString()) == null || !StringsKt.contains$default((CharSequence) obj, (CharSequence) RoutePath.All_CATEGORY_PAGE, false, 2, (Object) null)) {
                            z = false;
                        }
                        if (z) {
                            SchemeHelper.dispatchMsgForPageResultByPage(create.buildUri(), "dynamic", "", shopCategoryLandingView.getScopeContext(), false);
                        } else {
                            SchemeHelper.dispatchMsg(create.buildUri(), "", "", false);
                        }
                    }
                } else {
                    if (GroceryHelper.Companion.isGrocery(Integer.valueOf(GroceryHelper.Companion.getBusinessType(kingKongItemModel.getUrl())))) {
                        GroceryHelper.Companion.openGrocery(kingKongItemModel.getUrl());
                    } else {
                        ((Contract.AbsShopCategoryLandingPresenter) shopCategoryLandingView.getPresenter()).doRefresh(kingKongItemModel.getCateId());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final int m30026a() {
        NovaRecyclerAdapter novaRecyclerAdapter = (NovaRecyclerAdapter) getNovaRecyclerView().getAdapter();
        if (novaRecyclerAdapter != null) {
            List<ItemBinder> registeredBinderList = novaRecyclerAdapter.getRegisteredBinderList();
            int i = 0;
            int size = registeredBinderList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    if (registeredBinderList.get(i) instanceof HomeBusinessItemNewBinder) {
                        return i;
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setStatusBarBgLightning(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    public void setTitle(String str) {
        CharSequence charSequence = str;
        TitleBarView titleBarView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TitleBarView titleBarView2 = this.f42570b;
            if (titleBarView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBarView");
            } else {
                titleBarView = titleBarView2;
            }
            titleBarView.setTitleText(str);
            return;
        }
        TitleBarView titleBarView3 = this.f42570b;
        if (titleBarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBarView");
        } else {
            titleBarView = titleBarView3;
        }
        titleBarView.setTitleText("");
    }

    public void scrollToTop() {
        NovaRecyclerView novaRecyclerView = this.f42569a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        novaRecyclerView.scrollToPosition(0);
    }

    public void intoFloating() {
        LandingFloatLayout landingFloatLayout = this.f42572d;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.intoFloating();
    }

    public void fillRecyclerViewContentHeight(boolean z) {
        ((Contract.AbsShopCategoryLandingPresenter) getPresenter()).hideFooterBottomStubView();
        NovaRecyclerView novaRecyclerView = this.f42569a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        novaRecyclerView.post(new Runnable(z, this) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ ShopCategoryLandingView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                ShopCategoryLandingView.m30032a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30032a(boolean z, ShopCategoryLandingView shopCategoryLandingView) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        if (!z) {
            NovaRecyclerView novaRecyclerView = shopCategoryLandingView.f42569a;
            View view = null;
            if (novaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                novaRecyclerView = null;
            }
            RecyclerView recyclerView = novaRecyclerView;
            LandingFloatLayout landingFloatLayout = shopCategoryLandingView.f42572d;
            if (landingFloatLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
                landingFloatLayout = null;
            }
            int intoFloatDistance = landingFloatLayout.getIntoFloatDistance();
            View view2 = shopCategoryLandingView.f42573e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            } else {
                view = view2;
            }
            shopCategoryLandingView.m30027a(HomeCalculateHeightUtil.getLandingContentFullScreenOffset(recyclerView, intoFloatDistance, view.getHeight()));
        }
    }

    public void scrollToFloatingState(int i, boolean z) {
        LandingFloatLayout landingFloatLayout = this.f42572d;
        NovaRecyclerView novaRecyclerView = null;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.banAcceptScroll();
        NovaRecyclerView novaRecyclerView2 = this.f42569a;
        if (novaRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
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
                ShopCategoryLandingView.m30029a(ShopCategoryLandingView.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30029a(ShopCategoryLandingView shopCategoryLandingView, int i, boolean z) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        shopCategoryLandingView.m30028a(i, z);
        NovaRecyclerView novaRecyclerView = shopCategoryLandingView.f42569a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        novaRecyclerView.addOnLayoutChangeListener(new ShopCategoryLandingView$scrollToFloatingState$1$1(i, z, shopCategoryLandingView));
    }

    public void showShimmerView(ShimmerViewType shimmerViewType) {
        Intrinsics.checkNotNullParameter(shimmerViewType, "shimmerViewType");
        LandingFloatLayout landingFloatLayout = this.f42572d;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.showShimmer(shimmerViewType);
    }

    public void hideShimmerView() {
        LandingFloatLayout landingFloatLayout = this.f42572d;
        if (landingFloatLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            landingFloatLayout = null;
        }
        landingFloatLayout.hideShimmer();
    }

    /* renamed from: a */
    private final void m30028a(int i, boolean z) {
        NovaRecyclerView novaRecyclerView = this.f42569a;
        LandingFloatLayout landingFloatLayout = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            novaRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = novaRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int i2 = i < 0 ? 0 : i;
            LandingFloatLayout landingFloatLayout2 = this.f42572d;
            if (landingFloatLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            } else {
                landingFloatLayout = landingFloatLayout2;
            }
            int anchorOffsetDistance = landingFloatLayout.getAnchorOffsetDistance();
            int childCount = linearLayoutManager.getChildCount();
            if (!z && i >= 0 && childCount - i2 <= 7) {
                m30027a(DisplayUtils.getScreenHeight(getContext()));
            }
            linearLayoutManager.scrollToPositionWithOffset(i2, anchorOffsetDistance);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30027a(int i) {
        if (i > 0) {
            ((Contract.AbsShopCategoryLandingPresenter) getPresenter()).showFooterBottomStubView(i);
        } else {
            ((Contract.AbsShopCategoryLandingPresenter) getPresenter()).hideFooterBottomStubView();
        }
    }

    /* renamed from: b */
    private final void m30033b() {
        TitleBarView titleBarView = this.f42570b;
        TitleBarView titleBarView2 = null;
        if (titleBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBarView");
            titleBarView = null;
        }
        titleBarView.setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                ShopCategoryLandingView.m30030a(ShopCategoryLandingView.this, view);
            }
        });
        TitleBarView titleBarView3 = this.f42570b;
        if (titleBarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBarView");
            titleBarView3 = null;
        }
        titleBarView3.setRightText(m30035c());
        TitleBarView titleBarView4 = this.f42570b;
        if (titleBarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBarView");
        } else {
            titleBarView2 = titleBarView4;
        }
        titleBarView2.setOnRightClickListener(new OnRightClickListener() {
            public final void onRightClick(View view) {
                ShopCategoryLandingView.m30034b(ShopCategoryLandingView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30030a(ShopCategoryLandingView shopCategoryLandingView, View view) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        shopCategoryLandingView.getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30034b(ShopCategoryLandingView shopCategoryLandingView, View view) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        ((Contract.AbsShopCategoryLandingPresenter) shopCategoryLandingView.getPresenter()).go2Search();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_shop_category_landing, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_rv_shop_category_landing);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…rv_shop_category_landing)");
        this.f42569a = (NovaRecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tbv_title_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tbv_title_view)");
        this.f42570b = (TitleBarView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_prl_refresh_cate_landing);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…prl_refresh_cate_landing)");
        this.f42571c = (NovaPullRefreshLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_landing_recycle_float);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_landing_recycle_float)");
        this.f42572d = (LandingFloatLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_sbv_status_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_sbv_status_view)");
        this.f42573e = findViewById5;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…s_view)\n                }");
        return inflate;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingView$ShopCategoryLandingFilterBinder;", "Lcom/didi/soda/home/topgun/binder/FilterBinder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "onCreateBinderLogic", "Lcom/didi/soda/home/topgun/binder/HomeHeaderBinderLogic;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShopCategoryLandingView.kt */
    public static final class ShopCategoryLandingFilterBinder extends FilterBinder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShopCategoryLandingFilterBinder(ScopeContext scopeContext, ComponentLogicUnit componentLogicUnit) {
            super(scopeContext, componentLogicUnit);
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        }

        public HomeHeaderBinderLogic onCreateBinderLogic() {
            return new CateLandingHeaderBinderLogic();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingView$ShopCategoryLandingNoFilterResultBinder;", "Lcom/didi/soda/home/topgun/binder/HomeFilterNoResultBinder;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "onCreateBinderLogic", "Lcom/didi/soda/home/topgun/binder/HomeFilterNoResultBinder$HomeFilterNoResultLogic;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShopCategoryLandingView.kt */
    public static final class ShopCategoryLandingNoFilterResultBinder extends HomeFilterNoResultBinder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShopCategoryLandingNoFilterResultBinder(ComponentLogicUnit componentLogicUnit) {
            super(componentLogicUnit);
            Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        }

        public HomeFilterNoResultBinder.HomeFilterNoResultLogic onCreateBinderLogic() {
            return new CateLandingNoResultBinderLogic();
        }
    }
}
