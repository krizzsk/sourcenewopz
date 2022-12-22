package com.didi.soda.customer.foundation.util.startup;

import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;

public class FallbackController {

    /* renamed from: a */
    private static FallbackModel f41267a;

    public static class FallbackModel {
        public boolean isCloseSplashPost = false;
        public boolean isOpen = false;
        public boolean isOpenAsyncLayout = false;
        public boolean isOpenDelayFlutter = false;
        public boolean isOpenLazyComponent = false;
        public boolean isOpenPreFeed = false;
        public boolean isOpenPreLoc = false;
        public boolean isRemoveSetView = false;
    }

    public static boolean isOpenLazyComponent() {
        return getFallbackInfo().isOpenLazyComponent;
    }

    public static boolean isOpenDelayInitFlutter() {
        return getFallbackInfo().isOpenDelayFlutter;
    }

    public static boolean isOpenPreLoc() {
        return getFallbackInfo().isOpenPreLoc;
    }

    public static boolean isCloseSplashPost() {
        return getFallbackInfo().isCloseSplashPost;
    }

    public static boolean isOpenAsyncLayout() {
        return getFallbackInfo().isOpenAsyncLayout;
    }

    public static boolean isOpenPreFeed() {
        return getFallbackInfo().isOpenPreFeed;
    }

    public static boolean isRemoveSetView() {
        return getFallbackInfo().isRemoveSetView;
    }

    public static FallbackModel getFallbackInfo() {
        if (GlobalContext.isEmbed()) {
            return new FallbackModel();
        }
        if (f41267a == null) {
            f41267a = CustomerApolloUtil.getFallbackToggleModel();
        }
        return f41267a;
    }
}
