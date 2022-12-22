package com.didi.payment.creditcard.global.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.payment.base.utils.RTLUtil;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;

public class CardNoWatcher implements TextWatcher {

    /* renamed from: a */
    int f30582a = 0;

    /* renamed from: b */
    int f30583b = 0;

    /* renamed from: c */
    boolean f30584c;

    /* renamed from: d */
    int f30585d = 0;

    /* renamed from: e */
    int f30586e = 0;

    /* renamed from: f */
    private EditText f30587f;

    /* renamed from: g */
    private StringBuffer f30588g = new StringBuffer();

    /* renamed from: h */
    private CardBinCheckListener f30589h;

    public interface CardBinCheckListener {
        void check(String str);

        void reset(String str);
    }

    public CardNoWatcher(EditText editText) {
        this.f30587f = editText;
    }

    public void setCheckListener(CardBinCheckListener cardBinCheckListener) {
        this.f30589h = cardBinCheckListener;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f30582a = charSequence.length();
        if (this.f30588g.length() > 0) {
            StringBuffer stringBuffer = this.f30588g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f30586e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == ' ') {
                this.f30586e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f30583b = charSequence.length();
        this.f30588g.append(charSequence.toString());
        if (this.f30583b == this.f30582a || this.f30584c) {
            this.f30584c = false;
        } else {
            this.f30584c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f30584c) {
            int i = 0;
            while (i < this.f30588g.length()) {
                if (this.f30588g.charAt(i) == ' ') {
                    this.f30588g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f30588g.length() / 4;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f30588g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 4) + (i4 - 1)) {
                            this.f30588g.insert(i3, ' ');
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f30588g.toString();
            int selectionEnd = this.f30587f.getSelectionEnd();
            this.f30585d = selectionEnd;
            int i5 = this.f30586e;
            if (i2 > i5) {
                this.f30585d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f30585d, stringBuffer.length());
            this.f30585d = min;
            int max = Math.max(min, 0);
            this.f30585d = max;
            this.f30585d = Math.min(max, 23);
            this.f30587f.setText(stringBuffer);
            Selection.setSelection(this.f30587f.getText(), this.f30585d);
            this.f30584c = false;
            String replaceAllSpace = PaymentTextUtil.replaceAllSpace(editable.toString());
            if (replaceAllSpace.length() < 6) {
                CardBinCheckListener cardBinCheckListener = this.f30589h;
                if (cardBinCheckListener != null) {
                    cardBinCheckListener.reset(replaceAllSpace);
                    return;
                }
                return;
            }
            CardBinCheckListener cardBinCheckListener2 = this.f30589h;
            if (cardBinCheckListener2 != null) {
                cardBinCheckListener2.check(replaceAllSpace);
            }
        } else if (RTLUtil.isInRTLMode()) {
            int min2 = Math.min(this.f30585d, this.f30587f.getText() != null ? this.f30587f.getText().length() : 0);
            this.f30585d = min2;
            this.f30585d = Math.max(min2, 0);
            Selection.setSelection(this.f30587f.getText(), this.f30585d);
        }
    }
}
