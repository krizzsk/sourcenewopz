package com.didi.soda.address.component.feed.binder;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class DeliveryAddressItemDecorator implements ItemDecorator {

    /* renamed from: a */
    private Paint f38674a;

    /* renamed from: b */
    private int f38675b = DisplayUtils.dip2px(GlobalContext.getContext(), 0.5f);

    DeliveryAddressItemDecorator() {
        Paint paint = new Paint();
        this.f38674a = paint;
        paint.setColor(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
    }

    public static DeliveryAddressItemDecorator newInstance() {
        return new DeliveryAddressItemDecorator();
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        if (i != 0) {
            rect.top = this.f38675b;
        } else {
            rect.top = 0;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        if (i != 0) {
            int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 16.0f);
            int dip2px2 = DisplayUtils.dip2px(GlobalContext.getContext(), 12.0f);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) dip2px2, (float) (view.getTop() - this.f38675b), (float) (dip2px + dip2px2), (float) view.getTop(), this.f38674a);
        }
    }
}
