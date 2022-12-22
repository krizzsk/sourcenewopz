package com.didi.trackupload.sdk.datachannel;

import java.math.BigInteger;

public interface IDataChannelMsgCallback {
    void onFail(BigInteger bigInteger);

    void onSuccess(BigInteger bigInteger);
}
