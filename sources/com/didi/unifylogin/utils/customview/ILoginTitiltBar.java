package com.didi.unifylogin.utils.customview;

import android.view.View;

public interface ILoginTitiltBar {
    void setCenterMsg(String str);

    void setCenterVisible(boolean z);

    void setLeftClickListener(View.OnClickListener onClickListener);

    void setLeftVisible(boolean z);

    void setRightClickListener(View.OnClickListener onClickListener);

    void setRightText(CharSequence charSequence);

    void setRightVisible(boolean z);
}
