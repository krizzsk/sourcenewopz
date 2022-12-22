package com.didi.soda.home.component.feed.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.CustomerSkinTextView;
import com.didi.soda.home.component.feed.adapter.HomeEfoListAdapter;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "homeEfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;", "efoListener", "Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoListener;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoListener;)V", "mEfoGoodsList", "", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "mLogoRadius", "", "mRadius", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "rvModel", "Companion", "EfoListener", "EfoMoreHolder", "EfoNormalHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeEfoListAdapter.kt */
public final class HomeEfoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g */
    private static final int f42579g = 0;

    /* renamed from: h */
    private static final int f42580h = 1;

    /* renamed from: a */
    private final Context f42581a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HomeEfoRvModel f42582b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EfoListener f42583c;

    /* renamed from: d */
    private List<? extends BusinessGoodsItemRvModel> f42584d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f42585e = ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f42586f = ResourceHelper.getDimensionPixelSize(R.dimen.customer_4px);

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoListener;", "", "onEfoBuyButtonClicked", "", "position", "", "item", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "onEfoItemClicked", "onEfoItemExposured", "onEfoMoreClicked", "homeEfoRvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeEfoRvModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoListAdapter.kt */
    public interface EfoListener {
        void onEfoBuyButtonClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        void onEfoItemClicked(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        void onEfoItemExposured(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        void onEfoMoreClicked(HomeEfoRvModel homeEfoRvModel);
    }

    public HomeEfoListAdapter(Context context, HomeEfoRvModel homeEfoRvModel, EfoListener efoListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "homeEfoRvModel");
        Intrinsics.checkNotNullParameter(efoListener, "efoListener");
        this.f42581a = context;
        this.f42582b = homeEfoRvModel;
        this.f42583c = efoListener;
        List<BusinessGoodsItemRvModel> list = this.f42582b.mEfoGoodsList;
        Intrinsics.checkNotNullExpressionValue(list, "homeEfoRvModel.mEfoGoodsList");
        this.f42584d = list;
    }

    public int getItemCount() {
        return this.f42582b.mEfoGoodsList.size() + 1;
    }

    public int getItemViewType(int i) {
        return i == getItemCount() - 1 ? 1 : 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (getItemViewType(i) == 1) {
            if (viewHolder instanceof EfoMoreHolder) {
                ((EfoMoreHolder) viewHolder).bind();
            }
        } else if (viewHolder instanceof EfoNormalHolder) {
            Context context = viewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            ((EfoNormalHolder) viewHolder).bind(context, i, (BusinessGoodsItemRvModel) this.f42584d.get(i));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_efo_common, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                layoutParams2.width = ResourceHelper.getDimensionPixelSize(R.dimen.customer_302px);
                inflate.setLayoutParams(layoutParams2);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new EfoNormalHolder(this, inflate);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_efo_more, viewGroup, false);
        ViewGroup.LayoutParams layoutParams3 = inflate2.getLayoutParams();
        if (layoutParams3 != null) {
            RecyclerView.LayoutParams layoutParams4 = (RecyclerView.LayoutParams) layoutParams3;
            layoutParams4.width = ResourceHelper.getDimensionPixelSize(R.dimen.customer_302px);
            inflate2.setLayoutParams(layoutParams4);
            Intrinsics.checkNotNullExpressionValue(inflate2, "view");
            return new EfoMoreHolder(this, inflate2);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final void setData(HomeEfoRvModel homeEfoRvModel) {
        Intrinsics.checkNotNullParameter(homeEfoRvModel, "rvModel");
        this.f42582b = homeEfoRvModel;
        List<BusinessGoodsItemRvModel> list = homeEfoRvModel.mEfoGoodsList;
        Intrinsics.checkNotNullExpressionValue(list, "rvModel.mEfoGoodsList");
        this.f42584d = list;
        notifyDataSetChanged();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter;Landroid/view/View;)V", "mTvMore", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "bind", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoListAdapter.kt */
    public final class EfoMoreHolder extends RecyclerView.ViewHolder {
        private CustomerAppCompatTextView mTvMore;
        final /* synthetic */ HomeEfoListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EfoMoreHolder(HomeEfoListAdapter homeEfoListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(homeEfoListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = homeEfoListAdapter;
            View findViewById = view.findViewById(R.id.customer_tv_home_efo_more);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…ustomer_tv_home_efo_more)");
            this.mTvMore = (CustomerAppCompatTextView) findViewById;
        }

        public final void bind() {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeEfoListAdapter.EfoMoreHolder.m46938bind$lambda0(HomeEfoListAdapter.this, view);
                }
            });
            CustomerAppCompatTextView customerAppCompatTextView = this.mTvMore;
            String str = this.this$0.f42582b.mMoreTitle;
            if (str == null) {
                str = null;
            }
            customerAppCompatTextView.setText(str);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ResourceHelper.getColor(R.color.rf_color_gery_11_100_9AFFFFFF));
            gradientDrawable.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px));
            this.itemView.setBackground(gradientDrawable);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m46938bind$lambda0(HomeEfoListAdapter homeEfoListAdapter, View view) {
            Intrinsics.checkNotNullParameter(homeEfoListAdapter, "this$0");
            homeEfoListAdapter.f42583c.onEfoMoreClicked(homeEfoListAdapter.f42582b);
        }
    }

    @Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001aJ\b\u0010\"\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$EfoNormalHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter;Landroid/view/View;)V", "mBuyButton", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mDishLabel", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMDishLabel", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMDishLabel", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "mDishName", "mEfoDishImageView", "Landroid/widget/ImageView;", "mItemMarkView", "mLogo", "mOrignPrice", "mPrice", "Lcom/didi/soda/customer/widget/text/CustomerSkinTextView;", "mPriceLayout", "Landroid/widget/LinearLayout;", "mRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bind", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "restoreDefaultRelation", "setLineFeed", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoListAdapter.kt */
    public final class EfoNormalHolder extends RecyclerView.ViewHolder {
        private RFMainButton mBuyButton;
        private CustomerAppCompatTextView mDishLabel;
        private CustomerAppCompatTextView mDishName;
        private ImageView mEfoDishImageView;
        private View mItemMarkView;
        private ImageView mLogo;
        private CustomerAppCompatTextView mOrignPrice;
        private CustomerSkinTextView mPrice;
        private LinearLayout mPriceLayout;
        private ConstraintLayout mRoot;
        final /* synthetic */ HomeEfoListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EfoNormalHolder(HomeEfoListAdapter homeEfoListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(homeEfoListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = homeEfoListAdapter;
            View findViewById = view.findViewById(R.id.customer_cl_efo_item_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…ustomer_cl_efo_item_root)");
            this.mRoot = (ConstraintLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.customer_iv_efo_dish_image);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…stomer_iv_efo_dish_image)");
            this.mEfoDishImageView = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.customer_tv_home_efo_label);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…stomer_tv_home_efo_label)");
            this.mDishLabel = (CustomerAppCompatTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.customer_tv_home_efo_dish_name);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…er_tv_home_efo_dish_name)");
            this.mDishName = (CustomerAppCompatTextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.customer_ll_home_efo_price);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.…stomer_ll_home_efo_price)");
            this.mPriceLayout = (LinearLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.customer_tv_home_efo_price);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.…stomer_tv_home_efo_price)");
            this.mPrice = (CustomerSkinTextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.customer_tv_home_efo_orign_price);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.…_tv_home_efo_orign_price)");
            this.mOrignPrice = (CustomerAppCompatTextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.customer_btn_home_efo_buy);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.…ustomer_btn_home_efo_buy)");
            this.mBuyButton = (RFMainButton) findViewById8;
            View findViewById9 = view.findViewById(R.id.customer_iv_home_efo_logo);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.…ustomer_iv_home_efo_logo)");
            this.mLogo = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(R.id.customer_view_home_efo_mark);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…tomer_view_home_efo_mark)");
            this.mItemMarkView = findViewById10;
        }

        public final CustomerAppCompatTextView getMDishLabel() {
            return this.mDishLabel;
        }

        public final void setMDishLabel(CustomerAppCompatTextView customerAppCompatTextView) {
            Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
            this.mDishLabel = customerAppCompatTextView;
        }

        public final void bind(Context context, int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            Unit unit;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "item");
            this.itemView.setOnClickListener(new View.OnClickListener(i, businessGoodsItemRvModel) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ BusinessGoodsItemRvModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    HomeEfoListAdapter.EfoNormalHolder.m46939bind$lambda0(HomeEfoListAdapter.this, this.f$1, this.f$2, view);
                }
            });
            FlyImageLoader.loadImage1x1(context, businessGoodsItemRvModel.mHeadImg).placeholder((Drawable) BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_img_business_goods_item_x11, this.this$0.f42585e)).transform(new RoundedCornersTransformation(context, this.this$0.f42585e, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.mEfoDishImageView);
            String str = businessGoodsItemRvModel.mActLabel;
            String str2 = null;
            if (str == null) {
                unit = null;
            } else {
                getMDishLabel().setVisibility(0);
                getMDishLabel().setText(str);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                getMDishLabel().setVisibility(8);
            }
            CustomerAppCompatTextView customerAppCompatTextView = this.mDishName;
            String str3 = businessGoodsItemRvModel.mGoodsName;
            if (str3 == null) {
                str3 = null;
            }
            customerAppCompatTextView.setText(str3);
            CustomerSkinTextView customerSkinTextView = this.mPrice;
            String str4 = businessGoodsItemRvModel.mSpecialPriceDisplay;
            if (str4 != null) {
                str2 = str4;
            }
            customerSkinTextView.setText(str2);
            CustomerAppCompatTextView customerAppCompatTextView2 = this.mOrignPrice;
            CharSequence charSequence = businessGoodsItemRvModel.mPriceCharSequenceDisplay;
            if (charSequence == null) {
            }
            customerAppCompatTextView2.setText(charSequence);
            this.mBuyButton.setOnClickListener(new View.OnClickListener(i, businessGoodsItemRvModel) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ BusinessGoodsItemRvModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    HomeEfoListAdapter.EfoNormalHolder.m46940bind$lambda3(HomeEfoListAdapter.this, this.f$1, this.f$2, view);
                }
            });
            this.mBuyButton.setText(businessGoodsItemRvModel.mBuyDesc);
            restoreDefaultRelation();
            if (businessGoodsItemRvModel.mIsLineFeed) {
                setLineFeed();
            }
            ViewGroup.LayoutParams layoutParams = this.mBuyButton.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).width = businessGoodsItemRvModel.mBuyButtonWidth;
                if (!TextUtils.isEmpty(businessGoodsItemRvModel.mLogoImg)) {
                    this.mLogo.setVisibility(0);
                    FlyImageLoader.loadImage1x1(context, businessGoodsItemRvModel.mLogoImg).placeholder((Drawable) BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_icon_business_round_logo, this.this$0.f42586f)).error((Drawable) BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_icon_business_round_logo, this.this$0.f42586f)).transform(new RoundedCornersTransformation(context, this.this$0.f42586f, 0, RoundedCornersTransformation.CornerType.BOTTOM, true)).into(this.mLogo);
                    return;
                }
                this.mLogo.setVisibility(8);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m46939bind$lambda0(HomeEfoListAdapter homeEfoListAdapter, int i, BusinessGoodsItemRvModel businessGoodsItemRvModel, View view) {
            Intrinsics.checkNotNullParameter(homeEfoListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$item");
            homeEfoListAdapter.f42583c.onEfoItemClicked(i, businessGoodsItemRvModel);
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-3  reason: not valid java name */
        public static final void m46940bind$lambda3(HomeEfoListAdapter homeEfoListAdapter, int i, BusinessGoodsItemRvModel businessGoodsItemRvModel, View view) {
            Intrinsics.checkNotNullParameter(homeEfoListAdapter, "this$0");
            Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$item");
            homeEfoListAdapter.f42583c.onEfoBuyButtonClicked(i, businessGoodsItemRvModel);
        }

        public final void restoreDefaultRelation() {
            if (this.mBuyButton.getTag() != null) {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(this.mRoot);
                constraintSet.clear(this.mBuyButton.getId());
                constraintSet.constrainHeight(this.mBuyButton.getId(), -2);
                constraintSet.connect(this.mBuyButton.getId(), 7, 0, 7);
                constraintSet.connect(this.mBuyButton.getId(), 4, this.mPriceLayout.getId(), 4);
                constraintSet.applyTo(this.mRoot);
                this.mBuyButton.setTag((Object) null);
            }
        }

        private final void setLineFeed() {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.mRoot);
            constraintSet.clear(this.mBuyButton.getId());
            constraintSet.constrainHeight(this.mBuyButton.getId(), -2);
            constraintSet.connect(this.mBuyButton.getId(), 6, 0, 6);
            constraintSet.connect(this.mBuyButton.getId(), 3, this.mPriceLayout.getId(), 4, ResourceHelper.getDimensionPixelSize(R.dimen.customer_12px));
            constraintSet.applyTo(this.mRoot);
            this.mBuyButton.setTag(true);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/component/feed/adapter/HomeEfoListAdapter$Companion;", "", "()V", "HOME_EFO_ITEM_MORE", "", "HOME_EFO_ITEM_NORMAL", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeEfoListAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
