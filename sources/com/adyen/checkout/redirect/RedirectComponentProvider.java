package com.adyen.checkout.redirect;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.model.payments.response.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J!\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0014"}, mo175978d2 = {"Lcom/adyen/checkout/redirect/RedirectComponentProvider;", "Lcom/adyen/checkout/components/ActionComponentProvider;", "Lcom/adyen/checkout/redirect/RedirectComponent;", "Lcom/adyen/checkout/redirect/RedirectConfiguration;", "()V", "canHandleAction", "", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "get", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "application", "Landroid/app/Application;", "configuration", "getSupportedActionTypes", "", "", "requiresConfiguration", "requiresView", "redirect_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RedirectComponentProvider.kt */
public final class RedirectComponentProvider implements ActionComponentProvider<RedirectComponent, RedirectConfiguration> {
    public boolean requiresConfiguration() {
        return false;
    }

    public boolean requiresView(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return false;
    }

    public RedirectComponent get(ViewModelStoreOwner viewModelStoreOwner, Application application, RedirectConfiguration redirectConfiguration) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(redirectConfiguration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new RedirectComponentProvider$get$$inlined$viewModelFactory$1(application, redirectConfiguration, new RedirectDelegate())).get(RedirectComponent.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, redirectFactory).get(RedirectComponent::class.java)");
        return (RedirectComponent) viewModel;
    }

    public List<String> getSupportedActionTypes() {
        return CollectionsKt.listOf("redirect");
    }

    public boolean canHandleAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return CollectionsKt.contains(getSupportedActionTypes(), action.getType());
    }
}
