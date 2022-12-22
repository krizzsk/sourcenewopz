package com.didiglobal.p205sa.biz.component.sapanel.model;

import android.view.View;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IRideView;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.model.SABizCardProperty */
public class SABizCardProperty {
    public ICardPosition cardPosition;
    public String mId;
    public String mType;
    public View mView;
    public ICardVisibleListener mVisibleListener;
    public IRideView rideView;
}
