package com.didi.soda.home.shimmer;

import com.didi.soda.home.shimmer.adapter.ShimmerBaseAdapter;
import com.didi.soda.home.shimmer.adapter.ShimmerBusinessAdapter;
import com.didi.soda.home.shimmer.adapter.ShimmerBusinessSearchAdapter;
import com.didi.soda.home.shimmer.adapter.ShimmerHomeFullAdapter;
import com.didi.soda.home.shimmer.adapter.ShimmerHomeShopAdapter;
import com.didi.soda.home.shimmer.adapter.ShimmerShopLandAdapter;

public class ShimmerAdapterFactory {
    ShimmerAdapterFactory() {
    }

    public static ShimmerBaseAdapter creatShimmerAdapter(ShimmerViewType shimmerViewType) {
        if (shimmerViewType == ShimmerViewType.HOME_STRAT) {
            return new ShimmerHomeFullAdapter();
        }
        if (shimmerViewType == ShimmerViewType.HOME_FILTER) {
            return new ShimmerHomeShopAdapter();
        }
        if (shimmerViewType == ShimmerViewType.BUSINESS_START) {
            return new ShimmerBusinessAdapter();
        }
        if (shimmerViewType == ShimmerViewType.BUSINESS_SEARCH) {
            return new ShimmerBusinessSearchAdapter();
        }
        if (shimmerViewType == ShimmerViewType.SHOP_LAND) {
            return new ShimmerShopLandAdapter();
        }
        return null;
    }
}
