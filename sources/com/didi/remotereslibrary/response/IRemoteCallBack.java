package com.didi.remotereslibrary.response;

import com.didi.remotereslibrary.response.BaseResponse;

public interface IRemoteCallBack<T extends BaseResponse> {
    void onError(T t);

    void onSuccess(T t);
}
