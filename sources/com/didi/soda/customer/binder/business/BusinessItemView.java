package com.didi.soda.customer.binder.business;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.CustomerMvpItemView;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.business.BusinessInfoRvModel;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.push.model.AnchorInfoModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CircleImageView;
import com.didi.soda.customer.widget.business.BusinessExceptionStatusView;
import com.didi.soda.customer.widget.home.HomeBusinessAttributeTagView;
import com.didi.soda.customer.widget.home.HomeBusinessDiscountTagView;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.router.DiRouter;
import com.didi.soda.search.helper.SearchOmegaHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;

public class BusinessItemView extends CustomerMvpItemView<BusinessItemPresenter, BusinessInfoRvModel, ViewHolder> {

    /* renamed from: a */
    private static final String f40406a = "BusinessItemPresenter";

    /* access modifiers changed from: protected */
    public void updateView(ViewHolder viewHolder) {
        viewHolder.bind(getContext());
    }

    static class ViewHolder extends StaggerItemViewHolder<BusinessInfoRvModel> {
        ImageView mBusinessBgIv = ((ImageView) findViewById(R.id.iv_business_image));
        ImageView mBusinessBgMaskIv = ((ImageView) findViewById(R.id.customer_iv_business_image_mask));
        TextView mBusinessCateTv = ((TextView) findViewById(R.id.customer_tv_cate_tips));
        ImageView mBusinessDeliveryFree = ((ImageView) findViewById(R.id.iv_delivery_free));
        View mBusinessDeliveryInfoContainer = ((View) findViewById(R.id.ll_delivery_info_container));
        TextView mBusinessDeliveryTv = ((TextView) findViewById(R.id.tv_delivery_time));
        View mBusinessDescContainer = ((View) findViewById(R.id.customer_ll_business_desc_container));
        BusinessExceptionStatusView mBusinessExceptionStatusView = ((BusinessExceptionStatusView) findViewById(R.id.customer_custom_business_exception_status));
        CircleImageView mBusinessLogoIv = ((CircleImageView) findViewById(R.id.iv_business_logo));
        CircleImageView mBusinessLogoMask = ((CircleImageView) findViewById(R.id.customer_iv_business_logo_mask));
        TextView mBusinessNameTv = ((TextView) findViewById(R.id.txt_business_name));
        View mItemContainerMark = ((View) findViewById(R.id.customer_view_layout_mark));
        NovaFlowLayout mTagFlowLayout = ((NovaFlowLayout) findViewById(R.id.customer_view_tag_flow));

        ViewHolder(View view) {
            super(view);
        }

        public void bind(Context context) {
            setTransitionName();
            if (TextUtils.isEmpty(((BusinessInfoRvModel) getItem()).mLogoImg)) {
                this.mBusinessLogoIv.setVisibility(8);
                this.mBusinessLogoMask.setVisibility(8);
            } else {
                this.mBusinessLogoIv.setVisibility(0);
                FlyImageLoader.loadImage1x1(context, ((BusinessInfoRvModel) getItem()).mLogoImg).placeholder((int) R.drawable.customer_img_business_default_logo).error((int) R.drawable.customer_img_business_default_logo).into((ImageView) this.mBusinessLogoIv);
                if (((BusinessInfoRvModel) getItem()).mMask) {
                    this.mBusinessLogoMask.setVisibility(0);
                } else {
                    this.mBusinessLogoMask.setVisibility(8);
                }
            }
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mBusinessNameTv, IToolsService.FontType.MEDIUM);
            this.mBusinessNameTv.setText(((BusinessInfoRvModel) getItem()).mShopName);
            this.mItemContainerMark.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DiRouter.request().path(RoutePath.BUSINESS_HOME).putString(Const.PageParams.SHOP_ID, ((BusinessInfoRvModel) ViewHolder.this.getItem()).mShopId).putSerializable(Const.PageParams.TRANSITION_NAMES, ((BusinessInfoRvModel) ViewHolder.this.getItem()).mTransitionNameSet).putInt(Const.PageParams.BUSINESS_ANIMATION_SOURCE, ((BusinessInfoRvModel) ViewHolder.this.getItem()).mSource).putString(Const.PageParams.ANCHOR_INFO, GsonUtil.toJson(new AnchorInfoModel(((BusinessInfoRvModel) ViewHolder.this.getItem()).mAnchorId, ((BusinessInfoRvModel) ViewHolder.this.getItem()).mAnchorType))).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, (Serializable) null).putString(Const.PageParams.BIDATA, ((BusinessInfoRvModel) ViewHolder.this.getItem()).mSource == 2 ? SearchOmegaHelper.genBusinessBiData((BusinessInfoRvModel) ViewHolder.this.getItem(), (SearchFoodItemView.SearchFoodItemModel) null) : null).open();
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.trackBusinessClick((BusinessInfoRvModel) viewHolder.getItem());
                    ViewHolder.this.getLogTracker("onBusinessClick", "c-act|").setOtherParam("shopId", ((BusinessInfoRvModel) ViewHolder.this.getItem()).mShopId).build().info();
                }
            });
            if (((BusinessInfoRvModel) getItem()).mMask) {
                this.mBusinessBgMaskIv.setVisibility(0);
                this.mBusinessBgMaskIv.setAlpha(1.0f);
                this.mBusinessExceptionStatusView.setVisibility(0);
                this.mBusinessExceptionStatusView.updateExceptionStatus(((BusinessInfoRvModel) getItem()).mShopStatus, ((BusinessInfoRvModel) getItem()).mBusinessNextOpenTimeDesc);
                this.mBusinessCateTv.setVisibility(8);
                this.mBusinessDeliveryTv.setVisibility(8);
                this.mBusinessDeliveryFree.setVisibility(8);
                this.mBusinessDeliveryInfoContainer.setVisibility(8);
                this.mTagFlowLayout.setVisibility(8);
            } else {
                this.mBusinessBgMaskIv.setVisibility(0);
                this.mBusinessBgMaskIv.setAlpha(0.0f);
                this.mBusinessExceptionStatusView.setVisibility(8);
                this.mTagFlowLayout.removeAllViews();
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(((BusinessInfoRvModel) getItem()).mShopTip)) {
                    HomeBusinessAttributeTagView homeBusinessAttributeTagView = new HomeBusinessAttributeTagView(context);
                    homeBusinessAttributeTagView.setText(((BusinessInfoRvModel) getItem()).mShopTip);
                    homeBusinessAttributeTagView.setPadding(DisplayUtils.dip2px(context, 6.0f), DisplayUtils.dip2px(context, 4.0f), DisplayUtils.dip2px(context, 6.0f), DisplayUtils.dip2px(context, 3.0f));
                    arrayList.add(homeBusinessAttributeTagView);
                }
                if (!CollectionsUtil.isEmpty(((BusinessInfoRvModel) getItem()).mActTipList)) {
                    for (String text : ((BusinessInfoRvModel) getItem()).mActTipList) {
                        HomeBusinessDiscountTagView homeBusinessDiscountTagView = new HomeBusinessDiscountTagView(context);
                        homeBusinessDiscountTagView.setText(text);
                        arrayList.add(homeBusinessDiscountTagView);
                    }
                }
                if (!CollectionsUtil.isEmpty(arrayList)) {
                    this.mTagFlowLayout.addView(arrayList);
                    this.mTagFlowLayout.setVisibility(0);
                } else {
                    this.mTagFlowLayout.setVisibility(8);
                }
                if (!TextUtils.isEmpty(((BusinessInfoRvModel) getItem()).mDeliveryDesc)) {
                    this.mBusinessDeliveryInfoContainer.setVisibility(0);
                    this.mBusinessDeliveryTv.setText(((BusinessInfoRvModel) getItem()).mDeliveryDesc);
                    this.mBusinessDeliveryTv.setVisibility(0);
                    if (((BusinessInfoRvModel) getItem()).mDeliveryPriceAct == 0) {
                        this.mBusinessDeliveryFree.setVisibility(0);
                        this.mBusinessDeliveryFree.setImageResource(R.drawable.customer_icon_delivery_free);
                    } else {
                        this.mBusinessDeliveryFree.setVisibility(8);
                    }
                } else {
                    this.mBusinessDeliveryInfoContainer.setVisibility(8);
                    this.mBusinessDeliveryTv.setVisibility(8);
                    this.mBusinessDeliveryFree.setVisibility(8);
                }
                if (!TextUtils.isEmpty(((BusinessInfoRvModel) getItem()).mCateTip)) {
                    String[] strArr = null;
                    if (!CollectionsUtil.isEmpty(((BusinessInfoRvModel) getItem()).mCateHighlightKeys)) {
                        strArr = (String[]) ((BusinessInfoRvModel) getItem()).mCateHighlightKeys.toArray(new String[0]);
                    }
                    StringUtils.highlightText(this.mBusinessCateTv, ((BusinessInfoRvModel) getItem()).mCateTip, strArr);
                    this.mBusinessCateTv.setVisibility(0);
                } else {
                    this.mBusinessCateTv.setVisibility(8);
                }
            }
            onBusinessShow((BusinessInfoRvModel) getItem());
        }

        private void setTransitionName() {
            if (((BusinessInfoRvModel) getItem()).mTransitionNameSet != null) {
                ViewCompat.setTransitionName(this.mBusinessBgIv, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mImageTransitionName);
                ViewCompat.setTransitionName(this.mBusinessNameTv, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mNameTransitionName);
                ViewCompat.setTransitionName(this.mBusinessLogoIv, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mLogoTransitionName);
                ViewCompat.setTransitionName(this.mBusinessLogoMask, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mLogoMaskTransitionName);
                ViewCompat.setTransitionName(this.mBusinessExceptionStatusView, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mExceptionStatusTransitionName);
                ViewCompat.setTransitionName(this.mBusinessDescContainer, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mDescContainerTransitionName);
                ViewCompat.setTransitionName(this.mBusinessBgMaskIv, ((BusinessInfoRvModel) getItem()).mTransitionNameSet.mImageMaskTransitionName);
            }
        }

        /* access modifiers changed from: private */
        public void trackBusinessClick(BusinessInfoRvModel businessInfoRvModel) {
            if (businessInfoRvModel.mSource == 2) {
                SearchOmegaHelper.getInstance().setBusinessGuideParam(businessInfoRvModel);
                SearchOmegaHelper.getInstance().trackBusinessClick(businessInfoRvModel);
            }
        }

        private void onBusinessShow(BusinessInfoRvModel businessInfoRvModel) {
            if (businessInfoRvModel.mSource == 2) {
                SearchOmegaHelper.getInstance().itemExposure((BusinessInfoRvModel) getItem());
            }
        }

        /* access modifiers changed from: private */
        public RecordTracker.Builder getLogTracker(String str, String str2) {
            return RecordTracker.Builder.create().setTag(BusinessItemView.f40406a).setLogModule("m-business|").setMessage(str).setLogCategory(str2);
        }
    }

    public static class NormalViewHolder extends ViewHolder {
        /* access modifiers changed from: protected */
        public boolean needFullSpan() {
            return false;
        }

        public NormalViewHolder(View view) {
            super(view);
            Context context = view.getContext();
            int dip2px = DisplayUtils.dip2px(context, 16.0f);
            view.setPadding(dip2px, dip2px, dip2px, dip2px);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBusinessExceptionStatusView.getLayoutParams();
            if (CustomerSystemUtil.getScreenWidth(context) <= 540) {
                marginLayoutParams.bottomMargin = DisplayUtils.dip2px(context, 6.0f);
            } else {
                marginLayoutParams.bottomMargin = 0;
            }
            this.mBusinessExceptionStatusView.setLayoutParams(marginLayoutParams);
        }

        public void bind(Context context) {
            super.bind(context);
            FlyImageLoader.loadImage4x3(context, ((BusinessInfoRvModel) getItem()).mBgImg).placeholder((int) R.drawable.customer_skin_img_placeholder_x43).transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 5.0f), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.mBusinessBgIv);
        }
    }

    public static class LargeViewHolder extends ViewHolder {
        public LargeViewHolder(View view) {
            super(view);
            int dip2px = DisplayUtils.dip2px(view.getContext(), 16.0f);
            view.setPadding(dip2px, dip2px, dip2px, dip2px);
        }

        public void bind(Context context) {
            super.bind(context);
            FlyImageLoader.loadImage4x3(context, ((BusinessInfoRvModel) getItem()).mBgImg).placeholder((int) R.drawable.customer_skin_img_placeholder_x21).transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 5.0f), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.mBusinessBgIv);
        }
    }

    public static class ScrollLargeViewHolder extends ViewHolder {
        /* access modifiers changed from: protected */
        public boolean useStaggerLayout() {
            return false;
        }

        public ScrollLargeViewHolder(View view) {
            super(view);
            int dip2px = DisplayUtils.dip2px(view.getContext(), 16.0f);
            view.setPadding(dip2px, dip2px, dip2px, dip2px);
        }

        public void bind(Context context) {
            super.bind(context);
            FlyImageLoader.loadImage4x3(context, ((BusinessInfoRvModel) getItem()).mBgImg).placeholder((int) R.drawable.customer_skin_img_placeholder_x21).transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 5.0f), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.mBusinessBgIv);
        }
    }
}
