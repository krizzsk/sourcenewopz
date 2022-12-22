package com.didi.soda.business.component.home;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.GlobalContext;

public class BusinessGoodsItemDecorator implements ItemDecorator {
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
    }

    public static BusinessGoodsItemDecorator newInstance() {
        return new BusinessGoodsItemDecorator();
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 14.0f);
        int dip2px2 = DisplayUtils.dip2px(GlobalContext.getContext(), 10.0f);
        if (i2 == 16) {
            rect.set(0, dip2px, 0, dip2px2);
        } else {
            rect.set(0, 0, 0, dip2px2);
        }
    }
}
