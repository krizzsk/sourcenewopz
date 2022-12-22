package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.passenger.C10448R;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001*\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u0010\u0010)\u001a\u00020*X\u000e¢\u0006\u0004\n\u0002\u0010+R$\u0010,\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR$\u0010/\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000204\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u000204\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u000e\u0010<\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/widget/WalletAmountEditText;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amountValue", "", "getAmountValue", "()Ljava/lang/String;", "value", "", "currency", "getCurrency", "()Ljava/lang/CharSequence;", "setCurrency", "(Ljava/lang/CharSequence;)V", "enableExceed", "", "etAmount", "Landroid/widget/TextView;", "extraText", "getExtraText", "setExtraText", "extraTextColor", "getExtraTextColor", "()I", "setExtraTextColor", "(I)V", "floatInputHelper", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "getFloatInputHelper", "()Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "floatInputHelper$delegate", "Lkotlin/Lazy;", "labelText", "getLabelText", "setLabelText", "maxAmountInputFilter", "com/didi/payment/commonsdk/widget/WalletAmountEditText$maxAmountInputFilter$1", "Lcom/didi/payment/commonsdk/widget/WalletAmountEditText$maxAmountInputFilter$1;", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "onAmountValidListener", "Lkotlin/Function1;", "", "getOnAmountValidListener", "()Lkotlin/jvm/functions/Function1;", "setOnAmountValidListener", "(Lkotlin/jvm/functions/Function1;)V", "onExceedListener", "getOnExceedListener", "setOnExceedListener", "tvCurrency", "tvExtra", "tvLabel", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletAmountEditText.kt */
public final class WalletAmountEditText extends LinearLayout {

    /* renamed from: a */
    private final TextView f30247a;

    /* renamed from: b */
    private final TextView f30248b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final TextView f30249c;

    /* renamed from: d */
    private final TextView f30250d;

    /* renamed from: e */
    private final Lazy f30251e;

    /* renamed from: f */
    private boolean f30252f;

    /* renamed from: g */
    private Function1<? super Boolean, Unit> f30253g;

    /* renamed from: h */
    private WalletAmountEditText$maxAmountInputFilter$1 f30254h;

    /* renamed from: i */
    private Function1<? super Boolean, Unit> f30255i;

    /* renamed from: j */
    private CharSequence f30256j;

    /* renamed from: k */
    private CharSequence f30257k;

    /* renamed from: l */
    private int f30258l;

    /* renamed from: m */
    private int f30259m;

    /* renamed from: n */
    private CharSequence f30260n;

    /* renamed from: o */
    private int f30261o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletAmountEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletAmountEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletAmountEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletAmountEditText(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f30251e = LazyKt.lazy(WalletAmountEditText$floatInputHelper$2.INSTANCE);
        this.f30252f = true;
        this.f30254h = new WalletAmountEditText$maxAmountInputFilter$1(this);
        this.f30257k = "R$";
        this.f30258l = -1;
        this.f30259m = -1;
        this.f30261o = ContextCompat.getColor(context, R.color.wallet_color_666666);
        View.inflate(context, R.layout.widget_wallet_amount_edit_text, this);
        setOrientation(1);
        View findViewById = findViewById(R.id.tv_label);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_label)");
        this.f30247a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tv_currency);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_currency)");
        this.f30248b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.et_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.et_amount)");
        this.f30249c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tv_extra);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_extra)");
        this.f30250d = (TextView) findViewById4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.WalletAmountEditText, i, 0);
        String string = obtainStyledAttributes.getString(4);
        setLabelText(string == null ? getLabelText() : string);
        String string2 = obtainStyledAttributes.getString(0);
        setCurrency(string2 == null ? getCurrency() : string2);
        setMinValue(obtainStyledAttributes.getInteger(6, getMinValue()));
        setMaxValue(obtainStyledAttributes.getInteger(5, getMaxValue()));
        String string3 = obtainStyledAttributes.getString(2);
        setExtraText(string3 == null ? getExtraText() : string3);
        setExtraTextColor(obtainStyledAttributes.getColor(3, getExtraTextColor()));
        this.f30252f = obtainStyledAttributes.getBoolean(1, this.f30252f);
        obtainStyledAttributes.recycle();
        if (this.f30252f) {
            this.f30249c.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ WalletAmountEditText this$0;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                {
                    this.this$0 = r1;
                }

                public void afterTextChanged(Editable editable) {
                    String valueOf = String.valueOf(editable);
                    if (TextUtils.isEmpty(valueOf)) {
                        Function1<Boolean, Unit> onAmountValidListener = this.this$0.getOnAmountValidListener();
                        if (onAmountValidListener != null) {
                            onAmountValidListener.invoke(false);
                            return;
                        }
                        return;
                    }
                    WalletAmountEditText walletAmountEditText = this.this$0;
                    Context context = context;
                    float parseFloatValue = walletAmountEditText.getFloatInputHelper().parseFloatValue(valueOf);
                    if (parseFloatValue <= 0.0f) {
                        Function1<Boolean, Unit> onAmountValidListener2 = walletAmountEditText.getOnAmountValidListener();
                        if (onAmountValidListener2 != null) {
                            onAmountValidListener2.invoke(false);
                        }
                    } else if (walletAmountEditText.getMaxValue() < 0 || MathUtil.dollarToCent(parseFloatValue) <= walletAmountEditText.getMaxValue()) {
                        walletAmountEditText.f30249c.setTextColor(ContextCompat.getColor(context, R.color.black));
                        Function1<Boolean, Unit> onAmountValidListener3 = walletAmountEditText.getOnAmountValidListener();
                        if (onAmountValidListener3 != null) {
                            onAmountValidListener3.invoke(true);
                        }
                    } else {
                        walletAmountEditText.f30249c.setTextColor(ContextCompat.getColor(context, R.color.global_red));
                        Function1<Boolean, Unit> onAmountValidListener4 = walletAmountEditText.getOnAmountValidListener();
                        if (onAmountValidListener4 != null) {
                            onAmountValidListener4.invoke(false);
                        }
                    }
                }
            });
            return;
        }
        InputFilter[] filters = this.f30249c.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "etAmount.filters");
        Collection mutableList = ArraysKt.toMutableList((T[]) (Object[]) filters);
        mutableList.add(this.f30254h);
        TextView textView = this.f30249c;
        Object[] array = mutableList.toArray(new InputFilter[0]);
        if (array != null) {
            textView.setFilters((InputFilter[]) array);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* access modifiers changed from: private */
    public final NFloatInputHelper getFloatInputHelper() {
        return (NFloatInputHelper) this.f30251e.getValue();
    }

    public final Function1<Boolean, Unit> getOnExceedListener() {
        return this.f30253g;
    }

    public final void setOnExceedListener(Function1<? super Boolean, Unit> function1) {
        this.f30253g = function1;
    }

    public final Function1<Boolean, Unit> getOnAmountValidListener() {
        return this.f30255i;
    }

    public final void setOnAmountValidListener(Function1<? super Boolean, Unit> function1) {
        this.f30255i = function1;
    }

    public final CharSequence getLabelText() {
        return this.f30256j;
    }

    public final void setLabelText(CharSequence charSequence) {
        this.f30256j = charSequence;
        this.f30247a.setText(charSequence);
    }

    public final CharSequence getCurrency() {
        return this.f30257k;
    }

    public final void setCurrency(CharSequence charSequence) {
        this.f30257k = charSequence;
        this.f30248b.setText(charSequence);
    }

    public final int getMinValue() {
        return this.f30258l;
    }

    public final void setMinValue(int i) {
        this.f30258l = i;
        invalidate();
    }

    public final int getMaxValue() {
        return this.f30259m;
    }

    public final void setMaxValue(int i) {
        this.f30259m = i;
        invalidate();
    }

    public final CharSequence getExtraText() {
        return this.f30260n;
    }

    public final void setExtraText(CharSequence charSequence) {
        this.f30260n = charSequence;
        this.f30250d.setText(charSequence);
        TextView textView = this.f30250d;
        CharSequence charSequence2 = this.f30260n;
        int i = 0;
        if (charSequence2 == null || charSequence2.length() == 0) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public final int getExtraTextColor() {
        return this.f30261o;
    }

    public final void setExtraTextColor(int i) {
        this.f30261o = i;
        this.f30250d.setTextColor(i);
    }

    public final String getAmountValue() {
        return this.f30249c.getText().toString();
    }
}
