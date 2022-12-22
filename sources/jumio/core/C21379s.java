package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.credentials.JumioDocumentCredential;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.scanpart.JVisionScanPart;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.s */
/* compiled from: DocumentScanPart.kt */
public final class C21379s extends JVisionScanPart<ScanPartModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21379s(Controller controller, JumioDocumentCredential jumioDocumentCredential, ScanPartModel scanPartModel, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioDocumentCredential, scanPartModel, jumioScanPartInterface);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioDocumentCredential, "credential");
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
    }
}
