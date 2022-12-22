package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;

public class CardEditText extends AppCompatEditText {
    public static final int STATE_EDITING = 1;
    public static final int STATE_INVALID = 2;
    public static final int STATE_VALID = 3;

    /* renamed from: b */
    private static final int f30576b = 8;

    /* renamed from: a */
    private int f30577a = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f30578c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnPasteListener f30579d;

    /* renamed from: e */
    private TextWatcher f30580e;

    public interface OnPasteListener {
        void onPaste();
    }

    public enum TYPE {
        CARD_NUMBER,
        DATE,
        CVV
    }

    public CardEditText(Context context) {
        super(context);
        m21510a();
    }

    public CardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21510a();
    }

    public CardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21510a();
    }

    /* renamed from: a */
    private void m21510a() {
        setInputType(2);
    }

    public String getTextWithoutSpace() {
        String obj = super.getText().toString();
        return !TextUtils.isEmpty(obj) ? obj.trim().replaceAll(" ", "") : obj;
    }

    public String getTextString() {
        return super.getText().toString();
    }

    public void setMaxLength(int i) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public void showError() {
        setTextColor(getResources().getColor(R.color.one_payment_creditcard_text_xred));
    }

    public void resetError() {
        setTextColor(getResources().getColor(R.color.one_payment_creditcard_text_xblack));
    }

    public void setState(int i) {
        this.f30577a = i;
    }

    public int getState() {
        return this.f30577a;
    }

    /* renamed from: com.didi.payment.creditcard.global.widget.CardEditText$2 */
    static /* synthetic */ class C107312 {

        /* renamed from: $SwitchMap$com$didi$payment$creditcard$global$widget$CardEditText$TYPE */
        static final /* synthetic */ int[] f30581x9ea07ff2;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.payment.creditcard.global.widget.CardEditText$TYPE[] r0 = com.didi.payment.creditcard.global.widget.CardEditText.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30581x9ea07ff2 = r0
                com.didi.payment.creditcard.global.widget.CardEditText$TYPE r1 = com.didi.payment.creditcard.global.widget.CardEditText.TYPE.CARD_NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30581x9ea07ff2     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.creditcard.global.widget.CardEditText$TYPE r1 = com.didi.payment.creditcard.global.widget.CardEditText.TYPE.DATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30581x9ea07ff2     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.creditcard.global.widget.CardEditText$TYPE r1 = com.didi.payment.creditcard.global.widget.CardEditText.TYPE.CVV     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.widget.CardEditText.C107312.<clinit>():void");
        }
    }

    public void setType(TYPE type) {
        int i = C107312.f30581x9ea07ff2[type.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setInputType(2);
        }
    }

    public boolean onTextContextMenuItem(int i) {
        OnPasteListener onPasteListener = this.f30579d;
        if (onPasteListener != null && i == 16908322) {
            this.f30578c = true;
            onPasteListener.onPaste();
        }
        return super.onTextContextMenuItem(i);
    }

    public void setOnPasteListener(OnPasteListener onPasteListener) {
        this.f30579d = onPasteListener;
        TextWatcher textWatcher = this.f30580e;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
            this.f30580e = null;
        }
        if (onPasteListener != null) {
            C107301 r2 = new TextWatcher() {
                int beforeSize = 0;

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence != null) {
                        this.beforeSize = charSequence.length();
                    }
                }

                public void afterTextChanged(Editable editable) {
                    if (!CardEditText.this.f30578c && CardEditText.this.f30579d != null && editable != null && editable.length() - this.beforeSize > CardEditText.this.m21513b()) {
                        CardEditText.this.f30579d.onPaste();
                    }
                    boolean unused = CardEditText.this.f30578c = false;
                }
            };
            this.f30580e = r2;
            addTextChangedListener(r2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m21513b() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("wallet_screen_shot");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 8;
        }
        return ((Integer) experiment.getParam("paste_count", 8)).intValue();
    }
}
