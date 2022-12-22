package com.didi.aoe.features.bankcard.global;

import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH&J@\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/aoe/features/bankcard/global/BankcardInterface;", "", "destory", "", "init", "", "process", "imageData", "", "imageWidth", "imageHeight", "result", "Lcom/didi/aoe/features/bankcard/global/domain/DetectCardInfo;", "imageType", "imageDegree", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BankcardInterface.kt */
public interface BankcardInterface {
    void destory();

    int init();

    int process(byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo);

    int process(byte[] bArr, int i, int i2, DetectCardInfo detectCardInfo);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: BankcardInterface.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ int process$default(BankcardInterface bankcardInterface, byte[] bArr, int i, int i2, int i3, int i4, DetectCardInfo detectCardInfo, int i5, Object obj) {
            if (obj == null) {
                return bankcardInterface.process(bArr, (i5 & 2) != 0 ? 0 : i, i2, i3, (i5 & 16) != 0 ? 90 : i4, detectCardInfo);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: process");
        }
    }
}
