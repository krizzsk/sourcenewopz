package com.didiglobal.p205sa.biz.weight.tkrefreshlayout;

import android.view.View;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.IBottomView */
public interface IBottomView {
    View getView();

    void onFinish();

    void onPullReleasing(float f, float f2, float f3);

    void onPullingUp(float f, float f2, float f3);

    void reset();

    void startAnim(float f, float f2);
}
