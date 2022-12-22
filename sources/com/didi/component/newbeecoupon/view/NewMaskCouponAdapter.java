package com.didi.component.newbeecoupon.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.newbeecoupon.util.NewbeeCouponUtil;
import com.taxis99.R;
import java.util.Collection;

public class NewMaskCouponAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private static final int f14686a = 0;

    /* renamed from: b */
    private static final int f14687b = 1;

    /* renamed from: c */
    private HomeNewCouponModel f14688c;

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new NewCouponHeadVH(viewGroup) : new NewCouponCardVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof NewCouponHeadVH) {
            HomeNewCouponModel homeNewCouponModel = this.f14688c;
            if (homeNewCouponModel != null) {
                ((NewCouponHeadVH) viewHolder).bindDate(homeNewCouponModel.topText);
                return;
            }
            return;
        }
        HomeNewCouponModel homeNewCouponModel2 = this.f14688c;
        if (homeNewCouponModel2 != null && homeNewCouponModel2.couponInfos != null) {
            ((NewCouponCardVH) viewHolder).bindData(this.f14688c.couponInfos.get(i - 1));
        }
    }

    public int getItemCount() {
        HomeNewCouponModel homeNewCouponModel = this.f14688c;
        if (homeNewCouponModel == null || CollectionUtils.isEmpty((Collection) homeNewCouponModel.couponInfos)) {
            return 1;
        }
        return this.f14688c.couponInfos.size() + 1;
    }

    public void setData(HomeNewCouponModel homeNewCouponModel) {
        this.f14688c = homeNewCouponModel;
    }

    private class NewCouponCardVH extends RecyclerView.ViewHolder {
        private TextView mCouponDesc = ((TextView) this.itemView.findViewById(R.id.g_new_coupon_other_detail));
        private TextView mCouponDetail = ((TextView) this.itemView.findViewById(R.id.g_new_coupon_detail));
        private TextView mTitle = ((TextView) this.itemView.findViewById(R.id.g_new_coupon_title));

        public NewCouponCardVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_new_user_coupon_item_layout, viewGroup, false));
            this.mTitle.setTextColor(Color.parseColor("#333333"));
            this.mCouponDetail.setTextColor(Color.parseColor("#fea330"));
            this.mCouponDesc.setTextColor(Color.parseColor("#999999"));
        }

        public void bindData(HomeNewCouponModel.CouponInfo couponInfo) {
            if (couponInfo != null) {
                this.mTitle.setText(couponInfo.titleText);
                this.mCouponDetail.setText(NewbeeCouponUtil.getBoldAndSizeStyleText(couponInfo.couponText, 26));
                this.mCouponDesc.setText(couponInfo.tipText);
            }
        }
    }

    private class NewCouponHeadVH extends RecyclerView.ViewHolder {
        private TextView mContentTv;
        private ImageView mImageView = ((ImageView) this.itemView.findViewById(R.id.g_new_coupon_head_img));

        public NewCouponHeadVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_new_user_coupon_head_item, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.g_new_coupon_head_content);
            this.mContentTv = textView;
            textView.setTextColor(Color.parseColor("#000000"));
            this.mImageView.setImageResource(R.drawable.global_new_coupon_dialog_head_yellow_bg);
        }

        public void bindDate(String str) {
            this.mContentTv.setText(str);
        }
    }
}
