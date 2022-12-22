package com.didi.soda.home.component.feed.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.banner.OnBannerClickListener;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CouponTagFlowLayoutView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.HomeLogoPromotionView;
import com.taxis99.R;
import java.util.List;

public class HomeHorizontalScrollTopicAdapter extends RecyclerView.Adapter<ScrollLargeViewHolder> {

    /* renamed from: a */
    private List<HomeBusinessInfoRvModel> f42587a;

    /* renamed from: b */
    private OnBannerClickListener f42588b;

    /* renamed from: c */
    private RoundedBitmapDrawable f42589c;

    /* renamed from: d */
    private int f42590d;

    public HomeHorizontalScrollTopicAdapter(OnBannerClickListener onBannerClickListener, Context context) {
        int dip2px = DisplayUtils.dip2px(context, 4.0f);
        this.f42590d = dip2px;
        this.f42588b = onBannerClickListener;
        this.f42589c = BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_img_placeholder_x43, dip2px);
    }

    public int getItemCount() {
        return this.f42587a.size();
    }

    public void onBindViewHolder(ScrollLargeViewHolder scrollLargeViewHolder, int i) {
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f42587a.get(i);
        FlyImageLoader.loadImage4x3(scrollLargeViewHolder.itemView.getContext(), homeBusinessInfoRvModel.mBgImg).placeholder((Drawable) this.f42589c).centerCrop().transform(new RoundedCornersTransformation(scrollLargeViewHolder.itemView.getContext(), this.f42590d, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(scrollLargeViewHolder.mBusinessImage);
        scrollLargeViewHolder.mLogo.bindData((String) null, homeBusinessInfoRvModel.mLogoImg);
        scrollLargeViewHolder.mBusinessName.setText(homeBusinessInfoRvModel.mShopName);
        int screenWidth = (int) (((float) (DisplayUtils.getScreenWidth(scrollLargeViewHolder.mTip.getContext()) - scrollLargeViewHolder.mTip.getContext().getResources().getDimensionPixelOffset(R.dimen.customer_94px))) * 0.47f);
        if (homeBusinessInfoRvModel.mActTip == null || TextUtils.isEmpty(homeBusinessInfoRvModel.mActTip.content)) {
            scrollLargeViewHolder.mTip.setVisibility(4);
        } else {
            scrollLargeViewHolder.mTip.setData(homeBusinessInfoRvModel.mActTip, screenWidth);
            scrollLargeViewHolder.mTip.setVisibility(0);
        }
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(scrollLargeViewHolder.mBusinessName, IToolsService.FontType.MEDIUM);
        scrollLargeViewHolder.mBusinessMask.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeHorizontalScrollTopicAdapter.this.m30046a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30046a(int i, View view) {
        OnBannerClickListener onBannerClickListener = this.f42588b;
        if (onBannerClickListener != null) {
            onBannerClickListener.onBannerClick(i);
        }
    }

    public ScrollLargeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ScrollLargeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_scroll_topic, viewGroup, false));
    }

    public void setData(List<HomeBusinessInfoRvModel> list) {
        this.f42587a = list;
        notifyDataSetChanged();
    }

    static class ScrollLargeViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final ImageView mBusinessImage;
        /* access modifiers changed from: private */
        public final View mBusinessMask;
        /* access modifiers changed from: private */
        public final TextView mBusinessName;
        /* access modifiers changed from: private */
        public final HomeLogoPromotionView mLogo;
        /* access modifiers changed from: private */
        public final CouponTagFlowLayoutView mTip;

        ScrollLargeViewHolder(View view) {
            super(view);
            this.mBusinessImage = (ImageView) view.findViewById(R.id.customer_iv_business_image);
            int screenWidth = (int) (((float) (DisplayUtils.getScreenWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelOffset(R.dimen.customer_94px))) * 0.47f);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams.width = screenWidth;
            view.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mBusinessImage.getLayoutParams();
            layoutParams2.width = screenWidth;
            layoutParams2.height = (int) (((float) (layoutParams2.width * 3)) / 4.0f);
            this.mBusinessImage.setLayoutParams(layoutParams2);
            this.mLogo = (HomeLogoPromotionView) view.findViewById(R.id.customer_custom_logo_promotion);
            this.mBusinessMask = view.findViewById(R.id.customer_view_icon_mark);
            this.mBusinessName = (TextView) view.findViewById(R.id.customer_tv_business_name);
            this.mTip = (CouponTagFlowLayoutView) view.findViewById(R.id.customer_tv_cate_tips);
        }
    }
}
