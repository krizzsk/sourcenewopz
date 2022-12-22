package com.adyen.checkout.components.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.lifecycle.ActionComponentViewModel;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import org.json.JSONObject;

public abstract class BaseActionComponent<ConfigurationT extends Configuration> extends ActionComponentViewModel<ConfigurationT> {

    /* renamed from: a */
    private static final String f643a = LogUtil.getTag();

    /* renamed from: b */
    private static final String f644b = "payment_data";

    /* renamed from: c */
    private final MutableLiveData<ActionComponentData> f645c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<ComponentError> f646d = new MutableLiveData<>();

    /* renamed from: e */
    private String f647e;

    /* access modifiers changed from: protected */
    public abstract void handleActionInternal(Activity activity, Action action) throws ComponentException;

    public BaseActionComponent(Application application, ConfigurationT configurationt) {
        super(application, configurationt);
    }

    public void handleAction(Activity activity, Action action) {
        if (!canHandleAction(action)) {
            notifyException(new ComponentException("Action type not supported by this component - " + action.getType()));
            return;
        }
        this.f647e = action.getPaymentData();
        try {
            handleActionInternal(activity, action);
        } catch (ComponentException e) {
            notifyException(e);
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<ActionComponentData> observer) {
        this.f645c.observe(lifecycleOwner, observer);
    }

    public void observeErrors(LifecycleOwner lifecycleOwner, Observer<ComponentError> observer) {
        this.f646d.observe(lifecycleOwner, observer);
    }

    public void saveState(Bundle bundle) {
        if (bundle != null && !TextUtils.isEmpty(this.f647e)) {
            if (bundle.containsKey(f644b)) {
                Logger.m1076d(f643a, "bundle already has paymentData, overriding");
            }
            bundle.putString(f644b, this.f647e);
        }
    }

    public void restoreState(Bundle bundle) {
        if (bundle != null && bundle.containsKey(f644b) && TextUtils.isEmpty(this.f647e)) {
            this.f647e = bundle.getString(f644b);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyDetails(JSONObject jSONObject) throws ComponentException {
        ActionComponentData actionComponentData = new ActionComponentData();
        actionComponentData.setDetails(jSONObject);
        actionComponentData.setPaymentData(this.f647e);
        this.f645c.setValue(actionComponentData);
    }

    /* access modifiers changed from: protected */
    public void notifyException(CheckoutException checkoutException) {
        this.f646d.postValue(new ComponentError(checkoutException));
    }

    /* access modifiers changed from: protected */
    public String getPaymentData() {
        return this.f647e;
    }

    /* access modifiers changed from: protected */
    public void setPaymentData(String str) {
        this.f647e = str;
    }
}
