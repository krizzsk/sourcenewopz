package com.didi.soda.customer.widget.abnormal;

import android.view.View;
import com.didi.soda.customer.widget.abnormal.AbnormalViewModel;
import com.didi.soda.customer.widget.abnormal.state.impl.AbnormalIconState;

public final class AbnormalFactory {
    private AbnormalFactory() {
    }

    public static AbnormalViewModel buildIconWithTitle(String str) {
        return new AbnormalIconState().createAbnormalBuilder(new Object[0]).setTitle(str).build();
    }

    public static AbnormalViewModel buildIconWithTitle(int i) {
        return new AbnormalIconState().createAbnormalBuilder(new Object[0]).setResTitle(i).build();
    }

    public static AbnormalViewModel buildRetryView(int i, View.OnClickListener onClickListener) {
        return new AbnormalViewModel.Builder().setResTitle(i).setClickListener(onClickListener).build();
    }

    public static AbnormalViewModel buildRetryView(String str, View.OnClickListener onClickListener) {
        return new AbnormalViewModel.Builder().setTitle(str).setClickListener(onClickListener).build();
    }

    public static AbnormalViewModel buildSingleTextView(String str) {
        return new AbnormalViewModel.Builder().setTitle(str).build();
    }

    public static AbnormalViewModel buildSingleTextView(int i) {
        return new AbnormalViewModel.Builder().setResTitle(i).build();
    }
}
