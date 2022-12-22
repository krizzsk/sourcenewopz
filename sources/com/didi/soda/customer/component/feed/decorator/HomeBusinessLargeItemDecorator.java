package com.didi.soda.customer.component.feed.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.GlobalContext;

public class HomeBusinessLargeItemDecorator implements ItemDecorator {

    /* renamed from: a */
    private static final float f40786a = 11.0f;

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        int dip2px = 0 - DisplayUtils.dip2px(GlobalContext.getContext(), f40786a);
        rect.set(0, dip2px, 0, dip2px);
    }
}
