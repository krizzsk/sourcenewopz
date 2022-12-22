package com.didi.soda.customer.widget.headerview.tabitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class HomeClassifyTab extends AppCompatTextView implements ITab<String> {
    public HomeClassifyTab(Context context) {
        super(context);
        m29642a();
    }

    public HomeClassifyTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29642a();
    }

    public HomeClassifyTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29642a();
    }

    public void setSelectedState(boolean z, boolean z2) {
        if (z) {
            setSelected(true);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.BOLD);
            return;
        }
        setSelected(false);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.NORMAL);
    }

    public void updateTabView(String str, int i, int i2) {
        int dip2px = DisplayUtils.dip2px(getContext(), 16.0f);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 24.0f);
        if (i == 0) {
            setPadding(dip2px, 0, dip2px2, 0);
        } else {
            setPadding(0, 0, dip2px2, 0);
        }
        setText(str);
    }

    /* renamed from: a */
    private void m29642a() {
        setLayoutParams(new ViewGroup.LayoutParams(-2, DisplayUtils.dip2px(getContext(), 30.0f)));
        setGravity(17);
        setTextColor(ResourceHelper.getColor(R.color.customer_selector_home_indicator_text_color));
        setTextSize(1, 16.0f);
    }
}
