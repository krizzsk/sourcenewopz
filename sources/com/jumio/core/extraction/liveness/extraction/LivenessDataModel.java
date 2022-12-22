package com.jumio.core.extraction.liveness.extraction;

import com.jumio.commons.PersistWith;
import com.jumio.commons.camera.ImageData;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, mo175978d2 = {"Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/data/ScanMode;", "a", "Lcom/jumio/core/data/ScanMode;", "getType", "()Lcom/jumio/core/data/ScanMode;", "setType", "(Lcom/jumio/core/data/ScanMode;)V", "type", "", "Lcom/jumio/commons/camera/ImageData;", "b", "[Lcom/jumio/commons/camera/ImageData;", "getFrames", "()[Lcom/jumio/commons/camera/ImageData;", "setFrames", "([Lcom/jumio/commons/camera/ImageData;)V", "frames", "", "c", "Ljava/lang/Boolean;", "isPassed", "()Ljava/lang/Boolean;", "setPassed", "(Ljava/lang/Boolean;)V", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("LivenessDataModel")
/* compiled from: LivenessDataModel.kt */
public final class LivenessDataModel implements StaticModel {

    /* renamed from: a */
    public ScanMode f54765a;

    /* renamed from: b */
    public ImageData[] f54766b;

    /* renamed from: c */
    public Boolean f54767c;

    public final ImageData[] getFrames() {
        return this.f54766b;
    }

    public final ScanMode getType() {
        return this.f54765a;
    }

    public final Boolean isPassed() {
        return this.f54767c;
    }

    public final void setFrames(ImageData[] imageDataArr) {
        this.f54766b = imageDataArr;
    }

    public final void setPassed(Boolean bool) {
        this.f54767c = bool;
    }

    public final void setType(ScanMode scanMode) {
        this.f54765a = scanMode;
    }
}
