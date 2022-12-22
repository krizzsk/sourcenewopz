package com.didi.onekeyshare;

import androidx.fragment.app.FragmentActivity;

public interface ShareFragmentListener {
    void onDismiss(FragmentActivity fragmentActivity);

    void onShow(FragmentActivity fragmentActivity);
}
