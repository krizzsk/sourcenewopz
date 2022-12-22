package com.didi.beatles.p099im.access.style.custom;

import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.api.entity.IMTopOperationBody;

/* renamed from: com.didi.beatles.im.access.style.custom.IMTopOperationCusView */
public abstract class IMTopOperationCusView extends IMCustomView {
    public abstract void bindData(IMTopOperationBody iMTopOperationBody);

    public abstract View layoutView(ViewGroup viewGroup);

    public abstract void showGuideView(String str);
}
