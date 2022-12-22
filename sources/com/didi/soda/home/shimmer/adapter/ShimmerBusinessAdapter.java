package com.didi.soda.home.shimmer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.home.shimmer.ShimmerViewHolder;
import com.taxis99.R;

public class ShimmerBusinessAdapter extends ShimmerBaseAdapter {

    /* renamed from: a */
    private static final int f42736a = 0;

    /* renamed from: b */
    private static final int f42737b = 1;

    /* renamed from: c */
    private static final int f42738c = 2;

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == 1 ? 1 : 2;
    }

    public ShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeadViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_business_shimmer_header, viewGroup, false));
        }
        if (i == 1) {
            return new FilterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_business_shimmer_filter, viewGroup, false));
        }
        return new ShopViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_business_shimmer_shop, viewGroup, false));
    }

    public static class HeadViewHolder extends ShimmerViewHolder {
        HeadViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.customer_custom_shimmer_head_img1);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_head_img2);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
        }
    }

    public static class FilterViewHolder extends ShimmerViewHolder {
        FilterViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.customer_custom_shimmer_filter1);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_filter2);
            View findViewById3 = view.findViewById(R.id.customer_custom_shimmer_filter7);
            View findViewById4 = view.findViewById(R.id.customer_horizental_shimmer_item1);
            View findViewById5 = view.findViewById(R.id.customer_horizental_shimmer_item2);
            View findViewById6 = view.findViewById(R.id.customer_horizental_shimmer_item3);
            View findViewById7 = view.findViewById(R.id.customer_horizental_shimmer_item4);
            View findViewById8 = view.findViewById(R.id.customer_horizental_shimmer_item5);
            View findViewById9 = view.findViewById(R.id.customer_horizental_shimmer_item6);
            View findViewById10 = view.findViewById(R.id.customer_horizental_shimmer_item7);
            View findViewById11 = view.findViewById(R.id.customer_horizental_shimmer_item8);
            View findViewById12 = view.findViewById(R.id.customer_horizental_shimmer_item9);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
            addShimmerView(findViewById4);
            addShimmerView(findViewById5);
            addShimmerView(findViewById6);
            addShimmerView(findViewById7);
            addShimmerView(findViewById8);
            addShimmerView(findViewById9);
            addShimmerView(findViewById10);
            addShimmerView(findViewById11);
            addShimmerView(findViewById12);
        }
    }

    public static class ShopViewHolder extends ShimmerViewHolder {
        ShopViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.customer_custom_shimmer_shop_img1);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_shop_img2);
            View findViewById3 = view.findViewById(R.id.customer_custom_shimmer_shop_img3);
            View findViewById4 = view.findViewById(R.id.customer_custom_shimmer_shop_img4);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
            addShimmerView(findViewById4);
        }
    }
}
