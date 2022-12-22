package com.didi.hawaii.p118ar.core;

import com.didi.hawaii.p118ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p118ar.jni.DARCNetworkStatus;

/* renamed from: com.didi.hawaii.ar.core.INetWorkerDelegate */
public interface INetWorkerDelegate {
    void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus);

    void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse);
}
