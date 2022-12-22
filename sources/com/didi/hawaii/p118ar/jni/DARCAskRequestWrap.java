package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCAskRequestWrap */
public class DARCAskRequestWrap extends DARCAskRequest {
    protected DARCAskRequestWrap(long j, boolean z) {
        super(AREngineJNIBridge.DARCAskRequest_SWIGUpcast(j), z);
    }

    public static DARCHTTPRequest createHttpRequest(DARCAskRequest dARCAskRequest) {
        long DARCAskRequest_createHttpRequestWrap = AREngineJNIBridge.DARCAskRequest_createHttpRequestWrap(DARCAskRequest.getCPtr(dARCAskRequest), dARCAskRequest);
        if (DARCAskRequest_createHttpRequestWrap == 0) {
            return null;
        }
        return new DARCHTTPRequest(DARCAskRequest_createHttpRequestWrap, false);
    }
}
