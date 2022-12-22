package com.didiglobal.travel.infra.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ViewModel.kt */
public final class ViewModelKt$viewModel$4 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Fragment $this_viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelKt$viewModel$4(Fragment fragment) {
        super(0);
        this.$this_viewModel = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        FragmentActivity activity = this.$this_viewModel.getActivity();
        if (activity == null) {
            return new ViewModelProvider.NewInstanceFactory();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "it");
        return new ViewModelProvider.AndroidViewModelFactory(activity.getApplication());
    }
}
