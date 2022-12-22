package com.didi.soda.business.component.dynamic.search.helper;

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

public class MenuSearchDyView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f39526a;

    /* renamed from: b */
    private View f39527b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f39528c;

    /* renamed from: d */
    private ImageView f39529d;

    /* renamed from: e */
    private LottieLoadingView f39530e;

    /* renamed from: f */
    private View f39531f;

    public MenuSearchDyView(Context context) {
        super(context);
        this.f39526a = context;
        m28073a();
    }

    public MenuSearchDyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39526a = context;
        m28073a();
    }

    public EditText getEditView() {
        return this.f39528c;
    }

    public View getSearchButton() {
        return this.f39527b;
    }

    public void showOrHideLoading(boolean z) {
        m28075b();
        if (z) {
            this.f39530e.setVisibility(0);
            if (!this.f39530e.isRunning()) {
                this.f39530e.start();
            }
            this.f39529d.setVisibility(8);
            this.f39531f.setVisibility(8);
            this.f39527b.setVisibility(8);
            return;
        }
        this.f39530e.stop();
        this.f39530e.setVisibility(8);
        this.f39531f.setVisibility(0);
        this.f39527b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f39528c);
    }

    /* renamed from: a */
    private void m28073a() {
        LayoutInflater.from(this.f39526a).inflate(R.layout.customer_component_dy_menu_search, this);
        this.f39527b = findViewById(R.id.customer_iv_search);
        this.f39530e = (LottieLoadingView) findViewById(R.id.customer_la_search_loading);
        this.f39528c = (EditText) findViewById(R.id.customer_custom_business_search);
        this.f39529d = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f39531f = findViewById(R.id.v_line);
        this.f39529d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuSearchDyView.this.f39528c.setText("");
            }
        });
        this.f39528c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(MenuSearchDyView.this.f39526a, view);
                } else {
                    KeyboardUtils.hideSoftInput(MenuSearchDyView.this.f39526a, view);
                }
                MenuSearchDyView.this.m28075b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28075b() {
        if (TextUtils.isEmpty(this.f39528c.getText().toString())) {
            this.f39529d.setVisibility(8);
        } else {
            this.f39529d.setVisibility(0);
        }
    }
}
