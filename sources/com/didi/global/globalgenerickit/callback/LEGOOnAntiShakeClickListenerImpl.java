package com.didi.global.globalgenerickit.callback;

import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;

public abstract class LEGOOnAntiShakeClickListenerImpl extends LEGOOnAntiShakeClickListener {
    public ButtonModel btnModel;

    public LEGOOnAntiShakeClickListenerImpl(ButtonModel buttonModel) {
        this.btnModel = buttonModel;
    }
}
