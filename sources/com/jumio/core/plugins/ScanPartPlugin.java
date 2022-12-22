package com.jumio.core.plugins;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import jumio.core.C21343c0;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J=\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/core/plugins/ScanPartPlugin;", "Ljumio/core/c0;", "Lcom/jumio/core/Controller;", "controller", "", "preload", "unload", "Lcom/jumio/core/models/ScanPartModel;", "T", "Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "scanPartModel", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/core/scanpart/ScanPart;", "getScanPart", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioCredential;Lcom/jumio/core/models/ScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)Lcom/jumio/core/scanpart/ScanPart;", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ScanPartPlugin.kt */
public interface ScanPartPlugin extends C21343c0 {
    <T extends ScanPartModel> ScanPart<?> getScanPart(Controller controller, JumioCredential jumioCredential, T t, JumioScanPartInterface jumioScanPartInterface);

    /* synthetic */ boolean isUsable(Controller controller, ScanPartModel scanPartModel);

    void preload(Controller controller);

    void unload();
}
