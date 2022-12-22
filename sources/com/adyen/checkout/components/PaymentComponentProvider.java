package com.adyen.checkout.components;

import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.components.PaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.core.exception.CheckoutException;

public interface PaymentComponentProvider<ComponentT extends PaymentComponent, ConfigurationT extends Configuration> extends ComponentProvider<ComponentT> {
    ComponentT get(ViewModelStoreOwner viewModelStoreOwner, PaymentMethod paymentMethod, ConfigurationT configurationt) throws CheckoutException;
}
