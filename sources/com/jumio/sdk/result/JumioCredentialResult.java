package com.jumio.sdk.result;

import com.jumio.sdk.enums.JumioScanMode;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, mo175978d2 = {"Lcom/jumio/sdk/result/JumioCredentialResult;", "Ljava/io/Serializable;", "Lcom/jumio/sdk/enums/JumioScanMode;", "a", "Lcom/jumio/sdk/enums/JumioScanMode;", "getExtractionMode", "()Lcom/jumio/sdk/enums/JumioScanMode;", "setExtractionMode", "(Lcom/jumio/sdk/enums/JumioScanMode;)V", "extractionMode", "Lcom/jumio/sdk/result/JumioImageData;", "b", "Lcom/jumio/sdk/result/JumioImageData;", "getImageData", "()Lcom/jumio/sdk/result/JumioImageData;", "setImageData", "(Lcom/jumio/sdk/result/JumioImageData;)V", "imageData", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioCredentialResult.kt */
public class JumioCredentialResult implements Serializable {

    /* renamed from: a */
    public JumioScanMode f55093a;

    /* renamed from: b */
    public JumioImageData f55094b;

    public final JumioScanMode getExtractionMode() {
        return this.f55093a;
    }

    public final JumioImageData getImageData() {
        return this.f55094b;
    }

    public final void setExtractionMode(JumioScanMode jumioScanMode) {
        this.f55093a = jumioScanMode;
    }

    public final void setImageData(JumioImageData jumioImageData) {
        this.f55094b = jumioImageData;
    }
}
