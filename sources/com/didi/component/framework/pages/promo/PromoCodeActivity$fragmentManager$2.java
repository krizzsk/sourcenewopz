package com.didi.component.framework.pages.promo;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentManager;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoCodeActivity.kt */
final class PromoCodeActivity$fragmentManager$2 extends Lambda implements Function0<FragmentManager> {
    final /* synthetic */ PromoCodeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromoCodeActivity$fragmentManager$2(PromoCodeActivity promoCodeActivity) {
        super(0);
        this.this$0 = promoCodeActivity;
    }

    public final FragmentManager invoke() {
        return this.this$0.getSupportFragmentManager();
    }
}
