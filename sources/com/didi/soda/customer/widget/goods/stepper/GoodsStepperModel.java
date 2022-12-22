package com.didi.soda.customer.widget.goods.stepper;

public class GoodsStepperModel {

    /* renamed from: a */
    private int f41895a = 0;
    public int mCurQuantityNumber = 0;
    public boolean mIsAddEnabled = true;

    public void syncLastQuantityNumber() {
        this.f41895a = this.mCurQuantityNumber;
    }

    public boolean needExpand() {
        return this.f41895a == 0 && this.mCurQuantityNumber > 0;
    }

    public boolean needCollapse() {
        return this.f41895a > 0 && this.mCurQuantityNumber == 0;
    }

    public boolean isNumDiff() {
        return this.f41895a != this.mCurQuantityNumber;
    }
}
