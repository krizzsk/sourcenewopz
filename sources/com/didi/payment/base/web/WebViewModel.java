package com.didi.payment.base.web;

import android.app.Activity;
import androidx.fragment.app.Fragment;

public class WebViewModel {
    public static final int TYPE_CMB = 4;
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_CREDIT_CARD = 1;
    public static final int TYPE_PAYPAL = 2;
    public static final int TYPE_ZFT = 3;
    public Activity activity;
    public String backUrl;
    public boolean canChangeWebViewTitle = true;
    public String cancelUrl;
    public Fragment fragment;
    public boolean isPostBaseParams;
    public boolean isSupportCache = true;
    public String postData;
    public int requestCode;
    public String title;
    public int type;
    public String url;
}
