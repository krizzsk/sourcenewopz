package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BlueLableBubble;
import com.didi.map.base.bubble.Bubble;

public class BlueBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "BlueRoadBitmapLoader";

    /* renamed from: a */
    private final BlueLableBubble f24580a;

    public String toString() {
        return TAG;
    }

    public BlueBubbleBitmapLoader(Context context, BlueLableBubble blueLableBubble) {
        super(context);
        this.f24580a = blueLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        BlueBubbleBitmapOpt blueBubbleBitmapOpt = (BlueBubbleBitmapOpt) overlayRect.resourcePaths;
        String text = blueBubbleBitmapOpt.getText();
        return this.f24580a.getMarkerBitmap(this.context, text, this.f24580a.getTextColor(blueBubbleBitmapOpt.isNight(), text), blueBubbleBitmapOpt.getFileName(0), "", true, 0);
    }
}
