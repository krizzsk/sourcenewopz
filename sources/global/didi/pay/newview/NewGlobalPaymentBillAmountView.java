package global.didi.pay.newview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lglobal/didi/pay/newview/NewGlobalPaymentBillAmountView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTextTV", "Landroid/widget/TextView;", "updateBillAmount", "", "billDetail", "Lcom/didi/unifiedPay/sdk/model/BasicBill;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NewGlobalPaymentBillAmountView.kt */
public final class NewGlobalPaymentBillAmountView extends LinearLayout {
    private TextView mTextTV;

    public NewGlobalPaymentBillAmountView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public NewGlobalPaymentBillAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.new_g_payment_amount_bill, this);
        View findViewById = findViewById(R.id.tv_bill_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_bill_amount)");
        this.mTextTV = (TextView) findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewGlobalPaymentBillAmountView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if ((r4.length() > 0) == true) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBillAmount(com.didi.unifiedPay.sdk.model.BasicBill r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x0006
        L_0x0004:
            r2 = 0
            goto L_0x000b
        L_0x0006:
            int r2 = r6.showBillAmount
            if (r2 != r0) goto L_0x0004
            r2 = 1
        L_0x000b:
            r3 = 8
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0013
        L_0x0011:
            r2 = 8
        L_0x0013:
            r5.setVisibility(r2)
            android.widget.TextView r2 = r5.mTextTV
            if (r6 != 0) goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x002e
        L_0x001c:
            java.lang.String r4 = r6.originTotalFeeDisplay
            if (r4 != 0) goto L_0x0021
            goto L_0x001a
        L_0x0021:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x002b
            r4 = 1
            goto L_0x002c
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != r0) goto L_0x001a
        L_0x002e:
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r1 = 8
        L_0x0033:
            r2.setVisibility(r1)
            android.widget.TextView r0 = r5.mTextTV
            if (r6 != 0) goto L_0x003c
            r6 = 0
            goto L_0x003e
        L_0x003c:
            java.lang.String r6 = r6.originTotalFeeDisplay
        L_0x003e:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.newview.NewGlobalPaymentBillAmountView.updateBillAmount(com.didi.unifiedPay.sdk.model.BasicBill):void");
    }
}
