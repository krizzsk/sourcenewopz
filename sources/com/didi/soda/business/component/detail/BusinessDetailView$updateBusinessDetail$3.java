package com.didi.soda.business.component.detail;

import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/widget/LinearLayout;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailView.kt */
final class BusinessDetailView$updateBusinessDetail$3 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ BusinessDetailModel $detailModel;
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$updateBusinessDetail$3(BusinessDetailView businessDetailView, BusinessDetailModel businessDetailModel) {
        super(1);
        this.this$0 = businessDetailView;
        this.$detailModel = businessDetailModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "it");
        TextView access$createTextView = this.this$0.m27884a(14.0f, IToolsService.FontType.LIGHT);
        access$createTextView.setText(this.$detailModel.mDeliveryTypeDesc);
        access$createTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666));
        Resources resources = this.this$0.getResources();
        access$createTextView.setLineSpacing(resources == null ? 0.0f : (float) resources.getDimensionPixelOffset(R.dimen.customer_12px), 1.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Resources resources2 = this.this$0.getResources();
        layoutParams.topMargin = resources2 == null ? 0 : resources2.getDimensionPixelOffset(R.dimen.customer_24px);
        linearLayout.addView(access$createTextView, layoutParams);
    }
}
