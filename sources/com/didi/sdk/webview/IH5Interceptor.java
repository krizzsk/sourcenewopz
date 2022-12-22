package com.didi.sdk.webview;

import androidx.fragment.app.FragmentActivity;

public interface IH5Interceptor {
    boolean intercept(FragmentActivity fragmentActivity, String str);
}
