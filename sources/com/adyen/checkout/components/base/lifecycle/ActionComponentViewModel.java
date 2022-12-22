package com.adyen.checkout.components.base.lifecycle;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.adyen.checkout.components.ActionComponent;
import com.adyen.checkout.components.base.Configuration;

public abstract class ActionComponentViewModel<ConfigurationT extends Configuration> extends AndroidViewModel implements ActionComponent<ConfigurationT> {

    /* renamed from: a */
    private final ConfigurationT f661a;

    public ActionComponentViewModel(Application application, ConfigurationT configurationt) {
        super(application);
        this.f661a = configurationt;
    }

    public ConfigurationT getConfiguration() {
        return this.f661a;
    }
}
