package com.didi.zxing.barcodescanner.camera;

import android.graphics.Rect;
import com.didi.zxing.barcodescanner.Size;
import java.util.List;

public class DisplayConfiguration {

    /* renamed from: a */
    private static final String f45383a = "DisplayConfiguration";

    /* renamed from: b */
    private Size f45384b;

    /* renamed from: c */
    private int f45385c;

    /* renamed from: d */
    private boolean f45386d = false;

    /* renamed from: e */
    private PreviewScalingStrategy f45387e = new FitCenterStrategy();

    public DisplayConfiguration(int i) {
        this.f45385c = i;
    }

    public DisplayConfiguration(int i, Size size) {
        this.f45385c = i;
        this.f45384b = size;
    }

    public int getRotation() {
        return this.f45385c;
    }

    public void setViewfinderSize(Size size) {
        this.f45384b = size;
    }

    public Size getViewfinderSize() {
        return this.f45384b;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        return this.f45387e;
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f45387e = previewScalingStrategy;
    }

    public Size getDesiredPreviewSize(boolean z) {
        Size size = this.f45384b;
        if (size == null) {
            return null;
        }
        return z ? size.rotate() : size;
    }

    public Size getBestPreviewSize(List<Size> list, boolean z) {
        return this.f45387e.getBestPreviewSize(list, getDesiredPreviewSize(z));
    }

    public Rect scalePreview(Size size) {
        return this.f45387e.scalePreview(size, this.f45384b);
    }
}
