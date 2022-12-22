package com.didi.soda.uiwidget.cardview;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.didi.soda.uiwidget.cardview.d */
/* compiled from: SodaCardViewDelegate */
interface C14227d {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i, int i2);

    void setShadowPadding(int i, int i2, int i3, int i4);
}
