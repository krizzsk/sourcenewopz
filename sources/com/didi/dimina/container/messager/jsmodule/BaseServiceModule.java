package com.didi.dimina.container.messager.jsmodule;

import com.didi.dimina.container.DMMina;

public class BaseServiceModule {
    public DMMina mDimina;

    public void onDestroy() {
    }

    public BaseServiceModule(DMMina dMMina) {
        this.mDimina = dMMina;
    }
}
