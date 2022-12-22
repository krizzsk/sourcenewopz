package com.datadog.android.rum.tracking;

import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "", "", "it", "Landroidx/fragment/app/Fragment;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$onActivityStarted$1$navControllerFragmentCallbacks$1 */
/* compiled from: NavigationViewTrackingStrategy.kt */
final class C2208x2b42a531 extends Lambda implements Function1<Fragment, Map<String, ? extends Object>> {
    public static final C2208x2b42a531 INSTANCE = new C2208x2b42a531();

    C2208x2b42a531() {
        super(1);
    }

    public final Map<String, Object> invoke(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "it");
        return MapsKt.emptyMap();
    }
}
