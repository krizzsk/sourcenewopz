package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.ILableBubble;
import com.didi.map.alpha.maps.internal.MultiRouteLableBubble;
import com.didi.map.base.bubble.Bubble;

public class MultiBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "MultiRoadBitmapLoader";

    /* renamed from: a */
    private final MultiRouteLableBubble f24591a;

    public MultiBubbleBitmapLoader(Context context, ILableBubble iLableBubble) {
        super(context);
        this.f24591a = (MultiRouteLableBubble) iLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        String str;
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        MultiBubbleBitmapOpt multiBubbleBitmapOpt = (MultiBubbleBitmapOpt) overlayRect.resourcePaths;
        boolean isNight = multiBubbleBitmapOpt.isNight();
        boolean is2Dfullbrowser = multiBubbleBitmapOpt.is2Dfullbrowser();
        String[] split = multiBubbleBitmapOpt.getText().split(";");
        String str2 = split[0];
        int textColor = this.f24591a.getTextColor(isNight, str2);
        String fileName = multiBubbleBitmapOpt.getFileName(0);
        if (split.length > 2) {
            str = str2 + split[2];
        } else {
            str = str2;
        }
        return this.f24591a.getMarkerBitmap(this.context, str, textColor, fileName, "", false, 0, is2Dfullbrowser, isNight);
    }
}
