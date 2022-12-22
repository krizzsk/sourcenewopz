package com.didichuxing.diface;

import android.text.TextUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.diface.core.DiFaceFacade;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DiFaceResult implements Serializable {
    public static final int APPEAL_INVOKE = 1002;
    public static final int APPEAL_PHOTO_CONFIRM = 1007;
    public static final int APPEAL_PHOTO_DELETE = 1008;
    public static final int APPEAL_PHOTO_TAKE = 1006;
    public static final int APPEAL_SUBMIT_SUCCESS = 1000;
    public static final int APPEAL_UNDERWAY = 1001;
    public static final int APPEAL_VIDEO_CONFIRM = 1004;
    public static final int APPEAL_VIDEO_DELETE = 1005;
    public static final int APPEAL_VIDEO_TAKE = 1003;
    public static final int BIOASSAY_FAILED = 1009;
    public static final int BIOASSAY_ON_PAUSE = 1010;
    public static final int CODE_FAILED_ALPHA_SDK_INIT_ERROR = 100;
    public static final int CODE_FAILED_APPEAL_UNDERWAY = 114;
    public static final int CODE_FAILED_CALLER_STOP = 108;
    public static final int CODE_FAILED_COMPARE = 103;
    public static final int CODE_FAILED_NO_INTERNET = 112;
    public static final int CODE_FAILED_OVER_TIMES = 104;
    public static final int CODE_FAILED_PARAM_INCORRECT = 101;
    public static final int CODE_FAILED_SDK_NOT_INITIALIZED = 111;
    public static final int CODE_FAILED_SERVICE_EXCEPTION = 113;
    public static final int CODE_FAILED_UNKNOWN_ERROR = 106;
    public static final int CODE_FAILED_USER_CANCEL = 102;
    public static final int CODE_FAILED_USER_INFO_NOT_COMPELETE = 105;
    public static final int CODE_FAILED_USER_KICKED_OUT = 107;
    public static final int CODE_FAILED_USER_PERMISSION_NOT_ALL_GRANTED = 110;
    public static final int CODE_FAILED_USER_TOKEN_INVALIDATE = 109;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_SUCCESS_ACCORDDING_APOLLO = 1;
    public static final int CODE_SUCCESS_NO_PHOTO = 2;
    public static final int CODE_SUCCESS_SERVER_ERROR = 3;
    public static final int COMPARE_FAILED_CAN_APPEAL = 1011;
    public static final int UNICODE_FAILED_ALPHA_SDK_ERROR = 118;
    private int code;
    public Map<String, Object> data;
    private String msg;
    private String sessionId;

    public DiFaceResult(int i) {
        this("", i, "");
    }

    public DiFaceResult(int i, String str) {
        this("", i, str);
    }

    public DiFaceResult(String str, int i) {
        this(str, i, "");
    }

    public DiFaceResult(String str, int i, String str2) {
        this.sessionId = TextUtils.isEmpty(str) ? DiFaceFacade.getInstance().getSessionId() : str;
        this.code = i;
        this.msg = TextUtils.isEmpty(str2) ? innerGetMsg(i) : str2;
        this.data = new HashMap();
    }

    public DiFaceResult(String str, int i, Map<String, Object> map) {
        this(str, i, "");
        this.data = map;
    }

    private String innerGetMsg(int i) {
        if (i == 100) {
            return ResUtils.getString(R.string.df_result_alpha_sdk_init_failed);
        }
        if (i == 102) {
            return ResUtils.getString(R.string.df_result_user_cancel);
        }
        if (i == 110) {
            return ResUtils.getString(R.string.df_result_permission_not_granted);
        }
        if (i == 112) {
            return ResUtils.getString(R.string.df_no_net_connected_toast);
        }
        if (i == 114) {
            return ResUtils.getString(R.string.df_result_appeal_underway_errors);
        }
        if (i != 118) {
            return ResUtils.getString(R.string.df_result_other_unknown_errors);
        }
        return ResUtils.getString(R.string.df_result_alpha_sdk_init_failed);
    }

    public boolean isSuccessful() {
        return this.code < 100;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
