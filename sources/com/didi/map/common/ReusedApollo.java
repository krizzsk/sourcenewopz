package com.didi.map.common;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.apollo.ApolloDelegate;

public class ReusedApollo {
    private static final ApolloDelegate APOLLO_DELEGATE = new ApolloDelegate();
    private static final String NEW_VECTOR_ENLARGE_MAP = "gray_map_navi_enlargeimg_renderingengine";

    public static boolean isNewVecEnlargeMapEnable() {
        IToggle toggleCache = APOLLO_DELEGATE.getToggleCache(NEW_VECTOR_ENLARGE_MAP);
        if (toggleCache == null) {
            return false;
        }
        return toggleCache.allow();
    }
}
