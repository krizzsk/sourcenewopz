package com.didiglobal.travel.infra.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\b\u001a0\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\b¨\u0006\n"}, mo175978d2 = {"withTransaction", "", "Landroidx/fragment/app/FragmentManager;", "allowStateLoss", "", "block", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "withTransactionNow", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: FragmentManager.kt */
public final class FragmentManagerKt {
    public static /* synthetic */ void withTransaction$default(FragmentManager fragmentManager, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(fragmentManager, "$this$withTransaction");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void withTransaction(FragmentManager fragmentManager, boolean z, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "$this$withTransaction");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void withTransactionNow$default(FragmentManager fragmentManager, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(fragmentManager, "$this$withTransactionNow");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void withTransactionNow(FragmentManager fragmentManager, boolean z, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "$this$withTransactionNow");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }
}
