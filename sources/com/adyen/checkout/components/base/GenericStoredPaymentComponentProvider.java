package com.adyen.checkout.components.base;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.components.StoredPaymentComponentProvider;
import com.adyen.checkout.components.base.BasePaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0018\b\u0000\u0010\u0001*\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000fJ&\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/adyen/checkout/components/base/GenericStoredPaymentComponentProvider;", "BaseComponentT", "Lcom/adyen/checkout/components/base/BasePaymentComponent;", "ConfigurationT", "Lcom/adyen/checkout/components/base/Configuration;", "Lcom/adyen/checkout/components/StoredPaymentComponentProvider;", "componentClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "get", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "configuration", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/components/base/Configuration;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "storedPaymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;Lcom/adyen/checkout/components/base/Configuration;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GenericStoredPaymentComponentProvider.kt */
public final class GenericStoredPaymentComponentProvider<BaseComponentT extends BasePaymentComponent<?, ?, ?, ?>, ConfigurationT extends Configuration> implements StoredPaymentComponentProvider<BaseComponentT, ConfigurationT> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Class<BaseComponentT> f659a;

    public GenericStoredPaymentComponentProvider(Class<BaseComponentT> cls) {
        Intrinsics.checkNotNullParameter(cls, "componentClass");
        this.f659a = cls;
    }

    public BaseComponentT get(ViewModelStoreOwner viewModelStoreOwner, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        BaseComponentT basecomponentt = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new C1317x97ddf980(this, configurationt, storedPaymentMethod)).get(this.f659a);
        Intrinsics.checkNotNullExpressionValue(basecomponentt, "ViewModelProvider(viewModelStoreOwner, genericStoredFactory)[componentClass]");
        return (BasePaymentComponent) basecomponentt;
    }

    public BaseComponentT get(ViewModelStoreOwner viewModelStoreOwner, PaymentMethod paymentMethod, ConfigurationT configurationt) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        BaseComponentT basecomponentt = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new C1318x97ddf981(this, configurationt, paymentMethod)).get(this.f659a);
        Intrinsics.checkNotNullExpressionValue(basecomponentt, "ViewModelProvider(viewModelStoreOwner, genericFactory)[componentClass]");
        return (BasePaymentComponent) basecomponentt;
    }
}
