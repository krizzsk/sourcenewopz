package com.didi.drouter.router;

import android.os.Bundle;

public interface IInterceptor {
    void onContinue();

    void onInterrupt();

    void onRedirect(String str, Bundle... bundleArr);
}
