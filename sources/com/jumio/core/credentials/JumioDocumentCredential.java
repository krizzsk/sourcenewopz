package com.jumio.core.credentials;

import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.SortedMap;
import jumio.core.C21367m;
import jumio.core.C21379s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/core/credentials/JumioDocumentCredential;", "Lcom/jumio/sdk/credentials/JumioCredential;", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "initScanPart", "", "isConfigured", "()Z", "Lcom/jumio/core/Controller;", "controller", "Ljumio/core/m;", "credentialDataModel", "<init>", "(Lcom/jumio/core/Controller;Ljumio/core/m;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioDocumentCredential.kt */
public final class JumioDocumentCredential extends JumioCredential {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioDocumentCredential(Controller controller, C21367m mVar) {
        super(controller, mVar);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(mVar, "credentialDataModel");
        SortedMap<JumioScanSide, ScanPartModel> f = mVar.mo175836f();
        JumioScanSide jumioScanSide = JumioScanSide.DOCUMENT;
        f.put(jumioScanSide, new ScanPartModel(jumioScanSide, ScanMode.MANUAL));
    }

    public synchronized JumioScanPart initScanPart(JumioScanSide jumioScanSide, JumioScanPartInterface jumioScanPartInterface) {
        JumioScanPart activeScanPart$jumio_core_release;
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        Controller controller$jumio_core_release = getController$jumio_core_release();
        Object obj = getData$jumio_core_release().mo175836f().get(jumioScanSide);
        Intrinsics.checkNotNull(obj);
        setActiveScanPart$jumio_core_release(new JumioScanPart(new C21379s(controller$jumio_core_release, this, (ScanPartModel) obj, jumioScanPartInterface)));
        activeScanPart$jumio_core_release = getActiveScanPart$jumio_core_release();
        Intrinsics.checkNotNull(activeScanPart$jumio_core_release);
        return activeScanPart$jumio_core_release;
    }

    public boolean isConfigured() {
        return true;
    }

    public final synchronized JumioScanPart initScanPart(JumioScanPartInterface jumioScanPartInterface) {
        JumioScanSide firstKey;
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        firstKey = getData$jumio_core_release().mo175836f().firstKey();
        Intrinsics.checkNotNullExpressionValue(firstKey, "data.scanData.firstKey()");
        return initScanPart(firstKey, jumioScanPartInterface);
    }
}
