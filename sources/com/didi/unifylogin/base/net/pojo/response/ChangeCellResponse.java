package com.didi.unifylogin.base.net.pojo.response;

import com.didi.unifylogin.base.net.pojo.entity.PromptPageData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ChangeCellResponse extends BaseResponse {
    public static final int ERRNO_NEED_FACE = 41030;
    public static final int ERR_CELL_CONFLICT = 41007;
    public static final int ERR_CELL_CONFLICT_PROMPT = 41023;
    public static final int ERR_CHANGE_CELL_NEED_DST_COMFIRM = 41018;
    public static final int ERR_CHANGE_CELL_NEED_SRC_COMFIRM = 41017;
    public static final int ERR_DRIVER_NOT_ACCESS = 62403;
    public static final int ERR_FACE_IDENTITY_FAILED = 41037;
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("biz_code")
    public int bizCode;
    @SerializedName("change_cell_by_id_card_dialog")
    public DialogData dialogData;
    public PromptPageData prompt;
    @SerializedName("session_id")
    public String sessionId;

    public class DialogData implements Serializable {
        public List<Operation> operations;
        public String text;
        public String title;

        public DialogData() {
        }
    }

    public class Operation implements Serializable {
        @SerializedName("btn_type")
        public int btnType;
        @SerializedName("show_type")
        public int showType;
        public String title;

        public Operation() {
        }
    }
}
