package com.didi.soda.search.component.header;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class SearchView extends RelativeLayout {

    /* renamed from: a */
    private Context f43698a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AppCompatEditText f43699b;

    /* renamed from: c */
    private ImageView f43700c;

    /* renamed from: d */
    private View f43701d;

    /* renamed from: e */
    private RelativeLayout f43702e;

    /* renamed from: f */
    private RFIconView f43703f;

    /* renamed from: g */
    private LottieLoadingView f43704g;

    public SearchView(Context context) {
        super(context);
        this.f43698a = context;
        m31018a();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43698a = context;
        m31018a();
    }

    public EditText getEditView() {
        return this.f43699b;
    }

    public RFIconView getSearchButton() {
        return this.f43703f;
    }

    public void showOrHideLoading(boolean z) {
        if (z) {
            this.f43704g.setVisibility(0);
            if (!this.f43704g.isRunning()) {
                this.f43704g.start();
            }
            this.f43700c.setVisibility(8);
            this.f43701d.setVisibility(8);
            this.f43703f.setVisibility(8);
            this.f43702e.setSelected(false);
            return;
        }
        this.f43704g.stop();
        this.f43704g.setVisibility(8);
        this.f43702e.setSelected(true);
        if (TextUtils.isEmpty(this.f43699b.getText().toString())) {
            this.f43700c.setVisibility(8);
        } else {
            this.f43700c.setVisibility(0);
        }
        this.f43701d.setVisibility(0);
        this.f43703f.setVisibility(0);
    }

    public void goneAllRightView() {
        this.f43700c.setVisibility(8);
        this.f43701d.setVisibility(8);
        this.f43703f.setVisibility(8);
        this.f43702e.setSelected(false);
    }

    public void visibleAllRightView() {
        if (this.f43704g.getVisibility() != 0) {
            if (TextUtils.isEmpty(this.f43699b.getText().toString())) {
                this.f43700c.setVisibility(8);
            } else {
                this.f43700c.setVisibility(0);
            }
            this.f43701d.setVisibility(0);
            this.f43703f.setVisibility(0);
            this.f43702e.setSelected(true);
        }
    }

    /* renamed from: a */
    private void m31018a() {
        LayoutInflater.from(this.f43698a).inflate(R.layout.customer_view_search, this);
        this.f43699b = (AppCompatEditText) findViewById(R.id.customer_custom_address_search);
        this.f43700c = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f43701d = findViewById(R.id.v_line);
        this.f43702e = (RelativeLayout) findViewById(R.id.customer_rl_address_search);
        this.f43703f = (RFIconView) findViewById(R.id.customer_iv_search);
        LottieLoadingView lottieLoadingView = (LottieLoadingView) findViewById(R.id.customer_la_search_loading);
        this.f43704g = lottieLoadingView;
        lottieLoadingView.hide();
        this.f43700c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchView.this.f43699b.setText("");
            }
        });
    }
}
