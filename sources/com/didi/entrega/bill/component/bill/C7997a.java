package com.didi.entrega.bill.component.bill;

import android.graphics.Rect;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.component.feed.decorator.CustomerSimpleDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/BillDecorator;", "Lcom/didi/entrega/customer/component/feed/decorator/CustomerSimpleDecorator;", "color", "", "height", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.component.bill.a */
/* compiled from: BillView.kt */
final class C7997a extends CustomerSimpleDecorator {
    public C7997a(int i, int i2) {
        super(i, i2);
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        super.getItemOffsets(rect, i, i2);
        int dip2px = DisplayUtils.dip2px(GlobalContext.getContext(), 340.0f);
        if (i == 0) {
            rect.set(rect.left, dip2px, rect.right, rect.bottom);
        }
    }
}
