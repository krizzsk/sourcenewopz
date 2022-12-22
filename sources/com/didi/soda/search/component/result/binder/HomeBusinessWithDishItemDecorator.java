package com.didi.soda.search.component.result.binder;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.GlobalContext;

public class HomeBusinessWithDishItemDecorator implements ItemDecorator {
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        float f = i == 0 ? 12.0f : 5.0f;
        int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 5.0f);
        int dip2px2 = DisplayUtils.dip2px(GlobalContext.getContext(), 12.0f);
        rect.set(dip2px2, DisplayUtils.dip2px(GlobalContext.getContext(), f), dip2px2, dip2px);
    }
}
