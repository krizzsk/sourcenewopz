package com.didi.entrega.home.component.feed;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.entrega.home.component.feed.Contract;
import com.didi.entrega.home.component.feed.binder.HomeServicesCardBinder;
import com.didi.entrega.home.component.feed.binder.banner.BannerItemBinder;
import com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.home.shimmer.ShimmerRecyclerView;
import com.didi.entrega.home.shimmer.ShimmerViewType;
import com.didi.map.setting.common.utils.DisplayUtil;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020\u001aH\u0014J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010,\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\u0012\u00103\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J&\u00108\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u0001072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u00069"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/HomeFeedView;", "Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedView;", "()V", "TAG", "", "mAddressTv", "Landroid/widget/TextView;", "mDes", "mHomeAbNormal", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalView;", "mHomeAbNormalContainer", "Landroid/widget/FrameLayout;", "mHomeBg", "Landroid/widget/ImageView;", "mHomeBottomBg", "Landroid/view/View;", "mHomeShimmerContainer", "mHomeShimmerContainerParent", "Landroid/widget/LinearLayout;", "mJacoco", "mRecycleView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "mShimmerView", "Lcom/didi/entrega/home/shimmer/ShimmerRecyclerView;", "mTitle", "changeBgColor", "", "dismissAbnormal", "dismissShimmer", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "showAbnormal", "errorMsg", "showBusinessHoursDialog", "data", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity$HomeServiceAlertEntity;", "showBusinessServiceDialog", "showDefaultView", "homeTitle", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "showGooglePlayDialog", "content", "showShimmer", "updateAddress", "address", "updateHomeBackground", "backGround", "Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "updateHomePage", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedView.kt */
public final class HomeFeedView extends Contract.AbsHomeFeedView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NovaRecyclerView f20653a;

    /* renamed from: b */
    private TextView f20654b;

    /* renamed from: c */
    private ImageView f20655c;

    /* renamed from: d */
    private TextView f20656d;

    /* renamed from: e */
    private TextView f20657e;

    /* renamed from: f */
    private ImageView f20658f;

    /* renamed from: g */
    private View f20659g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FrameLayout f20660h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LinearLayout f20661i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ShimmerRecyclerView f20662j;

    /* renamed from: k */
    private AbnormalView f20663k;

    /* renamed from: l */
    private FrameLayout f20664l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final String f20665m = "HomeFeedView";

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15108a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15114a(RFDialog rFDialog) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15116b(View view) {
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_page_home_feed, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…age_home_feed, container)");
        View findViewById = inflate.findViewById(R.id.customer_rv_home_main);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_rv_home_main)");
        this.f20653a = (NovaRecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_view_home_titlebar_city);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.e…_view_home_titlebar_city)");
        this.f20654b = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.entrega_home_bg_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.entrega_home_bg_iv)");
        this.f20655c = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.entrega_home_bg_view1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.entrega_home_bg_view1)");
        this.f20659g = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.entrega_view_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.entrega_view_title)");
        this.f20656d = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.entrega_view_des);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.entrega_view_des)");
        this.f20657e = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.entrega_home_jacoco);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.entrega_home_jacoco)");
        this.f20658f = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_fl_home_shimmer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.c…l_home_shimmer_container)");
        this.f20660h = (FrameLayout) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_ll_shimmer);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.customer_ll_shimmer)");
        this.f20661i = (LinearLayout) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.entrega_home_abnormal);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.entrega_home_abnormal)");
        this.f20663k = (AbnormalView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.entrega_home_abnormal_container);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.e…_home_abnormal_container)");
        this.f20664l = (FrameLayout) findViewById11;
        ShimmerRecyclerView shimmerRecyclerView = new ShimmerRecyclerView(getContext());
        this.f20662j = shimmerRecyclerView;
        TextView textView = null;
        if (shimmerRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
            shimmerRecyclerView = null;
        }
        shimmerRecyclerView.setOnClickListener($$Lambda$HomeFeedView$TuGm_Is1Yh9a1ByOh8YUwsrf2o.INSTANCE);
        FrameLayout frameLayout = this.f20664l;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormalContainer");
            frameLayout = null;
        }
        frameLayout.setOnClickListener($$Lambda$HomeFeedView$XJyp99AGJU3w6H1JiWF8kEz0T_s.INSTANCE);
        if (!GlobalContext.isSuperApp()) {
            NovaRecyclerView novaRecyclerView = this.f20653a;
            if (novaRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
                novaRecyclerView = null;
            }
            ViewGroup.LayoutParams layoutParams = novaRecyclerView.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.bottomMargin = DisplayUtil.dp2px(getContext(), 70.0f);
                NovaRecyclerView novaRecyclerView2 = this.f20653a;
                if (novaRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
                    novaRecyclerView2 = null;
                }
                novaRecyclerView2.setLayoutParams(layoutParams2);
                View view = this.f20659g;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeBottomBg");
                    view = null;
                }
                view.setVisibility(0);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
        } else {
            NovaRecyclerView novaRecyclerView3 = this.f20653a;
            if (novaRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
                novaRecyclerView3 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = novaRecyclerView3.getLayoutParams();
            if (layoutParams3 != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                layoutParams4.bottomMargin = 0;
                NovaRecyclerView novaRecyclerView4 = this.f20653a;
                if (novaRecyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
                    novaRecyclerView4 = null;
                }
                novaRecyclerView4.setLayoutParams(layoutParams4);
                View view2 = this.f20659g;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeBottomBg");
                    view2 = null;
                }
                view2.setVisibility(8);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
        }
        m15107a();
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        TextView textView2 = this.f20654b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressTv");
        } else {
            textView = textView2;
        }
        iToolsService.setTypeface(textView, IToolsService.FontType.BOLD);
        LogUtil.m14765i(this.f20665m, "inflateView");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new HomeServicesCardBinder(((Contract.AbsHomeFeedPresenter) getPresenter()).provideComponentLogicUnit()));
        registerBinder(new BannerItemBinder(0.31778425f));
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f20653a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public NovaRecyclerAdapter getAdapter() {
        NovaRecyclerView novaRecyclerView = this.f20653a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
            novaRecyclerView = null;
        }
        RecyclerView.Adapter adapter = novaRecyclerView.getAdapter();
        if (adapter != null) {
            return (NovaRecyclerAdapter) adapter;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter");
    }

    public void showBusinessServiceDialog(HomeServiceItemEntity.HomeServiceAlertEntity homeServiceAlertEntity) {
        m15112a(homeServiceAlertEntity);
    }

    public void showGooglePlayDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        SodaWindowFactory.showDialog(getScopeContext().getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_home1_Go_upgrade_CGGs), new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                HomeFeedView.m15110a(HomeFeedView.this, rFDialog);
            }
        })).setSubAction1(ResourceHelper.getString(R.string.FoodC_home1_Got_it_MgpJ), $$Lambda$HomeFeedView$KXXeK2JkShw0CI1hQfYBBZtBHCs.INSTANCE)).create());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15110a(HomeFeedView homeFeedView, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(homeFeedView, "this$0");
        rFDialog.dismiss();
        CustomerSystemUtil.gotoGooglePlay(homeFeedView.getContext());
    }

    public void dismissShimmer() {
        ShimmerRecyclerView shimmerRecyclerView = this.f20662j;
        if (shimmerRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
            shimmerRecyclerView = null;
        }
        shimmerRecyclerView.stopShimmerAnimator(new HomeFeedView$dismissShimmer$1(this));
    }

    public void showShimmer() {
        LogUtil.m14765i(this.f20665m, "showShimmer");
        FrameLayout frameLayout = this.f20660h;
        ShimmerRecyclerView shimmerRecyclerView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeShimmerContainer");
            frameLayout = null;
        }
        ShimmerRecyclerView shimmerRecyclerView2 = this.f20662j;
        if (shimmerRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
            shimmerRecyclerView2 = null;
        }
        if (frameLayout.indexOfChild(shimmerRecyclerView2) < 0) {
            LinearLayout linearLayout = this.f20661i;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeShimmerContainerParent");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            FrameLayout frameLayout2 = this.f20660h;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeShimmerContainer");
                frameLayout2 = null;
            }
            ShimmerRecyclerView shimmerRecyclerView3 = this.f20662j;
            if (shimmerRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
                shimmerRecyclerView3 = null;
            }
            frameLayout2.addView(shimmerRecyclerView3);
            ShimmerRecyclerView shimmerRecyclerView4 = this.f20662j;
            if (shimmerRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShimmerView");
            } else {
                shimmerRecyclerView = shimmerRecyclerView4;
            }
            shimmerRecyclerView.startShimmerAnimator(ShimmerViewType.HOME_START);
        }
    }

    public void showAbnormal(String str) {
        AbnormalViewModel abnormalViewModel;
        AbnormalView abnormalView = this.f20663k;
        AbnormalView abnormalView2 = null;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormal");
            abnormalView = null;
        }
        abnormalView.setVisibility(0);
        FrameLayout frameLayout = this.f20664l;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormalContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            abnormalViewModel = AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeFeedView.m15109a(HomeFeedView.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(abnormalViewModel, "buildNoNetwork {\n       …tryAction()\n            }");
        } else {
            abnormalViewModel = AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeFeedView.m15117b(HomeFeedView.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(abnormalViewModel, "buildNoService(errorMsg)…tryAction()\n            }");
            AbnormalView abnormalView3 = this.f20663k;
            if (abnormalView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormal");
                abnormalView3 = null;
            }
            abnormalView3.show(abnormalViewModel);
        }
        AbnormalView abnormalView4 = this.f20663k;
        if (abnormalView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormal");
        } else {
            abnormalView2 = abnormalView4;
        }
        abnormalView2.show(abnormalViewModel);
        HomeOtherOmegaHelper.trackExceptionSW(1);
        LogUtil.m14765i(this.f20665m, "showAbnormal");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15109a(HomeFeedView homeFeedView, View view) {
        Intrinsics.checkNotNullParameter(homeFeedView, "this$0");
        ((Contract.AbsHomeFeedPresenter) homeFeedView.getPresenter()).onRetryAction();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15117b(HomeFeedView homeFeedView, View view) {
        Intrinsics.checkNotNullParameter(homeFeedView, "this$0");
        ((Contract.AbsHomeFeedPresenter) homeFeedView.getPresenter()).onRetryAction();
    }

    public void dismissAbnormal() {
        AbnormalView abnormalView = this.f20663k;
        FrameLayout frameLayout = null;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormal");
            abnormalView = null;
        }
        abnormalView.setVisibility(8);
        FrameLayout frameLayout2 = this.f20664l;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeAbNormalContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setVisibility(8);
    }

    public void updateHomePage(String str, HomeBackgroundEntity homeBackgroundEntity, HomeTitleEntity homeTitleEntity) {
        m15115a(str);
        m15111a(homeBackgroundEntity, homeTitleEntity);
    }

    /* renamed from: a */
    private final void m15107a() {
        NovaRecyclerView novaRecyclerView = this.f20653a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
            novaRecyclerView = null;
        }
        novaRecyclerView.addOnScrollListener(new HomeFeedView$changeBgColor$1(this));
    }

    /* renamed from: a */
    private final void m15115a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f20654b;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddressTv");
                textView = null;
            }
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (android.text.TextUtils.equals(r0.getTag().toString(), r12.getUrl()) == false) goto L_0x003d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m15111a(com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity r12, com.didi.entrega.home.component.feed.entity.HomeTitleEntity r13) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x00db
            java.lang.String r0 = r12.getUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00db
            android.widget.ImageView r0 = r11.f20655c
            java.lang.String r1 = "mHomeBg"
            r2 = 0
            if (r0 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0019:
            java.lang.Object r0 = r0.getTag()
            if (r0 == 0) goto L_0x003d
            android.widget.ImageView r0 = r11.f20655c
            if (r0 != 0) goto L_0x0027
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0027:
            java.lang.Object r0 = r0.getTag()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r3 = r12.getUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 != 0) goto L_0x00a9
        L_0x003d:
            long r6 = java.lang.System.currentTimeMillis()
            android.content.Context r0 = r11.getContext()
            java.lang.String r3 = r12.getUrl()
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = com.didi.entrega.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r0, (java.lang.String) r3)
            r3 = 1
            com.bumptech.glide.load.resource.bitmap.BitmapTransformation[] r3 = new com.bumptech.glide.load.resource.bitmap.BitmapTransformation[r3]
            com.didi.entrega.customer.foundation.imageloader.ClipBottomTransformation r4 = new com.didi.entrega.customer.foundation.imageloader.ClipBottomTransformation
            android.content.Context r5 = r11.getContext()
            android.content.Context r8 = r11.getContext()
            int r8 = com.didi.map.setting.common.utils.DisplayUtil.getScreenWidth(r8)
            android.content.Context r9 = r11.getContext()
            int r9 = com.didi.map.setting.common.utils.DisplayUtil.getScreenHeight(r9)
            r10 = 0
            r4.<init>(r5, r8, r9, r10)
            com.bumptech.glide.load.resource.bitmap.BitmapTransformation r4 = (com.bumptech.glide.load.resource.bitmap.BitmapTransformation) r4
            r3[r10] = r4
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.transform(r3)
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.diskCacheStrategy(r3)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.dontAnimate()
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r0 = r0.skipMemoryCache(r10)
            com.didi.entrega.home.component.feed.HomeFeedView$updateHomeBackground$1 r9 = new com.didi.entrega.home.component.feed.HomeFeedView$updateHomeBackground$1
            r3 = r9
            r4 = r13
            r5 = r11
            r8 = r12
            r3.<init>(r4, r5, r6, r8)
            com.didi.app.nova.skeleton.image.ImageRequestListener r9 = (com.didi.app.nova.skeleton.image.ImageRequestListener) r9
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = r0.listener(r9)
            android.widget.ImageView r0 = r11.f20655c
            if (r0 != 0) goto L_0x0097
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0097:
            r13.into((android.widget.ImageView) r0)
            android.widget.ImageView r13 = r11.f20655c
            if (r13 != 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r13 = r2
        L_0x00a2:
            java.lang.String r12 = r12.getUrl()
            r13.setTag(r12)
        L_0x00a9:
            android.widget.TextView r12 = r11.f20656d
            if (r12 != 0) goto L_0x00b3
            java.lang.String r12 = "mTitle"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r12 = r2
        L_0x00b3:
            r13 = 8
            r12.setVisibility(r13)
            android.widget.TextView r12 = r11.f20657e
            if (r12 != 0) goto L_0x00c2
            java.lang.String r12 = "mDes"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r12 = r2
        L_0x00c2:
            r12.setVisibility(r13)
            android.widget.TextView r12 = r11.f20654b
            if (r12 != 0) goto L_0x00cf
            java.lang.String r12 = "mAddressTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            goto L_0x00d0
        L_0x00cf:
            r2 = r12
        L_0x00d0:
            r12 = 2131101608(0x7f0607a8, float:1.781563E38)
            int r12 = r11.getColor(r12)
            r2.setTextColor(r12)
            goto L_0x00ec
        L_0x00db:
            if (r13 == 0) goto L_0x00ec
            java.lang.String r12 = r13.getMainTitle()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x00ec
            r11.m15113a((com.didi.entrega.home.component.feed.entity.HomeTitleEntity) r13)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.home.component.feed.HomeFeedView.m15111a(com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity, com.didi.entrega.home.component.feed.entity.HomeTitleEntity):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15113a(HomeTitleEntity homeTitleEntity) {
        TextView textView = this.f20656d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView3 = this.f20657e;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDes");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.f20656d;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView4 = null;
        }
        textView4.setText(homeTitleEntity.getMainTitle());
        TextView textView5 = this.f20657e;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDes");
            textView5 = null;
        }
        textView5.setText(homeTitleEntity.getSubTitle());
        ImageView imageView = this.f20655c;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBg");
            imageView = null;
        }
        imageView.setBackground((Drawable) null);
        ImageView imageView2 = this.f20655c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBg");
            imageView2 = null;
        }
        imageView2.setImageDrawable((Drawable) null);
        ImageView imageView3 = this.f20655c;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBg");
            imageView3 = null;
        }
        imageView3.setBackgroundColor(getColor(R.color.rf_color_white_100_FFFFFF));
        TextView textView6 = this.f20654b;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddressTv");
        } else {
            textView2 = textView6;
        }
        textView2.setTextColor(getColor(R.color.rf_color_gery_1_0_000000));
    }

    /* renamed from: a */
    private final void m15112a(HomeServiceItemEntity.HomeServiceAlertEntity homeServiceAlertEntity) {
        if (homeServiceAlertEntity != null) {
            if (!TextUtils.isEmpty(homeServiceAlertEntity.getContent()) || !TextUtils.isEmpty(homeServiceAlertEntity.getTitle())) {
                DialogUtil.showBusinessHourRemindDialog(homeServiceAlertEntity.getTitle(), homeServiceAlertEntity.getContent(), getScopeContext(), $$Lambda$HomeFeedView$S5_AMo76aLBgPafFYiw89pOSJE.INSTANCE);
                HomeOmegaHelper.Companion.trackBusinessHourSW();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15118b(RFDialog rFDialog) {
        rFDialog.dismiss();
        HomeOmegaHelper.Companion.trackBusinessHourCK();
    }
}
