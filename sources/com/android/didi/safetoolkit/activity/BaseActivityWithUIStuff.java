package com.android.didi.safetoolkit.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.safetoolkit.UIStuff;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class BaseActivityWithUIStuff extends BaseActivity implements UIStuff {
    public View getFallbackView() {
        return null;
    }

    public void showPDialog() {
        if (!isDestroyed()) {
            showPDialog(getString(R.string.progress_hint_text), false);
        }
    }

    public void showPDialog(String str) {
        showPDialog(str, true);
    }

    public void showPDialog(String str, boolean z) {
        if (!isDestroyed() && !TextUtils.isEmpty(str)) {
            if (z) {
                showLoading();
            } else {
                showMaskLayerLoading();
            }
        }
    }

    public void closePDialog() {
        hideLoading();
    }

    public boolean isWaitDialogShowing() {
        return isLoading();
    }

    public void showToast(String str) {
        showToast(str, 0);
    }

    public void showToast(int i) {
        showToast(getString(i));
    }

    public void showToast(int i, int i2) {
        showToast(getString(i), i2);
    }

    public void showToast(String str, int i) {
        if (!isDestroyed() && !TextUtils.isEmpty(str)) {
            ToastHelper.showShortCompleted((Context) this, str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        closePDialog();
    }
}
