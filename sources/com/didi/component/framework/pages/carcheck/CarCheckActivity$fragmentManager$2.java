package com.didi.component.framework.pages.carcheck;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentManager;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckActivity.kt */
final class CarCheckActivity$fragmentManager$2 extends Lambda implements Function0<FragmentManager> {
    final /* synthetic */ CarCheckActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CarCheckActivity$fragmentManager$2(CarCheckActivity carCheckActivity) {
        super(0);
        this.this$0 = carCheckActivity;
    }

    public final FragmentManager invoke() {
        return this.this$0.getSupportFragmentManager();
    }
}
