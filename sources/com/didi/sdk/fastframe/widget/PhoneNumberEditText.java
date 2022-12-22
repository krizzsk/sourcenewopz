package com.didi.sdk.fastframe.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.EditText;
import com.didi.sdk.apm.SystemUtils;

public class PhoneNumberEditText extends EditText {
    public PhoneNumberEditText(Context context) {
        super(context);
        m25449a();
    }

    public PhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25449a();
    }

    /* renamed from: a */
    private void m25449a() {
        setEditableFactory(new Editable.Factory() {
            public Editable newEditable(CharSequence charSequence) {
                return new PhoneStringBuilder(PhoneNumberEditText.this, charSequence);
            }
        });
    }

    public static class PhoneStringBuilder extends SpannableStringBuilder {
        private EditText editText;

        public PhoneStringBuilder(EditText editText2, CharSequence charSequence) {
            super(charSequence);
            this.editText = editText2;
        }

        private char[] cleanAndFormat(char[] cArr) {
            if (cArr == null) {
                return null;
            }
            int i = 0;
            for (char c : cArr) {
                if (c == ' ') {
                    i++;
                }
            }
            int length = cArr.length - i;
            char[] cArr2 = new char[length];
            int i2 = 0;
            for (int i3 = 0; i3 < cArr.length; i3++) {
                if (cArr[i3] != ' ') {
                    cArr2[i2] = cArr[i3];
                    i2++;
                }
            }
            if (length > 7) {
                char[] cArr3 = new char[(length + 2)];
                System.arraycopy(cArr2, 0, cArr3, 0, 3);
                cArr3[3] = ' ';
                System.arraycopy(cArr2, 3, cArr3, 4, 4);
                cArr3[8] = ' ';
                System.arraycopy(cArr2, 7, cArr3, 9, length - 7);
                return cArr3;
            } else if (length <= 3) {
                return cArr2;
            } else {
                char[] cArr4 = new char[(length + 1)];
                System.arraycopy(cArr2, 0, cArr4, 0, 3);
                cArr4[3] = ' ';
                System.arraycopy(cArr2, 3, cArr4, 4, length - 3);
                return cArr4;
            }
        }

        public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
            SystemUtils.log(3, "SpannableStringBuilder", "replace2: start = " + i + ", end = " + i2 + ",text = " + charSequence, (Throwable) null, "com.didi.sdk.fastframe.widget.PhoneNumberEditText$PhoneStringBuilder", 95);
            return super.replace(i, i2, charSequence);
        }

        public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
            SystemUtils.log(3, "SpannableStringBuilder", "replace1: start = " + i + ", end = " + i2 + ",text = " + charSequence + ",toStart = " + i3 + ", toEnd = " + i4, (Throwable) null, "com.didi.sdk.fastframe.widget.PhoneNumberEditText$PhoneStringBuilder", 127);
            return super.replace(i, i2, charSequence, i3, i4);
        }

        public SpannableStringBuilder delete(int i, int i2) {
            SystemUtils.log(3, "SpannableStringBuilder", "delete: start = " + i + ", end = " + i2, (Throwable) null, "com.didi.sdk.fastframe.widget.PhoneNumberEditText$PhoneStringBuilder", 133);
            return super.delete(i, i2);
        }
    }
}
