package com.didi.hawaii.p118ar.core;

import com.didi.hawaii.p118ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p118ar.jni.DARCNetworkStatus;
import com.didi.hawaii.p118ar.utils.NetStateUtil;

/* renamed from: com.didi.hawaii.ar.core.NetWorkerManager */
public class NetWorkerManager extends BaseDelegate implements INetWorkerDelegate {
    NetWorkerManager(DiAREngine diAREngine) {
        attachEngine(diAREngine);
        NetStateUtil.startListenNetWorkerState(new NetStateUtil.NetStateChangeListener() {
            public void onStateChange(int i) {
                NetWorkerManager.this.networkStatusChanged(NetStateUtil.convertNetworkeStateJava2AR(i));
            }
        });
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
        if (this.mAREngine != null) {
            this.mAREngine.recvHTTPResponse(dARCHTTPResponse);
        }
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
        if (this.mAREngine != null) {
            this.mAREngine.networkStatusChanged(dARCNetworkStatus);
        }
    }

    public void release() {
        super.release();
        NetStateUtil.stopListenNetWorkerState();
    }
}
