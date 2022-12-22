package com.adyen.checkout.components.base.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0006"}, mo175978d2 = {"viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "ViewModelT", "Landroidx/lifecycle/ViewModel;", "factoryProducer", "Lkotlin/Function0;", "components-core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewModelExt.kt */
public final class ViewModelExtKt {
    public static final <ViewModelT extends ViewModel> ViewModelProvider.Factory viewModelFactory(Function0<? extends ViewModelT> function0) {
        Intrinsics.checkNotNullParameter(function0, "factoryProducer");
        return new ViewModelExtKt$viewModelFactory$1(function0);
    }
}
