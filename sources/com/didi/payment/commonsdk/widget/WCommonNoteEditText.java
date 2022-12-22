package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.taxis99.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#J\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/widget/WCommonNoteEditText;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "inputEt", "Landroidx/appcompat/widget/AppCompatEditText;", "getInputEt", "()Landroidx/appcompat/widget/AppCompatEditText;", "setInputEt", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "inputLeftTv", "Landroid/widget/TextView;", "getInputLeftTv", "()Landroid/widget/TextView;", "setInputLeftTv", "(Landroid/widget/TextView;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "setLayoutInflater", "(Landroid/view/LayoutInflater;)V", "maxAcceptLength", "getMaxAcceptLength", "()I", "setMaxAcceptLength", "(I)V", "getInputVal", "", "setHintText", "", "hint", "setMaxInputLength", "maxLength", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WCommonNoteEditText.kt */
public final class WCommonNoteEditText extends LinearLayout {

    /* renamed from: a */
    private LayoutInflater f30243a;

    /* renamed from: b */
    private int f30244b;

    /* renamed from: c */
    private AppCompatEditText f30245c;

    /* renamed from: d */
    private TextView f30246d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WCommonNoteEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.f30243a = from;
        this.f30244b = 140;
        from.inflate(R.layout.note_text_input, this);
        View findViewById = findViewById(R.id.append_info_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.append_info_et)");
        this.f30245c = (AppCompatEditText) findViewById;
        View findViewById2 = findViewById(R.id.input_left_number_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.input_left_number_tv)");
        this.f30246d = (TextView) findViewById2;
        setMaxInputLength(this.f30244b);
        this.f30245c.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ WCommonNoteEditText this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                String valueOf = String.valueOf(editable);
                WCommonNoteEditText wCommonNoteEditText = this.this$0;
                TextView inputLeftTv = wCommonNoteEditText.getInputLeftTv();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(valueOf.length()), Integer.valueOf(wCommonNoteEditText.getMaxAcceptLength())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                inputLeftTv.setText(format);
                if (valueOf.length() >= wCommonNoteEditText.getMaxAcceptLength()) {
                    wCommonNoteEditText.getInputLeftTv().setTextColor(wCommonNoteEditText.getResources().getColor(R.color.global_red));
                } else {
                    wCommonNoteEditText.getInputLeftTv().setTextColor(wCommonNoteEditText.getResources().getColor(R.color.wallet_color_919599));
                }
            }
        });
        this.f30245c.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f30244b)});
    }

    public final LayoutInflater getLayoutInflater() {
        return this.f30243a;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "<set-?>");
        this.f30243a = layoutInflater;
    }

    public final int getMaxAcceptLength() {
        return this.f30244b;
    }

    public final void setMaxAcceptLength(int i) {
        this.f30244b = i;
    }

    public final AppCompatEditText getInputEt() {
        return this.f30245c;
    }

    public final void setInputEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.f30245c = appCompatEditText;
    }

    public final TextView getInputLeftTv() {
        return this.f30246d;
    }

    public final void setInputLeftTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f30246d = textView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WCommonNoteEditText(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WCommonNoteEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setMaxInputLength(int i) {
        if (i > 0) {
            this.f30244b = i;
            this.f30245c.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f30244b)});
            TextView textView = this.f30246d;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("0/%d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
    }

    public final void setHintText(String str) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.HINT_KEY);
        this.f30245c.setHint(str);
    }

    public final String getInputVal() {
        return String.valueOf(this.f30245c.getText());
    }
}
