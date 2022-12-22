package com.didichuxing.gbankcard.ocr.bankcard;

import com.didichuxing.gbankcard.ocr.alpha.AlphaDetector;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardResult;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;

public class BankcardDetector {

    /* renamed from: a */
    private final IBankcardDetector f47696a = new AlphaDetector();

    /* renamed from: b */
    private final BankcardResult f47697b;

    /* renamed from: c */
    private int f47698c;

    /* renamed from: d */
    private int f47699d;

    public BankcardDetector(GuideResp guideResp) {
        int i = guideResp.ocrType;
        this.f47697b = new BankcardResult(i, guideResp.getBorderThreshold(), guideResp.getCenterThreshold());
    }

    public int detect(byte[] bArr, int i, int i2) {
        this.f47698c = i;
        this.f47699d = i2;
        return this.f47696a.detect(bArr, i, i2, this.f47697b);
    }

    public void stop() {
        this.f47696a.stop();
    }

    public BankcardResult.CardNumInfo getCardNumInfo() {
        return this.f47697b.mo117743a(this.f47699d, this.f47698c);
    }

    public float[] getCardRect() {
        return this.f47697b.mo117744a();
    }

    public float[] getCardNumRect() {
        return this.f47697b.mo117745b();
    }

    public void reset() {
        this.f47697b.mo117746c();
    }
}
