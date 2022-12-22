package com.didi.map.global.sctx.case_parser.model;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/map/global/sctx/case_parser/model/SctxCaseCode;", "", "code", "", "primaryMsg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getPrimaryMsg", "()Ljava/lang/String;", "JUMP_UNKNOWN", "NEW_PATH_OFF_COURSE", "NEW_PATH_SAME_ROUTE", "ORA_REQUEST_TIMEOUT", "ORA_REQUEST_ERROR", "INERTIA_MATCH_FAIL", "INERTIA_DRIVER_TOO_FAR", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SctxCaseCode.kt */
public enum SctxCaseCode {
    JUMP_UNKNOWN(100, "跳变未知错误"),
    NEW_PATH_OFF_COURSE(101, "偏航下发新路线"),
    NEW_PATH_SAME_ROUTE(102, "非偏航下发新路线"),
    ORA_REQUEST_TIMEOUT(103, "ORA请求超时"),
    ORA_REQUEST_ERROR(104, "ORA请求错误"),
    INERTIA_MATCH_FAIL(105, "绑路失败"),
    INERTIA_DRIVER_TOO_FAR(106, "司机位置跳变");
    
    private final int code;
    private final String primaryMsg;

    private SctxCaseCode(int i, String str) {
        this.code = i;
        this.primaryMsg = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getPrimaryMsg() {
        return this.primaryMsg;
    }
}
