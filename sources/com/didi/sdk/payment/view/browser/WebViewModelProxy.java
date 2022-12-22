package com.didi.sdk.payment.view.browser;

import android.app.Activity;
import androidx.fragment.app.Fragment;

public class WebViewModelProxy {

    /* renamed from: a */
    private Activity f36920a;

    /* renamed from: b */
    private Fragment f36921b;

    /* renamed from: c */
    private String f36922c;

    /* renamed from: d */
    private String f36923d;

    /* renamed from: e */
    private String f36924e;

    /* renamed from: f */
    private String f36925f;

    /* renamed from: g */
    private String f36926g;

    /* renamed from: h */
    private int f36927h;

    /* renamed from: i */
    private int f36928i;

    /* renamed from: j */
    private boolean f36929j = true;

    /* renamed from: k */
    private boolean f36930k = true;

    /* renamed from: l */
    private boolean f36931l;

    public String getTitle() {
        return this.f36922c;
    }

    public void setTitle(String str) {
        this.f36922c = str;
    }

    public String getUrl() {
        return this.f36923d;
    }

    public void setUrl(String str) {
        this.f36923d = str;
    }

    public Activity getActivity() {
        return this.f36920a;
    }

    public void setActivity(Activity activity) {
        this.f36920a = activity;
    }

    public String getPostData() {
        return this.f36924e;
    }

    public void setPostData(String str) {
        this.f36924e = str;
    }

    public String getBackUrl() {
        return this.f36925f;
    }

    public void setBackUrl(String str) {
        this.f36925f = str;
    }

    public String getCancelUrl() {
        return this.f36926g;
    }

    public void setCancelUrl(String str) {
        this.f36926g = str;
    }

    public int getRequestCode() {
        return this.f36927h;
    }

    public void setRequestCode(int i) {
        this.f36927h = i;
    }

    public Fragment getFragment() {
        return this.f36921b;
    }

    public void setFragment(Fragment fragment) {
        this.f36921b = fragment;
    }

    public int getType() {
        return this.f36928i;
    }

    public void setType(int i) {
        this.f36928i = i;
    }

    public boolean isCanChangeWebViewTitle() {
        return this.f36929j;
    }

    public void setCanChangeWebViewTitle(boolean z) {
        this.f36929j = z;
    }

    public boolean isSupportCache() {
        return this.f36930k;
    }

    public void setSupportCache(boolean z) {
        this.f36930k = z;
    }

    public boolean isPostBaseParams() {
        return this.f36931l;
    }

    public void setPostBaseParams(boolean z) {
        this.f36931l = z;
    }
}
