package com.jumio.core.plugins;

import com.jumio.core.Controller;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.Overlay;
import jumio.core.C21343c0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/core/plugins/ExtractionPlugin;", "Ljumio/core/c0;", "Lcom/jumio/core/MobileContext;", "context", "Lcom/jumio/core/extraction/ExtractionClient;", "getExtractionClient", "Lcom/jumio/core/overlay/Overlay;", "getOverlay", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ExtractionPlugin.kt */
public interface ExtractionPlugin extends C21343c0 {

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: ExtractionPlugin.kt */
    public static final class DefaultImpls {
        public static boolean isUsable(ExtractionPlugin extractionPlugin, Controller controller, ScanPartModel scanPartModel) {
            Intrinsics.checkNotNullParameter(extractionPlugin, "this");
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
            return C21343c0.C21344a.m42101a(extractionPlugin, controller, scanPartModel);
        }
    }

    ExtractionClient getExtractionClient(MobileContext mobileContext);

    Overlay getOverlay(MobileContext mobileContext);

    /* synthetic */ boolean isUsable(Controller controller, ScanPartModel scanPartModel);
}
