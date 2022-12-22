package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMMessageCallback */
public interface IMMessageCallback extends IMMessagesLoadCallback, IMSucceedCallback {
    public static final int DELETE_FAILED = 402;
    public static final int DELETE_SUCCESS = 401;
    public static final int DOWNLOAD_FAILED = 302;
    public static final int DOWNLOAD_OK = 301;
    public static final int SEND_FAILED = 202;
    public static final int SEND_OK = 201;
    public static final int SEND_READ = 203;
    public static final int UPDATE_FAILED = 502;
    public static final int UPDATE_SUCCESS = 501;

    void onReadStatusChange(List<IMMessage> list, boolean z);

    void onReceive(List<IMMessage> list);

    void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse);
}
