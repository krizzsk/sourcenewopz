package com.didi.soda.home.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class InputPhoneLayout extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f43303a;

    /* renamed from: b */
    private LinearLayout f43304b;

    /* renamed from: c */
    private TextView f43305c;

    public InputPhoneLayout(Context context) {
        super(context);
        m30625a();
    }

    public InputPhoneLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30625a();
    }

    public InputPhoneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30625a();
    }

    public void focus() {
        this.f43303a.post(new Runnable() {
            public final void run() {
                InputPhoneLayout.this.m30627b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30627b() {
        this.f43303a.requestFocus();
    }

    public EditText getEditTextView() {
        return this.f43303a;
    }

    public String getPhone() {
        return this.f43303a.getText().toString();
    }

    public void setOnCodeClickListener(View.OnClickListener onClickListener) {
        this.f43304b.setOnClickListener(onClickListener);
    }

    public void updateCode(String str) {
        this.f43305c.setText(str);
    }

    /* renamed from: a */
    private void m30625a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_view_home_input_phone, this);
        this.f43304b = (LinearLayout) findViewById(R.id.customer_ll_input_code_layout);
        this.f43305c = (TextView) findViewById(R.id.customer_tv_code_text);
        EditText editText = (EditText) findViewById(R.id.customer_custom_input_phone);
        this.f43303a = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                InputPhoneLayout.this.m30626a(view, z);
            }
        });
        this.f43303a.setTextSize(1, 16.0f);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43303a, IToolsService.FontType.LIGHT);
        this.f43303a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    InputPhoneLayout.this.f43303a.setTextSize(1, 16.0f);
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(InputPhoneLayout.this.f43303a, IToolsService.FontType.LIGHT);
                    return;
                }
                InputPhoneLayout.this.f43303a.setTextSize(1, 24.0f);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(InputPhoneLayout.this.f43303a, IToolsService.FontType.MEDIUM);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30626a(View view, boolean z) {
        if (z) {
            KeyboardUtils.showSoftInput(getContext(), view);
        } else {
            KeyboardUtils.hideSoftInput(getContext(), view);
        }
    }
}
