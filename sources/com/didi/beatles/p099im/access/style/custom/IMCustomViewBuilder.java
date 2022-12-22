package com.didi.beatles.p099im.access.style.custom;

import com.didi.beatles.p099im.access.style.custom.msgcard.IMLocationCusView;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMSysOrderCusView;
import com.didi.beatles.p099im.access.style.custom.msgcard.IMTextRenderCusView;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomViewBuilder */
public abstract class IMCustomViewBuilder {
    public IMLocationCusView createLocation() {
        return null;
    }

    public IMSysOrderCusView createSysOrder() {
        return null;
    }

    public IMTextRenderCusView createTextRender() {
        return null;
    }

    public IMTopOperationCusView createTopOperationView() {
        return null;
    }
}
