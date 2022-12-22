package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BlockLableBubble;
import com.didi.map.alpha.maps.internal.ILableBubble;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.base.bubble.Bubble;

public class BlockBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "BlockRoadBitmapLoader";

    /* renamed from: a */
    private final BlockLableBubble f24577a;

    public BlockBubbleBitmapLoader(Context context, ILableBubble iLableBubble) {
        super(context);
        this.f24577a = (BlockLableBubble) iLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        BlockBubbleBitmapOpt blockBubbleBitmapOpt = (BlockBubbleBitmapOpt) overlayRect.resourcePaths;
        String str = blockBubbleBitmapOpt.getText().split(";")[0];
        String fileName = blockBubbleBitmapOpt.getFileName(0);
        int i2 = i == 0 ? 1 : 2;
        int blockBubbleType = blockBubbleBitmapOpt.getBlockBubbleType();
        LableMarkerManager.BlockBubbleParams blockBubbleParams = new LableMarkerManager.BlockBubbleParams();
        blockBubbleParams.text = str;
        blockBubbleParams.blockBubbleType = blockBubbleType;
        blockBubbleParams.fileName = fileName;
        if (blockBubbleType == 5) {
            blockBubbleParams.thumbUrl = blockBubbleBitmapOpt.thumbUrl;
        }
        return this.f24577a.getMarkerBitmap(this.context, i2, blockBubbleParams);
    }
}
