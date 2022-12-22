package com.didi.soda.business.component.detail;

import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "linearLayout", "Landroid/widget/LinearLayout;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailView.kt */
final class BusinessDetailView$renderOpenTimeItemView$1 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ List<BusinessDetailModel.BusinessOpenDayModel> $mBizOpenDayList;
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$renderOpenTimeItemView$1(List<? extends BusinessDetailModel.BusinessOpenDayModel> list, BusinessDetailView businessDetailView) {
        super(1);
        this.$mBizOpenDayList = list;
        this.this$0 = businessDetailView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        int size = this.$mBizOpenDayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                BusinessDetailModel.BusinessOpenDayModel businessOpenDayModel = this.$mBizOpenDayList.get(i);
                if (businessOpenDayModel != null) {
                    TextView access$createTextView = this.this$0.m27884a(14.0f, IToolsService.FontType.MEDIUM);
                    access$createTextView.setText(businessOpenDayModel.mDayDesc);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    Resources resources = this.this$0.getResources();
                    layoutParams.topMargin = resources == null ? 0 : resources.getDimensionPixelOffset(R.dimen.customer_24px);
                    linearLayout.addView(access$createTextView, layoutParams);
                    this.this$0.m27901b(linearLayout, businessOpenDayModel.mTimeDesc);
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
