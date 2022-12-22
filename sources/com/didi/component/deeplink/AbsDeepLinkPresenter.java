package com.didi.component.deeplink;

import android.content.Context;
import com.didi.component.common.dialog.LoadingDialogInfo;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;

public abstract class AbsDeepLinkPresenter extends IPresenter<IView> {
    protected final int DIALOG_LOADING = 10;

    public AbsDeepLinkPresenter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(String str) {
        LoadingDialogInfo loadingDialogInfo = new LoadingDialogInfo(10);
        loadingDialogInfo.setMessage(str);
        loadingDialogInfo.setCancelable(false);
        showDialog(loadingDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void dismissProgressDialog() {
        dismissDialog(10);
    }
}
