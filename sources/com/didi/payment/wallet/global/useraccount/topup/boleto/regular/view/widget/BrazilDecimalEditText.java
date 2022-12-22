package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities.WalletBoletoCashinActivity;
import com.taxis99.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.StringTokenizer;

public class BrazilDecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f32000a = 13;

    /* renamed from: b */
    private static final int f32001b = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f32002d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f32003e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f32004c;

    public BrazilDecimalEditText(Context context) {
        this(context, (AttributeSet) null, R.attr.editTextStyle);
    }

    public BrazilDecimalEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public BrazilDecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32004c = 2;
        m22658c();
    }

    /* renamed from: c */
    private void m22658c() {
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols();
        f32002d = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        f32003e = Character.toString(decimalFormatSymbols.getDecimalSeparator());
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned.toString();
                if (BrazilDecimalEditText.this.f32004c == 0 && charSequence.equals(BrazilDecimalEditText.f32003e)) {
                    return "";
                }
                if (charSequence.equals(BrazilDecimalEditText.f32003e) && obj.length() == 0) {
                    return "0" + BrazilDecimalEditText.f32003e;
                } else if (!obj.contains(BrazilDecimalEditText.f32003e) || i4 - obj.indexOf(BrazilDecimalEditText.f32003e) < BrazilDecimalEditText.this.f32004c + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(13)});
        addTextChangedListener(new NumberTextWatcherForThousand(this));
    }

    public int getDecimalNumber() {
        return this.f32004c;
    }

    public void setDecimalNumber(int i) {
        this.f32004c = i;
    }

    public static String trimStringToNormalDecimalFormat(String str) {
        String replaceAll = str.replaceAll("\\" + f32002d, "");
        return replaceAll.replaceAll("\\" + f32003e, "\\.");
    }

    class NumberTextWatcherForThousand implements TextWatcher {
        EditText editText;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public NumberTextWatcherForThousand(EditText editText2) {
            this.editText = editText2;
        }

        public void afterTextChanged(Editable editable) {
            try {
                this.editText.removeTextChangedListener(this);
                String obj = this.editText.getText().toString();
                if (!obj.equals("")) {
                    if (obj.startsWith(BrazilDecimalEditText.f32003e)) {
                        EditText editText2 = this.editText;
                        editText2.setText("0" + BrazilDecimalEditText.f32003e);
                    }
                    if (obj.startsWith("0")) {
                        if (!obj.startsWith("0" + BrazilDecimalEditText.f32003e)) {
                            this.editText.setText("");
                        }
                    }
                    this.editText.setText(getDecimalFormat(this.editText.getText().toString().replaceAll("\\" + BrazilDecimalEditText.f32002d, "")));
                    this.editText.setSelection(this.editText.getText().toString().length());
                }
                this.editText.addTextChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
                this.editText.addTextChangedListener(this);
            }
            if (editable.toString().contains(BrazilDecimalEditText.f32003e)) {
                this.editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
            } else {
                EditText editText3 = this.editText;
                editText3.setKeyListener(DigitsKeyListener.getInstance("0123456789" + BrazilDecimalEditText.f32003e));
            }
            if (BrazilDecimalEditText.this.getContext() instanceof WalletBoletoCashinActivity) {
                ((WalletBoletoCashinActivity) BrazilDecimalEditText.this.getContext()).updateUIAfterEditTextChanged();
            }
        }

        public String getDecimalFormat(String str) {
            String str2;
            StringTokenizer stringTokenizer = new StringTokenizer(str, BrazilDecimalEditText.f32003e);
            if (stringTokenizer.countTokens() > 1) {
                str = stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (str.charAt(str.length() - 1) == BrazilDecimalEditText.f32003e.charAt(0)) {
                length--;
                sb = new StringBuilder(BrazilDecimalEditText.f32003e);
            }
            int i = 0;
            while (length >= 0) {
                if (i == 3) {
                    sb.insert(0, BrazilDecimalEditText.f32002d);
                    i = 0;
                }
                sb.insert(0, str.charAt(length));
                i++;
                length--;
            }
            if (str2.length() > 0) {
                sb.append(BrazilDecimalEditText.f32003e);
                sb.append(str2);
            }
            return sb.toString();
        }
    }
}
