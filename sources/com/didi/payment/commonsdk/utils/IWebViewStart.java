package com.didi.payment.commonsdk.utils;

import androidx.fragment.app.FragmentActivity;

public interface IWebViewStart {
    public static final String WEB_99PAY_ALIAS = "99Pay";
    public static final String WEB_DRIVER_ALIAS = "99Driver";

    void open(FragmentActivity fragmentActivity, String str, String str2);
}
