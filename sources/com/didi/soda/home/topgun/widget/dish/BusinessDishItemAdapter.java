package com.didi.soda.home.topgun.widget.dish;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.widget.business.HomeBusinessDishTagView;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BusinessDishItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int CLICK_TYPE_NORMAL_IMAGE = 2;
    public static final int CLICK_TYPE_NORMAL_PURCHASE = 1;
    public static final int CLICK_TYPE_SHOP = 4;
    public static final int CLICK_TYPE_VIEW_MORE = 3;
    public static final int VIEW_TYPE_NORMAL_ITEM = 1;
    public static final int VIEW_TYPE_VIEW_MORE = 2;

    /* renamed from: a */
    private List<SearchFoodItemView.SearchFoodItemModel> f43226a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnItemClickListener f43227b;

    /* renamed from: c */
    private OnItemBindListener f43228c;

    public interface OnItemBindListener {
        void onItemBind(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z);
    }

    public interface OnItemClickListener {
        void onItemClick(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f43227b = onItemClickListener;
    }

    public void setOnItemBindListener(OnItemBindListener onItemBindListener) {
        this.f43228c = onItemBindListener;
    }

    public int getItemViewType(int i) {
        return (i != this.f43226a.size() - 1 || this.f43226a.get(i) == null || this.f43226a.get(i).viewMoreEntity == null) ? 1 : 2;
    }

    public int getItemCount() {
        return this.f43226a.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r0 = r11.f43226a.get(r13);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r12, int r13) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x01fa
            java.util.List<com.didi.soda.customer.widget.search.SearchFoodItemView$SearchFoodItemModel> r0 = r11.f43226a
            if (r0 == 0) goto L_0x01fa
            int r0 = r0.size()
            if (r13 < r0) goto L_0x000e
            goto L_0x01fa
        L_0x000e:
            java.util.List<com.didi.soda.customer.widget.search.SearchFoodItemView$SearchFoodItemModel> r0 = r11.f43226a
            java.lang.Object r0 = r0.get(r13)
            com.didi.soda.customer.widget.search.SearchFoodItemView$SearchFoodItemModel r0 = (com.didi.soda.customer.widget.search.SearchFoodItemView.SearchFoodItemModel) r0
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            int r13 = r11.getItemViewType(r13)
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$OnItemBindListener r1 = r11.f43228c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x002c
            r4 = 2
            if (r13 != r4) goto L_0x0028
            r4 = 1
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            r1.onItemBind(r0, r4)
        L_0x002c:
            if (r13 != r3) goto L_0x012c
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$DishItemViewHolder r12 = (com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter.DishItemViewHolder) r12
            android.view.View r13 = r12.itemView
            android.content.Context r13 = r13.getContext()
            java.lang.String r1 = r0.itemImg
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r13, (java.lang.String) r1)
            r1 = 2131232231(0x7f0805e7, float:1.8080565E38)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = r13.placeholder((int) r1)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = r13.error((int) r1)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = r13.fitCenter()
            com.bumptech.glide.load.resource.bitmap.BitmapTransformation[] r1 = new com.bumptech.glide.load.resource.bitmap.BitmapTransformation[r3]
            com.didi.app.nova.skeleton.image.RoundedCornersTransformation r10 = new com.didi.app.nova.skeleton.image.RoundedCornersTransformation
            android.view.View r4 = r12.itemView
            android.content.Context r5 = r4.getContext()
            android.view.View r4 = r12.itemView
            android.content.Context r4 = r4.getContext()
            r6 = 1096810496(0x41600000, float:14.0)
            int r6 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r4, r6)
            r7 = 0
            com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r8 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.ALL
            r9 = 1
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r1[r2] = r10
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r13 = r13.transform(r1)
            android.widget.ImageView r1 = r12.mDishImageIv
            r13.into((android.widget.ImageView) r1)
            android.widget.TextView r13 = r12.mDishNameTv
            java.lang.String r1 = r0.itemName
            r13.setText(r1)
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r13 = r0.priceInfo
            boolean r13 = com.didi.soda.customer.foundation.util.CollectionsUtil.isEmpty(r13)
            java.lang.String r1 = ""
            if (r13 != 0) goto L_0x00ce
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r13 = r0.priceInfo
            java.lang.Object r13 = r13.get(r2)
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r13 = (com.didi.soda.customer.foundation.rpc.entity.PromptEntity) r13
            if (r13 == 0) goto L_0x009d
            android.widget.TextView r4 = r12.mDishChargePriceTv
            java.lang.String r13 = r13.content
            r4.setText(r13)
            goto L_0x00a4
        L_0x009d:
            android.widget.TextView r13 = r12.mDishChargePriceTv
            r13.setText(r1)
        L_0x00a4:
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r13 = r0.priceInfo
            int r13 = r13.size()
            if (r13 <= r3) goto L_0x00c6
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r13 = r0.priceInfo
            java.lang.Object r13 = r13.get(r3)
            if (r13 == 0) goto L_0x00c6
            android.widget.TextView r13 = r12.mDishOriginPriceTv
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r1 = r0.priceInfo
            java.lang.Object r1 = r1.get(r3)
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r1 = (com.didi.soda.customer.foundation.rpc.entity.PromptEntity) r1
            java.lang.String r1 = r1.content
            r13.setText(r1)
            goto L_0x00dc
        L_0x00c6:
            android.widget.TextView r13 = r12.mDishOriginPriceTv
            r13.setText(r1)
            goto L_0x00dc
        L_0x00ce:
            android.widget.TextView r13 = r12.mDishOriginPriceTv
            r13.setText(r1)
            android.widget.TextView r13 = r12.mDishChargePriceTv
            r13.setText(r1)
        L_0x00dc:
            com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity r13 = r0.imgBottomTag
            if (r13 == 0) goto L_0x0109
            java.lang.String r1 = r13.getContent()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0109
            com.didi.soda.customer.widget.business.HomeBusinessDishTagView r1 = r12.mDishTagTv
            r1.setVisibility(r2)
            com.didi.soda.customer.widget.business.HomeBusinessDishTagView r1 = r12.mDishTagTv
            java.util.List r2 = r13.getColor()
            java.lang.String r3 = r13.getContent()
            int r13 = r13.getAngle()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1.setData(r2, r3, r13)
            goto L_0x0112
        L_0x0109:
            com.didi.soda.customer.widget.business.HomeBusinessDishTagView r13 = r12.mDishTagTv
            r1 = 8
            r13.setVisibility(r1)
        L_0x0112:
            android.widget.TextView r13 = r12.mDishPurchaseTv
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$1 r1 = new com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$1
            r1.<init>(r0)
            r13.setOnClickListener(r1)
            android.widget.ImageView r12 = r12.mDishImageIv
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$2 r13 = new com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$2
            r13.<init>(r0)
            r12.setOnClickListener(r13)
            goto L_0x01fa
        L_0x012c:
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$DishItemViewMoreHolder r12 = (com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter.DishItemViewMoreHolder) r12
            com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity r13 = r0.viewMoreEntity
            if (r13 == 0) goto L_0x01fa
            r1 = 2131957592(0x7f131758, float:1.9551772E38)
            java.lang.String r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r1)
            r2 = 2131954130(0x7f1309d2, float:1.954475E38)
            java.lang.String r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r2)
            java.lang.String r3 = r13.getIcon()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x014e
            java.lang.String r1 = r13.getIcon()
        L_0x014e:
            java.lang.String r3 = r13.getText()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x015c
            java.lang.String r2 = r13.getText()
        L_0x015c:
            androidx.constraintlayout.widget.ConstraintLayout r3 = r12.mDishMoreRootCl
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131231723(0x7f0803eb, float:1.8079535E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            android.graphics.drawable.GradientDrawable r3 = (android.graphics.drawable.GradientDrawable) r3
            if (r3 == 0) goto L_0x0198
            java.lang.String r4 = r13.getBgColor()     // Catch:{ Exception -> 0x0194 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0194 }
            if (r4 != 0) goto L_0x0189
            java.lang.String r4 = r13.getBgColor()     // Catch:{ Exception -> 0x0194 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x0194 }
            r3.setColor(r4)     // Catch:{ Exception -> 0x0194 }
            goto L_0x0198
        L_0x0189:
            r4 = 17170445(0x106000d, float:2.461195E-38)
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r4)     // Catch:{ Exception -> 0x0194 }
            r3.setColor(r4)     // Catch:{ Exception -> 0x0194 }
            goto L_0x0198
        L_0x0194:
            r4 = move-exception
            r4.fillInStackTrace()
        L_0x0198:
            androidx.constraintlayout.widget.ConstraintLayout r4 = r12.mDishMoreRootCl
            android.content.Context r4 = r4.getContext()
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131232038(0x7f080526, float:1.8080174E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r5)
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
            if (r4 == 0) goto L_0x01d4
            java.lang.String r5 = r13.getIconBgColor()     // Catch:{ Exception -> 0x01d0 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01d0 }
            if (r5 != 0) goto L_0x01c5
            java.lang.String r13 = r13.getIconBgColor()     // Catch:{ Exception -> 0x01d0 }
            int r13 = android.graphics.Color.parseColor(r13)     // Catch:{ Exception -> 0x01d0 }
            r4.setColor(r13)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01d4
        L_0x01c5:
            r13 = 2131101585(0x7f060791, float:1.7815584E38)
            int r13 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r13)     // Catch:{ Exception -> 0x01d0 }
            r4.setColor(r13)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01d4
        L_0x01d0:
            r13 = move-exception
            r13.fillInStackTrace()
        L_0x01d4:
            android.widget.TextView r13 = r12.mDishMoreCircleTv
            r13.setText(r1)
            android.widget.TextView r13 = r12.mDishMoreContentTv
            r13.setText(r2)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r12.mDishMoreRootCl
            r13.setBackground(r3)
            android.widget.TextView r13 = r12.mDishMoreCircleTv
            r13.setBackground(r4)
            android.view.View r12 = r12.itemView
            com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$3 r13 = new com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter$3
            r13.<init>(r0)
            r12.setOnClickListener(r13)
        L_0x01fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new DishItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_home_business_dish_item, viewGroup, false));
        }
        return new DishItemViewMoreHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_search_result_item_dish_more, viewGroup, false));
    }

    public void setData(List<SearchFoodItemView.SearchFoodItemModel> list) {
        this.f43226a.clear();
        notifyDataSetChanged();
        this.f43226a.addAll(list);
        notifyDataSetChanged();
    }

    static class DishItemViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView mDishChargePriceTv;
        /* access modifiers changed from: private */
        public ImageView mDishImageIv;
        /* access modifiers changed from: private */
        public TextView mDishNameTv;
        /* access modifiers changed from: private */
        public TextView mDishOriginPriceTv;
        /* access modifiers changed from: private */
        public TextView mDishPurchaseTv;
        /* access modifiers changed from: private */
        public HomeBusinessDishTagView mDishTagTv;

        DishItemViewHolder(View view) {
            super(view);
            this.mDishImageIv = (ImageView) view.findViewById(R.id.customer_iv_dish_image);
            this.mDishTagTv = (HomeBusinessDishTagView) view.findViewById(R.id.customer_hdt_dish_tag);
            this.mDishNameTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_name);
            this.mDishChargePriceTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_charge_price);
            this.mDishOriginPriceTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_origin_price);
            this.mDishPurchaseTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_purchase);
        }
    }

    static class DishItemViewMoreHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView mDishMoreCircleTv;
        /* access modifiers changed from: private */
        public TextView mDishMoreContentTv;
        /* access modifiers changed from: private */
        public ConstraintLayout mDishMoreRootCl;

        DishItemViewMoreHolder(View view) {
            super(view);
            this.mDishMoreCircleTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_more_circle);
            this.mDishMoreContentTv = (TextView) view.findViewById(R.id.customer_tv_home_dish_more);
            this.mDishMoreRootCl = (ConstraintLayout) view.findViewById(R.id.customer_cl_dish_more_root);
        }
    }
}
