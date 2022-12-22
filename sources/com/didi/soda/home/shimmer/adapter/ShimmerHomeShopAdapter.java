package com.didi.soda.home.shimmer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.home.shimmer.ShimmerViewHolder;
import com.taxis99.R;

public class ShimmerHomeShopAdapter extends ShimmerBaseAdapter {
    public ShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ShopViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_shimmer_shop, viewGroup, false));
    }

    static class ShopViewHolder extends ShimmerViewHolder {
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
