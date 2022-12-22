package com.didi.trackupload.sdk;

public class TrackErrInfo {
    public static final int ERR_OK = 0;
    public static final int ERR_PARAMS_CLIENT_TYPE = 204;
    public static final int ERR_PARAMS_COMMON_INFO_DELEGATE = 106;
    public static final int ERR_PARAMS_CONTEXT = 104;
    public static final int ERR_PARAMS_DATA_CHANNEL = 105;
    public static final int ERR_PARAMS_TRACKID = 205;
    public static final int ERR_PARAMS_TRACK_DATA_DELEGATE = 207;
    public static final int ERR_PARAMS_TRACK_OPTIONS = 206;
    public static final int ERR_STATE_CLIENT_ALREADY_STARTED = 202;
    public static final int ERR_STATE_CLIENT_NOT_EXISTS = 201;
    public static final int ERR_STATE_CLIENT_NOT_STARTED = 203;
    public static final int ERR_STATE_SERVICE_ALREADY_DESTORYED = 103;
    public static final int ERR_STATE_SERVICE_ALREADY_INITED = 102;
    public static final int ERR_STATE_SERVICE_NOT_INITED = 101;
    public static final int ERR_UNKNOWN = 9999;

    public static String toErrMsg(int i) {
        if (i == 0) {
            return "成功";
        }
        switch (i) {
            case 101:
                return "轨迹流服务尚未初始化";
            case 102:
                return "轨迹流服务无需重复初始化";
            case 103:
                return "轨迹流服务无需重复销毁";
            case 104:
                return "Context参数非法";
            case 105:
                return "DataChannel参数非法";
            case 106:
                return "ICommonInfoDelegate参数非法";
            default:
                switch (i) {
                    case 201:
                        return "TrackClient不存在";
                    case 202:
                        return "TrackClient已经是启动状态";
                    case 203:
                        return "TrackClient尚未启动";
                    case 204:
                        return "ClientType参数非法";
                    case 205:
                        return "TrackId参数非法";
                    case 206:
                        return "TrackOptions参数非法";
                    case 207:
                        return "ITrackDataDelegate参数非法";
                    default:
                        return "未知错误";
                }
        }
    }

    public static String toErrString(int i) {
        return "{errCode=" + i + ", errMsg=" + toErrMsg(i) + "}";
    }
}
