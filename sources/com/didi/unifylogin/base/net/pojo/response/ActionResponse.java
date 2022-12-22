package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

public class ActionResponse extends BaseResponse {
    @SerializedName("action_after_login")
    public List<Action> actions;

    public static class Action implements Serializable {
        public int action;
        public List<Integer> composition;
        public JSONObject config;
        public boolean skip;
    }
}
