package com.didi.sdk.app;

import android.view.View;

public interface ITitleBarDelegate {
    void addViewToRightRegion(View view);

    void hideTitleBar();

    void hideTitleBarRightBtn();

    void resetTitleBarAlpha(float f);

    void resetTitleBarYPosition(int i);

    void restoreTitleBar();

    void updateTitleBarLeftBtn(int i, View.OnClickListener onClickListener);
}
