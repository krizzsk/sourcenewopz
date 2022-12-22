package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class CustomerExpandView extends ConstraintLayout {
    public static final int PUT_AWAY = 2;
    public static final int SHOW_ALL = 1;

    /* renamed from: c */
    private static final int f39285c = -1;

    /* renamed from: a */
    TextView f39286a;

    /* renamed from: b */
    IconTextView f39287b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f39288d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnStatusChangeListener f39289e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f39290f;

    public interface OnStatusChangeListener {
        void onChanged(int i);
    }

    public CustomerExpandView(Context context) {
        super(context);
        m27831a();
    }

    public CustomerExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27831a();
    }

    public CustomerExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27831a();
    }

    public int getCurrentStatus() {
        return this.f39288d;
    }

    public void setData(int i, int i2) {
        this.f39290f = i;
        if (this.f39288d == -1) {
            this.f39288d = i2;
        }
        if (getCurrentStatus() == 1) {
            m27832a(i);
        } else if (getCurrentStatus() == 2) {
            m27835b(i);
        }
        OnStatusChangeListener onStatusChangeListener = this.f39289e;
        if (onStatusChangeListener != null) {
            onStatusChangeListener.onChanged(this.f39288d);
        }
    }

    public void setInitStatus(int i) {
        if (this.f39288d == -1) {
            this.f39288d = i;
        }
    }

    public void setStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.f39289e = onStatusChangeListener;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CustomerExpandView.this.f39288d == 1) {
                    CustomerExpandView customerExpandView = CustomerExpandView.this;
                    customerExpandView.m27835b(customerExpandView.f39290f);
                } else if (CustomerExpandView.this.f39288d == 2) {
                    CustomerExpandView customerExpandView2 = CustomerExpandView.this;
                    customerExpandView2.m27832a(customerExpandView2.f39290f);
                }
                if (CustomerExpandView.this.f39289e != null) {
                    CustomerExpandView.this.f39289e.onChanged(CustomerExpandView.this.f39288d);
                }
            }
        });
    }

    /* renamed from: a */
    private void m27831a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_cart_expand_container, this);
        this.f39286a = (TextView) findViewById(R.id.customer_tv_expand);
        this.f39287b = (IconTextView) findViewById(R.id.customer_custom_expand_arrow);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27832a(int i) {
        this.f39286a.setText(getResources().getQuantityString(R.plurals.customer_put_away, i, new Object[]{Integer.valueOf(i)}));
        this.f39287b.setText(getResources().getString(R.string.customer_common_icon_retract));
        this.f39288d = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27835b(int i) {
        this.f39286a.setText(getResources().getQuantityString(R.plurals.customer_show_all, i, new Object[]{Integer.valueOf(i)}));
        this.f39287b.setText(getResources().getString(R.string.customer_common_icon_spread));
        this.f39288d = 2;
    }
}
