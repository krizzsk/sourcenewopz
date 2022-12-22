package com.didi.trackupload.sdk.core;

public enum UploadResult {
    ERR_OK(0, "成功"),
    ERR_PARAMS_COMMON_INFO_DELEGATE(1001, "ICommonInfoDelegate参数非法"),
    ERR_PARAMS_BIZ_NODES(1002, "BizNode为空"),
    ERR_PARAMS_TRACK_CLIENT(1003, "TrackClient为空"),
    ERR_STATE_LAST_LOCATION(2001, "最近定位点获取失败"),
    ERR_STATE_DATA_CHANNEL_NOT_INITED(2002, "DataChannel未初始化"),
    ERR_STATE_DATA_CHANNEL_NOT_CONNECTED(2003, "DataChannel未连接"),
    ERR_STATE_HAS_PENDING_TASK(2004, "已经有上报任务在排队中"),
    ERR_STATE_UPLOAD_TIMEOUT(2005, "上传超时"),
    ERR_STATE_UPLOAD_FAILED(2006, "上传失败"),
    ERR_STATE_BUILD_UPLOAD_REQ(2007, "创建上报请求失败"),
    ERR_UNKNOWN(9999, "未知错误");
    
    private int mErrCode;
    private String mErrMsg;

    private UploadResult(int i, String str) {
        this.mErrCode = i;
        this.mErrMsg = str;
    }

    public int getCode() {
        return this.mErrCode;
    }

    public String toString() {
        return "{errCode=" + name() + "(" + this.mErrCode + ") , errMsg=" + this.mErrMsg + "}";
    }

    public String toSimpleString() {
        return name() + "(" + this.mErrCode + ")";
    }
}
