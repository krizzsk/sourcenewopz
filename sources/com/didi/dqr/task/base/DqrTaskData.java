package com.didi.dqr.task.base;

import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.common.StringUtils;

public class DqrTaskData {

    /* renamed from: a */
    private boolean f19103a;

    /* renamed from: b */
    private BinaryBitmap f19104b;

    /* renamed from: c */
    private MultiDetectorResult f19105c;

    /* renamed from: d */
    private DecoderResult f19106d;

    /* renamed from: e */
    private LuminanceSource f19107e;

    /* renamed from: f */
    private DecodeOptions f19108f;
    protected DqrTaskType fromTask;

    public BinaryBitmap getBinaryBitmap() {
        return this.f19104b;
    }

    public void setBinaryBitmap(BinaryBitmap binaryBitmap) {
        this.f19104b = binaryBitmap;
    }

    public MultiDetectorResult getDetectorResult() {
        return this.f19105c;
    }

    public void setDetectorResult(MultiDetectorResult multiDetectorResult) {
        this.f19105c = multiDetectorResult;
    }

    public DecoderResult getDecoderResult() {
        return this.f19106d;
    }

    public void setDecoderResult(DecoderResult decoderResult) {
        this.f19106d = decoderResult;
    }

    public LuminanceSource getSource() {
        return this.f19107e;
    }

    public void setSource(LuminanceSource luminanceSource) {
        this.f19107e = luminanceSource;
    }

    public DecodeOptions getDecodeOptions() {
        return this.f19108f;
    }

    public void setDecodeOptions(DecodeOptions decodeOptions) {
        this.f19108f = decodeOptions;
    }

    public boolean isFinished() {
        DecoderResult decoderResult = this.f19106d;
        return decoderResult != null && !StringUtils.isEmpty(decoderResult.getText());
    }

    public void setFinished(boolean z) {
        this.f19103a = z;
    }
}
