package com.didi.zxing.barcodescanner.camera;

import android.graphics.Rect;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class PreviewScalingStrategy {

    /* renamed from: a */
    private static final String f45391a = "PreviewScalingStrategy";

    /* access modifiers changed from: protected */
    public float getScore(Size size, Size size2) {
        return 0.5f;
    }

    public abstract Rect scalePreview(Size size, Size size2);

    public Size getBestPreviewSize(List<Size> list, Size size) {
        List<Size> bestPreviewOrder = getBestPreviewOrder(list, size);
        SystemUtils.log(4, f45391a, "Viewfinder size: " + size, (Throwable) null, "com.didi.zxing.barcodescanner.camera.PreviewScalingStrategy", 36);
        SystemUtils.log(4, f45391a, "Preview in order of preference: " + bestPreviewOrder, (Throwable) null, "com.didi.zxing.barcodescanner.camera.PreviewScalingStrategy", 37);
        return bestPreviewOrder.get(0);
    }

    public List<Size> getBestPreviewOrder(List<Size> list, final Size size) {
        if (size == null) {
            return list;
        }
        Collections.sort(list, new Comparator<Size>() {
            public int compare(Size size, Size size2) {
                return Float.compare(PreviewScalingStrategy.this.getScore(size2, size), PreviewScalingStrategy.this.getScore(size, size));
            }
        });
        return list;
    }
}
