package com.didi.onekeyshare.callback.intercept;

import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.entity.OneKeyShareInfo;

public interface IShareDialogIntercept {
    public static final String SYSTEM_SHARE_DIALOG = "system_share_dialog";

    boolean intercept(FragmentActivity fragmentActivity, OneKeyShareInfo oneKeyShareInfo);
}
