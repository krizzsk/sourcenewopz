package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;

public interface INewActivityDeepLink {
    public static final INewActivityDeepLink DEFAULT = new DefaultNewActivityDeepLink();

    void deepLink(Activity activity, Uri uri);

    public static class DefaultNewActivityDeepLink implements INewActivityDeepLink {
        public void deepLink(Activity activity, Uri uri) {
        }

        private DefaultNewActivityDeepLink() {
        }
    }
}
