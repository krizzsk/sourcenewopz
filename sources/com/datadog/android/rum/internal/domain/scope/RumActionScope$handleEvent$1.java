package com.datadog.android.rum.internal.domain.scope;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumActionScope.kt */
final class RumActionScope$handleEvent$1 extends Lambda implements Function1<WeakReference<Object>, Boolean> {
    public static final RumActionScope$handleEvent$1 INSTANCE = new RumActionScope$handleEvent$1();

    RumActionScope$handleEvent$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((WeakReference<Object>) (WeakReference) obj));
    }

    public final boolean invoke(WeakReference<Object> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "it");
        return weakReference.get() == null;
    }
}
