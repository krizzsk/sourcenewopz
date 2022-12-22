package com.jumio.core.extraction.barcode.vision;

import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.barcode.overlay.BarcodeOverlay;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.ExtractionPlugin;
import jumio.p243barcodevision.C21335a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/jumio/core/extraction/barcode/vision/BarcodeVisionPlugin;", "Lcom/jumio/core/plugins/ExtractionPlugin;", "Lcom/jumio/core/MobileContext;", "context", "Lcom/jumio/core/extraction/ExtractionClient;", "getExtractionClient", "Lcom/jumio/core/overlay/Overlay;", "getOverlay", "<init>", "()V", "jumio-barcode-vision_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BarcodeVisionPlugin.kt */
public final class BarcodeVisionPlugin implements ExtractionPlugin {
    public ExtractionClient getExtractionClient(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        return new C21335a(mobileContext);
    }

    public Overlay getOverlay(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        return new BarcodeOverlay(mobileContext);
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        return ExtractionPlugin.DefaultImpls.isUsable(this, controller, scanPartModel);
    }
}
