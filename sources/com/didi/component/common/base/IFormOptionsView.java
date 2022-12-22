package com.didi.component.common.base;

import com.didi.component.core.IView;

public interface IFormOptionsView extends IView {
    String getContent();

    String getIcon();

    void notifyUpdate();
}
