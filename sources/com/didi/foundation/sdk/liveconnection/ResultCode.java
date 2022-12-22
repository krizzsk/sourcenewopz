package com.didi.foundation.sdk.liveconnection;

public interface ResultCode {
    public static final int ERROR_CODE_AUTHORIZATION = 110;
    public static final int ERROR_CODE_CONNECT_FAIL = 100;
    public static final int ERROR_CODE_DECODE = 160;
    public static final int ERROR_CODE_ENTER_FOREGROUND_TIMEOUT = 180;
    public static final int ERROR_CODE_HEARTBEAT = 120;
    public static final int ERROR_CODE_KICKOFF = 130;
    public static final int ERROR_CODE_NET_STATUS_CHANGED = 190;
    public static final int ERROR_CODE_READ_FAIL = 150;
    public static final int ERROR_CODE_SERVER_ERROR = 170;
    public static final int ERROR_CODE_WRITE_FAIL = 140;
    public static final int RET_CODE_AUTH_FAILED = -17;
    public static final int RET_CODE_CONNECTION_STOPED = 2;
    public static final int RET_CODE_CONNECT_ERROR = -9;
    public static final int RET_CODE_FILE_ERROR = -14;
    public static final int RET_CODE_HAS_STARTED_ERROR = -16;
    public static final int RET_CODE_HAS_TASK = -8;
    public static final int RET_CODE_HEART_BEAT_FAILED = -20;
    public static final int RET_CODE_MEMORY_ERROR = -6;
    public static final int RET_CODE_NOT_ALIVE = -18;
    public static final int RET_CODE_NOT_FOUND = -5;
    public static final int RET_CODE_NOT_INITED = -7;
    public static final int RET_CODE_OK = 0;
    public static final int RET_CODE_PARAM_ERROR = -2;
    public static final int RET_CODE_QUEUE_EMPTY_ERROR = -4;
    public static final int RET_CODE_QUEUE_FULL_ERROR = -3;
    public static final int RET_CODE_RECV_BAD_DATA = -13;
    public static final int RET_CODE_RECV_BUFFER_EXHAUSTED = -12;
    public static final int RET_CODE_RECV_ERROR = -11;
    public static final int RET_CODE_REQUEST_CANCELED = 1;
    public static final int RET_CODE_SEND_ERROR = -10;
    public static final int RET_CODE_SERVER_ERROR = -15;
    public static final int RET_CODE_SERV_CLOSE = -19;
    public static final int RET_CODE_SERV_KICK_OFF = -21;
    public static final int RET_CODE_SYSTEM_ERROR = -1;
    public static final int RET_CODE_TASK_TIMEOUT = -22;
}
