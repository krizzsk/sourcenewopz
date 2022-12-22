package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCAskResponseWrap */
public class DARCAskResponseWrap extends DARCAskResponse {
    public DARCAskResponseWrap(long j, boolean z) {
        super(AREngineJNIBridge.DARCAskResponse_SWIGUpcast(j), z);
    }

    public static DARCAskResponse createAskResponse(DARCHTTPResponse dARCHTTPResponse) {
        long DARCAskResponse_createAskResponseWrap = AREngineJNIBridge.DARCAskResponse_createAskResponseWrap(DARCHTTPResponse.getCPtr(dARCHTTPResponse), dARCHTTPResponse);
        if (DARCAskResponse_createAskResponseWrap == 0) {
            return null;
        }
        return new DARCAskResponse(DARCAskResponse_createAskResponseWrap, false);
    }
}
