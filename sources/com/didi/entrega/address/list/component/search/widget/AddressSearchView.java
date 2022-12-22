package com.didi.entrega.address.list.component.search.widget;

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
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f19455a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f19456b;

    /* renamed from: c */
    private ImageView f19457c;

    /* renamed from: d */
    private LottieLoadingView f19458d;

    public AddressSearchView(Context context) {
        super(context);
        this.f19455a = context;
        m14565a();
    }

    public AddressSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19455a = context;
        m14565a();
    }

    public void showOrHideLoading(boolean z) {
        m14567b();
        if (z) {
            this.f19458d.setVisibility(0);
            if (!this.f19458d.isRunning()) {
                this.f19458d.start();
            }
            this.f19457c.setVisibility(8);
            return;
        }
        this.f19458d.stop();
        this.f19458d.setVisibility(8);
    }

    public void addTextWatcher(TextWatcher textWatcher) {
        this.f19456b.addTextChangedListener(textWatcher);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f19456b.setFilters(inputFilterArr);
    }

    public void focus() {
        this.f19456b.requestFocus();
    }

    public void clearText() {
        this.f19456b.setText("");
    }

    public void setTextHint(String str) {
        this.f19456b.setHint(str);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f19456b);
    }

    /* renamed from: a */
    private void m14565a() {
        LayoutInflater.from(this.f19455a).inflate(R.layout.entrega_customer_component_address_search, this);
        this.f19458d = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f19456b = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f19457c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressSearchView.this.f19456b.setText("");
            }
        });
        this.f19456b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(AddressSearchView.this.f19455a, view);
                } else {
                    KeyboardUtils.hideSoftInput(AddressSearchView.this.f19455a, view);
                }
            }
        });
    }

    /* renamed from: b */
    private void m14567b() {
        if (TextUtils.isEmpty(this.f19456b.getText().toString())) {
            this.f19457c.setVisibility(8);
        } else {
            this.f19457c.setVisibility(0);
        }
    }
}
