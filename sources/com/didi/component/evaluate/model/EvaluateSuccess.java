package com.didi.component.evaluate.model;

import java.io.Serializable;

public class EvaluateSuccess implements Serializable {
    public static final String EVALUATE_SUCCESS_STATE = "evaluate_success_state";
    public boolean hasMarket = false;
    public long successTime = 0;

    public EvaluateSuccess() {
    }

    public EvaluateSuccess(long j, boolean z) {
        this.successTime = j;
        this.hasMarket = z;
    }
}
