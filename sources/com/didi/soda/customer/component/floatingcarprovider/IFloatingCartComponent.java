package com.didi.soda.customer.component.floatingcarprovider;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public abstract class IFloatingCartComponent<V extends IView, P extends IPresenter> extends MvpComponent implements IFloatingCartProvider {
    public IFloatingCartComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }
}
