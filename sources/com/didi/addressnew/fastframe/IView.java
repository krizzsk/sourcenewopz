package com.didi.addressnew.fastframe;

public interface IView {

    /* renamed from: com.didi.addressnew.fastframe.IView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$dismissProgressDialog(IView iView) {
        }

        public static String $default$getString(IView iView, int i) {
            return "";
        }

        public static String $default$getStringVal(IView iView, int i) {
            return "";
        }

        public static void $default$onHttpRequestSuccess(IView iView) {
        }

        public static void $default$showContentView(IView iView) {
        }

        public static void $default$showEmptyView(IView iView) {
        }

        public static void $default$showProgressDialog(IView iView, String str, boolean z) {
        }

        public static void $default$showProgressDialog(IView iView, boolean z) {
        }

        public static void $default$showToastComplete(IView iView, String str) {
        }

        public static void $default$showToastError(IView iView, String str) {
        }

        public static void $default$showToastError(IView iView, String str, boolean z) {
        }
    }

    void dismissProgressDialog();

    String getString(int i);

    String getStringVal(int i);

    void onHttpRequestSuccess();

    void showContentView();

    void showEmptyView();

    void showProgressDialog(String str, boolean z);

    void showProgressDialog(boolean z);

    void showToastComplete(String str);

    void showToastError(String str);

    void showToastError(String str, boolean z);
}
