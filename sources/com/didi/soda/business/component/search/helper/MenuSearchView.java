package com.didi.soda.business.component.search.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class MenuSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f39661a;

    /* renamed from: b */
    private View f39662b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f39663c;

    /* renamed from: d */
    private ImageView f39664d;

    /* renamed from: e */
    private LottieLoadingView f39665e;

    public MenuSearchView(Context context) {
        super(context);
        this.f39661a = context;
        m28242a();
    }

    public MenuSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39661a = context;
        m28242a();
    }

    public EditText getEditView() {
        return this.f39663c;
    }

    public View getSearchButton() {
        return this.f39662b;
    }

    public void showOrHideLoading(boolean z) {
        m28244b();
        if (z) {
            this.f39665e.setVisibility(0);
            if (!this.f39665e.isRunning()) {
                this.f39665e.start();
            }
            this.f39664d.setVisibility(8);
            return;
        }
        this.f39665e.stop();
        this.f39665e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f39663c);
    }

    /* renamed from: a */
    private void m28242a() {
        LayoutInflater.from(this.f39661a).inflate(R.layout.customer_component_menu_search, this);
        this.f39662b = findViewById(R.id.customer_iv_address_search_icon);
        this.f39665e = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f39663c = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f39664d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuSearchView.this.f39663c.setText("");
            }
        });
        this.f39663c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(MenuSearchView.this.f39661a, view);
                } else {
                    KeyboardUtils.hideSoftInput(MenuSearchView.this.f39661a, view);
                }
                MenuSearchView.this.m28244b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28244b() {
        if (TextUtils.isEmpty(this.f39663c.getText().toString())) {
            this.f39664d.setVisibility(8);
        } else {
            this.f39664d.setVisibility(0);
        }
    }
}
