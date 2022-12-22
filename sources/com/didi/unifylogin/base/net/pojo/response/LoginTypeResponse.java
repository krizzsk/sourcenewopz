package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LoginTypeResponse extends BaseResponse implements Serializable {
    @SerializedName("login_type_list")
    private List<String> loginTypeList;

    public List<String> getLoginTypeList() {
        return this.loginTypeList;
    }

    public void setLoginTypeList(List<String> list) {
        this.loginTypeList = list;
    }
}
