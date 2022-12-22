package com.adyen.checkout.adyen3ds2;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository;
import com.adyen.checkout.redirect.RedirectDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b¸\u0006\u0000"}, mo175978d2 = {"com/adyen/checkout/components/base/lifecycle/ViewModelExtKt$viewModelFactory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewModelExt.kt */
public final class Adyen3DS2ComponentProvider$get$$inlined$viewModelFactory$1 implements ViewModelProvider.Factory {
    final /* synthetic */ Adyen3DS2Serializer $adyen3DS2DetailsParser$inlined;
    final /* synthetic */ Application $application$inlined;
    final /* synthetic */ Adyen3DS2Configuration $configuration$inlined;
    final /* synthetic */ RedirectDelegate $redirectDelegate$inlined;
    final /* synthetic */ SubmitFingerprintRepository $submitFingerprintRepository$inlined;

    public Adyen3DS2ComponentProvider$get$$inlined$viewModelFactory$1(Application application, Adyen3DS2Configuration adyen3DS2Configuration, SubmitFingerprintRepository submitFingerprintRepository, Adyen3DS2Serializer adyen3DS2Serializer, RedirectDelegate redirectDelegate) {
        this.$application$inlined = application;
        this.$configuration$inlined = adyen3DS2Configuration;
        this.$submitFingerprintRepository$inlined = submitFingerprintRepository;
        this.$adyen3DS2DetailsParser$inlined = adyen3DS2Serializer;
        this.$redirectDelegate$inlined = redirectDelegate;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) new Adyen3DS2Component(this.$application$inlined, this.$configuration$inlined, this.$submitFingerprintRepository$inlined, this.$adyen3DS2DetailsParser$inlined, this.$redirectDelegate$inlined);
    }
}
