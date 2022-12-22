package com.didi.payment.paymethod.server.global;

import com.didi.payment.paymethod.server.global.request.BalanceQueryReq;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.request.SignReq;
import com.didi.payment.paymethod.server.global.response.BalanceQueryResp;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.server.global.response.SignResultResp;
import com.didichuxing.foundation.rpc.RpcService;

public interface IGlobalPayMethodModel {
    void cancelSign(SignCancelReq signCancelReq, RpcService.Callback<SignCancelResp> callback);

    void pollSignStatus(SignPollingQueryReq signPollingQueryReq, RpcService.Callback<SignPollingQueryResp> callback);

    void queryBalance(BalanceQueryReq balanceQueryReq, RpcService.Callback<BalanceQueryResp> callback);

    void sign(SignReq signReq, RpcService.Callback<SignResultResp> callback);
}
