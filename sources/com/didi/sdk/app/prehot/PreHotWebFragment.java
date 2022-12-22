package com.didi.sdk.app.prehot;

import android.app.Activity;
import android.os.Bundle;
import com.didi.global.loading.Loading;
import com.didi.sdk.webview.WebFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;

public class PreHotWebFragment extends WebFragment {

    /* renamed from: a */
    private LoginListeners.LoginListener f35242a = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            PreHotWebFragment.this.refresh();
        }
    };

    /* renamed from: b */
    private LoginListeners.LoginOutListener f35243b = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            PreHotWebFragment.this.refresh();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OneLoginFacade.getFunction().addLoginListener(this.f35242a);
        OneLoginFacade.getFunction().addLoginOutListener(this.f35243b);
    }

    public void onDestroy() {
        super.onDestroy();
        OneLoginFacade.getFunction().removeLoginListener(this.f35242a);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f35243b);
    }

    /* access modifiers changed from: protected */
    public void showProgress() {
        if (this.mWebView != null) {
            Loading.make(getContext(), this.mWebView).show();
        }
    }

    /* access modifiers changed from: protected */
    public void hideProgress() {
        if (this.mWebView != null) {
            Loading.hide(this.mWebView);
        }
    }
}
