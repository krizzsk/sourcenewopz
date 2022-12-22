package com.didi.component.common.widget.pin;

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
import android.widget.RelativeLayout;
import com.taxis99.R;

public class PinInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {

    /* renamed from: a */
    private Context f12064a;

    /* renamed from: b */
    private RelativeLayout f12065b;

    /* renamed from: c */
    private RelativeLayout f12066c;

    /* renamed from: d */
    private RelativeLayout f12067d;

    /* renamed from: e */
    private EditText f12068e;

    /* renamed from: f */
    private EditText f12069f;

    /* renamed from: g */
    private EditText f12070g;

    /* renamed from: h */
    private boolean f12071h = true;

    /* renamed from: i */
    private State f12072i = State.INCOMPLETE;

    /* renamed from: j */
    private OnStateChangedListener f12073j;

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

    public PinInputLayout(Context context) {
        super(context);
        m8128a(context);
    }

    public PinInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8128a(context);
    }

    public PinInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8128a(context);
    }

    /* renamed from: a */
    private void m8128a(Context context) {
        this.f12064a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f12064a, R.layout.global_pin_input_layout, this);
        this.f12065b = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_1);
        this.f12066c = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_2);
        this.f12067d = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_3);
        this.f12068e = (EditText) findViewById(R.id.oc_pin_input_edit_text_1);
        this.f12069f = (EditText) findViewById(R.id.oc_pin_input_edit_text_2);
        this.f12070g = (EditText) findViewById(R.id.oc_pin_input_edit_text_3);
        this.f12068e.setInputType(2);
        this.f12068e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f12068e.addTextChangedListener(this);
        this.f12068e.setOnFocusChangeListener(this);
        this.f12068e.setOnKeyListener(this);
        this.f12068e.setFocusable(true);
        this.f12069f.setInputType(2);
        this.f12069f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f12069f.addTextChangedListener(this);
        this.f12069f.setOnFocusChangeListener(this);
        this.f12069f.setOnKeyListener(this);
        this.f12069f.setFocusable(false);
        this.f12070g.setInputType(2);
        this.f12070g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f12070g.addTextChangedListener(this);
        this.f12070g.setOnFocusChangeListener(this);
        this.f12070g.setOnKeyListener(this);
        this.f12070g.setFocusable(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m8127a();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m8127a();
        }
    }

    /* renamed from: a */
    private void m8127a() {
        if (!m8129a(this.f12068e)) {
            this.f12068e.setFocusable(true);
            this.f12068e.setFocusableInTouchMode(true);
            this.f12068e.requestFocus();
            this.f12069f.setFocusable(false);
            this.f12070g.setFocusable(false);
            m8131c();
        } else if (!m8129a(this.f12069f)) {
            this.f12069f.setFocusable(true);
            this.f12069f.setFocusableInTouchMode(true);
            this.f12069f.requestFocus();
            this.f12068e.setFocusable(false);
            this.f12070g.setFocusable(false);
            m8131c();
        } else if (!m8129a(this.f12070g)) {
            this.f12070g.setFocusable(true);
            this.f12070g.setFocusableInTouchMode(true);
            this.f12070g.requestFocus();
            this.f12068e.setFocusable(false);
            this.f12069f.setFocusable(false);
            m8131c();
        } else {
            this.f12068e.setFocusable(true);
            this.f12068e.setFocusableInTouchMode(true);
            this.f12069f.setFocusable(true);
            this.f12069f.setFocusableInTouchMode(true);
            this.f12070g.setFocusable(true);
            this.f12070g.setFocusableInTouchMode(true);
            requestFocus();
            m8130b();
            m8132d();
        }
    }

    /* renamed from: a */
    private boolean m8129a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    /* renamed from: b */
    private void m8130b() {
        ((InputMethodManager) this.f12064a.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        EditText editText = this.f12070g;
        if (view != editText || m8129a(editText)) {
            EditText editText2 = this.f12069f;
            if (view != editText2 || m8129a(editText2)) {
                return false;
            }
            this.f12068e.setText((CharSequence) null);
            m8127a();
            return false;
        }
        this.f12069f.setText((CharSequence) null);
        m8127a();
        return false;
    }

    public State getState() {
        return this.f12072i;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f12073j = onStateChangedListener;
    }

    /* renamed from: c */
    private void m8131c() {
        if (this.f12072i.equals(State.COMPLETE)) {
            this.f12072i = State.INCOMPLETE;
            m8133e();
        }
    }

    /* renamed from: d */
    private void m8132d() {
        if (this.f12072i.equals(State.INCOMPLETE)) {
            this.f12072i = State.COMPLETE;
            m8133e();
        }
    }

    /* renamed from: e */
    private void m8133e() {
        OnStateChangedListener onStateChangedListener = this.f12073j;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f12072i);
        }
    }

    public String getPin() {
        if (this.f12072i != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12068e.getText());
        sb.append(this.f12069f.getText());
        sb.append(this.f12070g.getText());
        return sb.toString();
    }

    public void setEditable(boolean z) {
        if (z) {
            this.f12065b.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f12066c.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f12067d.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f12068e.setEnabled(true);
            this.f12069f.setEnabled(true);
            this.f12070g.setEnabled(true);
        } else {
            this.f12065b.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f12066c.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f12067d.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f12068e.setEnabled(false);
            this.f12069f.setEnabled(false);
            this.f12070g.setEnabled(false);
        }
        this.f12071h = z;
    }

    public boolean isEditable() {
        return this.f12071h;
    }

    public boolean isCompleted() {
        return this.f12072i.equals(State.COMPLETE);
    }
}
