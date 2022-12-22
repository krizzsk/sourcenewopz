package com.didi.component.openride.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class QRCodeInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f14765a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText[] f14766b;

    /* renamed from: c */
    private State f14767c = State.INCOMPLETE;

    /* renamed from: d */
    private OnStateChangedListener f14768d;

    /* renamed from: e */
    private int f14769e;

    public interface OnStateChangedListener {
        void onStateChanged(State state);
    }

    public enum State {
        INCOMPLETE,
        COMPLETE
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public QRCodeInputLayout(Context context) {
        super(context);
        m10548a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10548a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10548a(context);
    }

    /* renamed from: a */
    private void m10548a(Context context) {
        this.f14765a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f14765a, R.layout.view_layout_global_qr_code_input, this);
    }

    public void initView(int i) {
        this.f14769e = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inputContainer);
        linearLayout.removeAllViews();
        this.f14766b = new EditText[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f14766b[i2] = (EditText) LayoutInflater.from(getContext()).inflate(R.layout.view_layout_global_qr_input_edittext, linearLayout, false);
            this.f14766b[i2].setInputType(2);
            this.f14766b[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f14766b[i2].addTextChangedListener(this);
            this.f14766b[i2].setOnFocusChangeListener(this);
            this.f14766b[i2].setOnKeyListener(this);
            this.f14766b[i2].setFocusable(true);
            this.f14766b[i2].setFitsSystemWindows(false);
            linearLayout.addView(this.f14766b[i2]);
            if (i2 < i - 1) {
                linearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.view_layout_global_qr_input_line, linearLayout, false));
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m10547a();
    }

    /* renamed from: a */
    private void m10547a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f14766b[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f14765a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m10552b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m10552b();
        }
    }

    /* renamed from: b */
    private void m10552b() {
        boolean z = false;
        for (EditText editText : this.f14766b) {
            if (m10549a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m10553c();
            return;
        }
        for (EditText editText2 : this.f14766b) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m10554d();
    }

    /* renamed from: a */
    private boolean m10549a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f14765a.getSystemService("input_method");
        for (EditText windowToken : this.f14766b) {
            inputMethodManager.hideSoftInputFromWindow(windowToken.getWindowToken(), 2);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f14769e > 0 && i == 67 && keyEvent.getAction() == 0) {
            for (int i2 = this.f14769e - 1; i2 > 0; i2--) {
                EditText[] editTextArr = this.f14766b;
                if (view == editTextArr[i2] && !m10549a(editTextArr[i2])) {
                    this.f14766b[i2 - 1].setText((CharSequence) null);
                    m10552b();
                }
            }
        }
        return false;
    }

    public State getState() {
        return this.f14767c;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f14768d = onStateChangedListener;
    }

    /* renamed from: c */
    private void m10553c() {
        if (this.f14767c.equals(State.COMPLETE)) {
            this.f14767c = State.INCOMPLETE;
            m10555e();
        }
    }

    /* renamed from: d */
    private void m10554d() {
        if (this.f14767c.equals(State.INCOMPLETE)) {
            this.f14767c = State.COMPLETE;
            m10555e();
        }
    }

    /* renamed from: e */
    private void m10555e() {
        OnStateChangedListener onStateChangedListener = this.f14768d;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f14767c);
        }
    }

    public String getPin() {
        if (this.f14767c != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f14766b) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f14766b) {
            text.getText().clear();
        }
        m10547a();
    }

    public boolean isCompleted() {
        return this.f14767c.equals(State.COMPLETE);
    }
}
