package com.didi.sdk.push.common;

public interface IThirdPartyMsgParamsGetter {
    PushAckParams getPushAckParams();

    UploadThirdIdParams getUploadThirdIdParams();
}
