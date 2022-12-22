package com.didi.universal.pay.sdk.web;

import android.app.Activity;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class WebActivityIntent extends AbsPlatformWebPageProxy {
    private final String UNIPAY_ACTION;
    /* access modifiers changed from: protected */
    public Activity mActivity;

    public void onFinish() {
    }

    public WebActivityIntent() {
        String name = WebProxyActivity.class.getName();
        this.UNIPAY_ACTION = name;
        setAction(name);
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
