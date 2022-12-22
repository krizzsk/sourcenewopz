package com.didi.soda.bill.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerTagView;
import com.taxis99.R;

public class CustomerSelectableTagView extends CustomerTagView {
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

    public CustomerSelectableTagView(Context context) {
        super(context);
    }

    public CustomerSelectableTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerSelectableTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        return getContext().getResources().getDrawable(R.drawable.customer_skin_selector_selectable_tagview);
    }

    /* access modifiers changed from: protected */
    public IToolsService.FontType getFontType() {
        return IToolsService.FontType.NORMAL;
    }

    /* access modifiers changed from: protected */
    public ColorStateList getTagTextColorStateList() {
        return ContextCompat.getColorStateList(getContext(), R.drawable.customer_skin_selector_selectable_tagview_text);
    }
}
