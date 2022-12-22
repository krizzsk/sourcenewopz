package com.jumio.core.extraction.barcode.overlay;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.core.MobileContext;
import com.jumio.core.overlay.JVisionOverlay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/core/extraction/barcode/overlay/BarcodeOverlay;", "Lcom/jumio/core/overlay/JVisionOverlay;", "Landroid/graphics/Rect;", "extractionArea", "", "calculate", "Landroid/content/Context;", "context", "updateOverlayConfiguration", "r", "Landroid/graphics/Rect;", "getOverlayBounds", "()Landroid/graphics/Rect;", "overlayBounds", "Lcom/jumio/core/MobileContext;", "<init>", "(Lcom/jumio/core/MobileContext;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BarcodeOverlay.kt */
public final class BarcodeOverlay extends JVisionOverlay {

    /* renamed from: r */
    public final Rect f54731r = new Rect();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BarcodeOverlay(MobileContext mobileContext) {
        super(mobileContext);
        Intrinsics.checkNotNullParameter(mobileContext, "context");
    }

    public void calculate(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        super.calculate(rect);
        float f = (float) this.width;
        float f2 = (float) 2;
        int i = (int) ((f - (0.9f * f)) / f2);
        float f3 = (float) this.height;
        int i2 = (int) ((f3 - (0.95f * f3)) / f2);
        getOverlayBounds().set(i, i2, this.width - i, this.height - (i2 * 3));
    }

    public Rect getOverlayBounds() {
        return this.f54731r;
    }

    public void updateOverlayConfiguration(Context context) {
        this.drawBrackets = false;
        this.dimBackground = false;
    }
}
