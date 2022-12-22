package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.callback.ICallback;

public interface ICallbackComponent {
    ICallback.IPlatformShareCallback getCallback();

    void setCallback(ICallback.IPlatformShareCallback iPlatformShareCallback);
}
