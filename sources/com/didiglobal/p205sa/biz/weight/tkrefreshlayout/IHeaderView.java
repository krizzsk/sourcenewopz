package com.didiglobal.p205sa.biz.weight.tkrefreshlayout;

import android.view.View;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.IHeaderView */
public interface IHeaderView {
    View getView();

    void onFinish(OnAnimEndListener onAnimEndListener);

    void onPullReleasing(float f, float f2, float f3);

    void onPullingDown(float f, float f2, float f3);

    void reset();

    void startAnim(float f, float f2);
}
