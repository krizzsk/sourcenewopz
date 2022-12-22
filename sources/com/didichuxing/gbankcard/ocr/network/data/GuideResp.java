package com.didichuxing.gbankcard.ocr.network.data;

import com.didichuxing.dfbasesdk.data.BaseInnerResult;

public class GuideResp extends BaseInnerResult {
    private static final float BORDER_THRE = 0.05f;
    private static final float CENTER_THRE = 0.1f;
    private float borderThreshold;
    private float centerThreshold;
    public int ocrType;
    private float rate1;

    public float getBorderThreshold() {
        float f = this.borderThreshold;
        return f <= 0.0f ? BORDER_THRE : f;
    }

    public float getCenterThreshold() {
        float f = this.centerThreshold;
        if (f <= 0.0f) {
            return 0.1f;
        }
        return f;
    }

    public String toString() {
        return "{ocrType=" + this.ocrType + ", rate1=" + this.rate1 + ", borderThreshold=" + this.borderThreshold + ", centerThreshold=" + this.centerThreshold + "}";
    }

    public static GuideResp newDefaultOne() {
        return newDefaultOne(2);
    }

    public static GuideResp newDefaultOne(int i) {
        GuideResp guideResp = new GuideResp();
        guideResp.ocrType = i;
        guideResp.rate1 = BORDER_THRE;
        guideResp.borderThreshold = BORDER_THRE;
        guideResp.centerThreshold = 0.1f;
        return guideResp;
    }
}
