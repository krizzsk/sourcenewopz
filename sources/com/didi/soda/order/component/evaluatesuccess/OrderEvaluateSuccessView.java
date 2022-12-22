package com.didi.soda.order.component.evaluatesuccess;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.component.evaluatesuccess.Contract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatesuccess/OrderEvaluateSuccessView;", "Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessView;", "()V", "mAfterSaleEntranceTextView", "Landroid/widget/TextView;", "mAfterSaleUrl", "", "mBackButton", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mHeaderLeftBackView", "Lcom/didi/soda/customer/widget/text/IconTextView;", "mSuccessDescTextView", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreate", "", "setAfterSaleText", "url", "updateUI", "evaluationFeedback", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluateSuccessView.kt */
public final class OrderEvaluateSuccessView extends Contract.AbsOrderEvaluateSuccessView {

    /* renamed from: a */
    private TextView f43429a;

    /* renamed from: b */
    private TextView f43430b;

    /* renamed from: c */
    private IconTextView f43431c;

    /* renamed from: d */
    private RFMainButton f43432d;

    /* renamed from: e */
    private String f43433e;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_order_evaluate_success, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_success_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.customer_tv_success_desc)");
        this.f43429a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_rtv_after_sale);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.customer_rtv_after_sale)");
        this.f43430b = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_itv_evaluate_success_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.cus…tv_evaluate_success_back)");
        this.f43431c = (IconTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.bt_evaluate_go_back);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.bt_evaluate_go_back)");
        this.f43432d = (RFMainButton) findViewById4;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…t_evaluate_go_back)\n    }");
        return inflate;
    }

    public void onCreate() {
        super.onCreate();
        RFMainButton rFMainButton = this.f43432d;
        IconTextView iconTextView = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackButton");
            rFMainButton = null;
        }
        rFMainButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateSuccessView.m30744a(OrderEvaluateSuccessView.this, view);
            }
        });
        IconTextView iconTextView2 = this.f43431c;
        if (iconTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLeftBackView");
        } else {
            iconTextView = iconTextView2;
        }
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateSuccessView.m30746b(OrderEvaluateSuccessView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30744a(OrderEvaluateSuccessView orderEvaluateSuccessView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateSuccessView, "this$0");
        ((Contract.AbsOrderEvaluateSuccessPresenter) orderEvaluateSuccessView.getPresenter()).goBack();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30746b(OrderEvaluateSuccessView orderEvaluateSuccessView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateSuccessView, "this$0");
        ((Contract.AbsOrderEvaluateSuccessPresenter) orderEvaluateSuccessView.getPresenter()).goBack();
    }

    public void updateUI(OrderEvaluationResultEntity.EvaluationFeedBackEntity evaluationFeedBackEntity) {
        TextView textView = this.f43429a;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSuccessDescTextView");
            textView = null;
        }
        String feedbackText = evaluationFeedBackEntity == null ? null : evaluationFeedBackEntity.getFeedbackText();
        if (feedbackText == null) {
            feedbackText = "";
        }
        textView.setText(feedbackText);
        if (evaluationFeedBackEntity != null) {
            str = evaluationFeedBackEntity.getAftersaleUrl();
        }
        this.f43433e = str;
        if (str != null) {
            m30745a(str);
        }
    }

    /* renamed from: a */
    private final void m30745a(String str) {
        String string = ResourceHelper.getString(R.string.FoodC_didifood_If_you_wcKE);
        String string2 = ResourceHelper.getString(R.string.FoodC_didifood_Enter_vWvo);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + string2 + ' ');
        spannableStringBuilder.setSpan(new OrderEvaluateSuccessView$setAfterSaleText$1(this, str), string.length(), string.length() + string2.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.rf_color_brands_1_100)), string.length(), string.length() + string2.length(), 33);
        TextView textView = this.f43430b;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAfterSaleEntranceTextView");
            textView = null;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = this.f43430b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAfterSaleEntranceTextView");
        } else {
            textView2 = textView3;
        }
        textView2.setText(spannableStringBuilder);
    }
}
