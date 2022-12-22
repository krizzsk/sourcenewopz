package com.didichuxing.gbankcard.ocr.bankcard;

import android.text.TextUtils;
import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.gbankcard.ocr.utils.LuhnAlgo;
import com.didichuxing.gbankcard.ocr.utils.OcrTypeUtils;
import java.util.Arrays;

public class BankcardResult {
    public static final int STATE_CENTER_CHECK_FAIL = 3;
    public static final int STATE_HAS_RESULT = 5;
    public static final int STATE_HBORDER_CHECK_FAIL = 2;
    public static final int STATE_LUHN_CHECK_FAIL = 4;
    public static final int STATE_NO_RESULT = 0;
    public static final int STATE_SIZE_CHECK_FAIL = 1;

    /* renamed from: a */
    private final int f47700a;
    public final DetectCardInfo alphaCardInfo = new DetectCardInfo();

    /* renamed from: b */
    private final float f47701b;

    /* renamed from: c */
    private final float f47702c;

    public static class CardNumInfo {
        public String cardNum;
        public float score;
        public int state = 0;

        CardNumInfo() {
        }
    }

    public BankcardResult(int i, float f, float f2) {
        this.f47700a = i;
        this.f47701b = f;
        this.f47702c = f2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CardNumInfo mo117743a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        CardNumInfo cardNumInfo = new CardNumInfo();
        String cardNum = this.alphaCardInfo.getCardNum();
        cardNumInfo.cardNum = cardNum;
        cardNumInfo.score = this.alphaCardInfo.prob;
        float[] fArr = this.alphaCardInfo.cardRect;
        LogUtils.m33563d("rawCardNum===" + cardNumInfo.cardNum + ", score=" + cardNumInfo.score);
        StringBuilder sb = new StringBuilder();
        sb.append("cardRect===");
        sb.append(Arrays.toString(fArr));
        LogUtils.m33563d(sb.toString());
        if (fArr != null && fArr.length >= 6) {
            float f = fArr[2];
            float f2 = fArr[3];
            float f3 = fArr[4];
            float f4 = fArr[5];
            float f5 = f3 - f;
            float f6 = f4 - f2;
            if (f5 <= 0.0f || f6 <= 0.0f) {
                cardNumInfo.state = 0;
            } else if (TextUtils.isEmpty(cardNum)) {
                cardNumInfo.state = 0;
                return cardNumInfo;
            } else {
                LogUtils.m33563d("imgW===" + i3 + ", imgH=" + i4 + ", cardW=" + f5 + ", cardH=" + f6);
                if (f5 <= f6 || ((f5 * f6) / ((float) i3)) / ((float) i4) >= 0.4f) {
                    float[] fArr2 = this.alphaCardInfo.cardNumRect;
                    LogUtils.m33563d("cardNumRect===" + Arrays.toString(fArr2));
                    float f7 = (float) i3;
                    float min = Math.min(fArr2[2], f7 - fArr2[4]);
                    LogUtils.m33563d("xborder===" + min);
                    if (min / f5 < this.f47701b) {
                        LogUtils.m33563d("left-right border pos invalid!!!");
                        cardNumInfo.state = 2;
                        return cardNumInfo;
                    }
                    float abs = Math.abs((f7 / 2.0f) - ((f + f3) / 2.0f));
                    float abs2 = Math.abs((((float) i4) / 2.0f) - ((f2 + f4) / 2.0f));
                    LogUtils.m33563d("centerXOffset===" + abs + ", centerYOffset=" + abs2);
                    float f8 = this.f47702c;
                    if (abs / f5 > f8 || abs2 / f6 > f8) {
                        LogUtils.m33563d("center pos invalid!!!");
                        cardNumInfo.state = 3;
                        return cardNumInfo;
                    } else if (LuhnAlgo.checkLuhn(cardNum)) {
                        cardNumInfo.state = 5;
                    } else {
                        LogUtils.m33563d("luhn check failed!!!");
                        cardNumInfo.state = 4;
                    }
                } else {
                    LogUtils.m33563d("size ratio invalid!!!");
                    cardNumInfo.state = 1;
                    return cardNumInfo;
                }
            }
        }
        return cardNumInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float[] mo117744a() {
        if (OcrTypeUtils.isUsingDidiCardIO(this.f47700a)) {
            return null;
        }
        return this.alphaCardInfo.cardRect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float[] mo117745b() {
        if (OcrTypeUtils.isUsingDidiCardIO(this.f47700a)) {
            return null;
        }
        return this.alphaCardInfo.cardNumRect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo117746c() {
        this.alphaCardInfo.reset();
    }
}
