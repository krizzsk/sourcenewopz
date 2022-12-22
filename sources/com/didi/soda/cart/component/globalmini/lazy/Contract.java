package com.didi.soda.cart.component.globalmini.lazy;

import android.view.View;
import com.didi.soda.customer.base.lazycomponent.ILazyPresenter;
import com.didi.soda.customer.base.lazycomponent.ILazyView;
import com.didi.soda.customer.component.provider.ICartProvider;

public interface Contract {

    public static abstract class AbsGlobalMiniCartPresenter extends ILazyPresenter<AbsGlobalMiniCartView> {
        public abstract boolean isCanShow();
    }

    public static abstract class AbsGlobalMiniCartView extends ILazyView<AbsGlobalMiniCartPresenter> implements ICartProvider {
        public abstract void initButtonStyle();

        public abstract boolean isShow();

        public abstract void setOnClickListener(View.OnClickListener onClickListener);
    }
}
