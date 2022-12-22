package com.didi.payment.pix.qrpayee.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/widget/AmountEditText;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "getConfig", "()Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "setConfig", "(Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;)V", "etAmount", "Landroidx/appcompat/widget/AppCompatEditText;", "extraText", "", "floatInputHelper", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "innerWatcher", "Lcom/didi/payment/pix/qrpayee/widget/AmountEditText$IValueValidator;", "tvExtraInfo", "Landroid/widget/TextView;", "tvLabel", "getInputValue", "", "initAmountEditText", "", "initConfig", "configOption", "setDefaultExtraText", "text", "setEditable", "enable", "", "setLabelText", "charSequence", "setValueWatcher", "validator", "IValueValidator", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AmountEditText.kt */
public final class AmountEditText extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IValueValidator f31180a;

    /* renamed from: b */
    private final TextView f31181b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppCompatEditText f31182c;
    public PixTransferOption.TransferOptionInfo config;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TextView f31183d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NFloatInputHelper f31184e;

    /* renamed from: f */
    private CharSequence f31185f;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/widget/AmountEditText$IValueValidator;", "", "onValueChanged", "", "valid", "", "value", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AmountEditText.kt */
    public interface IValueValidator {
        void onValueChanged(boolean z, String str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmountEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f31184e = new NFloatInputHelper();
        View.inflate(context, R.layout.common_amount_edit_lay, this);
        View findViewById = findViewById(R.id.amount_edit_label_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.amount_edit_label_tv)");
        this.f31181b = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.userinput_editview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.userinput_editview)");
        this.f31182c = (AppCompatEditText) findViewById2;
        View findViewById3 = findViewById(R.id.value_exceed_tip_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.value_exceed_tip_tv)");
        this.f31183d = (TextView) findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.AmountEditText, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ditText, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(1);
        setLabelText(string == null ? "" : string);
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
        m21946a();
    }

    public final PixTransferOption.TransferOptionInfo getConfig() {
        PixTransferOption.TransferOptionInfo transferOptionInfo = this.config;
        if (transferOptionInfo != null) {
            return transferOptionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(transferOptionInfo, "<set-?>");
        this.config = transferOptionInfo;
    }

    public final void initConfig(PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(transferOptionInfo, "configOption");
        setConfig(transferOptionInfo);
    }

    public final void setEditable(boolean z) {
        this.f31182c.setEnabled(z);
    }

    public final void setLabelText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        this.f31181b.setText(charSequence);
    }

    public final String getInputValue() {
        return String.valueOf(this.f31182c.getText());
    }

    /* renamed from: a */
    private final void m21946a() {
        this.f31182c.addTextChangedListener(new AmountEditText$initAmountEditText$1(this));
        this.f31182c.setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, this.f31184e.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
    }

    public final void setDefaultExtraText(CharSequence charSequence) {
        this.f31185f = charSequence;
        this.f31183d.setText(charSequence);
        View view = this.f31183d;
        int i = 0;
        if (!(!(charSequence == null || charSequence.length() == 0))) {
            i = 8;
        }
        view.setVisibility(i);
        this.f31183d.setTextColor(-16777216);
    }

    public final void setValueWatcher(IValueValidator iValueValidator) {
        Intrinsics.checkNotNullParameter(iValueValidator, "validator");
        this.f31180a = iValueValidator;
    }
}
