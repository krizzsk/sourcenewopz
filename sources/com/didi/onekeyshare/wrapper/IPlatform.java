package com.didi.onekeyshare.wrapper;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;

public interface IPlatform {
    boolean matchPlatform(String str);

    void share(Context context, OneKeyShareInfo oneKeyShareInfo, ICallback.IPlatformShareCallback iPlatformShareCallback);
}
