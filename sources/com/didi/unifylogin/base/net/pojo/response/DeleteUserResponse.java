package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class DeleteUserResponse extends BaseResponse implements Serializable {
    @SerializedName("delete_account_fail_texts")
    private List<DeleteContent> deleteAccountFailTexts;
    @SerializedName("sub_prompt_title")
    private String subPromptTitle;
    @SerializedName("sub_title")
    private String subTitle;

    public DeleteUserResponse setDeleteAccountFailTexts(List<DeleteContent> list) {
        this.deleteAccountFailTexts = list;
        return this;
    }

    public List<DeleteContent> getDeleteAccountFailTexts() {
        return this.deleteAccountFailTexts;
    }

    public String getSubPromptTitle() {
        return this.subPromptTitle;
    }

    public DeleteUserResponse setSubPromptTitle(String str) {
        this.subPromptTitle = str;
        return this;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public DeleteUserResponse setSubTitle(String str) {
        this.subTitle = str;
        return this;
    }

    public static class DeleteContent implements Serializable {
        public static int TYPE_ERROR = 1;
        public static int TYPE_NORMAL;
        private String des;
        private String tag;
        private int type;

        public int getType() {
            return this.type;
        }

        public String getTag() {
            return this.tag;
        }

        public String getDesc() {
            return this.des;
        }

        public DeleteContent setType(int i) {
            this.type = i;
            return this;
        }

        public DeleteContent setTag(String str) {
            this.tag = str;
            return this;
        }

        public DeleteContent setDes(String str) {
            this.des = str;
            return this;
        }
    }
}
