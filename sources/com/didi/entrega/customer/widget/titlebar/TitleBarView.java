package com.didi.entrega.customer.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class TitleBarView extends ConstraintLayout {

    /* renamed from: a */
    View f20623a;

    /* renamed from: b */
    RFIconView f20624b;

    /* renamed from: c */
    TextView f20625c;

    /* renamed from: d */
    TextView f20626d;

    /* renamed from: e */
    CharSequence f20627e;

    /* renamed from: f */
    CharSequence f20628f;

    /* renamed from: g */
    CharSequence f20629g;

    /* renamed from: h */
    OnBackClickListener f20630h;

    /* renamed from: i */
    OnRightClickListener f20631i;

    public TitleBarView(Context context) {
        super(context);
        m15078a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15079a(context, attributeSet, 0);
        m15078a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15079a(context, attributeSet, i);
        m15078a(context);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.f20630h = onBackClickListener;
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.f20631i = onRightClickListener;
    }

    public void setOnRightClickListener(String str, OnRightClickListener onRightClickListener) {
        setRightText(str);
        this.f20631i = onRightClickListener;
    }

    public void setBackIconText(int i) {
        this.f20624b.setText(i);
    }

    public void hideBackView() {
        this.f20624b.setVisibility(8);
    }

    public View getContainer() {
        return this.f20623a;
    }

    public RFIconView getBackView() {
        return this.f20624b;
    }

    public TextView getTitleView() {
        return this.f20625c;
    }

    public void setTitleText(int i) {
        this.f20625c.setText(i);
    }

    public void setTitleText(String str) {
        this.f20625c.setText(str);
    }

    public void setRigthText(int i) {
        this.f20626d.setText(i);
    }

    public void setRightText(String str) {
        if (str == null || str.length() <= 0) {
            this.f20626d.setVisibility(4);
            return;
        }
        this.f20626d.setText(str);
        this.f20626d.setVisibility(0);
    }

    public void setBackgroundResource(int i) {
        this.f20623a.setBackgroundResource(i);
    }

    /* renamed from: a */
    private void m15079a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaTitleBarView, i, 0);
        this.f20627e = obtainStyledAttributes.getText(2);
        this.f20628f = obtainStyledAttributes.getText(0);
        this.f20629g = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m15078a(Context context) {
        inflate(context, R.layout.entrega_common_title_bar_close, this);
        this.f20623a = findViewById(R.id.entrega_custom_title_container);
        this.f20624b = (RFIconView) findViewById(R.id.entrega_iv_page_back);
        this.f20625c = (TextView) findViewById(R.id.entrega_tv_title_label);
        this.f20626d = (TextView) findViewById(R.id.entrega_tv_page_opt_label);
        this.f20625c.setText(this.f20627e);
        CharSequence charSequence = this.f20628f;
        if (charSequence == null || charSequence.length() <= 0) {
            this.f20624b.setText(R.string.rf_icon_outline_close);
        } else {
            this.f20624b.setText(this.f20628f);
        }
        CharSequence charSequence2 = this.f20629g;
        if (charSequence2 != null && charSequence2.length() > 0) {
            this.f20626d.setText(this.f20629g);
            this.f20626d.setVisibility(0);
        }
        this.f20624b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBarView.this.f20630h != null) {
                    TitleBarView.this.f20630h.onBackClick(view);
                }
            }
        });
        this.f20626d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBarView.this.f20631i != null) {
                    TitleBarView.this.f20631i.onRightClick(view);
                }
            }
        });
    }
}
