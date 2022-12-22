package com.didi.safety.god.http;

import com.didi.safety.god.http.BaseInnerResult;
import com.didi.safety.god.http.SafetyResponse2;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class AbsRpcCallback<T extends SafetyResponse2, R extends BaseInnerResult> implements RpcService.Callback<SafetyResponse2<R>> {
    public static final int LOCAL_FAIL_CODE_1 = 1;
    public static final int LOCAL_FAIL_CODE_2 = 2;
    protected R respResult;

    /* access modifiers changed from: protected */
    public boolean isLocalFail(int i) {
        return i == 1 || i == 2;
    }

    public abstract void onBizOk(R r);

    public abstract void onFailed(int i, String str);

    public void onSuccess(SafetyResponse2<R> safetyResponse2) {
        if (safetyResponse2 == null) {
            onFailed(2, "resp==null!!!");
            return;
        }
        int i = safetyResponse2.apiCode;
        if (i == 200 && safetyResponse2.data != null) {
            R r = (BaseInnerResult) safetyResponse2.data.result;
            this.respResult = r;
            int i2 = safetyResponse2.data.code;
            String str = safetyResponse2.data.message;
            if (i2 == 100000) {
                onBizOk(r);
            } else {
                onBizFail(i2, str);
            }
        } else if (i != 200) {
            onFailed(2, "apiCode=" + i);
        } else {
            onFailed(2, "resp.data==null!!!");
        }
    }

    public void onBizFail(int i, String str) {
        onFailed(i, str);
    }

    public void onFailure(IOException iOException) {
        onFailed(1, iOException.getMessage());
    }
}
