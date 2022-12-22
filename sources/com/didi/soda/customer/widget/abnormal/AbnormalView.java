package com.didi.soda.customer.widget.abnormal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.soda.customer.widget.abnormal.state.IAbnormalState;
import com.taxis99.R;

public class AbnormalView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f41609a;

    /* renamed from: b */
    private TextView f41610b;

    /* renamed from: c */
    private TextView f41611c;
    protected RelativeLayout mContainer;

    public AbnormalView(Context context) {
        super(context);
        m29410a(context);
    }

    public AbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29410a(context);
    }

    public AbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29410a(context);
    }

    public void setContainerClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.f41609a.setImageResource(i);
            this.f41609a.setVisibility(0);
            return;
        }
        this.f41609a.setVisibility(8);
    }

    public void setTitle(String str) {
        this.f41610b.setText(str);
    }

    public void show(AbnormalViewModel abnormalViewModel) {
        if (abnormalViewModel != null) {
            if (abnormalViewModel.resId != 0) {
                setImageResource(abnormalViewModel.resId);
            } else {
                setImageResource(0);
            }
            if (abnormalViewModel.titleId != 0) {
                setTitle(getResources().getString(abnormalViewModel.titleId));
            } else if (!TextUtils.isEmpty(abnormalViewModel.title)) {
                setTitle(abnormalViewModel.title);
            } else {
                setTitle("");
            }
            if (abnormalViewModel.clickListener != null) {
                setContainerClickListener(abnormalViewModel.clickListener);
                this.f41611c.setVisibility(0);
            } else {
                setContainerClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                    }
                });
                this.f41611c.setVisibility(8);
            }
            if (abnormalViewModel.backgroundResId != 0) {
                setBackgroundResource(abnormalViewModel.backgroundResId);
            } else {
                setBackgroundColor(getResources().getColor(R.color.rf_color_white_100_FFFFFF));
            }
            setVisibility(0);
        }
    }

    public void show(IAbnormalState iAbnormalState) {
        if (iAbnormalState != null) {
            show(iAbnormalState.createAbnormalBuilder(new Object[0]).build());
        }
    }

    /* renamed from: a */
    private void m29410a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widght_error_view, this);
        this.f41609a = (ImageView) findViewById(R.id.error_img);
        this.f41610b = (TextView) findViewById(R.id.error_title);
        this.f41611c = (TextView) findViewById(R.id.customer_tv_retry);
        this.mContainer = (RelativeLayout) findViewById(R.id.common_error_container);
    }
}
