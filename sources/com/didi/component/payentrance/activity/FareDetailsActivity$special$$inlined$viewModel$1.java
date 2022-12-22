package com.didi.component.payentrance.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "com/didiglobal/travel/infra/lifecycle/ViewModelKt$viewModel$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: ViewModel.kt */
public final class FareDetailsActivity$special$$inlined$viewModel$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FareDetailsActivity$special$$inlined$viewModel$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModel = componentActivity;
    }

    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModel.getViewModelStore();
        Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
