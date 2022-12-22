package com.didi.soda.home.topgun.binder;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.adapter.HomeSearchViewFlpperAdapter;
import com.didi.soda.home.topgun.binder.HomeNewHeaderBinder;
import com.didi.soda.home.topgun.binder.model.HomeHeaderRvModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import com.didi.soda.home.topgun.widget.FeedHeaderLayout;
import com.didi.soda.home.topgun.widget.HeaderAddressLayout;
import com.didi.soda.home.topgun.widget.HeaderCoordinationView;
import com.didi.soda.home.topgun.widget.floatlayout.IHeaderStickHolder;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\u001c\u0010\u0016\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeNewHeaderBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeHeaderBinderLogic;", "Lcom/didi/soda/home/topgun/binder/model/HomeHeaderRvModel;", "Lcom/didi/soda/home/topgun/binder/HomeNewHeaderBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "feedHeaderLayout", "Lcom/didi/soda/home/topgun/widget/FeedHeaderLayout;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;Lcom/didi/soda/home/topgun/widget/FeedHeaderLayout;)V", "getFeedHeaderLayout", "()Lcom/didi/soda/home/topgun/widget/FeedHeaderLayout;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeNewHeaderBinder.kt */
public final class HomeNewHeaderBinder extends CustomerLogicItemBinder<HomeHeaderBinderLogic, HomeHeaderRvModel, ViewHolder> {

    /* renamed from: a */
    private final ScopeContext f42755a;

    /* renamed from: b */
    private final FeedHeaderLayout f42756b;

    public Class<HomeHeaderRvModel> bindDataType() {
        return HomeHeaderRvModel.class;
    }

    public final ScopeContext getScopeContext() {
        return this.f42755a;
    }

    public final FeedHeaderLayout getFeedHeaderLayout() {
        return this.f42756b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeNewHeaderBinder(ScopeContext scopeContext, ComponentLogicUnit componentLogicUnit, FeedHeaderLayout feedHeaderLayout) {
        super(componentLogicUnit);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        Intrinsics.checkNotNullParameter(feedHeaderLayout, "feedHeaderLayout");
        this.f42755a = scopeContext;
        this.f42756b = feedHeaderLayout;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_home_header_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        getFeedHeaderLayout().bindItemView(inflate);
        return viewHolder;
    }

    public void bind(ViewHolder viewHolder, HomeHeaderRvModel homeHeaderRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(homeHeaderRvModel, "item");
        viewHolder.setData(homeHeaderRvModel);
    }

    public HomeHeaderBinderLogic onCreateBinderLogic() {
        return new HomeHeaderBinderLogic();
    }

    @Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0002J\"\u0010.\u001a\u00020\"2\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u000100j\n\u0012\u0004\u0012\u000201\u0018\u0001`2J\u0006\u00103\u001a\u00020\"R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeNewHeaderBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/HomeHeaderRvModel;", "Lcom/didi/soda/home/topgun/widget/floatlayout/IHeaderStickHolder;", "rootView", "Landroid/view/View;", "(Lcom/didi/soda/home/topgun/binder/HomeNewHeaderBinder;Landroid/view/View;)V", "addressLayout", "Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "endColor", "", "floatViewLayout", "Landroid/widget/LinearLayout;", "floatViewLayoutParent", "Landroid/view/ViewGroup;", "headerCoordinationView", "Lcom/didi/soda/home/topgun/widget/HeaderCoordinationView;", "homeSearchViewFlpperAdapter", "Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter;", "iconvSearchHint", "Lcom/didi/rfusion/widget/RFIconView;", "searchHintFlipper", "Landroid/widget/AdapterViewFlipper;", "searchLayout", "specialImageView", "Landroid/widget/ImageView;", "specialLayout", "Landroid/widget/FrameLayout;", "startColor", "style", "Lcom/didi/soda/home/topgun/binder/Style;", "applyStyle", "", "getFloatScrollOffset", "getIntoFloatValue", "getStickParentView", "getStickView", "isFloating", "", "onFloatScroll", "progress", "", "setData", "item", "setFlpperData", "list", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "Lkotlin/collections/ArrayList;", "setViewAdapterFlipper", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeNewHeaderBinder.kt */
    public final class ViewHolder extends ItemViewHolder<HomeHeaderRvModel> implements IHeaderStickHolder {
        private HeaderAddressLayout addressLayout;
        private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        private int endColor = CustomerExtentionKt.getColor(R.color.rf_color_gery_6_90_E3E3E6);
        private final LinearLayout floatViewLayout;
        private final ViewGroup floatViewLayoutParent;
        private final HeaderCoordinationView headerCoordinationView;
        private final HomeSearchViewFlpperAdapter homeSearchViewFlpperAdapter;
        private final RFIconView iconvSearchHint;
        private final AdapterViewFlipper searchHintFlipper;
        private final LinearLayout searchLayout;
        private final ImageView specialImageView;
        private final FrameLayout specialLayout;
        private int startColor = CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
        /* access modifiers changed from: private */
        public C14000c style = new C13998a();
        final /* synthetic */ HomeNewHeaderBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(HomeNewHeaderBinder homeNewHeaderBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(homeNewHeaderBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = homeNewHeaderBinder;
            View findViewById = view.findViewById(R.id.customer_ll_home_search);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.….customer_ll_home_search)");
            this.searchLayout = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.customer_rl_home_feed_address);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…mer_rl_home_feed_address)");
            this.addressLayout = (HeaderAddressLayout) findViewById2;
            View findViewById3 = view.findViewById(R.id.customer_ll_home_float_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…mer_ll_home_float_layout)");
            this.floatViewLayout = (LinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.customer_ll_home_float_container);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…_ll_home_float_container)");
            this.floatViewLayoutParent = (ViewGroup) findViewById4;
            View findViewById5 = view.findViewById(R.id.customer_rl_home_special_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…r_rl_home_special_layout)");
            this.specialLayout = (FrameLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.customer_rl_home_special_image);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.…er_rl_home_special_image)");
            this.specialImageView = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.customer_custom_coordination_view);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.…custom_coordination_view)");
            this.headerCoordinationView = (HeaderCoordinationView) findViewById7;
            View findViewById8 = view.findViewById(R.id.customer_vf_home_search_hint);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.…omer_vf_home_search_hint)");
            this.searchHintFlipper = (AdapterViewFlipper) findViewById8;
            View findViewById9 = view.findViewById(R.id.iconv_search_hint);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.iconv_search_hint)");
            this.iconvSearchHint = (RFIconView) findViewById9;
            if (GlobalContext.isEmbed()) {
                this.headerCoordinationView.setVisibility(4);
                this.headerCoordinationView.setDependOnView(this.addressLayout);
                this.headerCoordinationView.bindScopeContext(this.this$0.getScopeContext());
            }
            this.homeSearchViewFlpperAdapter = new HomeSearchViewFlpperAdapter();
            setViewAdapterFlipper();
        }

        public final void setViewAdapterFlipper() {
            this.searchHintFlipper.setAdapter(this.homeSearchViewFlpperAdapter);
            this.searchHintFlipper.setOnItemClickListener(new AdapterView.OnItemClickListener(this.this$0) {
                public final /* synthetic */ HomeNewHeaderBinder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    HomeNewHeaderBinder.ViewHolder.m46969setViewAdapterFlipper$lambda0(HomeNewHeaderBinder.ViewHolder.this, this.f$1, adapterView, view, i, j);
                }
            });
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("translationY", new float[]{88.0f, 0.0f});
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.searchHintFlipper.setInAnimation(objectAnimator);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, -88.0f});
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat3, ofFloat4});
            this.searchHintFlipper.setOutAnimation(objectAnimator2);
            this.homeSearchViewFlpperAdapter.setOnItemClickListener(new HomeNewHeaderBinder$ViewHolder$setViewAdapterFlipper$2(this, this.this$0));
        }

        /* access modifiers changed from: private */
        /* renamed from: setViewAdapterFlipper$lambda-0  reason: not valid java name */
        public static final void m46969setViewAdapterFlipper$lambda0(ViewHolder viewHolder, HomeNewHeaderBinder homeNewHeaderBinder, AdapterView adapterView, View view, int i, long j) {
            Intrinsics.checkNotNullParameter(viewHolder, "this$0");
            Intrinsics.checkNotNullParameter(homeNewHeaderBinder, "this$1");
            ArrayList<HomeSearchHotWordsModel> data = viewHolder.homeSearchViewFlpperAdapter.getData();
            HomeSearchHotWordsModel homeSearchHotWordsModel = data == null ? null : data.get(i);
            if (homeSearchHotWordsModel != null) {
                ((HomeHeaderBinderLogic) homeNewHeaderBinder.getBinderLogic()).onSearchLayoutClick(viewHolder.isFloating(), homeSearchHotWordsModel);
            }
        }

        public final void setFlpperData(ArrayList<HomeSearchHotWordsModel> arrayList) {
            HomeSearchViewFlpperAdapter homeSearchViewFlpperAdapter2 = this.homeSearchViewFlpperAdapter;
            if (homeSearchViewFlpperAdapter2 != null) {
                homeSearchViewFlpperAdapter2.setData(arrayList);
            }
        }

        public void onFloatScroll(float f) {
            LogUtil.m29100d("TAG", Intrinsics.stringPlus(">>>  onFloatScroll ", Float.valueOf(f)));
            if (this.style instanceof C13999b) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_28));
                Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor));
                if (evaluate != null) {
                    gradientDrawable.setColor(((Integer) evaluate).intValue());
                    this.searchLayout.setBackground(gradientDrawable);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }

        public View getStickView() {
            return this.floatViewLayout;
        }

        public ViewGroup getStickParentView() {
            return this.floatViewLayoutParent;
        }

        public int getIntoFloatValue() {
            return this.itemView.getHeight() - DisplayUtils.dip2px(this.itemView.getContext(), 72.0f);
        }

        public int getFloatScrollOffset() {
            return DisplayUtils.dip2px(this.itemView.getContext(), 72.0f);
        }

        /* access modifiers changed from: private */
        public final void applyStyle() {
            this.addressLayout.setAddressColor(this.style.mo107285b(), this.style.mo107284a());
            if (!isFloating()) {
                this.searchLayout.setBackgroundResource(this.style.mo107286c());
            }
        }

        /* access modifiers changed from: private */
        public final boolean isFloating() {
            return !Intrinsics.areEqual((Object) this.floatViewLayout.getParent(), (Object) this.floatViewLayoutParent);
        }

        public final void setData(HomeHeaderRvModel homeHeaderRvModel) {
            C14000c cVar;
            Intrinsics.checkNotNullParameter(homeHeaderRvModel, "item");
            if (homeHeaderRvModel.mIsShowSpecial) {
                cVar = new C13999b();
            } else {
                cVar = new C13998a();
            }
            this.style = cVar;
            applyStyle();
            HeaderAddressLayout.setAddress$default(this.addressLayout, this.this$0.getScopeContext(), 0, 2, (Object) null);
            Rect rect = new Rect();
            this.searchHintFlipper.getHitRect(rect);
            Rect rect2 = new Rect();
            this.iconvSearchHint.getHitRect(rect2);
            rect.left = rect2.left - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            rect.right += ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            this.searchLayout.setTouchDelegate(new TouchDelegate(rect, this.searchHintFlipper));
            ArrayList<HomeSearchHotWordsModel> arrayList = homeHeaderRvModel.hotWordsList;
            if (arrayList != null && arrayList.isEmpty()) {
                this.searchHintFlipper.setAutoStart(false);
                this.searchHintFlipper.stopFlipping();
            } else {
                this.searchHintFlipper.setAutoStart(true);
                this.searchHintFlipper.startFlipping();
                HomeOmegaHelper.getInstance().trackHomeHotWordsSW(homeHeaderRvModel.hotWordsList);
            }
            setFlpperData(homeHeaderRvModel.hotWordsList);
            this.this$0.getFeedHeaderLayout().updateImage(this.this$0.getScopeContext(), homeHeaderRvModel.mIsShowSpecial, homeHeaderRvModel.specialBgImageUrl, homeHeaderRvModel.ambientImg, new HomeNewHeaderBinder$ViewHolder$setData$1(this));
            if (homeHeaderRvModel.mIsShowSpecial) {
                HomeOmegaHelper.getInstance().trackHeaderSpecialBannerSw(homeHeaderRvModel);
                this.specialLayout.setVisibility(0);
                FlyImageLoader.loadImageUnspecified(this.this$0.getScopeContext(), homeHeaderRvModel.specialImageUrl).dontAnimate().centerCrop().into(this.specialImageView);
                this.specialLayout.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        HomeNewHeaderBinder.ViewHolder.m46968setData$lambda1(HomeHeaderRvModel.this, view);
                    }
                });
                return;
            }
            this.specialLayout.setVisibility(8);
        }

        /* access modifiers changed from: private */
        /* renamed from: setData$lambda-1  reason: not valid java name */
        public static final void m46968setData$lambda1(HomeHeaderRvModel homeHeaderRvModel, View view) {
            Intrinsics.checkNotNullParameter(homeHeaderRvModel, "$item");
            HomeOmegaHelper.getInstance().trackHeaderSpecialBannerCk(homeHeaderRvModel);
            String str = homeHeaderRvModel.link;
            Intrinsics.checkNotNullExpressionValue(str, "item.link");
            SchemeHelper.dispatchMsg(str);
        }
    }
}
