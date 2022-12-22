package com.didi.soda.home.shimmer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.home.shimmer.ShimmerViewHolder;
import com.taxis99.R;

public class ShimmerShopLandAdapter extends ShimmerBaseAdapter {

    /* renamed from: a */
    private static final int f42744a = 0;

    /* renamed from: b */
    private static final int f42745b = 2;

    /* renamed from: c */
    private static final int f42746c = 3;

    public int getItemViewType(int i) {
        if (i == 0) {
            return 3;
        }
        return i == 1 ? 0 : 2;
    }

    public ShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return new KingKongViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_shimmer_kingkong, viewGroup, false));
        }
        if (i == 0) {
            return new FilterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_shimmer_filter, viewGroup, false));
        }
        return new ShopViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_shimmer_shop, viewGroup, false));
    }

    static class KingKongViewHolder extends ShimmerViewHolder {
        KingKongViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.customer_custom_shimmer_kk1);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_kk2);
            View findViewById3 = view.findViewById(R.id.customer_custom_shimmer_kk3);
            View findViewById4 = view.findViewById(R.id.customer_custom_shimmer_kk4);
            View findViewById5 = view.findViewById(R.id.customer_custom_shimmer_kk5);
            View findViewById6 = view.findViewById(R.id.customer_custom_shimmer_kk6);
            View findViewById7 = view.findViewById(R.id.customer_custom_shimmer_kk7);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
            addShimmerView(findViewById4);
            addShimmerView(findViewById5);
            addShimmerView(findViewById6);
            addShimmerView(findViewById7);
        }
    }

    static class FilterViewHolder extends ShimmerViewHolder {
        FilterViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.customer_custom_shimmer_filter1);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_filter2);
            View findViewById3 = view.findViewById(R.id.customer_custom_shimmer_filter3);
            View findViewById4 = view.findViewById(R.id.customer_custom_shimmer_filter4);
            View findViewById5 = view.findViewById(R.id.customer_custom_shimmer_filter5);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
            addShimmerView(findViewById4);
            addShimmerView(findViewById5);
        }
    }

    static class ShopViewHolder extends ShimmerViewHolder {
        ShopViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.rl_shimmer_container);
            View findViewById2 = view.findViewById(R.id.customer_custom_shimmer_shop_img1);
            View findViewById3 = view.findViewById(R.id.customer_custom_shimmer_shop_img2);
            View findViewById4 = view.findViewById(R.id.customer_custom_shimmer_shop_img3);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
            addShimmerView(findViewById4);
        }
    }
}
