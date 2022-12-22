package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.CustomerTagView;
import com.taxis99.R;

public class BusinessMarketingTipTagView extends CustomerTagView {
    public float getTagTextSize() {
        return 11.0f;
    }

    public BusinessMarketingTipTagView(Context context) {
        super(context);
    }

    public BusinessMarketingTipTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BusinessMarketingTipTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        return getContext().getResources().getDrawable(R.drawable.customer_skin_bg_topgun_home_act);
    }

    public int getTagTextColor() {
        return SkinUtil.getBrandPrimaryColor();
    }

    /* access modifiers changed from: protected */
    public int getTagMaxWidth() {
        return DisplayUtils.dip2px(getContext(), 230.0f);
    }
}
