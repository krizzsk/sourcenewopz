package com.didi.sdk.push.proxy;

import android.content.Context;
import android.net.Uri;

public interface LogupBindListener {
    void onBind(Context context, Uri uri);
}
