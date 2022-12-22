package com.koushikdutta.async.http;

import android.net.Uri;

public class AsyncHttpHead extends AsyncHttpRequest {
    public static final String METHOD = "HEAD";

    public boolean hasBody() {
        return false;
    }

    public AsyncHttpHead(Uri uri) {
        super(uri, METHOD);
    }
}
