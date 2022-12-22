package com.didi.consume.phone.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class KeyboardEditText extends AppCompatEditText {

    /* renamed from: a */
    KeyboardListener f16382a;

    public interface KeyboardListener {
        void onStateChanged(KeyboardEditText keyboardEditText, boolean z);
    }

    public KeyboardEditText(Context context) {
        super(context);
    }

    public KeyboardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeyboardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        KeyboardListener keyboardListener;
        super.onFocusChanged(z, i, rect);
        if (z && (keyboardListener = this.f16382a) != null) {
            keyboardListener.onStateChanged(this, true);
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        KeyboardListener keyboardListener;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (keyboardListener = this.f16382a) != null) {
            keyboardListener.onStateChanged(this, false);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setOnKeyboardListener(KeyboardListener keyboardListener) {
        this.f16382a = keyboardListener;
    }
}
