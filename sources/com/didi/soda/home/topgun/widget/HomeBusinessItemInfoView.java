package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.CouponTagFlowLayoutViewV2;
import com.didi.soda.customer.widget.CustomerFixLineHeightTextView;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinderNewLogic;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001a\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0007J\u0010\u0010+\u001a\u00020\u001b2\b\b\u0001\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessItemInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mActTipNfl", "Lcom/didi/soda/customer/widget/CouponTagFlowLayoutViewV2;", "mCateInfoContainer", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "mDeliveryDescContainer", "mHonorImgIv", "Landroid/widget/ImageView;", "mNameTv", "Lcom/didi/soda/customer/widget/CustomerFixLineHeightTextView;", "mRankDescContainer", "mRecommandDescDivider", "Landroid/view/View;", "mShowHonorImage", "", "mViewWidth", "bindData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "logicInterface", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "handCateInfo", "handDeliveryInfo", "handPromoteInfo", "handleBusinessName", "handleRankingInfo", "setHonorIconVisible", "visible", "setShopNameMaxLine", "maxLine", "setShopNameRightMargin", "rightMargin", "setShopNameTextColor", "color", "setViewWidth", "width", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBusinessItemInfoView.kt */
public final class HomeBusinessItemInfoView extends ConstraintLayout {

    /* renamed from: a */
    private CustomerFixLineHeightTextView f43091a;

    /* renamed from: b */
    private HomeBusinessGrid f43092b;

    /* renamed from: c */
    private HomeBusinessGrid f43093c;

    /* renamed from: d */
    private CouponTagFlowLayoutViewV2 f43094d;

    /* renamed from: e */
    private ImageView f43095e;

    /* renamed from: f */
    private View f43096f;

    /* renamed from: g */
    private HomeBusinessGrid f43097g;

    /* renamed from: h */
    private RoundedCornersTransformation.CornerType f43098h;

    /* renamed from: i */
    private int f43099i;

    /* renamed from: j */
    private boolean f43100j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemInfoView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessItemInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43098h = RoundedCornersTransformation.CornerType.ALL;
        this.f43100j = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_item_info_business, this, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_home_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CustomerFix…er_tv_home_business_name)");
        this.f43091a = (CustomerFixLineHeightTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_hs_cate_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<HomeBusines…r_hs_cate_info_container)");
        this.f43092b = (HomeBusinessGrid) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_hs_delivery_desc_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<HomeBusines…_delivery_desc_container)");
        this.f43093c = (HomeBusinessGrid) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_nfl_home_business_act_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<CouponTagFl…fl_home_business_act_tip)");
        this.f43094d = (CouponTagFlowLayoutViewV2) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_iv_home_business_honor_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById<ImageView>(…_home_business_honor_img)");
        this.f43095e = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_delivery_desc_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<View>(R.id.…er_delivery_desc_divider)");
        this.f43096f = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_hs_rank_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<HomeBusines…stomer_hs_rank_container)");
        this.f43097g = (HomeBusinessGrid) findViewById7;
    }

    public final void setShopNameTextColor(int i) {
        this.f43091a.setTextColor(i);
    }

    public final void setShopNameMaxLine(int i) {
        this.f43091a.setMaxLines(i);
    }

    public final void setShopNameRightMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.f43091a.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.rightMargin = i;
            this.f43091a.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setHonorIconVisible(boolean z) {
        this.f43100j = z;
    }

    /* renamed from: a */
    private final void m30495a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        this.f43091a.getPaint().setTextSize((float) DisplayUtils.dip2px(getContext(), 18.0f));
        boolean z = true;
        this.f43091a.setTextSize(1, (float) 16);
        this.f43091a.setLineSpacingExtra(DisplayUtils.dip2px(getContext(), 3.0f));
        CharSequence charSequence = homeBusinessInfoRvModel.mShopName;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        this.f43091a.setCustomText(z ? "" : homeBusinessInfoRvModel.mShopName);
    }

    /* renamed from: a */
    private final void m30496a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        Collection collection = homeBusinessInfoRvModel.mRating;
        if (!(collection == null || collection.isEmpty())) {
            this.f43092b.setData(homeBusinessInfoRvModel.mRating, this.f43099i);
            this.f43092b.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
                public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeBusinessItemInfoView.m30494a(HomeBusinessItemBinderNewLogic.this, this.f$1, view);
                }
            });
            return;
        }
        this.f43092b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30494a(HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessItemBinderNewLogic != null) {
            homeBusinessItemBinderNewLogic.onItemClick(homeBusinessInfoRvModel);
        }
    }

    /* renamed from: b */
    private final void m30499b(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        Collection collection = homeBusinessInfoRvModel.mFulfillment;
        if (collection == null || collection.isEmpty()) {
            this.f43093c.setVisibility(8);
            return;
        }
        this.f43093c.setDivider("dot");
        this.f43093c.setItemSpace(Float.valueOf(8.0f));
        this.f43093c.setData(homeBusinessInfoRvModel.mFulfillment, this.f43099i);
        this.f43093c.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeBusinessItemInfoView.m30497b(HomeBusinessItemBinderNewLogic.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30497b(HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessItemBinderNewLogic != null) {
            homeBusinessItemBinderNewLogic.onItemClick(homeBusinessInfoRvModel);
        }
    }

    /* renamed from: b */
    private final void m30498b(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (!CollectionsUtil.isEmpty(homeBusinessInfoRvModel.mTags)) {
            CouponTagFlowLayoutViewV2 couponTagFlowLayoutViewV2 = this.f43094d;
            List<PromptEntity> list = homeBusinessInfoRvModel.mTags;
            Intrinsics.checkNotNullExpressionValue(list, "rvModel.mTags");
            couponTagFlowLayoutViewV2.setData((List<? extends PromptEntity>) list, this.f43099i);
            this.f43094d.setVisibility(0);
            return;
        }
        this.f43094d.setVisibility(8);
    }

    /* renamed from: c */
    private final void m30501c(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        if (homeBusinessInfoRvModel.mRecInfo != null) {
            CharSequence charSequence = homeBusinessInfoRvModel.mRecInfo.content;
            if (!(charSequence == null || charSequence.length() == 0)) {
                this.f43097g.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
                    public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        HomeBusinessItemInfoView.m30500c(HomeBusinessItemBinderNewLogic.this, this.f$1, view);
                    }
                });
                this.f43097g.setData(CollectionsKt.mutableListOf(homeBusinessInfoRvModel.mRecInfo), this.f43099i);
                this.f43096f.setVisibility(this.f43097g.getVisibility());
            }
        }
        this.f43097g.setVisibility(8);
        this.f43096f.setVisibility(this.f43097g.getVisibility());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m30500c(HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessItemBinderNewLogic != null) {
            homeBusinessItemBinderNewLogic.onItemClick(homeBusinessInfoRvModel);
        }
    }

    public final void setViewWidth(int i) {
        this.f43099i = i;
    }

    public final void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        CharSequence charSequence = homeBusinessInfoRvModel.mHonorIconUrl;
        if ((charSequence == null || charSequence.length() == 0) || !this.f43100j) {
            this.f43095e.setVisibility(8);
        } else {
            this.f43095e.setVisibility(0);
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mHonorIconUrl).transform(new RoundedCornersTransformation(getContext(), 0, 0, this.f43098h, true)).into(this.f43095e);
        }
        m30495a(homeBusinessInfoRvModel);
        m30496a(homeBusinessInfoRvModel, homeBusinessItemBinderNewLogic);
        m30499b(homeBusinessInfoRvModel, homeBusinessItemBinderNewLogic);
        m30498b(homeBusinessInfoRvModel);
        m30501c(homeBusinessInfoRvModel, homeBusinessItemBinderNewLogic);
    }
}
