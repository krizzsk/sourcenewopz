package com.didi.payment.base.web;

import android.app.Activity;
import androidx.fragment.app.Fragment;

public class WebSignParam {
    public Activity activity = null;
    public String backUrl = "";
    public String cancelUrl = "";
    public Fragment fragment = null;
    public String postData = "";
    public int requestCode = -1;
    public String title = "";
    public String url = "";
}
