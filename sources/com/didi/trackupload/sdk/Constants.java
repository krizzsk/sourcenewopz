package com.didi.trackupload.sdk;

import com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrMessageType;
import com.didi.trackupload.sdk.datachannel.protobuf.MsgType;

public class Constants {
    public static final boolean DEBUG = false;
    public static final long HTTP_REQUEST_TIMEOUT_MILLIS = 10000;
    public static final String HTTP_URL_SEND_TRACK = "https://apimap.didiglobal.com/map/trajservice/transferus/";
    public static final String HTTP_URL_TEST_SEND_TRACK = "https://apimap.didiglobal.com/map/trajservice/transfertest/";
    public static final long LOC_EFFECTIVE_TIME = 30000;
    public static final long REQUEST_ONCE_LOCATION_TIMEOUT_MILLIS = 10000;
    public static final long SUBTITUDE_LOC_EFFECTIVE_TIME = 1500;
    public static final int TRACK_BINARY_MSG_TYPE = CollectSvrMessageType.kCollectSvrMessageTypeTrackUploadReq.getValue();
    public static final int TRACK_PUSH_MSG_TYPE = MsgType.kMsgTypeCollectSvrNoRspReq.getValue();
}
