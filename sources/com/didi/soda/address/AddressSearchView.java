package com.didi.soda.address;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f38625a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f38626b;

    /* renamed from: c */
    private ImageView f38627c;

    /* renamed from: d */
    private LottieLoadingView f38628d;

    public AddressSearchView(Context context) {
        super(context);
        this.f38625a = context;
        m27353a();
    }

    public AddressSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38625a = context;
        m27353a();
    }

    public void showOrHideLoading(boolean z) {
        m27355b();
        if (z) {
            this.f38628d.setVisibility(0);
            if (!this.f38628d.isRunning()) {
                this.f38628d.start();
            }
            this.f38627c.setVisibility(8);
            return;
        }
        this.f38628d.stop();
        this.f38628d.setVisibility(8);
    }

    public void addTextWatcher(TextWatcher textWatcher) {
        this.f38626b.addTextChangedListener(textWatcher);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f38626b.setFilters(inputFilterArr);
    }

    public void focus() {
        this.f38626b.requestFocus();
    }

    public void clearText() {
        this.f38626b.setText("");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f38626b);
    }

    /* renamed from: a */
    private void m27353a() {
        LayoutInflater.from(this.f38625a).inflate(R.layout.customer_component_address_search, this);
        this.f38628d = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f38626b = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f38627c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddressSearchView.this.f38626b.setText("");
            }
        });
        this.f38626b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(AddressSearchView.this.f38625a, view);
                } else {
                    KeyboardUtils.hideSoftInput(AddressSearchView.this.f38625a, view);
                }
            }
        });
    }

    /* renamed from: b */
    private void m27355b() {
        if (TextUtils.isEmpty(this.f38626b.getText().toString())) {
            this.f38627c.setVisibility(8);
        } else {
            this.f38627c.setVisibility(0);
        }
    }
}
