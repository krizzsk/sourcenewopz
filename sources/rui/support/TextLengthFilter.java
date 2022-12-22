package rui.support;

import android.text.InputFilter;
import android.text.Spanned;

public final class TextLengthFilter implements InputFilter {
    public static final int NO_FILTER_TEXT_LENGTH = -1;

    /* renamed from: b */
    private static final String f6819b = "...";

    /* renamed from: a */
    private MaxTextLengthCallback f6820a;

    /* renamed from: c */
    private int f6821c;

    /* renamed from: d */
    private boolean f6822d = true;

    public interface MaxTextLengthCallback {
        void onMaxTextLength(int i);
    }

    public TextLengthFilter(int i) {
        this.f6821c = i;
    }

    public void setMaxLengthCallback(MaxTextLengthCallback maxTextLengthCallback) {
        this.f6820a = maxTextLengthCallback;
    }

    public void disableShowCutOffHint() {
        this.f6822d = false;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = this.f6821c;
        if (i5 == -1) {
            return null;
        }
        int i6 = i4 - i3;
        int length = i5 - (spanned.length() - i6);
        if (length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        MaxTextLengthCallback maxTextLengthCallback = this.f6820a;
        if (maxTextLengthCallback != null) {
            maxTextLengthCallback.onMaxTextLength(this.f6821c);
        }
        CharSequence subSequence = charSequence.subSequence(i, length + i);
        if (!this.f6822d || i6 != 0) {
            return subSequence;
        }
        return subSequence + f6819b;
    }
}
