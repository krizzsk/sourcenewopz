package com.didi.payment.wallet.global.account.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class WalletInputView extends RelativeLayout {

    /* renamed from: a */
    private TextView f31736a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f31737b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f31738c;

    /* renamed from: d */
    private View f31739d;

    /* renamed from: e */
    private int f31740e;

    public WalletInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22513a(context);
    }

    /* renamed from: a */
    private void m22513a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_input_view, this, true);
        this.f31736a = (TextView) findViewById(R.id.wallet_input_title);
        this.f31737b = (ImageView) findViewById(R.id.wallet_delete_btn);
        this.f31738c = (EditText) findViewById(R.id.wallet_input_et);
        this.f31739d = findViewById(R.id.wallet_input_bottom_line);
        m22512a();
    }

    /* renamed from: a */
    private void m22512a() {
        this.f31737b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletInputView.this.f31738c.setText("");
            }
        });
        this.f31738c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(WalletInputView.this.f31738c.getText().toString())) {
                    WalletInputView.this.f31737b.setVisibility(8);
                } else {
                    WalletInputView.this.f31737b.setVisibility(0);
                }
            }
        });
        this.f31738c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                WalletInputView.this.m22515a(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22515a(boolean z) {
        if (z) {
            if (!TextUtils.isEmpty(this.f31738c.getText().toString())) {
                this.f31737b.setVisibility(0);
            }
            this.f31739d.setBackgroundColor(getContext().getResources().getColor(R.color.wallet_common_black));
            return;
        }
        this.f31737b.setVisibility(8);
        this.f31739d.setBackgroundColor(getContext().getResources().getColor(R.color.wallet_item_divider));
    }

    public void initConfig(String str, int i, int i2) {
        this.f31736a.setText(str);
        this.f31738c.setInputType(i2);
        this.f31738c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        this.f31740e = i;
    }

    public String getInputString() {
        return this.f31738c.getText().toString();
    }

    public void setInputString(String str) {
        this.f31738c.setText(str);
    }

    public void setTextChangeListener(TextWatcher textWatcher) {
        this.f31738c.addTextChangedListener(textWatcher);
    }

    public void setFilter(InputFilter inputFilter) {
        this.f31738c.setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(this.f31740e)});
    }
}
