package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.ILableBubble;
import com.didi.map.base.bubble.Bubble;

public class IllegalParkBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "IllegalParkRoadBitmapLoader";

    /* renamed from: a */
    private final ILableBubble f24589a;

    public IllegalParkBubbleBitmapLoader(Context context, ILableBubble iLableBubble) {
        super(context);
        this.f24589a = iLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        return this.f24589a.getMarkerBitmap(this.context, "", 0, ((IllegalParkBubbleBitmapOpt) overlayRect.resourcePaths).getFileName(0), "", true, i == 0 ? 1 : 2);
    }
}
