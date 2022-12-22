package com.didi.beatles.p099im.access.style.custom;

import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomView */
public abstract class IMCustomView {

    /* renamed from: a */
    private IMCustomContext f8851a;

    public void onSessionUpdate(IMSession iMSession) {
    }

    public final void bindIMContext(IMCustomContext iMCustomContext) {
        if (iMCustomContext != null) {
            iMCustomContext.addIMCustomView(this);
        }
        this.f8851a = iMCustomContext;
    }

    public final IMSession getSession() {
        IMCustomContext iMCustomContext = this.f8851a;
        if (iMCustomContext == null) {
            return null;
        }
        return iMCustomContext.getSession();
    }

    public final IMBusinessParam getBusinessParam() {
        IMCustomContext iMCustomContext = this.f8851a;
        if (iMCustomContext == null) {
            return null;
        }
        return iMCustomContext.getParam();
    }
}
