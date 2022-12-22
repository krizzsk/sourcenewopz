package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CodeMtResponse extends BaseResponse {
    public int code_type;
    @SerializedName("data")
    public Pattern pattern;
    public String prompt;
    @SerializedName("support_voice")
    public boolean voiceSupport;

    public static class Pattern implements Serializable {
        @SerializedName("code_len")
        public int codeLen;
        @SerializedName("code_tag")
        public String codeTag;
    }
}
