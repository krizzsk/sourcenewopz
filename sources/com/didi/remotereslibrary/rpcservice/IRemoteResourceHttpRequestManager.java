package com.didi.remotereslibrary.rpcservice;

import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import java.util.HashMap;

public interface IRemoteResourceHttpRequestManager<T extends BaseResponse> {
    long httpRequest(String str, HashMap<String, Object> hashMap, T t, IRemoteCallBack iRemoteCallBack);
}
