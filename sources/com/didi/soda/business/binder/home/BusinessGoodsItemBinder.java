package com.didi.soda.business.binder.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.listener.GoodsItemClickListener;
import com.didi.soda.business.listener.OnPlayAnimationListener;
import com.didi.soda.business.manager.Add2CartAnimManager;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.business.GoodsNameAmountView;
import com.didi.soda.customer.widget.goods.GoodsStateBar;
import com.didi.soda.customer.widget.goods.add.NormalGoodsAddView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.taxis99.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public abstract class BusinessGoodsItemBinder extends ItemBinder<BusinessGoodsItemRvModel, ViewHolder> implements GoodsItemClickListener, OnPlayAnimationListener {
    private static final int ANCHOR_ANIMATION_END_COLOR = -1;
    private static final String ANCHOR_ANIMATION_PROPERTY_NAME = "color";
    private Context mContext;
    /* access modifiers changed from: private */
    public ScopeContext mScopeContext;

    public abstract void onGoodsItemShow(BusinessGoodsItemRvModel businessGoodsItemRvModel);

    public BusinessGoodsItemBinder(ScopeContext scopeContext, ItemDecorator itemDecorator) {
        super(itemDecorator);
        this.mScopeContext = scopeContext;
    }

    public BusinessGoodsItemBinder() {
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_binder_business_goods_item, viewGroup, false);
        this.mContext = viewGroup.getContext();
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        ViewHolder viewHolder2 = viewHolder;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        Context context = viewHolder2.mGoodImageContainer.getContext();
        GoodsItemState goodsItemState = businessGoodsItemRvModel2.mGoodsAmountModel.mGoodsItemState;
        if (TextUtils.isEmpty(businessGoodsItemRvModel2.mHeadImg)) {
            if (GoodsDataHelper.isSoldOutOrLimitSale(goodsItemState)) {
                viewHolder2.mGoodImageContainer.setVisibility(0);
                viewHolder2.mGoodsImageIv.setImageDrawable(BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_img_business_goods_item_x11, DisplayUtils.dip2px(context, 4.0f)));
            } else {
                viewHolder2.mGoodImageContainer.setVisibility(8);
                viewHolder2.mGoodsImageIv.setImageDrawable((Drawable) null);
            }
            viewHolder2.mGoodImageContainer.setOnClickListener((View.OnClickListener) null);
        } else {
            viewHolder2.mGoodImageContainer.setOnClickListener(new View.OnClickListener(viewHolder2, businessGoodsItemRvModel2) {
                public final /* synthetic */ BusinessGoodsItemBinder.ViewHolder f$1;
                public final /* synthetic */ BusinessGoodsItemRvModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    BusinessGoodsItemBinder.this.lambda$bind$0$BusinessGoodsItemBinder(this.f$1, this.f$2, view);
                }
            });
            viewHolder2.mGoodImageContainer.setVisibility(0);
            FlyImageLoader.loadImage1x1(context, businessGoodsItemRvModel2.mHeadImg).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 4.0f), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(viewHolder2.mGoodsImageIv);
        }
        if (goodsItemState == GoodsItemState.SOLD_OUT) {
            viewHolder2.mExceptionStatusTv.setVisibility(0);
            viewHolder2.mExceptionStatusTv.setText(context.getResources().getText(R.string.customer_global_sold_out));
            viewHolder2.mExceptionStatusTv.setTextSize(1, 12.0f);
        } else if (goodsItemState != GoodsItemState.LIMIT_SALE || TextUtils.isEmpty(businessGoodsItemRvModel2.mSoldTimeDesc)) {
            viewHolder2.mExceptionStatusTv.setVisibility(8);
        } else {
            viewHolder2.mExceptionStatusTv.setVisibility(0);
            viewHolder2.mExceptionStatusTv.setText(businessGoodsItemRvModel2.mSoldTimeDesc);
            viewHolder2.mExceptionStatusTv.setTextSize(1, 10.0f);
        }
        viewHolder2.mGoodsNameAmountView.updateGoodsNameWithAmount(businessGoodsItemRvModel2.mGoodsName, businessGoodsItemRvModel2.mGoodsAmountModel.getCurrentAmount());
        if (!TextUtils.isEmpty(businessGoodsItemRvModel2.mShortDesc)) {
            viewHolder2.mGoodsDescTv.setVisibility(0);
            viewHolder2.mGoodsDescTv.setText(businessGoodsItemRvModel2.mShortDesc);
        } else {
            viewHolder2.mGoodsDescTv.setVisibility(8);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) viewHolder2.mCardContainer.getBackground().mutate();
        if (businessGoodsItemRvModel2.mIsAnchorItem) {
            gradientDrawable.setColor(ResourceHelper.getColor(R.color.rf_color_press_1_100));
        } else {
            gradientDrawable.setColor(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
        }
        if (businessGoodsItemRvModel2.mAddToCartAnimation) {
            businessGoodsItemRvModel2.mAddToCartAnimation = false;
            View createVirtualGoodsView = createVirtualGoodsView(viewHolder);
            viewHolder2.mAddContainer.addView(createVirtualGoodsView);
            createBackgroundAnimation(viewHolder2, createVirtualGoodsView);
        }
        String str = businessGoodsItemRvModel2.mSpecialPrice >= 0 ? businessGoodsItemRvModel2.mSpecialPriceDisplay : businessGoodsItemRvModel2.mPriceDisplay;
        String str2 = businessGoodsItemRvModel2.mSpecialPrice >= 0 ? businessGoodsItemRvModel2.mPriceDisplay : "";
        if (TextUtils.isEmpty(businessGoodsItemRvModel2.mHeadImg)) {
            i = DisplayUtils.getScreenWidth(context);
        } else {
            i = DisplayUtils.getScreenWidth(context) - DisplayUtils.dip2px(context, 130.0f);
        }
        viewHolder2.mGoodsStateBar.setPrice(str, str2).setMaxPriceWidth(i).setMarketingTip(businessGoodsItemRvModel2.mMarketingTipSpan).setGoodsAmountModel(businessGoodsItemRvModel2.mGoodsAmountModel).setActTag(businessGoodsItemRvModel2.mActTagList);
        handleGoodsAddView(viewHolder, businessGoodsItemRvModel);
        handleGoodsClickEvent(viewHolder, businessGoodsItemRvModel);
        onGoodsItemShow(businessGoodsItemRvModel2);
    }

    public /* synthetic */ void lambda$bind$0$BusinessGoodsItemBinder(ViewHolder viewHolder, BusinessGoodsItemRvModel businessGoodsItemRvModel, View view) {
        onGoodsImageClick(viewHolder.mGoodsImageIv, businessGoodsItemRvModel);
    }

    public Class<BusinessGoodsItemRvModel> bindDataType() {
        return BusinessGoodsItemRvModel.class;
    }

    private void handleGoodsClickEvent(ViewHolder viewHolder, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(businessGoodsItemRvModel) {
            public final /* synthetic */ BusinessGoodsItemRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessGoodsItemBinder.this.lambda$handleGoodsClickEvent$1$BusinessGoodsItemBinder(this.f$1, view);
            }
        });
        if (businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState == GoodsItemState.FOR_SALE) {
            viewHolder.mAddContainer.setOnClickListener(new View.OnClickListener(businessGoodsItemRvModel, viewHolder) {
                public final /* synthetic */ BusinessGoodsItemRvModel f$1;
                public final /* synthetic */ BusinessGoodsItemBinder.ViewHolder f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    BusinessGoodsItemBinder.this.lambda$handleGoodsClickEvent$2$BusinessGoodsItemBinder(this.f$1, this.f$2, view);
                }
            });
        } else {
            viewHolder.mAddContainer.setOnClickListener((View.OnClickListener) null);
        }
    }

    public /* synthetic */ void lambda$handleGoodsClickEvent$1$BusinessGoodsItemBinder(BusinessGoodsItemRvModel businessGoodsItemRvModel, View view) {
        onGoodsItemClick(businessGoodsItemRvModel);
    }

    public /* synthetic */ void lambda$handleGoodsClickEvent$2$BusinessGoodsItemBinder(BusinessGoodsItemRvModel businessGoodsItemRvModel, ViewHolder viewHolder, View view) {
        if (isPlayAddCartAnimation(businessGoodsItemRvModel)) {
            View createVirtualGoodsView = createVirtualGoodsView(viewHolder);
            viewHolder.mAddContainer.addView(createVirtualGoodsView);
            createBackgroundAnimation(viewHolder, createVirtualGoodsView);
        }
        onGoodsAddClick(businessGoodsItemRvModel);
    }

    private boolean isPlayAddCartAnimation(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        return !CheckCartMaxNumKt.isReachMaxNum(this.mScopeContext, businessGoodsItemRvModel.mBusinessId, businessGoodsItemRvModel.mItemUniqKey, (String) null, 1, (Function0<Unit>) null) && !businessGoodsItemRvModel.hasMultipleContents && !businessGoodsItemRvModel.mNeedAlcoholRemind;
    }

    private View createVirtualGoodsView(ViewHolder viewHolder) {
        int width = viewHolder.mGoodsAddView.getWidth();
        View view = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px));
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        view.setAlpha(0.25f);
        view.setBackgroundResource(R.drawable.customer_skin_add_view_virtual_animation_bg);
        return view;
    }

    private void createBackgroundAnimation(final ViewHolder viewHolder, final View view) {
        if (view != null) {
            Add2CartAnimManager.createAndStartBackgroundAnimation(viewHolder.mGoodsAddView, view, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    IFloatingCartProvider iFloatingCartProvider;
                    super.onAnimationEnd(animator);
                    if (BusinessGoodsItemBinder.this.mScopeContext != null && BusinessGoodsItemBinder.this.mScopeContext.getObject("service_floating_cart_key") != null && (iFloatingCartProvider = (IFloatingCartProvider) BusinessGoodsItemBinder.this.mScopeContext.getObject("service_floating_cart_key")) != null) {
                        iFloatingCartProvider.playAddToCartAnimation(true);
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        viewHolder.mAddContainer.removeView(view);
                        BusinessGoodsItemBinder.this.playAddCartAnimation(iArr);
                    }
                }
            });
        }
    }

    private void handleGoodsAddView(ViewHolder viewHolder, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        viewHolder.mGoodsAddView.updateViewModel(NormalGoodsAddView.NormalGoodsAddViewModel.newInstance(businessGoodsItemRvModel));
    }

    static class ViewHolder extends ItemViewHolder<BusinessGoodsItemRvModel> {
        FrameLayout mAddContainer;
        View mCardContainer;
        TextView mExceptionStatusTv;
        View mGoodImageContainer;
        NormalGoodsAddView mGoodsAddView;
        TextView mGoodsDescTv;
        ImageView mGoodsImageIv;
        View mGoodsMaskView;
        GoodsNameAmountView mGoodsNameAmountView;
        GoodsStateBar mGoodsStateBar;

        ViewHolder(View view) {
            super(view);
            this.mGoodImageContainer = view.findViewById(R.id.customer_iv_goods_image_layout);
            this.mGoodsImageIv = (ImageView) view.findViewById(R.id.customer_iv_goods_image);
            this.mGoodsDescTv = (TextView) view.findViewById(R.id.customer_tv_goods_desc);
            this.mGoodsStateBar = (GoodsStateBar) view.findViewById(R.id.customer_custom_business_goods_state_bar);
            this.mGoodsNameAmountView = (GoodsNameAmountView) view.findViewById(R.id.customer_view_goods_name_with_amount);
            this.mGoodsAddView = (NormalGoodsAddView) view.findViewById(R.id.customer_custom_business_goods_add_view);
            this.mAddContainer = (FrameLayout) view.findViewById(R.id.customer_fl_add_container);
            this.mGoodsMaskView = view.findViewById(R.id.customer_view_layout_mark);
            this.mCardContainer = view.findViewById(R.id.customer_card_container);
            this.mExceptionStatusTv = (TextView) view.findViewById(R.id.customer_tv_status);
        }
    }
}
