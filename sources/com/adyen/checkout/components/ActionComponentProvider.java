package com.adyen.checkout.components;

import android.app.Application;
import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.components.ActionComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.payments.response.Action;
import java.util.List;

public interface ActionComponentProvider<ComponentT extends ActionComponent, ConfigurationT extends Configuration> extends ComponentProvider<ComponentT> {
    boolean canHandleAction(Action action);

    ComponentT get(ViewModelStoreOwner viewModelStoreOwner, Application application, ConfigurationT configurationt);

    List<String> getSupportedActionTypes();

    boolean requiresConfiguration();

    boolean requiresView(Action action);
}
