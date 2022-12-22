package com.didi.payment.transfer.common;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public abstract class AbsTransRpcSvrCallback<T> implements RpcService.Callback<T> {
    private final Context mContext;
    private boolean showDefaultToastWhenfail = false;

    public abstract void onHandleFailure(IOException iOException);

    public abstract void onHandleSuccess(T t);

    public void onTaskFinish() {
    }

    public AbsTransRpcSvrCallback(Context context) {
        this.mContext = context;
        this.showDefaultToastWhenfail = true;
    }

    public AbsTransRpcSvrCallback(Context context, boolean z) {
        this.mContext = context;
        this.showDefaultToastWhenfail = z;
    }

    public final void onSuccess(T t) {
        onTaskFinish();
        onHandleSuccess(t);
    }

    public final void onFailure(IOException iOException) {
        onTaskFinish();
        if (this.showDefaultToastWhenfail && this.mContext != null) {
            showDefaultErrorToast();
        }
        onHandleFailure(iOException);
    }

    /* access modifiers changed from: protected */
    public void showDefaultErrorToast() {
        ToastHelper.showShortInfo(this.mContext, getGlobalDefaultErrorToastMsg(), (int) R.drawable.wallet_toast_icon_fail);
    }

    /* access modifiers changed from: protected */
    public void showSuccessToast(String str) {
        if (TextUtil.isEmpty(str)) {
            str = getGlobalDefaultSuccessToastMsg();
        }
        ToastHelper.showShortInfo(this.mContext, str, (int) R.drawable.wallet_toast_icon_successful);
    }

    /* access modifiers changed from: protected */
    public void showErrorToast(String str) {
        if (TextUtil.isEmpty(str)) {
            str = getGlobalDefaultErrorToastMsg();
        }
        ToastHelper.showShortInfo(this.mContext, str, (int) R.drawable.wallet_toast_icon_fail);
    }

    /* access modifiers changed from: protected */
    public String getGlobalDefaultErrorToastMsg() {
        return this.mContext.getResources().getString(R.string.GRider_PAX_Operation_failed_HAmB);
    }

    /* access modifiers changed from: protected */
    public String getGlobalDefaultSuccessToastMsg() {
        return this.mContext.getResources().getString(R.string.GRider_Riders_OK_jLdZ);
    }
}
