package global.didi.pay.newview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u00002\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lglobal/didi/pay/newview/NewGlobalPaymentTransactionFeeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "explanation", "", "mDisplayPrice", "Landroid/widget/TextView;", "mImageQuestion", "Landroid/widget/ImageView;", "mSlashPrice", "setFeeClickListener", "listener", "Lkotlin/Function1;", "", "updateTransactionFee", "fee", "Lcom/didi/unifiedPay/sdk/model/TransactionFee;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NewGlobalPaymentTransactionFeeView.kt */
public final class NewGlobalPaymentTransactionFeeView extends LinearLayout {
    private String explanation;
    private TextView mDisplayPrice;
    private ImageView mImageQuestion;
    private TextView mSlashPrice;

    public NewGlobalPaymentTransactionFeeView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public NewGlobalPaymentTransactionFeeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.new_g_payment_transaction_fee, this);
        View findViewById = findViewById(R.id.tv_trans_fee_display);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_trans_fee_display)");
        this.mDisplayPrice = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tv_trans_fee_slash);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_trans_fee_slash)");
        this.mSlashPrice = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.img_trans_fee_question_mark);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.img_trans_fee_question_mark)");
        this.mImageQuestion = (ImageView) findViewById3;
        this.mSlashPrice.getPaint().setFlags(16);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewGlobalPaymentTransactionFeeView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0072, code lost:
        if ((r5.length() <= 0) != true) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateTransactionFee(com.didi.unifiedPay.sdk.model.TransactionFee r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 != 0) goto L_0x0006
        L_0x0004:
            r2 = 0
            goto L_0x000b
        L_0x0006:
            boolean r2 = r9.enabled
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
            r8.setVisibility(r2)
            android.widget.TextView r2 = r8.mDisplayPrice
            if (r9 != 0) goto L_0x001c
        L_0x001a:
            r4 = 0
            goto L_0x002f
        L_0x001c:
            java.lang.String r4 = r9.actualPayDisplay
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
            r4 = 1
        L_0x002f:
            if (r4 == 0) goto L_0x0033
            r4 = 0
            goto L_0x0035
        L_0x0033:
            r4 = 8
        L_0x0035:
            r2.setVisibility(r4)
            android.widget.TextView r2 = r8.mSlashPrice
            r4 = 0
            if (r9 != 0) goto L_0x003f
            r5 = r4
            goto L_0x0045
        L_0x003f:
            long r5 = r9.actualPay
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
        L_0x0045:
            if (r9 != 0) goto L_0x0049
            r6 = r4
            goto L_0x004f
        L_0x0049:
            long r6 = r9.shouldPay
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
        L_0x004f:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0058
            r5 = 8
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            r2.setVisibility(r5)
            android.widget.ImageView r2 = r8.mImageQuestion
            if (r9 != 0) goto L_0x0062
        L_0x0060:
            r0 = 0
            goto L_0x0074
        L_0x0062:
            java.lang.String r5 = r9.explanation
            if (r5 != 0) goto L_0x0067
            goto L_0x0060
        L_0x0067:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0071
            r5 = 1
            goto L_0x0072
        L_0x0071:
            r5 = 0
        L_0x0072:
            if (r5 != r0) goto L_0x0060
        L_0x0074:
            if (r0 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r1 = 8
        L_0x0079:
            r2.setVisibility(r1)
            android.widget.TextView r0 = r8.mDisplayPrice
            if (r9 != 0) goto L_0x0082
            r1 = r4
            goto L_0x0084
        L_0x0082:
            java.lang.String r1 = r9.actualPayDisplay
        L_0x0084:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r8.mSlashPrice
            if (r9 != 0) goto L_0x008f
            r1 = r4
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = r9.shouldPayDisplay
        L_0x0091:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            if (r9 != 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            java.lang.String r4 = r9.explanation
        L_0x009b:
            r8.explanation = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.newview.NewGlobalPaymentTransactionFeeView.updateTransactionFee(com.didi.unifiedPay.sdk.model.TransactionFee):void");
    }

    public final NewGlobalPaymentTransactionFeeView setFeeClickListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        NewGlobalPaymentTransactionFeeView newGlobalPaymentTransactionFeeView = this;
        UIUtils.setTouchDelegate(newGlobalPaymentTransactionFeeView.mImageQuestion, UIUtils.dip2px(newGlobalPaymentTransactionFeeView.getContext(), 10.0f));
        newGlobalPaymentTransactionFeeView.mImageQuestion.setOnClickListener(new View.OnClickListener(newGlobalPaymentTransactionFeeView) {
            public final /* synthetic */ NewGlobalPaymentTransactionFeeView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                NewGlobalPaymentTransactionFeeView.m47655setFeeClickListener$lambda1$lambda0(Function1.this, this.f$1, view);
            }
        });
        return newGlobalPaymentTransactionFeeView;
    }

    /* access modifiers changed from: private */
    /* renamed from: setFeeClickListener$lambda-1$lambda-0  reason: not valid java name */
    public static final void m47655setFeeClickListener$lambda1$lambda0(Function1 function1, NewGlobalPaymentTransactionFeeView newGlobalPaymentTransactionFeeView, View view) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        Intrinsics.checkNotNullParameter(newGlobalPaymentTransactionFeeView, "$this_apply");
        function1.invoke(newGlobalPaymentTransactionFeeView.explanation);
    }
}
