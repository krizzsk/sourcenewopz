package com.didi.soda.business.component.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
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
final class BusinessDetailView$renderPhoneItemView$1 extends Lambda implements Function1<LinearLayout, Unit> {
    final /* synthetic */ List<String> $phoneList;
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$renderPhoneItemView$1(List<String> list, BusinessDetailView businessDetailView) {
        super(1);
        this.$phoneList = list;
        this.this$0 = businessDetailView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinearLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        int size = this.$phoneList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                TextView access$createTextView = this.this$0.m27884a(14.0f, IToolsService.FontType.LIGHT);
                String str = this.$phoneList.get(i);
                if (str != null) {
                    access$createTextView.setText(str);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    Resources resources = this.this$0.getResources();
                    layoutParams.topMargin = resources == null ? 0 : resources.getDimensionPixelOffset(R.dimen.customer_24px);
                    access$createTextView.setOnClickListener(new View.OnClickListener(str) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            BusinessDetailView$renderPhoneItemView$1.m46812invoke$lambda0(BusinessDetailView.this, this.f$1, view);
                        }
                    });
                    linearLayout.addView(access$createTextView, layoutParams);
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m46812invoke$lambda0(BusinessDetailView businessDetailView, String str, View view) {
        Intrinsics.checkNotNullParameter(businessDetailView, "this$0");
        Intrinsics.checkNotNullParameter(str, "$phone");
        Context access$getMContext$p = businessDetailView.f39413b;
        if (access$getMContext$p == null) {
            access$getMContext$p = GlobalContext.getContext();
        }
        CustomerSystemUtil.doCall(access$getMContext$p, str);
    }
}
