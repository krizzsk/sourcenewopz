package com.didi.entrega.home.shimmer;

import com.didi.entrega.home.shimmer.adapter.ShimmerBaseAdapter;
import com.didi.entrega.home.shimmer.adapter.ShimmerHomeFullAdapter;

public class ShimmerAdapterFactory {
    ShimmerAdapterFactory() {
    }

    public static ShimmerBaseAdapter createShimmerAdapter(ShimmerViewType shimmerViewType) {
        if (shimmerViewType == ShimmerViewType.HOME_START) {
            return new ShimmerHomeFullAdapter();
        }
        return null;
    }
}
