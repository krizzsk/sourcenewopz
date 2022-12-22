package com.didi.component.payentrance.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.common.view.RichTextView;
import com.taxis99.R;

public class PayentranceLoadingView extends FrameLayout {

    /* renamed from: a */
    private ImageView f15014a;

    /* renamed from: b */
    private View f15015b;

    /* renamed from: c */
    private RichTextView f15016c;

    /* renamed from: d */
    private AnimationDrawable f15017d;

    public PayentranceLoadingView(Context context) {
        super(context);
        m10772a();
    }

    public PayentranceLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10772a();
    }

    public PayentranceLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10772a();
    }

    /* renamed from: a */
    private void m10772a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_pe_loading_view, this);
        this.f15014a = (ImageView) findViewById(R.id.oc_dot_loading_view);
        this.f15015b = findViewById(R.id.oc_loading_mask);
        this.f15017d = (AnimationDrawable) this.f15014a.getDrawable();
        this.f15016c = (RichTextView) findViewById(R.id.oc_loading_error_view);
    }

    public void showMask() {
        hideError();
        this.f15015b.setVisibility(0);
    }

    public void hideMask() {
        this.f15015b.setVisibility(8);
    }

    public void showLoading() {
        hideError();
        if (this.f15014a.getVisibility() != 0) {
            this.f15014a.setVisibility(0);
        }
        if (!this.f15017d.isRunning()) {
            this.f15017d.start();
        }
    }

    public void hideLoading() {
        if (this.f15014a.getVisibility() != 8) {
            this.f15014a.setVisibility(8);
        }
        if (this.f15017d.isRunning()) {
            this.f15017d.stop();
        }
    }

    public void showError(CharSequence charSequence) {
        hideMask();
        hideLoading();
        this.f15016c.setText(charSequence);
        this.f15016c.setVisibility(0);
    }

    public void hideError() {
        this.f15016c.setVisibility(8);
    }

    public void showError() {
        hideMask();
        this.f15016c.setVisibility(0);
    }
}
