package com.jumio.core.models;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.sdk.enums.JumioScanSide;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo175978d2 = {"Lcom/jumio/core/models/FaceScanPartModel;", "Lcom/jumio/core/models/ScanPartModel;", "Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "h", "Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "getLivenessData", "()Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "setLivenessData", "(Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;)V", "livenessData", "Lcom/jumio/core/data/ScanMode;", "mode", "<init>", "(Lcom/jumio/core/data/ScanMode;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("FaceScanPartModel")
/* compiled from: ScanPartModel.kt */
public class FaceScanPartModel extends ScanPartModel {

    /* renamed from: h */
    public LivenessDataModel f54836h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FaceScanPartModel(ScanMode scanMode) {
        super(JumioScanSide.FACE, scanMode);
        Intrinsics.checkNotNullParameter(scanMode, ParamKeys.PARAM_MODE);
    }

    public final LivenessDataModel getLivenessData() {
        return this.f54836h;
    }

    public final void setLivenessData(LivenessDataModel livenessDataModel) {
        this.f54836h = livenessDataModel;
    }
}
