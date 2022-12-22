package com.didi.soda.order.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/order/view/EvaluateDetailBusinessItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemId", "", "itemName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "scoreInfo", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "icon", "Lcom/didi/rfusion/widget/RFIconView;", "picName", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "initView", "", "score", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EvaluateDetailBusinessItemView.kt */
public final class EvaluateDetailBusinessItemView extends LinearLayout {

    /* renamed from: a */
    private RFIconView f43544a;

    /* renamed from: b */
    private CustomerAppCompatTextView f43545b;

    /* renamed from: c */
    private String f43546c;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EvaluateDetailBusinessItemView(Context context) {
        this(context, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EvaluateDetailBusinessItemView(Context context, String str, String str2) {
        this(context, str, str2, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EvaluateDetailBusinessItemView(Context context, String str, String str2, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m30865a(context, str, str2, i);
    }

    /* renamed from: a */
    private final void m30865a(Context context, String str, String str2, int i) {
        this.f43546c = str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_detail_item, this, true);
        View findViewById = inflate.findViewById(R.id.customer_item_evaluation_detail_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…m_evaluation_detail_icon)");
        this.f43544a = (RFIconView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_item_evaluation_detail_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…m_evaluation_detail_text)");
        this.f43545b = (CustomerAppCompatTextView) findViewById2;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (i == 2) {
            RFIconView rFIconView = this.f43544a;
            if (rFIconView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                rFIconView = null;
            }
            rFIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
            RFIconView rFIconView2 = this.f43544a;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                rFIconView2 = null;
            }
            rFIconView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
        } else if (i == 10) {
            RFIconView rFIconView3 = this.f43544a;
            if (rFIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                rFIconView3 = null;
            }
            rFIconView3.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
            RFIconView rFIconView4 = this.f43544a;
            if (rFIconView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                rFIconView4 = null;
            }
            rFIconView4.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
        }
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f43545b;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picName");
        } else {
            customerAppCompatTextView = customerAppCompatTextView2;
        }
        customerAppCompatTextView.setText(str2);
    }
}
