package com.didi.soda.bill.widgets.btn;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/btn/BillPayLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "confirmBtn", "Landroid/widget/TextView;", "getConfirmBtn", "()Landroid/widget/TextView;", "setConfirmBtn", "(Landroid/widget/TextView;)V", "confirmLayout", "Landroid/view/View;", "getConfirmLayout", "()Landroid/view/View;", "setConfirmLayout", "(Landroid/view/View;)V", "loadingView", "Lcom/didi/rfusion/widget/loading/RFLottieLoadingView;", "rightBottomText", "rightTopText", "getPayButtonCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "setRightText", "", "top", "", "bottom", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPayLayout.kt */
public final class BillPayLayout extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private View f39297a;

    /* renamed from: b */
    private TextView f39298b;

    /* renamed from: c */
    private TextView f39299c;

    /* renamed from: d */
    private TextView f39300d;

    /* renamed from: e */
    private RFLottieLoadingView f39301e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillPayLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.customer_bill_widget_pay, this);
        View findViewById = findViewById(R.id.customer_bill_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_bill_confirm)");
        this.f39298b = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_custom_bottom_shadow_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…tom_bottom_shadow_button)");
        this.f39297a = findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_bottom_button_right_top_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…om_button_right_top_text)");
        this.f39299c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…button_right_bottom_text)");
        this.f39300d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_bill_layout_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_bill_layout_loading)");
        this.f39301e = (RFLottieLoadingView) findViewById5;
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this.f39299c, 10, 24, 1, 1);
    }

    public final View getConfirmLayout() {
        return this.f39297a;
    }

    public final void setConfirmLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f39297a = view;
    }

    public final TextView getConfirmBtn() {
        return this.f39298b;
    }

    public final void setConfirmBtn(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f39298b = textView;
    }

    public final void setRightText(String str, String str2) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            this.f39299c.setVisibility(8);
        } else {
            this.f39299c.setText(charSequence);
            this.f39299c.setVisibility(0);
        }
        CharSequence charSequence2 = str2;
        if (TextUtils.isEmpty(charSequence2)) {
            this.f39300d.setVisibility(8);
            return;
        }
        this.f39300d.setText(charSequence2);
        this.f39300d.setVisibility(0);
    }

    public final ICustomerPayManager.CartPayButtonCallback getPayButtonCallback() {
        return new Companion.PayButtonCallback(this.f39298b, this.f39301e, getContext());
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/btn/BillPayLayout$Companion;", "", "()V", "PayButtonCallback", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillPayLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/btn/BillPayLayout$Companion$PayButtonCallback;", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "payBtn", "Landroid/widget/TextView;", "loadingView", "Lcom/didi/rfusion/widget/loading/RFLottieLoadingView;", "context", "Landroid/content/Context;", "(Landroid/widget/TextView;Lcom/didi/rfusion/widget/loading/RFLottieLoadingView;Landroid/content/Context;)V", "mContext", "Ljava/lang/ref/WeakReference;", "mLoadingLottie", "mPayBtn", "fail", "", "businessId", "", "hideLoading", "isLoading", "", "loading", "setLoading", "setRightTextVisibility", "visibility", "", "success", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: BillPayLayout.kt */
        public static final class PayButtonCallback implements ICustomerPayManager.CartPayButtonCallback {
            private final WeakReference<Context> mContext;
            private final WeakReference<RFLottieLoadingView> mLoadingLottie;
            private final WeakReference<TextView> mPayBtn;

            public PayButtonCallback(TextView textView, RFLottieLoadingView rFLottieLoadingView, Context context) {
                this.mContext = new WeakReference<>(context);
                this.mPayBtn = new WeakReference<>(textView);
                this.mLoadingLottie = new WeakReference<>(rFLottieLoadingView);
            }

            public void fail(String str) {
                LogUtil.m29104i("CustomerBillView", Intrinsics.stringPlus("PayButtonCallback fail businessId = ", str));
                hideLoading();
            }

            public void loading() {
                LogUtil.m29104i("CustomerBillView", "PayButtonCallback loading");
                if (this.mPayBtn.get() != null) {
                    setLoading(true);
                    setRightTextVisibility(4);
                }
            }

            public boolean isLoading() {
                LogUtil.m29104i("CustomerBillView", "PayButtonCallback isLoading");
                RFLottieLoadingView rFLottieLoadingView = (RFLottieLoadingView) this.mLoadingLottie.get();
                if (rFLottieLoadingView == null) {
                    return false;
                }
                return rFLottieLoadingView.isRunning();
            }

            public void hideLoading() {
                TextView textView;
                LogUtil.m29104i("CustomerBillView", "PayButtonCallback hideLoading");
                DialogUtil.hideBlockDialog();
                if (this.mPayBtn.get() != null && (textView = (TextView) this.mPayBtn.get()) != null) {
                    setLoading(false);
                    setRightTextVisibility(0);
                    textView.setVisibility(0);
                    if (this.mContext.get() != null) {
                        Object obj = this.mContext.get();
                        Intrinsics.checkNotNull(obj);
                        textView.setText(((Context) obj).getResources().getString(R.string.customer_pay));
                    }
                }
            }

            public void success(String str) {
                TextView textView;
                LogUtil.m29104i("CustomerBillView", Intrinsics.stringPlus("PayButtonCallback success ", str));
                DialogUtil.hideBlockDialog();
                if (this.mPayBtn.get() != null && (textView = (TextView) this.mPayBtn.get()) != null) {
                    setLoading(false);
                    textView.setVisibility(0);
                    if (this.mContext.get() != null) {
                        Object obj = this.mContext.get();
                        Intrinsics.checkNotNull(obj);
                        textView.setText(((Context) obj).getResources().getString(R.string.customer_name_pay_success));
                    }
                }
            }

            private final void setRightTextVisibility(int i) {
                TextView textView;
                TextView textView2;
                CharSequence charSequence;
                TextView textView3 = (TextView) this.mPayBtn.get();
                CharSequence charSequence2 = null;
                if (textView3 == null) {
                    textView = null;
                } else {
                    textView = (TextView) textView3.findViewById(R.id.customer_tv_bottom_button_right_top_text);
                }
                TextView textView4 = (TextView) this.mPayBtn.get();
                if (textView4 == null) {
                    textView2 = null;
                } else {
                    textView2 = (TextView) textView4.findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
                }
                if (textView == null) {
                    charSequence = null;
                } else {
                    charSequence = textView.getText();
                }
                if (!TextUtils.isEmpty(charSequence) && textView != null) {
                    textView.setVisibility(i);
                }
                if (textView2 != null) {
                    charSequence2 = textView2.getText();
                }
                if (!TextUtils.isEmpty(charSequence2) && textView2 != null) {
                    textView2.setVisibility(i);
                }
            }

            private final void setLoading(boolean z) {
                if (z) {
                    RFLottieLoadingView rFLottieLoadingView = (RFLottieLoadingView) this.mLoadingLottie.get();
                    if (rFLottieLoadingView != null) {
                        rFLottieLoadingView.show();
                    }
                    TextView textView = (TextView) this.mPayBtn.get();
                    if (textView != null) {
                        textView.setVisibility(4);
                        return;
                    }
                    return;
                }
                RFLottieLoadingView rFLottieLoadingView2 = (RFLottieLoadingView) this.mLoadingLottie.get();
                if (rFLottieLoadingView2 != null) {
                    rFLottieLoadingView2.hide();
                }
                TextView textView2 = (TextView) this.mPayBtn.get();
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
        }

        private Companion() {
        }
    }
}
