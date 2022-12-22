package com.jumio.iproov;

import android.os.Build;
import com.jumio.core.Controller;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import jumio.iproov.C21405d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J=\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010\"\b\b\u0000\u0010\u000b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, mo175978d2 = {"Lcom/jumio/iproov/IproovPlugin;", "Lcom/jumio/core/plugins/ScanPartPlugin;", "Lcom/jumio/core/Controller;", "controller", "", "preload", "unload", "Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "", "isUsable", "T", "Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/core/scanpart/ScanPart;", "getScanPart", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioCredential;Lcom/jumio/core/models/ScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)Lcom/jumio/core/scanpart/ScanPart;", "<init>", "()V", "jumio-iproov_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: IproovPlugin.kt */
public final class IproovPlugin implements ScanPartPlugin {
    public <T extends ScanPartModel> ScanPart<?> getScanPart(Controller controller, JumioCredential jumioCredential, T t, JumioScanPartInterface jumioScanPartInterface) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        Intrinsics.checkNotNullParameter(t, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        if (!(jumioCredential instanceof JumioFaceCredential)) {
            throw new IllegalArgumentException("Credential needs to be instance of JumioFaceCredential".toString());
        } else if (t instanceof FaceScanPartModel) {
            return new C21405d(controller, (JumioFaceCredential) jumioCredential, (FaceScanPartModel) t, jumioScanPartInterface);
        } else {
            throw new IllegalArgumentException("ScanPartModel needs to be instance of FaceScanPartModel".toString());
        }
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
        return (((IproovTokenModel) controller.getDataManager().get(IproovTokenModel.class)).getToken().length() > 0) && Build.VERSION.SDK_INT >= 21;
    }

    public void preload(Controller controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    public void unload() {
    }
}
