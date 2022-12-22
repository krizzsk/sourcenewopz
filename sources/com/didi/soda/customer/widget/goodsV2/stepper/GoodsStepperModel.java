package com.didi.soda.customer.widget.goodsV2.stepper;

public class GoodsStepperModel {

    /* renamed from: a */
    private int f41970a = 0;
    public int mCurQuantityNumber = 0;
    public boolean mIsAddEnabled = true;

    public void syncLastQuantityNumber() {
        this.f41970a = this.mCurQuantityNumber;
    }

    public boolean needExpand() {
        return this.f41970a == 0 && this.mCurQuantityNumber > 0;
    }

    public boolean needCollapse() {
        return this.f41970a > 0 && this.mCurQuantityNumber == 0;
    }

    public boolean isNumDiff() {
        return this.f41970a != this.mCurQuantityNumber;
    }
}
