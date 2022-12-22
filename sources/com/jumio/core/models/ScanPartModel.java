package com.jumio.core.models;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b7\u00108R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R5\u00106\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.j\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200`18\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, mo175978d2 = {"Lcom/jumio/core/models/ScanPartModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/sdk/enums/JumioScanSide;", "a", "Lcom/jumio/sdk/enums/JumioScanSide;", "getSide", "()Lcom/jumio/sdk/enums/JumioScanSide;", "side", "Lcom/jumio/core/data/ScanMode;", "b", "Lcom/jumio/core/data/ScanMode;", "getMode", "()Lcom/jumio/core/data/ScanMode;", "setMode", "(Lcom/jumio/core/data/ScanMode;)V", "mode", "Lcom/jumio/commons/camera/ImageData;", "c", "Lcom/jumio/commons/camera/ImageData;", "getImageData", "()Lcom/jumio/commons/camera/ImageData;", "imageData", "", "d", "Z", "getUsability", "()Z", "setUsability", "(Z)V", "usability", "Lcom/jumio/sdk/enums/JumioScanStep;", "e", "Lcom/jumio/sdk/enums/JumioScanStep;", "getScanStep", "()Lcom/jumio/sdk/enums/JumioScanStep;", "setScanStep", "(Lcom/jumio/sdk/enums/JumioScanStep;)V", "scanStep", "Lcom/jumio/sdk/retry/JumioRetryReason;", "f", "Lcom/jumio/sdk/retry/JumioRetryReason;", "getLastRetryReason", "()Lcom/jumio/sdk/retry/JumioRetryReason;", "setLastRetryReason", "(Lcom/jumio/sdk/retry/JumioRetryReason;)V", "lastRetryReason", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "getData", "()Ljava/util/HashMap;", "data", "<init>", "(Lcom/jumio/sdk/enums/JumioScanSide;Lcom/jumio/core/data/ScanMode;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("ScanPartModel")
/* compiled from: ScanPartModel.kt */
public class ScanPartModel implements StaticModel {

    /* renamed from: a */
    public final JumioScanSide f54846a;

    /* renamed from: b */
    public ScanMode f54847b;

    /* renamed from: c */
    public final ImageData f54848c = new ImageData();

    /* renamed from: d */
    public boolean f54849d;

    /* renamed from: e */
    public JumioScanStep f54850e;

    /* renamed from: f */
    public JumioRetryReason f54851f;

    /* renamed from: g */
    public final HashMap<String, Serializable> f54852g = new HashMap<>();

    public ScanPartModel(JumioScanSide jumioScanSide, ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(jumioScanSide, "side");
        Intrinsics.checkNotNullParameter(scanMode, ParamKeys.PARAM_MODE);
        this.f54846a = jumioScanSide;
        this.f54847b = scanMode;
    }

    public final HashMap<String, Serializable> getData() {
        return this.f54852g;
    }

    public final ImageData getImageData() {
        return this.f54848c;
    }

    public final JumioRetryReason getLastRetryReason() {
        return this.f54851f;
    }

    public final ScanMode getMode() {
        return this.f54847b;
    }

    public final JumioScanStep getScanStep() {
        return this.f54850e;
    }

    public final JumioScanSide getSide() {
        return this.f54846a;
    }

    public final boolean getUsability() {
        return this.f54849d;
    }

    public final void setLastRetryReason(JumioRetryReason jumioRetryReason) {
        this.f54851f = jumioRetryReason;
    }

    public final void setMode(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "<set-?>");
        this.f54847b = scanMode;
    }

    public final void setScanStep(JumioScanStep jumioScanStep) {
        this.f54850e = jumioScanStep;
    }

    public final void setUsability(boolean z) {
        this.f54849d = z;
    }
}
