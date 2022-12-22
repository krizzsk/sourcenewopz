package com.didi.soda.customer.widget.abnormal.state;

import com.didi.soda.customer.widget.abnormal.AbnormalViewModel;

public interface IAbnormalState {
    AbnormalViewModel.Builder createAbnormalBuilder(Object... objArr);
}
