package com.didi.soda.customer.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class TitleBarView extends ConstraintLayout {

    /* renamed from: a */
    View f42242a;

    /* renamed from: b */
    IconTextView f42243b;

    /* renamed from: c */
    TextView f42244c;

    /* renamed from: d */
    IconRichTextView f42245d;

    /* renamed from: e */
    CharSequence f42246e;

    /* renamed from: f */
    CharSequence f42247f;

    /* renamed from: g */
    CharSequence f42248g;

    /* renamed from: h */
    OnBackClickListener f42249h;

    /* renamed from: i */
    OnRightClickListener f42250i;

    public TitleBarView(Context context) {
        super(context);
        m29780a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29781a(context, attributeSet, 0);
        m29780a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29781a(context, attributeSet, i);
        m29780a(context);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.f42249h = onBackClickListener;
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.f42250i = onRightClickListener;
    }

    public void setOnRightClickListener(String str, OnRightClickListener onRightClickListener) {
        setRightText(str);
        this.f42250i = onRightClickListener;
    }

    public void setBackIconText(int i) {
        this.f42243b.setText(i);
    }

    public void hideBackView() {
        this.f42243b.setVisibility(8);
    }

    public View getContainer() {
        return this.f42242a;
    }

    public IconTextView getBackView() {
        return this.f42243b;
    }

    public TextView getTitleView() {
        return this.f42244c;
    }

    public void setTitleText(int i) {
        this.f42244c.setText(i);
    }

    public void setTitleText(String str) {
        this.f42244c.setText(str);
    }

    public void setRigthText(int i) {
        this.f42245d.setText(i);
    }

    public void setRightText(String str) {
        if (str == null || str.length() <= 0) {
            this.f42245d.setVisibility(4);
            return;
        }
        this.f42245d.setText(str);
        this.f42245d.setVisibility(0);
    }

    public void setBackgroundResource(int i) {
        this.f42242a.setBackgroundResource(i);
    }

    /* renamed from: a */
    private void m29781a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TitleBarView, i, 0);
        this.f42246e = obtainStyledAttributes.getText(2);
        this.f42247f = obtainStyledAttributes.getText(0);
        this.f42248g = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m29780a(Context context) {
        inflate(context, R.layout.customer_common_title_bar_close, this);
        this.f42242a = findViewById(R.id.customer_custom_title_container);
        this.f42243b = (IconTextView) findViewById(R.id.customer_iv_page_back);
        this.f42244c = (TextView) findViewById(R.id.customer_tv_title_label);
        this.f42245d = (IconRichTextView) findViewById(R.id.customer_tv_page_opt_label);
        this.f42244c.setText(this.f42246e);
        CharSequence charSequence = this.f42247f;
        if (charSequence == null || charSequence.length() <= 0) {
            this.f42243b.setText(R.string.customer_common_icon_closed);
        } else {
            this.f42243b.setText(this.f42247f);
        }
        CharSequence charSequence2 = this.f42248g;
        if (charSequence2 != null && charSequence2.length() > 0) {
            this.f42245d.setText(this.f42248g);
            this.f42245d.setVisibility(0);
        }
        this.f42243b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TitleBarView.this.f42249h != null) {
                    TitleBarView.this.f42249h.onBackClick(view);
                }
            }
        });
        this.f42245d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TitleBarView.this.f42250i != null) {
                    TitleBarView.this.f42250i.onRightClick(view);
                }
            }
        });
    }
}
