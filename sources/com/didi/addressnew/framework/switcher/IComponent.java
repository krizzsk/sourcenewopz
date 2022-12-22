package com.didi.addressnew.framework.switcher;

import com.didi.address.model.SugParams;

public interface IComponent {
    void onConfirmEnter(SugParams sugParams);

    void onExit();

    void onGetonEnter(SugParams sugParams);

    void onHomeEnter(SugParams sugParams);

    void onRegister(String str, IComponent iComponent);

    void onSettingEnter(SugParams sugParams);

    void onWaittingEnter(SugParams sugParams);
}
