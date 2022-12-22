package com.didi.dimina.container.page;

import androidx.fragment.app.Fragment;
import org.json.JSONObject;

public interface IPageHost {

    /* renamed from: com.didi.dimina.container.page.IPageHost$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$disableAlertBeforeUnload(IPageHost iPageHost) {
        }

        public static void $default$enableAlertBeforeUnload(IPageHost iPageHost, OnPageHostBackListener onPageHostBackListener) {
        }

        public static void $default$onBackPressedInner(IPageHost iPageHost) {
        }

        public static void $default$switchTabLoadJSFileToDataThreadFinish(IPageHost iPageHost, JSONObject jSONObject) {
        }
    }

    public interface OnPageHostBackListener {
        void OnBack();
    }

    void disableAlertBeforeUnload();

    void enableAlertBeforeUnload(OnPageHostBackListener onPageHostBackListener);

    DMPage getPage();

    Fragment getPageHost();

    void invokeDomReady();

    void onBackPressedInner();

    void switchTabLoadJSFileToDataThreadFinish(JSONObject jSONObject);
}
