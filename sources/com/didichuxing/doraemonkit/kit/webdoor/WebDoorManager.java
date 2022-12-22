package com.didichuxing.doraemonkit.kit.webdoor;

import android.content.Context;

public class WebDoorManager {

    public interface WebDoorCallback {
        void overrideUrlLoading(Context context, String str);
    }
}
