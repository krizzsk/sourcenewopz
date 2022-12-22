package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.DynamicRouteLableBubble;
import com.didi.map.alpha.maps.internal.ILableBubble;
import com.didi.map.base.bubble.Bubble;

public class DynamicBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "DynamicRoadBitmapLoader";

    /* renamed from: a */
    DynamicRouteLableBubble f24583a;

    public DynamicBubbleBitmapLoader(Context context, ILableBubble iLableBubble) {
        super(context);
        this.f24583a = (DynamicRouteLableBubble) iLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        String str;
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        DynamicBubbleBitmapOpt dynamicBubbleBitmapOpt = (DynamicBubbleBitmapOpt) overlayRect.resourcePaths;
        boolean isNight = dynamicBubbleBitmapOpt.isNight();
        boolean is2Dfullbrowser = dynamicBubbleBitmapOpt.is2Dfullbrowser();
        String[] split = dynamicBubbleBitmapOpt.getText().split(";");
        String str2 = split[0];
        int textColor = this.f24583a.getTextColor(isNight, str2);
        String fileName = dynamicBubbleBitmapOpt.getFileName(0);
        if (split.length > 2) {
            str = str2 + split[2];
        } else {
            str = str2;
        }
        return this.f24583a.getMarkerBitmap(this.context, str, textColor, fileName, "", false, 0, is2Dfullbrowser, isNight);
    }
}
