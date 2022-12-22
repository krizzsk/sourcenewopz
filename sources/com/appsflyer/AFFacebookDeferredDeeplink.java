package com.appsflyer;

final class AFFacebookDeferredDeeplink {

    public interface AppLinkFetchEvents {
        void onAppLinkFetchFailed(String str);

        void onAppLinkFetchFinished(String str, String str2, String str3);
    }

    AFFacebookDeferredDeeplink() {
    }
}
