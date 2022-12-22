package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;

public class CapsuleButtonSubJSBridge {

    /* renamed from: a */
    private final DMMina f16560a;

    public CapsuleButtonSubJSBridge(DMMina dMMina) {
        this.f16560a = dMMina;
        LogUtil.m13411i("LoadSubPackageSubJSBridge init");
    }

    public void setCapsuleButtonVisible(boolean z, CallbackFunction callbackFunction) {
        DMPage curPage = NavigateUtil.getCurPage(this.f16560a);
        if (curPage != null) {
            curPage.setCapsuleButtonVisibility(z);
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
