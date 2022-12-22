package com.didi.soda.customer.widget.abnormal.state.impl;

import com.didi.soda.customer.widget.abnormal.AbnormalViewModel;
import com.didi.soda.customer.widget.abnormal.state.IAbnormalState;
import com.taxis99.R;

public class AbnormalIconState implements IAbnormalState {
    public AbnormalViewModel.Builder createAbnormalBuilder(Object... objArr) {
        return new AbnormalViewModel.Builder().setResId(R.drawable.common_icon_abnormal_type_1);
    }
}
