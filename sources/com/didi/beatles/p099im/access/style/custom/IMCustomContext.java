package com.didi.beatles.p099im.access.style.custom;

import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomContext */
public final class IMCustomContext {

    /* renamed from: a */
    private final ArrayList<WeakReference<IMCustomView>> f8848a = new ArrayList<>();

    /* renamed from: b */
    private IMSession f8849b;

    /* renamed from: c */
    private IMBusinessParam f8850c;

    public IMCustomContext(IMSession iMSession, IMBusinessParam iMBusinessParam) {
        this.f8849b = iMSession;
        this.f8850c = iMBusinessParam;
    }

    public void setSession(IMSession iMSession) {
        this.f8849b = iMSession;
        int i = 0;
        while (i < this.f8848a.size()) {
            IMCustomView iMCustomView = (IMCustomView) this.f8848a.get(i).get();
            if (iMCustomView == null) {
                this.f8848a.remove(i);
                i--;
            } else {
                iMCustomView.onSessionUpdate(iMSession);
            }
            i++;
        }
    }

    public IMSession getSession() {
        return this.f8849b;
    }

    public void setParam(IMBusinessParam iMBusinessParam) {
        this.f8850c = iMBusinessParam;
    }

    public IMBusinessParam getParam() {
        return this.f8850c;
    }

    public void addIMCustomView(IMCustomView iMCustomView) {
        this.f8848a.add(new WeakReference(iMCustomView));
        if (iMCustomView != null) {
            iMCustomView.onSessionUpdate(getSession());
        }
    }
}
