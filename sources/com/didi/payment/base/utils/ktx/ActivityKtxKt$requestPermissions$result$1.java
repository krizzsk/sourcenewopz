package com.didi.payment.base.utils.ktx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, mo175978d2 = {"<anonymous>", "", "requestCode", "", "permissions1", "", "", "grantResults", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityKtx.kt */
final class ActivityKtxKt$requestPermissions$result$1 extends Lambda implements Function3<Integer, String[], int[], Unit> {
    final /* synthetic */ int $currentRequestCode;
    final /* synthetic */ Function1<String[], Unit> $onPermissionsDenied;
    final /* synthetic */ Function0<Unit> $onPermissionsGrand;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityKtxKt$requestPermissions$result$1(int i, Function0<Unit> function0, Function1<? super String[], Unit> function1) {
        super(3);
        this.$currentRequestCode = i;
        this.$onPermissionsGrand = function0;
        this.$onPermissionsDenied = function1;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), (String[]) obj2, (int[]) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions1");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == this.$currentRequestCode) {
            Collection arrayList = new ArrayList();
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                int i4 = i3 + 1;
                if (iArr[i3] != 0) {
                    arrayList.add(str);
                }
                i2++;
                i3 = i4;
            }
            Collection collection = (List) arrayList;
            if (collection.isEmpty()) {
                this.$onPermissionsGrand.invoke();
                return;
            }
            Function1<String[], Unit> function1 = this.$onPermissionsDenied;
            if (function1 != null) {
                Object[] array = collection.toArray(new String[0]);
                if (array != null) {
                    function1.invoke(array);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
    }
}
