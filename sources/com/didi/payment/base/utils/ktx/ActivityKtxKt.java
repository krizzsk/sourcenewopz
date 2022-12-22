package com.didi.payment.base.utils.ktx;

import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aK\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u001c\u0010\t\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\u0010\r\u001aO\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0014\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00040\u0018\u001a<\u0010\u0014\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00040\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"permissionRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "startActivityRequestCode", "requestPermissions", "", "Landroidx/fragment/app/FragmentActivity;", "permissions", "", "", "onPermissionsDenied", "Lkotlin/Function1;", "onPermissionsGrand", "Lkotlin/Function0;", "(Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "requestCode", "", "onRequestPermissionsResult", "Lkotlin/Function3;", "", "(Landroidx/fragment/app/FragmentActivity;I[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "startActivityForResult", "intent", "Landroid/content/Intent;", "onActivityResult", "Lkotlin/Function2;", "base_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityKtx.kt */
public final class ActivityKtxKt {

    /* renamed from: a */
    private static final AtomicInteger f30031a = new AtomicInteger(1);

    /* renamed from: b */
    private static final AtomicInteger f30032b = new AtomicInteger(1);

    public static final void startActivityForResult(FragmentActivity fragmentActivity, Intent intent, int i, Function3<? super Integer, ? super Integer, ? super Intent, Unit> function3) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function3, "onActivityResult");
        RequestActivity.Companion.startForResult(fragmentActivity, intent, i);
        RequestActivity.Companion.setOnActivityResult(function3);
    }

    public static final void startActivityForResult(FragmentActivity fragmentActivity, Intent intent, Function2<? super Integer, ? super Intent, Unit> function2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function2, "onActivityResult");
        int andIncrement = f30031a.getAndIncrement();
        startActivityForResult(fragmentActivity, intent, andIncrement, new ActivityKtxKt$startActivityForResult$1(andIncrement, function2));
    }

    public static final void requestPermissions(FragmentActivity fragmentActivity, int i, String[] strArr, Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function3, "onRequestPermissionsResult");
        RequestActivity.Companion.requestPermission(fragmentActivity, i, strArr);
        RequestActivity.Companion.setOnRequestPermissionsResult(function3);
    }

    public static final void requestPermissions(FragmentActivity fragmentActivity, String[] strArr, Function1<? super String[], Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(function0, "onPermissionsGrand");
        Collection arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(fragmentActivity, str) != 0) {
                arrayList.add(str);
            }
        }
        Collection collection = (List) arrayList;
        if (collection.isEmpty()) {
            function0.invoke();
            return;
        }
        int andIncrement = f30032b.getAndIncrement();
        Function3 activityKtxKt$requestPermissions$result$1 = new ActivityKtxKt$requestPermissions$result$1(andIncrement, function0, function1);
        Object[] array = collection.toArray(new String[0]);
        if (array != null) {
            requestPermissions(fragmentActivity, andIncrement, (String[]) array, (Function3<? super Integer, ? super String[], ? super int[], Unit>) activityKtxKt$requestPermissions$result$1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
