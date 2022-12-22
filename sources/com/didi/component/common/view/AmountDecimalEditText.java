package com.didi.component.common.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.global.didi.elvish.Elvish;
import java.util.StringTokenizer;

public class AmountDecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f11809a = 13;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f11810b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f11811c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f11812d = ".";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f11813e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CustomizedAfterTextChangeListener f11814f;

    public interface CustomizedAfterTextChangeListener {
        void afterTextChanged(String str);
    }

    /* renamed from: a */
    private boolean m8002a(int i) {
        return i >= 0 && i <= 10;
    }

    public void setCustomizedAfterTextChangeListener(CustomizedAfterTextChangeListener customizedAfterTextChangeListener) {
        this.f11814f = customizedAfterTextChangeListener;
    }

    public AmountDecimalEditText(Context context) {
        super(context);
        m8004b();
    }

    public AmountDecimalEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8004b();
    }

    public AmountDecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8004b();
    }

    public void setAllowZero(boolean z) {
        this.f11813e = z;
    }

    /* renamed from: a */
    private void m8001a() {
        StringBuilder sb = new StringBuilder("0");
        if (m8002a(this.f11810b)) {
            if (this.f11810b > 0) {
                sb.append(this.f11812d);
            }
            for (int i = this.f11810b; i > 0; i--) {
                sb.append("0");
            }
        }
    }

    /* renamed from: b */
    private void m8004b() {
        int numberPrecision = Elvish.Companion.getInstance().getNumberPrecision(1);
        if (m8002a(numberPrecision)) {
            this.f11810b = numberPrecision;
        }
        String decimalSymbol = Elvish.Companion.getInstance().getDecimalSymbol();
        if (!TextUtils.isEmpty(decimalSymbol)) {
            this.f11812d = decimalSymbol;
        }
        String groupSymbol = Elvish.Companion.getInstance().getGroupSymbol();
        if (groupSymbol != null && !this.f11812d.equals(groupSymbol)) {
            this.f11811c = groupSymbol;
        }
        setImeOptions(6);
        m8001a();
        if (this.f11810b <= 0) {
            setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        } else {
            setKeyListener(DigitsKeyListener.getInstance("0123456789" + this.f11812d));
        }
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned != null ? spanned.toString() : "";
                if (AmountDecimalEditText.this.f11810b == 0 && charSequence != null && charSequence.equals(AmountDecimalEditText.this.f11812d)) {
                    return "";
                }
                if (charSequence != null && charSequence.equals(AmountDecimalEditText.this.f11812d) && obj.length() == 0) {
                    return "0" + AmountDecimalEditText.this.f11812d;
                } else if (!obj.contains(AmountDecimalEditText.this.f11812d) || i4 - obj.indexOf(AmountDecimalEditText.this.f11812d) < AmountDecimalEditText.this.f11810b + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(13)});
        addTextChangedListener(new NumberTextWatcherForThousand(this));
    }

    public int getDecimalNumber() {
        return this.f11810b;
    }

    public void setDecimalNumber(int i) {
        if (m8002a(i)) {
            this.f11810b = i;
            m8001a();
        }
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
            String editTextString = getEditTextString(this.editText);
            try {
                this.editText.removeTextChangedListener(this);
                if (editTextString != null && !editTextString.equals("")) {
                    if (editTextString.startsWith(AmountDecimalEditText.this.f11812d)) {
                        EditText editText2 = this.editText;
                        editText2.setText("0" + AmountDecimalEditText.this.f11812d);
                    }
                    if (editTextString.startsWith("0")) {
                        if (!editTextString.startsWith("0" + AmountDecimalEditText.this.f11812d)) {
                            if (!AmountDecimalEditText.this.f11813e) {
                                this.editText.setText("");
                            } else {
                                this.editText.setText("0");
                            }
                        }
                    }
                    this.editText.setText(getDecimalFormat(getEditTextString(this.editText).replace(AmountDecimalEditText.this.f11811c, "")));
                    this.editText.setSelection(getEditTextString(this.editText).length());
                }
                this.editText.addTextChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
                this.editText.addTextChangedListener(this);
            }
            String editTextString2 = getEditTextString(this.editText);
            if (AmountDecimalEditText.this.f11814f != null) {
                AmountDecimalEditText.this.f11814f.afterTextChanged(editTextString2);
            }
            if (editTextString2.contains(AmountDecimalEditText.this.f11812d) || AmountDecimalEditText.this.f11810b <= 0) {
                this.editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                return;
            }
            EditText editText3 = this.editText;
            editText3.setKeyListener(DigitsKeyListener.getInstance("0123456789" + AmountDecimalEditText.this.f11812d));
        }

        private String getEditTextString(EditText editText2) {
            Editable text = editText2 != null ? editText2.getText() : null;
            return text != null ? text.toString() : "";
        }

        public String getDecimalFormat(String str) {
            String str2;
            StringTokenizer stringTokenizer = new StringTokenizer(str, AmountDecimalEditText.this.f11812d);
            if (stringTokenizer.countTokens() > 1) {
                str = stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (str.charAt(str.length() - 1) == AmountDecimalEditText.this.f11812d.charAt(0)) {
                length--;
                sb = new StringBuilder(AmountDecimalEditText.this.f11812d);
            }
            int i = 0;
            while (length >= 0) {
                if (i == 3) {
                    sb.insert(0, AmountDecimalEditText.this.f11811c);
                    i = 0;
                }
                sb.insert(0, str.charAt(length));
                i++;
                length--;
            }
            if (AmountDecimalEditText.this.f11810b > 0 && str2 != null && str2.length() > 0) {
                if (str2.length() <= AmountDecimalEditText.this.f11810b) {
                    sb.append(AmountDecimalEditText.this.f11812d);
                    sb.append(str2);
                } else {
                    sb.append(AmountDecimalEditText.this.f11812d);
                    sb.append(str2.substring(0, AmountDecimalEditText.this.f11810b));
                }
            }
            return sb.toString();
        }
    }
}
