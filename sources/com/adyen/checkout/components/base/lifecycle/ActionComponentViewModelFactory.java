package com.adyen.checkout.components.base.lifecycle;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.adyen.checkout.components.base.Configuration;

public final class ActionComponentViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: a */
    private final Class<?> f662a;

    /* renamed from: b */
    private final Configuration f663b;

    /* renamed from: c */
    private final Application f664c;

    public ActionComponentViewModelFactory(Application application, Class<?> cls, Configuration configuration) {
        this.f664c = application;
        this.f662a = cls;
        this.f663b = configuration;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        try {
            return (ViewModel) cls.getConstructor(new Class[]{Application.class, this.f662a}).newInstance(new Object[]{this.f664c, this.f663b});
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an instance of component: " + cls, e);
        }
    }
}
