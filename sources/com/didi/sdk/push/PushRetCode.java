package com.didi.sdk.push;

public interface PushRetCode {
    public static final int ErrorCodeAuthorization = 110;
    public static final int ErrorCodeConnectFail = 100;
    public static final int ErrorCodeDecode = 160;
    public static final int ErrorCodeEnterForegroundTimeout = 180;
    public static final int ErrorCodeHeartbeat = 120;
    public static final int ErrorCodeKickoff = 130;
    public static final int ErrorCodeNetStatusChanged = 190;
    public static final int ErrorCodeReadFail = 150;
    public static final int ErrorCodeServerError = 170;
    public static final int ErrorCodeWriteFail = 140;
    public static final int RetCodeAuthFailed = -17;
    public static final int RetCodeConnectError = -9;
    public static final int RetCodeConnectionStoped = 2;
    public static final int RetCodeFileError = -14;
    public static final int RetCodeHasStartedError = -16;
    public static final int RetCodeHasTask = -8;
    public static final int RetCodeHeartBeatFailed = -20;
    public static final int RetCodeMemoryError = -6;
    public static final int RetCodeNotAlive = -18;
    public static final int RetCodeNotFound = -5;
    public static final int RetCodeNotInited = -7;
    public static final int RetCodeOk = 0;
    public static final int RetCodeParamError = -2;
    public static final int RetCodeQueueEmptyError = -4;
    public static final int RetCodeQueueFullError = -3;
    public static final int RetCodeRecvBadData = -13;
    public static final int RetCodeRecvBufferExhausted = -12;
    public static final int RetCodeRecvError = -11;
    public static final int RetCodeRequestCanceled = 1;
    public static final int RetCodeSendError = -10;
    public static final int RetCodeServClose = -19;
    public static final int RetCodeServKickOff = -21;
    public static final int RetCodeServerError = -15;
    public static final int RetCodeSystemError = -1;
    public static final int RetCodeTaskTimeout = -22;
}
