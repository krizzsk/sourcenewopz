package com.didi.component.evaluate.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class NewCommentView extends FrameLayout implements TextWatcher, View.OnFocusChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f13467a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f13468b;

    /* renamed from: c */
    private InputMethodManager f13469c;

    /* renamed from: d */
    private boolean f13470d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LinearLayout f13471e;

    /* renamed from: f */
    private View f13472f;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean checkInputConnectionProxy(View view) {
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public NewCommentView(Context context) {
        super(context);
        m9222a();
    }

    public NewCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9222a();
    }

    public NewCommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9222a();
    }

    /* renamed from: a */
    private void m9222a() {
        this.f13469c = (InputMethodManager) getContext().getSystemService("input_method");
        LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_comment_input_view, this);
        EditText editText = (EditText) findViewById(R.id.oc_evaluate_comment_view);
        this.f13467a = editText;
        editText.setOnFocusChangeListener(this);
        this.f13467a.addTextChangedListener(this);
        this.f13471e = (LinearLayout) findViewById(R.id.evaluate_comment_layout);
        View findViewById = findViewById(R.id.evaluate_comment_empty_view);
        this.f13472f = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                NewCommentView.this.hideSoftInput();
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.id.evaluate_comment_hint);
        this.f13468b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewCommentView.this.f13468b.setVisibility(8);
                NewCommentView.this.f13471e.setVisibility(0);
                NewCommentView.this.f13467a.requestFocus();
                NewCommentView newCommentView = NewCommentView.this;
                newCommentView.showSoftInput(newCommentView.f13467a);
            }
        });
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f13470d = true;
            return;
        }
        this.f13470d = false;
        hideSoftInput();
        m9226c();
    }

    public void showSoftInput(View view) {
        this.f13469c.showSoftInput(view, 0);
    }

    public void hideSoftInput() {
        this.f13469c.hideSoftInputFromWindow(this.f13467a.getWindowToken(), 0);
    }

    public String getText() {
        return this.f13467a.getText().toString().trim();
    }

    /* renamed from: b */
    private void m9224b() {
        this.f13471e.setVisibility(0);
        this.f13468b.setVisibility(8);
    }

    /* renamed from: c */
    private void m9226c() {
        this.f13471e.setVisibility(8);
        this.f13468b.setVisibility(0);
        this.f13468b.setText(this.f13467a.getText());
    }

    public void clearFocus() {
        super.clearFocus();
        this.f13467a.clearFocus();
    }

    public boolean isFocused() {
        return this.f13467a.isFocused();
    }

    public void setContent(String str) {
        this.f13467a.setVisibility(8);
    }

    public int onKeyboardHeightChange(int i) {
        if (i <= 0 || !this.f13470d) {
            return 0;
        }
        m9224b();
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void setEnable(boolean z) {
        this.f13467a.setEnabled(z);
    }
}
