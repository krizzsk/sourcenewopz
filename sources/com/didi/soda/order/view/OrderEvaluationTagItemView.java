package com.didi.soda.order.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerTagView;
import com.taxis99.R;

public class OrderEvaluationTagItemView extends CustomerTagView {
    public int getTagTextColor() {
        return 0;
    }

    public float getTagTextSize() {
        return 16.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isPureTextColor() {
        return false;
    }

    public OrderEvaluationTagItemView(Context context) {
        super(context);
    }

    public OrderEvaluationTagItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrderEvaluationTagItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        return getContext().getResources().getDrawable(R.drawable.customer_skin_selectable_tag_bg);
    }

    /* access modifiers changed from: protected */
    public IToolsService.FontType getFontType() {
        return IToolsService.FontType.NORMAL;
    }

    /* access modifiers changed from: protected */
    public ColorStateList getTagTextColorStateList() {
        return ColorUtil.getTagTextColorStateList(getContext());
    }
}
