package com.adyen.checkout.adyen3ds2;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.redirect.RedirectDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J!\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0014"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2ComponentProvider;", "Lcom/adyen/checkout/components/ActionComponentProvider;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "()V", "canHandleAction", "", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "get", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "application", "Landroid/app/Application;", "configuration", "getSupportedActionTypes", "", "", "requiresConfiguration", "requiresView", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Adyen3DS2ComponentProvider.kt */
public final class Adyen3DS2ComponentProvider implements ActionComponentProvider<Adyen3DS2Component, Adyen3DS2Configuration> {
    public boolean requiresConfiguration() {
        return false;
    }

    public boolean requiresView(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return false;
    }

    public Adyen3DS2Component get(ViewModelStoreOwner viewModelStoreOwner, Application application, Adyen3DS2Configuration adyen3DS2Configuration) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adyen3DS2Configuration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new Adyen3DS2ComponentProvider$get$$inlined$viewModelFactory$1(application, adyen3DS2Configuration, new SubmitFingerprintRepository(), new Adyen3DS2Serializer(), new RedirectDelegate())).get(Adyen3DS2Component.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, threeDS2Factory).get(Adyen3DS2Component::class.java)");
        return (Adyen3DS2Component) viewModel;
    }

    public List<String> getSupportedActionTypes() {
        return CollectionsKt.listOf("threeDS2Fingerprint", "threeDS2Challenge", "threeDS2");
    }

    public boolean canHandleAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return CollectionsKt.contains(getSupportedActionTypes(), action.getType());
    }
}
