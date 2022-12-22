package com.didi.hawaii.mapsdkv2.adapter.traffic;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.common.MapAssets;

public class TrafficIconBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "TrafficIconBitmapLoader";
    public int HINT_ICON_HEIGHT = 68;
    public int HINT_ICON_WIDTH = 68;
    public int ICON_HEIGHT = 68;
    public int ICON_WIDTH = 68;

    /* renamed from: a */
    private Bitmap f23765a;

    public String toString() {
        return TAG;
    }

    public TrafficIconBitmapLoader(Context context) {
        super(context);
        Bitmap bitmap = MapAssets.bitmap(context, "map/traffic_default_3x.png");
        bitmap = bitmap != null ? BitmapUtil.adaptFromXXhResource(bitmap) : bitmap;
        putCacheBitmap("map/traffic_default_3x.png", bitmap);
        this.ICON_WIDTH = bitmap.getWidth() + DisplayUtils.dip2px(context, 2.0f);
        this.ICON_HEIGHT = bitmap.getHeight() + DisplayUtils.dip2px(context, 2.0f);
        Bitmap bitmap2 = MapAssets.bitmap(context, "map/acciden_remote_icon.png");
        this.f23765a = bitmap2;
        if (bitmap2 != null) {
            Bitmap adaptFromXXhResource = BitmapUtil.adaptFromXXhResource(bitmap2);
            this.f23765a = adaptFromXXhResource;
            this.HINT_ICON_WIDTH = adaptFromXXhResource.getWidth();
            this.HINT_ICON_HEIGHT = this.f23765a.getHeight();
        }
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        TrafficIconBitmapOpt trafficIconBitmapOpt = (TrafficIconBitmapOpt) overlayRect.resourcePaths;
        if (trafficIconBitmapOpt.isHint()) {
            return this.f23765a;
        }
        String trafficIconTypeFileName = trafficIconBitmapOpt.getTrafficIconTypeFileName();
        float realIconSize = trafficIconBitmapOpt.getRealIconSize();
        Bitmap cacheBitmap = getCacheBitmap(trafficIconTypeFileName);
        if (cacheBitmap == null && (cacheBitmap = MapAssets.bitmap(this.context, trafficIconTypeFileName)) != null) {
            putCacheBitmap(trafficIconTypeFileName, cacheBitmap);
        }
        if (cacheBitmap == null) {
            return null;
        }
        int i2 = (int) realIconSize;
        return Bitmap.createScaledBitmap(cacheBitmap, i2, i2, true);
    }
}
