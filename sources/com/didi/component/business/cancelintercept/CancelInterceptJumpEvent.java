package com.didi.component.business.cancelintercept;

import android.os.Bundle;

public class CancelInterceptJumpEvent {
    public Bundle bundle;
    public int pageId;

    public CancelInterceptJumpEvent(int i, Bundle bundle2) {
        this.pageId = i;
        this.bundle = bundle2;
    }
}
