package com.didi.soda.home.topgun.component.topicact;

import android.graphics.Rect;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActivityItemDecoration;", "Lcom/didi/soda/customer/component/feed/decorator/CustomerSimpleDecorator;", "hasHeader", "", "color", "", "height", "(ZII)V", "getHasHeader", "()Z", "leftMargin", "getLeftMargin", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.component.topicact.b */
/* compiled from: TopicActivityView.kt */
final class C14037b extends CustomerSimpleDecorator {

    /* renamed from: a */
    private final boolean f42939a;

    /* renamed from: b */
    private final int f42940b = DisplayUtils.dip2px(GlobalContext.getContext(), 12.0f);

    public C14037b(boolean z, int i, int i2) {
        super(i, i2);
        this.f42939a = z;
    }

    /* renamed from: a */
    public final boolean mo107585a() {
        return this.f42939a;
    }

    /* renamed from: b */
    public final int mo107586b() {
        return this.f42940b;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        if (i != 0 || !this.f42939a) {
            int i3 = this.f42940b;
            rect.set(i3, 0, i3, this.mDecoratorHeight);
            return;
        }
        rect.set(0, 0, 0, DisplayUtils.dip2px(GlobalContext.getContext(), 6.0f));
    }
}
