package com.didi.soda.customer.blocks.view;

import android.graphics.Rect;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/BlocksItemDecoration;", "Lcom/didi/soda/customer/component/feed/decorator/CustomerSimpleDecorator;", "color", "", "height", "leftMargin", "(III)V", "getLeftMargin", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksItemDecoration.kt */
public final class BlocksItemDecoration extends CustomerSimpleDecorator {

    /* renamed from: a */
    private final int f40659a;

    public BlocksItemDecoration(int i, int i2, int i3) {
        super(i, i2);
        this.f40659a = i3;
    }

    public final int getLeftMargin() {
        return this.f40659a;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        if (!this.mEnableTopDecorator || (i2 & 16) == 0) {
            int i3 = this.f40659a;
            rect.set(i3, 0, i3, this.mDecoratorHeight);
            return;
        }
        rect.set(this.f40659a, this.mDecoratorHeight, this.f40659a, this.mDecoratorHeight);
    }
}
