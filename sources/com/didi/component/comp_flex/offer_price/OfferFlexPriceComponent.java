package com.didi.component.comp_flex.offer_price;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;

@ComponentRegister(product = "ride", type = "offer_flex_price")
public class OfferFlexPriceComponent extends BaseComponent<IView, OfferFlexPricePresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public OfferFlexPricePresenter onCreatePresenter(ComponentParams componentParams) {
        return new OfferFlexPricePresenter(componentParams);
    }
}
