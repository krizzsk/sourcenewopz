package com.didi.payment.commonsdk.net;

import android.content.Context;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public abstract class AbsRpcCallback<T> implements RpcService.Callback<T> {
    private final Context mContext;
    private boolean showDefaultToastWhenfail = false;

    public abstract void onHandleFailure(IOException iOException);

    public abstract void onHandleSuccess(T t);

    public void onTaskFinish() {
    }

    public AbsRpcCallback(Context context) {
        this.mContext = context;
        this.showDefaultToastWhenfail = true;
    }

    public AbsRpcCallback(Context context, boolean z) {
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
        WalletToastNew.showFailedMsg(this.mContext, getGlobalDefaultErrorToastMsg());
    }

    /* access modifiers changed from: protected */
    public void showSuccessToast(String str) {
        if (TextUtil.isEmpty(str)) {
            str = getGlobalDefaultSuccessToastMsg();
        }
        WalletToastNew.showSuccessMsg(this.mContext, str);
    }

    /* access modifiers changed from: protected */
    public void showErrorToast(String str) {
        if (TextUtil.isEmpty(str)) {
            str = getGlobalDefaultErrorToastMsg();
        }
        WalletToastNew.showFailedMsg(this.mContext, str);
    }

    /* access modifiers changed from: protected */
    public String getGlobalDefaultErrorToastMsg() {
        return this.mContext.getResources().getString(R.string.GWallet_Operation_failed_HAmB);
    }

    /* access modifiers changed from: protected */
    public String getGlobalDefaultSuccessToastMsg() {
        return this.mContext.getResources().getString(R.string.GWallet_Operation_OK_jLdZ);
    }
}
