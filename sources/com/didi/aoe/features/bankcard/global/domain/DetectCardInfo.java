package com.didi.aoe.features.bankcard.global.domain;

import java.util.Arrays;

public class DetectCardInfo {
    public static final int MAX_CARDNUM_COUNT = 30;
    public String bank;
    public final float[] cardNumRect = new float[6];
    public final float[] cardRect = new float[6];
    public int count = 0;
    public int exMonth;
    public int exYear;
    public final int[] prediction = new int[30];
    public float prob = 0.0f;
    public final float[] validDateRect = new float[6];

    public String getCardNum() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.count; i++) {
            sb.append(this.prediction[i]);
        }
        return sb.toString();
    }

    public void reset() {
        this.count = 0;
        this.exYear = 0;
        this.exMonth = 0;
        this.bank = null;
        this.prob = 0.0f;
        Arrays.fill(this.prediction, 0);
        Arrays.fill(this.cardRect, 0.0f);
        Arrays.fill(this.cardNumRect, 0.0f);
        Arrays.fill(this.validDateRect, 0.0f);
    }
}
