package com.didi.beatles.p099im.access.style.custom.msgcard;

import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.access.style.custom.IMCustomView;
import com.didi.beatles.p099im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.access.style.custom.msgcard.IMMsgCardCusView */
public abstract class IMMsgCardCusView extends IMCustomView {
    public abstract void bindContent(IMMessage iMMessage);

    public abstract View layoutView(ViewGroup viewGroup, boolean z);
}
