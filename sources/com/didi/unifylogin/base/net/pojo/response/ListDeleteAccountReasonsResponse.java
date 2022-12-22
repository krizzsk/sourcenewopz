package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ListDeleteAccountReasonsResponse extends BaseResponse implements Serializable {
    @SerializedName("delete_account_reasons")
    private List<String> deleteAccountReasons;
    @SerializedName("sub_prompt_title")
    private String subPromptTitle;
    @SerializedName("sub_title")
    private String subTitle;

    public List<String> getDeleteAccountReasons() {
        return this.deleteAccountReasons;
    }

    public ListDeleteAccountReasonsResponse setDeleteAccountReasons(List<String> list) {
        this.deleteAccountReasons = list;
        return this;
    }

    public String getSubPromptTitle() {
        return this.subPromptTitle;
    }

    public ListDeleteAccountReasonsResponse setSubPromptTitle(String str) {
        this.subPromptTitle = str;
        return this;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public ListDeleteAccountReasonsResponse setSubTitle(String str) {
        this.subTitle = str;
        return this;
    }
}
