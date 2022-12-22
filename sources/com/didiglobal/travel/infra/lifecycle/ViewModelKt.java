package com.didiglobal.travel.infra.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\b\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0005H\b¨\u0006\u0006"}, mo175978d2 = {"viewModel", "Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "Landroidx/fragment/app/Fragment;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: ViewModel.kt */
public final class ViewModelKt {
    public static final /* synthetic */ <VM extends ViewModel> ViewModelLazy<VM> viewModel(ComponentActivity componentActivity) {
        Intrinsics.checkParameterIsNotNull(componentActivity, "$this$viewModel");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy<>(C21490Reflection.getOrCreateKotlinClass(ViewModel.class), new ViewModelKt$viewModel$1(componentActivity), new ViewModelKt$viewModel$2(componentActivity));
    }

    public static final /* synthetic */ <VM extends ViewModel> ViewModelLazy<VM> viewModel(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$viewModel");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy<>(C21490Reflection.getOrCreateKotlinClass(ViewModel.class), new ViewModelKt$viewModel$3(fragment), new ViewModelKt$viewModel$4(fragment));
    }
}
