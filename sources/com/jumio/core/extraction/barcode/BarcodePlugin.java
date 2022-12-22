package com.jumio.core.extraction.barcode;

import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.barcode.overlay.BarcodeOverlay;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.ExtractionPlugin;
import jumio.barcode.C21336a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/core/extraction/barcode/BarcodePlugin;", "Lcom/jumio/core/plugins/ExtractionPlugin;", "Lcom/jumio/core/Controller;", "controller", "Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "", "isUsable", "Lcom/jumio/core/MobileContext;", "context", "Lcom/jumio/core/extraction/ExtractionClient;", "getExtractionClient", "Lcom/jumio/core/overlay/Overlay;", "getOverlay", "<init>", "()V", "jumio-barcode_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BarcodePlugin.kt */
public final class BarcodePlugin implements ExtractionPlugin {
    public ExtractionClient getExtractionClient(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        return new C21336a(mobileContext);
    }

    public Overlay getOverlay(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        return new BarcodeOverlay(mobileContext);
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
        return C21336a.f59572j.mo175776a(controller.getContext(), controller.getDataManager());
    }
}
