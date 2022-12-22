package com.didichuxing.diface.biz.bioassay.alpha;

import com.didichuxing.diface.DiFaceResult;

public class BioassayFailedDoneEvent {
    public final DiFaceResult result;

    public BioassayFailedDoneEvent(DiFaceResult diFaceResult) {
        this.result = diFaceResult;
    }
}
