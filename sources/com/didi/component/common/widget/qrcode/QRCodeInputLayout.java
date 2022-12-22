package com.didi.component.common.widget.qrcode;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class QRCodeInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {

    /* renamed from: b */
    private static final int f12080b = 8;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12081a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText[] f12082c;

    /* renamed from: d */
    private int[] f12083d = {R.id.oc_pin_input_edit_text_1, R.id.oc_pin_input_edit_text_2, R.id.oc_pin_input_edit_text_3, R.id.oc_pin_input_edit_text_4, R.id.oc_pin_input_edit_text_5, R.id.oc_pin_input_edit_text_6, R.id.oc_pin_input_edit_text_7, R.id.oc_pin_input_edit_text_8};

    /* renamed from: e */
    private State f12084e = State.INCOMPLETE;

    /* renamed from: f */
    private OnStateChangedListener f12085f;

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
        m8136a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8136a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8136a(context);
    }

    /* renamed from: a */
    private void m8136a(Context context) {
        this.f12081a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f12081a, R.layout.global_qr_code_input_layout, this);
        this.f12082c = new EditText[8];
        for (int i = 0; i < 8; i++) {
            this.f12082c[i] = (EditText) findViewById(this.f12083d[i]);
            this.f12082c[i].setInputType(2);
            this.f12082c[i].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f12082c[i].addTextChangedListener(this);
            this.f12082c[i].setOnFocusChangeListener(this);
            this.f12082c[i].setOnKeyListener(this);
            this.f12082c[i].setFocusable(true);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m8135a();
    }

    /* renamed from: a */
    private void m8135a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f12082c[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f12081a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m8140b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m8140b();
        }
    }

    /* renamed from: b */
    private void m8140b() {
        boolean z = false;
        for (EditText editText : this.f12082c) {
            if (m8137a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m8141c();
            return;
        }
        for (EditText editText2 : this.f12082c) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m8142d();
    }

    /* renamed from: a */
    private boolean m8137a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        ((InputMethodManager) this.f12081a.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        for (int i2 = 7; i2 > 0; i2--) {
            EditText[] editTextArr = this.f12082c;
            if (view == editTextArr[i2] && !m8137a(editTextArr[i2])) {
                this.f12082c[i2 - 1].setText((CharSequence) null);
                m8140b();
            }
        }
        return false;
    }

    public State getState() {
        return this.f12084e;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f12085f = onStateChangedListener;
    }

    /* renamed from: c */
    private void m8141c() {
        if (this.f12084e.equals(State.COMPLETE)) {
            this.f12084e = State.INCOMPLETE;
            m8143e();
        }
    }

    /* renamed from: d */
    private void m8142d() {
        if (this.f12084e.equals(State.INCOMPLETE)) {
            this.f12084e = State.COMPLETE;
            m8143e();
        }
    }

    /* renamed from: e */
    private void m8143e() {
        OnStateChangedListener onStateChangedListener = this.f12085f;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f12084e);
        }
    }

    public String getPin() {
        if (this.f12084e != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f12082c) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f12082c) {
            text.getText().clear();
        }
        m8135a();
    }

    public boolean isCompleted() {
        return this.f12084e.equals(State.COMPLETE);
    }
}
