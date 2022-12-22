package com.didiglobal.p205sa.biz.component.businesscard.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.sdk.app.DIDIApplication;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.view.SmallBusinessItemView */
public class SmallBusinessItemView extends AbsBusinessItemView {
    public int getLayoutResId() {
        return R.layout.business_small_item;
    }

    public SmallBusinessItemView(Context context) {
        super(context);
    }

    public SmallBusinessItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmallBusinessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public float getWeight() {
        return (float) BusinessCardModel.StyleWeight.SMALL.getWeight();
    }

    public int getRealWidth() {
        return (((UiUtils.INSTANCE.getScreenWidth(DIDIApplication.getAppContext()) - (UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 16.0f) * 2)) - (UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 8.0f) * 3)) / 4) + UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 13.0f) + UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 13.0f);
    }
}
