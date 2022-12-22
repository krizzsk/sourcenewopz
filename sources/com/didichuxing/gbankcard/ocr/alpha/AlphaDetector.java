package com.didichuxing.gbankcard.ocr.alpha;

import com.didi.aoe.features.bankcard.global.GlobalBankcardOcr;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardResult;
import com.didichuxing.gbankcard.ocr.bankcard.IBankcardDetector;

public class AlphaDetector implements IBankcardDetector {

    /* renamed from: a */
    private GlobalBankcardOcr f47694a;

    /* renamed from: b */
    private int f47695b;

    public int detect(byte[] bArr, int i, int i2, BankcardResult bankcardResult) {
        GlobalBankcardOcr globalBankcardOcr = this.f47694a;
        if (globalBankcardOcr == null) {
            GlobalBankcardOcr globalBankcardOcr2 = new GlobalBankcardOcr(AppContextHolder.getAppContext());
            this.f47694a = globalBankcardOcr2;
            this.f47695b = globalBankcardOcr2.init();
            LogUtils.m33563d("alpha initFlag===" + this.f47695b);
        } else {
            globalBankcardOcr.process(bArr, i, i2, bankcardResult.alphaCardInfo);
        }
        return this.f47695b;
    }

    public void stop() {
        GlobalBankcardOcr globalBankcardOcr = this.f47694a;
        if (globalBankcardOcr != null) {
            globalBankcardOcr.destory();
            this.f47694a = null;
        }
    }
}
