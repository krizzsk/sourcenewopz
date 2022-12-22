package com.didi.component.business.event;

import android.net.Uri;

public class OpenRideDeepLinkEvent extends BaseDeepLinkEvent {
    public Uri uri;

    public OpenRideDeepLinkEvent(Uri uri2) {
        this.uri = uri2;
    }
}
