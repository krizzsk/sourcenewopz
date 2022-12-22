package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.unifiedPay.component.widget.loading.CircularProgressBar;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;

public class LoadingStateView extends FrameLayout {

    /* renamed from: a */
    private CircularProgressBar f44457a;

    /* renamed from: b */
    private TextView f44458b;

    public enum State {
        LOADING_STATE,
        SUCCESS_STATE
    }

    public LoadingStateView(Context context) {
        super(context);
        m31568a();
    }

    public LoadingStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31568a();
    }

    /* renamed from: a */
    private void m31568a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_loading_view_layout, this);
        this.f44457a = (CircularProgressBar) inflate.findViewById(R.id.oc_round_progress_bar);
        this.f44458b = (TextView) inflate.findViewById(R.id.oc_tv_loading);
    }

    public void setText(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.f44458b.setVisibility(8);
            return;
        }
        this.f44458b.setText(str);
        this.f44458b.setVisibility(0);
    }

    public void changeState(State state) {
        if (state == State.SUCCESS_STATE) {
            this.f44457a.changeToSuccess();
        } else {
            this.f44457a.changeToLoading();
        }
    }

    public void setText(int i) {
        this.f44458b.setText(i);
        this.f44458b.setVisibility(0);
    }
}
