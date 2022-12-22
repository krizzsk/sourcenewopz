package com.didichuxing.drtl;

import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\r\"\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u00020\u000b*\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, mo175978d2 = {"Lcom/didichuxing/drtl/Drtl;", "", "()V", "TAG", "", "drtl", "Ljava/util/LinkedList;", "Lcom/didichuxing/drtl/auto/IDrtl;", "getDrtl", "()Ljava/util/LinkedList;", "apply", "", "any", "", "([Ljava/lang/Object;)V", "applyView", "view", "Landroid/view/View;", "([Landroid/view/View;)V", "rtl", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Drtl.kt */
public final class Drtl {
    public static final Drtl INSTANCE = new Drtl();
    public static final String TAG = "Drtl";

    /* renamed from: a */
    private static final LinkedList<IDrtl<?>> f47556a = new LinkedList<>();

    static {
        ServiceLoader<S> load = ServiceLoader.load(IDrtl.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(IDrtl::class.java)");
        for (S add : load) {
            f47556a.add(add);
        }
        SystemUtils.log(6, TAG, "drtl : " + f47556a.size(), (Throwable) null, "com.didichuxing.drtl.Drtl", 21);
    }

    private Drtl() {
    }

    public final LinkedList<IDrtl<?>> getDrtl() {
        return f47556a;
    }

    @JvmStatic
    public static final void apply(Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "any");
        if (!(objArr.length == 0)) {
            for (Object next : ArraysKt.filterNotNull(objArr)) {
                Collection arrayList = new ArrayList();
                for (Object next2 : f47556a) {
                    if (((IDrtl) next2).filter(next)) {
                        arrayList.add(next2);
                    }
                }
                for (IDrtl onApply : (List) arrayList) {
                    onApply.onApply(next);
                }
            }
        }
    }

    @JvmStatic
    public static final void applyView(View... viewArr) {
        Intrinsics.checkParameterIsNotNull(viewArr, "view");
        if (!(viewArr.length == 0)) {
            for (View allView : ArraysKt.filterNotNull(viewArr)) {
                for (View view : CollectionsKt.filterNotNull(DrtlViewExKt.allView(allView))) {
                    Collection arrayList = new ArrayList();
                    for (Object next : f47556a) {
                        if (((IDrtl) next).filter(view)) {
                            arrayList.add(next);
                        }
                    }
                    for (IDrtl onApply : (List) arrayList) {
                        onApply.onApply(view);
                    }
                }
            }
        }
    }

    public final void rtl(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$rtl");
        apply(obj);
    }
}
