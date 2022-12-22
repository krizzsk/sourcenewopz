package com.didichuxing.dfbasesdk.act;

import android.content.Context;

public interface IPermissionCallback {

    public static class PermissionCallbackAdapter implements IPermissionCallback {
        public void onEnter() {
        }

        public void onPermissionGrantCancel(String str, int[] iArr) {
        }

        public void onPermissionGrantSetting(String str, int[] iArr) {
        }

        public void onPermissionSuccess(Context context) {
        }
    }

    void onEnter();

    void onPermissionGrantCancel(String str, int[] iArr);

    void onPermissionGrantSetting(String str, int[] iArr);

    void onPermissionSuccess(Context context);
}
