package com.didiglobal.travel.infra.fragment;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003\u001a(\u0010\u0004\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"findCallback", "T", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "runIfAdded", "block", "Lkotlin/Function0;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Fragment.kt */
public final class FragmentKt {
    public static final <T> T runIfAdded(Fragment fragment, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$runIfAdded");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        if (fragment.isAdded()) {
            return function0.invoke();
        }
        return null;
    }

    public static final /* synthetic */ <T> T findCallback(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$findCallback");
        if (!fragment.isAdded()) {
            return null;
        }
        for (T parentFragment = fragment.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (parentFragment instanceof Object) {
                return parentFragment;
            }
        }
        T activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) activity;
    }
}
