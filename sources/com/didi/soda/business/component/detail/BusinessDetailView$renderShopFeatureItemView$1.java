package com.didi.soda.business.component.detail;

import android.widget.LinearLayout;
import com.didi.soda.business.model.BusinessDetailModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "linearLayout", "Landroid/widget/LinearLayout;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailView.kt */
final class BusinessDetailView$renderShopFeatureItemView$1 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ BusinessDetailModel.ShopFeatureTipModel $shopFeatureTipModel;
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$renderShopFeatureItemView$1(BusinessDetailView businessDetailView, BusinessDetailModel.ShopFeatureTipModel shopFeatureTipModel) {
        super(1);
        this.this$0 = businessDetailView;
        this.$shopFeatureTipModel = shopFeatureTipModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        this.this$0.m27887a(linearLayout, this.$shopFeatureTipModel);
    }
}
