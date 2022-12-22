package com.didi.unifiedPay.component.activity;

import android.app.Activity;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class WebActivityIntent extends AbsPlatformWebPageProxy {
    protected Activity mActivity;

    public void onFinish() {
    }

    public void onAttach(Activity activity) {
        this.mActivity = activity;
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
