package com.didi.payment.paymethod.open;

import com.didi.payment.paymethod.server.bean.SignCancelResult;
import com.didi.payment.paymethod.server.bean.SignResult;
import com.didi.payment.paymethod.server.bean.SignStatus;
import com.didichuxing.foundation.rpc.RpcService;

public interface ISignServerApi {
    void cancelSign(int i, int i2, RpcService.Callback<SignCancelResult> callback);

    void querySignStatus(int i, int i2, int i3, RpcService.Callback<SignStatus> callback);

    void sign(int i, int i2, String str, String str2, RpcService.Callback<SignResult> callback);
}
