package com.didi.trackupload.sdk.datachannel;

import com.didi.sdk.protobuf.BinaryMsg;
import java.math.BigInteger;

public interface IDataChannel {
    boolean isConnected();

    BigInteger sendMessage(int i, BinaryMsg binaryMsg);

    void setMsgCallback(IDataChannelMsgCallback iDataChannelMsgCallback);
}
