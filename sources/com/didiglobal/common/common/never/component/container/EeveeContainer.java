package com.didiglobal.common.common.never.component.container;

import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.container.ContainerComponent;
import com.didiglobal.common.common.never.component.container.EeveeContainerPresenter;

public abstract class EeveeContainer<T extends EeveeContainerPresenter> extends ContainerComponent {
    public boolean needInflate(ComponentParams componentParams) {
        return false;
    }
}
