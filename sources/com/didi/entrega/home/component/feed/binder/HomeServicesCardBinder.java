package com.didi.entrega.home.component.feed.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.customer.base.binder.logic.BinderLogic;
import com.didi.entrega.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.StringUtils;
import com.didi.entrega.customer.p113h5.CustomerH5UrlConst;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.entrega.customer.widget.support.CustomerCheckbox;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.didi.entrega.home.component.feed.binder.HomeServicesCardBinder;
import com.didi.entrega.home.component.feed.binder.model.HomeServicesRvModel;
import com.didi.entrega.home.component.feed.entity.HomeCouponEntity;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.soda.uiwidget.cardview.SodaCardView;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0003\u001a\u001b\u001cB\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder;", "Lcom/didi/entrega/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$HomerServicesBinderLogicImp;", "Lcom/didi/entrega/home/component/feed/binder/model/HomeServicesRvModel;", "Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$ViewHolder;", "componentLogicUnit", "Lcom/didi/entrega/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/entrega/customer/base/binder/ComponentLogicUnit;)V", "mLoadedIcon1", "", "getMLoadedIcon1", "()Ljava/lang/String;", "setMLoadedIcon1", "(Ljava/lang/String;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "AbsHomerServicesBinderLogic", "HomerServicesBinderLogicImp", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeServicesCardBinder.kt */
public final class HomeServicesCardBinder extends CustomerLogicItemBinder<HomerServicesBinderLogicImp, HomeServicesRvModel, ViewHolder> {

    /* renamed from: a */
    private String f20666a;

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$AbsHomerServicesBinderLogic;", "Lcom/didi/entrega/customer/base/binder/logic/BinderLogic;", "Lcom/didi/entrega/home/component/feed/binder/HomerServicesCardLogicRepo;", "()V", "onServiceItemClicked", "", "item", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "isLawChecked", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeServicesCardBinder.kt */
    public static abstract class AbsHomerServicesBinderLogic extends BinderLogic<HomerServicesCardLogicRepo> {
        public abstract void onServiceItemClicked(HomeServiceItemEntity homeServiceItemEntity, boolean z);
    }

    public Class<HomeServicesRvModel> bindDataType() {
        return HomeServicesRvModel.class;
    }

    public HomeServicesCardBinder(ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
    }

    public final String getMLoadedIcon1() {
        return this.f20666a;
    }

    public final void setMLoadedIcon1(String str) {
        this.f20666a = str;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.entrega_item_home_enter_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nter_card, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, HomeServicesRvModel homeServicesRvModel) {
        String couponTip;
        ViewHolder viewHolder2 = viewHolder;
        HomeServicesRvModel homeServicesRvModel2 = homeServicesRvModel;
        Intrinsics.checkNotNullParameter(viewHolder2, "holder");
        Intrinsics.checkNotNullParameter(homeServicesRvModel2, "item");
        List<HomeServiceItemEntity> serviceList = homeServicesRvModel.getServiceList();
        if (serviceList != null) {
            int i = 0;
            for (Object next : serviceList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                HomeServiceItemEntity homeServiceItemEntity = (HomeServiceItemEntity) next;
                if (homeServiceItemEntity.getType() == 1) {
                    if (!TextUtils.equals(getMLoadedIcon1(), homeServiceItemEntity.getIcon())) {
                        FlyImageLoader.loadImage1x1(viewHolder2.itemView.getContext(), homeServiceItemEntity.getIcon()).diskCacheStrategy(DiskCacheStrategy.RESOURCE).dontAnimate().centerCrop().skipMemoryCache(false).into(viewHolder.getMServiceIcon());
                        setMLoadedIcon1(homeServiceItemEntity.getIcon());
                    }
                    viewHolder.getMServiceName().setText(homeServiceItemEntity.getTitle());
                    viewHolder.getMServiceDes().setText(homeServiceItemEntity.getDesc());
                    viewHolder.getMServiceBtn().setText(homeServiceItemEntity.getButtonDesc());
                    viewHolder.getMServiceBtn().setOnClickListener(new View.OnClickListener(this, homeServiceItemEntity) {
                        public final /* synthetic */ HomeServicesCardBinder f$1;
                        public final /* synthetic */ HomeServiceItemEntity f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            HomeServicesCardBinder.m15120a(HomeServicesCardBinder.ViewHolder.this, this.f$1, this.f$2, view);
                        }
                    });
                }
                i = i2;
            }
        }
        HomeCouponEntity coupon = homeServicesRvModel.getCoupon();
        Unit unit = null;
        if (!(coupon == null || (couponTip = coupon.getCouponTip()) == null)) {
            viewHolder.getMCouponLayout().setVisibility(0);
            viewHolder.getMCouponTitle().setText(couponTip);
            ViewGroup.LayoutParams layoutParams = viewHolder.getMShadow().getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.topToTop = 0;
                viewHolder.getMShadow().setLayoutParams(layoutParams2);
                viewHolder.getMCouponLayout().setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        HomeServicesCardBinder.m15121a(HomeServicesRvModel.this, view);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        if (unit == null) {
            HomeServicesCardBinder homeServicesCardBinder = this;
            viewHolder.getMCouponLayout().setVisibility(4);
            ViewGroup.LayoutParams layoutParams3 = viewHolder.getMShadow().getLayoutParams();
            if (layoutParams3 != null) {
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.topToTop = viewHolder.getMSpacer().getId();
                viewHolder.getMShadow().setLayoutParams(layoutParams4);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        if (homeServicesRvModel.getLawStyle() == 2) {
            viewHolder.getMLawLayout().setVisibility(0);
            HomeOmegaHelper.Companion.trackLegalCheckSW();
            String string = ResourceHelper.getString(R.string.Entrega_Integration__CAyW);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Entrega_Integration__CAyW)");
            CharSequence charSequence = string;
            String substring = string.substring(StringsKt.indexOf$default(charSequence, Const.joLeft, 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default(charSequence, "}", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringUtils.highlightText((TextView) viewHolder.getMLawText(), StringsKt.replace$default(StringsKt.replace$default(string, Const.joLeft, "", false, 4, (Object) null), "}", "", false, 4, (Object) null), substring);
            viewHolder.getMLawText().setOnClickListener($$Lambda$HomeServicesCardBinder$1QTH7PlXaaOi2bbZzeYUgaXQiEA.INSTANCE);
            return;
        }
        viewHolder.getMLawLayout().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15120a(ViewHolder viewHolder, HomeServicesCardBinder homeServicesCardBinder, HomeServiceItemEntity homeServiceItemEntity, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(homeServicesCardBinder, "this$0");
        Intrinsics.checkNotNullParameter(homeServiceItemEntity, "$homeServiceItemEntity");
        int i = 1;
        boolean isChecked = viewHolder.getMLawLayout().getVisibility() == 0 ? viewHolder.getMLawCheckbox().isChecked() : true;
        ((HomerServicesBinderLogicImp) homeServicesCardBinder.getBinderLogic()).onServiceItemClicked(homeServiceItemEntity, isChecked);
        HomeOmegaHelper.Companion companion = HomeOmegaHelper.Companion;
        int type = homeServiceItemEntity.getType();
        if (isChecked) {
            i = 2;
        }
        companion.trackServiceCK(type, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15121a(HomeServicesRvModel homeServicesRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeServicesRvModel, "$item");
        HomeCouponEntity coupon = homeServicesRvModel.getCoupon();
        if (!(coupon == null || coupon.getUrl() == null)) {
            Request.Builder path = DiRouter.request().path("webPage");
            HomeCouponEntity coupon2 = homeServicesRvModel.getCoupon();
            path.putString("url", coupon2 == null ? null : coupon2.getUrl()).open();
        }
        HomeOmegaHelper.Companion.trackCouponCK();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15119a(View view) {
        DiRouter.request().path("webPage").putString("url", CustomerH5UrlConst.getLawUrl()).open();
        HomeOmegaHelper.Companion.trackLegalCheckCK();
    }

    public HomerServicesBinderLogicImp onCreateBinderLogic() {
        return new HomerServicesBinderLogicImp();
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$HomerServicesBinderLogicImp;", "Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$AbsHomerServicesBinderLogic;", "()V", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/entrega/home/component/feed/binder/HomerServicesCardLogicRepo;", "onServiceItemClicked", "", "item", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "isLawChecked", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeServicesCardBinder.kt */
    public static final class HomerServicesBinderLogicImp extends AbsHomerServicesBinderLogic {
        public Class<HomerServicesCardLogicRepo> bindLogicRepoType() {
            return HomerServicesCardLogicRepo.class;
        }

        public void onServiceItemClicked(HomeServiceItemEntity homeServiceItemEntity, boolean z) {
            Intrinsics.checkNotNullParameter(homeServiceItemEntity, "item");
            homeServiceItemEntity.setLawChecked(z);
            ((HomerServicesCardLogicRepo) getLogicRepo()).setValue(homeServiceItemEntity);
        }
    }

    @Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006,"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/binder/HomeServicesCardBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/home/component/feed/binder/model/HomeServicesRvModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCouponLayout", "Landroid/widget/LinearLayout;", "getMCouponLayout", "()Landroid/widget/LinearLayout;", "mCouponTitle", "Lcom/didi/entrega/customer/widget/text/RichTextView;", "getMCouponTitle", "()Lcom/didi/entrega/customer/widget/text/RichTextView;", "mLawCheckbox", "Lcom/didi/entrega/customer/widget/support/CustomerCheckbox;", "getMLawCheckbox", "()Lcom/didi/entrega/customer/widget/support/CustomerCheckbox;", "mLawLayout", "getMLawLayout", "mLawText", "getMLawText", "mServiceBtn", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "getMServiceBtn", "()Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "mServiceDes", "Landroid/widget/TextView;", "getMServiceDes", "()Landroid/widget/TextView;", "mServiceIcon", "Landroid/widget/ImageView;", "getMServiceIcon", "()Landroid/widget/ImageView;", "mServiceName", "getMServiceName", "mShadow", "Lcom/didi/soda/uiwidget/cardview/SodaCardView;", "getMShadow", "()Lcom/didi/soda/uiwidget/cardview/SodaCardView;", "mSpacer", "Landroid/widget/Space;", "getMSpacer", "()Landroid/widget/Space;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeServicesCardBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<HomeServicesRvModel> {
        private final LinearLayout mCouponLayout;
        private final RichTextView mCouponTitle;
        private final CustomerCheckbox mLawCheckbox;
        private final LinearLayout mLawLayout;
        private final RichTextView mLawText;
        private final CustomerAppCompatTextView mServiceBtn;
        private final TextView mServiceDes;
        private final ImageView mServiceIcon;
        private final TextView mServiceName;
        private final SodaCardView mShadow;
        private final Space mSpacer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.entrega_home_coupon_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…trega_home_coupon_layout)");
            this.mCouponLayout = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.entrega_view_coupon_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…ntrega_view_coupon_title)");
            this.mCouponTitle = (RichTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.entrega_iv_service_icon1);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…entrega_iv_service_icon1)");
            this.mServiceIcon = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.entrega_service_card_shadow);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…rega_service_card_shadow)");
            this.mShadow = (SodaCardView) findViewById4;
            View findViewById5 = view.findViewById(R.id.marginSpacer);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.marginSpacer)");
            this.mSpacer = (Space) findViewById5;
            View findViewById6 = view.findViewById(R.id.entrega_iv_service_title1);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.…ntrega_iv_service_title1)");
            this.mServiceName = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.entrega_iv_service_des);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.entrega_iv_service_des)");
            this.mServiceDes = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.entrega_home_card_btn);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.entrega_home_card_btn)");
            this.mServiceBtn = (CustomerAppCompatTextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.entrega_home_law_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.….entrega_home_law_layout)");
            this.mLawLayout = (LinearLayout) findViewById9;
            View findViewById10 = view.findViewById(R.id.entrega_rf_checkbox);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.entrega_rf_checkbox)");
            this.mLawCheckbox = (CustomerCheckbox) findViewById10;
            View findViewById11 = view.findViewById(R.id.entrega_home_law_text);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.entrega_home_law_text)");
            this.mLawText = (RichTextView) findViewById11;
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mServiceName, IToolsService.FontType.BOLD);
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this.mServiceName, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_font_10), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_font_18), 1, 1);
        }

        public final LinearLayout getMCouponLayout() {
            return this.mCouponLayout;
        }

        public final RichTextView getMCouponTitle() {
            return this.mCouponTitle;
        }

        public final ImageView getMServiceIcon() {
            return this.mServiceIcon;
        }

        public final SodaCardView getMShadow() {
            return this.mShadow;
        }

        public final Space getMSpacer() {
            return this.mSpacer;
        }

        public final TextView getMServiceName() {
            return this.mServiceName;
        }

        public final TextView getMServiceDes() {
            return this.mServiceDes;
        }

        public final CustomerAppCompatTextView getMServiceBtn() {
            return this.mServiceBtn;
        }

        public final LinearLayout getMLawLayout() {
            return this.mLawLayout;
        }

        public final CustomerCheckbox getMLawCheckbox() {
            return this.mLawCheckbox;
        }

        public final RichTextView getMLawText() {
            return this.mLawText;
        }
    }
}
