package com.didi.dimina.starbox.module.jsbridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.module.DiminaDemoActivity;

public class DiminaDemoSubJSBridge {

    /* renamed from: a */
    private final DMMina f18004a;

    DiminaDemoSubJSBridge(DMMina dMMina) {
        LogUtil.m13411i("DiminaDemoSubJSBridge init");
        this.f18004a = dMMina;
    }

    public void openDiminaDemo() {
        DiminaDemoActivity.startDiminaDemoActivity(this.f18004a.getActivity());
    }
}
