package com.didi.global.widget;

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
    public Context f22933a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText[] f22934b;

    /* renamed from: c */
    private State f22935c = State.INCOMPLETE;

    /* renamed from: d */
    private OnStateChangedListener f22936d;

    /* renamed from: e */
    private int f22937e;

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
        m16504a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16504a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16504a(context);
    }

    /* renamed from: a */
    private void m16504a(Context context) {
        this.f22933a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f22933a, R.layout.global_qr_code_input_layout_new, this);
    }

    public void initView(int i) {
        this.f22937e = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inputContainer);
        linearLayout.removeAllViews();
        this.f22934b = new EditText[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f22934b[i2] = (EditText) LayoutInflater.from(getContext()).inflate(R.layout.global_qr_input_edittext_new, linearLayout, false);
            this.f22934b[i2].setInputType(2);
            this.f22934b[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f22934b[i2].addTextChangedListener(this);
            this.f22934b[i2].setOnFocusChangeListener(this);
            this.f22934b[i2].setOnKeyListener(this);
            this.f22934b[i2].setFocusable(true);
            this.f22934b[i2].setFitsSystemWindows(false);
            linearLayout.addView(this.f22934b[i2]);
            if (i2 < i - 1) {
                linearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.global_qr_input_line_new, linearLayout, false));
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m16503a();
    }

    /* renamed from: a */
    private void m16503a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f22934b[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f22933a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m16508b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m16508b();
        }
    }

    /* renamed from: b */
    private void m16508b() {
        boolean z = false;
        for (EditText editText : this.f22934b) {
            if (m16505a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m16509c();
            return;
        }
        for (EditText editText2 : this.f22934b) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m16510d();
    }

    /* renamed from: a */
    private boolean m16505a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f22933a.getSystemService("input_method");
        for (EditText windowToken : this.f22934b) {
            inputMethodManager.hideSoftInputFromWindow(windowToken.getWindowToken(), 2);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f22937e > 0 && i == 67 && keyEvent.getAction() == 0) {
            for (int i2 = this.f22937e - 1; i2 > 0; i2--) {
                EditText[] editTextArr = this.f22934b;
                if (view == editTextArr[i2] && !m16505a(editTextArr[i2])) {
                    this.f22934b[i2 - 1].setText((CharSequence) null);
                    m16508b();
                }
            }
        }
        return false;
    }

    public State getState() {
        return this.f22935c;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f22936d = onStateChangedListener;
    }

    /* renamed from: c */
    private void m16509c() {
        if (this.f22935c.equals(State.COMPLETE)) {
            this.f22935c = State.INCOMPLETE;
            m16511e();
        }
    }

    /* renamed from: d */
    private void m16510d() {
        if (this.f22935c.equals(State.INCOMPLETE)) {
            this.f22935c = State.COMPLETE;
            m16511e();
        }
    }

    /* renamed from: e */
    private void m16511e() {
        OnStateChangedListener onStateChangedListener = this.f22936d;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f22935c);
        }
    }

    public String getPin() {
        if (this.f22935c != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f22934b) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f22934b) {
            text.getText().clear();
        }
        m16503a();
    }

    public boolean isCompleted() {
        return this.f22935c.equals(State.COMPLETE);
    }
}
