package com.adyen.checkout.components;

import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.components.PaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import com.adyen.checkout.core.exception.CheckoutException;

public interface StoredPaymentComponentProvider<ComponentT extends PaymentComponent, ConfigurationT extends Configuration> extends PaymentComponentProvider<ComponentT, ConfigurationT> {
    ComponentT get(ViewModelStoreOwner viewModelStoreOwner, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt) throws CheckoutException;
}
