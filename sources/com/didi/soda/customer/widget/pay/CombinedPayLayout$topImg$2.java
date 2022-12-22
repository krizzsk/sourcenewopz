package com.didi.soda.customer.widget.pay;

import android.widget.ImageView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CombinedPayLayout.kt */
final class CombinedPayLayout$topImg$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ CombinedPayLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombinedPayLayout$topImg$2(CombinedPayLayout combinedPayLayout) {
        super(0);
        this.this$0 = combinedPayLayout;
    }

    public final ImageView invoke() {
        return (ImageView) this.this$0.findViewById(R.id.customer_pay_combined_card_top);
    }
}
