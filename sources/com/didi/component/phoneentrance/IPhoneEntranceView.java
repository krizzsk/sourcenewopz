package com.didi.component.phoneentrance;

import com.didi.component.core.IView;

public interface IPhoneEntranceView extends IView<AbsPhoneEntrancePresenter> {

    public interface OnPhoneEntranceClickListener {
        void onPhoneEntranceClick();
    }

    void setOnPhoneEntranceClickListener(OnPhoneEntranceClickListener onPhoneEntranceClickListener);

    void setPhoneClickable(boolean z);

    void setPhoneGray();

    void setPhoneIcon(int i);

    void setSecurityVisible(boolean z);
}
