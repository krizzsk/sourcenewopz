package com.adyen.checkout.components.base;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.PaymentComponentState;
import com.adyen.checkout.components.ViewableComponent;
import com.adyen.checkout.components.analytics.AnalyticEvent;
import com.adyen.checkout.components.analytics.AnalyticsDispatcher;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.InputData;
import com.adyen.checkout.components.base.OutputData;
import com.adyen.checkout.components.base.lifecycle.PaymentComponentViewModel;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;

public abstract class BasePaymentComponent<ConfigurationT extends Configuration, InputDataT extends InputData, OutputDataT extends OutputData, ComponentStateT extends PaymentComponentState<? extends PaymentMethodDetails>> extends PaymentComponentViewModel<ConfigurationT, ComponentStateT> implements ViewableComponent<OutputDataT, ConfigurationT, ComponentStateT> {

    /* renamed from: a */
    private static final String f648a = LogUtil.getTag();

    /* renamed from: b */
    private final MutableLiveData<ComponentStateT> f649b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<ComponentError> f650c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<OutputDataT> f651d = new MutableLiveData<>();

    /* renamed from: e */
    private boolean f652e = false;

    /* renamed from: f */
    private boolean f653f = true;
    protected InputDataT mLatestInputData;

    /* access modifiers changed from: protected */
    public abstract ComponentStateT createComponentState();

    /* access modifiers changed from: protected */
    public abstract OutputDataT onInputDataChanged(InputDataT inputdatat);

    public boolean requiresInput() {
        return true;
    }

    public BasePaymentComponent(PaymentMethodDelegate paymentMethodDelegate, ConfigurationT configurationt) {
        super(paymentMethodDelegate, configurationt);
        m1044a(paymentMethodDelegate.getPaymentMethodType());
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<ComponentStateT> observer) {
        this.f649b.observe(lifecycleOwner, observer);
    }

    public void observeErrors(LifecycleOwner lifecycleOwner, Observer<ComponentError> observer) {
        this.f650c.observe(lifecycleOwner, observer);
    }

    public PaymentComponentState<? extends PaymentMethodDetails> getState() {
        return (PaymentComponentState) this.f649b.getValue();
    }

    public final void inputDataChanged(InputDataT inputdatat) {
        Logger.m1082v(f648a, "inputDataChanged");
        this.mLatestInputData = inputdatat;
        notifyStateChanged(onInputDataChanged(inputdatat));
    }

    public void setAnalyticsEnabled(boolean z) {
        this.f653f = z;
    }

    public void sendAnalyticsEvent(Context context) {
        AnalyticEvent.Flavor flavor;
        if (this.f653f) {
            if (this.f652e) {
                flavor = AnalyticEvent.Flavor.DROPIN;
            } else {
                flavor = AnalyticEvent.Flavor.COMPONENT;
            }
            String paymentMethodType = this.mPaymentMethodDelegate.getPaymentMethodType();
            if (!TextUtils.isEmpty(paymentMethodType)) {
                AnalyticsDispatcher.dispatchEvent(context, getConfiguration().getEnvironment(), AnalyticEvent.create(context, flavor, paymentMethodType, getConfiguration().getShopperLocale()));
                return;
            }
            throw new CheckoutException("Payment method has empty or null type");
        }
    }

    public void observeOutputData(LifecycleOwner lifecycleOwner, Observer<OutputDataT> observer) {
        this.f651d.observe(lifecycleOwner, observer);
    }

    public OutputDataT getOutputData() {
        return (OutputData) this.f651d.getValue();
    }

    /* access modifiers changed from: protected */
    public void notifyException(CheckoutException checkoutException) {
        String str = f648a;
        Logger.m1078e(str, "notifyException - " + checkoutException.getMessage());
        this.f650c.postValue(new ComponentError(checkoutException));
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged(OutputDataT outputdatat) {
        Logger.m1076d(f648a, "notifyStateChanged with OutputData");
        if (!outputdatat.equals(this.f651d.getValue())) {
            this.f651d.setValue(outputdatat);
            notifyStateChanged();
            return;
        }
        Logger.m1076d(f648a, "state has not changed");
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged() {
        Logger.m1076d(f648a, "notifyStateChanged");
        ThreadManager.EXECUTOR.submit(new Runnable() {
            public final void run() {
                BasePaymentComponent.this.m1043a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m1043a() {
        try {
            this.f649b.postValue(createComponentState());
        } catch (Exception e) {
            String str = f648a;
            Logger.m1078e(str, "notifyStateChanged - error:" + e.getMessage());
            notifyException(new ComponentException("Unexpected error", e));
        }
    }

    /* renamed from: a */
    private void m1044a(String str) {
        if (!m1045b(str)) {
            throw new IllegalArgumentException("Unsupported payment method type " + str);
        }
    }

    /* renamed from: b */
    private boolean m1045b(String str) {
        for (String equals : getSupportedPaymentMethodTypes()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setCreatedForDropIn() {
        this.f652e = true;
    }
}
