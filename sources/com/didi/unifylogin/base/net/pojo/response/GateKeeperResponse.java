package com.didi.unifylogin.base.net.pojo.response;

import com.didi.unifylogin.base.net.pojo.request.GateKeeperParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

public class GateKeeperResponse extends BaseResponse {
    public static final int CODE_LOGIN_TYPE = 1;
    public static final int FACE_CODE_LOGIN_TYPE = 8;
    public static final int FACE_LOGIN_TYPE = 4;
    public static final int PASSWORD_LOGIN_TYPE = 2;
    @SerializedName("action_after_login")
    public List<Action> actions;
    @SerializedName("close_voice")
    public int closeVoice;
    public String credential;
    public String email;
    @SerializedName("face_detection")
    public FaceDes faceDes;
    public List<Role> roles;
    @SerializedName("thirdparty_channels_available")
    public GateKeeperParam.ThirdPartyChannel thirdPartyChannelsAvailable;
    public int usertype;

    public static class Action implements Serializable {
        public int action;
        public List<Integer> composition;
        public JSONObject config;
        public boolean skip;
    }

    public static class FaceDes implements Serializable {
        public String text;
    }

    public static class Role implements Serializable {

        /* renamed from: id */
        public int f44704id;
        public int login_type;
        public String text;
    }
}
