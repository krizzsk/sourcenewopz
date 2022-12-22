package com.didi.soda.home.topgun.widget;

import android.graphics.Rect;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeComposeItemDecoration;", "Lcom/didi/soda/customer/component/feed/decorator/CustomerSimpleDecorator;", "color", "", "height", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeComposeItemDecoration.kt */
public final class HomeComposeItemDecoration extends CustomerSimpleDecorator {
    public HomeComposeItemDecoration(int i, int i2) {
        super(i, i2);
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 10.0f);
        int dip2px2 = DisplayUtils.dip2px(GlobalContext.getContext(), 12.0f);
        DisplayUtils.dip2px(GlobalContext.getContext(), 24.0f);
        rect.set(dip2px2, 0, dip2px2, dip2px);
    }
}
