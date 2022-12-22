package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AuthListResponse extends BaseResponse {
    public List<Auth> data;

    public static class Auth implements Serializable {
        @SerializedName("auth_channel")
        private String authChannel;
        private int state;

        public Auth setAuthChannel(String str) {
            this.authChannel = str;
            return this;
        }

        public Auth setState(int i) {
            this.state = i;
            return this;
        }

        public String getAuthChannel() {
            return this.authChannel;
        }

        public int getState() {
            return this.state;
        }
    }
}
