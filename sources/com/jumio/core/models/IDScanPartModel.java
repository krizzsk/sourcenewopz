package com.jumio.core.models;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.sdk.enums.JumioScanSide;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, mo175978d2 = {"Lcom/jumio/core/models/IDScanPartModel;", "Lcom/jumio/core/models/ScanPartModel;", "Lcom/jumio/core/data/document/DocumentFormat;", "h", "Lcom/jumio/core/data/document/DocumentFormat;", "getFormat", "()Lcom/jumio/core/data/document/DocumentFormat;", "format", "Lcom/jumio/core/models/SelectionModel;", "i", "Lcom/jumio/core/models/SelectionModel;", "getSelectionModel", "()Lcom/jumio/core/models/SelectionModel;", "selectionModel", "Lcom/jumio/core/models/DocumentDataModel;", "j", "Lcom/jumio/core/models/DocumentDataModel;", "getDocumentData", "()Lcom/jumio/core/models/DocumentDataModel;", "setDocumentData", "(Lcom/jumio/core/models/DocumentDataModel;)V", "documentData", "Lcom/jumio/sdk/enums/JumioScanSide;", "side", "Lcom/jumio/core/data/ScanMode;", "mode", "<init>", "(Lcom/jumio/sdk/enums/JumioScanSide;Lcom/jumio/core/data/ScanMode;Lcom/jumio/core/data/document/DocumentFormat;Lcom/jumio/core/models/SelectionModel;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("IDScanPartModel")
/* compiled from: ScanPartModel.kt */
public final class IDScanPartModel extends ScanPartModel {

    /* renamed from: h */
    public final DocumentFormat f54837h;

    /* renamed from: i */
    public final SelectionModel f54838i;

    /* renamed from: j */
    public DocumentDataModel f54839j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IDScanPartModel(JumioScanSide jumioScanSide, ScanMode scanMode, DocumentFormat documentFormat, SelectionModel selectionModel) {
        super(jumioScanSide, scanMode);
        Intrinsics.checkNotNullParameter(jumioScanSide, "side");
        Intrinsics.checkNotNullParameter(scanMode, ParamKeys.PARAM_MODE);
        Intrinsics.checkNotNullParameter(documentFormat, "format");
        Intrinsics.checkNotNullParameter(selectionModel, "selectionModel");
        this.f54837h = documentFormat;
        this.f54838i = selectionModel;
    }

    public final DocumentDataModel getDocumentData() {
        return this.f54839j;
    }

    public final DocumentFormat getFormat() {
        return this.f54837h;
    }

    public final SelectionModel getSelectionModel() {
        return this.f54838i;
    }

    public final void setDocumentData(DocumentDataModel documentDataModel) {
        this.f54839j = documentDataModel;
    }
}
