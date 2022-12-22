package com.didi.component.business.event;

import android.net.Uri;

public class ActivityDeepLinkEvent extends BaseDeepLinkEvent {
    public Uri uri;

    public ActivityDeepLinkEvent(Uri uri2) {
        this.uri = uri2;
    }
}
