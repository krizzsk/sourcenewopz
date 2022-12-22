package com.didichuxing.dfbasesdk.http;

import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbsRpcCallback<T extends NewBaseResult<? extends Serializable>, R extends Serializable> implements RpcService.Callback<NewBaseResult<R>> {
    private final List<Integer> successCodeLists = new ArrayList(Arrays.asList(new Integer[]{100000}));

    /* access modifiers changed from: protected */
    public abstract void failure(int i, String str);

    /* access modifiers changed from: protected */
    public List<Integer> getSuccessCode(List<Integer> list) {
        return list;
    }

    /* access modifiers changed from: protected */
    public abstract void success(R r, int i, String str);

    public void onSuccess(NewBaseResult<R> newBaseResult) {
        if (newBaseResult == null || newBaseResult.apiCode != 200 || newBaseResult.data == null) {
            failure(newBaseResult == null ? 4 : 2, "server error");
        } else if (getSuccessCode(this.successCodeLists).contains(Integer.valueOf(newBaseResult.data.code))) {
            try {
                success((Serializable) newBaseResult.data.result, newBaseResult.data.code, newBaseResult.data.message);
            } catch (Exception e) {
                onFailure(new IOException(e));
            }
        } else {
            onBizFailed(newBaseResult.data.code, newBaseResult.data.message);
        }
    }

    public void onFailure(IOException iOException) {
        failure(1, iOException.getMessage());
    }

    /* access modifiers changed from: protected */
    public void onBizFailed(int i, String str) {
        failure(i, str);
    }
}
