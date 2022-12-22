package com.didi.component.never.core.container;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import java.util.LinkedHashMap;

public abstract class ContainerPresenter extends ComponentPresenterImpl {

    /* renamed from: a */
    private LinkedHashMap<String, ViewGroup.LayoutParams> f14652a;

    public abstract LinkedHashMap<String, ViewGroup.LayoutParams> setLayoutParams(ComponentParams componentParams);

    public ContainerPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f14652a = setLayoutParams(componentParams);
    }

    public LinkedHashMap<String, ViewGroup.LayoutParams> getLayoutParams() {
        return this.f14652a;
    }
}
