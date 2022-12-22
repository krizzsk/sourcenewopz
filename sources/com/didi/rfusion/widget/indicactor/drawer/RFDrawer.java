package com.didi.rfusion.widget.indicactor.drawer;

import android.graphics.Canvas;
import com.didi.rfusion.widget.indicactor.drawer.RFBaseDrawer;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&J\u001c\u0010\u000e\u001a\u00060\u000fR\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFDrawer;", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer$MeasureResult;", "Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer;", "widthMeasureSpec", "heightMeasureSpec", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFDrawer.kt */
public interface RFDrawer {
    void onDraw(Canvas canvas);

    void onLayout(boolean z, int i, int i2, int i3, int i4);

    RFBaseDrawer.MeasureResult onMeasure(int i, int i2);
}
